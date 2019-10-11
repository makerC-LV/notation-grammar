package shiva.metamusic;

public class BarMarker implements INotesElement, IRhythmElement {

	

	@Override
	public IRhythmElement.Type getRhythmElementType() {
		return IRhythmElement.Type.BARMARKER;
	}

	@Override
	public INotesElement.Type getNotesElementType() {
		return INotesElement.Type.BARMARKER;
	}

	@Override
	public String toSong4() {
		return " | ";
	}

}
