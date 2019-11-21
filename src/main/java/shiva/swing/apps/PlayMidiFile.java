package shiva.swing.apps;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import org.jfugue.player.Player;

import shiva.metamusic.util.SequencePlayer;
import shiva.midi.DeviceUtils;

public class PlayMidiFile {

	public static void main(String[] args) throws MidiUnavailableException, IOException, InvalidMidiDataException, InvocationTargetException, InterruptedException {
		
		final JFileChooser fc = new JFileChooser();
		SwingUtilities.invokeAndWait(() -> {
			
			fc.showOpenDialog(null);
		});
		
		
        Sequence sequence = MidiSystem.getSequence(fc.getSelectedFile());
        
        SequencePlayer sp = new SequencePlayer(DeviceUtils.getOutputDevice("Fluid"));
        
        sp.start(sequence);
 
        
		Thread.sleep(100000);

	}

}
