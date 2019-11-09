package shiva.swing.syntaxeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import shiva.swing.components.Util;

/**
 * A Tabbed pane with a title for each tab and closeable tabs.
 * @author shiva
 *
 */
@SuppressWarnings("serial")
abstract public class STabbablePane extends JPanel {

	JTabbedPane tabbedPane = new JTabbedPane();
	
	public STabbablePane() {
		super();
		setLayout(new BorderLayout());
		add(getTabbedPane(), BorderLayout.CENTER);
		
	}

	protected abstract boolean closeRequested(int index, Tabbable tabbable);
	
	public void add(Tabbable tabbable) {
		add(getTabbedPane().getTabCount(), tabbable);
	}
	
	public void add(int index, Tabbable tabbable) {
		getTabbedPane().add(tabbable.getComponent(), index);
		getTabbedPane().setTabComponentAt(index, new TabLabel(tabbable, this, tabbable.getTitle()));
		tabbable.setTabbablePane(this);
	}
	
	public void remove(int index) {
		getTabbedPane().remove(index);
	}
	
	public void remove(Tabbable tabbable) {
		getTabbedPane().remove(tabbable.getComponent());
	}
	
	public void setTitleFor(Tabbable tabbable, String name) {
		int index = getTabbedPane().indexOfComponent(tabbable.getComponent());
		if (index >= 0) {
			
			getTabbedPane().setTabComponentAt(index, new TabLabel(tabbable, this, name));
		}
		
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public static interface Tabbable {
		JComponent getComponent();
		
		void setTabbablePane(STabbablePane sTabbablePane);

		String getTitle();

		boolean closeRequested();
	}
	
	private class TabLabel extends JPanel {

		public TabLabel(Tabbable tabbable, STabbablePane tabbablePane, String name) {
			setOpaque(false);
			JLabel titleLabel = new JLabel(name);
			Closer closer = new Closer(tabbable, tabbablePane);
			setLayout(new BorderLayout());
			add(titleLabel, BorderLayout.CENTER);
			add(closer, BorderLayout.EAST);
			
			
		}
		
	}
	
	private class Closer extends JLabel {

		private Icon rolloverIcon = Util.closeIcon(Color.white);
		private Icon defaultIcon = Util.closeIcon(Color.darkGray);
		private STabbablePane tabbedPane;
		private Tabbable tabbable;
		
		
		public Closer(Tabbable tabbable, STabbablePane tabbablePane) {
			setIcon(defaultIcon);
			this.tabbable = tabbable;
			this.tabbedPane = tabbablePane;
			
			addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					int index = tabbedPane.getTabbedPane().indexOfComponent(tabbable.getComponent());
					if (tabbedPane.closeRequested(index, tabbable)) {
						tabbedPane.remove(tabbable);
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					setIcon(rolloverIcon);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					setIcon(defaultIcon);
				}
				
			});
		}
		
	}

	

	
	
}
