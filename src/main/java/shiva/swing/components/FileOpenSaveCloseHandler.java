package shiva.swing.components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileOpenSaveCloseHandler {

	
	public static interface FileEditor {


		void onOpen(File selectedFile, String fileString);

		String getContents();

		boolean isDirty();

		FileNameExtensionFilter getExtensionFilter();

		boolean onClose(boolean canClose);

		void onSave();
		
	}
	
	protected FileEditor editor;
	protected File currentFile;

	public FileOpenSaveCloseHandler(FileEditor editor) {
		super();
		this.editor = editor;
	}
	
	public File getFile() {
		return currentFile;
	}
	
	public void openFile() {
		
		JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = editor.getExtensionFilter();
        		
        		/* new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif"); */
        if (filter != null) {
        	chooser.setFileFilter(filter);
        }
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {

        	open(chooser.getSelectedFile());
        }
	}
	
	protected void open(File selectedFile) {
		
		String fileString;
		try {
			fileString = new String ( Files.readAllBytes( Paths.get(selectedFile.getPath()) ) );
			currentFile = selectedFile;
			editor.onOpen(selectedFile, fileString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void saveFile() {
		if (currentFile == null) {
			saveAs();
		} else {
			write(currentFile, editor.getContents());
		}
	}

	
	
	public void saveAs() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save as...");   
		 
		int userSelection = fileChooser.showSaveDialog(null);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    currentFile = fileToSave;
		    write(fileToSave, editor.getContents());
		}
	}
	
	
	protected void write(File file, String contents) {
		try (PrintWriter out = new PrintWriter(file)) {
		    out.println(contents);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		editor.onSave();
	}

	public boolean closeFile() {
		boolean canClose = true;
		if (editor.isDirty()) {
			int result = JOptionPane.showConfirmDialog(null, "The contents have changed. Would you like to save?");
			switch (result) {
			case JOptionPane.YES_OPTION:
				saveFile();
				break;
			case JOptionPane.NO_OPTION:
				break;
			case JOptionPane.CANCEL_OPTION:
				canClose = false;
			} 
		} 
		return editor.onClose(canClose);
	}
}
