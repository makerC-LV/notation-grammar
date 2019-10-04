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

public class Song4Runner 
{
	
	
    public static void main( String[] args) throws Exception 
    {

//        CharStream input = CharStreams.fromStream(System.in);

    	CharStream input = CharStreams.fromString(new String(Files.readAllBytes( Paths.get("test.song4"))));
//    	CharStream input = CharStreams.fromString("V1 = I[Flute]; (V1 cq dh eq fh gi ai bs)");
        Song4Lexer lexer = new Song4Lexer(input);

        LexerLookup.INSTANCE.put(Song4Lexer.KEYSIG, GenerateNoteChordTokens.getKeyStrings());
        LexerLookup.INSTANCE.put(Song4Lexer.CHORD, GenerateNoteChordTokens.getChordStrings());
        LexerLookup.INSTANCE.put(Song4Lexer.NOTE, GenerateNoteChordTokens.getNoteStrings());
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Lexer test
        tokens.fill();
        
        System.out.println(tokens.getTokens());
        for (Token t : tokens.getTokens()) {
        	System.out.println("'" + t.getText() + "'" + "   " + lexer.getVocabulary().getSymbolicName(t.getType()));
        }

        // Parser test
        Song4Parser parser = new Song4Parser(tokens);
        ParseTree tree = parser.song(); // begin parsing at rule 'song'
        System.out.println(tree.toStringTree(parser)); // print LISP-style tree
        
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

    }
}