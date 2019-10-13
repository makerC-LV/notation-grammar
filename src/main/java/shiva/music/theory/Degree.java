package shiva.music.theory;

public enum Degree {

	D1, DS1, DF2, D2, DS2, DF3, D3, DS3, D4, DS4, DF5, D5, DF6, D6, DS6, DF7, D7 ;
	
	int degree;
	boolean sharp;
	boolean flat;
	int semitones;
	boolean major; // for major scale
	boolean minor; // for minor scale
	
	
	private Degree() {
		
	}
	
	public static void res() {
		
	}
}
