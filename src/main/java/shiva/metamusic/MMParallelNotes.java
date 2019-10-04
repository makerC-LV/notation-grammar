package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;

public class MMParallelNotes extends MMTrackItem {

	List<MMNote> notes = new ArrayList<>();
	
	public MMParallelNotes(MMDuration time) {
		super(MMItemType.PARALLELNOTES, time);
		
	}
	
	public void addNote(MMNote note) {
		if (note == null) {
			System.out.println("Null note!");
		}
		notes.add(note);
	}

	@Override
	public MMDuration getDuration() {
		if (notes.isEmpty()) {
			return MMDuration.ZERO;
		}
		return notes.get(0).getDuration();
	}

	@Override
	public MMTrackItem copy() {
		MMParallelNotes newNotes = new MMParallelNotes(time);
		for (MMNote n : notes) {
			MMNote newNote = (MMNote) n.copy();
			newNotes.addNote(newNote); 
		}
		return newNotes;
	}

	public List<MMNote> getNotes() {
		return notes;
	}

}
