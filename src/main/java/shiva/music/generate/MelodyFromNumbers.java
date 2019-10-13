package shiva.music.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.jfugue.theory.Key;
import org.jfugue.theory.Note;

import shiva.metamusic.MMChord;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;
import shiva.metamusic.Song;
import shiva.metamusic.util.PlayUtils;

public class MelodyFromNumbers {

	
	public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
		Key key = Key.DEFAULT_KEY;
//		Key key = new Key("F#min");
		MMKeySig keySig = new MMKeySig(key);
//		int[] series = new int[] {1, 5, 12, 22, 35, 51, 70, 92, 117, 145, 176}; // pentagonal
		int[] series = new LazyCaterer().generate(8); // periodic, first 7 are interesting
//		int[] series = new MagicSquare().generate(8); // periodic, but the first 7 notes are interesting
		List<MMNote> notes = generateMelody(series, keySig);
		List<MMNote> variation = MelodyVariations.varyNote(6, notes, keySig);
		variation = MelodyVariations.varyNote(4, variation, keySig);
		notes.addAll(variation);
//		PlayUtils.playNotes(notes, keySig);
		
		
		// add chords
		List<MMNote> barStarts = new ArrayList<>();
		for (int i = 3; i < notes.size(); i+=4) {
			barStarts.add(notes.get(i));
		}
		List<MMChord> chords = HarmonyFromScale.generateHarmony(barStarts, keySig);
		List<MMChord> chordsWithDuration = chords.stream().map(
				ch -> new MMChord(MMDuration.ZERO, ch.getJFugueChord(),  MMDuration.WHOLE)).collect(Collectors.toList());
		
		
		Song song = new Song();
		song.addNoteList("voice1", "Piano", false, notes);
		song.addNoteList("voice2", "Flute", false, chordsWithDuration);
		PlayUtils.playSong(song);
		
	}
	
	
	/**
	 * 
	 * @param input midi notes
	 * @param keySig
	 * @return
	 */
	public static List<MMNote> generateMelody(int[] input, MMKeySig keySig) {
		List<MMNote> mmnotes = keySig.getNotes();
		return generateMelody(input, mmnotes);
	}



	
	/**
	 * 
	 * @param input midi notes
	 * @param scaleNotes
	 * @return
	 */
	public static List<MMNote> generateMelody(int[] input, List<MMNote> scaleNotes) {
		List<MMNote> notes = new ArrayList<>();
		int n = scaleNotes.size();
		for (int r : input) {
			int index = r % n;
			notes.add((MMNote) scaleNotes.get(index).copy());
		}
		return notes;
	}
	
	
	/** This is periodic. No good. */
	static class LazyCaterer extends SeriesGenerator {

		@Override
		protected int formula(int n) {
			return ((n * n) + n + 2)/2;
		}
		
	}
	
	static class MagicSquare extends SeriesGenerator {

		@Override
		protected int formula(int n) {
			return n* (n*n + 1)/2;
		}
		
	}
	abstract static class SeriesGenerator {
		
		int[] generate(int len) {
			int[] r = new int[len];
			for (int i = 1; i < len; i++) {
				r[i] = formula(i);
			}
			return r;
		}

		protected abstract int formula(int i);
	}
}
