package shiva.metamusic.util;

import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jfugue.midi.MidiParser;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.staccato.StaccatoParserListener;

import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;
import shiva.metamusic.Song;
import shiva.song4.Song4Lexer;
import shiva.song4.Song4Parser;

public class PlayUtils {

	
	public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException {
		play("Rq Cq Dq Eq Fq Rq;");
	}
	
	public static void play(String songString) throws MidiUnavailableException, InvalidMidiDataException {
		CharStream input = CharStreams.fromString(songString);
		Song4Lexer lexer = new Song4Lexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Song4Parser parser = new Song4Parser(tokens);
        ParseTree tree = parser.song();
        Song4Visitor2<Void> visitor = new Song4Visitor2<Void>();
        visitor.visit(tree);
        
        Song song = visitor.getSong();
        playSong(song);
	}
	
	public static void playNotes(List<MMNote> notes, MMKeySig keySig) throws MidiUnavailableException, InvalidMidiDataException {
		Song s = Song.create(notes, keySig);
		playSong(s);
		
	}
	
	public static void playNotes(List<MMNote> notes) throws MidiUnavailableException, InvalidMidiDataException {
		Song s = Song.create(notes);
		playSong(s);
		
	}
	
	public static void playSong(Song song) throws MidiUnavailableException, InvalidMidiDataException {
		LinearSong lsong = new LinearSong(song);
		playUsingJava(LinearSongToMidi.getSequence(lsong));
	}
	
	public static void playUsingJava(Sequence seq)
			throws MidiUnavailableException, InvalidMidiDataException {
		new Thread(()-> {playInSeparateThread(seq);}).start();
	}

	private static void playInSeparateThread(Sequence seq)  {
		Sequencer sqr = null;
		try {
			sqr = MidiSystem.getSequencer();
			sqr.open();
			sqr.setSequence(seq);
			sqr.start();
			// busy-wait until the sequencer stops playing - ugly, but couldn't find
			// a better way to do it
			while (sqr.isRunning()) {
				Thread.yield();
			}
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// when done playing, close the sequencer
			sqr.close();
			
		}

	}
	
	public static void playStaccatoUsingJFugue(Sequence seq) {
		StaccatoParserListener listener = new StaccatoParserListener();
		MidiParser midiParser = new MidiParser();
		midiParser.addParserListener(listener);
		midiParser.parse(seq);
		Pattern pattern = listener.getPattern();
		System.out.println(pattern);
		Player player = new Player();
		player.play(pattern);
//		while (player.isPlaying()) {
//			Thread.yield();
//		}
	}

	

}
