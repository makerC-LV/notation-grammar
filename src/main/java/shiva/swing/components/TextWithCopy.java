package shiva.swing.components;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextWithCopy extends JPanel {
	
	JTextField field = new JTextField();
	JButton copyButton = Util.copyButton();
	
	public TextWithCopy() {
		super();
		setLayout(new BorderLayout());
		add(copyButton, BorderLayout.WEST);
		add(field, BorderLayout.CENTER);
		copyButton.addActionListener(e -> {
			StringSelection stringSelection = new StringSelection(field.getText());
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(stringSelection, null);
		});
	}

	public void setText(String t) {
		field.setText(t);
	}

	public String getText() {
		return field.getText();
	}
	
	

}
