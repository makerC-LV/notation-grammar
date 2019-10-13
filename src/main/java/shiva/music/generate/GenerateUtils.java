package shiva.music.generate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jfugue.theory.Note;

import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;

public class GenerateUtils {

	
	
	public static List<MMNote> generateMMNotes(int[] midiNums) {
		List<MMNote> l = new ArrayList<>();
		for (int note: midiNums) {
			MMNote mmn = new MMNote(new Note(note));
			l.add(mmn);
		}
		return l;
	}
	
	public static int[] getMidiNumbers(List<MMNote> notes, MMKeySig keySig) {
		int[] r = new int[notes.size()];
		for (int i = 0; i < notes.size(); i++) {
			r[i] = MMNote.calculateMidiNum(notes.get(i), keySig);
		}
		return r;
	}
	
	
	/** Tries to break the array into the longest repeating patterns, and intermediate parts */
	public static List<IndexPair> breakIntoRepeatingPatterns(int[] midiNums) {
		List<IndexPair> l = new ArrayList<>();
		IndexPair pat = findLongestRepeatingPattern(midiNums);
		if (pat == null) {
			return l;
		}
		int index = 0;
		IndexPair currentPat = pat;
		while (index < midiNums.length) {
			if (pat.start > index) {
				l.add(new IndexPair(index, currentPat.start));
			}
			l.add(currentPat);
			index = currentPat.end;
			if (index >= midiNums.length) {
				break;
			}
			currentPat = findNextOccurrence(currentPat, midiNums);
			
			if (currentPat == null) {
				l.add(new IndexPair(index, midiNums.length));
				break;
			} 
		}
		return l;
		
	}
	
	private static IndexPair findNextOccurrence(IndexPair currentPat, int[] midiNums) {
		// TODO Auto-generated method stub
		return null;
	}


	public static IndexPair findLongestRepeatingPattern(int[] a) {
		if (a.length < 4) {
			return null;
		}
		int maxLen = -1;
		IndexPair maxPair = null;
		int n = a.length;
		for (int i = 0; i < n-2; i++) {
			for (int j = i+2; j < n; j++) {
				IndexPair pair = new IndexPair(i, j);
				if (isRepeating(a, pair)) {
					if (pair.length() > maxLen) {
						maxPair = pair;
					}
				}
			}
		}
		return maxPair;
	}
	
	
	private static boolean isRepeating(int[] a, IndexPair pair) {
		int len = pair.length();
		if (pair.end + len > a.length) {
			return false;
		}
		for (int i = pair.end; i < a.length - len; i++) {
			if (match(a, pair.start, pair.end, i, i+len)) {
				return true;
			}
		}
		return false;
	}


	private static boolean match(int[] a, int s1, int e1, int s2, int e2) {
		for (int i = s1; i < e1; i++) {
			int offset = i - s1;
			if (a[i] != a[s2+offset]) {
				return false;
			}
		}
		return true;
	}

	public static int[] copy(int[] a) {
		return Arrays.copyOf(a, a.length);
	}

	public  static class IndexPair {
		int start;
		int end;
		public IndexPair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		public int length() {
			return end - start;
		}
		
	}

	
}
