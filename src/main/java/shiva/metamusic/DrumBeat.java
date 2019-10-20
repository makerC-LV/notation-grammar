package shiva.metamusic;

public class DrumBeat implements ICopiable, IRhythmElement {

	private boolean beat;
	private boolean accented;
	
	public DrumBeat(boolean beat) {
		super();
		this.beat = beat;
	}

	public void accent(boolean b) {
		accented = b;
	}
	
	
	public boolean isAccented() {
		return accented;
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
		DrumBeat db = new DrumBeat(beat);
		db.accent(accented);
		return db;
	}


	@Override
	public String toSong4() {
		return beat ? "+" : "-";
	}


	

}
