import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import org.jfugue.theory.TimeSignature;

import shiva.metamusic.MMChord;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;
import shiva.metamusic.MMNotePhrase;
import shiva.metamusic.MMParallelNotes;
import shiva.metamusic.MMRhythmPhrase;
import shiva.metamusic.MMSong;
import shiva.metamusic.MMTempo;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.MMTrack;
import shiva.song4.GenerateNoteChordTokens;
import shiva.song4.Song4Lexer;
import shiva.song4.Song4Parser;
import shiva.song4.Song4Parser.KeysigContext;
import shiva.song4.Song4Parser.NotePhraseContext;
import shiva.song4.Song4Parser.NotePhraseElementContext;
import shiva.song4.Song4Parser.ParallelNotesContext;
import shiva.song4.Song4Parser.ParallelNotesElementContext;
import shiva.song4.Song4Parser.PhraseDefContext;
import shiva.song4.Song4Parser.RhythmPhraseContext;
import shiva.song4.Song4Parser.RhythmPhraseDefContext;
import shiva.song4.Song4Parser.RhythmPhraseElementContext;
import shiva.song4.Song4Parser.RhythmVoiceDefContext;
import shiva.song4.Song4Parser.SongContext;
import shiva.song4.Song4Parser.TempoContext;
import shiva.song4.Song4Parser.TimeBookmarkContext;
import shiva.song4.Song4Parser.TimeRecallContext;
import shiva.song4.Song4Parser.TimeSetContext;
import shiva.song4.Song4Parser.TimesigContext;
import shiva.song4.Song4Parser.VoiceDefContext;
import shiva.song4.Song4Parser.VoicedNotePhraseContext;
import shiva.song4.Song4Parser.VoicedNotePhraseElementContext;
import shiva.song4.Song4Parser.VoicedRhythmPhraseContext;
import shiva.song4.Song4Parser.VoicedRhythmPhraseElementContext;
import shiva.song4.Song4ParserBaseVisitor;

public class Song4Visitor<T> extends Song4ParserBaseVisitor<T> {

	
	private enum State {
		IN_PHRASEDEF, 
		IN_RHYTHMPHRASEDEF, 
		IN_NOTE_PHRASE, 
		IN_RHYTHM_PHRASE, 
		IN_VOICED_PHRASE, 
		IN_PARALLEL_NOTES, 
		IN_VOICED_RHYTHM_PHRASE
	}
	
	private Song4Lexer lexer;

	private Song4Parser parser;
	
	
	
	Map<String, MMNotePhrase> NotePhraseMap = new LinkedHashMap<>();
	
	Map<String, MMDuration> timeBookmarkMap = new LinkedHashMap<>();
	
	Map<String, Integer> rhythmNoteMap = new LinkedHashMap<>();
	
	Map<String, MMRhythmPhrase> rhythmPhraseMap = new LinkedHashMap<>();
	
	MMSong song;
	
	String currentPhraseName;
	
	String currentRhythmPhraseName;
	
	int currentRhythmNoteNum = -1;
	
	MMNotePhrase currentNotePhrase;
	
	MMRhythmPhrase currentRhythmPhrase;
	
	MMParallelNotes currentParallelNotes;
	
	MMTrack currentTrack;
	
	Stack<State> stateStack = new Stack<>();
	

	public Song4Visitor(Song4Lexer lexer, Song4Parser parser) {
		super();
		this.lexer = lexer;
		this.parser = parser;
	}

	@Override
	public T visitSong(SongContext ctx) {
		song = new MMSong();
		System.out.println("Song: " + ctx.getText());
		T v =  super.visitSong(ctx);
		return v;
	}

	
	@Override
	public T visitTempo(TempoContext ctx) {
		System.out.println("Tempo: " + ctx.getText());
		int bpm = Integer.parseInt(ctx.NUM().getText());
		MMTempo mmt = new MMTempo(bpm);
		song.setTempo(mmt);
		return super.visitTempo(ctx);
	}

