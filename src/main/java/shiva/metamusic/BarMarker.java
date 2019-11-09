package shiva.metamusic;

public class BarMarker extends Locatable implements INotesElement, IRhythmElement {

	

	public BarMarker(Location location) {
		super(location);
	}

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
