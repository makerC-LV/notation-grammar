package shiva.metamusic.util;

import shiva.metamusic.MMDuration;
import shiva.metamusic.MMTempo;
import shiva.metamusic.MMTimeSig;

public class TickCalculator {

	private long ticksPerPulse;
	// Below quantities are informational only
	private long pulsesPerMin;
	private double ticksPerMin;
	private int bpm;
	private int beatsPerMeasure;
	private double secsPerPulse;
	private double secondsPerBeat;
	private double pulsesPerMillisecond;

	public TickCalculator(int ppq, MMTimeSig timeSig, MMTempo tempo) {
		super();
		int ppb = timeSig.getPulsesForBeat();
		ticksPerPulse = ppq / ppb;
		bpm = tempo.getBpm();
		pulsesPerMin = ppb * bpm;
		ticksPerMin = ppq * bpm;
		pulsesPerMillisecond = pulsesPerMin/60000.0;
		
		beatsPerMeasure = timeSig.getBeatsPerMeasure();
		secsPerPulse = 1.0/(60 * pulsesPerMin);
		secondsPerBeat = timeSig.getPulsesForBeat() * secsPerPulse;
	}

	public long toTicks(MMDuration duration) {
		return ticksPerPulse * duration.getPulses();
	}

	public int ticksToPulses(long ticks) {
		return (int) (ticks / ticksPerPulse);
	}

	public int millisecondsToPulses(long millis) {
		return (int) (millis * pulsesPerMillisecond);
	}

	@Override
	public String toString() {
		return "TickCalculator [ticksPerPulse=" + ticksPerPulse + ", pulsesPerMin=" + pulsesPerMin + ", ticksPerMin="
				+ ticksPerMin + ", bpm=" + bpm + ", beatsPerMeasure=" + beatsPerMeasure + ", secsPerPulse="
				+ secsPerPulse + ", secondsPerBeat=" + secondsPerBeat + ", pulsesPerMillisecond=" + pulsesPerMillisecond
				+ "]";
	}
	
	
	
	
	
	
}