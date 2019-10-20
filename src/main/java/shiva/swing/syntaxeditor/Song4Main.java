package shiva.swing.syntaxeditor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.tree.DefaultTreeModel;

import org.antlr.v4.runtime.tree.ParseTree;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.parser.ParserNotice;
import org.fife.ui.rtextarea.Gutter;

import com.esotericsoftware.tablelayout.swing.Table;

import shiva.metamusic.util.PlayUtils;
import shiva.song4.Song4Lexer;
import shiva.song4.Song4Parser;
import shiva.swing.components.Dialogs;
import shiva.swing.components.Util;
import shiva.swing.midicomponents.PlayControls;
import shiva.swing.midicomponents.PlayControls.SequenceProvider;
import shiva.swing.syntaxeditor.ErrorTable.ErrorTableModel;
import shiva.swing.syntaxeditor.STabbablePane.Tabbable;



public class Song4Main implements PropertyChangeListener, SequenceProvider {
	
	
	SyntaxEditorFrame frame;
	
	STabbablePane tabPane;
	
	private ErrorTable errorTable;
	private ErrorTableModel errorTableModel;
	private Song4OutlineTree tree = new Song4OutlineTree();
	
	Song4Parsing parsing = new Song4Parsing(new Song4Lexer(null), new Song4Parser(null));
	Song4RSTAParser parser = new Song4RSTAParser(parsing);
	PlayControls controls = new PlayControls(this);
	
	private void setup() {
		frame = new SyntaxEditorFrame("Song4") {

			@Override
			public boolean canClose() {
				if (dirtyPanelsExist()) {
					return Dialogs.confirmDialog("Some panels have unsaved changes. Really exit?", "");
				}
				return true;
			}
			
		};
		tabPane = new STabbablePane() {

			@Override
			boolean closeRequested(int index, Tabbable tabbable) {
				return tabbable.closeRequested();
			}
			
		};
		
		tabPane.tabbedPane.addChangeListener(e -> {
			tabChanged();
		});
		
		frame.setMainView(tabPane);
		
		
		String[] columnNames = { "", "Line", "Error" };
		errorTableModel = new ErrorTableModel(columnNames, 0);
		errorTable = new ErrorTable(errorTableModel);
		JScrollPane errorTableScrollPane = new JScrollPane(errorTable);
		frame.setBottomView(errorTableScrollPane);
		
		JScrollPane treeSp = new JScrollPane(tree);
		frame.setLeftView(treeSp);
		
		frame.getContentPane().add(createToolBar(), BorderLayout.NORTH);
		
		
		actionNew();
		
		
		frame.setBounds(100, 100, 600, 500);
		SwingUtilities.invokeLater(() -> {
			frame.setLocations(0.25, 0.25, 0);
		});
		
		
	}
	
	protected boolean dirtyPanelsExist() {
		for (int i = 0; i < tabPane.tabbedPane.getTabCount(); i++) {
			Song4SyntaxPane syntaxpane = (Song4SyntaxPane) tabPane.tabbedPane.getComponentAt(i);
			if (syntaxpane.isDirty()) {
				return true;
			}
		}
		return false;
	}

	private Component createToolBar() {
		JToolBar toolbar = new JToolBar();
		toolbar.setLayout(new BorderLayout());
		Table table = new Table();
		
		
		add(table, Util.newButton(), "New", e ->{ actionNew();} );
		add(table, Util.openButton(), "Open", e ->{ actionOpen();} );
		add(table, Util.saveButton(), "Save", e ->{ actionSave();} );
		add(table, Util.saveAsButton(), "Save as", e ->{ actionSaveAs();} );
		
		toolbar.add(new JSeparator());
		
		table.addCell(controls).expandX().fillX();
		
//		toolbar.add(Util.copyButton());
//		toolbar.add(new JSeparator());
//		toolbar.add(Util.editButton());
		toolbar.add(table, BorderLayout.CENTER);
		return toolbar;
	}

	private void add(Table table, JButton button, String tooltip, ActionListener al) {
		table.addCell(button);
		button.addActionListener(al);
		button.setToolTipText(tooltip);
	}
//
//	private void add(JToolBar toolbar, JButton button, String tooltip, ActionListener al) {
//		toolbar.add(button);
//		button.addActionListener(al);
//		button.setToolTipText(tooltip);
//		
//	}

	
	
	private void tabChanged() {
		
		Song4SyntaxPane spane = getSelectedPane();
		if (spane != null) {
			errorTable.setTextArea(spane.textArea);
		}
		controls.onReset();
		
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Song4SyntaxPane spane = getSelectedPane();
		List<ParserNotice> notices = spane.textArea.getParserNotices();
        refreshErrorTable(spane, notices);
        refreshTreeView(notices);
		
	}

