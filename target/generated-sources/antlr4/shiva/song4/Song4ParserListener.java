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
	 * Enter a parse tree produced by {@link Song4Parser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(Song4Parser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(Song4Parser.PhraseContext ctx);
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
	 * Enter a parse tree produced by {@link Song4Parser#rhythmVoiceDef}.
	 * @param ctx the parse tree
	 */
	void enterRhythmVoiceDef(Song4Parser.RhythmVoiceDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#rhythmVoiceDef}.
	 * @param ctx the parse tree
	 */
	void exitRhythmVoiceDef(Song4Parser.RhythmVoiceDefContext ctx);
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
	 * Enter a parse tree produced by {@link Song4Parser#rhythmPhraseDef}.
	 * @param ctx the parse tree
	 */
	void enterRhythmPhraseDef(Song4Parser.RhythmPhraseDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#rhythmPhraseDef}.
	 * @param ctx the parse tree
	 */
	void exitRhythmPhraseDef(Song4Parser.RhythmPhraseDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#rhythmPhrase}.
	 * @param ctx the parse tree
	 */
	void enterRhythmPhrase(Song4Parser.RhythmPhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#rhythmPhrase}.
	 * @param ctx the parse tree
	 */
	void exitRhythmPhrase(Song4Parser.RhythmPhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#rhythmPhraseElement}.
	 * @param ctx the parse tree
	 */
	void enterRhythmPhraseElement(Song4Parser.RhythmPhraseElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#rhythmPhraseElement}.
	 * @param ctx the parse tree
	 */
	void exitRhythmPhraseElement(Song4Parser.RhythmPhraseElementContext ctx);
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
	 * Enter a parse tree produced by {@link Song4Parser#notePhrase}.
	 * @param ctx the parse tree
	 */
	void enterNotePhrase(Song4Parser.NotePhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#notePhrase}.
	 * @param ctx the parse tree
	 */
	void exitNotePhrase(Song4Parser.NotePhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#notePhraseElement}.
	 * @param ctx the parse tree
	 */
	void enterNotePhraseElement(Song4Parser.NotePhraseElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#notePhraseElement}.
	 * @param ctx the parse tree
	 */
	void exitNotePhraseElement(Song4Parser.NotePhraseElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#voicedNotePhrase}.
	 * @param ctx the parse tree
	 */
	void enterVoicedNotePhrase(Song4Parser.VoicedNotePhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voicedNotePhrase}.
	 * @param ctx the parse tree
	 */
	void exitVoicedNotePhrase(Song4Parser.VoicedNotePhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#voicedNotePhraseElement}.
	 * @param ctx the parse tree
	 */
	void enterVoicedNotePhraseElement(Song4Parser.VoicedNotePhraseElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voicedNotePhraseElement}.
	 * @param ctx the parse tree
	 */
	void exitVoicedNotePhraseElement(Song4Parser.VoicedNotePhraseElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#repeatedVar}.
	 * @param ctx the parse tree
	 */
	void enterRepeatedVar(Song4Parser.RepeatedVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#repeatedVar}.
	 * @param ctx the parse tree
	 */
	void exitRepeatedVar(Song4Parser.RepeatedVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#voicedRhythmPhrase}.
	 * @param ctx the parse tree
	 */
	void enterVoicedRhythmPhrase(Song4Parser.VoicedRhythmPhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voicedRhythmPhrase}.
	 * @param ctx the parse tree
	 */
	void exitVoicedRhythmPhrase(Song4Parser.VoicedRhythmPhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song4Parser#voicedRhythmPhraseElement}.
	 * @param ctx the parse tree
	 */
	void enterVoicedRhythmPhraseElement(Song4Parser.VoicedRhythmPhraseElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song4Parser#voicedRhythmPhraseElement}.
	 * @param ctx the parse tree
	 */
	void exitVoicedRhythmPhraseElement(Song4Parser.VoicedRhythmPhraseElementContext ctx);
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