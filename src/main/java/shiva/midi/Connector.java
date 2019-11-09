package shiva.midi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

/** This device can connect multiple transmitters to multiple receivers. */
public class Connector implements Receiver {

	private List<Receiver> rec = new ArrayList<>();
	private List<Transmitter> trans = new ArrayList<>();
	private boolean debug;

	public Connector(boolean debug) {
		super();
		this.debug = debug;
	}

	public void addTransmitter(Transmitter t) {
		 trans.add(t);
		 t.setReceiver(this);
	}
	
	public void addReceiver(Receiver r) {
		rec.add(r);
	}
	
	

	@Override
	public void send(MidiMessage message, long timeStamp) {
		if (debug) {
			System.out.println(getClass().getName() + ": message: " + Arrays.toString(message.getMessage()));
		}
		for (Receiver receiver : rec) {
			receiver.send(message, timeStamp);
		}

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	

}