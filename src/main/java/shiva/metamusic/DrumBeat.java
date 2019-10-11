package shiva.metamusic;

public class DrumBeat implements ICopiable, IRhythmElement {

	private boolean beat;
	
	
	public DrumBeat(boolean beat) {
		super();
		this.beat = beat;
	}

	
	public boolean isBeat() {
		return beat;
	}


	@Override
	public Type getRhythmElementType() {
		return beat ? Type.PLUS : Type.MINUS;
	}

	@Override
	public ICopiable copy() {
		return new DrumBeat(beat);
	}


	@Override
	public String toSong4() {
		return beat ? "+" : "-";
	}

}
