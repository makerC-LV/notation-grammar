package shiva.swing.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.AbstractButton;

/**
	 * Allows at most one of the member buttons to be selected at a time.
	 * @author shiva
	 *
	 */
	public class MaxOneButtonGroup extends HashSet<AbstractButton> implements ActionListener {

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