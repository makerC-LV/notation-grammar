package shiva.metamusic;

import org.jfugue.theory.Chord;

public class MMChord extends MMTrackItem  {

	private Chord chord;

	public MMChord(MMDuration time, Chord chord, MMDuration duration) {
		super(MMItemType.CHORD, time);
		this.chord = chord;
		this.duration = duration;
	}

	@Override
	public MMTrackItem copy() {
		MMChord newChord = new MMChord(time, chord, duration);
		return newChord;
	}

	public Chord getJFugueChord() {
		return chord;
	}

	

}
