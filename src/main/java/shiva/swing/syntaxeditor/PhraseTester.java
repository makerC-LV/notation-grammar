package shiva.swing.syntaxeditor;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import org.jfugue.midi.MidiDictionary;

import shiva.metamusic.util.CaptureKeyboard;
import shiva.metamusic.util.MidiUtils;
import shiva.midi.DeviceUtils;
import shiva.swing.components.TablePanel;
import shiva.swing.components.Util;
import shiva.swing.midicomponents.InstrumentChooser;

@SuppressWarnings("serial")
public class PhraseTester extends TablePanel {
	
	JTextArea phrasePane = new JTextArea();
	JToggleButton recordButton = Util.recordPauseButton();
	
	CaptureKeyboard ck;
	JTextField timeSigField = new JTextField(4);
	JTextField tempoField = new JTextField(4);
	InstrumentChooser ic = new InstrumentChooser(8);
	
	public PhraseTester(CaptureKeyboard ck) {
		this.ck = ck;
		
		table.addCell(recordButton).left();
		table.addCell(new JLabel("Tempo:")).left();
		table.addCell(tempoField).left();
		
		table.addCell(new JLabel("Time sig:")).left();
		table.addCell(timeSigField).left();
		
		table.addCell(new JLabel("Instr:")).left();
		table.addCell(ic).left().expandX().fillX();
		
		table.row();
		table.addCell(new JScrollPane(phrasePane)).colspan(7).expand().fill();
		
		phrasePane.setWrapStyleWord(true);
		phrasePane.setLineWrap(true);
		
		recordButton.addActionListener(e-> {
			if (recordButton.isSelected()) {
				ck.setTempo(tempoField.getText());
				ck.setTimeSig(timeSigField.getText());
				ck.start();
			} else {
				ck.stop();
				phrasePane.setText(ck.getNotes().toSong4());
			}
		});
		
		ic.addActionListener(e-> {
			String inst = ic.getText();
			int instNum = MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get(inst.toUpperCase());
			ck.setInstrument(instNum);
		});
	}
	
	public static void main(String[] args) {
		Util.showInFrame(new PhraseTester(
				new CaptureKeyboard(
						DeviceUtils.getInputDevice("USB"),
						DeviceUtils.getOutputDevice("Fluid")
						)));
		
	}

}
