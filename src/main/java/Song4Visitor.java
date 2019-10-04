import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import org.jfugue.theory.TimeSignature;

import shiva.metamusic.MMChord;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;
import shiva.metamusic.MMParallelNotes;
import shiva.metamusic.MMSong;
import shiva.metamusic.MMTemplatePhrase;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.MMTrack;
import shiva.song4.GenerateNoteChordTokens;
import shiva.song4.Song4Lexer;
import shiva.song4.Song4Parser;
import shiva.song4.Song4Parser.KeysigContext;
import shiva.song4.Song4Parser.ParallelNotesContext;
import shiva.song4.Song4Parser.ParallelNotesElementContext;
import shiva.song4.Song4Parser.PhraseDefContext;
import shiva.song4.Song4Parser.SongContext;
import shiva.song4.Song4Parser.TemplatePhraseContext;
import shiva.song4.Song4Parser.TemplatePhraseElementContext;
import shiva.song4.Song4Parser.TimeBookmarkContext;
import shiva.song4.Song4Parser.TimeRecallContext;
import shiva.song4.Song4Parser.TimeSetContext;
import shiva.song4.Song4Parser.TimesigContext;
import shiva.song4.Song4Parser.VoiceDefContext;
import shiva.song4.Song4Parser.VoicedPhraseContext;
import shiva.song4.Song4Parser.VoicedPhraseElementContext;
import shiva.song4.Song4ParserBaseVisitor;

public class Song4Visitor<T> extends Song4ParserBaseVisitor<T> {

	
	private enum State {
		IN_PHRASEDEF, IN_TEMPLATE_PHRASE, IN_VOICED_PHRASE, IN_PARALLEL_NOTES
	}
	
	private Song4Lexer lexer;

	private Song4Parser parser;
	
	
	
	Map<String, MMTemplatePhrase> templatePhraseMap = new LinkedHashMap<>();
	
	Map<String, MMDuration> timeBookmarkMap = new LinkedHashMap<>();
	
	MMSong song;
	
	String currentPhraseName;

	MMTemplatePhrase currentTemplatePhrase;
	
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
		String name = ctx.VOICEVAR().getText();
		String midiInstrumentName = ctx.INSTRUMENTNAME().getText().toUpperCase();
		//midiInstrumentName = midiInstrumentName.substring(2, midiInstrumentName.length()-1);
		MMTrack track = song.createTrack(name, midiInstrumentName);
		
		System.out.println("Voicedef: " + ctx.getText());
		T v =  super.visitVoiceDef(ctx);
		return v;
	}

	@Override
	public T visitPhraseDef(PhraseDefContext ctx) {
		currentPhraseName = ctx.PHRASETEMPLATEVAR().getText();
		stateStack.push(State.IN_PHRASEDEF);
		System.out.println("Phrasedef: " + ctx.getText());
		T v =  super.visitPhraseDef(ctx);
		stateStack.pop();
		
		return v;
	}

	@Override
	public T visitTemplatePhrase(TemplatePhraseContext ctx) {
		currentTemplatePhrase = new MMTemplatePhrase();
		stateStack.push(State.IN_TEMPLATE_PHRASE);
		System.out.println("Templatephrase: " + ctx.getText());
		T v =  super.visitTemplatePhrase(ctx);
		stateStack.pop();
		if (stateStack.peek() == State.IN_PHRASEDEF) {
			templatePhraseMap.put(currentPhraseName, currentTemplatePhrase);
		} else if (stateStack.peek() == State.IN_VOICED_PHRASE) {
			currentTrack.add(currentTemplatePhrase);
		}
		currentTemplatePhrase = null;
		currentPhraseName = null;
		return v;
	}

	
	@Override
	public T visitTemplatePhraseElement(TemplatePhraseElementContext ctx) {
		System.out.println("Templatephraseelement: " + ctx.getText());
		
		if (ctx.NOTE() != null) {
			System.out.println("Found NOTE: " + ctx.NOTE().getText());
			MMNote note = GenerateNoteChordTokens.findNote(ctx.NOTE().getText());
			currentTemplatePhrase.addItem(note);
		} else if (ctx.CHORD() != null) {
			System.out.println("Found CHORD: " + ctx.CHORD().getText());
			MMChord chord = GenerateNoteChordTokens.findChord(ctx.CHORD().getText());
			currentTemplatePhrase.addItem(chord);
		}
		T v =  super.visitTemplatePhraseElement(ctx);
		return v;
	}

	@Override
	public T visitParallelNotes(ParallelNotesContext ctx) {
		System.out.println("ParallelNotes: " + ctx.getText());
		currentParallelNotes = new MMParallelNotes(MMDuration.ZERO);
		stateStack.push(State.IN_PARALLEL_NOTES);
		
		T v =  super.visitParallelNotes(ctx);
		stateStack.pop();
		if (stateStack.peek() == State.IN_TEMPLATE_PHRASE) {
			currentTemplatePhrase.addItem(currentParallelNotes);
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
	public T visitVoicedPhrase(VoicedPhraseContext ctx) {
		System.out.println("Voicedphrase: " + ctx.getText());
		currentTrack = song.getTrack(ctx.VOICEVAR().getText());
		stateStack.push(State.IN_VOICED_PHRASE);
		T v = super.visitVoicedPhrase(ctx);
		stateStack.pop();
		return v;
	}

	//voicedphraseelement : templatephrase | PHRASETEMPLATEVAR | timeset | timerecall | timebookmark | BARMARKER ;

	@Override
	public T visitVoicedPhraseElement(VoicedPhraseElementContext ctx) {
		System.out.println("Voicedphraseelement: " + ctx.getText());
		if (ctx.PHRASETEMPLATEVAR() != null) {
			MMTemplatePhrase phrase = templatePhraseMap.get(ctx.PHRASETEMPLATEVAR().getText());
			currentTrack.add(phrase);
		} else if (ctx.BARMARKER() != null) {
			int pulseTime = currentTrack.getCurrentTime().getPulses();
			int pulsesPerbar = song.getTimeSig().getPulsesPerMeasure();
			int remainderPulses = pulseTime % pulsesPerbar;
			currentTrack.setTime(MMDuration.add(currentTrack.getCurrentTime(), new MMDuration(remainderPulses)));
		}
		
		T v = super.visitVoicedPhraseElement(ctx);
		
		return v;
	}

	@Override
	public T visitTimeBookmark(TimeBookmarkContext ctx) {
		System.out.println("TimeBookmark: " + ctx.getText());
		String tvar = ctx.TIMEVAR().getText();
		timeBookmarkMap.put(tvar, currentTrack.getCurrentTime());
		return super.visitTimeBookmark(ctx);
	}

	@Override
	public T visitTimeRecall(TimeRecallContext ctx) {
		System.out.println("TimeRecall: " + ctx.getText());
		String tvar = ctx.TIMEVAR().getText();
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
