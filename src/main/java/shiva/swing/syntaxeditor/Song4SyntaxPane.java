package shiva.swing.syntaxeditor;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.fife.ui.rsyntaxtextarea.AbstractTokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.FileLocation;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.TextEditorPane;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rsyntaxtextarea.TokenMakerFactory;
import org.fife.ui.rsyntaxtextarea.parser.Parser;
import org.fife.ui.rtextarea.RTextScrollPane;

import shiva.swing.components.FileOpenSaveCloseHandler;
import shiva.swing.components.FileOpenSaveCloseHandler.FileEditor;
import shiva.swing.syntaxeditor.STabbablePane.Tabbable;

@SuppressWarnings("serial")
public class Song4SyntaxPane extends JPanel implements Tabbable, FileEditor {

	static {
		AbstractTokenMakerFactory atmf = (AbstractTokenMakerFactory) TokenMakerFactory.getDefaultInstance();
		String name = Song4TokenMaker.class.getName();
		atmf.putMapping("text/song4", name);

	}

	RSyntaxTextArea textArea;
	RTextScrollPane scrollPane;

	Song4FileHandler fileHandler = new Song4FileHandler(this);
	Parser parser;

	STabbablePane myPane;

	public Song4SyntaxPane(Song4RSTAParser parser) {
		super();
		this.parser = parser;
		textArea = new TextEditorPane();
		textArea.setRows(25);
		textArea.setColumns(100);
		textArea.setSyntaxEditingStyle("text/song4");
		textArea.requestFocusInWindow();
		textArea.setMarkOccurrences(true);
		textArea.setCodeFoldingEnabled(true);
		textArea.setClearWhitespaceLinesEnabled(false);
		textArea.setTabSize(4);
		textArea.setTabsEmulated(true);
		textArea.setAnimateBracketMatching(false);
		textArea.setPaintMatchedBracketPair(true);
		textArea.setCodeFoldingEnabled(true);
		Theme theme;
		try {
			theme = Theme.load(getClass().getResourceAsStream(
//			           "/org/fife/ui/rsyntaxtextarea/themes/dark.xml"));
					"/song4-dark.xml"));
			theme.apply(textArea);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textArea.addParser(parser);

		textArea.addPropertyChangeListener(RSyntaxTextArea.PARSER_NOTICES_PROPERTY, e -> {
			// List<ParserNotice> notices = textArea.getParserNotices();
//                    System.out.println("Parser notices changed");
			// refreshErrorTable(notices);
		});

		
		
		scrollPane = new RTextScrollPane(textArea);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);

	}


	public void reparse() {
		textArea.forceReparsing(0);
	}

	@Override
	public JComponent getComponent() {
		return this;
	}

	@Override
	public boolean closeRequested() {
		return fileHandler.closeFile();
	}

	@Override
	public String getTitle() {
		File f = fileHandler.getFile();
		if (f == null) {
			return "Untitled";
		} else {
			return f.getName();
		}
	}

	@Override
	public void setTabbablePane(STabbablePane sTabbablePane) {
		myPane = sTabbablePane;

	}

	@Override
	public void onOpen(File selectedFile, String fileString) {
		System.out.println("Song$SyntaxPane:onOpen called");
		reparse();
	}

	@Override
	public String getContents() {
		return textArea.getText();
	}

	@Override
	public boolean isDirty() {
		return ((TextEditorPane) textArea).isDirty();
	}

	@Override
	public FileNameExtensionFilter getExtensionFilter() {
		return new FileNameExtensionFilter("Song4 files", "song4");
	}

	@Override
	public boolean onClose(boolean canClose) {
		return canClose;

	}

	@Override
	public void onSave() {
		System.out.println("Onsave called");
		File f = fileHandler.getFile();
		if (myPane != null && f != null) {
			myPane.setTitleFor(this, f.getName());
		}

	}

	class Song4FileHandler extends FileOpenSaveCloseHandler {

		public Song4FileHandler(FileEditor editor) {
			super(editor);
		}

		@Override
		protected void open(File selectedFile) {

			FileLocation loc = FileLocation.create(selectedFile);
			try {
				((TextEditorPane) textArea).load(loc, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		protected void write(File file, String contents) {
			try {

				FileLocation loc = FileLocation.create(file);
				((TextEditorPane) textArea).saveAs(loc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editor.onSave();
		}

	}

}
