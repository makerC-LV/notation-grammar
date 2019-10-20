package shiva.metamusic;

import shiva.metamusic.util.MidiUtils;
import shiva.metamusic.util.MidiUtils.Dynamics;

public class MMDynamics extends ElementWithDuration implements ICopiable, INotesElement, IRhythmElement {

	Dynamics dynamics;
	
	public MMDynamics(String s) {
		super(MMDuration.ZERO);
		duration = MMDuration.ZERO;
		this.dynamics = MidiUtils.Dynamics.valueOf(s);
	}
	
	public int getMidiValue() {
		return dynamics.getMidiValue();
	}
	
	@Override
	public shiva.metamusic.IRhythmElement.Type getRhythmElementType() {
		return shiva.metamusic.IRhythmElement.Type.DYNAMIC;
	}

	@Override
	public shiva.metamusic.INotesElement.Type getNotesElementType() {
		return shiva.metamusic.INotesElement.Type.DYNAMIC;
	}

	@Override
	public String toSong4() {
		return ":" + dynamics.name();
	}

	@Override
	public ICopiable copy() {
		return new MMDynamics(dynamics.name());
	}

}
