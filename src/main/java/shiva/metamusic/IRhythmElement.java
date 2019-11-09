package shiva.metamusic;


public interface IRhythmElement {

	public enum Type {
		BEAT,  REST,  FLAM, BARMARKER, BEATCHANGE, RHYTHM, VAR, DYNAMIC
			
	}

	Type getRhythmElementType();

	String toSong4();
}
