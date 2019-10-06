package shiva.metamusic;

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
	
	public static Sequence createSequence(MMSong song) throws InvalidMidiDataException {
		
		Sequence seq = new Sequence(Sequence.PPQ, DEFAULT_PPQ);
		
		int bpm = song.getTempo().getBpm();
		TickCalculator tc = new TickCalculator(DEFAULT_PPQ, song.getTimeSig(), song.getTempo());
		
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
	}
	
	private static void fillTrack(Track track, MMTrack mmtrack, int bpm, MMSong song, TickCalculator tc) throws InvalidMidiDataException {
		for (MMTrackItem ti: mmtrack.getItems()) {
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
				MMParallelNotes pnotes = (MMParallelNotes) ti;
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

	private static void addNote(Track track, MMTrack mmtrack, MMSong song, long startTick, long durationTicks, MMNote mmnote)
			throws InvalidMidiDataException {
		if (! mmnote.getJFugueNote().isRest()) {
			int midiNum = MMNote.calculateMidiNum(mmnote, song.getKeySig());
			int channel = mmtrack.getMidiChannel();
			track.add(createNoteOn(midiNum, startTick, channel));
			track.add(createNoteOff(midiNum, startTick + durationTicks, channel));
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
		MMTimeSig timeSig;
		MMTempo tempo;
		
		long ticksPerPulse;
		
		public TickCalculator(int ppq, MMTimeSig timeSig, MMTempo tempo) {
			super();
			int ppb = timeSig.getPulsesForBeat();
			int bpm = tempo.getBpm();
			long pulsesPerMin = ppb * bpm;
			long ticksPerMin = ppq * bpm;
			ticksPerPulse = ppq/ppb;
			
		}
		
		long toTick(MMDuration duration) {
			return ticksPerPulse * duration.getPulses();
		}
		
	}
}
