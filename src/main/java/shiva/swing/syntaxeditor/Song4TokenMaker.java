package shiva.swing.syntaxeditor;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

import javax.annotation.Nonnull;
import javax.swing.text.Segment;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.UnbufferedTokenStream;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMaker;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMap;

import shiva.song4.Song4Lexer;

public class Song4TokenMaker extends AbstractTokenMaker {

	private boolean DEBUG;
	
	@Override
	public Token getTokenList(@Nonnull Segment text, int initialTokenType, int startOffset) {
	    try (Reader textReader = new CharArrayReader(text.array, text.offset, text.count)) {
	    	CharStream input = CharStreams.fromReader(textReader);
	    	Song4Lexer lexer = new Song4Lexer(input);
//	        lexer.setInputStream(input);
	        TokenStream tokenStream = new UnbufferedTokenStream(lexer);
	        resetTokenList();
	        boolean inMLC = (initialTokenType == Token.COMMENT_MULTILINE);
	        
	        debug("initialTType=" + initialTokenType);
	        while (true) {
	            org.antlr.v4.runtime.Token currentToken = tokenStream.LT(1);
	            if (currentToken.getType() == org.antlr.v4.runtime.Token.EOF) {
	                break;
	            }
	            if (currentToken.getType() == Song4Lexer.STARTCOMMENT) {
	                inMLC = true;
	            }
	            if (currentToken.getType() == Song4Lexer.ENDCOMMENT) {
	                inMLC = false;
	            }
	            tokenStream.consume();
	            // convert the ANTLR token to a RSyntaxTextArea token and add it to the linked list
	            int tokenStart = currentToken.getCharPositionInLine() + text.offset;
	            int tokenEnd = (tokenStart + currentToken.getText().length()) - 1;
	            int tokenOffset = startOffset + currentToken.getCharPositionInLine();
	            
	            int adjTokType = (inMLC  || (currentToken.getType() == Song4Lexer.ENDCOMMENT ))
	            		? Song4Lexer.MULTILINE_COMMENT : currentToken.getType();
	            
	            String ds = String.format(
	            		"inMLC: %b   token: '%s'   adjTokType: %s[%d]   origTokType: %s[%d]", 
	            		inMLC, currentToken.getText(), 
	            		lexer.getVocabulary().getSymbolicName(adjTokType), adjTokType,
	            		lexer.getVocabulary().getSymbolicName(currentToken.getType()), currentToken.getType());
	            		
	            		
	            debug(ds);
	            
	            addToken(text.array, tokenStart, tokenEnd, convertTokenType(adjTokType), tokenOffset);
	        }
	        // end while
	        // add a null token to indicate end of line; note that the test grammar has no multiline token types
	        if (!inMLC) {
	        	debug("Adding null token");
	        	addNullToken();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return firstToken;
	}

	private int convertTokenType(int type) {
		switch (type) {
		case Song4Lexer.CHORD:
		case Song4Lexer.NOTE:
		case Song4Lexer.PLUS:
		case Song4Lexer.MINUS:
		case Song4Lexer.INSTRUMENTNAME:
		case Song4Lexer.DRUMNAME:
		case Song4Lexer.KEYSIG:
			return Token.DATA_TYPE;
			
		case Song4Lexer.LPAREN:
		case Song4Lexer.RPAREN:
		case Song4Lexer.LBRACE:
		case Song4Lexer.RBRACE:
		case Song4Lexer.SEMICOLON:
		case Song4Lexer.BARMARKER:
		case Song4Lexer.SLASH:
		case Song4Lexer.COLON:
			return Token.SEPARATOR;
			
		case Song4Lexer.ASSIGN:
		case Song4Lexer.TIMES:
			return Token.OPERATOR;
			
		case Song4Lexer.VAR:
			return Token.VARIABLE;
			
		case Song4Lexer.NUM:
			return Token.LITERAL_NUMBER_DECIMAL_INT;
			
			
		case Song4Lexer.KEY:
		case Song4Lexer.TEMPO:
		case Song4Lexer.TIME:
		case Song4Lexer.DRUM:
		case Song4Lexer.VOICE:
		case Song4Lexer.MARKTIME:
		case Song4Lexer.RECALLTIME:
			return Token.RESERVED_WORD;
			
		case Song4Lexer.SCRIPT:
			return Token.FUNCTION;
			
		case Song4Lexer.LINE_COMMENT:
			return Token.COMMENT_EOL;
			
		case Song4Lexer.MULTILINE_COMMENT:
			return Token.COMMENT_MULTILINE;
			
		case Song4Lexer.WS:
			return Token.WHITESPACE;
		
		case Song4Lexer.UNMATCHED:
			return Token.ERROR_CHAR;
			
		default:
			return Token.ERROR_CHAR;
		
		}
	}

	@Override
	public TokenMap getWordsToHighlight() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void debug(String s) {
		if (DEBUG) {
			System.out.println(s);
		}
	}

}
