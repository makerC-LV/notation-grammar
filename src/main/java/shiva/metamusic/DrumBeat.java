package shiva.metamusic;

public class DrumBeat extends Locatable implements ICopiable, IRhythmElement {

	private boolean beat;
	private int accent;
	private boolean flam;
	
	public DrumBeat(boolean beat, Location location) {
		super(location);
		this.beat = beat;
	}

	public void accent(int b) {
		accent = b;
	}
	
	
	public int getAccent() {
		return accent;
	}

	public boolean isBeat() {
		return beat;
	}

	public boolean isFlam() {
		return flam;
	}

	public void setFlam(boolean b) {
		this.flam = b;
	}
	
	@Override
	public Type getRhythmElementType() {
		return flam ? Type.FLAM : (beat ? Type.BEAT : Type.REST);
	}

	@Override
	public ICopiable copy() {
		DrumBeat db = new DrumBeat(beat, getLocation());
		db.accent(accent);
		return db;
	}


	@Override
	public String toSong4() {
		if (beat && !flam && accent == 1) {
			return "!";
		}
		if (!beat) {
			return "-";
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < accent; i++) {
			sb.append("^");
		}
		String accentString = sb.toString();
		return accentString + (flam ? "*" : "+") ;
	}

	


	

}
