package shiva.music.generate.counterpoint;

import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.swing.JComboBox;

import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.util.PlayUtils;
import shiva.swing.components.Util;

public class PlayGenerated {

	public static void main(String[] args) {
		CounterpointMelody melody = new CounterpointMelody(8, 4, 1);
		
		List<Voice> solutions = new BNB().generate(melody, Species.CANTUS, 5000);
		System.out.println("Generated: " + solutions.size());
		JComboBox<Voice> jl = new JComboBox<>(solutions.toArray(new Voice[0]));
		
		jl.addActionListener(e->  {
			Voice v = (Voice) jl.getSelectedItem();
			try {
				PlayUtils.playNotes(v.toNoteList(MMKeySig.DEFAULT_KEYSIG, MMTimeSig.DEFAULT_TIMESIG));
			} catch (MidiUnavailableException | InvalidMidiDataException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});Util.showInFrame(jl);
		
		
	}
}
