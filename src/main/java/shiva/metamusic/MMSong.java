package shiva.metamusic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jfugue.theory.Key;
import org.jfugue.theory.TimeSignature;

public class MMSong {

	MMTempo tempo;
	MMKeySig keySig;
	MMTimeSig timeSig;
	Map<String, MMTrack> tracksByName = new LinkedHashMap<>();
	MMRhythmTrack percussionTrack;
	
	private List<Integer> voiceChannels = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15));
	
	public MMSong() {
		this(new MMKeySig(Key.DEFAULT_KEY), new MMTimeSig(TimeSignature.DEFAULT_TIMESIG), MMTempo.DEFAULT_TEMPO);
	}
	
	protected MMSong(MMKeySig keySig, MMTimeSig timeSig, MMTempo tempo) {
		super();
		this.keySig = keySig;
		this.timeSig = timeSig;
		this.tempo = tempo;
	}

	
	public MMTempo getTempo() {
		return tempo;
	}

	public void setTempo(MMTempo mmt) {
		this.tempo = mmt;
		
	}
	
	public MMKeySig getKeySig() {
		return keySig;
	}

	public void setKeySig(MMKeySig keySig) {
		this.keySig = keySig;
	}

	public MMTimeSig getTimeSig() {
		return timeSig;
	}

	public void setTimeSig(MMTimeSig timeSig) {
		this.timeSig = timeSig;
	}

	public MMTrack createTrack(String name, String midiInstrumentName) {
		int channel = voiceChannels.remove(0);
		MMTrack mmtrack = new MMTrack(name, midiInstrumentName, channel);
		addTrack(mmtrack);
		return mmtrack;
	}
	
	private void addTrack(MMTrack track) {
		tracksByName.put(track.getName(), track);
		
	}
	
	public MMTrack getTrack(String name) {
		return tracksByName.get(name);
	}
	
	public MMRhythmTrack getPercussionTrack() {
		if (percussionTrack == null) {
			percussionTrack = new MMRhythmTrack();
		}
		return percussionTrack;
	}
	
	public MMTrack getDefaultTrack() {
		for (MMTrack t : tracksByName.values()) {
			if (t.getMidiInstrument() == 0) {
				return t;
			}
		}
		int channel = voiceChannels.remove(0);
		MMTrack mmtrack = new MMTrack("Default,-Piano", "Piano", channel);
		addTrack(mmtrack);
		return mmtrack;
	}
	
	public List<String> getTrackNames() {
		return new ArrayList<>(tracksByName.keySet());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(tempo);
		sb.append("\n");
		sb.append(keySig);
		sb.append("\n");
		sb.append(timeSig);
		sb.append("\n");
		for (String name : getTrackNames()) {
			sb.append(getTrack(name));
			sb.append("\n");
			
		}
		return sb.toString();
	}

	

	

	

	
	
	
}