	@Override
	public T visitKeysig(KeysigContext ctx) {
		MMKeySig keysig = GenerateNoteChordTokens.findKeySig(ctx.KEYSIG().getText());
		song.setKeySig(keysig);
		System.out.println("KeySig: " + ctx.KEYSIG().getText());
		T v =  super.visitKeysig(ctx);
		return v;
	}

	@Override
	public T visitTimesig(TimesigContext ctx) {
		MMTimeSig timesig = getMMTimeSig(ctx.NUM(0).getText(), ctx.NUM(1).getText());
		song.setTimeSig(timesig);
		System.out.println("TimeSig: " + ctx.getText());
		T v =  super.visitTimesig(ctx);
		return v;
	}

	private MMTimeSig getMMTimeSig(String numS, String denomS) {
		byte numerator = Byte.parseByte(numS);
		byte denominator = Byte.parseByte(denomS);
		TimeSignature timeSignature = new TimeSignature(numerator, denominator);
		MMTimeSig timeSig = new MMTimeSig(timeSignature);
		return timeSig;
	}

	@Override
	public T visitVoiceDef(VoiceDefContext ctx) {
		String name = ctx.VAR().getText();
		String midiInstrumentName = ctx.INSTRUMENTNAME().getText().toUpperCase();
		//midiInstrumentName = midiInstrumentName.substring(2, midiInstrumentName.length()-1);
		MMTrack track = song.createTrack(name, midiInstrumentName);
		
		System.out.println("Voicedef: " + ctx.getText());
		T v =  super.visitVoiceDef(ctx);
		return v;
	}

	
	@Override
	public T visitRhythmVoiceDef(RhythmVoiceDefContext ctx) {
		System.out.println("RhythmVoicedef: " + ctx.getText());
		String name = ctx.VAR().getText();
		String instrumentName = ctx.INSTRUMENTNAME().getText();
		int midiNoteNum = MMRhythmPhrase.getRhythmMidiNum(instrumentName);
		rhythmNoteMap.put(name, midiNoteNum);
		return super.visitRhythmVoiceDef(ctx);
	}

	@Override
	public T visitPhraseDef(PhraseDefContext ctx) {
		currentPhraseName = ctx.VAR().getText();
		stateStack.push(State.IN_PHRASEDEF);
		System.out.println("Phrasedef: " + ctx.getText());
		T v =  super.visitPhraseDef(ctx);
		stateStack.pop();
		
		return v;
	}

	@Override
	public T visitRhythmPhraseDef(RhythmPhraseDefContext ctx) {
		System.out.println("RhythmPhraseDef: " + ctx.getText());
		currentRhythmPhraseName = ctx.VAR().getText();
		stateStack.push(State.IN_RHYTHMPHRASEDEF);
		currentRhythmPhrase = new MMRhythmPhrase();
		T v = super.visitRhythmPhraseDef(ctx);
		stateStack.pop();
		return v;
	}
	
	@Override
	public T visitNotePhrase(NotePhraseContext ctx) {
		currentNotePhrase = new MMNotePhrase();
		stateStack.push(State.IN_NOTE_PHRASE);
		System.out.println("NotePhrase: " + ctx.getText());
		T v =  super.visitNotePhrase(ctx);
		stateStack.pop();
		if (ctx.NUM() != null) {
			int reps = Integer.parseInt(ctx.NUM().getText());
			currentNotePhrase = currentNotePhrase.repeat(reps);
		}
		if (stateStack.peek() == State.IN_PHRASEDEF) {
			NotePhraseMap.put(currentPhraseName, currentNotePhrase);
		} else if (stateStack.peek() == State.IN_VOICED_PHRASE) {
			currentTrack.add(currentNotePhrase);
		}
		currentNotePhrase = null;
		currentPhraseName = null;
		return v;
	}

	
	

