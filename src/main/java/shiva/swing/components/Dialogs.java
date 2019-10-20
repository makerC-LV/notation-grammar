package shiva.swing.components;

import java.util.function.Function;

import javax.swing.JOptionPane;

public class Dialogs {

	
	public static boolean confirmDialog(String message, String title) {
		return JOptionPane.showConfirmDialog(
				
				null, message, title, JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION;
	}

	public static  void acceptRejectCancelDialog(String message, String acceptS, String rejectS, String cancelS,
			Runnable onAccept, Runnable onReject, Runnable onCancel) {
		int result = JOptionPane.showConfirmDialog(null, message);
		switch (result) {
		case JOptionPane.YES_OPTION:
			onAccept.run();
		case JOptionPane.NO_OPTION:
			onReject.run();
		case JOptionPane.CANCEL_OPTION:
			onCancel.run();
			
		}
		
	}
}
