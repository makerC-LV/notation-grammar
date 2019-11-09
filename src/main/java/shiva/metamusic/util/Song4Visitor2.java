package shiva.metamusic.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.jfugue.theory.TimeSignature;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import shiva.metamusic.BarMarker;
import shiva.metamusic.BeatChange;
import shiva.metamusic.DrumBeat;
import shiva.metamusic.INotesElement;
import shiva.metamusic.IRhythmElement;
import shiva.metamusic.ISongElement;
import shiva.metamusic.Location;
import shiva.metamusic.MMChord;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMDynamics;
import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;
import shiva.metamusic.MMRhythm;
import shiva.metamusic.MMTempo;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.Notes;
import shiva.metamusic.ParallelNotes;
import shiva.metamusic.PlayCommand;
import shiva.metamusic.Song;
import shiva.metamusic.TimeBookmark;
import shiva.metamusic.TimeRecall;
import shiva.metamusic.TimeSet;
import shiva.metamusic.Var;
import shiva.metamusic.VarDef;
import shiva.metamusic.Voice;
import shiva.song4.Song4Parser.AssignableContext;
import shiva.song4.Song4Parser.BeatContext;
import shiva.song4.Song4Parser.ChordContext;
import shiva.song4.Song4Parser.DrumChangeContext;
import shiva.song4.Song4Parser.GroupedNotesContext;
import shiva.song4.Song4Parser.GroupedRhythmContext;
import shiva.song4.Song4Parser.KeysigContext;
import shiva.song4.Song4Parser.NoteContext;
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
import shiva.song4.Song4Parser.VoiceChangeContext;
import shiva.song4.Song4Parser.VoiceContext;
import shiva.song4.Song4ParserBaseVisitor;
import shiva.song4.Song4SpecialTokenParser;
import shiva.song4.Song4SpecialTokenParser.SpecialToken;

public class Song4Visitor2<T> extends Song4ParserBaseVisitor<T> {
	
	

	private Stack<ParserRuleContext> contextStack = new Stack<>();
	private Stack<Notes> notesStack = new Stack<>();
	private Stack<MMRhythm> rhythmStack = new Stack<>();
	private ISongElement currentSongElement;
	private ParallelNotes currentParallelNotes;
	
