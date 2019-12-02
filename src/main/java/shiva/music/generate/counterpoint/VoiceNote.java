package shiva.music.generate.counterpoint;

import java.util.ArrayList;
import java.util.List;

import org.jfugue.theory.Note;

import shiva.metamusic.MMDuration;
import shiva.metamusic.MMKeySig;
import shiva.metamusic.MMNote;
import shiva.metamusic.MMTimeSig;
import shiva.music.generate.counterpoint.Rules.RuleResult;

public class VoiceNote implements Comparable<VoiceNote>{

	int midiNum;
	private Voice voice;
	int durationInBeats;
	boolean isDotted;
	public int score = 0;
	public boolean debug;
	public List<RuleResult> res = new ArrayList<>();
	
	
	
	public VoiceNote(int midiNum, int durationInBeats, boolean isDotted) {
		super();
		this.midiNum = midiNum;
		this.durationInBeats = durationInBeats;
		this.isDotted = isDotted;
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	public int getDurationInBeats() {
		return isDotted? (int) Math.round(durationInBeats * 1.5) : durationInBeats;
	}

	public void setDurationInBeats(int durationInBeats) {
		this.durationInBeats = durationInBeats;
	}

	public boolean isDotted() {
		return isDotted;
	}

	public void setDotted(boolean isDotted) {
		this.isDotted = isDotted;
	}

	

	@Override
	public int compareTo(VoiceNote o) {
		return score - o.score;
	}

	@Override
	public String toString() {
		return toStringSimple()
				+ (debug ? printS(res) : "");
	}

	public String toStringSimple() {
		return String.format("VoiceNote[%d, %d, %d]", midiNum, getDurationInBeats(), score);
	}

	private String printS(List<RuleResult> res2) {
		StringBuilder sb = new StringBuilder();
		boolean first = false;
		for (RuleResult rr: res) {
			if (!first) {
				sb.append("\n");
			}
			sb.append(rr.toString());
		}
		return sb.toString();
	}

	public void addResult(RuleResult rr) {
		if (debug) {
			res.add(rr);
		}
	}

	public VoiceNote copy() {
		VoiceNote vn = new VoiceNote(midiNum, durationInBeats, isDotted);
		vn.score = score;
		vn.voice = voice;
		vn.debug = debug;
		vn.res.addAll(res);
		return vn;
	}

	public boolean identicalNote(VoiceNote o) {
		return midiNum == o.midiNum && getDurationInBeats() == o.getDurationInBeats();
	}
	
	
	public MMNote toMMNote(MMKeySig keySig, MMTimeSig timeSig) {
		int pulse = timeSig.getPulsesForBeat() * getDurationInBeats();
		return new MMNote(MMDuration.ZERO, new Note(midiNum), new MMDuration(pulse ), null);
	}
	
}
