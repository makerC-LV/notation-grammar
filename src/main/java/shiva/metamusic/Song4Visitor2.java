package shiva.metamusic;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.jfugue.theory.TimeSignature;

import shiva.song4.Song4Parser.AssignableContext;
import shiva.song4.Song4Parser.GroupedNotesContext;
import shiva.song4.Song4Parser.GroupedRhythmContext;
import shiva.song4.Song4Parser.KeysigContext;
import shiva.song4.Song4Parser.NotesContext;
import shiva.song4.Song4Parser.NotesElementContext;
import shiva.song4.Song4Parser.ParallelNotesContext;
import shiva.song4.Song4Parser.ParallelNotesElementContext;
import shiva.song4.Song4Parser.PlayCommandContext;
import shiva.song4.Song4Parser.PlayableContext;
import shiva.song4.Song4Parser.RhythmContext;
import shiva.song4.Song4Parser.RhythmElementContext;
import shiva.song4.Song4Parser.SongContext;
import shiva.song4.Song4Parser.SongElementContext;
import shiva.song4.Song4Parser.TempoContext;
import shiva.song4.Song4Parser.TimeBookmarkContext;
import shiva.song4.Song4Parser.TimeRecallContext;
import shiva.song4.Song4Parser.TimeSetContext;
import shiva.song4.Song4Parser.TimesigContext;
import shiva.song4.Song4Parser.VarDefContext;
import shiva.song4.Song4Parser.VoiceContext;
import shiva.song4.Song4ParserBaseVisitor;
import shiva.song4.Song4SpecialTokenParser;
import shiva.song4.Song4SpecialTokenParser.SpecialToken;

public class Song4Visitor2<T> extends Song4ParserBaseVisitor<T> {
	
	

	private Stack<ParserRuleContext> contextStack = new Stack<>();
	private Stack<Notes> notesStack = new Stack<>();
	private Stack<MMRhythm> rhythmStack = new Stack<>();
	private ISongElement currentSongElement;
//	private IPlayable currentPlayable;
	private ParallelNotes currentParallelNotes;
	
//	Song4Lexer lexer;
//	Song4Parser parser;
	
	Song song;
	
	
	public Song4Visitor2() {
		super();
		
	}
	
	public Song getSong() {
		return song;
	}
	
