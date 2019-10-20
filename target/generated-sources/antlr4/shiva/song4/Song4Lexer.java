// Generated from Song4Lexer.g4 by ANTLR 4.7.2

    package shiva.song4;
    import java.util.HashMap;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Song4Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CHORD=1, NOTE=2, KEYSIG=3, INSTRUMENTNAME=4, DRUMNAME=5, TEMPO=6, KEY=7, 
		TIME=8, VOICE=9, DRUM=10, MARKTIME=11, RECALLTIME=12, VAR=13, ACCENT=14, 
		DYNAMICS=15, MULTILINE_COMMENT=16, STARTCOMMENT=17, ENDCOMMENT=18, BARMARKER=19, 
		SEMICOLON=20, COLON=21, LPAREN=22, RPAREN=23, SLASH=24, LBRACKET=25, RBRACKET=26, 
		LBRACE=27, RBRACE=28, ASSIGN=29, TIMES=30, PLUS=31, MINUS=32, CARET=33, 
		NUM=34, DIGIT=35, WS=36, LINE_COMMENT=37, WORD=38, UNMATCHED=39;
	public static final int
		ERROR=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN", "ERROR"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TEMPO", "KEY", "TIME", "VOICE", "DRUM", "MARKTIME", "RECALLTIME", "VAR", 
			"ACCENT", "DYNAMICS", "MULTILINE_COMMENT", "STARTCOMMENT", "ENDCOMMENT", 
			"BARMARKER", "SEMICOLON", "COLON", "LPAREN", "RPAREN", "SLASH", "LBRACKET", 
			"RBRACKET", "LBRACE", "RBRACE", "ASSIGN", "TIMES", "PLUS", "MINUS", "CARET", 
			"NUM", "DIGIT", "ALPHABET", "IDCHAR", "WS", "LINE_COMMENT", "WORD", "UNMATCHED"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'tempo'", "'key'", "'time'", "'voice'", 
			"'drum'", "'marktime'", "'recalltime'", null, null, null, null, "'/*'", 
			"'*/'", "'|'", "';'", "':'", "'('", "')'", "'/'", "'['", "']'", "'{'", 
			"'}'", "'='", "'X'", "'+'", "'-'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CHORD", "NOTE", "KEYSIG", "INSTRUMENTNAME", "DRUMNAME", "TEMPO", 
			"KEY", "TIME", "VOICE", "DRUM", "MARKTIME", "RECALLTIME", "VAR", "ACCENT", 
			"DYNAMICS", "MULTILINE_COMMENT", "STARTCOMMENT", "ENDCOMMENT", "BARMARKER", 
			"SEMICOLON", "COLON", "LPAREN", "RPAREN", "SLASH", "LBRACKET", "RBRACKET", 
			"LBRACE", "RBRACE", "ASSIGN", "TIMES", "PLUS", "MINUS", "CARET", "NUM", 
			"DIGIT", "WS", "LINE_COMMENT", "WORD", "UNMATCHED"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	  //public static final LexerLookup LOOKUP = LexerLookup.INSTANCE;
	  


	public Song4Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Song4Lexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 34:
			WORD_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WORD_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 
				Song4SpecialTokenParser.SpecialToken token = Song4SpecialTokenParser.getSpecialToken(getText());
				if ( token != null) {
					setType(token.tokenId);
				} else {
					setType(Song4Lexer.UNMATCHED);
				}

			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u00ed\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\6\t|\n\t\r\t\16\t}\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0093\n\13"+
		"\3\f\3\f\7\f\u0097\n\f\f\f\16\f\u009a\13\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\6\36\u00c9\n\36\r\36"+
		"\16\36\u00ca\3\37\3\37\3 \3 \3!\3!\3\"\6\"\u00d4\n\"\r\"\16\"\u00d5\3"+
		"\"\3\"\3#\3#\3#\3#\7#\u00de\n#\f#\16#\u00e1\13#\3#\3#\3$\6$\u00e6\n$\r"+
		"$\16$\u00e7\3$\3$\3%\3%\3\u0098\2&\3\b\5\t\7\n\t\13\13\f\r\r\17\16\21"+
		"\17\23\20\25\21\27\22\31\23\33\24\35\25\37\26!\27#\30%\31\'\32)\33+\34"+
		"-\35/\36\61\37\63 \65!\67\"9#;$=%?\2A\2C&E\'G(I)\3\2\b\3\2\62;\4\2C\\"+
		"c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\b\2%%\'\'\62;C\\aa"+
		"c|\2\u00f7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\3K\3\2\2\2\5Q\3\2\2\2\7U\3\2\2\2\tZ\3\2\2\2\13`\3\2\2\2\re\3\2\2\2\17"+
		"n\3\2\2\2\21y\3\2\2\2\23\177\3\2\2\2\25\u0081\3\2\2\2\27\u0094\3\2\2\2"+
		"\31\u009f\3\2\2\2\33\u00a4\3\2\2\2\35\u00a9\3\2\2\2\37\u00ab\3\2\2\2!"+
		"\u00ad\3\2\2\2#\u00af\3\2\2\2%\u00b1\3\2\2\2\'\u00b3\3\2\2\2)\u00b5\3"+
		"\2\2\2+\u00b7\3\2\2\2-\u00b9\3\2\2\2/\u00bb\3\2\2\2\61\u00bd\3\2\2\2\63"+
		"\u00bf\3\2\2\2\65\u00c1\3\2\2\2\67\u00c3\3\2\2\29\u00c5\3\2\2\2;\u00c8"+
		"\3\2\2\2=\u00cc\3\2\2\2?\u00ce\3\2\2\2A\u00d0\3\2\2\2C\u00d3\3\2\2\2E"+
		"\u00d9\3\2\2\2G\u00e5\3\2\2\2I\u00eb\3\2\2\2KL\7v\2\2LM\7g\2\2MN\7o\2"+
		"\2NO\7r\2\2OP\7q\2\2P\4\3\2\2\2QR\7m\2\2RS\7g\2\2ST\7{\2\2T\6\3\2\2\2"+
		"UV\7v\2\2VW\7k\2\2WX\7o\2\2XY\7g\2\2Y\b\3\2\2\2Z[\7x\2\2[\\\7q\2\2\\]"+
		"\7k\2\2]^\7e\2\2^_\7g\2\2_\n\3\2\2\2`a\7f\2\2ab\7t\2\2bc\7w\2\2cd\7o\2"+
		"\2d\f\3\2\2\2ef\7o\2\2fg\7c\2\2gh\7t\2\2hi\7m\2\2ij\7v\2\2jk\7k\2\2kl"+
		"\7o\2\2lm\7g\2\2m\16\3\2\2\2no\7t\2\2op\7g\2\2pq\7e\2\2qr\7c\2\2rs\7n"+
		"\2\2st\7n\2\2tu\7v\2\2uv\7k\2\2vw\7o\2\2wx\7g\2\2x\20\3\2\2\2y{\7&\2\2"+
		"z|\5A!\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\22\3\2\2\2\177\u0080"+
		"\59\35\2\u0080\24\3\2\2\2\u0081\u0092\5!\21\2\u0082\u0083\7h\2\2\u0083"+
		"\u0084\7h\2\2\u0084\u0093\7h\2\2\u0085\u0086\7h\2\2\u0086\u0093\7h\2\2"+
		"\u0087\u0093\7h\2\2\u0088\u0089\7o\2\2\u0089\u0093\7h\2\2\u008a\u008b"+
		"\7r\2\2\u008b\u0093\7h\2\2\u008c\u008d\7r\2\2\u008d\u008e\7r\2\2\u008e"+
		"\u0093\7r\2\2\u008f\u0090\7r\2\2\u0090\u0093\7r\2\2\u0091\u0093\7r\2\2"+
		"\u0092\u0082\3\2\2\2\u0092\u0085\3\2\2\2\u0092\u0087\3\2\2\2\u0092\u0088"+
		"\3\2\2\2\u0092\u008a\3\2\2\2\u0092\u008c\3\2\2\2\u0092\u008f\3\2\2\2\u0092"+
		"\u0091\3\2\2\2\u0093\26\3\2\2\2\u0094\u0098\5\31\r\2\u0095\u0097\13\2"+
		"\2\2\u0096\u0095\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0099\3\2\2\2\u0098"+
		"\u0096\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\5\33"+
		"\16\2\u009c\u009d\3\2\2\2\u009d\u009e\b\f\2\2\u009e\30\3\2\2\2\u009f\u00a0"+
		"\7\61\2\2\u00a0\u00a1\7,\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\r\2\2\u00a3"+
		"\32\3\2\2\2\u00a4\u00a5\7,\2\2\u00a5\u00a6\7\61\2\2\u00a6\u00a7\3\2\2"+
		"\2\u00a7\u00a8\b\16\2\2\u00a8\34\3\2\2\2\u00a9\u00aa\7~\2\2\u00aa\36\3"+
		"\2\2\2\u00ab\u00ac\7=\2\2\u00ac \3\2\2\2\u00ad\u00ae\7<\2\2\u00ae\"\3"+
		"\2\2\2\u00af\u00b0\7*\2\2\u00b0$\3\2\2\2\u00b1\u00b2\7+\2\2\u00b2&\3\2"+
		"\2\2\u00b3\u00b4\7\61\2\2\u00b4(\3\2\2\2\u00b5\u00b6\7]\2\2\u00b6*\3\2"+
		"\2\2\u00b7\u00b8\7_\2\2\u00b8,\3\2\2\2\u00b9\u00ba\7}\2\2\u00ba.\3\2\2"+
		"\2\u00bb\u00bc\7\177\2\2\u00bc\60\3\2\2\2\u00bd\u00be\7?\2\2\u00be\62"+
		"\3\2\2\2\u00bf\u00c0\7Z\2\2\u00c0\64\3\2\2\2\u00c1\u00c2\7-\2\2\u00c2"+
		"\66\3\2\2\2\u00c3\u00c4\7/\2\2\u00c48\3\2\2\2\u00c5\u00c6\7`\2\2\u00c6"+
		":\3\2\2\2\u00c7\u00c9\5=\37\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2"+
		"\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb<\3\2\2\2\u00cc\u00cd\t"+
		"\2\2\2\u00cd>\3\2\2\2\u00ce\u00cf\t\3\2\2\u00cf@\3\2\2\2\u00d0\u00d1\t"+
		"\4\2\2\u00d1B\3\2\2\2\u00d2\u00d4\t\5\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5"+
		"\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7"+
		"\u00d8\b\"\2\2\u00d8D\3\2\2\2\u00d9\u00da\7\61\2\2\u00da\u00db\7\61\2"+
		"\2\u00db\u00df\3\2\2\2\u00dc\u00de\n\6\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1"+
		"\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1"+
		"\u00df\3\2\2\2\u00e2\u00e3\b#\2\2\u00e3F\3\2\2\2\u00e4\u00e6\t\7\2\2\u00e5"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\b$\3\2\u00eaH\3\2\2\2\u00eb\u00ec"+
		"\13\2\2\2\u00ecJ\3\2\2\2\n\2}\u0092\u0098\u00ca\u00d5\u00df\u00e7\4\2"+
		"\3\2\3$\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}