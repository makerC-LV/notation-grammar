package shiva.metamusic;

public class TimeSet implements IPlayable {

	private MMDuration time;
	private String bar;
	private String pulse;
	
	
	public TimeSet(MMDuration time, String bar, String pulses) {
		super();
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
