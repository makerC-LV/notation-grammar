package shiva.metamusic;

import org.jfugue.midi.MidiDictionary;
import org.jfugue.theory.Note;

public class Voice implements IAssignable {
	
	public static final int DEFAULT_PERCUSSION_NOTE = 42; // Closed hi-hat

	private String instrumentName;
	private boolean percussion;
	private int midiNote; // (for percussion)
	private int midiProgramChange;  // for a note
	
	public Voice(String instrumentName, boolean isPercussion) {
		super();
		this.instrumentName = instrumentName;
		this.percussion = isPercussion;
		if (isPercussion) {
			midiNote = getRhythmMidiNum(instrumentName);
		} else {
			midiProgramChange = MidiDictionary.INSTRUMENT_STRING_TO_BYTE.get(instrumentName);
		}
	}

	public static int getRhythmMidiNum(String instrumentName) {
		int i = 0;
		for (String inst : Note.PERCUSSION_NAMES) {
			if (inst.equals(instrumentName.toUpperCase())) {
				return i + 35;
			}
			i++;
		}
		return DEFAULT_PERCUSSION_NOTE;
	}

	
	public int getMidiProgramChange() {
		return midiProgramChange;
	}

	public boolean isPercussion() {
		return percussion;
	}



	public String getInstrumentName() {
		return instrumentName;
	}



	@Override
	public Type getType() {
		return Type.VOICE;
	}



	@Override
	public String toSong4() {
		return instrumentName + " " ;
	}



	public int getPercussionNote() {
		return midiNote;
	}

}
