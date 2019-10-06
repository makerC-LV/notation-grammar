package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;

import org.jfugue.theory.Note;

public class MMRhythmPhrase {

	public static final MMDuration DEFAULT_DURATION = new MMDuration(16);
	public static final int DEFAULT_PERCUSSION_NOTE = 42; // Closed hi-hat
	
	MMDuration noteDuration = DEFAULT_DURATION;
	
	List<Boolean> beats = new ArrayList<>();
	
	
	public MMDuration getNoteDuration() {
		return noteDuration;
	}

	public void setNoteDuration(MMDuration pulseDuration) {
		noteDuration = pulseDuration;
		
	}

	public void add(boolean b) {
		beats.add(b);
		
	}

	
	public List<Boolean> getBeats() {
		return beats;
	}

	public static int getRhythmMidiNum(String instrumentName) {
		int i = 0;
		for (String inst : Note.PERCUSSION_NAMES) {
			if (inst.equals(instrumentName.toUpperCase())) {
				return i + 35;
			}
			i++;
		}
		return DEFAULT_PERCUSSION_NOTE;
	}

	public MMRhythmPhrase repeat(int reps) {
		MMRhythmPhrase newphrase = new MMRhythmPhrase();
		newphrase.setNoteDuration(this.noteDuration);
		
		for (int i = 0; i < reps; i++) {
			for (boolean b : getBeats()) {
				newphrase.add(b);
			}
		}
		return newphrase;
		
	}

}
