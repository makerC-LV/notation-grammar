package shiva.metamusic;

public class MMTempo {

	int bpm;

	public MMTempo(int bpm) {
		super();
		this.bpm = bpm;
	}
	
	
	public int getBpm() {
		return bpm;
	}


	public static MMTempo DEFAULT_TEMPO = new MMTempo(120);
}
