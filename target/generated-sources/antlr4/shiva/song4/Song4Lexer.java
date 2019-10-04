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
		KEYSIG=1, CHORD=2, NOTE=3, TEMPOMARKER=4, KEYMARKER=5, TIMEMARKER=6, VOICEVAR=7, 
		PHRASETEMPLATEVAR=8, TIMEVAR=9, TIMINGMARKER=10, INSTRUMENTNAME=11, NUM=12, 
		DIGIT=13, BARMARKER=14, SEMICOLON=15, COLON=16, LPAREN=17, RPAREN=18, 
		SLASH=19, LBRACKET=20, RBRACKET=21, LBRACE=22, RBRACE=23, ASSIGN=24, WS=25, 
		COMMENT=26, LINE_COMMENT=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"KEYSIG", "CHORD", "NOTE", "TEMPOMARKER", "KEYMARKER", "TIMEMARKER", 
			"VOICEVAR", "PHRASETEMPLATEVAR", "TIMEVAR", "TIMINGMARKER", "INSTRUMENTNAME", 
			"NUM", "DIGIT", "ALPHABET", "IDCHAR", "BARMARKER", "SEMICOLON", "COLON", 
			"LPAREN", "RPAREN", "SLASH", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", 
			"ASSIGN", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'tempo'", "'key'", "'time'", null, null, null, 
			"'S'", null, null, null, "'|'", "';'", "':'", "'('", "')'", "'/'", "'['", 
			"']'", "'{'", "'}'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "KEYSIG", "CHORD", "NOTE", "TEMPOMARKER", "KEYMARKER", "TIMEMARKER", 
			"VOICEVAR", "PHRASETEMPLATEVAR", "TIMEVAR", "TIMINGMARKER", "INSTRUMENTNAME", 
			"NUM", "DIGIT", "BARMARKER", "SEMICOLON", "COLON", "LPAREN", "RPAREN", 
			"SLASH", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "ASSIGN", "WS", 
			"COMMENT", "LINE_COMMENT"
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


	  public static final LexerLookup LOOKUP = LexerLookup.INSTANCE;


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
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return KEYSIG_sempred((RuleContext)_localctx, predIndex);
		case 1:
			return CHORD_sempred((RuleContext)_localctx, predIndex);
		case 2:
			return NOTE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean KEYSIG_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return LOOKUP.contains(KEYSIG, _input);
		}
		return true;
	}
	private boolean CHORD_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return LOOKUP.contains(CHORD, _input);
		}
		return true;
	}
	private boolean NOTE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return LOOKUP.contains(NOTE, _input);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00b1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\6\bX\n\b\r\b\16\bY\3\t\3\t\6\t^\n\t\r\t\16\t_\3\n"+
		"\3\n\6\nd\n\n\r\n\16\ne\3\13\3\13\3\f\3\f\7\fl\n\f\f\f\16\fo\13\f\3\r"+
		"\6\rr\n\r\r\r\16\rs\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\6\34\u0093\n\34\r\34\16\34\u0094\3\34\3\34\3"+
		"\35\3\35\3\35\3\35\7\35\u009d\n\35\f\35\16\35\u00a0\13\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00ab\n\36\f\36\16\36\u00ae\13"+
		"\36\3\36\3\36\3\u009e\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\2\37\2!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63"+
		"\31\65\32\67\339\34;\35\3\2\7\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f"+
		"\17\17\"\"\4\2\f\f\17\17\2\u00b6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2!\3\2\2\2\2"+
		"#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3"+
		"\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\3=\3\2\2\2\5@\3\2\2\2\7C\3\2\2\2\tF\3\2\2\2\13L\3\2\2\2\r"+
		"P\3\2\2\2\17U\3\2\2\2\21[\3\2\2\2\23a\3\2\2\2\25g\3\2\2\2\27i\3\2\2\2"+
		"\31q\3\2\2\2\33u\3\2\2\2\35w\3\2\2\2\37y\3\2\2\2!{\3\2\2\2#}\3\2\2\2%"+
		"\177\3\2\2\2\'\u0081\3\2\2\2)\u0083\3\2\2\2+\u0085\3\2\2\2-\u0087\3\2"+
		"\2\2/\u0089\3\2\2\2\61\u008b\3\2\2\2\63\u008d\3\2\2\2\65\u008f\3\2\2\2"+
		"\67\u0092\3\2\2\29\u0098\3\2\2\2;\u00a6\3\2\2\2=>\6\2\2\2>?\13\2\2\2?"+
		"\4\3\2\2\2@A\6\3\3\2AB\13\2\2\2B\6\3\2\2\2CD\6\4\4\2DE\13\2\2\2E\b\3\2"+
		"\2\2FG\7v\2\2GH\7g\2\2HI\7o\2\2IJ\7r\2\2JK\7q\2\2K\n\3\2\2\2LM\7m\2\2"+
		"MN\7g\2\2NO\7{\2\2O\f\3\2\2\2PQ\7v\2\2QR\7k\2\2RS\7o\2\2ST\7g\2\2T\16"+
		"\3\2\2\2UW\7X\2\2VX\5\37\20\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2"+
		"Z\20\3\2\2\2[]\7R\2\2\\^\5\37\20\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`\22\3\2\2\2ac\7V\2\2bd\5\37\20\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2"+
		"ef\3\2\2\2f\24\3\2\2\2gh\7U\2\2h\26\3\2\2\2im\5\35\17\2jl\5\37\20\2kj"+
		"\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\30\3\2\2\2om\3\2\2\2pr\5\33\16"+
		"\2qp\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2t\32\3\2\2\2uv\t\2\2\2v\34\3"+
		"\2\2\2wx\t\3\2\2x\36\3\2\2\2yz\t\4\2\2z \3\2\2\2{|\7~\2\2|\"\3\2\2\2}"+
		"~\7=\2\2~$\3\2\2\2\177\u0080\7<\2\2\u0080&\3\2\2\2\u0081\u0082\7*\2\2"+
		"\u0082(\3\2\2\2\u0083\u0084\7+\2\2\u0084*\3\2\2\2\u0085\u0086\7\61\2\2"+
		"\u0086,\3\2\2\2\u0087\u0088\7]\2\2\u0088.\3\2\2\2\u0089\u008a\7_\2\2\u008a"+
		"\60\3\2\2\2\u008b\u008c\7}\2\2\u008c\62\3\2\2\2\u008d\u008e\7\177\2\2"+
		"\u008e\64\3\2\2\2\u008f\u0090\7?\2\2\u0090\66\3\2\2\2\u0091\u0093\t\5"+
		"\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\b\34\2\2\u00978\3\2\2\2"+
		"\u0098\u0099\7\61\2\2\u0099\u009a\7,\2\2\u009a\u009e\3\2\2\2\u009b\u009d"+
		"\13\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009f\3\2\2\2"+
		"\u009e\u009c\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2"+
		"\7,\2\2\u00a2\u00a3\7\61\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\b\35\2\2"+
		"\u00a5:\3\2\2\2\u00a6\u00a7\7\61\2\2\u00a7\u00a8\7\61\2\2\u00a8\u00ac"+
		"\3\2\2\2\u00a9\u00ab\n\6\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00af\u00b0\b\36\2\2\u00b0<\3\2\2\2\13\2Y_ems\u0094\u009e\u00ac\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}