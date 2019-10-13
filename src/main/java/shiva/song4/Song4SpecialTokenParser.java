package shiva.song4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jfugue.midi.MidiDefaults;
import org.jfugue.midi.MidiDictionary;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Intervals;
import org.jfugue.theory.Key;
import org.jfugue.theory.Note;
import org.jfugue.theory.Scale;

import shiva.metamusic.MMChord;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;

public class Song4SpecialTokenParser {
	
	private static final Comparator<String> LONGEST_FIRST = (s1, s2) -> s2.length() - s1.length();
	
	private static final String noteNames = "CDEFGABR";
	private static final String noteAccidentals = "#BN";
	private static final String chordNames = "CDEFGAB";
	private static final String chordAccidentals = "#B";
	private static final String durations = "WHQISTXO"; 
	
	static private Pattern chordPattern;
	static private Pattern notePattern;
	static private Pattern keySigPattern;
	static private List<String> instrumentNames;
	static private List<String> drumNames;
	
	static {
		chordPattern = Pattern.compile(buildChordPatternString());
		notePattern = Pattern.compile(buildNotePatternString());
		keySigPattern = Pattern.compile(buildKeySigPatternString());
		instrumentNames = buildInstrumentNames();
		drumNames = buildDrumNames();
	}
	
	public static final int NOTENAME = 1;
	public static final int CHORDNAME = 1;
	public static final int ACCIDENTAL = 2;
	public static final int OCTAVE = 3;
	public static final int NOTEDURATION = 4;
	public static final int CHORDTYPE = 4;
	public static final int CHORDDURATION = 5;
	
	public static SpecialToken getSpecialToken(String word) {
		SpecialToken token = new SpecialToken();
		String ucWord = word.toUpperCase();
		Matcher m = chordPattern.matcher(ucWord);
		if (m.matches()) {
			token.tokenId = Song4Lexer.CHORD;
			token.setChord(m.group(CHORDNAME), m.group(ACCIDENTAL), m.group(OCTAVE), m.group(CHORDTYPE), m.group(CHORDDURATION));
			return token;
		}
		m = notePattern.matcher(ucWord);
		if (m.matches()) {
			token.tokenId = Song4Lexer.NOTE;
			token.setNote(m.group(NOTENAME), m.group(ACCIDENTAL), m.group(OCTAVE), m.group(NOTEDURATION));
			return token;
		}
		m = keySigPattern.matcher(ucWord);
		if (m.matches()) {
			token.tokenId = Song4Lexer.KEYSIG;
			token.setKeySig(m.group(NOTENAME), m.group(ACCIDENTAL), m.group(3));
			return token;
		}
		if (instrumentNames.contains(ucWord)) {
			token.tokenId = Song4Lexer.INSTRUMENTNAME;
			token.instrumentName = ucWord;
			return token;
		}
		if (drumNames.contains(ucWord)) {
			token.tokenId = Song4Lexer.DRUMNAME;
			token.instrumentName = ucWord;
			return token;
		}
		return null;
	}
	
	private static List<String> buildInstrumentNames() {
		List<String> names = new ArrayList<>();
		names.addAll(MidiDictionary.INSTRUMENT_STRING_TO_BYTE.keySet());
		return names;
	}

	private static List<String> buildDrumNames() {
		List<String> names = new ArrayList<>();
		names.addAll(Arrays.asList(Note.PERCUSSION_NAMES));
		return names;
	}
	
	private static String buildKeySigPatternString() {
		String noteNameString = buildAlternativesString(noteNames);
		String accidentalString = buildAlternativesString(chordAccidentals);
		String chordString = "(MAJOR|MINOR)";
		String keySigString = 
				noteNameString 
				+ accidentalString + "?" 
				+ chordString;
		return keySigString;
				
	}
	
