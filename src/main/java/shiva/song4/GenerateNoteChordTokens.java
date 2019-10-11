package shiva.song4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfugue.theory.Chord;
import org.jfugue.theory.Key;
import org.jfugue.theory.Note;
import org.jfugue.theory.Scale;

import shiva.metamusic.MMChord;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;

public class GenerateNoteChordTokens {

	
	private static String noteCharsUC = "CDEFGABR";
	private static String durationCharsLC = "whqistxo";
	
	
	
	private static String[] noteArray = generateNoteArray();
	private static String[] octaveStrings = generateOctaveStrings();
	private static String[] chordAccidentals = new String[] {"#", "b", " "};
	private static String[] noteAccidentals = new String[] {"#", "b", "n", " "};
	private static String [] durationArray = generateDurationArray();
	
	private static String dot = ".";
	
	private static Map<String, MMNote> noteMap = new HashMap<>();
	private static Map<String, MMNote> noteNameMap = new HashMap<>();
	private static Map<String, MMChord> chordMap = new HashMap<>();
	private static Map<String, MMChord> chordTypeMap = new HashMap<>();
	private static Map<String, MMKeySig> keySigMap = new HashMap<>();
	
	static {
		fillNoteMap();
		fillNoteNameMap();
		fillChordMap();
		fillChordTypeMap();
		fillKeySigMap();
		
	}
	
	public static MMNote findNote(String text) {
		if (!noteMap.containsKey(text.toUpperCase())) {
			throw new RuntimeException("No note found for :" + text);
		}
		return noteMap.get(text.toUpperCase());
	}
	
	public static MMChord findChord(String text) {
		if (!chordMap.containsKey(text.toUpperCase())) {
			throw new RuntimeException("No chord found for :" + text);
		}
		return chordMap.get(text.toUpperCase());
	}
	
	public static MMKeySig findKeySig(String text) {
		if (!keySigMap.containsKey(text.toUpperCase())) {
			throw new RuntimeException("No key sig found for :" + text);
		}
		return keySigMap.get(text.toUpperCase());
	}
	
	private static void fillNoteNameMap() {
		for (String note: noteArray) {
			for (String accidental: noteAccidentals) {
				StringBuilder sb = new StringBuilder();
				sb.append(note);

				if (!accidental.equals(" ")) {
					sb.append(accidental);
				}

				MMNote mmnote = constructNote(note, "5", accidental, "q");

				noteNameMap.put(sb.toString().toUpperCase(), mmnote);


			}
		}
		System.out.println("NoteNames : " + noteNameMap.size());
	}

	
	private static void fillNoteMap() {
		for (String note: noteArray) {
			for (String octave :  octaveStrings) {
				for (String accidental: noteAccidentals) {
					for (String duration : durationArray) {
						StringBuilder sb = new StringBuilder();
						sb.append(note);
						if (!octave.equals(" ")) {
							sb.append(octave);
						}
						if (!accidental.equals(" ")) {
							sb.append(accidental);
						}
						if (!duration.equals(" ")) {
							sb.append(duration);
						}
						
						MMNote mmnote = constructNote(note, octave, accidental, duration);
						
						noteMap.put(sb.toString().toUpperCase(), mmnote);
						
						
					}
				}
			}
		}
		System.out.println("Notes : " + noteMap.size());
	}


	private static void fillKeySigMap() {
		for (String note: noteArray) { 
			for (String accidental: chordAccidentals) {
				if (accidental.equals(" ")) {
					accidental = "";
				}
				for (String scale : new String[] {"MAJOR", "MINOR"}) {
					StringBuilder sb = new StringBuilder();
					sb.append(note);
					sb.append(accidental);
					sb.append(scale);
					Scale s = (scale.equals("MINOR")) ? Scale.MINOR : Scale.MAJOR;
					Note n = new Note(note + accidental);
					Key key = new Key(n, s);
					
					MMKeySig keySig = new MMKeySig(key);
					keySigMap.put(sb.toString().toUpperCase(), keySig);
				}
			}
		}
		
	}



