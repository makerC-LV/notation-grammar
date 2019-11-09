package shiva.metamusic;

public enum Dynamics {
	
	ppp(16), pp(33), p(49), mp(64), mf(80), f(96), ff(112), fff(127) ;
	
	private int midiValue;
	
	private Dynamics(int midiValue) {
		this.midiValue = midiValue;
	}

	public int getMidiValue() {
		return midiValue;
	}
	
	
}