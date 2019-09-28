// Generated from Song2Parser.g4 by ANTLR 4.4

    package shiva.song2;
    import java.util.HashMap;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Song2Parser}.
 */
public interface Song2ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Song2Parser#song}.
	 * @param ctx the parse tree
	 */
	void enterSong(@NotNull Song2Parser.SongContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#song}.
	 * @param ctx the parse tree
	 */
	void exitSong(@NotNull Song2Parser.SongContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(@NotNull Song2Parser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(@NotNull Song2Parser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#varvalue}.
	 * @param ctx the parse tree
	 */
	void enterVarvalue(@NotNull Song2Parser.VarvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#varvalue}.
	 * @param ctx the parse tree
	 */
	void exitVarvalue(@NotNull Song2Parser.VarvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(@NotNull Song2Parser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(@NotNull Song2Parser.PartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#rhythmpart}.
	 * @param ctx the parse tree
	 */
	void enterRhythmpart(@NotNull Song2Parser.RhythmpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#rhythmpart}.
	 * @param ctx the parse tree
	 */
	void exitRhythmpart(@NotNull Song2Parser.RhythmpartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#timesig}.
	 * @param ctx the parse tree
	 */
	void enterTimesig(@NotNull Song2Parser.TimesigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#timesig}.
	 * @param ctx the parse tree
	 */
	void exitTimesig(@NotNull Song2Parser.TimesigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVardecl(@NotNull Song2Parser.VardeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVardecl(@NotNull Song2Parser.VardeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#keysig}.
	 * @param ctx the parse tree
	 */
	void enterKeysig(@NotNull Song2Parser.KeysigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#keysig}.
	 * @param ctx the parse tree
	 */
	void exitKeysig(@NotNull Song2Parser.KeysigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#partlist}.
	 * @param ctx the parse tree
	 */
	void enterPartlist(@NotNull Song2Parser.PartlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#partlist}.
	 * @param ctx the parse tree
	 */
	void exitPartlist(@NotNull Song2Parser.PartlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#notepart}.
	 * @param ctx the parse tree
	 */
	void enterNotepart(@NotNull Song2Parser.NotepartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#notepart}.
	 * @param ctx the parse tree
	 */
	void exitNotepart(@NotNull Song2Parser.NotepartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#rphrase}.
	 * @param ctx the parse tree
	 */
	void enterRphrase(@NotNull Song2Parser.RphraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#rphrase}.
	 * @param ctx the parse tree
	 */
	void exitRphrase(@NotNull Song2Parser.RphraseContext ctx);
}