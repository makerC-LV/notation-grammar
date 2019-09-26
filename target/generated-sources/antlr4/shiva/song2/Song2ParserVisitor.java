// Generated from Song2Parser.g4 by ANTLR 4.7.2

    package shiva.song2;
    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Song2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Song2ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Song2Parser#song}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSong(Song2Parser.SongContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#keysig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeysig(Song2Parser.KeysigContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#timesig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimesig(Song2Parser.TimesigContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#partlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartlist(Song2Parser.PartlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPart(Song2Parser.PartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#vardecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardecl(Song2Parser.VardeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#varvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarvalue(Song2Parser.VarvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#notepart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotepart(Song2Parser.NotepartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#phrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhrase(Song2Parser.PhraseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#rhythmpart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRhythmpart(Song2Parser.RhythmpartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Song2Parser#rphrase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRphrase(Song2Parser.RphraseContext ctx);
}