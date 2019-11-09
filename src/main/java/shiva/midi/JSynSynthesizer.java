package shiva.midi;

import java.util.Arrays;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

import com.jsyn.JSyn;
import com.jsyn.instruments.SubtractiveSynthVoice;
import com.jsyn.instruments.WaveShapingVoice;
import com.jsyn.midi.MessageParser;
import com.jsyn.unitgen.LineOut;
import com.jsyn.unitgen.UnitSource;
import com.jsyn.unitgen.UnitVoice;
import com.jsyn.util.PolyphonicInstrument;
import com.jsyn.util.VoiceDescription;
import com.softsynth.math.AudioMath;
import com.softsynth.shared.time.TimeStamp;

public class JSynSynthesizer implements MidiDevice {

	public static JSynSynthesizer INSTANCE = new JSynSynthesizer();

	com.jsyn.Synthesizer synth = JSyn.createSynthesizer();
	JSynReceiver jsynReceiver = new JSynReceiver(synth);

	private JSynSynthesizer() {
		//jsynReceiver.presetSelected(WaveShapingVoice.getVoiceDescription(), 0);
		jsynReceiver.presetSelected(SubtractiveSynthVoice.getVoiceDescription(), 2);
	}

	@Override
	public Info getDeviceInfo() {
		return new MidiDevice.Info("Jsyn", "Jsyn", "Synth", "1.0") {

		};
	}

	@Override
	public void open() throws MidiUnavailableException {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isOpen() {
		return true;
	}

	@Override
	public long getMicrosecondPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxReceivers() {
		return 1;
	}

	@Override
	public int getMaxTransmitters() {
		return 0;
	}

	@Override
	public Receiver getReceiver() throws MidiUnavailableException {
		return jsynReceiver;
	}

	@Override
	public List<Receiver> getReceivers() {
		return Arrays.asList(jsynReceiver);
	}

	@Override
	public Transmitter getTransmitter() throws MidiUnavailableException {
		return null;
	}

	@Override
	public List<Transmitter> getTransmitters() {
		return null;
	}

	private class JSynReceiver extends MessageParser implements Receiver {

		private com.jsyn.Synthesizer synth;
		LineOut lineOut = new LineOut();
		PolyphonicInstrument instrument;

		public JSynReceiver(com.jsyn.Synthesizer synth) {
			this.synth = synth;
			synth.add(lineOut);
		}

		@Override
		public void send(MidiMessage message, long timeStamp) {
			System.out.println("Message: " + message.getLength() + "  " + Arrays.toString(message.getMessage()));
			parse(message.getMessage());
			MidiEvent me = new MidiEvent(message, timeStamp);

		}

		@Override
		public void noteOff(int channel, int noteNumber, int velocity) {
			instrument.noteOff(noteNumber, synth.createTimeStamp());
		}

		@Override
		public void noteOn(int channel, int noteNumber, int velocity) {
			double frequency = AudioMath.pitchToFrequency(noteNumber);
			double amplitude = velocity / (4 * 128.0);
			TimeStamp timeStamp = synth.createTimeStamp();
			instrument.noteOn(noteNumber, frequency, amplitude, timeStamp);
		}

		@Override
		public void close() {
			// TODO Auto-generated method stub

		}

		public void presetSelected(VoiceDescription voiceDescription, int presetIndex) {
			UnitVoice[] voices = new UnitVoice[8];
			for (int i = 0; i < voices.length; i++) {
				voices[i] = voiceDescription.createUnitVoice();
			}
			instrument = new PolyphonicInstrument(voices);
			synth.add(instrument);
			instrument.usePreset(presetIndex, synth.createTimeStamp());
			String title = voiceDescription.getVoiceClassName() + ": " + voiceDescription.getPresetNames()[presetIndex];
			useSource(instrument, title);
		}

		private void useSource(UnitSource voice, String title) {

			lineOut.input.disconnectAll(0);
			lineOut.input.disconnectAll(1);

			// Connect the source to both left and right output.
			voice.getOutput().connect(0, lineOut.input, 0);
			voice.getOutput().connect(0, lineOut.input, 1);

			try {
				if (synth.isRunning()) {
					synth.sleepFor(0.1);
				}
				// Start synthesizer using default stereo output at 44100 Hz.
				synth.start();
				// We only need to start the LineOut. It will pull data from the
				// oscillator.
				lineOut.start();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
