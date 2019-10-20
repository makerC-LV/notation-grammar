package shiva.swing.music;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.theory.Note;

import shiva.metamusic.util.MidiUtils;
import shiva.swing.components.SuggestingTextField;
import shiva.swing.midicomponents.DrumChooser;
import shiva.swing.midicomponents.InstrumentChooser;

@SuppressWarnings("serial")
class VoiceStatusPanel extends JPanel {
	
	private static int voiceNumber;

	private JTextField voiceField = new JTextField(6);
	private SuggestingTextField instrumentField;

	private boolean percussion;
	
//	JButton editButton = Util.editButton();

//	String voiceName = "";
//	String instrument = "";

	public VoiceStatusPanel(boolean percussion) {
		super();
		this.percussion = percussion;
		voiceField.setText("Voice" + voiceNumber++);
		
		
		
		instrumentField =  percussion ? new DrumChooser(12) : new InstrumentChooser(12);
			
		instrumentField.setText(percussion? MidiUtils.DEFAULT_PERCUSSION_NAME : MidiUtils.DEFAULT_INSTRUMENT_NAME);
		
		add(voiceField);
		add(instrumentField);
		

	}

	

}