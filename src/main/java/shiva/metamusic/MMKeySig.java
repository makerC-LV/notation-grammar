package shiva.metamusic;

import org.jfugue.theory.Key;
import org.jfugue.theory.Scale;

public class MMKeySig {

	Key key;

	public MMKeySig(Key key) {
		super();
		this.key = key;
	}

	public Key getKey() {
		return key;
	}

	public String toSong4() {
		String scaleType = (key.getScale().getMajorOrMinorIndicator() == Scale.MAJOR_INDICATOR) ? "major" : "minor";
		return "key " + key.getRoot() + scaleType + " ;";
	}
	
	
}
