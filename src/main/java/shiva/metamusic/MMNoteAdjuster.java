package shiva.metamusic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.jfugue.theory.Note;
import org.jfugue.theory.Scale;

public class MMNoteAdjuster {

	
	//http://neilhawes.com/sstheory/skeysig2.htm
	
	static String[] majorScaleRoots = new String[] 
			{"Cb", "Gb", "Db", "Ab", "Eb", "Bb", "F", "C", "G", "D", "A", "E", "B", "F#", "C#"};
	
	static String[] minorScaleRoots = new String[] 
			{"Ab", "Eb", "Bb", "F", "C", "G", "D", "A", "E", "B", "F#", "C#", "G#", "D#", "A#"};
	
	static String[] fifths = {"F", "C", "G", "D", "A", "E", "B" };
	
	static private Map<String, SharpOrFlatNotes> majorScaleMap = new HashMap<>();
	static private Map<String, SharpOrFlatNotes> minorScaleMap = new HashMap<>();
	
	static {
		fillMaps();
	}
	
	static public int getMidiNote(MMNote mmnote, MMKeySig keySig) {
		Note jfnote = mmnote.getJFugueNote();
		String noteS = Note.getToneStringWithoutOctave(jfnote.getValue());
		if (noteS.length() > 1) {
			return jfnote.getValue();
		}
		boolean isMajorKey = keySig.getKey().getScale().getMajorOrMinorIndicator() == Scale.MAJOR_INDICATOR;
		Map<String, SharpOrFlatNotes> map = isMajorKey ? majorScaleMap : minorScaleMap;
		byte keyRootValue = keySig.getKey().getRoot().getValue();
		String keySigNoteS = Note.getToneStringWithoutOctave(keyRootValue);
		SharpOrFlatNotes sof = map.get(keySigNoteS);
		if (sof == null) {
			return jfnote.getValue();
		} else if (sof.contains(noteS)){
			if (sof.sharp) {
				return jfnote.getValue() + 1;
			} else {
				return jfnote.getValue() - 1;
			}
			
		}
		return jfnote.getValue();
	}
	
	
	static private void fillMaps() {
		for (int i = 0; i < majorScaleRoots.length; i++) {
			if (i < 7) {
				SharpOrFlatNotes sof = makeFlats(i);
				majorScaleMap.put(majorScaleRoots[i], sof);
				minorScaleMap.put(minorScaleRoots[i], sof);
			} else if (i > 7) {
				SharpOrFlatNotes sof = makeSharps(i);
				majorScaleMap.put(majorScaleRoots[i], sof);
				minorScaleMap.put(minorScaleRoots[i], sof);
			}
		}
	}
	
	
	private static SharpOrFlatNotes makeFlats(int i) {
		SharpOrFlatNotes flats = new SharpOrFlatNotes();
		flats.sharp = false;
		for (int j = i; j < fifths.length; j++) {
			flats.add(fifths[j]);
		}
		return flats;
	}


	private static SharpOrFlatNotes makeSharps(int i) {
		SharpOrFlatNotes sharps = new SharpOrFlatNotes();
		sharps.sharp = true;
		int max = i - 7;
		for (int j = 0; j < max; j++) {
			sharps.add(fifths[j]);
		}
		return sharps;
	}
	
	static private class SharpOrFlatNotes extends HashSet<String> {
		boolean sharp;
		
	}
}
