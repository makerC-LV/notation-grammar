import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.Future;

import javax.sound.midi.Sequence;
import javax.swing.JFrame;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import shiva.metamusic.Song;
import shiva.metamusic.Song4Visitor2;
import shiva.metamusic.SongToMidi;
import shiva.song4.Song4Lexer;
import shiva.song4.Song4Parser;
import shiva.util.PTimer;

public class Song4Runner 
{
	
	
    public static void main( String[] args) throws Exception 
    {

//        CharStream input = CharStreams.fromStream(System.in);

//    	CharStream input = CharStreams.fromString(new String(Files.readAllBytes( Paths.get("test.song4"))));
//    	CharStream input = CharStreams.fromString(new String(Files.readAllBytes( Paths.get("test2.song4"))));
    	CharStream input = CharStreams.fromString("play (c dh eq fi gi ai bs) X 3 ;");
    	
//    	CharStream input = CharStreams.fromString("key Cminor; r c d e f g a b ");
    	
        Song4Lexer lexer = new Song4Lexer(input);

        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PTimer lext = new PTimer("Lexer");
        PTimer part = new PTimer("Parser");
        lext.start();
        // Lexer test
        tokens.fill();
        
        System.out.println(tokens.getTokens());
        for (Token t : tokens.getTokens()) {
        	System.out.println("'" + t.getText() + "'" + "   " + lexer.getVocabulary().getSymbolicName(t.getType()));
        }
        lext.stop();
        
        // Parser test
        part.start();
        Song4Parser parser = new Song4Parser(tokens);
        ParseTree tree = parser.song(); // begin parsing at rule 'song'
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        part.stop();
      //show AST in GUI
        
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        
        Future<JFrame> ff = viewr.open();
        ff.get().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Song4Visitor2<Void> visitor = new Song4Visitor2<Void>();
        visitor.visit(tree);
        
        Song song = visitor.getSong();
        System.out.println(song);
        
        System.out.println(lext);
        System.out.println(part);
        
       Sequence seq = SongToMidi.createSequence(song);
       SongToMidi.playUsingJava(seq);

       
       
    }
}