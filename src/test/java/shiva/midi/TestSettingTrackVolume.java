package shiva.midi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

import shiva.metamusic.util.PlayUtils;

public class TestSettingTrackVolume {

	public static void main(String[] args) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		
		
//		playTwoNotes();
		
		
		Sequencer seq = MidiSystem.getSequencer(false);
		
		Synthesizer syn = MidiSystem.getSynthesizer();
		
		seq.getTransmitter().setReceiver(syn.getReceiver());
		
		Sequence sq = PlayUtils.toSequence("C d e f g a b c");
		
		seq.setSequence(sq);
		
		syn.open();
		
		seq.open();
		seq.start();
		
		Thread.sleep(2000);
		
//		playTwoNotes();
		MidiChannel[] channels = syn.getChannels();
		MidiChannel c = channels[0];
//		c.setMute(true);
		Thread.sleep(1000);
		for (int i = 0; i < 20; i++ ) {
			c.controlChange( 7, (int)( i * 5) );
			Thread.sleep(200);
		}

		
//		for (int i = 0; i < 20; i++ ) {
//			MidiChannel[] channels = syn.getChannels();
//			for( int c = 0; c < channels.length; c++ ) {
//				ShortMessage myMsg = new ShortMessage();
//				myMsg.setMessage(ShortMessage.CONTROL_CHANGE, c, 07, i * 5);
//                if(channels[c] != null)   {
//                	channels[c].controlChange( 7, (int)( i * 5) );
//                	
//                	Thread.sleep(1000);
//                }
//            }
//		}
		
		Thread.sleep(10000);
		seq.close();
		syn.close();
	}

	private static void playTwoNotes() throws MidiUnavailableException, InterruptedException {
		Synthesizer syn = MidiSystem.getSynthesizer();
		syn.open();
		MidiChannel c = syn.getChannels()[1];
		
		c.controlChange( 7, 30 );
		c.noteOn(64, 80);
		Thread.sleep(1000);
		c.noteOff(64, 80);
		
		c.setMute(true);
//		Thread.sleep(1000);
//		
//		c.controlChange( 7, 100 );
//		
//		c.noteOn(64, 80);
//		Thread.sleep(1000);
//		c.noteOff(64, 80);
		
		
		syn.close();
	}
}
