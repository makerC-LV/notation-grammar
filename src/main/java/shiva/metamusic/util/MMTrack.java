package shiva.metamusic.util;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.theory.Chord;
import org.jfugue.theory.Note;

import shiva.metamusic.ElementWithDuration;
import shiva.metamusic.MMChord;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMDynamics;
import shiva.metamusic.MMNote;
import shiva.metamusic.ParallelNotes;

public class MMTrack {

	boolean percussionTrack;
	int midiInstrument;
	String midiInstrumentName;
	String name;
	private int midiChannel;
	MMDuration duration = MMDuration.SIXTEENTH; // default duration
	int midiNote;  // percussion track
	
	TreeMap<MMDuration, List<ElementWithDuration>> items = new TreeMap<>();

	MMDuration currentTime = MMDuration.ZERO;
	
	private MMTrack(String name, String midiInstrumentName) {
		this.name = name;
		this.midiInstrumentName = midiInstrumentName;
		this.midiNote = MidiUtils.percussionToMidiNote(midiInstrumentName);
		this.midiChannel = MidiUtils.PERCUSSION_CHANNEL;
		percussionTrack = true;
	}
	
	public MMTrack(String name, String midiInstrumentName, int midiChannel) {
		super();
		this.name = name;
		this.midiInstrumentName = midiInstrumentName;
		this.midiInstrument = MidiUtils.instrumentToMidiNum(midiInstrumentName);
		this.midiChannel = midiChannel;
		
	}

	static public MMTrack createPercussionTrack(String name, String midiInstrumentName) {
		return new MMTrack(name, midiInstrumentName);
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

	public void add(ParallelNotes pn) {
		if (percussionTrack) {
			throw new RuntimeException("Cannot add parallel notes to percussion track: " + pn.toSong4());
		}
		for (MMNote mmnote : pn.getNotes()) {
			addNoteWithoutIncrementingTime(mmnote);
		}
		currentTime = MMDuration.add(currentTime, pn.getDuration());
	}
	
	public void add(MMChord chord) {
		if (percussionTrack) {
			throw new RuntimeException("Cannot add chord to percussion track: " + chord.toSong4());
		}
		MMDuration dur = chord.getDuration();
		Chord c = chord.getJFugueChord();
		for (Note n : c.getNotes()) {
			MMNote mmnote = new MMNote(MMDuration.ZERO, n, dur);
			mmnote.accent(chord.isAccented());
			addNoteWithoutIncrementingTime(mmnote);
		}
		currentTime = MMDuration.add(currentTime, dur);
	}
	
	
	
	public void add(MMNote item) {
		if (percussionTrack) {
			throw new RuntimeException("Cannot add note to percussion track: " + item.toSong4());
		}
		addNoteInternal(item);
		
	}

	private void addNoteInternal(MMNote item) {
		addNoteWithoutIncrementingTime(item);
		currentTime = MMDuration.add(currentTime, item.getDuration());
	}

	private void addNoteWithoutIncrementingTime(MMNote item) {
		List<ElementWithDuration> list = getItemsForTime(currentTime);
		MMNote copy = (MMNote) item.copy();
//		System.out.println("Adding " + item.toSong4() + " " + item.getTime())
		copy.setTime(currentTime);
		list.add(copy);
	}

	private List<ElementWithDuration> getItemsForTime(MMDuration time) {
		List<ElementWithDuration> list = items.get(time);
		if (list == null) {
			list = new ArrayList<>();
			items.put(currentTime, list);
		}
		return list;
	}
	
	public void add(MMDynamics mmd) {
		MMDynamics copy = (MMDynamics) mmd.copy();
		copy.setTime(currentTime);
		List<ElementWithDuration> list = getItemsForTime(currentTime);
		list.add(copy);
		
	}
	
	public void setDuration(MMDuration dur) {
		if (!percussionTrack) {
			throw new RuntimeException("Cannot set duration for note track");
		}
		this.duration = dur;
	} 
	
	public void addBeat(boolean beat, boolean accented) {
		if (!percussionTrack) {
			throw new RuntimeException("Cannot add beat to note track");
		}
		Note n = Note.createRest(1);
		if (beat) {
			n = new Note(midiNote);
		}
		MMNote mmnote = new MMNote(MMDuration.ZERO, n, duration);
		mmnote.accent(accented);
		addNoteInternal(mmnote);
	}
	
	
	public void setTime(MMDuration duration) {
		currentTime = duration;
	}


	public MMDuration getCurrentTime() {
		return currentTime;
	}


	public List<ElementWithDuration> getItems() {
		List<ElementWithDuration> list = new ArrayList<>();
		for (List<ElementWithDuration> l : items.values()) {
			list.addAll(l);
		}
		return list;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append("[");
		for (ElementWithDuration item: getItems()) {
			sb.append(item);
			sb.append(" ");
		}
		sb.append("]");
		return sb.toString();
	}

	

	
	
	
}
