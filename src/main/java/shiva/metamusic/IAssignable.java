package shiva.metamusic;


public interface IAssignable {
	
	public enum Type {
		VOICE, NOTES, RHYTHM
	}

	Type getType();

	String toSong4();
}
