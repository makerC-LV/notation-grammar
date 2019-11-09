package shiva.metamusic;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TestMMDuration {

	
	@Test
	public void testDurationList() {
		List<MMDuration> l = MMDuration.getDurationList(128);
		assertEquals(1, l.size());
		assertEquals(128, l.get(0).getPulses());
		
		l = MMDuration.getDurationList(200);
		assertEquals(3, l.size());
		assertEquals(128, l.get(0).getPulses());
		assertEquals(64, l.get(1).getPulses());
		
	}
}
