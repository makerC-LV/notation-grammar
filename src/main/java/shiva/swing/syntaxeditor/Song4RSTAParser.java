package shiva.swing.syntaxeditor;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.BadLocationException;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.fife.ui.rsyntaxtextarea.RSyntaxDocument;
import org.fife.ui.rsyntaxtextarea.parser.DefaultParserNotice;
import org.fife.ui.rsyntaxtextarea.parser.ExtendedHyperlinkListener;
import org.fife.ui.rsyntaxtextarea.parser.ParseResult;
import org.fife.ui.rsyntaxtextarea.parser.Parser;
import org.fife.ui.rsyntaxtextarea.parser.ParserNotice;

import shiva.metamusic.Song;
import shiva.metamusic.util.LinearSong;
import shiva.metamusic.util.LinearSongToMidi;
import shiva.metamusic.util.LocatableException;
import shiva.metamusic.util.Song4Visitor2;

public class Song4RSTAParser implements Parser {
	
	private static final boolean DEBUG = false;
	
	Song4Parsing parsing;
	
	ParseResultGenerator prgen;
	private Song4RSTAParseResult pres;

	public Song4RSTAParser(Song4Parsing parsing) {
		super();
		this.parsing = parsing;
		pres = new Song4RSTAParseResult(this);
		prgen = new ParseResultGenerator(pres , this);
		parsing.getLexer().removeErrorListeners();
		parsing.getParser().removeErrorListeners();
		parsing.getLexer().addErrorListener(prgen);
		parsing.getParser().addErrorListener(prgen);
		
	}

	@Override
	public ExtendedHyperlinkListener getHyperlinkListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getImageBase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	int[] charsInLines;
	
	@Override
	public ParseResult parse(RSyntaxDocument doc, String style) {
		pres.clear();
		try {
			String text = doc.getText(0, doc.getLength());
			pres.setLastLineParsed(countLines(text));
			prgen.charsInLines = charsInLines; // HACK
//			System.out.println("Parsing: " + text);
		
			CharStream input = CharStreams.fromString(text);
			parsing.getLexer().reset();
			parsing.getLexer().setInputStream(input);
			CommonTokenStream tokens = new CommonTokenStream(parsing.getLexer());
			parsing.getParser().reset();
			parsing.getParser().setTokenStream(tokens);
			ParseTree tree = parsing.getParser().song();
			parsing.setParseTree(tree);
			
			
			Song song = null;
			try {
				Song4Visitor2<Void> visitor = new Song4Visitor2<Void>();
		        visitor.visit(tree);
		        
		        song = visitor.getSong();
		        
			} catch (LocatableException e) {
				prgen.syntaxError(null, e.getText(), e.getLine(), e.getCharOffsetInLine(), 
						"Error while generating song: " + e.getMessage(), null);
			}
			if (song != null) {
				LinearSong lsong = null;
				try {
					lsong = new LinearSong(song);
					
				} catch (LocatableException ex) {
					prgen.syntaxError(null, ex.getText(), ex.getLine(), ex.getCharOffsetInLine(), 
							"Error while generating linear song: " + ex.getMessage(), null);
				}
				if (lsong != null) {
					try {
						LinearSongToMidi.getSequence(lsong);
					} catch (LocatableException ex) {
						prgen.syntaxError(null, ex.getText(), ex.getLine(), ex.getCharOffsetInLine(), 
								"Error while generating midi: " + ex.getMessage(), null);
					}
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pres.setException(e);
		}
		return pres;
	}
	


	private int countLines(String str) {
		String[] lines = str.split("\r\n|\r|\n");
		charsInLines = new int[lines.length];
		for (int i = 0; i < lines.length; i++) {
			charsInLines[i] = lines[i].length();
		}
		return lines.length;
	}


	public static class ParseResultGenerator extends BaseErrorListener {
		
		public int[] charsInLines;
		Song4RSTAParseResult pres;
		Parser parser;
		
		
		public ParseResultGenerator(Song4RSTAParseResult pres, Parser parser) {
			super();
			this.pres = pres;
			this.parser = parser;
		}


		@Override
	    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
	                            int line, int charPositionInLine,
	                            String msg, RecognitionException e)
	    {
			
			String sourceName = null;
			if (recognizer == null) {
				sourceName = offendingSymbol.toString();
			} else {
				sourceName = recognizer.getInputStream().getSourceName();
			}

			int length = sourceName == null ? 10 : sourceName.length();
	        int offset = getOffset(line, charPositionInLine);
			DefaultParserNotice pn = new DefaultParserNotice(parser, msg, line-1, offset, length);
			pn.setLevel(ParserNotice.Level.ERROR);
			
			if (DEBUG) {
				System.err.println(sourceName+"line "+line+":"+charPositionInLine+" "+msg);
				System.err.println(offendingSymbol.getClass().getName());
			}
			pres.add(pn);
	    }


		private int getOffset(int line, int charPositionInLine) {
			int offset = 0;
			for (int i = 0; i < line-1; i++) {
				offset += charsInLines[i] + 1;
			}
			return offset;
		}
	}
	
	
	
	@SuppressWarnings("serial")
	public static class Song4RSTAParseResult extends ArrayList<ParserNotice> implements ParseResult {

		Parser parser;
		int lastLineParsed;
		long parseTimeMillis;
		Exception exception;
		

		public Song4RSTAParseResult(Parser parser) {
			super();
			this.parser = parser;
			
		}

		
		public void setException(Exception e) {
			this.exception = e;
			
		}


		@Override
		public void clear() {
			super.clear();
			exception = null;
			lastLineParsed = 0;
			
		}
		
		public void setLastLineParsed(int lastLineParsed) {
			this.lastLineParsed = lastLineParsed;
		}


		public void setParseTimeMillis(long parseTimeMillis) {
			this.parseTimeMillis = parseTimeMillis;
		}


		@Override
		public Exception getError() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getFirstLineParsed() {
			return 0;
		}

		@Override
		public int getLastLineParsed() {
			return lastLineParsed;
		}

		@Override
		public List<ParserNotice> getNotices() {
			return this;
		}

		@Override
		public Parser getParser() {
			
			return parser;
		}

		@Override
		public long getParseTime() {
			return parseTimeMillis;
		}
		
	}

}
