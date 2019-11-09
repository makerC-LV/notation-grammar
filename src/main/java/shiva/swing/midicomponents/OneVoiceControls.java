package shiva.swing.midicomponents;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToggleButton;

import shiva.swing.components.DKnob;
import shiva.swing.components.TablePanel;
import shiva.swing.components.Util;

@SuppressWarnings("serial")
public class OneVoiceControls extends TablePanel {

	DKnob volumeKnob = new DKnob();
	JLabel voiceName = new JLabel("V:");
	JLabel instName = new JLabel("I:");
	JLabel midiChannelL = new JLabel("Ch:");
	int midiChannel;
	private JToggleButton muteButton = Util.muteButton();
	private JToggleButton soloButton = Util.soloButton();
	private Controllable controllable;
	private int tracknum;
	
	
	public OneVoiceControls(Controllable c, int midiChannel, int trackNum, String voice, String inst) {
		super();
		this.controllable = c;
		this.midiChannel = midiChannel;
		this.tracknum = trackNum;
		
		table.pad(2);
		
		Dimension d = new Dimension(100, 190);
		setPreferredSize(d);
		setMinimumSize(d);
		table.addCell(volumeKnob).colspan(2).fill().center();
		table.row();
		table.addCell(muteButton);
		table.addCell(soloButton);
		table.row();
		table.addCell(voiceName).colspan(2).left();
		table.row();
		table.addCell(instName).colspan(2).left();
		table.row();
		table.addCell(voiceName).colspan(2).left();
		table.row();
		table.addCell(midiChannelL).colspan(2).left();
		
		int m = 12;
		voice = voice.length() > m ? voice.substring(0, m-2) + ".." : voice;
		inst= inst.length() > m ? inst.substring(0, m-2) + ".." : inst;
		voiceName.setText("V:" + voice);
		instName.setText("I:" + inst);
		midiChannelL.setText("Ch:" + midiChannel);
		
		
		muteButton.addActionListener( e -> {mute();});
		
		soloButton.addActionListener( e -> {solo();});
		
		volumeKnob.addChangeListener(e -> {volume();});
		
	}
	
	void volume() {
		controllable.volume(midiChannel, volumeKnob.getValue());
	}
	
	void solo() {
		controllable.solo(tracknum, soloButton.isSelected());
	}
	void mute() {
		controllable.mute(tracknum, muteButton.isSelected());
	}
	
	
	
	public JToggleButton getSoloButton() {
		return soloButton;
	}

	public static void main(String[] args) {
		Controllable c = new Controllable() {

			@Override
			public void mute(int trackNum, boolean mute) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void volume(int channel, float value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void solo(int trackNum, boolean solo) {
				// TODO Auto-generated method stub
				
			}

			
			
		};
		int ch = 0;
		Util.showInFrame(new OneVoiceControls(c, 0, 0, "Voice", "Long Instrument"));
	}
	
	public static interface Controllable {

		void mute(int trackNum, boolean mute);

		void volume(int channel, float value);

		void solo(int trackNum, boolean solo);
		
	}
}
