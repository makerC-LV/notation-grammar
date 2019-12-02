package shiva.music.generate.counterpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.util.PlayUtils;

public class Generator {
	
	
	
	public List<? extends CRule> rules = GroovyRules.getGroovyRules();
	
	Random rand = new Random(10);
	
	public static void main(String[] args) {
		new Generator().generateCantus(8, 4);
	}
	
	public CounterpointMelody generateCantus(int measures, int beatsPerMeasure) {
		CounterpointMelody cm = new CounterpointMelody(measures, beatsPerMeasure, 5);
		generateVoice(cm, Species.CANTUS);
		return cm;
	}
	
	public void generateVoice(CounterpointMelody melody, Species species) {
		List<Voice> solutions = new BNB().generate(melody, species, 50);
		Voice v = solutions.get(0);
		v.setMelody(melody);
		melody.add(v);
		print(solutions);
		
	}

	

	

	private void print(List<Voice> solutions) {
		solutions.forEach(v -> {
			System.out.println("Solution:");
			v.forEach(n -> System.out.println(n));
			
		});
		
	}

	/** Select note with prob prop to score. */
	private VoiceNote selectNote(List<VoiceNote> validNotes) {
		double r = rand.nextDouble();
		double sum = validNotes.stream().collect(Collectors.summingDouble(sn->sn.score));
		r *= sum;
		for (VoiceNote sn : validNotes) {
			r -= sn.score;
			if (r <= 0) {
				return sn;
			}
		}
		return null;
	}
	

}
