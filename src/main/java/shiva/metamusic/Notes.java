package shiva.metamusic;

import java.util.ArrayList;
import java.util.List;

public class Notes extends ArrayList<INotesElement> implements IPlayable, INotesElement, IAssignable {

	private int reps;
	
	
	public Notes(int reps) {
		super();
		this.reps = reps;
	}

	
	public int getReps() {
		return reps;
	}


	@Override
	public INotesElement.Type getNotesElementType() {
		return INotesElement.Type.NOTES;
	}

	@Override
	public IPlayable.Type getPlayableType() {
		return IPlayable.Type.NOTES;
	}

	@Override
	public IAssignable.Type getType() {
		return IAssignable.Type.NOTES;
	}

	@Override
	public String toSong4() {
		StringBuilder sb = new StringBuilder();
		for (INotesElement i : this) {
			sb.append(i.toSong4());
		}
		if (reps == 1) {
			return sb.toString();
		} else {
			return "( " + sb.toString() + " ) X " + reps + " ";
		}
	}


	public static IPlayable create(List<MMNote> notes) {
		Notes n = new Notes(1);
		for (MMNote nn : notes) {
			n.add(nn);
		}
		return n;
	}

}
