package shiva.song4;

import static org.junit.Assert.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

public class TestSong4Lexer {

	Song4Lexer lexer;
	DescriptiveErrorListener errors = DescriptiveErrorListener.INSTANCE;
	
	@Test
	public void test() {
		setupWith("{ } C#11maj7");
		assertEquals(0, errors.getErrorCount());
	}

	
	private void setupWith(String string) {
		DescriptiveErrorListener.INSTANCE.reset();
		CharStream input = CharStreams.fromString(string);
		lexer = new Song4Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        lexer.removeErrorListeners();
        lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
        
        tokens.fill();
        
        for (Token t : tokens.getTokens()) {
        	System.out.println("'" + t.getText() + "'" + "   " + lexer.getVocabulary().getSymbolicName(t.getType()));
        }
        
	}
	
}
