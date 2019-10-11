// Generated from Song4Parser.g4 by ANTLR 4.7.2

    package shiva.song4;
    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Song4Parser}.
 */
public interface Song4ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Song4Parser#song}.
	 * @param ctx the parse tree
	 */
	void enterSong(Song4Parser.SongContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#song}.
	 * @param ctx the parse tree
	 */
	void exitSong(Song4Parser.SongContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#songElement}.
	 * @param ctx the parse tree
	 */
	void enterSongElement(Song4Parser.SongElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#songElement}.
	 * @param ctx the parse tree
	 */
	void exitSongElement(Song4Parser.SongElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#playCommand}.
	 * @param ctx the parse tree
	 */
	void enterPlayCommand(Song4Parser.PlayCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#playCommand}.
	 * @param ctx the parse tree
	 */
	void exitPlayCommand(Song4Parser.PlayCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#playable}.
	 * @param ctx the parse tree
	 */
	void enterPlayable(Song4Parser.PlayableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#playable}.
	 * @param ctx the parse tree
	 */
	void exitPlayable(Song4Parser.PlayableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(Song4Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(Song4Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(Song4Parser.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(Song4Parser.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#voice}.
	 * @param ctx the parse tree
	 */
	void enterVoice(Song4Parser.VoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voice}.
	 * @param ctx the parse tree
	 */
	void exitVoice(Song4Parser.VoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#notes}.
	 * @param ctx the parse tree
	 */
	void enterNotes(Song4Parser.NotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#notes}.
	 * @param ctx the parse tree
	 */
	void exitNotes(Song4Parser.NotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#notesElement}.
	 * @param ctx the parse tree
	 */
	void enterNotesElement(Song4Parser.NotesElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#notesElement}.
	 * @param ctx the parse tree
	 */
	void exitNotesElement(Song4Parser.NotesElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#groupedNotes}.
	 * @param ctx the parse tree
	 */
	void enterGroupedNotes(Song4Parser.GroupedNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#groupedNotes}.
	 * @param ctx the parse tree
	 */
	void exitGroupedNotes(Song4Parser.GroupedNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#rhythm}.
	 * @param ctx the parse tree
	 */
	void enterRhythm(Song4Parser.RhythmContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#rhythm}.
	 * @param ctx the parse tree
	 */
	void exitRhythm(Song4Parser.RhythmContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#rhythmElement}.
	 * @param ctx the parse tree
	 */
	void enterRhythmElement(Song4Parser.RhythmElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#rhythmElement}.
	 * @param ctx the parse tree
	 */
	void exitRhythmElement(Song4Parser.RhythmElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#groupedRhythm}.
	 * @param ctx the parse tree
	 */
	void enterGroupedRhythm(Song4Parser.GroupedRhythmContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#groupedRhythm}.
	 * @param ctx the parse tree
	 */
	void exitGroupedRhythm(Song4Parser.GroupedRhythmContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#tempo}.
	 * @param ctx the parse tree
	 */
	void enterTempo(Song4Parser.TempoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#tempo}.
	 * @param ctx the parse tree
	 */
	void exitTempo(Song4Parser.TempoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#keysig}.
	 * @param ctx the parse tree
	 */
	void enterKeysig(Song4Parser.KeysigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#keysig}.
	 * @param ctx the parse tree
	 */
	void exitKeysig(Song4Parser.KeysigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#timesig}.
	 * @param ctx the parse tree
	 */
	void enterTimesig(Song4Parser.TimesigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#timesig}.
	 * @param ctx the parse tree
	 */
	void exitTimesig(Song4Parser.TimesigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#parallelNotes}.
	 * @param ctx the parse tree
	 */
	void enterParallelNotes(Song4Parser.ParallelNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#parallelNotes}.
	 * @param ctx the parse tree
	 */
	void exitParallelNotes(Song4Parser.ParallelNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#parallelNotesElement}.
	 * @param ctx the parse tree
	 */
	void enterParallelNotesElement(Song4Parser.ParallelNotesElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#parallelNotesElement}.
	 * @param ctx the parse tree
	 */
	void exitParallelNotesElement(Song4Parser.ParallelNotesElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#timeBookmark}.
	 * @param ctx the parse tree
	 */
	void enterTimeBookmark(Song4Parser.TimeBookmarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#timeBookmark}.
	 * @param ctx the parse tree
	 */
	void exitTimeBookmark(Song4Parser.TimeBookmarkContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#timeRecall}.
	 * @param ctx the parse tree
	 */
	void enterTimeRecall(Song4Parser.TimeRecallContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#timeRecall}.
	 * @param ctx the parse tree
	 */
	void exitTimeRecall(Song4Parser.TimeRecallContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#timeSet}.
	 * @param ctx the parse tree
	 */
	void enterTimeSet(Song4Parser.TimeSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#timeSet}.
	 * @param ctx the parse tree
	 */
	void exitTimeSet(Song4Parser.TimeSetContext ctx);
}