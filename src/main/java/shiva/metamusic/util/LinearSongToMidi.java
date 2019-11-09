package shiva.metamusic.util;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

import shiva.metamusic.ElementWithDuration;
import shiva.metamusic.INotesElement;
import shiva.metamusic.MMChord;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMDynamics;
import shiva.metamusic.MMNote;
import shiva.metamusic.MMTempo;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.ParallelNotes;
import shiva.metamusic.Song;

public class LinearSongToMidi {

	public static Sequence getSequence(LinearSong lsong) throws InvalidMidiDataException {
		Song song = lsong.getSong();
		int bpm = song.getTempo().getBpm();
		TickCalculator tc = new TickCalculator(MidiUtils.DEFAULT_PPQ, song.getTimeSig(), song.getTempo());

		Sequence seq = new Sequence(Sequence.PPQ, MidiUtils.DEFAULT_PPQ);

		TrackManager noteTracks = lsong.getNoteTracks();
		for (String name : noteTracks.getTrackNames()) {
			MMTrack mmtrack = noteTracks.getTrackByName(name);
			Track track = seq.createTrack();
			track.add(MidiUtils.createTempoEvent(bpm));
			track.add(MidiUtils.createProgramChange(mmtrack.getMidiInstrument(), 0, mmtrack.getMidiChannel()));

			long finishTime = fillNotes(track, mmtrack, bpm, song, tc);
			MidiUtils.finishTrack(track, finishTime + 10);
		}
		TrackManager rtrack = lsong.getDrumTracks();
		int numRhythmVoices = rtrack.getTrackNames().size();
		if (numRhythmVoices > 0) {
			Track track = seq.createTrack();
			long maxTrackTime = 0;
			for (String name : rtrack.getTrackNames()) {
				MMTrack mmtrack = rtrack.getTrackByName(name);
				track.add(MidiUtils.createTempoEvent(bpm));
				long finishTime = fillNotes(track, mmtrack, bpm, song, tc);
				if (maxTrackTime < finishTime) {
					maxTrackTime = finishTime;
				}
			}
			MidiUtils.finishTrack(track, maxTrackTime + 10);
		}
		return seq;

	}

	/** Returns the last time of an event in the track. */
	private static long fillNotes(Track track, MMTrack mmtrack, int bpm, Song song, TickCalculator tc) throws InvalidMidiDataException {
		
		long maxTime = 0;
		
		int currentVelocity = MidiUtils.DEFAULT_DYNAMICS.getMidiValue();
		
		for (ElementWithDuration ti: mmtrack.getItems()) {
			
			long startTick = tc.toTicks(ti.getTime());
			long durationTicks = tc.toTicks(ti.getDuration());
			if (maxTime < startTick + durationTicks) {
				maxTime = startTick + durationTicks;
			}
			int velocityIncrement = 0;
			switch (((INotesElement) ti).getNotesElementType()) {
			
			case CHORD: {
				MMChord mmchord = (MMChord) ti;
				
				velocityIncrement = mmchord.getAccent() * MidiUtils.ACCENT_INCREMENT;
				
				Chord chord = mmchord.getJFugueChord();
				for (Note n : chord.getNotes()) {
					MMNote mmn = new MMNote(mmchord.getTime(), n, mmchord.getDuration(), null);
					MidiUtils.addNote(track, song, startTick, durationTicks, mmn, mmtrack.getMidiChannel(), 
							Math.min((currentVelocity + velocityIncrement), 127));
				}
				break;
			}
			case NOTE: {
				MMNote mmnote = (MMNote) ti;
				velocityIncrement = mmnote.getAccent() * MidiUtils.ACCENT_INCREMENT;
				
				MidiUtils.addNote(track, song, startTick, durationTicks, mmnote, mmtrack.getMidiChannel(), 
						Math.min((currentVelocity + velocityIncrement), 127));
				break;
			}
			case PARALLELNOTES: {
				ParallelNotes pnotes = (ParallelNotes) ti;
				for (MMNote note: pnotes.getNotes()) {
					int inc = 0;
					inc = note.getAccent() * MidiUtils.ACCENT_INCREMENT;
					MidiUtils.addNote(track, song, startTick, durationTicks, note, mmtrack.getMidiChannel(), 
							Math.min((currentVelocity + inc), 127));
				}
				break;
			}
			case DYNAMIC: 
				currentVelocity = ((MMDynamics)ti).getMidiValue();
				break;
			
			default:
				throw new LocatableException(ti.getLocation(), "Unimplemented type : " + ((INotesElement) ti).getNotesElementType());
			
			}
		}
		
		return maxTime;
	}

	
}
