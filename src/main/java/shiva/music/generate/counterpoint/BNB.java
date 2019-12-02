package shiva.music.generate.counterpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BNB {
	
	public  static final int LOWEST_NOTE = 48;
	public static final int HIGHEST_NOTE = 72;
	
	public static final int INFINITE = 1000000;
	
	boolean solutionsGenerated = false;
	
	public List<? extends CRule> rules = GroovyRules.getGroovyRules();
	
	int[] pitches;
	int[] durations;
	
	public BNB() {
		pitches = new int[HIGHEST_NOTE - LOWEST_NOTE + 1];
		for (int i = LOWEST_NOTE; i <= HIGHEST_NOTE; i++) {
			pitches[i-LOWEST_NOTE] = i;
		}
	}
	public List<Voice> generate(CounterpointMelody melody, Species species, int numSolutions) {
		durations = new int[melody.getBeatsPerMeasure()];
		for (int i = 0; i < melody.getBeatsPerMeasure(); i++) {
			durations[i] = i+1;
		}
		
		solutionsGenerated = false;
		List<Voice> solutions = new ArrayList<>();
		PriorityQueue<Voice> partialSolutions = new PriorityQueue<>();
		Voice v = new Voice();
		partialSolutions.add(v);
		generateRec(partialSolutions, solutions, numSolutions, melody, species);
		
		solutions.sort(null);
		return solutions;
	}

	
	
	private void generateRec(PriorityQueue<Voice> partialSolutions, List<Voice> solutions, int numSolutions,
			CounterpointMelody melody, Species species) {
		while (!solutionsGenerated) {
			extendBestPartialSolution(partialSolutions, solutions, numSolutions, melody, species);
		}
	}



	private void extendBestPartialSolution(PriorityQueue<Voice> partialSolutions, List<Voice> solutions, int numSolutions, 
			CounterpointMelody melody, Species species) {
		if (partialSolutions.isEmpty()) {
			System.out.println("No more solutions");
			solutionsGenerated = true;
			return;
		}
		Voice cs = partialSolutions.poll();
		partialSolutions.remove(cs);
		List<VoiceNote> candidates = generateCandidates(melody, species);
		RuleContext rc = new RuleContext(melody, cs, species, null);
		int psSize = partialSolutions.size();
		for (VoiceNote vn: candidates) {
			rc.sn = vn;
			score(rc);
			if (vn.score < INFINITE) {
				Voice v = cs.copy();
				v.add(vn);
				if (isComplete(v, melody, species)) {
					solutions.add(v);
					System.out.println("Num solns: " + solutions.size());
					if (solutions.size() >= numSolutions) {
						System.out.println("SolnsGenerated: ");
						solutionsGenerated = true;
						return;
					}
				} else {
					if (!isContained(partialSolutions, v)) {
						partialSolutions.add(v);
					}
//					System.out.println("PS length: " + v.size() + " " + v.score);
//					System.out.println(partialSolutions.size());
				}
			}
		}
		if (partialSolutions.size() == psSize) {
//			System.out.println("No partial soulutions added: " + partialSolutions.size());
		}
	}



	private boolean isContained(PriorityQueue<Voice> partialSolutions, Voice v) {
		for (Voice ps : partialSolutions) {
			if (v.identicalNotes(ps)) {
				return true;
			}
		}
		return false;
	}



	private boolean isComplete(Voice v, CounterpointMelody melody, Species species) {
		return melody.getDurationInBeats() <= v.getDurationinBeats();
	}



	private void score(RuleContext rc) {
		for (CRule r : rules) {
			r.score(rc);
		}
		
	}



	private List<VoiceNote> generateCandidates(CounterpointMelody melody, Species species) {
		List<VoiceNote> l = new ArrayList<>();
		for (int n : pitches) {
			for (int dur: durations) {
				VoiceNote vn = new VoiceNote(n, dur, false);
//				debug(vn, 71);
				l.add(vn);
			}
		}
		return l;
	}

	private void debug(VoiceNote sn, int pitch) {
		sn.debug = (sn.midiNum == pitch);
		
	}

	
}
