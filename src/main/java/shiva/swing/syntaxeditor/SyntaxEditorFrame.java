package shiva.swing.syntaxeditor;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;


/**
 * Generic syntax editor framework which has a main view, a left
 * view, a bottom view, a right view, a toolbar and/or a menubar.
 * 
 * @author shiva
 *
 */
@SuppressWarnings("serial")
public class SyntaxEditorFrame extends JFrame {

	protected JComponent mainView;
	protected JComponent leftView;
	protected JComponent bottomView;
	protected JComponent rightView;
	
	
	protected JSplitPane leftAndRest = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	protected JSplitPane centerAndRight = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	protected JSplitPane topAndBottom = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	
	public SyntaxEditorFrame(String title) throws HeadlessException {
		super(title);
		
		leftAndRest.setUI(new CleanSplitPaneUI());
		centerAndRight.setUI(new CleanSplitPaneUI());
		topAndBottom.setUI(new CleanSplitPaneUI());
		
		leftAndRest.setContinuousLayout(true);
		centerAndRight.setContinuousLayout(true);
		topAndBottom.setContinuousLayout(true);
		
		leftAndRest.setResizeWeight(0);
		centerAndRight.setResizeWeight(1);
		topAndBottom.setResizeWeight(1);
		
		
		leftAndRest.setRightComponent(centerAndRight);
		centerAndRight.setLeftComponent(topAndBottom);
		
		getContentPane().setLayout(new BorderLayout());
		
		getContentPane().add(leftAndRest, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				if (canClose()) {
					System.exit(0);
				}
			}
			
		});
		
		
	}

	public boolean canClose() {
		return true;
	}

	public JComponent getMainView() {
		return mainView;
	}


	public void setMainView(JComponent mainView) {
		this.mainView = mainView;
		topAndBottom.setTopComponent(mainView);
	}


	public JComponent getLeftView() {
		return leftView;
	}


	public void setLeftView(JComponent leftView) {
		this.leftView = leftView;
		leftAndRest.setLeftComponent(leftView);
	}


	public JComponent getBottomView() {
		return bottomView;
	}


	public void setBottomView(JComponent bottomView) {
		this.bottomView = bottomView;
		topAndBottom.setBottomComponent(bottomView);
	}


	public JComponent getRightView() {
		return rightView;
	}


	public void setRightView(JComponent rightView) {
		this.rightView = rightView;
		centerAndRight.setRightComponent(rightView);
	}

	/** Sets the proportion of the view that the left, right and bottom panels should occupy. */
	public void setLocations(double left, double right, double bottom) {
		leftAndRest.setDividerLocation(left);
		centerAndRight.setDividerLocation(1 - right);
		topAndBottom.setDividerLocation(1 - bottom);
	}
	
	
	

}
