package shiva.metamusic.util;

import java.util.function.Function;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.theory.Note;

import shiva.metamusic.Dynamics;
import shiva.metamusic.MMNote;
import shiva.metamusic.Song;

public class MidiUtils {

	private static boolean DEBUG = false;
	
	public static final int DEFAULT_PPQ = 960;
	public static final String DEFAULT_PERCUSSION_NAME = "CLOSED_HI_HAT";
	public static final int DEFAULT_PERCUSSION_NOTE = 42; // closed hi-hat
	public static final int PERCUSSION_CHANNEL = 9;
	public static final int DEFAULT_INSTRUMENT = 0;  //Piano
	public static final String DEFAULT_INSTRUMENT_NAME = "PIANO";
//	public static final int DEFAULT_VELOCITY = 64;

	public static final Dynamics DEFAULT_DYNAMICS = Dynamics.mp;
	public static final int ACCENT_INCREMENT = 16;

	public static final int CHANNEL_VOLUME_CONTROLLER = 7;
	
	public static final int instrumentToMidiNum(String instrument) {
		return MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get(instrument.toUpperCase());
	}
	
	public static final String midiNumToInstrument(int num) {
		return MidiDictionary.INSTRUMENT_BYTE_TO_STRING.get((byte) num);
	}
	
	public static final int percussionToMidiNote(String instrument) {
		for (int i = 0; i < Note.PERCUSSION_NAMES.length; i++) {
			if (Note.PERCUSSION_NAMES[i].equals(instrument.toUpperCase())) {
				return 35 + i;
			}
		}
		return -1;
	}
	
	public static final String midiNoteToPercussion(int note) {
		return Note.PERCUSSION_NAMES[note - 35];
	}
	
	public static void addNote(Track track, int midiNum, long durationTicks, long startTick, int midiChannel, int velocity) throws InvalidMidiDataException {
		track.add(createNoteOn(midiNum, startTick, midiChannel, velocity));
		track.add(createNoteOff(midiNum, startTick + durationTicks, midiChannel, velocity));
		
	}
	
	public static void addNote(Track track,  Song song, long startTick, long durationTicks, MMNote mmnote, int midiChannel, int velocity)
			throws InvalidMidiDataException {
		if (! mmnote.getJFugueNote().isRest()) {
			int midiNum = MMNote.calculateMidiNum(mmnote, song.getKeySig());
			track.add(createNoteOn(midiNum, startTick, midiChannel, velocity));
			
//			setPitchBends(track, midiChannel, startTick, durationTicks, 1.0, 256);
			track.add(createNoteOff(midiNum, startTick + durationTicks, midiChannel, velocity));
		}
	}

	

	public static MidiEvent createNoteOn(int noteNum, long tick, int channel, int velocity)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		myMsg.setMessage(ShortMessage.NOTE_ON,  channel, noteNum, velocity);
		debug("Note on " + noteNum + "  tick=" + tick + " channel=" + channel + "velocity=" + velocity);
		return new MidiEvent(myMsg, tick);
	}

	public static MidiEvent createNoteOff(int noteNum, long tick, int channel, int velocity)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		myMsg.setMessage(ShortMessage.NOTE_OFF, channel, noteNum, velocity);
		debug("Note off " + noteNum + "  tick=" + tick  + " channel=" + channel + "velocity=" + velocity);
		return new MidiEvent(myMsg, tick);
	}
	
	public static MidiEvent createPitchBend(long tick, int channel, double numSemitones)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		int[] data = convertPitchBendValue(numSemitones);
		myMsg.setMessage(ShortMessage.PITCH_BEND, channel, data[0], data[1]);
		debug("Pitch bend " + "  tick=" + tick  + " channel=" + channel +  " data1=" + data[0] + " data2=" + data[1]);
		return new MidiEvent(myMsg, tick);
	}
	
	public static MidiEvent createChannelVelocity(long tick, int channel, int velocity)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		myMsg.setMessage(ShortMessage.CONTROL_CHANGE, channel, 7, velocity); // 7 is channel velocity
		debug("Channel velocity " + "  tick=" + tick  + " channel=" + channel +  " data1=" + 7 + " data2=" + velocity);
		return new MidiEvent(myMsg, tick);
	}
	
	
	/** numSemitones is a value between -2 and 2 */
	private static int[] convertPitchBendValue(double numSemitones) {
		int twoSemitones = 8191; // see Pict behd spec
		int delta = (int) (twoSemitones * numSemitones / 2); 
		
		int val = 8192 + delta;
		System.out.println(val);
		int[] data = new int[2];
		data[1] = (byte) (val & 0x07F);
		data[0] = (byte) ((val >> 7) & 0x07F);
		return data;
	}

	public static MidiEvent createProgramChange(int instrument, long tick, int channel)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		myMsg.setMessage(ShortMessage.PROGRAM_CHANGE, channel, instrument, 0);
		return new MidiEvent(myMsg, tick);
	}
	
	public static MidiEvent createTempoEvent(int bpm)
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
	
	/** Adds an End-of-track message 
	 * @throws InvalidMidiDataException */
	public static void finishTrack(Track track, long finishTime) throws InvalidMidiDataException {
		MetaMessage message = new MetaMessage();
		message.setMessage(0x2F, null, 0);
		track.add(new MidiEvent(message, finishTime));
		
	}
	
	private static void debug(String s) {
		if (DEBUG) {
			System.out.println(s);
		}
	}

	
	private static void setPitchBends(Track track, int midiChannel, long startTick, long tspan, double bend, int resolution)
			throws InvalidMidiDataException {
		PBCurve pbc = new PBCurve(tspan, bend);
		for (int i = 0; i < resolution; i++) {
			long t = i * tspan/resolution;
			double b = pbc.apply(t);
			track.add(createPitchBend(startTick + t, midiChannel, b));
		}
		track.add(createPitchBend(startTick + tspan, midiChannel, 0));
	}
	
	private static class PBCurve implements Function<Long, Double> {

		long tspan;
		double yspan;
		
		public PBCurve(long tspan, double yspan) {
			super();
			this.tspan = tspan;
			this.yspan = yspan;
		}

		@Override
		public Double apply(Long t) {
			double normT = ((double) t)/tspan;
//			double normY = normT * normT * normT * normT;
//			return yspan * normY;
			return PitchBendUtils.peaked(0, 0.25, 1, normT);
		}
		
	}
}
