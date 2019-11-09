package shiva.metamusic;

public class TimeSet extends Locatable implements IPlayable {

	private MMDuration time;
	private String bar;
	private String pulse;
	
	
	public TimeSet(MMDuration time, String bar, String pulses, Location location) {
		super(location);
		this.time = time;
		this.bar = bar;
		this.pulse = pulses;
	}


	public MMDuration getTime() {
		return time;
	}


	@Override
	public Type getPlayableType() {
		return Type.TIMESET;
	}


	@Override
	public String toSong4() {
		return bar + ":" + pulse + " ";
	}

}
