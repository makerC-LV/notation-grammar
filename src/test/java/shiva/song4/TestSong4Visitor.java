package shiva.song4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Ignore;
import org.junit.Test;

import shiva.metamusic.util.Song4Visitor2;

public class TestSong4Visitor {

	Song4Lexer lexer;
	Song4Parser parser;
	ParseTree tree;
	DescriptiveErrorListener errors = DescriptiveErrorListener.INSTANCE;
	Song4Visitor2<Void> visitor;
	
	
	@Test
	public void test1() {
		setupWith("tempo  90 ; key eminor ; time 2/3 ;  c d ");
		tree = parser.song();
		noErrors();
		visitor.visit(tree);
		System.out.println(visitor.getSong().toSong4());
		
	}

	

	
	@Test
	public void testParallelNotes() {
		setupWith("c { d f} ");
		tree = parser.song();
		noErrors();
		visitor.visit(tree);
		System.out.println(visitor.getSong().toSong4());
		
	}
	
	
	@Test
	public void testNestedNotes() {
		setupWith(" c d ( e f) X 3 (a g) ");
		tree = parser.song();
		noErrors();
		visitor.visit(tree);
		System.out.println(visitor.getSong().toSong4());
		
	}
	
	@Test
	public void testBarlinesAndTime() {
		setupWith("c d | ( e f) X 3 | (a g) ");
		tree = parser.song();
		noErrors();
		visitor.visit(tree);
		System.out.println(visitor.getSong().toSong4());
		
	}
	
	@Test
	public void testVariables() {
		setupWith("$a = c d ; $a");
		tree = parser.song();
		noErrors();
		visitor.visit(tree);
		System.out.println(visitor.getSong().toSong4());
		
	}
	
	private void setupWith(String string) {
		DescriptiveErrorListener.INSTANCE.reset();
		CharStream input = CharStreams.fromString(string);
		lexer = new Song4Lexer(input);
		
		
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        tokens.fill();
        
        for (Token t : tokens.getTokens()) {
        	System.out.println("'" + t.getText() + "'" + "   " + lexer.getVocabulary().getSymbolicName(t.getType()));
        }
        
        parser = new Song4Parser(tokens);
        
        lexer.removeErrorListeners();
        lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
        parser.removeErrorListeners();
        parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
        
        visitor = new Song4Visitor2<Void>();
        
	}
	
	private void noErrors() {
		assertEquals(0, errors.getErrorCount());
		
	}
}
