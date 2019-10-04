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
	 * Enter a parse tree produced by {@link Song4Parser#voiceDef}.
	 * @param ctx the parse tree
	 */
	void enterVoiceDef(Song4Parser.VoiceDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voiceDef}.
	 * @param ctx the parse tree
	 */
	void exitVoiceDef(Song4Parser.VoiceDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#phraseDef}.
	 * @param ctx the parse tree
	 */
	void enterPhraseDef(Song4Parser.PhraseDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#phraseDef}.
	 * @param ctx the parse tree
	 */
	void exitPhraseDef(Song4Parser.PhraseDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#templatePhrase}.
	 * @param ctx the parse tree
	 */
	void enterTemplatePhrase(Song4Parser.TemplatePhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#templatePhrase}.
	 * @param ctx the parse tree
	 */
	void exitTemplatePhrase(Song4Parser.TemplatePhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#templatePhraseElement}.
	 * @param ctx the parse tree
	 */
	void enterTemplatePhraseElement(Song4Parser.TemplatePhraseElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#templatePhraseElement}.
	 * @param ctx the parse tree
	 */
	void exitTemplatePhraseElement(Song4Parser.TemplatePhraseElementContext ctx);
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
	 * Enter a parse tree produced by {@link Song4Parser#voicedPhrase}.
	 * @param ctx the parse tree
	 */
	void enterVoicedPhrase(Song4Parser.VoicedPhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voicedPhrase}.
	 * @param ctx the parse tree
	 */
	void exitVoicedPhrase(Song4Parser.VoicedPhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#voicedPhraseElement}.
	 * @param ctx the parse tree
	 */
	void enterVoicedPhraseElement(Song4Parser.VoicedPhraseElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voicedPhraseElement}.
	 * @param ctx the parse tree
	 */
	void exitVoicedPhraseElement(Song4Parser.VoicedPhraseElementContext ctx);
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