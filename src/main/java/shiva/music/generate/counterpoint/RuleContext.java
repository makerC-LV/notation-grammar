package shiva.music.generate.counterpoint;

public class RuleContext {
	
	CounterpointMelody melody;
	Voice v;
	Species species;
	VoiceNote sn;
	
	
	
	public RuleContext(CounterpointMelody melody, Voice v, Species species, VoiceNote sn) {
		this.melody = melody;
		this.v = v;
		this.species = species;
		this.sn = sn;
	}
	
	
}