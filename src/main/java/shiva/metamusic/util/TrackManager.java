package shiva.metamusic.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TrackManager {

	private List<Integer> voiceChannels = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15));

	
	private Map<String, MMTrack> tracksByName = new LinkedHashMap<>();
	private MMTrack currentTrack;

	private String defaultInstrumentName;
	private String defaultTrackName;
	private boolean percussion;
	
	
	public TrackManager(boolean percussion) {
		super();
		this.percussion = percussion;
		if (percussion) {
			this.defaultInstrumentName = MidiUtils.DEFAULT_PERCUSSION_NAME;
			this.defaultTrackName = MidiUtils.DEFAULT_PERCUSSION_NAME;
		} else {
			this.defaultInstrumentName = MidiUtils.DEFAULT_INSTRUMENT_NAME;
			this.defaultTrackName = MidiUtils.DEFAULT_INSTRUMENT_NAME;
		}
		
	}

	public MMTrack getCurrentTrack() {
		if (currentTrack == null) {
			currentTrack = getDefaultTrack();
		}
		return currentTrack;
	}
	
	private MMTrack getTrack( String name, String instrumentName) {
		MMTrack track = tracksByName.get(name);
		if (track == null) {
			track = createTrack(name, instrumentName);
			tracksByName.put(name,  track);
		}
		return track;
	}

	private MMTrack createTrack(String name, String instrumentName) {
		if (percussion) {
			return MMTrack.createPercussionTrack(name, instrumentName);
		} else {
			int midiChannel = voiceChannels.remove(0);
			return new MMTrack(name, instrumentName, midiChannel);
		}
	}
	public MMTrack getDefaultTrack() {
		return getTrack(defaultTrackName, defaultInstrumentName);
	}

//	public Collection<MMTrack> getTracks() {
//		return tracksByInstrumentName.values();
//	}

	public void changeTrack(String name, String instrumentName) {
		currentTrack = getTrack(name, instrumentName);
		
	}
	
	public MMTrack getTrackByName(String name) {
		return tracksByName.get(name);
	}
	
	public Collection<String> getTrackNames() {
		return tracksByName.keySet();
	}
}
