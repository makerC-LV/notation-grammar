package shiva.metamusic;

public class VarDef extends Locatable implements ISongElement {

	String varName;
	IAssignable value;
	
	
	public VarDef(String varName, IAssignable value, Location location) {
		super(location);
		this.varName = varName;
		this.value = value;
	}


	public String getVarName() {
		return varName;
	}


	public IAssignable getValue() {
		return value;
	}


	@Override
	public Type getSongElementType() {
		
		return Type.VARDEF;
	}


	public void setAssignable(IAssignable ass) {
		this.value = ass;
		
	}


	@Override
	public String toSong4() {
		return varName + " = " + value.toSong4() + " ; ";
	}
}
