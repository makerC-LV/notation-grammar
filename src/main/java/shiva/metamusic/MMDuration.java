package shiva.metamusic;

/** Represents time in 1/128  notes. */
public class MMDuration implements Comparable<MMDuration> {

	int pulses;
	
	public MMDuration(int pulse) {
		super();
		this.pulses = pulse;
	}

	public int getPulses() {
		return pulses;
	}
	
	@Override
	public int compareTo(MMDuration o) {
		int diff = pulses - o.pulses;
		return diff;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pulses;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MMDuration other = (MMDuration) obj;
		if (pulses != other.pulses)
			return false;
		return true;
	}



	public static MMDuration ZERO = new MMDuration(0);
	public static MMDuration WHOLE = new MMDuration(128);
	public static MMDuration HALF = new MMDuration(64);
	public static MMDuration QUARTER = new MMDuration(32);
	public static MMDuration EIGHTH = new MMDuration(16);
	public static MMDuration SIXTEENTH = new MMDuration(8);
	public static MMDuration THIRTYSECOND = new MMDuration(4);
	public static MMDuration SIXTYFOURTH = new MMDuration(2);
	public static MMDuration ONETWENTYEIGHTH = new MMDuration(1);

	
	
	public static MMDuration stringToDuration(String durationS) {
		if (durationS == null) {
			return WHOLE;
		}
		switch (durationS.toLowerCase()) {
		case "w": return WHOLE;
		case "h": return HALF;
		case "q": return QUARTER;
		case "i": return EIGHTH;
		case "s": return SIXTEENTH;
		case "t": return THIRTYSECOND;
		case "x": return SIXTYFOURTH;
		case "o": return ONETWENTYEIGHTH;
		default: throw new RuntimeException("Unknown duration string: " + durationS);
		}
	}

	public static MMDuration add(MMDuration currentTime, MMDuration duration) {
		return new MMDuration(currentTime.pulses + duration.pulses);
	}
	
	public static MMDuration divide(int n) {
		return new MMDuration(WHOLE.pulses/n);
	}
	
}
