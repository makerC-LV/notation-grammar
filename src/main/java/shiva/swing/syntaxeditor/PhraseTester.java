package shiva.swing.syntaxeditor;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.theory.TimeSignature;

import shiva.metamusic.MMTempo;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.util.CaptureKeyboard;
import shiva.metamusic.util.KeyboardModel;
import shiva.metamusic.util.Metronome;
import shiva.metamusic.util.MidiUtils;
import shiva.midi.DeviceUtils;
import shiva.swing.components.TablePanel;
import shiva.swing.components.Util;
import shiva.swing.midicomponents.DeviceChooser;
import shiva.swing.midicomponents.InstrumentChooser;
import shiva.swing.music.KeyboardPane;

@SuppressWarnings("serial")
public class PhraseTester extends TablePanel {

	JTextArea phrasePane = new JTextArea();
	JToggleButton recordButton = Util.recordPauseButton();

	CaptureKeyboard ck;
	JTextField timeSigField = new JTextField(4);
	JTextField tempoField = new JTextField(4);
	InstrumentChooser ic = new InstrumentChooser(8);
	DeviceChooser inputChooser = new DeviceChooser(DeviceChooser.Type.INPUT);
	JComboBox channelChooser = new JComboBox<Integer>(new Integer[] {0, 1, 2, 3, 4 , 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
	Metronome metro = new Metronome();
	
	public PhraseTester(CaptureKeyboard ck, KeyboardModel model) {
		this.ck = ck;

		table.addCell(recordButton).left();
		table.addCell(inputChooser).expandX().fillX();

		table.addCell(new JLabel("Channel:")).left();
		table.addCell(channelChooser).left();
		
		table.addCell(new JLabel("Tempo:")).left();
		table.addCell(tempoField).left();
		
		table.row();
		
		table.addCell(new JLabel("Instr:")).left();
		table.addCell(ic).left().expandX().fillX().colspan(3);

		table.addCell(new JLabel("Time sig:")).left();
		table.addCell(timeSigField).left();
		

		table.row();

		table.addCell(new KeyboardPane(model)).colspan(6).expandX().fill().height(100);

		table.row();
		table.addCell(new JScrollPane(phrasePane)).colspan(6).expand().fill();

		phrasePane.setWrapStyleWord(true);
		phrasePane.setLineWrap(true);

		metro.addMetronomeListener(()-> {
			ck.setTempo(getTempo());
			ck.setTimeSig(getTimeSig());
			ck.start();
		});
		
		recordButton.addActionListener(e -> {
			if (recordButton.isSelected()) {
				metro.setUp(getTimeSig(), getTempo());
				metro.start();
				
			} else {
				metro.stop();
				ck.stop();
				phrasePane.setText(ck.getNotes().toSong4());
			}
		});

		ic.addActionListener(e -> {
			String inst = ic.getText();
			int instNum = MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get(inst.toUpperCase());
			ck.setInstrument(instNum);
		});
		
		inputChooser.addDeviceListener(dev->{
			ck.setInputDevice(dev);
			});
		channelChooser.addActionListener(e -> {
			ck.setChannel((int) channelChooser.getSelectedItem());
		});
	}

	private MMTempo getTempo() {
		MMTempo tempo = MMTempo.DEFAULT_TEMPO;
		String s = tempoField.getText();
		if (s != null && s.trim().length() > 0) {
			try {
				int bpm = Integer.parseInt(s);
				tempo = new MMTempo(bpm, null);
			} catch (Exception e) {
				System.err.println("Invalid tempo: " + s);
				e.printStackTrace();
			}
		}
		return tempo;
	}

	private MMTimeSig getTimeSig() {
		MMTimeSig ts = MMTimeSig.DEFAULT_TIMESIG;
		String s = timeSigField.getText();
		if (s != null && s.trim().length() > 0) {
			try {
				String[] parts = s.split("/");
				ts = new MMTimeSig(new TimeSignature(Integer.parseInt(parts[0]), 
						Integer.parseInt(parts[1])), null);
			} catch (Exception e) {
				System.err.println("Invalid time sig: " + s);
			}
		}
		return ts;
	}

	public static void main(String[] args) {
		KeyboardModel model = new KeyboardModel(2);
		
		CaptureKeyboard ck = new CaptureKeyboard(
				DeviceUtils.getInputDevice("USB"),
				DeviceUtils.getOutputDevice("Fluid")
				);
		ck.addReceiver(model);
		Util.showInFrame(new PhraseTester(
				ck,
				model));
		
	}

}