	private static void fillChordMap() {
		for (String note: noteArray) {
			for (String octave :  octaveStrings) {
				for (String accidental: chordAccidentals) {
					for (String chordType: Chord.chordMap.keySet()) {
						for (String duration : durationArray) {
							StringBuilder sb = new StringBuilder();
							sb.append(note);
							if (!octave.equals(" ")) {
								sb.append(octave);
							}
							if (!accidental.equals(" ")) {
								sb.append(accidental);
							}
							sb.append(chordType);
							if (!duration.equals(" ")) {
								sb.append(duration);
							}
							
							MMChord mmchord = constructChord(note, octave, accidental, chordType, duration);
							
							
							chordMap.put(sb.toString().toUpperCase().toUpperCase(), mmchord);
						}
					}
				}
			}
		}
		System.out.println("Chords : " + chordMap.size());
	}


	private static void fillChordTypeMap() {

		for (String chordType: Chord.chordMap.keySet()) {

			StringBuilder sb = new StringBuilder();

			sb.append(chordType);


			MMChord mmchord = constructChord("C", "5", " ", chordType, "q");


			chordTypeMap.put(sb.toString().toUpperCase().toUpperCase(), mmchord);
		}
		System.out.println("ChordTypes : " + chordTypeMap.size());
	}
	
	private static MMChord constructChord(String note, String octave, String accidental, String chordType,
			String duration) {
		if (" ".equals(octave)) {
			octave = null;
		}
		if (" ".equals(accidental)) {
			accidental = null;
		}
		if (" ".contentEquals(duration)) {
			duration = null;
		}
		int num = MMNote.stringToMidiNum(note, accidental, octave);
		MMDuration bbdur= MMDuration.stringToDuration(duration);
		Note jfnote = new Note(num);
//		if (jfnote == null) {
//			throw new RuntimeException("No JFugue note for " + num);
//		}
		Chord jfchord = new Chord(jfnote, Chord.getIntervals(chordType));
		return new MMChord(MMDuration.ZERO, jfchord, bbdur);
	}


	private static MMNote constructNote(String note, String octave, String accidental, String duration) {
		if (" ".equals(octave)) {
			octave = null;
		}
		if (" ".equals(accidental)) {
			accidental = null;
		}
		if (" ".contentEquals(duration)) {
			duration = null;
		}
		String jfnoteS = note + (accidental == null ? "" : accidental);
		Note jfnote = new Note(jfnoteS);
//		if (jfnote == null) {
//			throw new RuntimeException("No JFugue note for " + jfnoteS);
//		}
		MMDuration bbdur= MMDuration.stringToDuration(duration);
		return new MMNote(MMDuration.ZERO, new Note(jfnote), bbdur);
	}

	private static String[] generateDurationArray() {
		String durationChars = durationCharsLC;
		return stringToArray(durationChars, " ");
	}

	private static String[] generateDurationArrayWithDot() {
		String durationChars = durationCharsLC;
		String[] charArray = stringToArray(durationChars);
		String[] durationArray = new String[2 * charArray.length + 1];
		int index = 0;
		for (String s : charArray) {
			for (String b:  new String[]{dot, ""}) {
				durationArray[index] = s + b;
				index++;
			}
		}
		durationArray[index] = " ";
		return durationArray;
		
	}


	


	private static String[] generateOctaveStrings() {
		int numOctaves = 12;
		String[] oct = new String[numOctaves + 1];
		for (int i = 0; i< numOctaves; i++) {
			oct[i] = "" + i;
		}
		oct[numOctaves] = " ";
		return oct;
	}


	private static String[] generateNoteArray() {
		return stringToArray(noteCharsUC);
	}

	private static String[] stringToArray(String string, String...additional) {
		String[] res = new String[string.length() + additional.length];
		for (int i = 0; i < string.length(); i++) {
				res[i] = Character.toString(string.charAt(i));
		}
		for (int i = 0; i < additional.length; i++) {
			res[i + string.length()] = additional[i];
		}
		return res;
	}

	public static List<String> getKeyStrings() {
		return new ArrayList<>(keySigMap.keySet());
	}
	
	public static List<String> getNoteStrings() {
		return new ArrayList<>(noteMap.keySet());
	}
	
	public static List<String> getNoteNameStrings() {
		return new ArrayList<>(noteNameMap.keySet());
	}
	
	public static List<String> getChordStrings() {
		return new ArrayList<>( chordMap.keySet());
	}
	
	public static List<String> getChordTypeStrings() {
		return new ArrayList<>( chordTypeMap.keySet());
	}
}
