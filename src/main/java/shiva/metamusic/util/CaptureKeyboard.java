package shiva.metamusic.util;

import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
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
    private MidiDevice synth;
    int channel = 0;
    
    
	public static void main(String[] args) throws MidiUnavailableException, IOException, InterruptedException {
		CaptureKeyboard ck = new CaptureKeyboard();
		ck.setInputDevice(DeviceUtils.getInputDevice("USB"));
		//ck.setOutputDevice(JSynSynthesizer.INSTANCE);
//		ck.setOutputDevice(DeviceUtils.getOutputDevice("Gervill"));
		ck.setOutputDevice(DeviceUtils.getOutputDevice("Fluid"));
		ck.setTempo(MMTempo.DEFAULT_TEMPO);
		Util.showInFrame(new JLabel("Wait"));
	}
	
	
	
	public CaptureKeyboard() {
		super(false);
	}
	
	public CaptureKeyboard(MidiDevice keyboard, MidiDevice synth) {
		this();
		setup(keyboard, synth);
		
	}
	
	public void setChannel(int chan) {
		this.channel = chan;
	}
	
	
	@Override
	public void send(MidiMessage message, long timeStamp) {
		if (message instanceof ShortMessage) {
			ShortMessage msg = (ShortMessage) message;
			if (msg.getChannel() != channel) {
				try {
					ShortMessage repl = new ShortMessage(msg.getCommand(), channel, msg.getData1(), msg.getData2());
					message = repl;
				} catch (InvalidMidiDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		super.send(message, timeStamp);
	}



	public void setInputDevice(MidiDevice input) {
		System.out.println("CaptureKeyboard: setInputDevice: " + input.getDeviceInfo().getName());
		if (input == keyboard) {
			return;
		}
		if (keyboard != null) {
			removeDeviceFromTransmitters(keyboard);
			//keyboard.close();
		}
		keyboard = input;
		if (synth != null) {
			setup(keyboard, synth);
		}
		
		
	}
	
	public void setOutputDevice(MidiDevice output) {
		System.out.println("CaptureKeyboard: setOutputDevice: " + output.getDeviceInfo().getName());
		if (output == synth) {
			return;
		}
		if (synth != null) {
			removeDeviceFromReceivers(synth);
			//synth.close();
		}
		synth = output;
		if (keyboard != null) {
			setup(keyboard, synth);
		}
		
		
	}
	
	private void setup(MidiDevice keyboard, MidiDevice synth) {

//		removeAllTransmitters();
//		removeAllReceivers();
		try {
			//keyboard.close();
			//synth.close();
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
		return notesFromMidi.getNotes();
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
	
	public void setTempo(MMTempo tempo) {
		
		notesFromMidi.setTempo(tempo);
	}
	
	public void setTimeSig(MMTimeSig ts) {
		
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
