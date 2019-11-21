package shiva.midi;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiDevice.Info;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class DeviceUtils {
	
	
	public static Sequencer getSequencerConnectedTo(String deviceName) throws MidiUnavailableException {
		Sequencer seq = MidiSystem.getSequencer(false);
		MidiDevice dev = getOutputDevice(deviceName);
		seq.open();
		seq.getTransmitter().setReceiver(dev.getReceiver());
		return seq;
	}
	
	
	public static MidiDevice getOutputDevice(String name) {
		for (MidiDevice dev : outputDevices()) {
			if (dev.getDeviceInfo().getName().contains(name)) {
				Info i = dev.getDeviceInfo();
				System.out.println("Found output device: " + i.getName() + " - " + i.getVendor());
				return dev;
			}
		}
		System.err.println("No output device found with name: " + name);
		
		return null;
	}
	
	public static MidiDevice getInputDevice(String name) {
		for (MidiDevice dev : inputDevices()) {
			if (dev.getDeviceInfo().getName().contains(name)) {
				Info i = dev.getDeviceInfo();
				System.out.println("Found input device: " + i.getName() + " - " + i.getVendor());
				return dev;
			}
		}
		System.err.println("No input device found with name: " + name);
		return null;
	}
	
	/** Devices that have receivers */
	public static List<MidiDevice> outputDevices() {
		List<MidiDevice> devs = new ArrayList<>();

		try {
			for (Info info : MidiSystem.getMidiDeviceInfo()) {
				MidiDevice dev = MidiSystem.getMidiDevice(info);
				if (dev.getMaxReceivers() != 0) {
					devs.add(dev);
				}
			}
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return devs;

	}
	/** Devices that have transmitters */
	public static List<MidiDevice> inputDevices() {
		List<MidiDevice> devs = new ArrayList<>();

		try {
			for (Info info : MidiSystem.getMidiDeviceInfo()) {
				MidiDevice dev = MidiSystem.getMidiDevice(info);
				if (dev.getMaxTransmitters() != 0) {
					devs.add(dev);
				}
			}
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return devs;

	}
	
	public static void printDevices(String heading, List<MidiDevice> dev) {
		System.out.println(heading);
		for (MidiDevice d : dev) {
			Info i = d.getDeviceInfo();
			System.out.println(i.getName() + " - " + i.getVendor());
		}
		
	}
	public static void main(String[] args) {
		printDevices("Input devices:" , inputDevices());
		printDevices("Output devices:" , outputDevices());
	}


	
	
}
