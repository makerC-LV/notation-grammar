package shiva.swing.midicomponents;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.ManagedPlayerListener;

import shiva.swing.components.TablePanel;
import shiva.swing.components.Util;

@SuppressWarnings("serial")
public class PlayControls extends TablePanel implements ManagedPlayerListener {

	public static interface SequenceProvider {
		Sequence buildSequence();
	}
	
	ManagedPlayer player = new ManagedPlayer();
	JToggleButton playPause = Util.playPauseButton();
	JButton resetButton = Util.playResetButton();
	JSlider seeker = new JSlider(0, 100);
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
		table.addCell(playPause);
		table.addCell(resetButton);
		table.addCell(seeker).expandX().fillX();
		playPause.addActionListener(e -> { playOrPause(); }) ;
		resetButton.addActionListener(e -> { reset(); });
		seeker.addChangeListener(ce-> {sliderChanged();});
		player.addManagedPlayerListener(this);
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
			player.start(seq);
		} catch (InvalidMidiDataException | MidiUnavailableException e) {
			e.printStackTrace();
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
		playPause.setSelected(false);
		playPause.setEnabled(true);
		resetButton.setEnabled(true);
		seeker.setEnabled(true);
		seeker.setValue(0);
	}
	
	public void resume() {
		ses.execute(() -> {player.resume();});
	}
	
	public void reset() {
		ses.execute(() -> {player.reset();});
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
		SwingUtilities.invokeLater(()-> {
			setResetState();
			});
		
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

	
	
}
