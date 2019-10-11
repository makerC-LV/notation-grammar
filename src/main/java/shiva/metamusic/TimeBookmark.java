package shiva.metamusic;

public class TimeBookmark implements IPlayable {

	private String varName;
	
	
	
	public TimeBookmark(String varName) {
		super();
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
