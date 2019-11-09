package shiva.metamusic;

public class MMTempo extends Locatable {

	int bpm;

	public MMTempo(int bpm, Location location) {
		super(location);
		this.bpm = bpm;
	}
	
	
	public int getBpm() {
		return bpm;
	}


	public static MMTempo DEFAULT_TEMPO = new MMTempo(120, null);

	public String toSong4() {
		return "tempo " + bpm + " ;";
	}
}
