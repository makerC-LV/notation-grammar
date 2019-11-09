package shiva.scratch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jfugue.theory.TimeSignature;

import shiva.metamusic.BeatChange;
import shiva.metamusic.DrumBeat;
import shiva.metamusic.IAssignable;
import shiva.metamusic.MMRhythm;
import shiva.metamusic.MMTempo;
import shiva.metamusic.MMTimeSig;
import shiva.metamusic.PlayCommand;
import shiva.metamusic.Var;
import shiva.metamusic.VarDef;
import shiva.metamusic.Voice;
import shiva.metamusic.util.MidiUtils;

public class DrumPatternsToSong4 {

	public static void main(String[] args) throws IOException {
		File f = new File("./src/main/resources/drumPatterns/200DrumPatterns.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		Map<String, VarDef> instMap = 
				generateInstMap(br);
//		System.out.println(instMap);
		SongInfo info;
		while((info = parseSong(br, instMap))!= null) {
			info.instDefs = new ArrayList<>(instMap.values());
			info.name = info.name.replaceAll("&|-", "_");
			File o = new File(f.getParent(), info.name + "." + info.subName + ".song4" );
			Path path = Paths.get(o.getPath());
		    byte[] strToBytes = info.asSong().getBytes();
		 
		    Files.write(path, strToBytes);
		} 

	}
	
	private static SongInfo parseSong(BufferedReader br, Map<String, VarDef> instMap) throws IOException {
		SongInfo info = new SongInfo();
		String line;
		while ((line = getNonEmptyLine(br)) != null) {
			try {
			if (line.startsWith("### ")) {
				String[] parts = line.split("\\s+");
				if (parts.length == 2) {
					info.name = parts[1];
					info.subName = "1";
				} else {
					info.subName = parts[parts.length - 1];
					StringBuilder sb = new StringBuilder();
					for (int i = 1; i < parts.length-1; i++) {
						sb.append(parts[i]);
					}
					info.name = sb.toString();
				}
				
				line = getNonEmptyLine(br);
				parts = line.split("\\s+");
				String tss = parts[0].substring(0, parts[0].length()-1);
				String tempos = parts[parts.length-1];
				String[] tsParts = tss.split("/");
				int num = Integer.parseInt(tsParts[0]);
				int denom = Integer.parseInt(tsParts[1]);
				info.timeSig = new MMTimeSig(new TimeSignature(num, denom), null);
				info.tempo = new MMTempo(Integer.parseInt(tempos.split("-")[0]), null);
				
				List<Boolean> accents = new ArrayList<>();
				line = getNonEmptyLine(br);
				if (!line.startsWith("#### Measure A")) {
					throw new RuntimeException("Couldn't find Measure A");
				}
				info.measureA =  new MMRhythm(1);
				line = getNonEmptyLine(br);
				while (line.startsWith("|")) {
					info.length = addToRhythm(info.measureA, info.measureAInstruments, line, accents, instMap);
					line = getNonEmptyLine(br);
				}
				if (!line.startsWith("#### Measure B")) {
					throw new RuntimeException("Couldn't find Measure B");
				}
				info.measureB =  new MMRhythm(1);
				accents.clear();
				line = getNonEmptyLine(br);
				while (line.startsWith("|")) {
					addToRhythm(info.measureB, info.measureBInstruments, line, accents, instMap);
					line = getNonEmptyLine(br);
				}
				if (!line.startsWith("#### Break")) {
					throw new RuntimeException("Couldn't find Break");
				}
				info.breakPattern =  new MMRhythm(1);
				line = getNonEmptyLine(br);
				while (line.startsWith("|")) {
					addToRhythm(info.breakPattern, info.breakInstruments, line, accents, instMap);
					line = getNonEmptyLine(br);
				}
				
				addRestsForUnusedInstruments(info);
				return info;
			}
			} catch (Exception ex) {
				System.out.println(line);
				System.out.println(info);
				ex.printStackTrace();
				System.exit(0);
			}
		}
		
		return null;
		
	}

	private static void addRestsForUnusedInstruments(SongInfo info) {
		add(info.measureA, info.measureAInstruments, info.measureB, info.measureBInstruments, info.length);
		add(info.measureA, info.measureAInstruments, info.breakPattern, info.breakInstruments, info.length);
		add(info.measureB, info.measureBInstruments, info.breakPattern, info.breakInstruments, info.length);
		
	}

	private static void add(MMRhythm ra, Set<String> ia, MMRhythm rb,
			Set<String> ib, int l) {
		addInternal(ra, ia, rb, ib, l);
		addInternal(rb, ib, ra, ia, l);
		
	}

	private static void addInternal(MMRhythm ra, Set<String> ia, MMRhythm rb, Set<String> ib, int l) {
		Set<String> ia2 = new LinkedHashSet<String>(ia);
		ia2.removeAll(ib);
		for (String inst : ia2) {
			ib.add(inst);
			addInstrument(rb, inst, l);
		}
		
		
	}

	private static void addInstrument(MMRhythm rb, String inst, int l) {
		rb.add(new Var(inst, null));
		for (int i = 0; i < l; i++) {
			rb.add(new DrumBeat(false, null));
		}
		
	}

	private static int addToRhythm(MMRhythm rhythm, Set<String> instruments, String line, List<Boolean> accents, Map<String, VarDef> instMap) {
		
		if (line.startsWith("|Drum")) {
			line = line.substring(5, line.length());
			line = line.replaceAll("\\|", " ");
			line = line.trim();
			int len = line.split("\\s+").length;
//			System.out.println(line);
			rhythm.add(new BeatChange((int) Math.floor(128.0/len), null));
			
			return len;
			 
		}
		if (line.startsWith("|---")) {
			return 0;	
		}
		String name = line.substring(1, 3);
		line = line.substring(4);
		line = line.replaceAll("\\|", "");
		line = line.replaceAll("\\s+", "");
		char[] ca = line.toCharArray();
		if (name.equals("AC")) {
			for (char c : ca) {
				accents.add(c == '1'? true : false);
			}
			
		} else {
			name = "$" + name;
			VarDef vd = instMap.get(name);
			if (vd == null) {
				throw new RuntimeException("Couldn't find inst for:" + name);
			}
			rhythm.add(new Var(name, null));
			instruments.add(name);
			for (int i = 0; i < ca.length; i++) {
				DrumBeat db = new DrumBeat(ca[i] == '1', null);
				if (accents.size() > i && accents.get(i)) {
					db.accent(1);
				}
				rhythm.add(db);
			}
			
		}
		return ca.length;
		
	}

	private static Map<String, VarDef> generateInstMap(BufferedReader br) throws IOException {
		String prefix = "This database follows the mapping";
		String line;
		while (!(line = getNonEmptyLine(br)).startsWith(prefix)) {
			line = getNonEmptyLine(br);
		}
		
		Map<String, VarDef> map = new LinkedHashMap<>();
		line = getNonEmptyLine(br);
		while (line.startsWith("*")) {
			String[] parts = line.split("\\s+");
			int num = Integer.parseInt(parts[1]);
			String varName = "$" + parts[2];
			String instName = MidiUtils.midiNoteToPercussion(num);
			IAssignable value = new Voice(instName, true, null);
			VarDef def = new VarDef(varName, value, null);
			map.put(varName, def);
			line = getNonEmptyLine(br);
		}
		return map;
	}

	private static String getNonEmptyLine(BufferedReader br) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {
			if (line.trim().length() > 0) {
				if (line.startsWith("### Endings")) {
					break;
				}
				return line;
			}
			
		}
		return null;
	}

	