	@Override
	public Sequence buildSequence() {
		try {
			return PlayUtils.toSequence(getSelectedPane().textArea.getText());
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	private Song4SyntaxPane getSelectedPane() {
		Song4SyntaxPane spane = (Song4SyntaxPane) tabPane.tabbedPane.getSelectedComponent();
		return spane;
	}
	
	private void refreshErrorTable(Song4SyntaxPane spane, List<ParserNotice> notices) {

		Gutter gutter = spane.scrollPane.getGutter();
		gutter.removeAllTrackingIcons();
		errorTableModel.setRowCount(0);

		for (ParserNotice notice : notices) {
			if (notice.getParser()==parser) {
				boolean error = notice.getLevel()==ParserNotice.Level.ERROR;
				Icon icon = error ? Song4IconFactory.getErrorIcon(): Song4IconFactory.getWarningIcon();
				int line = notice.getLine();
				Object[] data = { icon, line + 1, notice };
				errorTableModel.addRow(data);
				try {
					gutter.addLineTrackingIcon(line, icon, notice.getToolTipText());
				} catch (BadLocationException ble) {
					ble.printStackTrace();
				}
			}
		}

	}
	
	private void refreshTreeView(List<ParserNotice> notices) {
		
		ParseTree node = parsing.getParseTree();
		if (node != null) {
			DefaultTreeModel root = ParseTreeModel.getTreeModel(node, parsing.getParser());
			tree.setModel(root);
			for (int i = 0; i < tree.getRowCount(); i++) {
				tree.expandRow(i);
			}
		} else {
			tree.setModel(ParseTreeModel.emptyModel());
		}
	}
	
	
	private Song4SyntaxPane actionNew() {
		Song4SyntaxPane syntaxPane = new Song4SyntaxPane(parser);
		
		String defaultText = "tempo 120 ;";
		
		syntaxPane.textArea.setText(defaultText);
		syntaxPane.textArea.addPropertyChangeListener(RSyntaxTextArea.PARSER_NOTICES_PROPERTY, this);
		tabPane.add((Tabbable) syntaxPane) ;
		tabPane.tabbedPane.setSelectedIndex(tabPane.tabbedPane.getTabCount()-1);
		
		setUpSaveKey(syntaxPane);
		setUpDirtyIndicator(syntaxPane);
		
		return syntaxPane;
	}

	private void setUpDirtyIndicator(Song4SyntaxPane syntaxPane) {
		syntaxPane.textArea.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				setTitleDirty();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				setTitleDirty();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
			
			private void setTitleDirty() {
				tabPane.setTitleFor(syntaxPane, "*" + syntaxPane.getTitle());
			}
			
		});
		
	}

	private void setUpSaveKey(Song4SyntaxPane syntaxPane) {
		KeyStroke saveKey = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		String SAVE = "Save";
		
		Action saveAction = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionSave();
				
			}
		};
		
		syntaxPane.textArea.getActionMap().put(SAVE, saveAction);
		
		InputMap[] inputMaps = new InputMap[] {
				syntaxPane.textArea.getInputMap(JComponent.WHEN_FOCUSED),
				syntaxPane.textArea.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT),
				syntaxPane.textArea.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW),
		};
		for(InputMap i : inputMaps) {
			i.put(saveKey,SAVE);
		}
	}
	
	private void actionOpen() {
		Song4SyntaxPane pane = actionNew();
		pane.fileHandler.openFile();
	}
	
	
	private void actionSave() {
		Song4SyntaxPane pane = getSelectedPane();
		pane.fileHandler.saveFile();
	}
	
	private void actionSaveAs() {
		Song4SyntaxPane pane = getSelectedPane();
		pane.fileHandler.saveAs();
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> {
			try {
//				try {
//				    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//				        if ("Nimbus".equals(info.getName())) {
//				        	UIManager.put( "control", new Color( 128, 128, 128) );
//				        	  UIManager.put( "info", new Color(128,128,128) );
//				        	  UIManager.put( "nimbusBase", new Color( 18, 30, 49) );
//				        	  UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 0) );
//				        	  UIManager.put( "nimbusDisabledText", new Color( 128, 128, 128) );
//				        	  UIManager.put( "nimbusFocus", new Color(115,164,209) );
//				        	  UIManager.put( "nimbusGreen", new Color(176,179,50) );
//				        	  UIManager.put( "nimbusInfoBlue", new Color( 66, 139, 221) );
//				        	  UIManager.put( "nimbusLightBackground", new Color( 18, 30, 49) );
//				        	  UIManager.put( "nimbusOrange", new Color(191,98,4) );
//				        	  UIManager.put( "nimbusRed", new Color(169,46,34) );
//				        	  UIManager.put( "nimbusSelectedText", new Color( 255, 255, 255) );
//				        	  UIManager.put( "nimbusSelectionBackground", new Color( 104, 93, 156) );
//				        	  UIManager.put( "text", new Color( 230, 230, 230) );
//				            UIManager.setLookAndFeel(info.getClassName());
//				            break;
//				        }
//				    }
//				} catch (Exception e) {
//				    // If Nimbus is not available, you can set the GUI to another look and feel.
//					UIManager.setLookAndFeel(UIManager.
//							getCrossPlatformLookAndFeelClassName());
////											getSystemLookAndFeelClassName());
//				}

				
				Song4Main s4m = new Song4Main();
				s4m.setup();
				
				s4m.frame.setVisible(true);
				
			} catch (Exception e) {
				e.printStackTrace(); // Never happens
			}
			Toolkit.getDefaultToolkit().setDynamicLayout(true);
			
		});
	}

	

	

}
