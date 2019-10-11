package shiva.metamusic;


public interface IPlayable {
	
	public enum Type {
		NOTES, RHYTHM, TIMEBOOKMARK, TIMERECALL, TIMESET, VAR
	}

	Type getPlayableType();

	String toSong4();

}
