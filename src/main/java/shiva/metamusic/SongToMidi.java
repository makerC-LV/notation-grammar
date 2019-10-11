package shiva.metamusic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;


public class SongToMidi {

	private static final int DEFAULT_PPQ = 480;
	
	public static Sequence createSequence(Song song) throws InvalidMidiDataException {
		
		int bpm = song.getTempo().getBpm();
		TickCalculator tc = new TickCalculator(DEFAULT_PPQ, song.getTimeSig(), song.getTempo());
		ConversionState cs = new ConversionState(bpm, tc);
		cs.song = song;
		cs.seq = new Sequence(Sequence.PPQ, DEFAULT_PPQ);
		
		
		
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
		
		cs.rhythmToTrack();
		
		return cs.seq;
/*		
		for (String name : song.getTrackNames()) {
			MMTrack mmtrack = song.getTrack(name);
			Track track = seq.createTrack();
			track.add(createTempoEvent(bpm));
			if (!mmtrack.isPercussionTrack()) {
				track.add(createProgramChange(mmtrack.getMidiInstrument(), 0, mmtrack.getMidiChannel()));
			}
			
			fillTrack(track, mmtrack, bpm, song, tc);
		}
		MMRhythmTrack rtrack = song.getPercussionTrack();
		int numRhythmVoices = rtrack.getTracks().size();
		if (numRhythmVoices > 0) {
			Track track = seq.createTrack();
			for (MMTrack mmtrack: rtrack.getTracks()) {
				track.add(createTempoEvent(bpm));
				fillTrack(track, mmtrack, bpm, song, tc);
			}
		}
		return seq;
		*/
	}
	
