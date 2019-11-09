package shiva.metamusic.util;

import java.io.IOException;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.swing.JLabel;

import org.jfugue.theory.TimeSignature;

import com.jsyn.midi.MessageParser;

import shiva.metamusic.MMTempo;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.Notes;
import shiva.midi.Connector;
import shiva.midi.DeviceUtils;
import shiva.midi.JSynSynthesizer;
import shiva.swing.components.Util;

public class CaptureKeyboard  extends Connector {

    NotesFromMidi notesFromMidi = new NotesFromMidi();
	private MidiDevice keyboard;
    
	public static void main(String[] args) throws MidiUnavailableException, IOException, InterruptedException {
		CaptureKeyboard ck = new CaptureKeyboard(
				DeviceUtils.getInputDevice("USB"),
				JSynSynthesizer.INSTANCE
				//DeviceUtils.getOutputDevice("Gervill")
				//DeviceUtils.getOutputDevice("Fluid")
				);
		ck.setTempo("240");
		ck.setTempo("480");
		Util.showInFrame(new JLabel("Wait"));
	}
	
	
	
	public CaptureKeyboard(MidiDevice keyboard, MidiDevice synth) {
		super(false);
		setup(keyboard, synth);
	}
	
	
	private void setup(MidiDevice keyboard, MidiDevice synth) {
		try {
			this.keyboard = keyboard;
			openIfNot(keyboard);
			openIfNot(synth);
			addTransmitter(keyboard.getTransmitter());
			if (synth instanceof javax.sound.midi.Synthesizer) {
				addReceiver(new JavaSynthReceiver((javax.sound.midi.Synthesizer) synth));
//			} else if (synth instanceof JSynSynthesizer) {
//				addReceiver(new JSynReceiver((com.jsyn.Synthesizer) synth));
			} else {
				addReceiver(synth.getReceiver());
			}
			addReceiver(notesFromMidi);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		
	}


	private void openIfNot(MidiDevice device) {
		if (!device.isOpen()) {
			try {
				device.open();
			} catch (MidiUnavailableException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public Notes getNotes() {
		return notesFromMidi.noteList;
	}
	
	public void start() {
		notesFromMidi.start();
	}
	
	public void stop() {
		notesFromMidi.stop();
	}
	
	public void setInstrument(int midiInstrument) {
		try {
			MidiEvent evt = MidiUtils.createProgramChange(midiInstrument, -1, 0);
			send (evt.getMessage(), -1);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void setTempo(String s) {
		MMTempo tempo = MMTempo.DEFAULT_TEMPO;
		if (s != null && s.trim().length() > 0) {
			try {
				int bpm = Integer.parseInt(s);
				tempo = new MMTempo(bpm, null);
				MidiEvent e = MidiUtils.createTempoEvent(bpm);
//				keyboard.getReceiver().send(e.getMessage(), -1);
			} catch (Exception e) {
				System.err.println("Invalid tempo: " + s);
				e.printStackTrace();
			}
		}
		notesFromMidi.setTempo(tempo);
	}
	
	public void setTimeSig(String s) {
		MMTimeSig ts = MMTimeSig.DEFAULT_TIMESIG;
		if (s != null && s.trim().length() > 0) {
			try {
				String[] parts = s.split("/");
				ts = new MMTimeSig(new TimeSignature(Integer.parseInt(parts[0]), 
						Integer.parseInt(parts[1])), null);
			} catch (Exception e) {
				System.err.println("Invalid time sig: " + s);
			}
		}
		notesFromMidi.setTimeSig(ts);
	}
	
	private class JavaSynthReceiver extends MessageParser implements Receiver {

		
		private javax.sound.midi.Synthesizer synth;
		MidiChannel[] channels;

		public JavaSynthReceiver(javax.sound.midi.Synthesizer synth) throws MidiUnavailableException {
			this.synth = synth;
			synth.open();
			channels = synth.getChannels();
		}

		@Override
		public void send(MidiMessage message, long timeStamp) {
			parse(message.getMessage());
		}

		
		@Override
		public void noteOn(int channel, int pitch, int velocity) {
			channels[channel].noteOn(pitch, velocity);
		}

		@Override
		public void noteOff(int channel, int pitch, int velocity) {
			channels[channel].noteOff(pitch, velocity);
		}

		
		@Override
		public void close() {
			// TODO Auto-generated method stub
			
		}
		
	}



}
