package shiva.metamusic;

import java.util.ArrayList;

public class MMRhythm extends ArrayList<IRhythmElement> implements IPlayable, IRhythmElement, IAssignable {

	private int reps;
	
	
	public MMRhythm(int reps) {
		super();
		this.reps = reps;
	}

	
	public int getReps() {
		return reps;
	}


	@Override
	public IRhythmElement.Type getRhythmElementType() {
		return IRhythmElement.Type.RHYTHM;
	}

	@Override
	public IPlayable.Type getPlayableType() {
		return IPlayable.Type.RHYTHM;
	}
	
	@Override
	public IAssignable.Type getType() {
		return IAssignable.Type.RHYTHM;
	}
	
	public String toSong4() {
		StringBuilder sb = new StringBuilder();
		for (IRhythmElement ir: this) {
			sb.append(ir.toSong4());
		}
		if (reps == 1) {
			return sb.toString() + "\n" ;
		} else {
			return "( " + sb.toString() + " ) X " + reps + "\n";
		}
	}

}