	private static void processVar(Var pl, ConversionState cs) throws InvalidMidiDataException {
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
			break;
		
		}
		
	}

	private static void processVoice(Voice voice, String voiceName, ConversionState cs) throws InvalidMidiDataException {
		if (voice.isPercussion()) {
			cs.rhythmTrack.changeDrum(voice.getPercussionNote());
		} else {
			cs.currentTrack = cs.getTrackByName(voiceName, voice.getMidiProgramChange());
		}
		
	}

	private static void processTimeSet(TimeSet pl, ConversionState cs) {
		cs.currentTrack.currentTime = cs.tc.toTick(pl.getTime());
	}

	private static void processRecall(TimeRecall pl, ConversionState cs) {
		VarDef vd = cs.varDefs.get(pl.getVarName());
		if (vd == null) {
			throw new RuntimeException("Unknown variable: " + pl.getVarName());
		}
		
	}

	private static void processBookmark(TimeBookmark pl, ConversionState cs) {
		cs.timeBookmarks.put(pl.getVarName(), cs.currentTrack.currentTime);
	}

	private static void processRhythm(MMRhythm pl, ConversionState cs) throws InvalidMidiDataException {
		for (int i = 0; i < pl.getReps(); i++) {
			for (IRhythmElement re : pl) {
				switch (re.getRhythmElementType()) {
				case BARMARKER:
					break;
				case BEATCHANGE:
					BeatChange bc = (BeatChange) re;
					cs.rhythmTrack.changeDuration(cs.tc.toTick(bc.getDuration()));
					break;
				case MINUS:
					cs.rhythmTrack.addRest();
					
					break;
				case PLUS:
					cs.rhythmTrack.addBeat();
					break;
				case RHYTHM:
					processRhythm((MMRhythm) re, cs);
					break;
				case VAR:
					processVar((Var) re, cs);
					break;

				default:
					break;

				}
			}
		}

	}
	

	private static void processNotes(Notes pl, ConversionState cs) throws InvalidMidiDataException {
		for (int i = 0; i < pl.getReps(); i++) {
			for (INotesElement ne : pl) {
				switch (ne.getNotesElementType()) {
				case BARMARKER:
					break;
				case CHORD: 
					MMChord mmchord = (MMChord) ne;
					cs.getCurrentTrack().add(mmchord, cs.tc);

					break;
				case NOTE: {
					MMNote mmnote = (MMNote) ne;
					cs.getCurrentTrack().add(mmnote, cs.song, cs.tc);
					
				}
				break;
				case NOTES:
					Notes notes = (Notes) ne;
					processNotes(notes, cs);
					break;
				case PARALLELNOTES:
					
					ParallelNotes pn = (ParallelNotes) ne;
					cs.getCurrentTrack().add(pn, cs.song, cs.tc);
					break;
				case VAR:
					Var v = (Var) ne;
					processVar(v, cs);
					break;
				
				default:
					break;
				
				}
			}
		}
		
	}

	/*
	private static void fillTrack(Track track, MMTrack mmtrack, int bpm, MMSong song, TickCalculator tc) throws InvalidMidiDataException {
		for (ElementWithDuration ti: mmtrack.getItems()) {
			long startTick = tc.toTick(ti.getTime());
			long durationTicks = tc.toTick(ti.getDuration());
			
			switch (ti.getType()) {
			case CHORD:
				MMChord mmchord = (MMChord) ti;
				Chord chord = mmchord.getJFugueChord();
				for (Note n : chord.getNotes()) {
					MMNote mmn = new MMNote(mmchord.getTime(), n, mmchord.getDuration());
					addNote(track, mmtrack, song, startTick, durationTicks, mmn);
				}
				break;
			case NOTE:
				MMNote mmnote = (MMNote) ti;
				addNote(track, mmtrack, song, startTick, durationTicks, mmnote);
				break;
			case PARALLELNOTES:
				ParallelNotes pnotes = (ParallelNotes) ti;
				for (MMNote note: pnotes.getNotes()) {
					addNote(track, mmtrack, song, startTick, durationTicks, note);
				}
				break;
			
			case VELOCITY:
				break;
			default:
				throw new RuntimeException("Unimplemented type : " + ti.getType());
			
			}
		}
		
	}
	*/
	
	private static void addNote(Track track, int midiNum, long durationTicks, long startTick, int midiChannel) throws InvalidMidiDataException {
		track.add(createNoteOn(midiNum, startTick, midiChannel));
		track.add(createNoteOff(midiNum, startTick + durationTicks, midiChannel));
		
	}

	private static void addNoteToTrack(Track track,  Song song, long startTick, long durationTicks, MMNote mmnote, int midiChannel)
			throws InvalidMidiDataException {
		if (! mmnote.getJFugueNote().isRest()) {
			int midiNum = MMNote.calculateMidiNum(mmnote, song.getKeySig());
			track.add(createNoteOn(midiNum, startTick, midiChannel));
			track.add(createNoteOff(midiNum, startTick + durationTicks, midiChannel));
		}
	}

	private static MidiEvent createNoteOn(int noteNum, long tick, int channel)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		// (velocity = 93)on channel 0 (zero-based).
		myMsg.setMessage(ShortMessage.NOTE_ON,  channel, noteNum, 93);
		System.out.println("Note on " + noteNum + "  tick=" + tick + " channel=" + channel);
		return new MidiEvent(myMsg, tick);
	}

	private static MidiEvent createNoteOff(int noteNum, long tick, int channel)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		// Play the note Middle C (60) moderately loud
		// (velocity = 93)on channel 0 (zero-based).
		myMsg.setMessage(ShortMessage.NOTE_OFF, channel, noteNum, 93);
		System.out.println("Note off " + noteNum + "  tick=" + tick  + " channel=" + channel);
		return new MidiEvent(myMsg, tick);
	}
	
	private static MidiEvent createProgramChange(int instrument, long tick, int channel)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		myMsg.setMessage(ShortMessage.PROGRAM_CHANGE, channel, instrument, 0);
		return new MidiEvent(myMsg, tick);
	}
	
	private static MidiEvent createTempoEvent(int bpm)
			throws InvalidMidiDataException {
		MetaMessage msg = new MetaMessage();
		byte[] data = new byte[3];
		long mspq = 60000000L / bpm;
		data[2] = (byte) (mspq & 0x0FF);
		data[1] = (byte) ((mspq & 0x0FF00) >> 8);
		data[0] = (byte) ((mspq & 0x0FF0000) >> 16);
		msg.setMessage(0x51, data, 3);

		return new MidiEvent(msg, 0);
	}
	
	public static void playUsingJava(Sequence seq)
			throws MidiUnavailableException, InvalidMidiDataException {
		Sequencer sqr = MidiSystem.getSequencer();
		sqr.open();
		sqr.setSequence(seq);
		sqr.start();
		// busy-wait until the sequencer stops playing - ugly, but couldn't find
		// a better way to do it
		while (sqr.isRunning()) {
			Thread.yield();
		}

		// when done playing, close the sequencer
		sqr.close();
	}
	
	private static class TickCalculator {
		
		long ticksPerPulse;
		
		public TickCalculator(int ppq, MMTimeSig timeSig, MMTempo tempo) {
			super();
			int ppb = timeSig.getPulsesForBeat();
//			int bpm = tempo.getBpm();
//			long pulsesPerMin = ppb * bpm;
//			long ticksPerMin = ppq * bpm;
			ticksPerPulse = ppq/ppb;
			
		}
		
		long toTick(MMDuration duration) {
			return ticksPerPulse * duration.getPulses();
		}
		
	}
	
	private static class ConversionState {
		
		public Song song;
		static List<Integer> channels = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15));
		Sequence seq;
		
		Map<String, VarDef> varDefs = new HashMap<>();
		Map<String, TrackState> tracksByName = new HashMap<>();
		Map<String, Long> timeBookmarks = new HashMap<>();
		
		RhythmTrack rhythmTrack = new RhythmTrack();
		TrackState currentTrack;
		
		TickCalculator tc;
		int bpm;
		
		ConversionState(int bpm, TickCalculator tc) {
			this.bpm = bpm;
			this.tc = tc;
		}

		public void rhythmToTrack() throws InvalidMidiDataException {
			if (rhythmTrack.tracksByNote.size() == 0) {
				return;
			}
			Track track = seq.createTrack();
			track.add(createTempoEvent(bpm));
			for (RhythmTrackState rt : rhythmTrack.tracksByNote.values() ) {
				for (MidiEvent ev : rt.events) {
					track.add(ev);
				}
			}
			
		}

		public TrackState getCurrentTrack() throws InvalidMidiDataException {
			if (currentTrack == null) {
				currentTrack = getTrackByName("DEFAULT", 0);
			}
			return currentTrack;
		}

		

		public TrackState getTrackByName(String voiceName, int midiProgramChange) throws InvalidMidiDataException {
			TrackState tr = tracksByName.get(voiceName);
			if (tr == null) {
				tr = new TrackState(seq.createTrack());
				tr.track.add(createTempoEvent(bpm));
				tr.track.add(createProgramChange(midiProgramChange, 0, tr.trackChannel));
				tr.trackChannel = channels.remove(0);
				
				tracksByName.put(voiceName, tr);
			}
			return tr;
		}
	}
	
	private static class TrackState {
		
		 
		Track track;
		long currentTime = 0;
		int trackChannel;
		
		
		public TrackState(Track track) {
			this.track = track;
		}


		public void add(ParallelNotes pn, Song song, TickCalculator tc) throws InvalidMidiDataException {
			long duration = tc.toTick(pn.getDuration());
			for (MMNote mmnote : pn.getNotes()) {
				addNoteToTrack(track, song, currentTime, duration, mmnote, trackChannel);
				
			}
			currentTime += duration;
			
		}


		public void add(MMNote mmnote, Song song, TickCalculator tc) throws InvalidMidiDataException {
			long duration = tc.toTick(mmnote.getDuration());
			addNoteToTrack(track, song, currentTime, duration, mmnote, trackChannel);
			currentTime += duration;
			
		}


		public void add(MMChord mmchord, TickCalculator tc) throws InvalidMidiDataException {
			Chord chord = mmchord.getJFugueChord();
			long duration = tc.toTick(mmchord.getDuration());
			

			for (Note n : chord.getNotes()) {
				MMNote mmn = new MMNote(mmchord.getTime(), n, mmchord.getDuration());
				addNote(track, mmn.getJFugueNote().getValue(), duration, currentTime, trackChannel);

			}
			currentTime += duration;
			
		}
		
	}
	
	private static class RhythmTrack {
		long currentBeatDuration = 16; // Default sixteenth
		Map<Integer, RhythmTrackState> tracksByNote = new LinkedHashMap<>();
		RhythmTrackState currentTrack;
		
		void addBeat() throws InvalidMidiDataException {
			if (currentTrack == null) {
				changeDrum(Voice.DEFAULT_PERCUSSION_NOTE);
			}
			currentTrack.addBeat(currentBeatDuration);
		}
		void addRest() throws InvalidMidiDataException {
			if (currentTrack == null) {
				changeDrum(Voice.DEFAULT_PERCUSSION_NOTE);
			}
			currentTrack.addRest(currentBeatDuration);
		}
		
		void changeDuration(long duration) {
			currentBeatDuration = duration;
		}
		
		void changeDrum(int midiNote) {
			RhythmTrackState rts = tracksByNote.get(midiNote);
			if (rts == null) {
				rts = new RhythmTrackState(midiNote);
				tracksByNote.put(midiNote, rts);
			}
			currentTrack = rts;
		}
		
	}
	
	private static class RhythmTrackState {
		
		List<MidiEvent> events = new ArrayList();
		long currentTime = 0;
		int midiNote;
		
		
		public RhythmTrackState(int midiNote) {
			super();
			this.midiNote = midiNote;
		}
		void addBeat(long duration) throws InvalidMidiDataException {
			events.add(createNoteOn(midiNote, currentTime, 9));
			events.add(createNoteOff(midiNote, currentTime + duration, 9));

			currentTime += duration;
			
		}
		void addRest(long duration) {
			currentTime += duration;
			
		}
		
	}
}
