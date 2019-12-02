// Generated from Song4Parser.g4 by ANTLR 4.4

    package shiva.song4;
    import java.util.HashMap;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Song4Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Song4ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Song4Parser#voice}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoice(@NotNull Song4Parser.VoiceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(@NotNull Song4Parser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#notes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotes(@NotNull Song4Parser.NotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#parallelNotesElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelNotesElement(@NotNull Song4Parser.ParallelNotesElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#timeRecall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeRecall(@NotNull Song4Parser.TimeRecallContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#tempo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTempo(@NotNull Song4Parser.TempoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#timesig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimesig(@NotNull Song4Parser.TimesigContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#keysig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeysig(@NotNull Song4Parser.KeysigContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#playable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayable(@NotNull Song4Parser.PlayableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#timeBookmark}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeBookmark(@NotNull Song4Parser.TimeBookmarkContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#songElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSongElement(@NotNull Song4Parser.SongElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#beat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeat(@NotNull Song4Parser.BeatContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#song}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSong(@NotNull Song4Parser.SongContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#drumChange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrumChange(@NotNull Song4Parser.DrumChangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#globalElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalElement(@NotNull Song4Parser.GlobalElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#rhythmElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhythmElement(@NotNull Song4Parser.RhythmElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#rhythm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhythm(@NotNull Song4Parser.RhythmContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#assignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignable(@NotNull Song4Parser.AssignableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#groupedNotes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupedNotes(@NotNull Song4Parser.GroupedNotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#parallelNotes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelNotes(@NotNull Song4Parser.ParallelNotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#playCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayCommand(@NotNull Song4Parser.PlayCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#notesElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotesElement(@NotNull Song4Parser.NotesElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#groupedRhythm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupedRhythm(@NotNull Song4Parser.GroupedRhythmContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#chord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChord(@NotNull Song4Parser.ChordContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(@NotNull Song4Parser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#voiceChange}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoiceChange(@NotNull Song4Parser.VoiceChangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#timeSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeSet(@NotNull Song4Parser.TimeSetContext ctx);
}