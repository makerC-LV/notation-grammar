package shiva.swing.music;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.border.MatteBorder;

import shiva.swing.components.TablePanel;

@SuppressWarnings("serial")
public class MultiVoicePanel extends TablePanel {

	private List<VoicePanel> voices = new ArrayList<>();
	
	private MaxOneButtonGroup bg = new MaxOneButtonGroup();
	
	public MultiVoicePanel() {
		super();
		table.columnDefaults(0).expand().fill();
	}

	public VoicePanel addVoicePanel(boolean percussion) {
		VoicePanel vp = new VoicePanel(percussion);
		vp.setBorder(new MatteBorder(1, 0, 0, 0, Color.gray));
		bg.add(vp.getInfoPanel().getSoloButton());
		if (!voices.isEmpty()) {
			table.row();
		}
		voices.add(vp);
		table.addCell(vp);
		revalidate();
		return vp;
	}
	
	/**
	 * Allows at most one of the member buttons to be selected at a time.
	 * @author shiva
	 *
	 */
	private class MaxOneButtonGroup extends HashSet<AbstractButton> implements ActionListener {

		@Override
		public boolean add(AbstractButton e) {
			e.addActionListener(this);
			return super.add(e);
		}

		@Override
		public boolean remove(Object o) {
			AbstractButton b = (AbstractButton) o;
			b.removeActionListener(this);
			return super.remove(o);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractButton b = (AbstractButton) e.getSource();
			if (b.isSelected()) {
				for (AbstractButton ab: this) {
					if (ab != b) {
						ab.setSelected(false);
					}
				}
			} else {
				// do nothing
			}
			
		}
		
		
		
		
	}
}