	private static class SongInfo {
		String name;
		String subName;
		String description;
		MMTempo tempo;
		MMTimeSig timeSig;
		int length;
		List<VarDef> instDefs;
		MMRhythm measureA;
		Set<String> measureAInstruments = new LinkedHashSet<>();
		MMRhythm measureB;
		Set<String> measureBInstruments = new LinkedHashSet<>();
		MMRhythm breakPattern;
		Set<String> breakInstruments = new LinkedHashSet<>();
		@Override
		public String toString() {
			return "SongInfo [name=" + name + ", subName=" + subName + ", description=" + description + ", tempo="
					+ tempo + ", timeSig=" + timeSig + ", measureA=" + measureA + ", measureB=" + measureB
					+ ", breakPattern=" + breakPattern + "]";
		}
		public String asSong() {
			StringBuilder sb = new StringBuilder();
			sb.append("// " + name + " " + subName + " " + description + "\n");
			sb.append(tempo.toSong4());
			sb.append("\n");
			sb.append(timeSig.toSong4());
			sb.append("\n\n");
			
			for (VarDef vd : instDefs) {
				sb.append(vd.toSong4());
				sb.append("\n");
			}
			sb.append("\n\n");
			
			sb.append("// Measure A \n");
			PlayCommand pc = new PlayCommand();
			pc.add(measureA);
			sb.append(pc.toSong4());
			sb.append("\n");
			
			
			sb.append("// Measure B \n");
			pc = new PlayCommand();
			pc.add(measureB);
			sb.append(pc.toSong4());
			sb.append("\n");
			
			sb.append("// Break\n");
			pc = new PlayCommand();
			pc.add(breakPattern);
			sb.append(pc.toSong4());
			sb.append("\n");
			
			return sb.toString();
			
		}
		
		
	}

}
