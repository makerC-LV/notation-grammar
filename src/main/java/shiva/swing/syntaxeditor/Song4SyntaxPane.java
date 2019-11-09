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
		getTextArea().setRows(25);
		getTextArea().setColumns(100);
		getTextArea().setSyntaxEditingStyle("text/song4");
		getTextArea().requestFocusInWindow();
		getTextArea().setMarkOccurrences(true);
		getTextArea().setCodeFoldingEnabled(true);
		getTextArea().setClearWhitespaceLinesEnabled(false);
		getTextArea().setTabSize(4);
		getTextArea().setTabsEmulated(true);
		getTextArea().setAnimateBracketMatching(false);
		getTextArea().setPaintMatchedBracketPair(true);
		getTextArea().setCodeFoldingEnabled(true);
		Theme theme;
		try {
			theme = Theme.load(getClass().getResourceAsStream(
//			           "/org/fife/ui/rsyntaxtextarea/themes/dark.xml"));
					"/song4-dark.xml"));
			theme.apply(getTextArea());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getTextArea().addParser(parser);

		getTextArea().addPropertyChangeListener(RSyntaxTextArea.PARSER_NOTICES_PROPERTY, e -> {
			// List<ParserNotice> notices = textArea.getParserNotices();
//                    System.out.println("Parser notices changed");
			// refreshErrorTable(notices);
		});

		
		
		scrollPane = new RTextScrollPane(getTextArea());
		setLayout(new BorderLayout());
		add(getScrollPane(), BorderLayout.CENTER);

	}


	public void reparse() {
		getTextArea().forceReparsing(0);
	}

	@Override
	public JComponent getComponent() {
		return this;
	}

	@Override
	public boolean closeRequested() {
		return getFileHandler().closeFile();
	}

	@Override
	public String getTitle() {
		File f = getFileHandler().getFile();
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
		return getTextArea().getText();
	}

	@Override
	public boolean isDirty() {
		return ((TextEditorPane) getTextArea()).isDirty();
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
		File f = getFileHandler().getFile();
		if (myPane != null && f != null) {
			myPane.setTitleFor(this, f.getName());
		}

	}

	public RSyntaxTextArea getTextArea() {
		return textArea;
	}

	public RTextScrollPane getScrollPane() {
		return scrollPane;
	}

	public Song4FileHandler getFileHandler() {
		return fileHandler;
	}

	public class Song4FileHandler extends FileOpenSaveCloseHandler {

		public Song4FileHandler(FileEditor editor) {
			super(editor);
		}

		@Override
		protected void open(File selectedFile) {

			FileLocation loc = FileLocation.create(selectedFile);
			try {
				((TextEditorPane) getTextArea()).load(loc, null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		protected void write(File file, String contents) {
			try {

				FileLocation loc = FileLocation.create(file);
				((TextEditorPane) getTextArea()).saveAs(loc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editor.onSave();
		}

	}

}
