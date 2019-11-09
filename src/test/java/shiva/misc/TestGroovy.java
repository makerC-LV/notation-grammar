package shiva.misc;

import static org.junit.Assert.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import shiva.metamusic.util.PlayUtils;

public class TestGroovy {
	
	@Test
	public void test() {
		
		// call groovy expressions from Java code
		Binding binding = new Binding();
		binding.setVariable("foo", new Integer(2));
		GroovyShell shell = new GroovyShell(binding);

		Object value = shell.evaluate("  println(foo);  result = 10 ; return [1, 2, 3] ");
		System.out.println(binding.getVariable("result"));
		System.out.println(value);
	}
	
	@Test
	public void testPlay() {
		try {
			PlayUtils.play("/[ import shiva.music.generate.ScriptHelper; return ScriptHelper.notes([1,2], 'Cmaj'); ]/");
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
