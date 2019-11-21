package shiva.metamusic.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;

import org.jfugue.theory.Note;

import shiva.metamusic.INotesElement;
import shiva.metamusic.MMDuration;
import shiva.metamusic.MMNote;
import shiva.metamusic.MMTempo;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.Notes;

public class NotesFromMidi  implements Receiver {
	// See JFugue MidiParser.java
	private MMTempo tempo = MMTempo.DEFAULT_TEMPO;
	private MMTimeSig timeSig = MMTimeSig.DEFAULT_TIMESIG;
	TickCalculator tc;

	Comparator<PlayedNote> comp = new Comparator<PlayedNote>() {

		@Override
		public int compare(PlayedNote o1, PlayedNote o2) {
			return o1.startPulses - o2.startPulses;
		}
		
	};
	
	//SortedSet<MMNote> noteSet = new TreeSet<>(comp);
	List<PlayedNote> capturedNotes = new ArrayList<>();
	
	Map<Integer, Long> onNotes = new HashMap<>();
	long lastNoteEnd = 0;
	long startTime;
	boolean running;

	public NotesFromMidi() {
		this(MMTempo.DEFAULT_TEMPO, MMTimeSig.DEFAULT_TIMESIG);
	}

	public NotesFromMidi(MMTempo tempo, MMTimeSig timeSig) {
		super();
		this.tempo = tempo;
		this.timeSig = timeSig;
		calcTicksPerPulse();
	}

	public void start() {
		capturedNotes.clear();
		onNotes.clear();
		lastNoteEnd = 0;
		running = true;
		startTime = System.currentTimeMillis();
	}

	public void stop() {
		running = false;
		onNotes.clear();
		lastNoteEnd = 0;
	}

	public void setTempo(MMTempo tempo) {
		System.out.println(tempo.getBpm());
		this.tempo = tempo;
		calcTicksPerPulse();
	}

	public void setTimeSig(MMTimeSig timeSig) {
		this.timeSig = timeSig;
		calcTicksPerPulse();
	}

	private void calcTicksPerPulse() {
		tc = new TickCalculator(MidiUtils.DEFAULT_PPQ, timeSig, tempo);
		System.out.println(tc);
	}
	
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void send(MidiMessage message, long timeStamp) {
		if (!running) {
			return;
		}
		if (message instanceof ShortMessage) {
			parseShortMessage((ShortMessage) message, timeStamp);
		} else if (message instanceof MetaMessage) {
			// parseMetaMessage((MetaMessage) message, timeStamp);
			System.out.println("NotesFromMidi: ignoring: " + message.getClass().getName());
		} else if (message instanceof SysexMessage) {
//				parseSysexMessage((SysexMessage) message, timeStamp);
			System.out.println("NotesFromMidi: ignoring: " + message.getClass().getName());
		} else {
			System.out.println("NotesFromMidi: ignoring: " + message.getClass().getName());
		}

	}

	private void parseShortMessage(ShortMessage message, long timeStamp) {
		switch (message.getCommand()) {
		case ShortMessage.NOTE_OFF:
			noteOff(message.getChannel(), message, timeStamp);
			break;
		case ShortMessage.NOTE_ON:
			noteOn(message.getChannel(), message, timeStamp);
			break;
		case ShortMessage.POLY_PRESSURE:
			polyphonicAftertouch(message.getChannel(), message, timeStamp);
			;
			break;
		case ShortMessage.CONTROL_CHANGE:
			controlChange(message.getChannel(), message, timeStamp);
			break;
		case ShortMessage.PROGRAM_CHANGE:
			programChange(message.getChannel(), message, timeStamp);
			break;
		case ShortMessage.CHANNEL_PRESSURE:
			channelAftertouch(message.getChannel(), message, timeStamp);
			break;
		case ShortMessage.PITCH_BEND:
			pitchWheel(message.getChannel(), message, timeStamp);
			break;
		default:
			System.out.println("NotesFromMidi: parseShortMessage: ignoring: " + message.getCommand());
			break;
		}

	}

	private void noteOff(int channel, ShortMessage message, long timeStamp) {
		long msTime = System.currentTimeMillis();
		int note = message.getData1();
		int velocity = message.getData2();
		System.out.println("Note off: chan:" + channel + " note:" + note + " vel:" + velocity + " ms:" + msTime);
		Long onTime = onNotes.get(note);
		if (onTime != null) {
			PlayedNote pn = new PlayedNote(note, velocity, onTime, msTime);
			capturedNotes.add(pn);

		}
		lastNoteEnd = msTime;
	}

