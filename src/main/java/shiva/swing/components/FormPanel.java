package shiva.swing.components;

import static shiva.swing.components.Util.label;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import com.esotericsoftware.tablelayout.swing.Table;

public class FormPanel extends TablePanel {

	//FormLayout myLayout;
	
	private Map<String, JLabel> labels = new LinkedHashMap<>();
	private Map<String, Component> components = new LinkedHashMap<>();
	
	
	
	public FormPanel(int xgap, int ygap) {
		super();
		table.columnDefaults(1).expandX().fillX();
		table.pad(2);
//		table.debug();

//		myLayout = new FormLayout(this, xgap, ygap);
//		setLayout(myLayout);
		
	}
	
	public void addFormElement(String label, Component comp) {
//		myLayout.add(label, comp);
		
		if (!labels.isEmpty()) {
			table.row();
		}
		JLabel jlabel = label(label);
		table.addCell(jlabel).right().space(2);
		table.addCell(comp).space(2);
		labels.put(label, jlabel) ;
		components.put(label, comp);
		
	}
	
	public Component getComponent(String label) {
		return components.get(label);
	}
	
	private static class FormLayout implements LayoutManager {

		private Map<String, JLabel> labels = new LinkedHashMap<>();
		private Map<String, Component> components = new LinkedHashMap<>();
		private FormPanel formPanel;
		private int xgap;
		private int ygap;
		
		public FormLayout(FormPanel formPanel, int xgap, int ygap) {
			this.formPanel = formPanel;
			this.xgap = xgap;
			this.ygap = ygap;
		}

		@Override
		public void addLayoutComponent(String name, Component comp) {
			// TODO Auto-generated method stub
			
		}

		public void add(String label, Component comp) {
			JLabel jlabel = label(label);
			formPanel.add(jlabel);
			formPanel.add(comp);
			labels.put(label, jlabel) ;
			components.put(label, comp);
			
		}

		@Override
		public void removeLayoutComponent(Component comp) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Dimension preferredLayoutSize(Container parent) {
			int maxWidth = getMaxPreferredWidth(labels.values()) +
					getMaxPreferredWidth(components.values()) +
					4 * xgap;
			
			int maxHeight = Math.max(getSumPreferredHeight(labels.values()),
					getSumPreferredHeight(components.values())) +
					(labels.size() + 1) * ygap;
			Dimension d = new Dimension(maxWidth, maxHeight);
//			System.out.println("Pref" + d);
			return d;
		}

		private int getSumPreferredHeight(Collection<? extends Component> values) {
			int sum = 0;
			for (Component c : values) {
				sum += c.getPreferredSize().height;
			}
			return sum;
		}

		private int getMaxPreferredWidth(Collection<? extends Component> values) {
			int max = 0;
			for (Component c : values) {
				int w = c.getPreferredSize().width;
				if (w > max) {
					max = w;
				}
			}
			return max;
		}

		@Override
		public Dimension minimumLayoutSize(Container parent) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void layoutContainer(Container parent) {
			Dimension d = parent.getSize();
			int leftColumnWidth = getMaxPreferredWidth(labels.values()) + 2 * xgap ;
			
			int rightColumnwidth = d.width - leftColumnWidth + 2 * xgap;
			
			List<JLabel> llist = new ArrayList<>(labels.values());
			List<Component> clist = new ArrayList<>(components.values());
			int y = ygap;
			for (int i = 0; i < llist.size(); i++) {
				JLabel label = llist.get(i);
				Component comp = clist.get(i);
				int h = Math.max(getPH(label), getPH(comp));
				rightAlign(label, xgap, y, leftColumnWidth - 2 * xgap, h);
				leftAlighAndStretch(comp, leftColumnWidth + xgap, y, d.width - leftColumnWidth - 2 * xgap, h);
//				System.out.println(label.getBounds());
				y += h + ygap;
			}
			
		}

		private void leftAlighAndStretch(Component c, int x, int y, int w, int h) {
			Dimension d = c.getPreferredSize();
			int ry =  y + (h - d.height)/2;
			c.setBounds(x, ry, w, d.height);
			
		}

		private void rightAlign(Component c, int x, int y, int w, int h) {
			Dimension d = c.getPreferredSize();
			int rx = x + w - d.width;
			int ry = y + (h - d.height)/2;
			c.setBounds(rx, ry, d.width, d.height);
		}

		private int getPH(Component comp) {
			return comp.getPreferredSize().height;
		}
		
	}
	
}
