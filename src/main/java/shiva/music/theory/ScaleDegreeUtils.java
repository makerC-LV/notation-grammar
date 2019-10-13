package shiva.music.theory;

import java.util.List;

import org.jfugue.theory.Intervals;
import org.jfugue.theory.Note;
import org.jfugue.theory.Scale;

public class ScaleDegreeUtils {

	public int[] getIntervalSemitones(Intervals intervals) {
		int[] r = new int[intervals.size()];
		for (int i = 0; i < r.length; i++) {
			r[i] = Integer.parseInt(intervals.getNthInterval(i));
		}
		return r;
	}
	
	public static void main(String[] args) {
		Scale scale = new Scale("Cmaj");
		List<Note> notes = scale.getIntervals().getNotes();
		notes.forEach(n->System.out.println(n.getValue()));
	}
}
