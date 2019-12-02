// Generated from Song4Parser.g4 by ANTLR 4.4

    package shiva.song4;
    import java.util.HashMap;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Song4Parser}.
 */
public interface Song4ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Song4Parser#voice}.
	 * @param ctx the parse tree
	 */
	void enterVoice(@NotNull Song4Parser.VoiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voice}.
	 * @param ctx the parse tree
	 */
	void exitVoice(@NotNull Song4Parser.VoiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(@NotNull Song4Parser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(@NotNull Song4Parser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#notes}.
	 * @param ctx the parse tree
	 */
	void enterNotes(@NotNull Song4Parser.NotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#notes}.
	 * @param ctx the parse tree
	 */
	void exitNotes(@NotNull Song4Parser.NotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#parallelNotesElement}.
	 * @param ctx the parse tree
	 */
	void enterParallelNotesElement(@NotNull Song4Parser.ParallelNotesElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#parallelNotesElement}.
	 * @param ctx the parse tree
	 */
	void exitParallelNotesElement(@NotNull Song4Parser.ParallelNotesElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#timeRecall}.
	 * @param ctx the parse tree
	 */
	void enterTimeRecall(@NotNull Song4Parser.TimeRecallContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#timeRecall}.
	 * @param ctx the parse tree
	 */
	void exitTimeRecall(@NotNull Song4Parser.TimeRecallContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#tempo}.
	 * @param ctx the parse tree
	 */
	void enterTempo(@NotNull Song4Parser.TempoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#tempo}.
	 * @param ctx the parse tree
	 */
	void exitTempo(@NotNull Song4Parser.TempoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#timesig}.
	 * @param ctx the parse tree
	 */
	void enterTimesig(@NotNull Song4Parser.TimesigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#timesig}.
	 * @param ctx the parse tree
	 */
	void exitTimesig(@NotNull Song4Parser.TimesigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#keysig}.
	 * @param ctx the parse tree
	 */
	void enterKeysig(@NotNull Song4Parser.KeysigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#keysig}.
	 * @param ctx the parse tree
	 */
	void exitKeysig(@NotNull Song4Parser.KeysigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#playable}.
	 * @param ctx the parse tree
	 */
	void enterPlayable(@NotNull Song4Parser.PlayableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#playable}.
	 * @param ctx the parse tree
	 */
	void exitPlayable(@NotNull Song4Parser.PlayableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#timeBookmark}.
	 * @param ctx the parse tree
	 */
	void enterTimeBookmark(@NotNull Song4Parser.TimeBookmarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#timeBookmark}.
	 * @param ctx the parse tree
	 */
	void exitTimeBookmark(@NotNull Song4Parser.TimeBookmarkContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#songElement}.
	 * @param ctx the parse tree
	 */
	void enterSongElement(@NotNull Song4Parser.SongElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#songElement}.
	 * @param ctx the parse tree
	 */
	void exitSongElement(@NotNull Song4Parser.SongElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#beat}.
	 * @param ctx the parse tree
	 */
	void enterBeat(@NotNull Song4Parser.BeatContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#beat}.
	 * @param ctx the parse tree
	 */
	void exitBeat(@NotNull Song4Parser.BeatContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#song}.
	 * @param ctx the parse tree
	 */
	void enterSong(@NotNull Song4Parser.SongContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#song}.
	 * @param ctx the parse tree
	 */
	void exitSong(@NotNull Song4Parser.SongContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#drumChange}.
	 * @param ctx the parse tree
	 */
	void enterDrumChange(@NotNull Song4Parser.DrumChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#drumChange}.
	 * @param ctx the parse tree
	 */
	void exitDrumChange(@NotNull Song4Parser.DrumChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#globalElement}.
	 * @param ctx the parse tree
	 */
	void enterGlobalElement(@NotNull Song4Parser.GlobalElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#globalElement}.
	 * @param ctx the parse tree
	 */
	void exitGlobalElement(@NotNull Song4Parser.GlobalElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#rhythmElement}.
	 * @param ctx the parse tree
	 */
	void enterRhythmElement(@NotNull Song4Parser.RhythmElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#rhythmElement}.
	 * @param ctx the parse tree
	 */
	void exitRhythmElement(@NotNull Song4Parser.RhythmElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#rhythm}.
	 * @param ctx the parse tree
	 */
	void enterRhythm(@NotNull Song4Parser.RhythmContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#rhythm}.
	 * @param ctx the parse tree
	 */
	void exitRhythm(@NotNull Song4Parser.RhythmContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(@NotNull Song4Parser.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(@NotNull Song4Parser.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#groupedNotes}.
	 * @param ctx the parse tree
	 */
	void enterGroupedNotes(@NotNull Song4Parser.GroupedNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#groupedNotes}.
	 * @param ctx the parse tree
	 */
	void exitGroupedNotes(@NotNull Song4Parser.GroupedNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#parallelNotes}.
	 * @param ctx the parse tree
	 */
	void enterParallelNotes(@NotNull Song4Parser.ParallelNotesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#parallelNotes}.
	 * @param ctx the parse tree
	 */
	void exitParallelNotes(@NotNull Song4Parser.ParallelNotesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#playCommand}.
	 * @param ctx the parse tree
	 */
	void enterPlayCommand(@NotNull Song4Parser.PlayCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#playCommand}.
	 * @param ctx the parse tree
	 */
	void exitPlayCommand(@NotNull Song4Parser.PlayCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#notesElement}.
	 * @param ctx the parse tree
	 */
	void enterNotesElement(@NotNull Song4Parser.NotesElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#notesElement}.
	 * @param ctx the parse tree
	 */
	void exitNotesElement(@NotNull Song4Parser.NotesElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#groupedRhythm}.
	 * @param ctx the parse tree
	 */
	void enterGroupedRhythm(@NotNull Song4Parser.GroupedRhythmContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#groupedRhythm}.
	 * @param ctx the parse tree
	 */
	void exitGroupedRhythm(@NotNull Song4Parser.GroupedRhythmContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#chord}.
	 * @param ctx the parse tree
	 */
	void enterChord(@NotNull Song4Parser.ChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#chord}.
	 * @param ctx the parse tree
	 */
	void exitChord(@NotNull Song4Parser.ChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(@NotNull Song4Parser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(@NotNull Song4Parser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#voiceChange}.
	 * @param ctx the parse tree
	 */
	void enterVoiceChange(@NotNull Song4Parser.VoiceChangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voiceChange}.
	 * @param ctx the parse tree
	 */
	void exitVoiceChange(@NotNull Song4Parser.VoiceChangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#timeSet}.
	 * @param ctx the parse tree
	 */
	void enterTimeSet(@NotNull Song4Parser.TimeSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#timeSet}.
	 * @param ctx the parse tree
	 */
	void exitTimeSet(@NotNull Song4Parser.TimeSetContext ctx);
}