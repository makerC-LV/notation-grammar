package shiva.music.generate;

import java.util.List;

import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;

public class MelodyVariations {

	// Ideas
	// vary first part of a melody (first or second note)
	// vary last part of a melody (secondlast note)
	
	// vary first pattern
	// vary last pattern
	
	public static List<MMNote> varyNote(int index, List<MMNote> notes, MMKeySig keySig) {
		int[] midiNums = GenerateUtils.getMidiNumbers(notes, keySig);
		int[] variation = varyNote(index, midiNums, keySig);
		return GenerateUtils.generateMMNotes(variation);
	}
	
	// change note[index]
	public static int[] varyNote(int index, int[] midiNums, MMKeySig keySig) {
		int[] n = midiNums;
		if (n.length > 6) {
			System.out.println("Warning: The melody is longer than 6 notes, varying one index will have little impact.");
		}
		if (index == 0 || index == n.length - 1) {
			throw new RuntimeException("varyNote: This method only handles middle notes");
		}
		int previousNote = n[index - 1];
		int nextNote = n[index + 1];
		int note = n[index];
		System.out.printf("prev:%d note:%d next:%d\n", previousNote, note, nextNote);
		int bestConsonance = Integer.MAX_VALUE;
		int bestCandidate = -1;
		for (int candidate = note - 6; candidate < note + 6; candidate++) {
			if (candidate == note) {
				continue;
			}
			int consonance = consonance(previousNote, candidate, nextNote);
			if (consonance < bestConsonance) {
				System.out.println("new consonance: " + consonance + " candidate: " + candidate);
				bestConsonance = consonance;
				bestCandidate = candidate;
			}
		}
		int[] variation = new int[n.length];
		for (int i = 0; i < n.length; i++) {
			if (i == index) {
				System.out.println("Replacing " + note + " with " + bestCandidate);
				variation[i] = bestCandidate;
			} else {
				variation[i] = n[i];
			}
		}
		return variation;
				
		
	}
	
	private static int consonance(int prev, int note, int next) {
		int c1 = EulerConsonance.eulerConsonance(prev, note);
		int c2 = EulerConsonance.eulerConsonance(note, next);
		return c1+c2;
	}
	
	
}
