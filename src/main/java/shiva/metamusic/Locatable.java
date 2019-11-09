package shiva.metamusic;

public class Locatable {

	protected Location location;

	public Locatable(Location location) {
		super();
		this.location = location;
	}

	
	public Location getLocation() {
		return location;
	}

	

	public void setLocation(Location location) {
		this.location = location;
	}


	public int getLine() {
		return location == null ? -1 : location.getLine();
	}

	public int getCharOffsetInLine() {
		return location == null ? -1 : location.getCharOffsetInLine();
	}

	public int getLength() {
		return location == null ? -1 : location.getLength();
	}

	public String getText() {
		return location == null ? "" : location.getText();
	}

	
	
	
	
}
