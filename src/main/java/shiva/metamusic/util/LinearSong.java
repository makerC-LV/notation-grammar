package shiva.metamusic.util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.sound.midi.InvalidMidiDataException;

import shiva.metamusic.BeatChange;
import shiva.metamusic.DrumBeat;
import shiva.metamusic.IAssignable;
import shiva.metamusic.INotesElement;
import shiva.metamusic.IPlayable;
import shiva.metamusic.IRhythmElement;
import shiva.metamusic.ISongElement;
import shiva.metamusic.MMChord;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMDynamics;
import shiva.metamusic.MMNote;
import shiva.metamusic.MMRhythm;
import shiva.metamusic.Notes;
import shiva.metamusic.ParallelNotes;
import shiva.metamusic.PlayCommand;
import shiva.metamusic.Song;
import shiva.metamusic.TimeBookmark;
import shiva.metamusic.TimeRecall;
import shiva.metamusic.TimeSet;
import shiva.metamusic.Var;
import shiva.metamusic.VarDef;
import shiva.metamusic.Voice;

/**
 * This class holds timed notes in tracks in a fashion similar to a midi
 * sequence. It is an intermediate format between a structured song and a flat
 * sequence of events. This format is convenient to work with for processing (or
 * displaying) notes.
 */
public class LinearSong {

	private TrackManager noteTracks = new TrackManager(false);
	private TrackManager drumTracks = new TrackManager(true);
	
	private Voice currentVoice;
	
	private Song song;
	
	public LinearSong(Song song) throws InvalidMidiDataException {
		this.song = song;
		convertSong();
	}
	
	
	
	public TrackManager getNoteTracks() {
		return noteTracks;
	}



	public TrackManager getDrumTracks() {
		return drumTracks;
	}



	public Song getSong() {
		return song;
	}



	private MMTrack getCurrentTrack() {
		if (currentVoice == null || ! currentVoice.isPercussion()) {
			return noteTracks.getCurrentTrack();
		} else {
			return drumTracks.getCurrentTrack();
		}
	}
	
	private void convertSong() throws InvalidMidiDataException {
		ConversionState cs = new ConversionState();
		for (ISongElement se: song) {
			switch (se.getSongElementType()) {
			case VARDEF:
				VarDef vd = (VarDef) se;
				cs.varDefs.put(vd.getVarName(), vd);
				break;
			case PLAYCOMMAND: 
				for (IPlayable pl : (PlayCommand) se) {
					switch (pl.getPlayableType()) {
					case NOTES:
						processNotes((Notes) pl, cs);
						break;
					case RHYTHM:
						processRhythm((MMRhythm) pl, cs);
						break;
					case TIMEBOOKMARK:
						processBookmark((TimeBookmark) pl, cs);
						break;
					case TIMERECALL:
						processRecall((TimeRecall)pl, cs);
						break;
					case TIMESET:
						processTimeSet((TimeSet)pl, cs);
						break;
					case VAR:
						processVar((Var) pl, cs);
						break;
					default:
						throw new RuntimeException("Unknown type: " + pl.getPlayableType());
					}
				}
			}
		}
		
	}
	
	
	private void processVar(Var pl, ConversionState cs) throws InvalidMidiDataException {
		VarDef vd = cs.varDefs.get(pl.getVarName());
		if (vd == null) {
			throw new RuntimeException("Undefined variable: " + pl.getVarName());
		}
		IAssignable ass = vd.getValue();
		switch (ass.getType()) {
		case NOTES:
			processNotes((Notes) ass, cs);
			break;
		case RHYTHM:
			processRhythm((MMRhythm) ass, cs);
			break;
		case VOICE:
			processVoice((Voice) ass, pl.getVarName(), cs);
			break;
		default:
			throw new RuntimeException("Unknown type: " + ass.getType());
		
		}
		
	}

	private void processVoice(Voice voice, String voiceName, ConversionState cs) throws InvalidMidiDataException {
		if (voice.isPercussion()) {
			drumTracks.changeTrack( voiceName, voice.getInstrumentName());
		} else {
			noteTracks.changeTrack(voiceName, voice.getInstrumentName());
		}
		currentVoice = voice;
	}

	
	
	private void processTimeSet(TimeSet pl, ConversionState cs) {
		getCurrentTrack().setTime(pl.getTime());
	}

	private void processRecall(TimeRecall pl, ConversionState cs) {
//		VarDef vd = cs.varDefs.get(pl.getVarName());
		MMDuration vd = cs.timeBookmarks.get(pl.getVarName());
		if (vd == null) {
			throw new RuntimeException("Unknown variable: " + pl.getVarName());
		}
		getCurrentTrack().setTime(vd);
	}

	private void processBookmark(TimeBookmark pl, ConversionState cs) {
		cs.timeBookmarks.put(pl.getVarName(), getCurrentTrack().getCurrentTime());
	}

	private void processRhythm(MMRhythm pl, ConversionState cs) throws InvalidMidiDataException {
		for (int i = 0; i < pl.getReps(); i++) {
			for (IRhythmElement re : pl) {
				switch (re.getRhythmElementType()) {
				case BARMARKER:
					break;
				case BEATCHANGE:
					BeatChange bc = (BeatChange) re;
					drumTracks.getCurrentTrack().setDuration(bc.getDuration());
					break;
				case MINUS:
					drumTracks.getCurrentTrack().addBeat(false, ((DrumBeat)re).isAccented());
					
					break;
				case PLUS:
					drumTracks.getCurrentTrack().addBeat(true, ((DrumBeat)re).isAccented());
					break;
				case RHYTHM:
					processRhythm((MMRhythm) re, cs);
					break;
				case VAR:
					processVar((Var) re, cs);
					break;
				case DYNAMIC:
					MMDynamics mmd = (MMDynamics) re;
					drumTracks.getCurrentTrack().add(mmd);
					break;
				default:
					throw new RuntimeException("Unknown type: " + re.getRhythmElementType());

				}
			}
		}

	}
	

	private void processNotes(Notes pl, ConversionState cs) throws InvalidMidiDataException {
		for (int i = 0; i < pl.getReps(); i++) {
			for (INotesElement ne : pl) {
				switch (ne.getNotesElementType()) {
				case BARMARKER:
					break;
				case CHORD: 
					MMChord mmchord = (MMChord) ne;
					noteTracks.getCurrentTrack().add(mmchord);

					break;
				case NOTE: {
					MMNote mmnote = (MMNote) ne;
					noteTracks.getCurrentTrack().add(mmnote);
					
				}
				break;
				case NOTES:
					Notes notes = (Notes) ne;
					processNotes(notes, cs);
					break;
				case PARALLELNOTES:
					
					ParallelNotes pn = (ParallelNotes) ne;
					noteTracks.getCurrentTrack().add(pn);
					break;
				case VAR:
					Var v = (Var) ne;
					processVar(v, cs);
					break;
				case DYNAMIC:
					MMDynamics mmd = (MMDynamics) ne;
					noteTracks.getCurrentTrack().add(mmd);
					break;
				default:
					throw new RuntimeException("Unknown type: " + ne.getNotesElementType());
				
				}
			}
		}
		
	}
	
	
	private class ConversionState {
		
		Map<String, MMDuration> timeBookmarks = new LinkedHashMap<>();
		Map<String, VarDef> varDefs = new LinkedHashMap<>();
		
		
	}
}
