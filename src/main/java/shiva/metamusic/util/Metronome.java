package shiva.metamusic.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import org.jfugue.theory.TimeSignature;

import shiva.metamusic.MMTempo;
import shiva.metamusic.MMTimeSig;

public class Metronome {

	static private final int LEAD_IN_COUNT = 1; // bar
	
	public interface MetronomeListener {
		public void leadInFinished();
	}
	
	public List<MetronomeListener> listeners = new ArrayList<>();
	
	ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
	
	int count;
	Runnable beatRunnable = () -> {
		playBeatSound();
	};
	
	
	long msForBeat;
	long msForBar;
	int beatsPerBar;
	
	int beatCount = 0;
	
	ScheduledFuture beatFuture;
	
	
	byte[] beatSound;
	byte[] barSound;
	
	SourceDataLine line;
	
	public Metronome() {
		
		try {
			line = AudioSystem.getSourceDataLine(new AudioFormat(44000, 16, 1, true, false));
			line.open();
			line.start();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		beatSound = createSound(440 * 8);
		barSound = createSound(440);
	}
	
	public void addMetronomeListener(MetronomeListener l) {
		listeners.add(l);
	}
	
	private byte[] createSound(double freq) {
		//return get16BitPcm(getSineWave(44000/16, 44000, freq));
		return get16BitPcm(expDecay(getRandomWave(44000/16, 44000, freq)));
	}

	public double[] getSineWave(int samples,int sampleRate,double frequencyOfTone){
		double[] sample = new double[samples];
		for (int i = 0; i < samples; i++) {
			sample[i] = Math.sin(2 * Math.PI * i / (sampleRate/frequencyOfTone));
		}
		return sample;
    }

	double[] samplebuffer; 
	public double[] getRandomWave(int samples,int sampleRate,double frequencyOfTone) {
		if (samplebuffer == null) {
			samplebuffer = new double[800];
			for (int i = 0; i < samplebuffer.length; i++) {
				samplebuffer[i] = Math.random();
			}
		}
		int period = (int) (sampleRate/frequencyOfTone);
		double[] sample = new double[samples];
		for (int i = 0; i < samples; i++) {
			sample[i] = samplebuffer[i%period];
		}
		return sample;
	}
	
	public double[] expDecay(double[] samples) {
		double b = 0.01;
		for (int i = 0; i < samples.length; i++) {
			double x = i/ (samples.length);
			samples[i] *= Math.pow(1-b, i);
		}
		return samples;
	}
	
    public byte[] get16BitPcm(double[] samples) {
    	double volume = 0.25;
        byte[] generatedSound = new byte[2 * samples.length];
        int index = 0;
        for (double sample : samples) {
            // scale to maximum amplitude
            short maxSample = (short) ((sample * Short.MAX_VALUE * volume));
            // in 16 bit wav PCM, first byte is the low order byte
            generatedSound[index++] = (byte) (maxSample & 0x00ff);
            generatedSound[index++] = (byte) ((maxSample & 0xff00) >>> 8);

        }
        return generatedSound;
    }
//	private void playBarSound() {
//		System.out.println("Bar");
//		line.write(barSound, 0, barSound.length);
//		
//	}

	private void playBeatSound() {
		beatCount++;
		if (beatCount %beatsPerBar == 0) {
			//System.out.println("Bar");
			line.write(barSound, 0, barSound.length);
		} else {
			//System.out.println("Beat");
			line.write(beatSound, 0, beatSound.length);
		}
		if (beatCount == beatsPerBar) {
			for (MetronomeListener ml : listeners) {
				ml.leadInFinished();
			}
		}
		
	}

	
	public void setUp(MMTimeSig timeSig, MMTempo tempo) {
		int ppb = timeSig.getPulsesForBeat();
		int bpm = tempo.getBpm();
		long pulsesPerMin = ppb * bpm;
		double pulsesPerMillisecond = pulsesPerMin/60000.0;
		double msPerPulse = 1/pulsesPerMillisecond;
		msForBeat = (long) (msPerPulse * timeSig.getPulsesForBeat());
		beatsPerBar = timeSig.getBeatsPerMeasure();
		msForBar = msForBeat * beatsPerBar;
		
	}
	
	public void start() {
		beatCount = 0;
		beatFuture = ses.scheduleAtFixedRate(beatRunnable, 0, msForBeat, TimeUnit.MILLISECONDS);
		//barFuture = ses.scheduleAtFixedRate(barRunnable, msForBar, msForBar, TimeUnit.MILLISECONDS);
	}
	
	public void stop() {
		beatFuture.cancel(false);
		//barFuture.cancel(false);
		beatFuture = null;
		//barFuture = null;
	}
	
	public static void main(String[] args) {
		Metronome m = new Metronome();
		m.setUp(MMTimeSig.DEFAULT_TIMESIG, MMTempo.DEFAULT_TEMPO);
		m.start();
	}

	
}
