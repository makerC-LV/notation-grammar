import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import shiva.song2.Song2Lexer;
import shiva.song2.Song2Parser;

public class Song2Runner 
{
    public static void main( String[] args) throws Exception 
    {

//        CharStream input = CharStreams.fromStream(System.in);

    	CharStream input = CharStreams.fromString(new String(Files.readAllBytes( Paths.get("test.song"))));
//    	CharStream input = CharStreams.fromString("c d e");
        Song2Lexer lexer = new Song2Lexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Lexer test
//        tokens.fill();
        
//        System.out.println(tokens.getTokens());
//        for (Token t : tokens.getTokens()) {
//        	System.out.println("'" + t.getText() + "'" + "   " + lexer.getVocabulary().getSymbolicName(t.getType()));
//        }

        // Parser test
        Song2Parser parser = new Song2Parser(tokens);
        ParseTree tree = parser.song(); // begin parsing at rule 'song'
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
    }
}