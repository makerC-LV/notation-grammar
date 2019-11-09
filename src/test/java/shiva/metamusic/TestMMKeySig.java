package shiva.metamusic;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.jfugue.theory.Chord;
import org.jfugue.theory.Key;
import org.jfugue.theory.Note;
import org.junit.Test;

public class TestMMKeySig {

	@Test
	public void test() {
		assertEquals("CDEFGAB", notesString(create("CMAJ")));
		assertEquals("DEF#GABC#", notesString(create("DMAJ")));
		assertEquals("GABCDEF#", notesString(create("GMAJ")));
		
		assertEquals("CDEbFGG#Bb", notesString(create("CMIN")));
		
		//System.out.println(notesString(create("CMIN")));
	}

	@Test
	public void testChord() {
		String[] sa = notesArray(create("CMIN"));
		for (int i = 0; i < sa.length; i++) {
			String[] na = new String[3];
			for (int j = 0; j < na.length; j++) {
				na[j] = sa[(i+ 2 * j)%sa.length];
				
			}
			System.out.println(Arrays.toString(na));
			Chord c = Chord.fromNotes(na);
			c.setInversion(0);
			System.out.printf("%s  %s  %s\n", c, c.getRoot(), c.getBassNote());
		}
	}
	
	
	private String[] notesArray(MMKeySig sig) {
		String[] sa = new String[7];
		int i = 0;
		for (MMNote mmn : sig.getNotes()) {
			sa[i++] = Note.getToneStringWithoutOctave(mmn.getJFugueNote().getValue());
		}
		
		return sa;
	}
	
	private String notesString(MMKeySig sig) {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (MMNote mmn : sig.getNotes()) {
			if (!first) {
				sb.append(" ");
				first = false;
			}
			sb.append(Note.getToneStringWithoutOctave(mmn.getJFugueNote().getValue()));
			
		}
		return sb.toString();
	}
	
	private MMKeySig create(String repn) {
		Key key = new Key(repn);
		return new MMKeySig(key, null);
	}
}
