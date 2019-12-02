package shiva.music.generate.counterpoint

import java.util.function.Predicate

import com.jsyn.unitgen.PitchDetector

import shiva.music.generate.counterpoint.Rules.GRule

class GRules implements GroovyRules {

	private int INFINITE = BNB.INFINITE;
	
	static int unison = 0;
	static int minorSecond = 1;
	static int majorSecond = 2;
	static int minorThird = 3;
	static int majorThird = 4;
	static int fourth = 5;
	static int tritone = 6;
	static int fifth = 7;
	static int minorSixth = 8;
	static int majorSixth = 9;
	static int minorSeventh = 10;
	static int majorSeventh = 11;
	static int octave = 12;

//	 Condensed from table in http://openmusictheory.com/intervals.html (I think)
	boolean[] perfectConsonance = [true, false, false, false, false, false, false,
			true, false, false, false, false, true]
	boolean[] imperfectConsonance = [false, false, false, true, true, false, false, false,
			true, true, false, false, false]
	boolean[] dissonance = [false, true, true, false, false, true, true, false,
			false, false, true, true, false]
		
	
	List<GRule> rules = [
		// Ensure pitch is reasonable.
		rule {
			name "PitchInBounds"
			penalty INFINITE
			test {rc -> return pitchInBounds(rc) }
		},
		
		rule {
			name "DurationMatchesSpecies"
			penalty INFINITE
			test {rc -> return durationMatchesSpecies(rc) }
		},
		
		rule {
			name "CantusStartOnDO"
			penalty INFINITE
			species Species.CANTUS
			condition {rc -> return isFirstNote(rc)}
			test {rc -> return pitch(rc.sn) == 60 }
		},
		
		rule {
			name "CantusEndOnDO"
			penalty INFINITE
			species Species.CANTUS
			condition {rc -> return isLastNote(rc)}
			test {rc -> return pitch(rc.sn) == 60 }
		},
		
		rule {
			name "CantusStepToEnd"
			penalty INFINITE
			species Species.CANTUS
			condition {rc -> return isLastNote(rc)}
			test {rc -> return Math.abs(currentPitchDiff(rc)) <= 3 }
		},
		
		rule {
			name "CantusIntervalsConsonant"
			penalty INFINITE
			species Species.CANTUS
			condition {rc -> return !isFirstNote(rc)}
			test {rc -> 
				int ad = Math.abs(currentPitchDiff(rc)) % 12;
				return !dissonance[ad] ;
			}
		},
		
		rule {
			name "CantusRange14"
			penalty INFINITE
			species Species.CANTUS
			condition {rc -> return !isFirstNote(rc)}
			test {rc -> return !rangeAbove(rc.v, rc.sn, 16)}
		},
		
		rule {
			name "CantusRange12"
			penalty 10
			species Species.CANTUS
			condition {rc -> return !isFirstNote(rc)}
			test {rc -> return !rangeAbove(rc.v, rc.sn, 12)}
		},
		
		rule {
			name "CantusSingleClimax"
			penalty INFINITE
			species Species.CANTUS
			condition {rc -> return !isFirstNote(rc)}
			test {rc -> return !multipleHighNotes(rc.v, rc.sn)}
		},
		
		rule {
			name "CantusStep4"
			penalty 100
			species Species.CANTUS
			condition {rc -> return !isFirstNote(rc)}
			test {rc -> return Math.abs(currentPitchDiff(rc)) < 4}
		},
		
		rule {
			name "CantusStep8"
			penalty 1000
			species Species.CANTUS
			condition {rc -> return !isFirstNote(rc)}
			test {rc -> return Math.abs(currentPitchDiff(rc)) < 8}
		},
		
		rule {
			name "CantusDirectionChange"
			penalty  200
			species Species.CANTUS
			condition {rc -> return rc.v.size() >= 2}
			test {rc -> return pitchDiff(rc.v, -1) * currentPitchDiff(rc) >= 0}
		},
		
		rule {
			name "CantusLargeLeap=>OppositeStep"
			penalty  INFINITE
			species Species.CANTUS
			condition {rc -> return rc.v.size() >= 2}
			test {rc -> return oppositeStepFollowsLeap(rc)}
		},
		
		rule {
			name "CantusConsecutiveLeaps"
			penalty  INFINITE
			species Species.CANTUS
			condition {rc -> return rc.v.size() >= 2}
			test {rc -> return !(isLeap(pitchDiff(rc.v, -1)) && isLeap(currentPitchDiff(rc))) }
		},
		
		rule {
			name "CantusRepeatedNote"
			penalty  40
			species Species.CANTUS
			condition {rc -> return !isFirstNote(rc)}
			test {rc -> return rc.sn.midiNum != rc.v.last().midiNum  }
		},
	]

	
	
