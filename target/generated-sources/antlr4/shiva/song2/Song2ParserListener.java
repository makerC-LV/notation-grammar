// Generated from Song2Parser.g4 by ANTLR 4.7.2

    package shiva.song2;
    import java.util.HashMap;

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
	void enterSong(Song2Parser.SongContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#song}.
	 * @param ctx the parse tree
	 */
	void exitSong(Song2Parser.SongContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#keysig}.
	 * @param ctx the parse tree
	 */
	void enterKeysig(Song2Parser.KeysigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#keysig}.
	 * @param ctx the parse tree
	 */
	void exitKeysig(Song2Parser.KeysigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#timesig}.
	 * @param ctx the parse tree
	 */
	void enterTimesig(Song2Parser.TimesigContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#timesig}.
	 * @param ctx the parse tree
	 */
	void exitTimesig(Song2Parser.TimesigContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#partlist}.
	 * @param ctx the parse tree
	 */
	void enterPartlist(Song2Parser.PartlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#partlist}.
	 * @param ctx the parse tree
	 */
	void exitPartlist(Song2Parser.PartlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#part}.
	 * @param ctx the parse tree
	 */
	void enterPart(Song2Parser.PartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#part}.
	 * @param ctx the parse tree
	 */
	void exitPart(Song2Parser.PartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#vardecl}.
	 * @param ctx the parse tree
	 */
	void enterVardecl(Song2Parser.VardeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#vardecl}.
	 * @param ctx the parse tree
	 */
	void exitVardecl(Song2Parser.VardeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#varvalue}.
	 * @param ctx the parse tree
	 */
	void enterVarvalue(Song2Parser.VarvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#varvalue}.
	 * @param ctx the parse tree
	 */
	void exitVarvalue(Song2Parser.VarvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#notepart}.
	 * @param ctx the parse tree
	 */
	void enterNotepart(Song2Parser.NotepartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#notepart}.
	 * @param ctx the parse tree
	 */
	void exitNotepart(Song2Parser.NotepartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#phrase}.
	 * @param ctx the parse tree
	 */
	void enterPhrase(Song2Parser.PhraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#phrase}.
	 * @param ctx the parse tree
	 */
	void exitPhrase(Song2Parser.PhraseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#rhythmpart}.
	 * @param ctx the parse tree
	 */
	void enterRhythmpart(Song2Parser.RhythmpartContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#rhythmpart}.
	 * @param ctx the parse tree
	 */
	void exitRhythmpart(Song2Parser.RhythmpartContext ctx);
	/**
	 * Enter a parse tree produced by {@link Song2Parser#rphrase}.
	 * @param ctx the parse tree
	 */
	void enterRphrase(Song2Parser.RphraseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Song2Parser#rphrase}.
	 * @param ctx the parse tree
	 */
	void exitRphrase(Song2Parser.RphraseContext ctx);
}