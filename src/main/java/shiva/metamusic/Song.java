package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;

import org.jfugue.theory.TimeSignature;

public class Song extends ArrayList<ISongElement>{

	MMTempo tempo;
	MMKeySig keySig;
	MMTimeSig timeSig;
	
	
	public Song() {
		this(MMKeySig.DEFAULT_KEYSIG, MMTimeSig.DEFAULT_TIMESIG, MMTempo.DEFAULT_TEMPO);
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

	public void addNoteList(String voiceName, String instrument, boolean isPercussion, List<? extends INotesElement> mmnotes) {
		add(new VarDef(voiceName, new Voice(instrument.toUpperCase(), isPercussion, null), null));
		Notes notes = new Notes(1);
		notes.add(new Var(voiceName, null));
		for (INotesElement  mmn: mmnotes) {
			notes.add(mmn);
		}
		PlayCommand pc = new PlayCommand();
		pc.add(notes);
		add(pc);
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

	public static Song create(List<MMNote> notes) {
		return create(notes, MMKeySig.DEFAULT_KEYSIG);
	}

	public static Song create(List<MMNote> notes, MMKeySig keySig) {
		Song s = new Song();
		s.setKeySig(keySig);
		s.add(PlayCommand.create(notes));
		return s;
	}
	
	
	
}
