package shiva.metamusic.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sound.midi.Track;

public class MMRhythmTrack {

	Map<String, MMTrack> tracksByInstrumentName = new LinkedHashMap<>();
	MMTrack currentTrack;

	public MMTrack getCurrentTrack() {
		if (currentTrack == null) {
			currentTrack = getDefaultTrack();
		}
		return currentTrack;
	}
	
	private MMTrack getTrack( String name, String instrumentName) {
		MMTrack track = tracksByInstrumentName.get(instrumentName);
		if (track == null) {
			track = MMTrack.createPercussionTrack(name, instrumentName);
			tracksByInstrumentName.put(instrumentName,  track);
		}
		return track;
	}

	public MMTrack getDefaultTrack() {
		return getTrack(MidiUtils.DEFAULT_PERCUSSION_NAME, "Default");
	}

	public Collection<MMTrack> getTracks() {
		return tracksByInstrumentName.values();
	}

	public void changeDrum(String name, String instrumentName) {
		currentTrack = getTrack(instrumentName, name);
		
	}
	
}
