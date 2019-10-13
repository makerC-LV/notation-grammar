package shiva.metamusic.util;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.theory.Note;

import shiva.metamusic.MMNote;
import shiva.metamusic.Song;

public class MidiUtils {

	private static boolean DEBUG = false;
	
	public static final int DEFAULT_PPQ = 480;
	public static final String DEFAULT_PERCUSSION_NAME = "CLOSED_HI_HAT";
	public static final int DEFAULT_PERCUSSION_NOTE = 42; // closed hi-hat
	public static final int PERCUSSION_CHANNEL = 9;
	public static final int DEFAULT_INSTRUMENT = 0;  //Piano
	public static final String DEFAULT_INSTRUMENT_NAME = "PIANO";
	public static final int DEFAULT_VELOCITY = 64;
	
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
	
	public static void addNote(Track track, int midiNum, long durationTicks, long startTick, int midiChannel) throws InvalidMidiDataException {
		track.add(createNoteOn(midiNum, startTick, midiChannel));
		track.add(createNoteOff(midiNum, startTick + durationTicks, midiChannel));
		
	}
	
	public static void addNote(Track track,  Song song, long startTick, long durationTicks, MMNote mmnote, int midiChannel)
			throws InvalidMidiDataException {
		if (! mmnote.getJFugueNote().isRest()) {
			int midiNum = MMNote.calculateMidiNum(mmnote, song.getKeySig());
			track.add(createNoteOn(midiNum, startTick, midiChannel));
			track.add(createNoteOff(midiNum, startTick + durationTicks, midiChannel));
		}
	}

	public static MidiEvent createNoteOn(int noteNum, long tick, int channel)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		// (velocity = 93)on channel 0 (zero-based).
		myMsg.setMessage(ShortMessage.NOTE_ON,  channel, noteNum, 93);
		debug("Note on " + noteNum + "  tick=" + tick + " channel=" + channel);
		return new MidiEvent(myMsg, tick);
	}

	public static MidiEvent createNoteOff(int noteNum, long tick, int channel)
			throws InvalidMidiDataException {
		ShortMessage myMsg = new ShortMessage();
		// Play the note Middle C (60) moderately loud
		// (velocity = 93)on channel 0 (zero-based).
		myMsg.setMessage(ShortMessage.NOTE_OFF, channel, noteNum, 93);
		debug("Note off " + noteNum + "  tick=" + tick  + " channel=" + channel);
		return new MidiEvent(myMsg, tick);
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

	
}
