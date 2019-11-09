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
		ANTIACCENT=15, DYNAMICS=16, BEAT=17, ACCENTED_BEAT=18, FLAM=19, MULTILINE_COMMENT=20, 
		STARTCOMMENT=21, ENDCOMMENT=22, SCRIPT=23, STARTSCRIPT=24, ENDSCRIPT=25, 
		BARMARKER=26, TILDE=27, SEMICOLON=28, COLON=29, LPAREN=30, RPAREN=31, 
		SLASH=32, LBRACKET=33, RBRACKET=34, LBRACE=35, RBRACE=36, ASSIGN=37, TIMES=38, 
		PLUS=39, MINUS=40, CARET=41, EXCLAMATION=42, ASTERISK=43, NUM=44, DIGIT=45, 
		WS=46, LINE_COMMENT=47, WORD=48, UNMATCHED=49;
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
			"ACCENT", "ANTIACCENT", "DYNAMICS", "BEAT", "ACCENTED_BEAT", "FLAM", 
			"MULTILINE_COMMENT", "STARTCOMMENT", "ENDCOMMENT", "SCRIPT", "STARTSCRIPT", 
			"ENDSCRIPT", "BARMARKER", "TILDE", "SEMICOLON", "COLON", "LPAREN", "RPAREN", 
			"SLASH", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "ASSIGN", "TIMES", 
			"PLUS", "MINUS", "CARET", "EXCLAMATION", "ASTERISK", "NUM", "DIGIT", 
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "ALPHABET", 
			"IDCHAR", "WS", "LINE_COMMENT", "WORD", "UNMATCHED"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "'/*'", "'*/'", 
			null, null, null, "'|'", "'~'", "';'", "':'", "'('", "')'", "'/'", "'['", 
			"']'", "'{'", "'}'", "'='", "'X'", "'+'", "'-'", "'^'", "'!'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CHORD", "NOTE", "KEYSIG", "INSTRUMENTNAME", "DRUMNAME", "TEMPO", 
			"KEY", "TIME", "VOICE", "DRUM", "MARKTIME", "RECALLTIME", "VAR", "ACCENT", 
			"ANTIACCENT", "DYNAMICS", "BEAT", "ACCENTED_BEAT", "FLAM", "MULTILINE_COMMENT", 
			"STARTCOMMENT", "ENDCOMMENT", "SCRIPT", "STARTSCRIPT", "ENDSCRIPT", "BARMARKER", 
			"TILDE", "SEMICOLON", "COLON", "LPAREN", "RPAREN", "SLASH", "LBRACKET", 
			"RBRACKET", "LBRACE", "RBRACE", "ASSIGN", "TIMES", "PLUS", "MINUS", "CARET", 
			"EXCLAMATION", "ASTERISK", "NUM", "DIGIT", "WS", "LINE_COMMENT", "WORD", 
			"UNMATCHED"
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
		case 70:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u017e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\6\t\u00bc\n\t\r\t\16\t\u00bd\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u00d5\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20\u00df\n\20\f\20"+
		"\16\20\u00e2\13\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\7\23\u00f4\n\23\f\23\16\23\u00f7\13\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3"+
		" \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\6(\u0126\n(\r(\16"+
		"(\u0127\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39"+
		"\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D"+
		"\3E\3E\3F\6F\u0165\nF\rF\16F\u0166\3F\3F\3G\3G\3G\3G\7G\u016f\nG\fG\16"+
		"G\u0172\13G\3G\3G\3H\6H\u0177\nH\rH\16H\u0178\3H\3H\3I\3I\4\u00e0\u00f5"+
		"\2J\3\b\5\t\7\n\t\13\13\f\r\r\17\16\21\17\23\20\25\21\27\22\31\23\33\24"+
		"\35\25\37\26!\27#\30%\31\'\32)\33+\34-\35/\36\61\37\63 \65!\67\"9#;$="+
		"%?&A\'C(E)G*I+K,M-O.Q/S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2"+
		"s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b"+
		"\60\u008d\61\u008f\62\u0091\63\3\2\"\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4"+
		"\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNn"+
		"n\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2"+
		"WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\4\2C\\c|\6\2\62;C\\aac"+
		"|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\b\2%%\'\'\62;C\\aac|\2\u016f\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2\u008b\3\2\2\2\2"+
		"\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\3\u0093\3\2\2\2\5\u0099"+
		"\3\2\2\2\7\u009d\3\2\2\2\t\u00a2\3\2\2\2\13\u00a8\3\2\2\2\r\u00ad\3\2"+
		"\2\2\17\u00b2\3\2\2\2\21\u00b9\3\2\2\2\23\u00bf\3\2\2\2\25\u00c1\3\2\2"+
		"\2\27\u00c3\3\2\2\2\31\u00d6\3\2\2\2\33\u00d8\3\2\2\2\35\u00da\3\2\2\2"+
		"\37\u00dc\3\2\2\2!\u00e7\3\2\2\2#\u00ec\3\2\2\2%\u00f1\3\2\2\2\'\u00fa"+
		"\3\2\2\2)\u00fd\3\2\2\2+\u0100\3\2\2\2-\u0102\3\2\2\2/\u0104\3\2\2\2\61"+
		"\u0106\3\2\2\2\63\u0108\3\2\2\2\65\u010a\3\2\2\2\67\u010c\3\2\2\29\u010e"+
		"\3\2\2\2;\u0110\3\2\2\2=\u0112\3\2\2\2?\u0114\3\2\2\2A\u0116\3\2\2\2C"+
		"\u0118\3\2\2\2E\u011a\3\2\2\2G\u011c\3\2\2\2I\u011e\3\2\2\2K\u0120\3\2"+
		"\2\2M\u0122\3\2\2\2O\u0125\3\2\2\2Q\u0129\3\2\2\2S\u012b\3\2\2\2U\u012d"+
		"\3\2\2\2W\u012f\3\2\2\2Y\u0131\3\2\2\2[\u0133\3\2\2\2]\u0135\3\2\2\2_"+
		"\u0137\3\2\2\2a\u0139\3\2\2\2c\u013b\3\2\2\2e\u013d\3\2\2\2g\u013f\3\2"+
		"\2\2i\u0141\3\2\2\2k\u0143\3\2\2\2m\u0145\3\2\2\2o\u0147\3\2\2\2q\u0149"+
		"\3\2\2\2s\u014b\3\2\2\2u\u014d\3\2\2\2w\u014f\3\2\2\2y\u0151\3\2\2\2{"+
		"\u0153\3\2\2\2}\u0155\3\2\2\2\177\u0157\3\2\2\2\u0081\u0159\3\2\2\2\u0083"+
		"\u015b\3\2\2\2\u0085\u015d\3\2\2\2\u0087\u015f\3\2\2\2\u0089\u0161\3\2"+
		"\2\2\u008b\u0164\3\2\2\2\u008d\u016a\3\2\2\2\u008f\u0176\3\2\2\2\u0091"+
		"\u017c\3\2\2\2\u0093\u0094\5y=\2\u0094\u0095\5[.\2\u0095\u0096\5k\66\2"+
		"\u0096\u0097\5q9\2\u0097\u0098\5o8\2\u0098\4\3\2\2\2\u0099\u009a\5g\64"+
		"\2\u009a\u009b\5[.\2\u009b\u009c\5\u0083B\2\u009c\6\3\2\2\2\u009d\u009e"+
		"\5y=\2\u009e\u009f\5c\62\2\u009f\u00a0\5k\66\2\u00a0\u00a1\5[.\2\u00a1"+
		"\b\3\2\2\2\u00a2\u00a3\5}?\2\u00a3\u00a4\5o8\2\u00a4\u00a5\5c\62\2\u00a5"+
		"\u00a6\5W,\2\u00a6\u00a7\5[.\2\u00a7\n\3\2\2\2\u00a8\u00a9\5Y-\2\u00a9"+
		"\u00aa\5u;\2\u00aa\u00ab\5{>\2\u00ab\u00ac\5k\66\2\u00ac\f\3\2\2\2\u00ad"+
		"\u00ae\5k\66\2\u00ae\u00af\5S*\2\u00af\u00b0\5u;\2\u00b0\u00b1\5g\64\2"+
		"\u00b1\16\3\2\2\2\u00b2\u00b3\5u;\2\u00b3\u00b4\5[.\2\u00b4\u00b5\5W,"+
		"\2\u00b5\u00b6\5S*\2\u00b6\u00b7\5i\65\2\u00b7\u00b8\5i\65\2\u00b8\20"+
		"\3\2\2\2\u00b9\u00bb\7&\2\2\u00ba\u00bc\5\u0089E\2\u00bb\u00ba\3\2\2\2"+
		"\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\22"+
		"\3\2\2\2\u00bf\u00c0\5I%\2\u00c0\24\3\2\2\2\u00c1\u00c2\5-\27\2\u00c2"+
		"\26\3\2\2\2\u00c3\u00d4\5\61\31\2\u00c4\u00c5\7h\2\2\u00c5\u00c6\7h\2"+
		"\2\u00c6\u00d5\7h\2\2\u00c7\u00c8\7h\2\2\u00c8\u00d5\7h\2\2\u00c9\u00d5"+
		"\7h\2\2\u00ca\u00cb\7o\2\2\u00cb\u00d5\7h\2\2\u00cc\u00cd\7r\2\2\u00cd"+
		"\u00d5\7h\2\2\u00ce\u00cf\7r\2\2\u00cf\u00d0\7r\2\2\u00d0\u00d5\7r\2\2"+
		"\u00d1\u00d2\7r\2\2\u00d2\u00d5\7r\2\2\u00d3\u00d5\7r\2\2\u00d4\u00c4"+
		"\3\2\2\2\u00d4\u00c7\3\2\2\2\u00d4\u00c9\3\2\2\2\u00d4\u00ca\3\2\2\2\u00d4"+
		"\u00cc\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d4\u00d3\3\2"+
		"\2\2\u00d5\30\3\2\2\2\u00d6\u00d7\5E#\2\u00d7\32\3\2\2\2\u00d8\u00d9\5"+
		"K&\2\u00d9\34\3\2\2\2\u00da\u00db\5M\'\2\u00db\36\3\2\2\2\u00dc\u00e0"+
		"\5!\21\2\u00dd\u00df\13\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2"+
		"\u00e0\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e3\u00e4\5#\22\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\b\20\2\2"+
		"\u00e6 \3\2\2\2\u00e7\u00e8\7\61\2\2\u00e8\u00e9\7,\2\2\u00e9\u00ea\3"+
		"\2\2\2\u00ea\u00eb\b\21\2\2\u00eb\"\3\2\2\2\u00ec\u00ed\7,\2\2\u00ed\u00ee"+
		"\7\61\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b\22\2\2\u00f0$\3\2\2\2\u00f1"+
		"\u00f5\5\'\24\2\u00f2\u00f4\13\2\2\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3"+
		"\2\2\2\u00f5\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f8\u00f9\5)\25\2\u00f9&\3\2\2\2\u00fa\u00fb\5\67\34"+
		"\2\u00fb\u00fc\59\35\2\u00fc(\3\2\2\2\u00fd\u00fe\5;\36\2\u00fe\u00ff"+
		"\5\67\34\2\u00ff*\3\2\2\2\u0100\u0101\7~\2\2\u0101,\3\2\2\2\u0102\u0103"+
		"\7\u0080\2\2\u0103.\3\2\2\2\u0104\u0105\7=\2\2\u0105\60\3\2\2\2\u0106"+
		"\u0107\7<\2\2\u0107\62\3\2\2\2\u0108\u0109\7*\2\2\u0109\64\3\2\2\2\u010a"+
		"\u010b\7+\2\2\u010b\66\3\2\2\2\u010c\u010d\7\61\2\2\u010d8\3\2\2\2\u010e"+
		"\u010f\7]\2\2\u010f:\3\2\2\2\u0110\u0111\7_\2\2\u0111<\3\2\2\2\u0112\u0113"+
		"\7}\2\2\u0113>\3\2\2\2\u0114\u0115\7\177\2\2\u0115@\3\2\2\2\u0116\u0117"+
		"\7?\2\2\u0117B\3\2\2\2\u0118\u0119\7Z\2\2\u0119D\3\2\2\2\u011a\u011b\7"+
		"-\2\2\u011bF\3\2\2\2\u011c\u011d\7/\2\2\u011dH\3\2\2\2\u011e\u011f\7`"+
		"\2\2\u011fJ\3\2\2\2\u0120\u0121\7#\2\2\u0121L\3\2\2\2\u0122\u0123\7,\2"+
		"\2\u0123N\3\2\2\2\u0124\u0126\5Q)\2\u0125\u0124\3\2\2\2\u0126\u0127\3"+
		"\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128P\3\2\2\2\u0129\u012a"+
		"\t\2\2\2\u012aR\3\2\2\2\u012b\u012c\t\3\2\2\u012cT\3\2\2\2\u012d\u012e"+
		"\t\4\2\2\u012eV\3\2\2\2\u012f\u0130\t\5\2\2\u0130X\3\2\2\2\u0131\u0132"+
		"\t\6\2\2\u0132Z\3\2\2\2\u0133\u0134\t\7\2\2\u0134\\\3\2\2\2\u0135\u0136"+
		"\t\b\2\2\u0136^\3\2\2\2\u0137\u0138\t\t\2\2\u0138`\3\2\2\2\u0139\u013a"+
		"\t\n\2\2\u013ab\3\2\2\2\u013b\u013c\t\13\2\2\u013cd\3\2\2\2\u013d\u013e"+
		"\t\f\2\2\u013ef\3\2\2\2\u013f\u0140\t\r\2\2\u0140h\3\2\2\2\u0141\u0142"+
		"\t\16\2\2\u0142j\3\2\2\2\u0143\u0144\t\17\2\2\u0144l\3\2\2\2\u0145\u0146"+
		"\t\20\2\2\u0146n\3\2\2\2\u0147\u0148\t\21\2\2\u0148p\3\2\2\2\u0149\u014a"+
		"\t\22\2\2\u014ar\3\2\2\2\u014b\u014c\t\23\2\2\u014ct\3\2\2\2\u014d\u014e"+
		"\t\24\2\2\u014ev\3\2\2\2\u014f\u0150\t\25\2\2\u0150x\3\2\2\2\u0151\u0152"+
		"\t\26\2\2\u0152z\3\2\2\2\u0153\u0154\t\27\2\2\u0154|\3\2\2\2\u0155\u0156"+
		"\t\30\2\2\u0156~\3\2\2\2\u0157\u0158\t\31\2\2\u0158\u0080\3\2\2\2\u0159"+
		"\u015a\t\32\2\2\u015a\u0082\3\2\2\2\u015b\u015c\t\33\2\2\u015c\u0084\3"+
		"\2\2\2\u015d\u015e\t\34\2\2\u015e\u0086\3\2\2\2\u015f\u0160\t\35\2\2\u0160"+
		"\u0088\3\2\2\2\u0161\u0162\t\36\2\2\u0162\u008a\3\2\2\2\u0163\u0165\t"+
		"\37\2\2\u0164\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\bF\2\2\u0169\u008c\3\2"+
		"\2\2\u016a\u016b\7\61\2\2\u016b\u016c\7\61\2\2\u016c\u0170\3\2\2\2\u016d"+
		"\u016f\n \2\2\u016e\u016d\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2"+
		"\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2\u0172\u0170\3\2\2\2\u0173"+
		"\u0174\bG\2\2\u0174\u008e\3\2\2\2\u0175\u0177\t!\2\2\u0176\u0175\3\2\2"+
		"\2\u0177\u0178\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a"+
		"\3\2\2\2\u017a\u017b\bH\3\2\u017b\u0090\3\2\2\2\u017c\u017d\13\2\2\2\u017d"+
		"\u0092\3\2\2\2\13\2\u00bd\u00d4\u00e0\u00f5\u0127\u0166\u0170\u0178\4"+
		"\2\3\2\3H\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}