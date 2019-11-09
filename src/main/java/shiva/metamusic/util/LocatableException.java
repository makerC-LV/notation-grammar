package shiva.metamusic.util;

import shiva.metamusic.Location;

@SuppressWarnings("serial")
public class LocatableException extends RuntimeException {
	
	protected Location location;
	
	public LocatableException(Location location,  String msg) {
		super(msg);
		this.location = location;
	}

	public int getLine() {
		return location.getLine();
	}

	public int getCharOffsetInLine() {
		return location.getCharOffsetInLine();
	}

	public int getLength() {
		return location.getLength();
	}

	public String getText() {
		return location.getText();
	}
	
	

}
