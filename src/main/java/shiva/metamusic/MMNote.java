package shiva.metamusic;

import org.jfugue.theory.Note;

public class MMNote extends ElementWithDuration implements ICopiable, INotesElement {

	public static final int DEFAULT_OCTAVE = 5;
	
	Note note;
	int midiVelocity;
	
	
	public MMNote(MMDuration time) {
		this(time, Note.REST, MMDuration.QUARTER);
	}

	public MMNote(MMDuration time, Note note, MMDuration duration) {
		super(time);
		this.note = note;
		this.midiVelocity = 64;
		this.duration = duration;
	}
	
	@Override
	public ICopiable copy() {
		return new MMNote(time, note, duration);
	}
	
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

	private static String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "B#"};
	
	public static String midiNumToString(int midiNum) {
		int octave = midiNum/12;
		int offset = midiNum % 12;
		return notes[offset] + octave;
	}

	public Note getJFugueNote() {
		return note;
	}

	public static int calculateMidiNum(MMNote mmnote, MMKeySig keySig) {
		return MMNoteAdjuster.getMidiNote(mmnote, keySig);
	}

	@Override
	public Type getNotesElementType() {
		return Type.NOTE;
	}

	@Override
	public String toSong4() {
		return note.toString() + " ";
	}

	

		
}
