package shiva.metamusic;

import org.jfugue.theory.Chord;

public class MMChord extends ElementWithDuration implements ICopiable, INotesElement {

	private Chord chord;

	public MMChord(MMDuration time, Chord chord, MMDuration duration) {
		super(time);
		this.chord = chord;
		this.duration = duration;
	}

	@Override
	public ICopiable copy() {
		MMChord newChord = new MMChord(time, chord, duration);
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

	

}
