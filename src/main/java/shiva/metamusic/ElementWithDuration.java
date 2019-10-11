package shiva.metamusic;

public abstract class ElementWithDuration {

	
	
	protected MMDuration time;
	protected MMDuration duration;

	protected ElementWithDuration( MMDuration time) {
		super();
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
