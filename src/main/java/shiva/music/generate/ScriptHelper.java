package shiva.music.generate;

import java.util.ArrayList;
import java.util.List;

import org.jfugue.theory.Key;

import shiva.metamusic.INotesElement;
import shiva.metamusic.MMChord;
import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;
import shiva.metamusic.Notes;
import shiva.metamusic.ParallelNotes;

/** This class packages a number of methods for convenient use from scripts. */

public class ScriptHelper {

	public static Notes notes(List<Integer> numbers, String keySig) {
		List<MMNote> notel =noteList(numbers, keySig);
		return (Notes) Notes.create(notel);
	}
	
	
	public static List<MMNote> noteList(List<Integer> numbers, String keySig) {
		int[] nints = toIntArray(numbers);
		return MelodyFromNumbers.generateMelody(nints, new MMKeySig(new Key(keySig), null));
	}
	
	/** Requires that notes should be essentially a list of notes. */
	public static Notes harmony(Notes notes, String keySig) {
		List<MMChord> l = HarmonyFromScale.generateHarmony(listFromNotes(notes), new MMKeySig(new Key(keySig), null));
		Notes n = new Notes(0);
		n.addAll(l);
		return n;
	}
	
	static List<MMNote> listFromNotes(Notes notes) {
		List<MMNote> l = new ArrayList<>();
		for (INotesElement n : notes) {
			switch (n.getNotesElementType()) {
			case BARMARKER:
				break;
			case CHORD: // take tonic note
				MMChord mmchord = (MMChord) n;
				l.add(mmchord.getTonicNote());
				break;
			case DYNAMIC:
				break;
			case NOTE:
				break;
			case NOTES:
				l.addAll(listFromNotes((Notes) n));
				break;
			case PARALLELNOTES: // take first note
				ParallelNotes pn = (ParallelNotes) n;
				l.add(pn.getNotes().get(0));
				break;
			case VAR:
				throw new RuntimeException("Var not allowed in this function");
			default:
				throw new RuntimeException("Unimplemented type: " + n.getNotesElementType());
			
			}
		}
		return l;
	}
	
	
	
	static int[] toIntArray(List<Integer> list){
		  int[] ret = new int[list.size()];
		  for(int i = 0;i < ret.length;i++)
		    ret[i] = list.get(i);
		  return ret;
		}
}
