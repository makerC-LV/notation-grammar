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
		RBRACKET=9, ASSIGN=10, KEYMARKER=11, TIMEMARKER=12, KEYCHORD=13, RHYTHM=14, 
		NOTE=15, OCTAVE=16, DURATION=17, VARNOTE=18, INSTRUMENT=19, RINSTRUMENT=20;
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
			"TIMEMARKER", "KEYCHORD", "RHYTHM", "NOTE", "OCTAVE", "DURATION", "VARNOTE", 
			"NUM", "INSTRUMENT", "RINSTRUMENT"
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
			"RHYTHM", "NOTE", "OCTAVE", "DURATION", "VARNOTE", "INSTRUMENT", "RINSTRUMENT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00ae\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\6\2\65\n\2\r\2\16\2\66\3\3\6\3:\n\3\r\3\16\3;\3\3\3\3\3\4\3"+
		"\4\6\4B\n\4\r\4\16\4C\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16^\n\16\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\5\21l\n\21"+
		"\3\21\5\21o\n\21\3\21\3\21\3\22\3\22\3\23\3\23\5\23w\n\23\3\23\5\23z\n"+
		"\23\3\23\5\23}\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u0084\n\24\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0091\n\26\3\27\6\27"+
		"\u0094\n\27\r\27\16\27\u0095\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\5\30\u00a2\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u00ad\n\31\2\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\2\31\2\33\2\35\r\37\16!\17#\20%\21\'\22)\23+\24-\2/\25\61\26\3\2\t"+
		"\3\2\62;\5\2\13\f\17\17\"\"\7\2//\62;C\\aac|\4\2CIci\4\2%%dd\4\2aaqq\6"+
		"\2jjssuvyy\2\u00b9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\64\3\2\2\2\59\3\2"+
		"\2\2\7?\3\2\2\2\tE\3\2\2\2\13G\3\2\2\2\rI\3\2\2\2\17K\3\2\2\2\21M\3\2"+
		"\2\2\23O\3\2\2\2\25Q\3\2\2\2\27S\3\2\2\2\31U\3\2\2\2\33]\3\2\2\2\35_\3"+
		"\2\2\2\37c\3\2\2\2!h\3\2\2\2#r\3\2\2\2%t\3\2\2\2\'\u0083\3\2\2\2)\u0085"+
		"\3\2\2\2+\u0090\3\2\2\2-\u0093\3\2\2\2/\u00a1\3\2\2\2\61\u00ac\3\2\2\2"+
		"\63\65\t\2\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2"+
		"\67\4\3\2\2\28:\t\3\2\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<=\3\2"+
		"\2\2=>\b\3\2\2>\6\3\2\2\2?A\7a\2\2@B\t\4\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2"+
		"\2\2CD\3\2\2\2D\b\3\2\2\2EF\7=\2\2F\n\3\2\2\2GH\7*\2\2H\f\3\2\2\2IJ\7"+
		"+\2\2J\16\3\2\2\2KL\7\61\2\2L\20\3\2\2\2MN\7]\2\2N\22\3\2\2\2OP\7_\2\2"+
		"P\24\3\2\2\2QR\7?\2\2R\26\3\2\2\2ST\t\5\2\2T\30\3\2\2\2UV\t\6\2\2V\32"+
		"\3\2\2\2WX\7o\2\2XY\7c\2\2Y^\7l\2\2Z[\7o\2\2[\\\7k\2\2\\^\7p\2\2]W\3\2"+
		"\2\2]Z\3\2\2\2^\34\3\2\2\2_`\7m\2\2`a\7g\2\2ab\7{\2\2b\36\3\2\2\2cd\7"+
		"v\2\2de\7k\2\2ef\7o\2\2fg\7g\2\2g \3\2\2\2hi\5\21\t\2ik\5\27\f\2jl\5\31"+
		"\r\2kj\3\2\2\2kl\3\2\2\2ln\3\2\2\2mo\5\33\16\2nm\3\2\2\2no\3\2\2\2op\3"+
		"\2\2\2pq\5\23\n\2q\"\3\2\2\2rs\t\7\2\2s$\3\2\2\2tv\5\27\f\2uw\5\'\24\2"+
		"vu\3\2\2\2vw\3\2\2\2wy\3\2\2\2xz\5\31\r\2yx\3\2\2\2yz\3\2\2\2z|\3\2\2"+
		"\2{}\5)\25\2|{\3\2\2\2|}\3\2\2\2}&\3\2\2\2~\177\7\63\2\2\177\u0084\7\63"+
		"\2\2\u0080\u0081\7\63\2\2\u0081\u0084\7\62\2\2\u0082\u0084\t\2\2\2\u0083"+
		"~\3\2\2\2\u0083\u0080\3\2\2\2\u0083\u0082\3\2\2\2\u0084(\3\2\2\2\u0085"+
		"\u0086\t\b\2\2\u0086*\3\2\2\2\u0087\u0088\5\7\4\2\u0088\u0089\7-\2\2\u0089"+
		"\u008a\5-\27\2\u008a\u0091\3\2\2\2\u008b\u008c\5\7\4\2\u008c\u008d\7/"+
		"\2\2\u008d\u008e\5-\27\2\u008e\u0091\3\2\2\2\u008f\u0091\5\7\4\2\u0090"+
		"\u0087\3\2\2\2\u0090\u008b\3\2\2\2\u0090\u008f\3\2\2\2\u0091,\3\2\2\2"+
		"\u0092\u0094\5\3\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096.\3\2\2\2\u0097\u0098\7R\2\2\u0098\u0099"+
		"\7k\2\2\u0099\u009a\7c\2\2\u009a\u009b\7p\2\2\u009b\u00a2\7q\2\2\u009c"+
		"\u009d\7H\2\2\u009d\u009e\7n\2\2\u009e\u009f\7w\2\2\u009f\u00a0\7v\2\2"+
		"\u00a0\u00a2\7g\2\2\u00a1\u0097\3\2\2\2\u00a1\u009c\3\2\2\2\u00a2\60\3"+
		"\2\2\2\u00a3\u00a4\7D\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7u\2\2\u00a6"+
		"\u00ad\7u\2\2\u00a7\u00a8\7U\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7c\2\2"+
		"\u00aa\u00ab\7t\2\2\u00ab\u00ad\7g\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00a7"+
		"\3\2\2\2\u00ad\62\3\2\2\2\21\2\66;C]knvy|\u0083\u0090\u0095\u00a1\u00ac"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}