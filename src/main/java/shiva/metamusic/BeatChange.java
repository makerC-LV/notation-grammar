package shiva.metamusic;

public class BeatChange implements IRhythmElement {
	
	MMDuration duration;

	public BeatChange(int pulse) {
		duration = new MMDuration(pulse);
	}

	
	public MMDuration getDuration() {
		return duration;
	}


	@Override
	public Type getRhythmElementType() {
		return IRhythmElement.Type.BEATCHANGE;
	}

	@Override
	public String toSong4() {
		// TODO Auto-generated method stub
		return null;
	}

}
