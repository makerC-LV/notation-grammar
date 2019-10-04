// Generated from Song4Parser.g4 by ANTLR 4.7.2

    package shiva.song4;
    import java.util.HashMap;

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
	 * Visit a parse tree produced by {@link Song4Parser#song}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSong(Song4Parser.SongContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#tempo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTempo(Song4Parser.TempoContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#keysig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeysig(Song4Parser.KeysigContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#timesig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimesig(Song4Parser.TimesigContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#voiceDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoiceDef(Song4Parser.VoiceDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#phraseDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhraseDef(Song4Parser.PhraseDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#templatePhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplatePhrase(Song4Parser.TemplatePhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#templatePhraseElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplatePhraseElement(Song4Parser.TemplatePhraseElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#parallelNotes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelNotes(Song4Parser.ParallelNotesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#parallelNotesElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParallelNotesElement(Song4Parser.ParallelNotesElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#voicedPhrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoicedPhrase(Song4Parser.VoicedPhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#voicedPhraseElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoicedPhraseElement(Song4Parser.VoicedPhraseElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#timeBookmark}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeBookmark(Song4Parser.TimeBookmarkContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#timeRecall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeRecall(Song4Parser.TimeRecallContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song4Parser#timeSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimeSet(Song4Parser.TimeSetContext ctx);
}