	private void noteOn(int channel, ShortMessage message, long timeStamp) {
		long msTime = System.currentTimeMillis();
		int note = message.getData1();
		int velocity = message.getData2();
		if (velocity == 0) {
			noteOff(channel, message, timeStamp);
			return;
		}
		System.out.println("Note on: chan:" + channel + " note:" + note + " vel:" + velocity + " ms:" + msTime);
//		if (lastNoteEnd > 0) {
//			fillInRests(lastNoteEnd, msTime);
//		}
		onNotes.put(note, msTime);
	}

//	private void fillInRests(long start, long end) {
//		List<MMDuration> durations = getSensibleDuration(start, end);
//		for (MMDuration dur : durations) {
//			MMNote rest = new MMNote(MMDuration.ZERO, Note.createRest(dur.toDecimal()), dur, null);
//			noteSet.add(rest);
//		}
//
//	}
//
//	private List<MMDuration> getSensibleDuration(long startMs, long endMs) {
//		int pulses = tc.millisecondsToPulses(endMs - startMs);
//		System.out.println("NotesFromMidi: Ms: " + (endMs - startMs) + "  pulses:" + pulses);
//		List<MMDuration> dl = MMDuration.getDurationList(pulses);
//		System.out.println(dl);
//		return dl;
//	}

	public Notes getNotes() {
		Notes notes = new Notes(1);
		capturedNotes.forEach(pn->System.out.println(pn));
		adjustDurations(capturedNotes);
		capturedNotes.forEach(pn->System.out.println(pn));
		quantizeStarts(capturedNotes);
		capturedNotes.forEach(pn->System.out.println(pn));
		SortedSet<PlayedNote> sortedNotes = new TreeSet<>(comp);
		sortedNotes.addAll(capturedNotes);
		int currentTime = 0;
		boolean firstNote = true;
		for (PlayedNote pn : sortedNotes) {
			if (pn.startPulses < currentTime) {
				System.out.println("Warning - overlapping notes");
			} 
			if (currentTime < pn.startPulses && !firstNote) {
				MMNote rest = new MMNote(
						MMDuration.ZERO, Note.createRest(1), new MMDuration(pn.startPulses - currentTime), null);
				notes.add(rest);
			}
			notes.add(new MMNote(MMDuration.ZERO, new Note(pn.midiNum), new MMDuration(pn.durationPulses), null));
			currentTime = pn.startPulses + pn.durationPulses;
			firstNote = false;
		}
		return notes;
	}
	
	
	private void quantizeStarts(List<PlayedNote> d1) {
		for (PlayedNote pn: d1) {
			int startPulses = tc.millisecondsToPulses(pn.start - startTime);
			if (pn.durationPulses >= MMDuration.EIGHTH.getPulses()) {
				pn.startPulses = quantize(MMDuration.EIGHTH.getPulses(), startPulses);
			} else {
				pn.startPulses = quantize(pn.durationPulses, startPulses);
			}
		}
		
	}

	private int quantize(int pulses, int start) {
		return (int) Math.round(((double) start)/pulses);
	}

	private void adjustDurations(List<PlayedNote> l) {
		l.forEach(pn-> 
		pn.durationPulses = adjustDuration(pn.start, pn.end));
	}
	
	private int adjustDuration(long start, long end) {

		int pulses = tc.millisecondsToPulses(end - start);
		int adjusted = MMDuration.getClosestFittingDuration(pulses).getPulses();
		System.out.println(pulses +  " -> " + adjusted);
		return adjusted;

	}

	private void polyphonicAftertouch(int channel, ShortMessage message, long timeStamp) {
		System.out.println("NotesFromMidi:polyphonicAftertouch : ignoring: " + channel);

	}

	private void controlChange(int channel, ShortMessage message, long timeStamp) {
		System.out.println("NotesFromMidi: controlChange: ignoring: " + channel);
	}

	private void programChange(int channel, ShortMessage message, long timeStamp) {
		System.out.println("NotesFromMidi: programChange: ignoring: " + channel);

	}

	private void channelAftertouch(int channel, ShortMessage message, long timeStamp) {
		System.out.println("NotesFromMidi: channelAftertouch: ignoring: " + channel);

	}

	private void pitchWheel(int channel, ShortMessage message, long timeStamp) {
		System.out.println("NotesFromMidi: pitchWheel: ignoring: " + channel);

	}

	public static void main(String[] args) {
		NotesFromMidi nfm = new NotesFromMidi();
		nfm.setTempo(new MMTempo(240, null));
		nfm.setTempo(new MMTempo(480, null));
		
	}

	private class PlayedNote {
		int midiNum;
		int velocity;
		long start;
		long end;
		int durationPulses;
		int startPulses;
		
		public PlayedNote(int midiNum, int velocity, long start, long end) {
			super();
			this.midiNum = midiNum;
			this.velocity = velocity;
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "PlayedNote [midiNum=" + midiNum + ", velocity=" + velocity + ", start=" + start + ", end=" + end
					+ ", durationPulses=" + durationPulses + ", startPulses=" + startPulses + "]";
		}
		
		
		
	}

}