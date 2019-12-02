package shiva.music.generate.counterpoint;

import java.util.ArrayList;

public class CounterpointMelody extends ArrayList<Voice>{
	
	private int measures; 
	private int beatsPerMeasure;
	private int numVoices;
	
	
	public CounterpointMelody(int measures, int beatsPerMeasure, int numVoices) {
		super();
		this.measures = measures;
		this.beatsPerMeasure = beatsPerMeasure;
		this.numVoices = numVoices;
	}


	public int getMeasures() {
		return measures;
	}


	public int getBeatsPerMeasure() {
		return beatsPerMeasure;
	}


	public int getNumVoices() {
		return numVoices;
	}


	public int getDurationInBeats() {
		return measures * beatsPerMeasure;
	}

	
	
	
}
