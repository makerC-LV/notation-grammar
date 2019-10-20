package shiva.swing.midicomponents;

import java.awt.Color;
import java.util.Arrays;

import org.jfugue.theory.Note;

import shiva.swing.components.SuggestingTextField;

@SuppressWarnings("serial")
public class DrumChooser extends SuggestingTextField {

	public DrumChooser(int chars) {
		super(chars, Arrays.asList(Note.PERCUSSION_NAMES));
		setBackground(new Color(0xFFFFEE));
	}

	
}