	boolean oppositeStepFollowsLeap(rc) {
		int ppd = pitchDiff(rc.v, -1);
		if (!isLeap(ppd)) {
			return true
		} else {
			int cd = currentPitchDiff(rc)
			return cd < 3 && cd * ppd < 0;
		}
	}
	
	boolean isLeap(int pitchChange) {
		return Math.abs(pitchChange) > 5
	}
	
	
	boolean multipleHighNotes(Voice v, VoiceNote vn) {
		int mp = maxPitch(v);
		return vn.midiNum == mp;
	}
	
	boolean rangeAbove(Voice v, VoiceNote vn, int limit) {
		int max = maxPitch(v)
		int min = minPitch(v);
		
		max = Math.max(max, vn.midiNum);
		min = Math.min(min, vn.midiNum);
		
		return max - min > limit;
	}
	
	int maxPitch(Voice v) {
		return v.max { it.midiNum }.midiNum
	}
	
	int minPitch(Voice v) {
		return v.max { it.midiNum }.midiNum
	}
	
	int pitchDiff(VoiceNote first, VoiceNote second) {
		return first.midiNum - second.midiNum;
	}
	
	int pitchDiff(Voice v, int gapNum) {
		int bi
		if (gapNum < 0) {
			bi = v.size() + gapNum
		} else {
			bi = gapNum + 1;
		}
		return v.get(bi).midiNum - v.get(bi-1).midiNum;
	}
	
	int currentPitchDiff(RuleContext rc) {
		VoiceNote n = rc.v.last();
		return rc.sn.midiNum - n.midiNum;
	}

	int pitch (VoiceNote v) {
		return v.midiNum;
	}

	boolean durationMatchesSpecies(RuleContext rc) {
		int nd = rc.sn.getDurationInBeats();
		int beatsPerMeasure = rc.melody.getBeatsPerMeasure();
		switch (rc.species) {
			case Species.CANTUS:
				return nd == beatsPerMeasure;
			case Species.FIRST:
				return nd == beatsPerMeasure;
			case Species.SECOND:
				return nd == beatsPerMeasure/2;
			case Species.THIRD:
				return nd == beatsPerMeasure/2;
			case Species.FOURTH:
				return nd = beatsPerMeasure/4;
			case Species.FIFTH:
				return nd >= beatsPerMeasure/4;
		}
		return false;
	}

	boolean pitchInBounds(RuleContext rc) {
		int pitch = rc.sn.midiNum;
		return pitch <= BNB.HIGHEST_NOTE && pitch >= BNB.LOWEST_NOTE;
	}

	boolean isLastNote(RuleContext rc) {
		return ((rc.v.getDurationinBeats() + rc.sn.getDurationInBeats())
				== rc.melody.getDurationInBeats())
	}

	boolean isFirstNote(RuleContext rc) {
		return rc.v.isEmpty();
	}

	Predicate and(Object... fns) {
		Predicate p  = null
		for (func in fns) {
			p = (p == null ? func : p.and(func))
		}
		return p;
	}

	@Override
	public List<GRule> getRules() {
		return rules
	}
	
	static class RuleMaker {
		GRule rule = new GRule();
		
		RuleMaker() {
			rule.condition = {rc -> true;}
		}
		
		void name(String name) {
			rule.name = name;
		}
		
		void penalty(double d) {
			rule.penalty = d;
		}
		
		void condition(Predicate p) {
			rule.condition = p;
		}
		
		void test(Predicate p) {
			rule.test = p;
		}
		
		void species(Species s) {
			rule.condition = rule.condition.and({rc -> return rc.species == s });
		}
	}
		
	static GRule rule(closure) {
		RuleMaker rm = new RuleMaker();
		closure.delegate = rm;
		closure();
		
		return rm.rule;
		
	}
}
