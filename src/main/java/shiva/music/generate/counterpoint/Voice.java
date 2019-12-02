package shiva.music.generate.counterpoint;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;
import shiva.metamusic.MMTimeSig;

public class Voice extends ArrayList<VoiceNote> implements Comparable<Voice> {

	private CounterpointMelody melody;
	int score = 0;

	public CounterpointMelody getMelody() {
		return melody;
	}

	public void setMelody(CounterpointMelody melody) {
		this.melody = melody;
	}

	public int getDurationinBeats() {
		return stream().collect(Collectors.summingInt(n->n.getDurationInBeats()));
	}
	
	public VoiceNote last() {
		if (isEmpty()) {
			return null;
		} else {
			return get(size() -1);
		}
	}

	
	
	@Override
	public boolean add(VoiceNote e) {
		score += e.score;
		return super.add(e);
	}

	@Override
	public void add(int index, VoiceNote element) {
		super.add(index, element);
		score += element.score;
	}

	@Override
	public boolean addAll(Collection<? extends VoiceNote> c) {
		throw new RuntimeException("Unimplemented - score adjustment required");
		//return super.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends VoiceNote> c) {
		throw new RuntimeException("Unimplemented - score adjustment required");
		//return super.addAll(index, c);
	}

	@Override
	public int compareTo(Voice o) {
		return score - o.score;
	}
	
	public Voice copy() {
		Voice v = new Voice();
		v.melody = melody;
		this.forEach( vn -> {v.add(vn.copy());}) ;
		return v;
	}

	public boolean identicalNotes(Voice ps) {
		if (size() != ps.size()) {
			return false;
		}
		for (int i = 0; i < size(); i++) {
			if (!get(i).identicalNote(ps.get(i))) {
				return false;
			}
		}
		return true;
	}

	public List<MMNote> toNoteList(MMKeySig keySig, MMTimeSig timeSig) {
		return this.stream().map(vn -> vn.toMMNote(keySig, timeSig)).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return super.toString() + " " + score;
	}

	
	
}
