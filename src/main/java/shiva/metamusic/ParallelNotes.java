package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;

public class ParallelNotes extends ElementWithDuration implements ICopiable, INotesElement {

	List<MMNote> notes = new ArrayList<>();
	
	public ParallelNotes(MMDuration time, Location location) {
		super(time, location);
		
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
	public ICopiable copy() {
		ParallelNotes newNotes = new ParallelNotes(time, getLocation());
		for (MMNote n : notes) {
			MMNote newNote = (MMNote) n.copy();
			newNotes.addNote(newNote); 
		}
		return newNotes;
	}

	public List<MMNote> getNotes() {
		return notes;
	}

	@Override
	public Type getNotesElementType() {
		return Type.PARALLELNOTES;
	}

	@Override
	public String toSong4() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (MMNote n : notes) {
			sb.append(n.toSong4());
			sb.append(" ");
		}
		
		sb.append("}");
		return sb.toString();
	}

}
