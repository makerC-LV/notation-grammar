package shiva.swing.music;

import java.awt.Color;

import javax.swing.JToggleButton;
import javax.swing.border.MatteBorder;

import shiva.swing.components.TablePanel;
import shiva.swing.components.Util;

@SuppressWarnings("serial")
public class VoiceControlsPanel extends TablePanel {

	
	private JToggleButton muteButton = Util.muteButton();
	private JToggleButton soloButton = Util.soloButton();
//	private InstrumentChooser instrument = new InstrumentChooser();
//	FormPanel voicePanel = new FormPanel(2, 2);
	
	public VoiceControlsPanel() {
		super();

		
		table.pad(2);
		//table.columnDefaults(1).expand().fillX();
		
		table.addCell(muteButton);
		//table.addCell(voicePanel);
		
		table.row();
		
		table.addCell(soloButton);
		//table.addCell(instrument);
		setBorder(new MatteBorder(0, 0, 0, 1, Color.gray));
	}

	public JToggleButton getSoloButton() {
		return soloButton;
	}

	
}
