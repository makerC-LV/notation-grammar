package shiva.metamusic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.jfugue.theory.Chord;
import org.jfugue.theory.Intervals;
import org.jfugue.theory.Key;
import org.jfugue.theory.Note;
import org.jfugue.theory.Scale;

public class MMKeySig extends Locatable {

	Key key;
	

	SortedSet<Integer> notesInKey;
	// Chords without octave
	List<MMChord> allChordsInKey;
	
	public MMKeySig(Key key, Location location) {
		super(location);
		this.key = key;
//		byte noteValue = key.getRoot().getValue();
//		Note root = new Note(Note.getToneStringWithoutOctave(noteValue ));
		key.getScale().getIntervals().setRoot(key.getRoot());
		computeNotesInKey();
		computeChordsInKey();
		
	}

	private void computeChordsInKey() {
		List<MMChord> chords = new ArrayList<>();
		String[] sa = notesArray();
		// for triads
		for (int i = 0; i < sa.length; i++) {
			String[] na = new String[3];
			for (int j = 0; j < na.length; j++) {
				na[j] = sa[(i+ 2 * j)%sa.length];

			}
			Chord c = Chord.fromNotes(na);
			c.setInversion(0);
			MMChord mmc = new MMChord(c, null);
			chords.add(mmc);
		}
		// for sevenths, 4 notes
		for (int i = 0; i < sa.length; i++) {
			String[] na = new String[4];
			for (int j = 0; j < na.length; j++) {
				na[j] = sa[(i+ 2 * j)%sa.length];

			}
			Chord c = Chord.fromNotes(na);
			c.setInversion(0);
			MMChord mmc = new MMChord(c, null);
			chords.add(mmc);
		}
		allChordsInKey = Collections.unmodifiableList(chords);
	}

	private void computeNotesInKey() {
		TreeSet<Integer> set = new TreeSet<>();
		List<Note> notes = key.getScale().getIntervals().getNotes();
		for (int i = 0; i < notes.size(); i++) {
			int value = notes.get(i).getValue();
			int smallestValue = value%12;
			set.add(smallestValue);
			for (int j = 0; j < 11; j++) {
				set.add(smallestValue + j*12);
			}
		}
		notesInKey = Collections.unmodifiableSortedSet(set);
	}

	
	public Key getKey() {
		return key;
	}

	public SortedSet<Integer> getAllNotesInKey() {
		return notesInKey;
	}
	
	public boolean containsNote(int value) {
		return notesInKey.contains(value);
	}
	
	public List<MMNote> getNotes() {
		List<Note> notes = key.getScale().getIntervals().getNotes();
		List<MMNote> mmnotes = notes.stream().map(n -> MMNote.defaultNote(n)).collect(Collectors.toList());
		return mmnotes;
	}
	
	/** Currently returns only major, minor and seventh chords */
	public List<MMChord> getAllChordsInKey() {
		return allChordsInKey;
	}
	
	private String[] notesArray() {
		String[] sa = new String[7];
		int i = 0;
		for (MMNote mmn : getNotes()) {
			sa[i++] = Note.getToneStringWithoutOctave(mmn.getJFugueNote().getValue());
		}
		
		return sa;
	}
	
	
	public String toSong4() {
		String scaleType = (key.getScale().getMajorOrMinorIndicator() == Scale.MAJOR_INDICATOR) ? "major" : "minor";
		return "key " + key.getRoot() + scaleType + " ;";
	}
	
	public static Scale createScale(Scale scale) {
		Scale copy = new Scale(createIntervals(scale.getIntervals()));
		copy.setMajorOrMinorIndicator((byte) scale.getDisposition());
		return copy;
	}
	
	private static Intervals createIntervals(Intervals intervals) {
		return new Intervals(intervals.toString());
	}
	
	static public MMKeySig DEFAULT_KEYSIG = new MMKeySig(Key.DEFAULT_KEY, null);
}
