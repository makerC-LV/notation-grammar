package shiva.swing.midicomponents;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import org.jfugue.player.SequencerManager;
import org.jfugue.player.SynthesizerManager;

import shiva.metamusic.util.MidiUtils;
import shiva.metamusic.util.SequencePlayer;
import shiva.metamusic.util.SequencePlayer.SequencePlayerListener;
import shiva.swing.components.TablePanel;
import shiva.swing.components.Util;
import shiva.swing.midicomponents.DeviceChooser.DeviceListener;
import shiva.swing.midicomponents.OneVoiceControls.Controllable;

@SuppressWarnings("serial")
public class PlayControls extends TablePanel implements SequencePlayerListener, Controllable {

	public static interface SequenceProvider {
		Sequence buildSequence();
	}
	
	SequencePlayer player;
	JToggleButton playPause = Util.playPauseButton();
	JButton resetButton = Util.playResetButton();
	JButton equalizerButton = Util.equalizerButton();
	JSlider seeker = new JSlider(0, 100);
	DeviceChooser outputChooser = new DeviceChooser(DeviceChooser.Type.OUTPUT);
	JCheckBox sendMidiCC = new JCheckBox("Send MIDICC");
	
	ExecutorService ses = Executors.newFixedThreadPool(4);
	SequenceProvider sequenceProvider;
	
	Runnable sliderUpdateTask = new Runnable() {

		@Override
		public void run() {
			while(player.isPlaying()) {
				SwingUtilities.invokeLater(() -> { 
					double frac =  ((double)player.getTickPosition())/player.getTickLength();
					int val = (int) (frac * seeker.getMaximum());
					seeker.setValue(val);
				});
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	};
	
	public PlayControls(SequenceProvider client) {
		super();
		this.sequenceProvider = client;
		player = new SequencePlayer();
		table.addCell(playPause);
		table.addCell(resetButton);
		table.addCell(equalizerButton);
		table.addCell(seeker).expandX().fillX();
		table.addCell(outputChooser);
		table.addCell(sendMidiCC);
		playPause.addActionListener(e -> { playOrPause(); }) ;
		resetButton.addActionListener(e -> { reset(); });
		seeker.addChangeListener(ce-> {sliderChanged();});
		outputChooser.addDeviceListener(d->{outputDeviceChanged(d);});
		player.addSequencePlayerListener(this);
		
		
		
	}
	
	public void addDeviceListener(DeviceListener l) {
		outputChooser.addDeviceListener(l);
	}
	
	private void outputDeviceChanged(MidiDevice dev) {
		if (!dev.isOpen()) {
			try {
				dev.open();
			} catch (MidiUnavailableException e) {
				e.printStackTrace();
			}
		}
		player.setOutputDevice(dev);
		
	}

	private void sliderChanged() {
		if (!seeker.getValueIsAdjusting() && !player.isPlaying()) {
			int val = seeker.getValue();
			double frac = ((double) seeker.getValue())/seeker.getMaximum();
//			System.out.printf("%f %d\n", frac, player.getTickLength());
			long pos = (long) (frac * player.getTickLength());
//			System.out.println(isPaused() + " " + pos);
			ses.execute(() -> {player.seek(pos);});
//			System.out.println("After:" + isPaused());

		}

	}

	
	public JButton getEqualizerButton() {
		return equalizerButton;
	}

	public boolean isStarted() {
		return player.isStarted();
	}
	
	public boolean isPaused() {
		return player.isPaused();
	}
	
	public boolean isFinished() {
		return player.isFinished();
	}
	
	
	private void start(Sequence seq) {
		ses.execute(() -> {startBackground(seq);});
	}

	private void startBackground(Sequence seq) {
		try {
			sendMIDICC();
			player.start(seq);
		} catch (InvalidMidiDataException | MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private void sendMIDICC() {
		if (sendMidiCC.isSelected()) {
			player.sendMIDICC();
		}
		
	}

	private void setPlayingState() {
		playPause.setSelected(true);
		resetButton.setEnabled(false);
		seeker.setEnabled(false);
	}
	
	private void setPausedState() {
		playPause.setSelected(false);
		resetButton.setEnabled(true);
		seeker.setEnabled(true);
	}
	
	private void setResetState() {
		playPause.setEnabled(true);
		playPause.setSelected(false);
		resetButton.setEnabled(true);
		seeker.setEnabled(true);
		seeker.setValue(0);
	}
	
	public void resume() {
		ses.execute(() -> {player.resume();});
	}
	
	public void reset() {
		ses.execute(() -> {
			sendMIDICC();
			player.reset();
			});
	}

	private void pause() {
		ses.execute(() -> {player.pause();});
	}
	
	private void playOrPause() {
		if (!isStarted()) {
			start(sequenceProvider.buildSequence());
		} else if (isPaused()) {
			resume();
		} else if (isFinished()) {
			reset();
		} else { // started, not paused and not finished, must be playing
			pause();
		}
		
	}

	@Override
	public void onStarted(Sequence sequence) {
		SwingUtilities.invokeLater(()-> {setPlayingState();});
		ses.execute(sliderUpdateTask);
		
	}

	@Override
	public void onFinished() {
		ses.execute(() -> {player.reset();});
//		SwingUtilities.invokeLater(()-> {
//			setResetState();
//			});
		
	}

	@Override
	public void onPaused() {
		SwingUtilities.invokeLater(()-> {setPausedState();});
		
	}

	@Override
	public void onResumed() {
		SwingUtilities.invokeLater(()-> {setPlayingState();});
		ses.execute(sliderUpdateTask);
		
	}

	@Override
	public void onSeek(long tick) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset() {
		SwingUtilities.invokeLater(()->
		{
			setResetState();
		});

	}

	@Override
	public void mute(int trackNum, boolean mute) {
		
			Sequencer seq = player.getSequencer();
			seq.setTrackMute(trackNum, mute);
		
	}

	Executor ex = Executors.newSingleThreadExecutor();
	@Override
	public void volume(int channelNum, float value) {
		int midiValue = (int) (value * 127);
//		System.out.println("Vol: " + channelNum + " " + midiValue);
		MidiDevice synth = player.getSynthesizer();
		if (synth instanceof Synthesizer) {
			volume(channelNum, midiValue, (Synthesizer)synth);
		} else {
			// send control change
			Sequencer seq = player.getSequencer();
			try {
				MidiMessage message = MidiUtils.createChannelVelocity(0, channelNum, midiValue).getMessage();
				synth.getReceivers().get(0).send(message, seq.getTickPosition());
			} catch (InvalidMidiDataException e) {
				e.printStackTrace();
			}
			
		}
		
		
		

	} 


	
	private void volume(int channelNum, int midiValue, Synthesizer synth) {
		MidiChannel channel = synth.getChannels()[channelNum];
		channel.controlChange(MidiUtils.CHANNEL_VOLUME_CONTROLLER, midiValue);
	}

	
	@Override
	public void solo(int trackNum, boolean solo) {
		Sequencer seq = player.getSequencer();
		seq.setTrackSolo(trackNum, solo);

	}

	

	
	
}
