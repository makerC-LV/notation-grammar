// Generated from Song2Parser.g4 by ANTLR 4.7.2

    package shiva.song2;
    import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Song2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DIGIT=1, WS=2, VARNAME=3, SEMICOLON=4, LPAREN=5, RPAREN=6, SLASH=7, LBRACKET=8, 
		RBRACKET=9, ASSIGN=10, KEYMARKER=11, TIMEMARKER=12, KEYCHORD=13, TIMESIGFRACTION=14, 
		RHYTHM=15, NOTE=16, OCTAVE=17, DURATION=18, VARNOTE=19, INSTRUMENT=20, 
		RINSTRUMENT=21;
	public static final int
		RULE_song = 0, RULE_keysig = 1, RULE_timesig = 2, RULE_partlist = 3, RULE_part = 4, 
		RULE_vardecl = 5, RULE_varvalue = 6, RULE_notepart = 7, RULE_phrase = 8, 
		RULE_rhythmpart = 9, RULE_rphrase = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"song", "keysig", "timesig", "partlist", "part", "vardecl", "varvalue", 
			"notepart", "phrase", "rhythmpart", "rphrase"
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
			"TIMESIGFRACTION", "RHYTHM", "NOTE", "OCTAVE", "DURATION", "VARNOTE", 
			"INSTRUMENT", "RINSTRUMENT"
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

	@Override
	public String getGrammarFileName() { return "Song2Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Song2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SongContext extends ParserRuleContext {
		public KeysigContext keysig() {
			return getRuleContext(KeysigContext.class,0);
		}
		public TimesigContext timesig() {
			return getRuleContext(TimesigContext.class,0);
		}
		public PartlistContext partlist() {
			return getRuleContext(PartlistContext.class,0);
		}
		public SongContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_song; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterSong(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitSong(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitSong(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SongContext song() throws RecognitionException {
		SongContext _localctx = new SongContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_song);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				keysig();
				setState(23);
				timesig();
				setState(24);
				partlist();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				keysig();
				setState(27);
				partlist();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				timesig();
				setState(30);
				partlist();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(32);
				timesig();
				setState(33);
				keysig();
				setState(34);
				partlist();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				partlist();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeysigContext extends ParserRuleContext {
		public TerminalNode KEYMARKER() { return getToken(Song2Parser.KEYMARKER, 0); }
		public TerminalNode KEYCHORD() { return getToken(Song2Parser.KEYCHORD, 0); }
		public TerminalNode SEMICOLON() { return getToken(Song2Parser.SEMICOLON, 0); }
		public KeysigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keysig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterKeysig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitKeysig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitKeysig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeysigContext keysig() throws RecognitionException {
		KeysigContext _localctx = new KeysigContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_keysig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(KEYMARKER);
			setState(40);
			match(KEYCHORD);
			setState(41);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimesigContext extends ParserRuleContext {
		public TerminalNode TIMEMARKER() { return getToken(Song2Parser.TIMEMARKER, 0); }
		public TerminalNode TIMESIGFRACTION() { return getToken(Song2Parser.TIMESIGFRACTION, 0); }
		public TerminalNode SEMICOLON() { return getToken(Song2Parser.SEMICOLON, 0); }
		public TimesigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timesig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterTimesig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitTimesig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitTimesig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimesigContext timesig() throws RecognitionException {
		TimesigContext _localctx = new TimesigContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_timesig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(TIMEMARKER);
			setState(44);
			match(TIMESIGFRACTION);
			setState(45);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartlistContext extends ParserRuleContext {
		public List<PartContext> part() {
			return getRuleContexts(PartContext.class);
		}
		public PartContext part(int i) {
			return getRuleContext(PartContext.class,i);
		}
		public PartlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterPartlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitPartlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitPartlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartlistContext partlist() throws RecognitionException {
		PartlistContext _localctx = new PartlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_partlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(47);
				part();
				}
				}
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VARNAME || _la==LPAREN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartContext extends ParserRuleContext {
		public VardeclContext vardecl() {
			return getRuleContext(VardeclContext.class,0);
		}
		public NotepartContext notepart() {
			return getRuleContext(NotepartContext.class,0);
		}
		public RhythmpartContext rhythmpart() {
			return getRuleContext(RhythmpartContext.class,0);
		}
		public PartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartContext part() throws RecognitionException {
		PartContext _localctx = new PartContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_part);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				vardecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				notepart();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				rhythmpart();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclContext extends ParserRuleContext {
		public TerminalNode VARNAME() { return getToken(Song2Parser.VARNAME, 0); }
		public TerminalNode ASSIGN() { return getToken(Song2Parser.ASSIGN, 0); }
		public VarvalueContext varvalue() {
			return getRuleContext(VarvalueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Song2Parser.SEMICOLON, 0); }
		public VardeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterVardecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitVardecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitVardecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardeclContext vardecl() throws RecognitionException {
		VardeclContext _localctx = new VardeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_vardecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(VARNAME);
			setState(58);
			match(ASSIGN);
			setState(59);
			varvalue();
			setState(60);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarvalueContext extends ParserRuleContext {
		public List<NotepartContext> notepart() {
			return getRuleContexts(NotepartContext.class);
		}
		public NotepartContext notepart(int i) {
			return getRuleContext(NotepartContext.class,i);
		}
		public List<RhythmpartContext> rhythmpart() {
			return getRuleContexts(RhythmpartContext.class);
		}
		public RhythmpartContext rhythmpart(int i) {
			return getRuleContext(RhythmpartContext.class,i);
		}
		public TerminalNode NOTE() { return getToken(Song2Parser.NOTE, 0); }
		public VarvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterVarvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitVarvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitVarvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarvalueContext varvalue() throws RecognitionException {
		VarvalueContext _localctx = new VarvalueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varvalue);
		int _la;
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARNAME:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(64);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						setState(62);
						notepart();
						}
						break;
					case 2:
						{
						setState(63);
						rhythmpart();
						}
						break;
					}
					}
					setState(66); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VARNAME || _la==LPAREN );
				}
				break;
			case NOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				match(NOTE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NotepartContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Song2Parser.LPAREN, 0); }
		public PhraseContext phrase() {
			return getRuleContext(PhraseContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Song2Parser.RPAREN, 0); }
		public TerminalNode VARNAME() { return getToken(Song2Parser.VARNAME, 0); }
		public NotepartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notepart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterNotepart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitNotepart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitNotepart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotepartContext notepart() throws RecognitionException {
		NotepartContext _localctx = new NotepartContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_notepart);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(LPAREN);
				setState(72);
				phrase();
				setState(73);
				match(RPAREN);
				}
				break;
			case VARNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(VARNAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PhraseContext extends ParserRuleContext {
		public TerminalNode INSTRUMENT() { return getToken(Song2Parser.INSTRUMENT, 0); }
		public List<TerminalNode> NOTE() { return getTokens(Song2Parser.NOTE); }
		public TerminalNode NOTE(int i) {
			return getToken(Song2Parser.NOTE, i);
		}
		public List<TerminalNode> VARNOTE() { return getTokens(Song2Parser.VARNOTE); }
		public TerminalNode VARNOTE(int i) {
			return getToken(Song2Parser.VARNOTE, i);
		}
		public TerminalNode VARNAME() { return getToken(Song2Parser.VARNAME, 0); }
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_phrase);
		int _la;
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSTRUMENT) {
					{
					setState(78);
					match(INSTRUMENT);
					}
				}

				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(81);
					match(NOTE);
					}
					}
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NOTE );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					match(VARNOTE);
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VARNOTE );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				match(INSTRUMENT);
				setState(92);
				match(VARNAME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RhythmpartContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Song2Parser.LPAREN, 0); }
		public RphraseContext rphrase() {
			return getRuleContext(RphraseContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Song2Parser.RPAREN, 0); }
		public TerminalNode VARNAME() { return getToken(Song2Parser.VARNAME, 0); }
		public RhythmpartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhythmpart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterRhythmpart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitRhythmpart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitRhythmpart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhythmpartContext rhythmpart() throws RecognitionException {
		RhythmpartContext _localctx = new RhythmpartContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rhythmpart);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(LPAREN);
				setState(96);
				rphrase();
				setState(97);
				match(RPAREN);
				}
				break;
			case VARNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(VARNAME);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RphraseContext extends ParserRuleContext {
		public TerminalNode RINSTRUMENT() { return getToken(Song2Parser.RINSTRUMENT, 0); }
		public List<TerminalNode> RHYTHM() { return getTokens(Song2Parser.RHYTHM); }
		public TerminalNode RHYTHM(int i) {
			return getToken(Song2Parser.RHYTHM, i);
		}
		public TerminalNode VARNAME() { return getToken(Song2Parser.VARNAME, 0); }
		public RphraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rphrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).enterRphrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song2ParserListener ) ((Song2ParserListener)listener).exitRphrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song2ParserVisitor ) return ((Song2ParserVisitor<? extends T>)visitor).visitRphrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RphraseContext rphrase() throws RecognitionException {
		RphraseContext _localctx = new RphraseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rphrase);
		int _la;
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RINSTRUMENT) {
					{
					setState(102);
					match(RINSTRUMENT);
					}
				}

				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(105);
					match(RHYTHM);
					}
					}
					setState(108); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==RHYTHM );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(RINSTRUMENT);
				setState(111);
				match(VARNAME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27u\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2"+
		"(\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\6\5\63\n\5\r\5\16\5\64\3\6\3"+
		"\6\3\6\5\6:\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\6\bC\n\b\r\b\16\bD\3\b\5\b"+
		"H\n\b\3\t\3\t\3\t\3\t\3\t\5\tO\n\t\3\n\5\nR\n\n\3\n\6\nU\n\n\r\n\16\n"+
		"V\3\n\6\nZ\n\n\r\n\16\n[\3\n\3\n\5\n`\n\n\3\13\3\13\3\13\3\13\3\13\5\13"+
		"g\n\13\3\f\5\fj\n\f\3\f\6\fm\n\f\r\f\16\fn\3\f\3\f\5\fs\n\f\3\f\2\2\r"+
		"\2\4\6\b\n\f\16\20\22\24\26\2\2\2}\2\'\3\2\2\2\4)\3\2\2\2\6-\3\2\2\2\b"+
		"\62\3\2\2\2\n9\3\2\2\2\f;\3\2\2\2\16G\3\2\2\2\20N\3\2\2\2\22_\3\2\2\2"+
		"\24f\3\2\2\2\26r\3\2\2\2\30\31\5\4\3\2\31\32\5\6\4\2\32\33\5\b\5\2\33"+
		"(\3\2\2\2\34\35\5\4\3\2\35\36\5\b\5\2\36(\3\2\2\2\37 \5\6\4\2 !\5\b\5"+
		"\2!(\3\2\2\2\"#\5\6\4\2#$\5\4\3\2$%\5\b\5\2%(\3\2\2\2&(\5\b\5\2\'\30\3"+
		"\2\2\2\'\34\3\2\2\2\'\37\3\2\2\2\'\"\3\2\2\2\'&\3\2\2\2(\3\3\2\2\2)*\7"+
		"\r\2\2*+\7\17\2\2+,\7\6\2\2,\5\3\2\2\2-.\7\16\2\2./\7\20\2\2/\60\7\6\2"+
		"\2\60\7\3\2\2\2\61\63\5\n\6\2\62\61\3\2\2\2\63\64\3\2\2\2\64\62\3\2\2"+
		"\2\64\65\3\2\2\2\65\t\3\2\2\2\66:\5\f\7\2\67:\5\20\t\28:\5\24\13\29\66"+
		"\3\2\2\29\67\3\2\2\298\3\2\2\2:\13\3\2\2\2;<\7\5\2\2<=\7\f\2\2=>\5\16"+
		"\b\2>?\7\6\2\2?\r\3\2\2\2@C\5\20\t\2AC\5\24\13\2B@\3\2\2\2BA\3\2\2\2C"+
		"D\3\2\2\2DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FH\7\22\2\2GB\3\2\2\2GF\3\2\2\2"+
		"H\17\3\2\2\2IJ\7\7\2\2JK\5\22\n\2KL\7\b\2\2LO\3\2\2\2MO\7\5\2\2NI\3\2"+
		"\2\2NM\3\2\2\2O\21\3\2\2\2PR\7\26\2\2QP\3\2\2\2QR\3\2\2\2RT\3\2\2\2SU"+
		"\7\22\2\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2W`\3\2\2\2XZ\7\25\2\2"+
		"YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\`\3\2\2\2]^\7\26\2\2^`\7\5"+
		"\2\2_Q\3\2\2\2_Y\3\2\2\2_]\3\2\2\2`\23\3\2\2\2ab\7\7\2\2bc\5\26\f\2cd"+
		"\7\b\2\2dg\3\2\2\2eg\7\5\2\2fa\3\2\2\2fe\3\2\2\2g\25\3\2\2\2hj\7\27\2"+
		"\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2km\7\21\2\2lk\3\2\2\2mn\3\2\2\2nl\3\2"+
		"\2\2no\3\2\2\2os\3\2\2\2pq\7\27\2\2qs\7\5\2\2ri\3\2\2\2rp\3\2\2\2s\27"+
		"\3\2\2\2\21\'\649BDGNQV[_finr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}