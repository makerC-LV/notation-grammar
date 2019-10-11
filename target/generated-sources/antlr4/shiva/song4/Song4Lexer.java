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
		TIME=8, VOICE=9, DRUM=10, PLAY=11, MARKTIME=12, RECALLTIME=13, VAR=14, 
		BARMARKER=15, SEMICOLON=16, COLON=17, LPAREN=18, RPAREN=19, SLASH=20, 
		LBRACKET=21, RBRACKET=22, LBRACE=23, RBRACE=24, ASSIGN=25, TIMES=26, PLUS=27, 
		MINUS=28, NUM=29, DIGIT=30, WS=31, COMMENT=32, LINE_COMMENT=33, WORD=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TEMPO", "KEY", "TIME", "VOICE", "DRUM", "PLAY", "MARKTIME", "RECALLTIME", 
			"VAR", "BARMARKER", "SEMICOLON", "COLON", "LPAREN", "RPAREN", "SLASH", 
			"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "ASSIGN", "TIMES", "PLUS", 
			"MINUS", "NUM", "DIGIT", "ALPHABET", "IDCHAR", "WS", "COMMENT", "LINE_COMMENT", 
			"WORD"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'tempo'", "'key'", "'time'", "'voice'", 
			"'drum'", "'play'", "'marktime'", "'recalltime'", null, "'|'", "';'", 
			"':'", "'('", "')'", "'/'", "'['", "']'", "'{'", "'}'", "'='", "'X'", 
			"'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CHORD", "NOTE", "KEYSIG", "INSTRUMENTNAME", "DRUMNAME", "TEMPO", 
			"KEY", "TIME", "VOICE", "DRUM", "PLAY", "MARKTIME", "RECALLTIME", "VAR", 
			"BARMARKER", "SEMICOLON", "COLON", "LPAREN", "RPAREN", "SLASH", "LBRACKET", 
			"RBRACKET", "LBRACE", "RBRACE", "ASSIGN", "TIMES", "PLUS", "MINUS", "NUM", 
			"DIGIT", "WS", "COMMENT", "LINE_COMMENT", "WORD"
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
		case 30:
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
				}

			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00c8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\6"+
		"\nw\n\n\r\n\16\nx\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\6\31\u0098\n\31\r\31\16\31\u0099\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\6\35\u00a3\n\35\r\35\16\35\u00a4\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\7\36\u00ad\n\36\f\36\16\36\u00b0\13\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\7\37\u00bb\n\37\f\37\16\37\u00be\13\37\3\37\3"+
		"\37\3 \6 \u00c3\n \r \16 \u00c4\3 \3 \3\u00ae\2!\3\b\5\t\7\n\t\13\13\f"+
		"\r\r\17\16\21\17\23\20\25\21\27\22\31\23\33\24\35\25\37\26!\27#\30%\31"+
		"\'\32)\33+\34-\35/\36\61\37\63 \65\2\67\29!;\"=#?$\3\2\b\3\2\62;\4\2C"+
		"\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\b\2%%\'\'\62;C\\"+
		"aac|\2\u00cb\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\3A\3\2\2\2\5G\3\2\2\2\7K\3\2\2\2\tP\3\2\2\2\13V\3\2\2\2"+
		"\r[\3\2\2\2\17`\3\2\2\2\21i\3\2\2\2\23t\3\2\2\2\25z\3\2\2\2\27|\3\2\2"+
		"\2\31~\3\2\2\2\33\u0080\3\2\2\2\35\u0082\3\2\2\2\37\u0084\3\2\2\2!\u0086"+
		"\3\2\2\2#\u0088\3\2\2\2%\u008a\3\2\2\2\'\u008c\3\2\2\2)\u008e\3\2\2\2"+
		"+\u0090\3\2\2\2-\u0092\3\2\2\2/\u0094\3\2\2\2\61\u0097\3\2\2\2\63\u009b"+
		"\3\2\2\2\65\u009d\3\2\2\2\67\u009f\3\2\2\29\u00a2\3\2\2\2;\u00a8\3\2\2"+
		"\2=\u00b6\3\2\2\2?\u00c2\3\2\2\2AB\7v\2\2BC\7g\2\2CD\7o\2\2DE\7r\2\2E"+
		"F\7q\2\2F\4\3\2\2\2GH\7m\2\2HI\7g\2\2IJ\7{\2\2J\6\3\2\2\2KL\7v\2\2LM\7"+
		"k\2\2MN\7o\2\2NO\7g\2\2O\b\3\2\2\2PQ\7x\2\2QR\7q\2\2RS\7k\2\2ST\7e\2\2"+
		"TU\7g\2\2U\n\3\2\2\2VW\7f\2\2WX\7t\2\2XY\7w\2\2YZ\7o\2\2Z\f\3\2\2\2[\\"+
		"\7r\2\2\\]\7n\2\2]^\7c\2\2^_\7{\2\2_\16\3\2\2\2`a\7o\2\2ab\7c\2\2bc\7"+
		"t\2\2cd\7m\2\2de\7v\2\2ef\7k\2\2fg\7o\2\2gh\7g\2\2h\20\3\2\2\2ij\7t\2"+
		"\2jk\7g\2\2kl\7e\2\2lm\7c\2\2mn\7n\2\2no\7n\2\2op\7v\2\2pq\7k\2\2qr\7"+
		"o\2\2rs\7g\2\2s\22\3\2\2\2tv\7&\2\2uw\5\67\34\2vu\3\2\2\2wx\3\2\2\2xv"+
		"\3\2\2\2xy\3\2\2\2y\24\3\2\2\2z{\7~\2\2{\26\3\2\2\2|}\7=\2\2}\30\3\2\2"+
		"\2~\177\7<\2\2\177\32\3\2\2\2\u0080\u0081\7*\2\2\u0081\34\3\2\2\2\u0082"+
		"\u0083\7+\2\2\u0083\36\3\2\2\2\u0084\u0085\7\61\2\2\u0085 \3\2\2\2\u0086"+
		"\u0087\7]\2\2\u0087\"\3\2\2\2\u0088\u0089\7_\2\2\u0089$\3\2\2\2\u008a"+
		"\u008b\7}\2\2\u008b&\3\2\2\2\u008c\u008d\7\177\2\2\u008d(\3\2\2\2\u008e"+
		"\u008f\7?\2\2\u008f*\3\2\2\2\u0090\u0091\7Z\2\2\u0091,\3\2\2\2\u0092\u0093"+
		"\7-\2\2\u0093.\3\2\2\2\u0094\u0095\7/\2\2\u0095\60\3\2\2\2\u0096\u0098"+
		"\5\63\32\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\62\3\2\2\2\u009b\u009c\t\2\2\2\u009c\64\3\2"+
		"\2\2\u009d\u009e\t\3\2\2\u009e\66\3\2\2\2\u009f\u00a0\t\4\2\2\u00a08\3"+
		"\2\2\2\u00a1\u00a3\t\5\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\b\35"+
		"\2\2\u00a7:\3\2\2\2\u00a8\u00a9\7\61\2\2\u00a9\u00aa\7,\2\2\u00aa\u00ae"+
		"\3\2\2\2\u00ab\u00ad\13\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2"+
		"\u00ae\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b1\u00b2\7,\2\2\u00b2\u00b3\7\61\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\b\36\2\2\u00b5<\3\2\2\2\u00b6\u00b7\7\61\2\2\u00b7\u00b8\7\61\2"+
		"\2\u00b8\u00bc\3\2\2\2\u00b9\u00bb\n\6\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c0\b\37\2\2\u00c0>\3\2\2\2\u00c1\u00c3\t\7\2\2"+
		"\u00c2\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5"+
		"\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\b \3\2\u00c7@\3\2\2\2\t\2x\u0099"+
		"\u00a4\u00ae\u00bc\u00c4\4\b\2\2\3 \2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}