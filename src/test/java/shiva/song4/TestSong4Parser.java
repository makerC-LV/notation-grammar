package shiva.song4;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class TestSong4Parser {

	Song4Lexer lexer;
	Song4Parser parser;
	ParseTree tree;
	DescriptiveErrorListener errors = DescriptiveErrorListener.INSTANCE;

	@Ignore
	@Test
	public void testVarDef() {
		setupWith("$a = (c d) (e f) X 2 ;");
		tree = parser.varDef();
		print(tree);
		assertEquals(0, errors.getErrorCount());
		
		setupWith("$b = +-|+- drum $c (+-) X 4 ;");
		tree = parser.varDef();
		print(tree);
		assertEquals(0, errors.getErrorCount());
		
		setupWith("play voice $i c d e f g ;");
		tree = parser.playCommand();
		print(tree);
		assertEquals(0, errors.getErrorCount());
		
		setupWith(getResourceFile("parsertest.song4"));
		tree = parser.song();
		print(tree);
		assertEquals(0, errors.getErrorCount());
		
	}

	@Test
	public void testNotesElement() {
		setupWith("{a b}");
		tree = parser.notesElement();
		print(tree);
	}
	
	
	
	private String getResourceFile(String name) {
		URL url = Resources.getResource(name);
		try {
			String text = Resources.toString(url, Charsets.UTF_8);
			return text;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void print(ParseTree tree2) {
		System.out.println(tree.toStringTree(parser)); 
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
        
	}
}
