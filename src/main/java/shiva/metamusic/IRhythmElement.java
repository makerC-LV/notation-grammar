package shiva.metamusic;


public interface IRhythmElement {

	public enum Type {
		PLUS,  MINUS,  BARMARKER, BEATCHANGE, RHYTHM, VAR
			
	}

	Type getRhythmElementType();

	String toSong4();
}
