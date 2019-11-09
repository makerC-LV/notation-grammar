package shiva.metamusic;

public class TimeBookmark extends Locatable implements IPlayable {

	private String varName;
	
	
	
	public TimeBookmark(String varName, Location location) {
		super(location);
		this.varName = varName;
	}



	public String getVarName() {
		return varName;
	}



	@Override
	public Type getPlayableType() {
		return Type.TIMEBOOKMARK;
	}



	@Override
	public String toSong4() {
		return "marktime:" + varName + " "; 
	}

}
