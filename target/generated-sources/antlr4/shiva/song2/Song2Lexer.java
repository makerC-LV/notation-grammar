// Generated from Song2Lexer.g4 by ANTLR 4.7.2

    package shiva.song2;
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
public class Song2Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DIGIT=1, WS=2, VARNAME=3, SEMICOLON=4, LPAREN=5, RPAREN=6, SLASH=7, LBRACKET=8, 
		RBRACKET=9, ASSIGN=10, KEYMARKER=11, TIMEMARKER=12, KEYCHORD=13, TIMENUMERATOR=14, 
		TIMEDENOMINATOR=15, RHYTHM=16, NOTE=17, OCTAVE=18, DURATION=19, VARNOTE=20, 
		INSTRUMENT=21, RINSTRUMENT=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DIGIT", "WS", "VARNAME", "SEMICOLON", "LPAREN", "RPAREN", "SLASH", "LBRACKET", 
			"RBRACKET", "ASSIGN", "BASENOTE", "NOTEMODIFIER", "SCALE", "KEYMARKER", 
			"TIMEMARKER", "KEYCHORD", "TIMENUMERATOR", "TIMEDENOMINATOR", "RHYTHM", 
			"NOTE", "OCTAVE", "DURATION", "VARNOTE", "NUM", "INSTRUMENT", "RINSTRUMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "';'", "'('", "')'", "'/'", "'['", "']'", "'='", 
			"'key'", "'time'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DIGIT", "WS", "VARNAME", "SEMICOLON", "LPAREN", "RPAREN", "SLASH", 
			"LBRACKET", "RBRACKET", "ASSIGN", "KEYMARKER", "TIMEMARKER", "KEYCHORD", 
			"TIMENUMERATOR", "TIMEDENOMINATOR", "RHYTHM", "NOTE", "OCTAVE", "DURATION", 
			"VARNOTE", "INSTRUMENT", "RINSTRUMENT"
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


	public Song2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Song2Lexer.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00b6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\6\29\n\2\r\2\16\2:\3\3\6\3>\n\3\r\3\16\3"+
		"?\3\3\3\3\3\4\3\4\6\4F\n\4\r\4\16\4G\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16b\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\5\21p\n\21\3\21\5\21s\n\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\5\25\177\n\25\3\25\5\25\u0082\n\25\3\25\5\25\u0085\n\25\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u008c\n\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u0099\n\30\3\31\6\31\u009c\n\31\r\31\16\31\u009d"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00aa\n\32\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00b5\n\33\2\2\34\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\2\33\2\35\r\37\16!\17"+
		"#\20%\21\'\22)\23+\24-\25/\26\61\2\63\27\65\30\3\2\t\3\2\62;\5\2\13\f"+
		"\17\17\"\"\7\2//\62;C\\aac|\4\2CIci\4\2%%dd\4\2aaqq\6\2jjssuvyy\2\u00c1"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\38\3\2\2\2"+
		"\5=\3\2\2\2\7C\3\2\2\2\tI\3\2\2\2\13K\3\2\2\2\rM\3\2\2\2\17O\3\2\2\2\21"+
		"Q\3\2\2\2\23S\3\2\2\2\25U\3\2\2\2\27W\3\2\2\2\31Y\3\2\2\2\33a\3\2\2\2"+
		"\35c\3\2\2\2\37g\3\2\2\2!l\3\2\2\2#v\3\2\2\2%x\3\2\2\2\'z\3\2\2\2)|\3"+
		"\2\2\2+\u008b\3\2\2\2-\u008d\3\2\2\2/\u0098\3\2\2\2\61\u009b\3\2\2\2\63"+
		"\u00a9\3\2\2\2\65\u00b4\3\2\2\2\679\t\2\2\28\67\3\2\2\29:\3\2\2\2:8\3"+
		"\2\2\2:;\3\2\2\2;\4\3\2\2\2<>\t\3\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@"+
		"\3\2\2\2@A\3\2\2\2AB\b\3\2\2B\6\3\2\2\2CE\7a\2\2DF\t\4\2\2ED\3\2\2\2F"+
		"G\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\b\3\2\2\2IJ\7=\2\2J\n\3\2\2\2KL\7*\2\2"+
		"L\f\3\2\2\2MN\7+\2\2N\16\3\2\2\2OP\7\61\2\2P\20\3\2\2\2QR\7]\2\2R\22\3"+
		"\2\2\2ST\7_\2\2T\24\3\2\2\2UV\7?\2\2V\26\3\2\2\2WX\t\5\2\2X\30\3\2\2\2"+
		"YZ\t\6\2\2Z\32\3\2\2\2[\\\7o\2\2\\]\7c\2\2]b\7l\2\2^_\7o\2\2_`\7k\2\2"+
		"`b\7p\2\2a[\3\2\2\2a^\3\2\2\2b\34\3\2\2\2cd\7m\2\2de\7g\2\2ef\7{\2\2f"+
		"\36\3\2\2\2gh\7v\2\2hi\7k\2\2ij\7o\2\2jk\7g\2\2k \3\2\2\2lm\5\21\t\2m"+
		"o\5\27\f\2np\5\31\r\2on\3\2\2\2op\3\2\2\2pr\3\2\2\2qs\5\33\16\2rq\3\2"+
		"\2\2rs\3\2\2\2st\3\2\2\2tu\5\23\n\2u\"\3\2\2\2vw\5\3\2\2w$\3\2\2\2xy\5"+
		"\3\2\2y&\3\2\2\2z{\t\7\2\2{(\3\2\2\2|~\5\27\f\2}\177\5+\26\2~}\3\2\2\2"+
		"~\177\3\2\2\2\177\u0081\3\2\2\2\u0080\u0082\5\31\r\2\u0081\u0080\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0085\5-\27\2\u0084\u0083"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085*\3\2\2\2\u0086\u0087\7\63\2\2\u0087"+
		"\u008c\7\63\2\2\u0088\u0089\7\63\2\2\u0089\u008c\7\62\2\2\u008a\u008c"+
		"\t\2\2\2\u008b\u0086\3\2\2\2\u008b\u0088\3\2\2\2\u008b\u008a\3\2\2\2\u008c"+
		",\3\2\2\2\u008d\u008e\t\b\2\2\u008e.\3\2\2\2\u008f\u0090\5\7\4\2\u0090"+
		"\u0091\7-\2\2\u0091\u0092\5\61\31\2\u0092\u0099\3\2\2\2\u0093\u0094\5"+
		"\7\4\2\u0094\u0095\7/\2\2\u0095\u0096\5\61\31\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0099\5\7\4\2\u0098\u008f\3\2\2\2\u0098\u0093\3\2\2\2\u0098\u0097\3\2"+
		"\2\2\u0099\60\3\2\2\2\u009a\u009c\5\3\2\2\u009b\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\62\3\2\2\2\u009f"+
		"\u00a0\7R\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3\7p\2\2"+
		"\u00a3\u00aa\7q\2\2\u00a4\u00a5\7H\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7"+
		"\7w\2\2\u00a7\u00a8\7v\2\2\u00a8\u00aa\7g\2\2\u00a9\u009f\3\2\2\2\u00a9"+
		"\u00a4\3\2\2\2\u00aa\64\3\2\2\2\u00ab\u00ac\7D\2\2\u00ac\u00ad\7c\2\2"+
		"\u00ad\u00ae\7u\2\2\u00ae\u00b5\7u\2\2\u00af\u00b0\7U\2\2\u00b0\u00b1"+
		"\7p\2\2\u00b1\u00b2\7c\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b5\7g\2\2\u00b4"+
		"\u00ab\3\2\2\2\u00b4\u00af\3\2\2\2\u00b5\66\3\2\2\2\21\2:?Gaor~\u0081"+
		"\u0084\u008b\u0098\u009d\u00a9\u00b4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}