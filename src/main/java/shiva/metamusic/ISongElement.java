package shiva.metamusic;

public interface ISongElement {

	public enum Type {
		VARDEF, PLAYCOMMAND
	}
	
	Type getSongElementType();
	
	String toSong4();
}
