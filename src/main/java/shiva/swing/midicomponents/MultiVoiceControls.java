package shiva.swing.midicomponents;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.MatteBorder;

import shiva.swing.components.MaxOneButtonGroup;
import shiva.swing.components.TablePanel;
import shiva.swing.components.Util;
import shiva.swing.midicomponents.OneVoiceControls.Controllable;

@SuppressWarnings("serial")
public class MultiVoiceControls extends TablePanel {

	List<OneVoiceControls> panels = new ArrayList<>();
	private int cols;
	
	private MaxOneButtonGroup bg = new MaxOneButtonGroup();
	
	public MultiVoiceControls(int cols) {
		super();
		this.cols = cols;
		
	}

	public void add(OneVoiceControls ctl) {
		panels.add(ctl);
		int colnum = panels.size() % cols;
		if (panels.size() > 0 && colnum == 0) {
			table.row();
		}
		table.addCell(ctl).fill().center();
		if (colnum > 0) {
			ctl.setBorder(new MatteBorder(0, 2, 0, 0, Color.darkGray));
		}
		bg.add(ctl.getSoloButton());
	}
	
	public static void main(String[] args) {
		Controllable c = new Controllable() {

			@Override
			public void mute(int trackNum, boolean mute) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void volume(int channel, float value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void solo(int trackNum, boolean solo) {
				// TODO Auto-generated method stub
				
			}

			
			
		};
		MultiVoiceControls mvc = new MultiVoiceControls(6);
		for (int i = 0; i < 5; i++) {
			mvc.add(new OneVoiceControls(c, i, i, "Voice", "Long Instrument"));
		}
		Util.showInFrame(mvc);;
	}
	
}
