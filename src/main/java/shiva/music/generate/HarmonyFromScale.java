package shiva.music.generate;

import java.util.ArrayList;
import java.util.List;

import shiva.metamusic.MMChord;
import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;

public class HarmonyFromScale {

	//https://medium.com/@NickEss/how-to-add-a-chord-progression-to-a-melody-in-a-few-easy-steps-7d28939f0b43
	public static List<MMChord> generateHarmony(List<MMNote> notes, MMKeySig keysig) {
		List<MMChord> chords = new ArrayList<>();
		List<MMChord> candidates = keysig.getAllChordsInKey();
		for (MMNote mmn: notes) {
			chords.add(match(mmn, candidates));
		}
		return chords;
		
	}

	private static MMChord match(MMNote mmn, List<MMChord> candidates) {
		for (MMChord ch: candidates) {
			int midiNum = mmn.getJFugueNote().getValue();
			MMChord mc = ch.transposeToInclude(midiNum);
			if (mc != null) {
				return mc;
			}
		}
		return null;
	}
	
	
}
