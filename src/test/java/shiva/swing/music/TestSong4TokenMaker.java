package shiva.swing.music;

import static org.junit.Assert.assertEquals;

import javax.swing.text.Segment;

import org.fife.ui.rsyntaxtextarea.Token;
import org.junit.Test;

import shiva.swing.syntaxeditor.Song4TokenMaker;

public class TestSong4TokenMaker {

	Song4TokenMaker s4m = new Song4TokenMaker();
	
	@Test
	public void testInitialLine() {
		char[] ca = "tempo /* this is".toCharArray();
		Segment s = new Segment(ca, 0, ca.length);
		System.out.println();
		Token tokenList = s4m.getTokenList(s, 0, 0);
		check(tokenList, 
				Token.RESERVED_WORD, Token.WHITESPACE, 
				Token.COMMENT_MULTILINE, Token.COMMENT_MULTILINE,
				Token.COMMENT_MULTILINE, Token.COMMENT_MULTILINE,
				Token.COMMENT_MULTILINE
				);
	}
	
	
	
	
	@Test
	public void testFinalLine() {
		char[] ca = " at end */ Cmaj a ".toCharArray();
		Segment s = new Segment(ca, 0, ca.length);
		System.out.println();
		Token tokenList = s4m.getTokenList(s, Token.COMMENT_MULTILINE, 0);
		check(tokenList, 
				 
				Token.COMMENT_MULTILINE, Token.COMMENT_MULTILINE,
				Token.COMMENT_MULTILINE, Token.COMMENT_MULTILINE,
				Token.COMMENT_MULTILINE, Token.COMMENT_MULTILINE,
				Token.WHITESPACE, 
				Token.DATA_TYPE, 
				Token.WHITESPACE,
				Token.DATA_TYPE,
				Token.WHITESPACE,
				Token.NULL
				);
	}
	
	private void check(Token tokenList, int...types) {
		int index = 0;
		while (tokenList != null) {
			assertEquals(tokenList.getLexeme(), types[index], tokenList.getType());
			tokenList = tokenList.getNextToken();
			index++;
		}
	}
}
