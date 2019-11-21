package shiva.midi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiDeviceReceiver;
import javax.sound.midi.MidiDeviceTransmitter;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;

/** This device can connect multiple transmitters to multiple receivers. */
public class Connector implements Receiver {

	private List<Receiver> rec = new ArrayList<>();
	private List<Transmitter> trans = new ArrayList<>();
	protected boolean debug;

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
	
	public void removeDeviceFromTransmitters(MidiDevice device) {
		List<Transmitter> toRemove = new ArrayList<Transmitter>();
		trans.forEach(t-> {
			if (belongsTo(t, device)) {
				toRemove.add(t);
			}
		});
		trans.removeAll(toRemove);
	}
	
	
	public void removeDeviceFromReceivers(MidiDevice device) {
		List<Receiver> toRemove = new ArrayList<Receiver>();
		rec.forEach(t-> {
			if (belongsTo(t, device)) {
				toRemove.add(t);
			}
		});
		rec.removeAll(toRemove);
	}

	private boolean belongsTo(Transmitter t, MidiDevice device) {
		if (t instanceof MidiDeviceTransmitter) {
			return device.equals(((MidiDeviceTransmitter) t).getMidiDevice());
		}
		return false;
	}

	private boolean belongsTo(Receiver r, MidiDevice device) {
		if (r instanceof MidiDeviceReceiver) {
			return device.equals(((MidiDeviceReceiver) r).getMidiDevice());
		}
		return false;
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