	@Override
	public T visitRhythmPhrase(RhythmPhraseContext ctx) {
		System.out.println("RhythmPhrase: " + ctx.getText());
		currentRhythmPhrase = new MMRhythmPhrase();
		stateStack.push(State.IN_RHYTHM_PHRASE);
		T v = super.visitRhythmPhrase(ctx);
		stateStack.pop();
		if (ctx.NUM(0) != null) {
			int pulseDuration = Integer.parseInt(ctx.NUM(0).getText());
			currentRhythmPhrase.setNoteDuration(new MMDuration(pulseDuration));
		} else {
			currentRhythmPhrase.setNoteDuration(MMRhythmPhrase.DEFAULT_DURATION);
		}
		if (ctx.NUM(1) != null) {
			int reps = Integer.parseInt(ctx.NUM(1).getText());
			currentRhythmPhrase = currentRhythmPhrase.repeat(reps);
		}
		if (stateStack.peek() == State.IN_RHYTHMPHRASEDEF) {
			rhythmPhraseMap.put(currentRhythmPhraseName, currentRhythmPhrase);
		} else if (stateStack.peek() == State.IN_VOICED_RHYTHM_PHRASE) {
			currentTrack.add(currentRhythmPhrase, currentRhythmNoteNum);
		}
		currentRhythmPhrase = null;
		currentRhythmPhraseName = null;
		return v;
	}

	@Override
	public T visitNotePhraseElement(NotePhraseElementContext ctx) {
		System.out.println("NotePhraseelement: " + ctx.getText());
		
		if (ctx.NOTE() != null) {
			System.out.println("Found NOTE: " + ctx.NOTE().getText());
			MMNote note = GenerateNoteChordTokens.findNote(ctx.NOTE().getText());
			currentNotePhrase.addItem(note);
		} else if (ctx.CHORD() != null) {
			System.out.println("Found CHORD: " + ctx.CHORD().getText());
			MMChord chord = GenerateNoteChordTokens.findChord(ctx.CHORD().getText());
			currentNotePhrase.addItem(chord);
		}
		T v =  super.visitNotePhraseElement(ctx);
		return v;
	}

	@Override
	public T visitRhythmPhraseElement(RhythmPhraseElementContext ctx) {
		System.out.println("RhythmPhraseElement: " + ctx.getText());
		if (ctx.PLUS() != null) {
			currentRhythmPhrase.add(true);
		} else if (ctx.MINUS() != null) {
			currentRhythmPhrase.add(false);
		}
		T v = super.visitRhythmPhraseElement(ctx);
		return v;
	}

	@Override
	public T visitParallelNotes(ParallelNotesContext ctx) {
		System.out.println("ParallelNotes: " + ctx.getText());
		currentParallelNotes = new MMParallelNotes(MMDuration.ZERO);
		stateStack.push(State.IN_PARALLEL_NOTES);
		
		T v =  super.visitParallelNotes(ctx);
		stateStack.pop();
		if (stateStack.peek() == State.IN_NOTE_PHRASE) {
			currentNotePhrase.addItem(currentParallelNotes);
		} else if (stateStack.peek() == State.IN_VOICED_PHRASE) {
			currentTrack.add(currentParallelNotes);
			currentParallelNotes = null;
		}
		return v;
	}

	
	@Override
	public T visitParallelNotesElement(ParallelNotesElementContext ctx) {
		System.out.println("parallelNoteselement: " + ctx.getText());
		MMNote note = GenerateNoteChordTokens.findNote(ctx.NOTE().getText());
		currentParallelNotes.addNote(note);
		T v = super.visitParallelNotesElement(ctx);
		return v;
	}

