package shiva.metamusic;

public class BeatChange extends Locatable implements IRhythmElement {
	
	MMDuration duration;

	public BeatChange(int pulse, Location location) {
		super(location);
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
		return " " + duration.getPulses() + " " ;
	}

}
