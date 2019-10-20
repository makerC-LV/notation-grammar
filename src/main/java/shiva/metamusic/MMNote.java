package shiva.metamusic;

import org.jfugue.theory.Note;

import shiva.metamusic.util.MidiUtils;
import shiva.music.theory.AdjustNoteForScale;

public class MMNote extends ElementWithDuration implements ICopiable, INotesElement {

	public static final int DEFAULT_OCTAVE = 5;
	Note note;
	int midiVelocity;
	boolean accented;
	
	
	public MMNote(MMDuration time) {
		this(time, Note.REST, MMDuration.QUARTER);
	}

	public MMNote(Note note) {
		this(MMDuration.ZERO, note, MMDuration.QUARTER);
	}
	
	public MMNote(MMDuration time, Note note, MMDuration duration) {
		super(time);
		this.note = note;
		this.midiVelocity = MidiUtils.DEFAULT_DYNAMICS.getMidiValue();
		this.duration = duration;
	}
	
	
	public boolean isAccented() {
		return accented;
	}

	@Override
	public ICopiable copy() {
		MMNote n = new MMNote(new MMDuration(time.getPulses()), new Note(note), new MMDuration(duration.getPulses()));
		n.midiVelocity = midiVelocity;
		n.accented = accented;
		return n;
	}
	
	public void accent(boolean b) {
		accented = b;
		
	}
	
	public static String midiNumToString(int midiNum) {
		int octave = midiNum/12;
		int offset = midiNum % 12;
		return notes[offset] + octave;
	}

	public Note getJFugueNote() {
		return note;
	}

	public static int calculateMidiNum(MMNote mmnote, MMKeySig keySig) {
		int delta =  AdjustNoteForScale.adjustNoteForKeySignature(mmnote, keySig);
		return mmnote.getJFugueNote().getValue() + delta;
	}

	@Override
	public Type getNotesElementType() {
		return Type.NOTE;
	}

	@Override
	public String toSong4() {
		return note.toString() + " ";
	}

	private static String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "B#"};
	

	public static int stringToMidiNum(String base, String accidental, String octave) {
		if (octave == null) {
			octave = "" + DEFAULT_OCTAVE;
		}
		int offset = 0;
		if (accidental != null) {
			if (accidental.equals("#")) {
				offset = 1;
			} else if (accidental.equals("-")) {
				offset = -1;
			}
		}
		int noteOffset = 0;
		switch (base.toUpperCase()) {
		case "C":
			break;
		case "D":
			noteOffset = 2;
			break;
		case "E":
			noteOffset = 4;
			break;
		case "F":
			noteOffset = 5;
			break;
		case "G":
			noteOffset = 7;
			break;
		case "A":
			noteOffset = 9;
			break;
		case "B":
			noteOffset = 11;
			break;
		case "R":
			return -1;
		default : throw new RuntimeException("Unknown note: " + base);
		};
		return noteOffset + offset + 12 * Integer.parseInt(octave);
	}

	public static MMNote defaultNote(Note n) {
		return new MMNote(MMDuration.ZERO, n, MMDuration.QUARTER);
	}

	
		
}
