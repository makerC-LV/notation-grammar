package shiva.metamusic;


public interface INotesElement {

	public enum Type {
		 NOTE, CHORD, BARMARKER, PARALLELNOTES, NOTES, VAR, DYNAMIC
			
	}

	Type getNotesElementType();

	String toSong4();
}