	private static String buildNotePatternString() {
		String noteNameString = buildAlternativesString(noteNames);
		String octaveString = buildOctaveString();
		String accidentalString = buildAlternativesString(noteAccidentals);
		String durationString = buildAlternativesString(durations);
		
		String noteString = noteNameString 
				+ accidentalString + "?" 
				+ octaveString + "?" 
				+ durationString + "?";
		
		return noteString;
	}
	private static String buildChordPatternString() {
		String chordNameString = buildAlternativesString(chordNames);
		String accidentalString = buildAlternativesString(chordAccidentals);
		String octaveString = buildOctaveString();
		String chordTypeString = buildChordTypeString();
		String durationString = buildAlternativesString(durations);
		
		String chordString = chordNameString 
				+ accidentalString + "?" 
				+ octaveString + "?" 
				+ chordTypeString
				+ durationString + "?";
		
		return chordString;
	}
	
	private static String buildOctaveString() {
		int numOctaves = 12;
		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
		boolean first = true;
		for (int i = 0; i < numOctaves; i++) {
			if (!first) {
				sb.append("|");
			}
			first = false;
			sb.append(i);
			
		}
		sb.append(")");
		String s = sb.toString();
		//System.out.println(s);
		return s;
	}

	
	
	

	private static String buildAlternativesString(String root) {
		String[] names = stringToArray(root);
		
		return buildAlternativesString(names);
	}

	private static String buildAlternativesString(String[] names) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
		boolean first = true;
		for (String type: names) {
			if (!first) {
				sb.append("|");
			}
			first = false;
			sb.append(type);
			
		}
		sb.append(")");
		String s = sb.toString();
		//System.out.println(s);
		return s;
	}
	
	
	private static String buildChordTypeString() {
		List<String> types = new ArrayList<>(Chord.chordMap.keySet());
		types.sort(LONGEST_FIRST);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("(");
		boolean first = true;
		for (String type: types) {
			if (!first) {
				sb.append("|");
			}
			first = false;
			sb.append(type);
			
		}
		sb.append(")");
		String s = sb.toString();
//		System.out.println(s);
		return s;
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
	
	public static void main2(String[] args) {
		Pattern pat = Pattern.compile(buildChordPatternString());
		Matcher m = pat.matcher("CMAJ");
		if (m.find()) {
			System.out.println("Found value: " + m.group(0) );
			for (int i = 0; i <= m.groupCount(); i++) {
				System.out.println("Found value: " + m.group(i) );
				
			}
		}
	}
	
	public static void main(String[] args) {
		Note n = new Note("C#6w");
		System.out.println(n + "  " + n.getDuration());
	}
	
	public static class SpecialToken {
		public int tokenId;
		public MMNote mmnote;
		public MMChord mmchord;
		public MMKeySig mmkeysig;
		public String instrumentName;
		public String drumName;
		
		public void setChord(String note, String accidental, String octave, String chordType, String duration) {
			if (accidental == null) {
				accidental = "";
			}
			if (octave == null) {
				octave = "";
			}
			if (duration == null) {
				duration = "";
			}
			Note n = new Note(note + accidental + octave + duration);
			Intervals intervals = Chord.getIntervals(chordType);
			Chord c = new Chord(n, intervals);
			mmchord = new MMChord(MMDuration.ZERO, c, MMDuration.stringToDuration(duration));
		}
		
		public void setKeySig(String note, String accidental, String majorOrMinor) {
			if (accidental == null) {
				accidental = "";
			}
			Note root = new Note(note+accidental);
			Scale scale = majorOrMinor.equals("MAJOR") ? 
					MMKeySig.createScale(Scale.MAJOR) : 
						MMKeySig.createScale(Scale.MINOR) ;
			Key key = new Key(root, scale);
			
			mmkeysig = new MMKeySig(key);
			
		}
		public void setNote(String note, String accidental, String octave, String duration) {
			if (accidental == null) {
				accidental = "";
			}
			if (octave == null) {
				octave = "";
			}
			if (duration == null) {
				duration = "";
			}
			Note n = new Note(note + accidental + octave + duration);
			mmnote = new MMNote(MMDuration.ZERO, n, MMDuration.stringToDuration(duration));
			
		}
		
		
	}

}
