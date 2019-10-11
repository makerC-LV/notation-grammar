package shiva.metamusic;

import java.util.ArrayList;
import java.util.Stack;

import org.jfugue.theory.Key;
import org.jfugue.theory.TimeSignature;

public class Song extends ArrayList<ISongElement>{

	MMTempo tempo;
	MMKeySig keySig;
	MMTimeSig timeSig;
	
	
	public Song() {
		this(new MMKeySig(Key.DEFAULT_KEY), new MMTimeSig(TimeSignature.DEFAULT_TIMESIG), MMTempo.DEFAULT_TEMPO);
	}
	
	protected Song(MMKeySig keySig, MMTimeSig timeSig, MMTempo tempo) {
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

	public String toSong4() {
		StringBuilder sb = new StringBuilder();
		sb.append(tempo.toSong4());
		sb.append("\n");
		sb.append(timeSig.toSong4());
		sb.append("\n");
		sb.append(keySig.toSong4());
		sb.append("\n");
		
		for (ISongElement el: this) {
			sb.append(el.toSong4());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
}
