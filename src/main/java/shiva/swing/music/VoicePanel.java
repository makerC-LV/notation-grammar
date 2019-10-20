package shiva.swing.music;

import com.esotericsoftware.tablelayout.swing.Table;

import shiva.swing.components.TablePanel;
import shiva.swing.components.TextWithCopy;

@SuppressWarnings("serial")
public class VoicePanel extends TablePanel {

	private VoiceControlsPanel controls = new VoiceControlsPanel();
	private TextWithCopy text = new TextWithCopy();
	private VoiceStatusPanel status;
	
	public VoicePanel(boolean percussion) {
		super();
		status = new VoiceStatusPanel(percussion);
		table.columnDefaults(1).expandX().fillX();
		
		Table rightTable = new Table();
		table.addCell(controls);
		table.addCell(rightTable);
		
		rightTable.addCell(text).expandX().fillX();
		rightTable.row();
		rightTable.addCell(status).left();
		
	}

	public VoiceControlsPanel getInfoPanel() {
		return controls;
	}

	
	
	
}
