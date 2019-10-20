package shiva.swing.components;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.esotericsoftware.tablelayout.swing.Table;

/**
 * Required because a Table does not fill it's parent. This class forces it's table to fill it.
 * @author shiva
 *
 */
public class TablePanel extends JPanel {
	
	protected Table table = new Table();

	public TablePanel() {
		super();
		
		setLayout(new BorderLayout());
		add(table, BorderLayout.CENTER);
	}
	
	
	
	
}
