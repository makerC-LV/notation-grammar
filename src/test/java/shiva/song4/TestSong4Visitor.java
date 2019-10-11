package shiva.song4;

import static org.junit.Assert.fail;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Ignore;
import org.junit.Test;

import shiva.metamusic.Song4Visitor2;

public class TestSong4Visitor {

	Song4Lexer lexer;
	Song4Parser parser;
	ParseTree tree;
	DescriptiveErrorListener errors = DescriptiveErrorListener.INSTANCE;
	Song4Visitor2<Void> visitor;
	
	@Ignore
	@Test
	public void test1() {
		setupWith("tempo  90 ; key eminor ; time 2/3 ; play c d ;");
		tree = parser.song();
		visitor.visit(tree);
		System.out.println(visitor.getSong().toSong4());
		
	}

	@Ignore
	@Test
	public void testParallelNotes() {
		setupWith(" play c { d f} ;");
		tree = parser.song();
		visitor.visit(tree);
		System.out.println(visitor.getSong().toSong4());
		
	}
	
	@Ignore
	@Test
	public void testNestedNotes() {
		setupWith("play c d ( e f) X 3 (a g) ;");
		tree = parser.song();
		visitor.visit(tree);
		System.out.println(visitor.getSong().toSong4());
		
	}
	
	@Test
	public void testBarlinesAndTime() {
		setupWith("play c d | ( e f) X 3 | (a g) ;");
		tree = parser.song();
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
}
