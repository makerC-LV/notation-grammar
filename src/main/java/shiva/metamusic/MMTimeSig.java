package shiva.metamusic;

import org.jfugue.theory.TimeSignature;

public class MMTimeSig {

	TimeSignature time;

	public MMTimeSig(TimeSignature time) {
		super();
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
}
