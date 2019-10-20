package shiva.swing.midicomponents;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.jfugue.midi.MidiDictionary;

import shiva.swing.components.SuggestingTextField;

@SuppressWarnings("serial")
public class InstrumentChooser extends SuggestingTextField {

	List<String> names;
	
	public InstrumentChooser(int chars) {
		// Use TreeMap to sort in midi number order
		super(chars, new ArrayList<>(new TreeMap<Byte, String>(MidiDictionary.INSTRUMENT_BYTE_TO_STRING).values()));
		setBackground(new Color(0xFFFFEE));
	}
	
	
}
