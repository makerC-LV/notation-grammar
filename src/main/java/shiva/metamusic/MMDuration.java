package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public String toString() {
		return "D[" + pulses + "]";
	}

	public MMDuration copy() {
		return new MMDuration(pulses);
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
		
		case "":
		case "w": 
		case "W": return WHOLE;
		
		case "h":
		case "H": return HALF;
		
		case "q": return QUARTER;
		case "Q": return QUARTER;
		
		case "i": 
		case "I": return EIGHTH;
		
		case "s": 
		case "S": return SIXTEENTH;
		
		case "t": 
		case "T": return THIRTYSECOND;
		
		case "x": 
		case "X": return SIXTYFOURTH;
		
		case "o": 
		case "O": return ONETWENTYEIGHTH;
		
		default: throw new RuntimeException("Unknown duration string: " + durationS);
		}
	}

	public static String durationToString(MMDuration dur) {
		if (dur.pulses > WHOLE.pulses*1.5) {
			return "D[" + dur.pulses + "]";
		} else {
			MMDuration fd =  getClosestFittingDuration(dur.pulses);
			if (fd.equals(WHOLE)) {
				return "";
			} if (fd.equals(HALF)) {
				return "h";
			} if (fd.equals(QUARTER)) {
				return "q";
			} if (fd.equals(EIGHTH)) {
				return "i";
			} if (fd.equals(SIXTEENTH)) {
				return "s";
			} if (fd.equals(THIRTYSECOND)) {
				return "t";
			} if (fd.equals(SIXTYFOURTH)) {
				return "x";
			} if (fd.equals(ONETWENTYEIGHTH)) {
				return "o";
			}
		}
		return null;
	}
	public static MMDuration add(MMDuration currentTime, MMDuration duration) {
		return new MMDuration(currentTime.pulses + duration.pulses);
	}
	
	public static MMDuration multiply(MMDuration dur, double d) {
		return new MMDuration((int) (dur.pulses * d));
	}
	
	
	/** Creates a duration of d * WHOLE */
	public static MMDuration createDuration(double d) {
		return new MMDuration((int) (WHOLE.pulses * d));
	}

	
	private static MMDuration[] DURATIONS = new MMDuration[] {
			WHOLE, HALF, QUARTER, EIGHTH, SIXTEENTH, THIRTYSECOND, SIXTYFOURTH, ONETWENTYEIGHTH 
	};
	
	public static List<MMDuration> getDurationList(int d) {
		List<MMDuration> l = new ArrayList<>();
		while (d >= ONETWENTYEIGHTH.pulses) {
			MMDuration dur = getClosestFittingDuration(d);
			l.add(dur.copy());
			if (d < 1.6 * dur.pulses)
			d = 0;
			if (d <= 0) {
				break;
			}
		}
		return l;
	}

	private static MMDuration getLargestFittingDuration(int d) {
		for (MMDuration dur: DURATIONS) {
			if (dur.pulses <= d) {
				return dur;
			}
		}
		return null;
	}

	private static MMDuration getClosestFittingDuration(int d) {
		for (MMDuration dur: DURATIONS) {
			if (dur.pulses == 1) {
				return dur;
			} else {
				if (0.70 * dur.pulses < d && d < 1.5 * dur.pulses) {
					return dur;
				}
			}
			
		}
		return null;
	}

	public String toSong4() {
		return durationToString(this);
	}
	
	
	
	
}
