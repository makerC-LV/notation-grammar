package shiva.metamusic;

public class Var extends Locatable implements IPlayable, INotesElement, IRhythmElement {

	private String varName;

	public Var(String varName, Location location) {
		super(location);
		this.varName = varName;
	}

	public String getVarName() {
		return varName;
	}

	@Override
	public IPlayable.Type getPlayableType() {
		return IPlayable.Type.VAR;
	}

	@Override
	public IRhythmElement.Type getRhythmElementType() {
		return IRhythmElement.Type.VAR;
	}

	@Override
	public INotesElement.Type getNotesElementType() {
		return INotesElement.Type.VAR;
	}

	@Override
	public String toSong4() {
		return varName + " ";
	}


}
