package shiva.metamusic;

import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

public class MMChord extends ElementWithDuration implements ICopiable, INotesElement {

	private Chord chord;
	private int accent;  // can be + or -

	public MMChord(Chord chord, Location location) {
		this(MMDuration.ZERO, chord, MMDuration.QUARTER, location);
	}
			
	public MMChord(MMDuration time, Chord chord, MMDuration duration, Location location) {
		super(time, location);
		this.chord = chord;
		this.duration = duration;
	}

	public void accent(int b) {
		accent = b;
		
	}
	
	
	public int getAccent() {
		return accent;
	}

	@Override
	public ICopiable copy() {
		MMChord newChord = new MMChord(time, chord, duration, getLocation());
		newChord.accent = accent;
		return newChord;
	}

	public Chord getJFugueChord() {
		return chord;
	}

	@Override
	public Type getNotesElementType() {
		return Type.CHORD;
	}

	@Override
	public String toSong4() {
		return chord.toString();
	}

	public boolean containsNote(int midiNum) {
		int noteIndex = getNoteIndexInternal(midiNum);
		return noteIndex >= 0;
	}

	public MMChord transposeToInclude(int midiNum) {
		int noteIndex = getNoteIndexInternal(midiNum);
		if (noteIndex < 0) {
			return null;
		}
		Note[] notes = chord.getNotes();
		Note n = notes[noteIndex];
		int offset = midiNum - n.getValue();
		
		Note[] transposed = new Note[notes.length];
		for (int i = 0; i < notes.length; i++) {
			transposed[i] = new Note(notes[i].getValue() + offset);
		}
		Chord transposedChord = Chord.fromNotes(transposed);
		return new MMChord(new MMDuration(time.getPulses()), transposedChord, 
				new MMDuration(duration.getPulses()), getLocation());
	}
	
	public MMNote getTonicNote() {
		return new MMNote(chord.getNotes()[0], null);
		
	}
	
	private int getNoteIndexInternal(int midiNum) {
		int index = 0;
		for (Note n: chord.getNotes()) {
			int diff = Math.abs(n.getValue() - midiNum);
			if (diff%12 == 0) {
				return index;
			}
			index++;
		}
		return -1;
	}

	

	

}
