package shiva.metamusic;

public class Location {

	private int line;
	private int charOffsetInLine;
	private int length;
	String text;
	
	
	public Location(int line, int charOffsetInLine, int length, String text) {
		super();
		this.line = line;
		this.charOffsetInLine = charOffsetInLine;
		this.length = length;
		this.text = text;
	}


	public int getLine() {
		return line;
	}


	public int getCharOffsetInLine() {
		return charOffsetInLine;
	}


	public int getLength() {
		return length;
	}


	public String getText() {
		return text;
	}
	
	
	
	
}