	@Override
	public T visitSong(SongContext ctx) {
		contextStack.push(ctx);
		song = new Song();
		T v =  super.visitSong(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitSongElement(SongElementContext ctx) {
		//System.out.println("SongElement: " + ctx.getText());
		contextStack.push(ctx);
		T v =  super.visitSongElement(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitPlayCommand(PlayCommandContext ctx) {
		contextStack.push(ctx);
		currentSongElement = new PlayCommand();
		T v =  super.visitPlayCommand(ctx);
		song.add(currentSongElement);
		currentSongElement = null;
		contextStack.pop();
		return v;
	}
	@Override
	public T visitPlayable(PlayableContext ctx) {
		contextStack.push(ctx);
		T v =  super.visitPlayable(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitVarDef(VarDefContext ctx) {
		contextStack.push(ctx);
		String varName = ctx.VAR().getText();
		currentSongElement = new VarDef(varName, null);
		T v =  super.visitVarDef(ctx);
		song.add(currentSongElement); 
		currentSongElement = null;
		contextStack.pop();
		return v;
	}
	@Override
	public T visitAssignable(AssignableContext ctx) {
		contextStack.push(ctx);
		T v = super.visitAssignable(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitVoice(VoiceContext ctx) {
		contextStack.push(ctx);
		Voice inst = null;
		if (ctx.INSTRUMENTNAME() != null) {
			inst = new Voice(ctx.INSTRUMENTNAME().getText(), false);
		
		} else if (ctx.DRUMNAME() != null) {
			inst = new Voice(ctx.DRUMNAME().getText(), true);
		}
		T v =  super.visitVoice(ctx);
		if (inst != null) {
			VarDef def = (VarDef) currentSongElement;
			def.setAssignable(inst);
		}
		contextStack.pop();
		return v;
	}
	@Override
	public T visitNotes(NotesContext ctx) {
		ParserRuleContext context = contextStack.peek();
		contextStack.push(ctx);
		boolean inGroupedNotes = context instanceof GroupedNotesContext;
		if (!inGroupedNotes) {
			Notes notes = new Notes(1);
			notesStack.push(notes);
		}
		T v = super.visitNotes(ctx);
		Notes notes = notesStack.peek();
		if (!inGroupedNotes) {
			notesStack.pop();
		}
		
		if (context instanceof PlayableContext) {
			PlayCommand pc = (PlayCommand) currentSongElement;
			pc.add(notes);
		} else if (context instanceof AssignableContext) {
			VarDef def = (VarDef) currentSongElement;
			def.setAssignable(notes);
		} else if (context instanceof GroupedNotesContext) {
			// do nothing
		}
		
		contextStack.pop();
		return v;
	}
	
	@Override
	public T visitNotesElement(NotesElementContext ctx) {
		contextStack.push(ctx);
		Notes notes = notesStack.peek();
		if (ctx.NOTE() != null) {
			SpecialToken st = Song4SpecialTokenParser.getSpecialToken(ctx.NOTE().getText());
			notes.add(st.mmnote);
		} else if (ctx.CHORD() != null) {
			SpecialToken st = Song4SpecialTokenParser.getSpecialToken(ctx.CHORD().getText());
			notes.add(st.mmchord);
		} else if (ctx.BARMARKER() != null) {
			notes.add(new BarMarker());
		} else if (ctx.VOICE() != null) {
			Var var = new Var(ctx.VAR().getText());
			notes.add(var);
		}
		T v =  super.visitNotesElement(ctx);
		contextStack.pop();
		return v;
	}
	
	@Override
	public T visitGroupedNotes(GroupedNotesContext ctx) {
		contextStack.push(ctx);
		int reps = ctx.NUM() == null ? 1 : Integer.parseInt(ctx.NUM().getText());
		Notes notes = new Notes(reps);
		notesStack.push(notes);
		T v = super.visitGroupedNotes(ctx);
		notesStack.pop();
		Notes parentNotes = notesStack.peek();
		parentNotes.add(notes);
		contextStack.pop();
		return v;
	}
	
	@Override
	public T visitRhythm(RhythmContext ctx) {
		ParserRuleContext context = contextStack.peek();
		boolean inGroupedRhythm = context instanceof GroupedRhythmContext;
		if (!inGroupedRhythm) {
			contextStack.push(ctx);
			MMRhythm rhythm = new MMRhythm(1);
			rhythmStack.push(rhythm);
		}

		T v =  super.visitRhythm(ctx);
		MMRhythm rhythm = rhythmStack.peek();
		if (!inGroupedRhythm) {
			rhythmStack.pop();
		}
		if (context instanceof PlayableContext) {
			PlayCommand pc = (PlayCommand) currentSongElement;
			pc.add(rhythm);
		} else if (context instanceof AssignableContext) {
			VarDef def = (VarDef) currentSongElement;
			def.setAssignable(rhythm);
		} else if (context instanceof GroupedRhythmContext) {
			// do nothing
		}
		
		return v;
	}
	@Override
	public T visitRhythmElement(RhythmElementContext ctx) {
		contextStack.push(ctx);
		MMRhythm rhythm = rhythmStack.peek();
		if (ctx.PLUS() != null) {
			rhythm.add(new DrumBeat(true));
		} else if (ctx.MINUS() != null) {
			rhythm.add(new DrumBeat(false));
		} else if (ctx.BARMARKER() != null) {
			rhythm.add(new BarMarker());
		} else if (ctx.DRUM() != null) {
			Var var = new Var(ctx.VAR().getText());
			rhythm.add(var);
		} else if (ctx.NUM() != null) {
			rhythm.add(new BeatChange(Integer.parseInt(ctx.NUM().getText())));
		}
		
		T v =  super.visitRhythmElement(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitGroupedRhythm(GroupedRhythmContext ctx) {
		contextStack.push(ctx);
		int reps = ctx.NUM() == null ? 1 : Integer.parseInt(ctx.NUM().getText());
		MMRhythm rhythm = new MMRhythm(reps);
		rhythmStack.push(rhythm);
		T v = super.visitGroupedRhythm(ctx);
		rhythmStack.pop();
		MMRhythm parentRhythm = rhythmStack.peek();
		parentRhythm.add(rhythm);
		contextStack.pop();
		return v;
	}
	
	
	@Override
	public T visitTempo(TempoContext ctx) {
		contextStack.push(ctx);
		int bpm = Integer.parseInt(ctx.NUM().getText());
		MMTempo mmt = new MMTempo(bpm);
		song.setTempo(mmt);
		T v =  super.visitTempo(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitKeysig(KeysigContext ctx) {
		contextStack.push(ctx);
		SpecialToken st = Song4SpecialTokenParser.getSpecialToken(ctx.KEYSIG().getText());
		song.setKeySig(st.mmkeysig);
		T v =  super.visitKeysig(ctx);
		contextStack.pop();
		return v;
	}
	
	@Override
	public T visitTimesig(TimesigContext ctx) {
		contextStack.push(ctx);
		MMTimeSig timesig = getMMTimeSig(ctx.NUM(0).getText(), ctx.NUM(1).getText());
		song.setTimeSig(timesig);
		T v =  super.visitTimesig(ctx);
		contextStack.pop();
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
	public T visitParallelNotes(ParallelNotesContext ctx) {
		contextStack.push(ctx);
		currentParallelNotes = new ParallelNotes(MMDuration.ZERO);
		T v =  super.visitParallelNotes(ctx);
		notesStack.peek().add(currentParallelNotes);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitParallelNotesElement(ParallelNotesElementContext ctx) {
		contextStack.push(ctx);
		SpecialToken st = Song4SpecialTokenParser.getSpecialToken(ctx.NOTE().getText());
		currentParallelNotes.addNote(st.mmnote);
		T v =  super.visitParallelNotesElement(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitTimeBookmark(TimeBookmarkContext ctx) {
		contextStack.push(ctx);
		TimeBookmark bm = new TimeBookmark(ctx.VAR().getText());
		PlayCommand pc = (PlayCommand) currentSongElement;
		pc.add(bm);
		T v =  super.visitTimeBookmark(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitTimeRecall(TimeRecallContext ctx) {
		contextStack.push(ctx);
		TimeRecall tr = new TimeRecall(ctx.VAR().getText());
		PlayCommand pc = (PlayCommand) currentSongElement;
		pc.add(tr);
		T v =  super.visitTimeRecall(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitTimeSet(TimeSetContext ctx) {
		contextStack.push(ctx);
		int bars = Integer.parseInt(ctx.NUM(0).getText());
		int pulses = Integer.parseInt(ctx.NUM(1).getText());
		int totalPulses = bars * song.getTimeSig().getPulsesPerMeasure() + pulses;
		TimeSet ts = new TimeSet(new MMDuration(totalPulses), "" + bars, "" + pulses);
		PlayCommand pc = (PlayCommand) currentSongElement;
		pc.add(ts);
		T v =  super.visitTimeSet(ctx);
		contextStack.pop();
		return v;
	}
	
	
	
	
	
	
	

}
