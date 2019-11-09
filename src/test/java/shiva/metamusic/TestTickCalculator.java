package shiva.metamusic;

import org.junit.Test;

import shiva.metamusic.util.MidiUtils;
import shiva.metamusic.util.TickCalculator;

public class TestTickCalculator {
	
	@Test
	public void test1() {
		TickCalculator tc = new TickCalculator(MidiUtils.DEFAULT_PPQ, MMTimeSig.DEFAULT_TIMESIG, MMTempo.DEFAULT_TEMPO);
		System.out.println(tc.millisecondsToPulses(1000));
	}

}