	@Override
	public T visitVoicedNotePhrase(VoicedNotePhraseContext ctx) {
		System.out.println("VoicedNotePhrase: " + ctx.getText());
		if (ctx.VAR() != null) {
			currentTrack = song.getTrack(ctx.VAR().getText());
		} else {
			currentTrack = song.getDefaultTrack();
		}
		stateStack.push(State.IN_VOICED_PHRASE);
		T v = super.visitVoicedNotePhrase(ctx);
		stateStack.pop();
		currentTrack = null;
		return v;
	}

	
	@Override
	public T visitVoicedRhythmPhrase(VoicedRhythmPhraseContext ctx) {
		System.out.println("VoicedRhythmphrase: " + ctx.getText());
		if (ctx.VAR() != null) {
			currentRhythmNoteNum = rhythmNoteMap.get(ctx.VAR().getText());
			currentTrack = song.getPercussionTrack().getTrack(currentRhythmNoteNum, ctx.VAR().getText());
			
		} else {
			currentRhythmNoteNum = MMRhythmPhrase.DEFAULT_PERCUSSION_NOTE;
			currentTrack = song.getPercussionTrack().getDefaultTrack();
		}
		stateStack.push(State.IN_VOICED_RHYTHM_PHRASE);
		
		T v = super.visitVoicedRhythmPhrase(ctx);
		stateStack.pop();
		currentRhythmNoteNum = -1;
		currentTrack = null;
		return v;
	}
	
	
	//NoicedNotePhraseelement : NotePhrase | PHRASETEMPLATEVAR | timeset | timerecall | timebookmark | BARMARKER ;

	

	@Override
	public T visitVoicedNotePhraseElement(VoicedNotePhraseElementContext ctx) {
		System.out.println("VoicedNotePhraseelement: " + ctx.getText());
		if (ctx.VAR() != null) {
			MMNotePhrase phrase = NotePhraseMap.get(ctx.VAR().getText());
			currentTrack.add(phrase);
		} else if (ctx.BARMARKER() != null) {
			int pulseTime = currentTrack.getCurrentTime().getPulses();
			int pulsesPerbar = song.getTimeSig().getPulsesPerMeasure();
			int remainderPulses = pulseTime % pulsesPerbar;
			currentTrack.setTime(MMDuration.add(currentTrack.getCurrentTime(), new MMDuration(remainderPulses)));
		}
		
		T v = super.visitVoicedNotePhraseElement(ctx);
		
		return v;
	}

	
	
	@Override
	public T visitVoicedRhythmPhraseElement(VoicedRhythmPhraseElementContext ctx) {
		System.out.println("VoicedRhythmPhraseelement: " + ctx.getText());
		if (ctx.VAR() != null) {
			MMRhythmPhrase phrase = rhythmPhraseMap.get(ctx.VAR().getText());
			int midiNoteNum = rhythmNoteMap.get(ctx.VAR().getText());
			currentTrack.add(phrase, midiNoteNum);
		} else if (ctx.BARMARKER() != null) {
			int pulseTime = currentTrack.getCurrentTime().getPulses();
			int pulsesPerbar = song.getTimeSig().getPulsesPerMeasure();
			int remainderPulses = pulseTime % pulsesPerbar;
			currentTrack.setTime(MMDuration.add(currentTrack.getCurrentTime(), new MMDuration(remainderPulses)));
		}
		T v = super.visitVoicedRhythmPhraseElement(ctx);
		return v;
	}

	@Override
	public T visitTimeBookmark(TimeBookmarkContext ctx) {
		System.out.println("TimeBookmark: " + ctx.getText());
		String tvar = ctx.VAR().getText();
		timeBookmarkMap.put(tvar, currentTrack.getCurrentTime());
		return super.visitTimeBookmark(ctx);
	}

	@Override
	public T visitTimeRecall(TimeRecallContext ctx) {
		System.out.println("TimeRecall: " + ctx.getText());
		String tvar = ctx.VAR().getText();
		MMDuration time = timeBookmarkMap.get(tvar);
		if (time == null) {
			throw new RuntimeException("Unknown time var : " + tvar);
		}
		currentTrack.setTime(time);
		return super.visitTimeRecall(ctx);
	}

	@Override
	public T visitTimeSet(TimeSetContext ctx) {
		System.out.println("TimeSet: " + ctx.getText());
		int bars = Integer.parseInt(ctx.NUM(0).getText());
		int pulses = Integer.parseInt(ctx.NUM(1).getText());
		int totalPulses = bars * song.getTimeSig().getPulsesPerMeasure() + pulses;
		currentTrack.setTime(new MMDuration(totalPulses));
		
		return super.visitTimeSet(ctx);
	}
	
	

}