	// For scripts
	private List<VarDef> varDefs = new ArrayList<>();
	
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
		VarDef vd  = new VarDef(varName, null, getLocation(ctx));
		currentSongElement = vd;
		varDefs.add(vd);
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
		Location loc = getLocation(ctx);
		Voice inst = null;
		if (ctx.INSTRUMENTNAME() != null) {
			inst = new Voice(ctx.INSTRUMENTNAME().getText(), false, loc);
		
		} else if (ctx.DRUMNAME() != null) {
			inst = new Voice(ctx.DRUMNAME().getText(), true, loc);
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
		Location loc = getLocation(ctx);
		if (ctx.DYNAMICS() != null) {
			notes.add(new MMDynamics(ctx.DYNAMICS().getText().substring(1), loc));
		} else if (ctx.BARMARKER() != null) {
			notes.add(new BarMarker(loc));
		} else if (ctx.VAR() != null) {
			Var var = new Var(ctx.VAR().getText(), loc);
			notes.add(var);
		} else if (ctx.SCRIPT() != null) {
			INotesElement scriptVal = (INotesElement) evaluateGroovy(ctx.getText());
			notes.add(scriptVal);
		}
		T v =  super.visitNotesElement(ctx);
		contextStack.pop();
		return v;
	}
	
	
	@Override
	public T visitVoiceChange(VoiceChangeContext ctx) {
		contextStack.push(ctx);
		Notes notes = notesStack.peek();
		if (ctx.VAR() != null) {
			Var var = new Var(ctx.VAR().getText(), getLocation(ctx));
			notes.add(var);
		}
		T v =  super.visitVoiceChange(ctx);
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
	public T visitNote(NoteContext ctx) {
		contextStack.push(ctx);
		Notes notes = notesStack.peek();
		if (ctx.NOTE() != null) {
			SpecialToken st = Song4SpecialTokenParser.getSpecialToken(ctx.NOTE().getText());
			MMNote mmnote = (MMNote) st.mmnote.copy();
			mmnote.setLocation(getLocation(ctx));
			int accent = ctx.ACCENT() != null ? ctx.ACCENT().size() :
				(ctx.ANTIACCENT() != null ? - ctx.ANTIACCENT().size() : 0);
			mmnote.accent(accent);
			notes.add(mmnote);
		}
		T v = super.visitNote(ctx);
		contextStack.pop();
		return v;
	}

	@Override
	public T visitChord(ChordContext ctx) {
		contextStack.push(ctx);
		Notes notes = notesStack.peek();
		if (ctx.CHORD() != null) {
			SpecialToken st = Song4SpecialTokenParser.getSpecialToken(ctx.CHORD().getText());
			MMChord mmchord = (MMChord) st.mmchord.copy();
			mmchord.setLocation(getLocation(ctx));
			int accent = ctx.ACCENT() != null ? ctx.ACCENT().size() :
				(ctx.ANTIACCENT() != null ? - ctx.ANTIACCENT().size() : 0);
			
			mmchord.accent(accent);
			
			notes.add(mmchord);
		}
		T v = super.visitChord(ctx);
		contextStack.pop();
		return v;
	}

	@Override
	public T visitBeat(BeatContext ctx) {
		contextStack.push(ctx);
		Location loc = getLocation(ctx);
		MMRhythm rhythm = rhythmStack.peek();
		int accent = ctx.ACCENT() != null ? ctx.ACCENT().size() :
			(ctx.ANTIACCENT() != null ? - ctx.ANTIACCENT().size() : 0);
		DrumBeat db = null;;
		if (ctx.BEAT() != null) {
			db = new DrumBeat(true, loc);
			db.accent(accent);
		} else if (ctx.ACCENTED_BEAT() != null) {
			db = new DrumBeat(true, loc);
			db.accent(1);
		} else if (ctx.FLAM() != null) {
			db = new DrumBeat(true, loc);
			db.accent(accent);
			db.setFlam(true);
		} else if (ctx.MINUS() != null) {
			db = new DrumBeat(false, loc);
		} 
		if (db != null) {
			rhythm.add(db);
		}
		T v = super.visitBeat(ctx);
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
		Location loc = getLocation(ctx);
		if (ctx.DYNAMICS() != null) {
			rhythm.add(new MMDynamics(ctx.DYNAMICS().getText().substring(1), loc));
		} else if (ctx.BARMARKER() != null) {
			rhythm.add(new BarMarker(loc));
		} else if (ctx.VAR() != null) {
			Var var = new Var(ctx.VAR().getText(), loc);
			rhythm.add(var);
		} else if (ctx.NUM() != null) {
			rhythm.add(new BeatChange(Integer.parseInt(ctx.NUM().getText()), loc));
		} else if (ctx.SCRIPT() != null) {
			IRhythmElement scriptVal = (IRhythmElement) evaluateGroovy(ctx.getText());
			rhythm.add(scriptVal);
		}
		
		T v =  super.visitRhythmElement(ctx);
		contextStack.pop();
		return v;
	}
	
	
	

	@Override
	public T visitDrumChange(DrumChangeContext ctx) {
		contextStack.push(ctx);
		MMRhythm rhythm = rhythmStack.peek();
		if (ctx.VAR() != null) {
			Var var = new Var(ctx.VAR().getText(), getLocation(ctx));
			rhythm.add(var);
		}
		T v =  super.visitDrumChange(ctx);
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
		MMTempo mmt = new MMTempo(bpm, getLocation(ctx));
		song.setTempo(mmt);
		T v =  super.visitTempo(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitKeysig(KeysigContext ctx) {
		contextStack.push(ctx);
		SpecialToken st = Song4SpecialTokenParser.getSpecialToken(ctx.KEYSIG().getText());
		
		song.setKeySig(new MMKeySig(st.mmkeysig.getKey(), getLocation(ctx)));
		T v =  super.visitKeysig(ctx);
		contextStack.pop();
		return v;
	}
	
	@Override
	public T visitTimesig(TimesigContext ctx) {
		contextStack.push(ctx);
		MMTimeSig timesig = getMMTimeSig(ctx.NUM(0).getText(), ctx.NUM(1).getText(), getLocation(ctx));
		song.setTimeSig(timesig);
		T v =  super.visitTimesig(ctx);
		contextStack.pop();
		return v;
	}
	
	private MMTimeSig getMMTimeSig(String numS, String denomS, Location loc) {
		
		byte numerator = Byte.parseByte(numS);
		byte denominator = Byte.parseByte(denomS);
		TimeSignature timeSignature = new TimeSignature(numerator, denominator);
		MMTimeSig timeSig = new MMTimeSig(timeSignature, loc);
		return timeSig;
	}
	
	@Override
	public T visitParallelNotes(ParallelNotesContext ctx) {
		contextStack.push(ctx);
		currentParallelNotes = new ParallelNotes(MMDuration.ZERO, getLocation(ctx));
		T v =  super.visitParallelNotes(ctx);
		notesStack.peek().add(currentParallelNotes);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitParallelNotesElement(ParallelNotesElementContext ctx) {
		contextStack.push(ctx);
		SpecialToken st = Song4SpecialTokenParser.getSpecialToken(ctx.NOTE().getText());
		st.mmnote.setLocation(getLocation(ctx));
		currentParallelNotes.addNote(st.mmnote);
		T v =  super.visitParallelNotesElement(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitTimeBookmark(TimeBookmarkContext ctx) {
		contextStack.push(ctx);
		TimeBookmark bm = new TimeBookmark(ctx.VAR().getText(), getLocation(ctx));
		PlayCommand pc = (PlayCommand) currentSongElement;
		pc.add(bm);
		T v =  super.visitTimeBookmark(ctx);
		contextStack.pop();
		return v;
	}
	@Override
	public T visitTimeRecall(TimeRecallContext ctx) {
		contextStack.push(ctx);
		TimeRecall tr = new TimeRecall(ctx.VAR().getText(), getLocation(ctx));
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
		TimeSet ts = new TimeSet(new MMDuration(totalPulses), "" + bars, "" + pulses, getLocation(ctx));
		PlayCommand pc = (PlayCommand) currentSongElement;
		pc.add(ts);
		T v =  super.visitTimeSet(ctx);
		contextStack.pop();
		return v;
	}
	
	
	private Location getLocation(ParserRuleContext ctx) {
		return new Location(ctx.getStart().getLine(), 
				ctx.getStart().getStartIndex(), 
				ctx.getText().length(), 
				ctx.getText());
		
	}
	
	
	private Object evaluateGroovy(String text) {
		String staticImports = "import static shiva.music.generate.ScriptHelper.*;";
		
		String script = staticImports + text.substring(2, text.length()-2);
		Binding binding = new Binding();
		for (VarDef vd: varDefs) {
			binding.setVariable(vd.getVarName(), vd.getValue());
		}
		GroovyShell shell = new GroovyShell(binding);

		Object value = shell.evaluate(script);
		return value;

	}
	

}
