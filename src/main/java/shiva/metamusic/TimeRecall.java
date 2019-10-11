package shiva.metamusic;

public class TimeRecall implements IPlayable {

	private String varName;
	
	
	public TimeRecall(String varName) {
		super();
		this.varName = varName;
	}


	public String getVarName() {
		return varName;
	}


	@Override
	public Type getPlayableType() {
		return Type.TIMERECALL;
	}


	@Override
	public String toSong4() {
		return "recalltime:" + varName + " " ;
	}

}
