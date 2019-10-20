package shiva.swing.syntaxeditor;

import org.antlr.v4.runtime.tree.ParseTree;

import shiva.song4.Song4Lexer;
import shiva.song4.Song4Parser;

public class Song4Parsing {

	private Song4Lexer lexer;
	private Song4Parser parser;
	private ParseTree parseTree;
	
	
	public Song4Parsing(Song4Lexer lexer, Song4Parser parser) {
		super();
		this.lexer = lexer;
		this.parser = parser;
	}


	public Song4Lexer getLexer() {
		return lexer;
	}


	public Song4Parser getParser() {
		return parser;
	}


	public ParseTree getParseTree() {
		return parseTree;
	}


	public void setParseTree(ParseTree parseTree) {
		this.parseTree = parseTree;
	}
	
	
	
	
}
