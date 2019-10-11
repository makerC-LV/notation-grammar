package shiva.metamusic;

public class Var implements IPlayable, INotesElement, IRhythmElement {

	private String varName;

	public Var(String varName) {
		super();
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
