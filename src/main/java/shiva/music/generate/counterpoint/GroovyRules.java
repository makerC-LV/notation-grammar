package shiva.music.generate.counterpoint;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.codehaus.groovy.control.CompilationFailedException;

import groovy.lang.GroovyClassLoader;
import shiva.music.generate.counterpoint.Rules.GRule;

public interface GroovyRules {

	List<GRule>getRules();
	
	static List<GRule> getGroovyRules() {
	
		
		try {
			
			File f = new File("src/main/java/shiva/music/generate/counterpoint/GRules.groovy");
//			String file = "GRules.groovy";
//			URL u = GroovyRules.class.getClassLoader().getResource(file);
//			System.err.println(u);
			InputStream is = new FileInputStream(f);
//			InputStream is = GroovyRules.class.getClassLoader().getResourceAsStream(file);
			Class<GroovyRules> scriptClass = new GroovyClassLoader().parseClass(new InputStreamReader(is), "Grules.groovy");
					
			GroovyRules gr =  scriptClass.newInstance() ;
			is.close();
			return gr.getRules();
		} catch (CompilationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		int l = getGroovyRules().size();
		System.out.println(l);
	}
}
