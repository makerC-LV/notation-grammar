package shiva.metamusic;

import org.jfugue.theory.TimeSignature;

import shiva.metamusic.util.Util;

public class MMTimeSig extends Locatable {

	TimeSignature time;

	public MMTimeSig(TimeSignature time, Location location) {
		super(location);
		this.time = time;
		if (!Util.isPowerOfTwo(time.getDurationForBeat())) {
			System.err.println("Warning: Irrational time signature: " + time);
		}
	}

	public TimeSignature getTime() {
		return time;
	}
	
	public int getPulsesForBeat() {
		return MMDuration.WHOLE.getPulses()/time.getDurationForBeat();
	}
	
	public int getBeatsPerMeasure() {
		return time.getBeatsPerMeasure();
	}
	
	public int getPulsesPerMeasure() {
		return getPulsesForBeat() * getBeatsPerMeasure();
	}

	public String toSong4() {
		return "time " + time.getBeatsPerMeasure() + "/" + time.getDurationForBeat() + " ;" ;
	}
	
	public static MMTimeSig DEFAULT_TIMESIG = new MMTimeSig(TimeSignature.DEFAULT_TIMESIG, null);
}
