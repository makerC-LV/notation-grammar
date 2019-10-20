package shiva.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.esotericsoftware.tablelayout.swing.Table;

import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import shiva.swing.components.FormPanel;
import shiva.swing.components.TextWithCopy;
import shiva.swing.components.Util;
import shiva.swing.midicomponents.DrumChooser;
import shiva.swing.midicomponents.InstrumentChooser;
import shiva.swing.music.MultiVoicePanel;
import shiva.swing.music.VoiceControlsPanel;

public class App1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App1 window = new App1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App1() {
		initialize();
		frame.pack();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		initialize2();
		addContents();
	}

	private void initialize2() {
		frame.setLayout(new BorderLayout());
		
		Table table = new Table();
		
//		table.debug();
		
		frame.add(table, BorderLayout.CENTER);
		table.columnDefaults(0).expand().fill();
		
		MultiVoicePanel mvp = new MultiVoicePanel();
		table.addCell(mvp);
		
		JToolBar tb = new JToolBar();
		JButton addVoice = Util.iconButton(GoogleMaterialDesignIcons.PERSON_ADD);
		addVoice.addActionListener(e -> { mvp.addVoicePanel(false); });
		JButton addRhythm = Util.iconButton(GoogleMaterialDesignIcons.PLAYLIST_ADD);
		addRhythm.addActionListener(e -> { mvp.addVoicePanel(true); });
		
		
		tb.add(addVoice);
		tb.add(addRhythm);
		
		frame.add(tb, BorderLayout.NORTH);
		
		frame.setPreferredSize(new Dimension(400, 250));
	}
	
	private void addContents() {
		FormPanel form = new FormPanel(5, 5);
		form.addFormElement("Hello", Util.textField(20));
		form.addFormElement("Second", Util.label("Second"));
		form.addFormElement("Third", Util.button("Button"));
		form.addFormElement("Copy", Util.copyButton());
		form.addFormElement("TextCopy", new TextWithCopy());
		form.addFormElement("Instrument", new InstrumentChooser(10));
		form.addFormElement("Percussion", new DrumChooser(10));
		form.addFormElement("Mute", Util.muteButton());
		form.addFormElement("Solo", Util.soloButton());
		form.addFormElement("VoiceInfo", new VoiceControlsPanel());
		form.addFormElement("Slider", new JSlider());
		form.setPreferredSize(new Dimension(400, 250));
		frame.add(form);

	}

}
