import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
import org.jfugue.player.Player;

import shiva.metamusic.MMSong;
import shiva.metamusic.SongToMidi;
import shiva.song4.GenerateNoteChordTokens;
import shiva.song4.LexerLookup;
import shiva.song4.Song4Lexer;
import shiva.song4.Song4Parser;
import shiva.util.PTimer;

public class Song4Runner 
{
	
	
    public static void main( String[] args) throws Exception 
    {

//        CharStream input = CharStreams.fromStream(System.in);

//    	CharStream input = CharStreams.fromString(new String(Files.readAllBytes( Paths.get("test.song4"))));
    	CharStream input = CharStreams.fromString(new String(Files.readAllBytes( Paths.get("test2.song4"))));
//    	CharStream input = CharStreams.fromString("(c dh eq fi gi ai bs) X 3");
    	
//    	CharStream input = CharStreams.fromString("key Cminor; r c d e f g a b ");
    	
        Song4Lexer lexer = new Song4Lexer(input);

        LexerLookup.INSTANCE.put(Song4Lexer.KEYSIG, GenerateNoteChordTokens.getKeyStrings());
        LexerLookup.INSTANCE.put(Song4Lexer.CHORD, GenerateNoteChordTokens.getChordStrings());
        LexerLookup.INSTANCE.put(Song4Lexer.NOTE, GenerateNoteChordTokens.getNoteStrings());
        
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
        
        Song4Visitor<Void> visitor = new Song4Visitor<Void>(lexer, parser);
        visitor.visit(tree);
        
        MMSong song = visitor.song;
        System.out.println(song);
        
       Sequence seq = SongToMidi.createSequence(song);
       SongToMidi.playUsingJava(seq);

       System.out.println(lext);
       System.out.println(part);
       
    }
}