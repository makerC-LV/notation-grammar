package shiva.metamusic;

public abstract class ElementWithDuration extends Locatable {

	
	
	protected MMDuration time;
	protected MMDuration duration;

	protected ElementWithDuration( MMDuration time, Location location) {
		super(location);
		this.time = time;
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
