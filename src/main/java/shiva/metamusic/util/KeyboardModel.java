package shiva.metamusic.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;

import shiva.metamusic.MMKeySig;

public class KeyboardModel implements javax.sound.midi.Receiver{

	public static interface KeyboardListener {

		void keyPressed(int num);
		
		void keyReleased(int num);
	}

	private final double EPS = 0.0001;

	private final int[] wb = new int[] { 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 };
	private final String[] names = new String[] { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };

	Map<Integer, Key> whiteKeys = new TreeMap<>();
	Map<Integer, Key> blackKeys = new TreeMap<>();

	List<KeyboardListener> listeners = new ArrayList<>();
	
	MMKeySig keySig = new MMKeySig("Cmaj", null);
	
	public KeyboardModel(int numOctaves) {
		if (numOctaves %2 == 1) {
			throw new RuntimeException("numOctaves must be even");
		}
		int lowKey = 60 - 12 * numOctaves / 2;
		int highKey = 60 + 12 * numOctaves / 2 - 1;
		fillKeys(numOctaves, lowKey, highKey);
		setKeySignature(this.keySig);
	}
	
	public void addKeyboardListener(KeyboardListener l) {
		listeners.add(l);
	}
	
	public Map<Integer, Key> getWhiteKeys() {
		return whiteKeys;
	}

	public Map<Integer, Key> getBlackKeys() {
		return blackKeys;
	}

	public void setKeySignature(MMKeySig keySig) {
		this.keySig = keySig;
		whiteKeys.values().forEach(k->setInKey(k));
		blackKeys.values().forEach(k->setInKey(k));
	}
	
	private void setInKey(Key k) {
		if (this.keySig == null) {
			k.isInKey = false;
		} else {
			k.isInKey = keySig.containsNote(k.midiNum);
		}
		
	}

	public void press(int num) {
		Key key = whiteKeys.get(num);
		if (key == null) {
			key = blackKeys.get(num);
		}
		if (key != null) {
			key.isPressed = true;
			for (KeyboardListener l : listeners) {
				l.keyPressed(num);
			}
		}
	}

	public void release(int num) {
		Key key = whiteKeys.get(num);
		if (key == null) {
			key = blackKeys.get(num);
		}
		if (key != null) {
			key.isPressed = false;
			for (KeyboardListener l : listeners) {
				l.keyReleased(num);
			}
		}
		
	}

	private void fillKeys(int numOctaves, int lowKey, int highKey) {
		double width = 1.0 / (7 * numOctaves);
		int whiteKeyCount = 0;

		for (int i = lowKey; i <= highKey; i += 12) {
			for (int j = 0; j < wb.length; j++) {
				int midiNum = i + j;
				String name = names[j];
				if (wb[j] == 0) { // white note
					double lowX = whiteKeyCount * width + EPS;
					whiteKeys.put(midiNum, new Key(midiNum, name, lowX, lowX + width - EPS));
					whiteKeyCount++;
				} else { // black note
					double lowX = whiteKeyCount * width - 0.3 * width;
					blackKeys.put(midiNum, new Key(midiNum, name, lowX, lowX + 0.6 * width));
				}
			}
		}

	}

	public class Key {
		public int midiNum;
		public String name;

		public double lowX;
		public double highX;

		
		
		public boolean isPressed;
		public boolean isInKey;

		public Key(int midiNum, String name, double lowX, double highX) {
			super();
			this.midiNum = midiNum;
			this.name = name;
			this.lowX = lowX;
			this.highX = highX;
		}

		@Override
		public String toString() {
			return "Key [midiNum=" + midiNum + ", name=" + name + ", lowX=" + lowX + ", highX=" + highX + "]";
		}

	}

	

	@Override
	public void send(MidiMessage mmsg, long timeStamp) {
		if (!(mmsg instanceof ShortMessage)) {
			return;
		}
		ShortMessage message = (ShortMessage) mmsg;
		switch (message.getCommand()) {
		case ShortMessage.NOTE_OFF:
			int note = message.getData1();
			release(note);
			break;
		case ShortMessage.NOTE_ON:
			int velocity = message.getData2();
			note = message.getData1();
			if (velocity == 0) {
				release(note);
			} else { 
				press(note);
			}
			break;
		}

		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
}