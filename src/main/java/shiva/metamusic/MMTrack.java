package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.theory.Note;

public class MMTrack {

	boolean percussionTrack;
	int midiInstrument;
	String midiInstrumentName;
	String name;
	private int midiChannel;
	
	TreeMap<MMDuration, List<MMTrackItem>> items = new TreeMap<>();

	MMDuration currentTime = MMDuration.ZERO;
	
	private MMTrack(String name) {
		this.name = name;
		this.midiChannel = 9;
		percussionTrack = true;
	}
	
	public MMTrack(String name, String midiInstrumentName, int midiChannel) {
		super();
		this.name = name;
		this.midiInstrumentName = midiInstrumentName;
		this.midiInstrument = MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get(midiInstrumentName.toUpperCase());
		this.midiChannel = midiChannel;
		
	}

	static public MMTrack createPercussionTrack(String name) {
		return new MMTrack(name);
	}
	
	
	public boolean isPercussionTrack() {
		return percussionTrack;
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
	
	public void add(MMNotePhrase phrase) {
		for (MMTrackItem item: phrase.getItems()) {
			add(item.copy());
		}
	}
	
	public void add(MMRhythmPhrase phrase, int midiNoteNum) {
		MMDuration dur = phrase.getNoteDuration();
		
		for (boolean b: phrase.getBeats()) {
			Note n = Note.createRest(1);
			if (b) {
				n = new Note(midiNoteNum);
			}
			MMNote mmnote = new MMNote(MMDuration.ZERO, n, dur);
			add(mmnote);
			
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
