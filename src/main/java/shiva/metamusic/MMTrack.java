package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.jfugue.midi.MidiDictionary;

public class MMTrack {

	int midiInstrument;
	String midiInstrumentName;
	String name;
	private int midiChannel;
	
	TreeMap<MMDuration, List<MMTrackItem>> items = new TreeMap<>();

	MMDuration currentTime = MMDuration.ZERO;
	
	public MMTrack(String name, String midiInstrumentName, int midiChannel) {
		super();
		this.name = name;
		this.midiInstrumentName = midiInstrumentName;
		this.midiInstrument = MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get(midiInstrumentName.toUpperCase());
		this.midiChannel = midiChannel;
		
	}


	public String getName() {
		return name;
	}
	
	
	
	public int getMidiInstrument() {
		return midiInstrument;
	}


	public int getMidiChannel() {
		return midiChannel;
	}


	public void add(MMTrackItem item) {
		List<MMTrackItem> list = items.get(currentTime);
		if (list == null) {
			list = new ArrayList<>();
			items.put(currentTime, list);
		}
		list.add(item);
		item.setTime(currentTime);
		currentTime = MMDuration.add(currentTime, item.getDuration());
		
	}
	
	public void add(MMTemplatePhrase phrase) {
		for (MMTrackItem item: phrase.getItems()) {
			add(item.copy());
		}
	}
	
	public void setTime(MMDuration duration) {
		currentTime = duration;
	}


	public MMDuration getCurrentTime() {
		return currentTime;
	}


	public List<MMTrackItem> getItems() {
		List<MMTrackItem> list = new ArrayList<>();
		for (List<MMTrackItem> l : items.values()) {
			list.addAll(l);
		}
		return list;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("[");
		for (MMTrackItem item: getItems()) {
			sb.append(item);
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	
}
