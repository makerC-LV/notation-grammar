package shiva.metamusic;

public abstract class MMTrackItem {

	public static enum MMItemType {
		NOTE, PARALLELNOTES, CHORD, VELOCITY
	}
	
	protected MMItemType type;
	
	protected MMDuration time;
	protected MMDuration duration;

	protected MMTrackItem(MMItemType type, MMDuration time) {
		super();
		this.type = type;
		this.time = time;
	}

	abstract public MMTrackItem copy();
	
	public MMItemType getType() {
		return type;
	}

	public MMDuration getTime() {
		return time;
	}

	public MMDuration getDuration() {
		return duration;
	}

	public void setTime(MMDuration time) {
		this.time = time;
	}
	
	
	
}
