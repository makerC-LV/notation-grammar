package shiva.metamusic.util;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;

public class SequencePlayer {

	private SequencePlayerState state = new SequencePlayerState();

	private CopyOnWriteArrayList<SequencePlayerListener> playerListeners = new CopyOnWriteArrayList<SequencePlayer.SequencePlayerListener>();

	private Sequencer sequencer;

	private MidiDevice synth;

	private Executor exec = Executors.newSingleThreadExecutor();

	private SequencerWatcher seqWatcher = new SequencerWatcher();

	public SequencePlayer() {
		this(null, null);
		
	}

	public SequencePlayer(MidiDevice synth)  {
		this(null, synth);
	}
	
	public SequencePlayer(Sequencer sequencer, MidiDevice synth)  {
		try {
			if (sequencer == null) {
				sequencer = MidiSystem.getSequencer(false);
			}
			if (synth == null) {
				synth = MidiSystem.getSynthesizer();
			}
			setup(sequencer, synth);
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}

	private void setup(Sequencer sequencer, MidiDevice synth) throws MidiUnavailableException {
		this.sequencer = sequencer;
		this.synth = synth;
		sequencer.getTransmitter().setReceiver(synth.getReceiver());
	}

	public void addSequencePlayerListener(SequencePlayerListener listener) {
		playerListeners.add(listener);
	}

	public void removeSequencePlayerListener(SequencePlayerListener listener) {
		playerListeners.add(listener);
	}

	public List<SequencePlayerListener> getSequencePlayerListeners() {
		return playerListeners;
	}

	/**
	 * This method opens the sequencer (if it is not already open - @see
	 * PlayerCommon), sets the sequence, tells listeners that play is starting, and
	 * starts the sequence.
	 * 
	 * @param sequence
	 */
	public void start(Sequence sequence) throws InvalidMidiDataException, MidiUnavailableException {
		open();
		getSequencer().setSequence(sequence);
		fireOnStarted(sequence);
		this.state.started = true;
		this.state.paused = false;
		this.state.finished = false;
		System.out.println("Seq started");
		getSequencer().start();
		startSequencerWatcher();
	}

	/**
	 * To resume play, @see resume()
	 */
	public void pause() {
		fireOnPaused();
		state.paused = true;
		getSequencer().stop();
		stopSequencerWatcher();
	}

	/**
	 * To pause play, @see pause()
	 */
	public void resume() {
		fireOnResumed();
		state.paused = false;
		getSequencer().start();
		startSequencerWatcher();
	}

	public void seek(long tick) {
		fireOnSeek(tick);
		getSequencer().setTickPosition(tick);
	}

	public void finish() {
		close();
		state.finished = true;
		fireOnFinished();
	}

	public void reset() {
		close();
		state.started = false;
		state.paused = false;
		state.finished = false;
		fireOnReset();
	}

	private void open() throws MidiUnavailableException {
		if (!sequencer.isOpen()) {
			sequencer.open();
		}
		if (!synth.isOpen()) {
			synth.open();
		}
	}

	private void close() {
//		if (sequencer.isOpen()) {
//			sequencer.close();
//		}
//		if (synth.isOpen()) {
//			synth.close();
//		}

	}

	public void startSequencerWatcher() {
		seqWatcher.setCancel(false);
		exec.execute(seqWatcher);
	}

	public void stopSequencerWatcher() {
		seqWatcher.setCancel(true);
	}

	public long getTickLength() {
		return getSequencer().getTickLength();
	}

	public long getTickPosition() {
		return getSequencer().getTickPosition();
	}

	public boolean isStarted() {
		return state.started;
	}

	public boolean isFinished() {
		return state.finished;
	}

	public boolean isPaused() {
		return state.paused;
	}

	public boolean isPlaying() {
		return getSequencer().isRunning();
	}

	public Sequencer getSequencer() {
		return sequencer;
	}

	public MidiDevice getSynthesizer() {
		return synth;
	}
	
	protected void fireOnStarted(Sequence sequence) {
		List<SequencePlayerListener> listeners = getSequencePlayerListeners();
		for (SequencePlayerListener listener : listeners) {
			listener.onStarted(sequence);
		}
	}

	protected void fireOnFinished() {
		List<SequencePlayerListener> listeners = getSequencePlayerListeners();
		for (SequencePlayerListener listener : listeners) {
			listener.onFinished();
		}
	}

	protected void fireOnPaused() {
		List<SequencePlayerListener> listeners = getSequencePlayerListeners();
		for (SequencePlayerListener listener : listeners) {
			listener.onPaused();
		}
	}

	protected void fireOnResumed() {
		List<SequencePlayerListener> listeners = getSequencePlayerListeners();
		for (SequencePlayerListener listener : listeners) {
			listener.onResumed();
		}
	}

	protected void fireOnSeek(long tick) {
		List<SequencePlayerListener> listeners = getSequencePlayerListeners();
		for (SequencePlayerListener listener : listeners) {
			listener.onSeek(tick);
		}
	}

	protected void fireOnReset() {
		List<SequencePlayerListener> listeners = getSequencePlayerListeners();
		for (SequencePlayerListener listener : listeners) {
			listener.onReset();
		}
	}

	public static interface SequencePlayerListener {

		public void onStarted(Sequence sequence);

		public void onFinished();

		public void onPaused();

		public void onResumed();

		public void onSeek(long tick);

		public void onReset();

	}

	public static class SequencePlayerState {
		private boolean started;
		private boolean finished;
		private boolean paused;

	}

	@SuppressWarnings("unused")
	private class SequencerWatcher implements Runnable {

		boolean cancelled;

		@Override
		public void run() {
			while (sequencer.isRunning()) {
				Thread.yield();
				if (cancelled) {
					break;
				}
			}
			if (!cancelled && !isPaused()) {
				finish();
			}
		}

		public boolean isCancelled() {
			return cancelled;
		}

		private void setCancel(boolean b) {
			this.cancelled = b;
		}

	}

	
}
