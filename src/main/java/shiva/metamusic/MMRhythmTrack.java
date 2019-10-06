package shiva.metamusic;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sound.midi.Track;

public class MMRhythmTrack {

	Map<Integer, MMTrack> tracksByNoteNum = new LinkedHashMap<>();

	public MMTrack getTrack(int noteNum, String name) {
		MMTrack track = tracksByNoteNum.get(noteNum);
		if (track == null) {
			track = MMTrack.createPercussionTrack(name);
			tracksByNoteNum.put(noteNum,  track);
		}
		return track;
	}

	public MMTrack getDefaultTrack() {
		return getTrack(MMRhythmPhrase.DEFAULT_PERCUSSION_NOTE, "Default");
	}

	public Collection<MMTrack> getTracks() {
		return tracksByNoteNum.values();
	}
	
}
