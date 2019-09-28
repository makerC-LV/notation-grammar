import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import shiva.song2.Song2Lexer;
import shiva.song2.Song2Parser;
import shiva.song2.Song2Parser.KeysigContext;
import shiva.song2.Song2Parser.SongContext;
import shiva.song2.Song2Parser.TimesigContext;
import shiva.song2.Song2ParserBaseVisitor;
import shiva.song2.Song2ParserVisitor;

public class Song2Visitor<T> extends Song2ParserBaseVisitor<T> {

	public static void main(String[] args) throws IOException {
//      CharStream input = CharStreams.fromStream(System.in);

  	CharStream input = CharStreams.fromString(new String(Files.readAllBytes( Paths.get("test.song"))));
//  	CharStream input = CharStreams.fromString("c d e");
      Song2Lexer lexer = new Song2Lexer(input);

      CommonTokenStream tokens = new CommonTokenStream(lexer);
      
      // Lexer test
//      tokens.fill();
      
//      System.out.println(tokens.getTokens());
//      for (Token t : tokens.getTokens()) {
//      	System.out.println("'" + t.getText() + "'" + "   " + lexer.getVocabulary().getSymbolicName(t.getType()));
//      }

      // Parser test
      Song2Parser parser = new Song2Parser(tokens);
      Song2ParserVisitor<Void> visitor = new Song2Visitor<Void>();
      visitor.visit(parser.song()); // begin parsing at rule 'song'
      

	}

	@Override
	public T visitSong(SongContext ctx) {
		//System.out.println(ctx);
		return super.visitSong(ctx);
	}

	@Override
	public T visitKeysig(KeysigContext ctx) {
		//System.out.println(ctx);
		return super.visitKeysig(ctx);
	}

	@Override
	public T visitTimesig(TimesigContext ctx) {
		T v = super.visitTimesig(ctx);
		System.out.println(ctx.TIMESIGFRACTION().getText());
		
		return v;
	}

	
	
}
