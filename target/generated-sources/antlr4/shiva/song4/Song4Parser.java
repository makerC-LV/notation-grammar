// Generated from Song4Parser.g4 by ANTLR 4.7.2

    package shiva.song4;
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
public class Song4Parser extends Parser {
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
	public static final int
		RULE_song = 0, RULE_tempo = 1, RULE_keysig = 2, RULE_timesig = 3, RULE_voiceDef = 4, 
		RULE_phraseDef = 5, RULE_templatePhrase = 6, RULE_templatePhraseElement = 7, 
		RULE_parallelNotes = 8, RULE_parallelNotesElement = 9, RULE_voicedPhrase = 10, 
		RULE_voicedPhraseElement = 11, RULE_timeBookmark = 12, RULE_timeRecall = 13, 
		RULE_timeSet = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"song", "tempo", "keysig", "timesig", "voiceDef", "phraseDef", "templatePhrase", 
			"templatePhraseElement", "parallelNotes", "parallelNotesElement", "voicedPhrase", 
			"voicedPhraseElement", "timeBookmark", "timeRecall", "timeSet"
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

	@Override
	public String getGrammarFileName() { return "Song4Parser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Song4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SongContext extends ParserRuleContext {
		public TempoContext tempo() {
			return getRuleContext(TempoContext.class,0);
		}
		public KeysigContext keysig() {
			return getRuleContext(KeysigContext.class,0);
		}
		public TimesigContext timesig() {
			return getRuleContext(TimesigContext.class,0);
		}
		public List<VoiceDefContext> voiceDef() {
			return getRuleContexts(VoiceDefContext.class);
		}
		public VoiceDefContext voiceDef(int i) {
			return getRuleContext(VoiceDefContext.class,i);
		}
		public List<PhraseDefContext> phraseDef() {
			return getRuleContexts(PhraseDefContext.class);
		}
		public PhraseDefContext phraseDef(int i) {
			return getRuleContext(PhraseDefContext.class,i);
		}
		public List<VoicedPhraseContext> voicedPhrase() {
			return getRuleContexts(VoicedPhraseContext.class);
		}
		public VoicedPhraseContext voicedPhrase(int i) {
			return getRuleContext(VoicedPhraseContext.class,i);
		}
		public SongContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_song; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterSong(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitSong(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitSong(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SongContext song() throws RecognitionException {
		SongContext _localctx = new SongContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_song);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMPOMARKER) {
				{
				setState(30);
				tempo();
				}
			}

			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYMARKER) {
				{
				setState(33);
				keysig();
				}
			}

			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMEMARKER) {
				{
				setState(36);
				timesig();
				}
			}

			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VOICEVAR) {
				{
				{
				setState(39);
				voiceDef();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PHRASETEMPLATEVAR) {
				{
				{
				setState(45);
				phraseDef();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51);
				voicedPhrase();
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LPAREN );
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

	public static class TempoContext extends ParserRuleContext {
		public TerminalNode TEMPOMARKER() { return getToken(Song4Parser.TEMPOMARKER, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public TempoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterTempo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitTempo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitTempo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TempoContext tempo() throws RecognitionException {
		TempoContext _localctx = new TempoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tempo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(TEMPOMARKER);
			setState(57);
			match(NUM);
			setState(58);
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

	public static class KeysigContext extends ParserRuleContext {
		public TerminalNode KEYMARKER() { return getToken(Song4Parser.KEYMARKER, 0); }
		public TerminalNode KEYSIG() { return getToken(Song4Parser.KEYSIG, 0); }
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public KeysigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keysig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterKeysig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitKeysig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitKeysig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeysigContext keysig() throws RecognitionException {
		KeysigContext _localctx = new KeysigContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_keysig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(KEYMARKER);
			setState(61);
			match(KEYSIG);
			setState(62);
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
		public TerminalNode TIMEMARKER() { return getToken(Song4Parser.TIMEMARKER, 0); }
		public List<TerminalNode> NUM() { return getTokens(Song4Parser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Song4Parser.NUM, i);
		}
		public TerminalNode SLASH() { return getToken(Song4Parser.SLASH, 0); }
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public TimesigContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timesig; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterTimesig(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitTimesig(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitTimesig(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimesigContext timesig() throws RecognitionException {
		TimesigContext _localctx = new TimesigContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_timesig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(TIMEMARKER);
			setState(65);
			match(NUM);
			setState(66);
			match(SLASH);
			setState(67);
			match(NUM);
			setState(68);
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

	public static class VoiceDefContext extends ParserRuleContext {
		public TerminalNode VOICEVAR() { return getToken(Song4Parser.VOICEVAR, 0); }
		public TerminalNode ASSIGN() { return getToken(Song4Parser.ASSIGN, 0); }
		public TerminalNode INSTRUMENTNAME() { return getToken(Song4Parser.INSTRUMENTNAME, 0); }
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public VoiceDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voiceDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVoiceDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVoiceDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVoiceDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoiceDefContext voiceDef() throws RecognitionException {
		VoiceDefContext _localctx = new VoiceDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_voiceDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(VOICEVAR);
			setState(71);
			match(ASSIGN);
			setState(72);
			match(INSTRUMENTNAME);
			setState(73);
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

	public static class PhraseDefContext extends ParserRuleContext {
		public TerminalNode PHRASETEMPLATEVAR() { return getToken(Song4Parser.PHRASETEMPLATEVAR, 0); }
		public TerminalNode ASSIGN() { return getToken(Song4Parser.ASSIGN, 0); }
		public TemplatePhraseContext templatePhrase() {
			return getRuleContext(TemplatePhraseContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public PhraseDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phraseDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterPhraseDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitPhraseDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitPhraseDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseDefContext phraseDef() throws RecognitionException {
		PhraseDefContext _localctx = new PhraseDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_phraseDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(PHRASETEMPLATEVAR);
			setState(76);
			match(ASSIGN);
			setState(77);
			templatePhrase();
			setState(78);
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

	public static class TemplatePhraseContext extends ParserRuleContext {
		public List<TemplatePhraseElementContext> templatePhraseElement() {
			return getRuleContexts(TemplatePhraseElementContext.class);
		}
		public TemplatePhraseElementContext templatePhraseElement(int i) {
			return getRuleContext(TemplatePhraseElementContext.class,i);
		}
		public TemplatePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templatePhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterTemplatePhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitTemplatePhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitTemplatePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplatePhraseContext templatePhrase() throws RecognitionException {
		TemplatePhraseContext _localctx = new TemplatePhraseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_templatePhrase);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(81); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(80);
					templatePhraseElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(83); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class TemplatePhraseElementContext extends ParserRuleContext {
		public TerminalNode CHORD() { return getToken(Song4Parser.CHORD, 0); }
		public TerminalNode NOTE() { return getToken(Song4Parser.NOTE, 0); }
		public ParallelNotesContext parallelNotes() {
			return getRuleContext(ParallelNotesContext.class,0);
		}
		public TemplatePhraseElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_templatePhraseElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterTemplatePhraseElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitTemplatePhraseElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitTemplatePhraseElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TemplatePhraseElementContext templatePhraseElement() throws RecognitionException {
		TemplatePhraseElementContext _localctx = new TemplatePhraseElementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_templatePhraseElement);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(CHORD);
				}
				break;
			case NOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(NOTE);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				parallelNotes();
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

	public static class ParallelNotesContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Song4Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Song4Parser.RBRACE, 0); }
		public List<ParallelNotesElementContext> parallelNotesElement() {
			return getRuleContexts(ParallelNotesElementContext.class);
		}
		public ParallelNotesElementContext parallelNotesElement(int i) {
			return getRuleContext(ParallelNotesElementContext.class,i);
		}
		public ParallelNotesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parallelNotes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterParallelNotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitParallelNotes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitParallelNotes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParallelNotesContext parallelNotes() throws RecognitionException {
		ParallelNotesContext _localctx = new ParallelNotesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parallelNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(LBRACE);
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91);
				parallelNotesElement();
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NOTE );
			setState(96);
			match(RBRACE);
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

	public static class ParallelNotesElementContext extends ParserRuleContext {
		public TerminalNode NOTE() { return getToken(Song4Parser.NOTE, 0); }
		public ParallelNotesElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parallelNotesElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterParallelNotesElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitParallelNotesElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitParallelNotesElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParallelNotesElementContext parallelNotesElement() throws RecognitionException {
		ParallelNotesElementContext _localctx = new ParallelNotesElementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parallelNotesElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(NOTE);
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

	public static class VoicedPhraseContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Song4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Song4Parser.RPAREN, 0); }
		public TerminalNode VOICEVAR() { return getToken(Song4Parser.VOICEVAR, 0); }
		public List<VoicedPhraseElementContext> voicedPhraseElement() {
			return getRuleContexts(VoicedPhraseElementContext.class);
		}
		public VoicedPhraseElementContext voicedPhraseElement(int i) {
			return getRuleContext(VoicedPhraseElementContext.class,i);
		}
		public VoicedPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voicedPhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVoicedPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVoicedPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVoicedPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoicedPhraseContext voicedPhrase() throws RecognitionException {
		VoicedPhraseContext _localctx = new VoicedPhraseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_voicedPhrase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(LPAREN);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VOICEVAR) {
				{
				setState(101);
				match(VOICEVAR);
				}
			}

			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(104);
				voicedPhraseElement();
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHORD) | (1L << NOTE) | (1L << PHRASETEMPLATEVAR) | (1L << TIMEVAR) | (1L << TIMINGMARKER) | (1L << NUM) | (1L << BARMARKER) | (1L << LBRACE))) != 0) );
			setState(109);
			match(RPAREN);
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

	public static class VoicedPhraseElementContext extends ParserRuleContext {
		public TemplatePhraseContext templatePhrase() {
			return getRuleContext(TemplatePhraseContext.class,0);
		}
		public TerminalNode PHRASETEMPLATEVAR() { return getToken(Song4Parser.PHRASETEMPLATEVAR, 0); }
		public TimeSetContext timeSet() {
			return getRuleContext(TimeSetContext.class,0);
		}
		public TimeRecallContext timeRecall() {
			return getRuleContext(TimeRecallContext.class,0);
		}
		public TimeBookmarkContext timeBookmark() {
			return getRuleContext(TimeBookmarkContext.class,0);
		}
		public TerminalNode BARMARKER() { return getToken(Song4Parser.BARMARKER, 0); }
		public VoicedPhraseElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voicedPhraseElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVoicedPhraseElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVoicedPhraseElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVoicedPhraseElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoicedPhraseElementContext voicedPhraseElement() throws RecognitionException {
		VoicedPhraseElementContext _localctx = new VoicedPhraseElementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_voicedPhraseElement);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHORD:
			case NOTE:
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				templatePhrase();
				}
				break;
			case PHRASETEMPLATEVAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(PHRASETEMPLATEVAR);
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				timeSet();
				}
				break;
			case TIMINGMARKER:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				timeRecall();
				}
				break;
			case TIMEVAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
				timeBookmark();
				}
				break;
			case BARMARKER:
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				match(BARMARKER);
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

	public static class TimeBookmarkContext extends ParserRuleContext {
		public TerminalNode TIMEVAR() { return getToken(Song4Parser.TIMEVAR, 0); }
		public TimeBookmarkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeBookmark; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterTimeBookmark(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitTimeBookmark(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitTimeBookmark(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeBookmarkContext timeBookmark() throws RecognitionException {
		TimeBookmarkContext _localctx = new TimeBookmarkContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_timeBookmark);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(TIMEVAR);
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

	public static class TimeRecallContext extends ParserRuleContext {
		public TerminalNode TIMINGMARKER() { return getToken(Song4Parser.TIMINGMARKER, 0); }
		public TerminalNode COLON() { return getToken(Song4Parser.COLON, 0); }
		public TerminalNode TIMEVAR() { return getToken(Song4Parser.TIMEVAR, 0); }
		public TimeRecallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeRecall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterTimeRecall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitTimeRecall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitTimeRecall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeRecallContext timeRecall() throws RecognitionException {
		TimeRecallContext _localctx = new TimeRecallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_timeRecall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(TIMINGMARKER);
			setState(122);
			match(COLON);
			setState(123);
			match(TIMEVAR);
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

	public static class TimeSetContext extends ParserRuleContext {
		public List<TerminalNode> NUM() { return getTokens(Song4Parser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Song4Parser.NUM, i);
		}
		public TerminalNode COLON() { return getToken(Song4Parser.COLON, 0); }
		public TimeSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timeSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterTimeSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitTimeSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitTimeSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeSetContext timeSet() throws RecognitionException {
		TimeSetContext _localctx = new TimeSetContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_timeSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(NUM);
			setState(126);
			match(COLON);
			setState(127);
			match(NUM);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u0084\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\5\2\"\n\2\3\2"+
		"\5\2%\n\2\3\2\5\2(\n\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\7\2\61\n\2\f\2"+
		"\16\2\64\13\2\3\2\6\2\67\n\2\r\2\16\28\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\6"+
		"\bT\n\b\r\b\16\bU\3\t\3\t\3\t\5\t[\n\t\3\n\3\n\6\n_\n\n\r\n\16\n`\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\5\fi\n\f\3\f\6\fl\n\f\r\f\16\fm\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\rx\n\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\2\u0085\2"+
		"!\3\2\2\2\4:\3\2\2\2\6>\3\2\2\2\bB\3\2\2\2\nH\3\2\2\2\fM\3\2\2\2\16S\3"+
		"\2\2\2\20Z\3\2\2\2\22\\\3\2\2\2\24d\3\2\2\2\26f\3\2\2\2\30w\3\2\2\2\32"+
		"y\3\2\2\2\34{\3\2\2\2\36\177\3\2\2\2 \"\5\4\3\2! \3\2\2\2!\"\3\2\2\2\""+
		"$\3\2\2\2#%\5\6\4\2$#\3\2\2\2$%\3\2\2\2%\'\3\2\2\2&(\5\b\5\2\'&\3\2\2"+
		"\2\'(\3\2\2\2(,\3\2\2\2)+\5\n\6\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2"+
		"\2\2-\62\3\2\2\2.,\3\2\2\2/\61\5\f\7\2\60/\3\2\2\2\61\64\3\2\2\2\62\60"+
		"\3\2\2\2\62\63\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\65\67\5\26\f\2\66\65"+
		"\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29\3\3\2\2\2:;\7\6\2\2;<\7\16"+
		"\2\2<=\7\21\2\2=\5\3\2\2\2>?\7\7\2\2?@\7\3\2\2@A\7\21\2\2A\7\3\2\2\2B"+
		"C\7\b\2\2CD\7\16\2\2DE\7\25\2\2EF\7\16\2\2FG\7\21\2\2G\t\3\2\2\2HI\7\t"+
		"\2\2IJ\7\32\2\2JK\7\r\2\2KL\7\21\2\2L\13\3\2\2\2MN\7\n\2\2NO\7\32\2\2"+
		"OP\5\16\b\2PQ\7\21\2\2Q\r\3\2\2\2RT\5\20\t\2SR\3\2\2\2TU\3\2\2\2US\3\2"+
		"\2\2UV\3\2\2\2V\17\3\2\2\2W[\7\4\2\2X[\7\5\2\2Y[\5\22\n\2ZW\3\2\2\2ZX"+
		"\3\2\2\2ZY\3\2\2\2[\21\3\2\2\2\\^\7\30\2\2]_\5\24\13\2^]\3\2\2\2_`\3\2"+
		"\2\2`^\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\7\31\2\2c\23\3\2\2\2de\7\5\2\2e\25"+
		"\3\2\2\2fh\7\23\2\2gi\7\t\2\2hg\3\2\2\2hi\3\2\2\2ik\3\2\2\2jl\5\30\r\2"+
		"kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\24\2\2p\27\3\2"+
		"\2\2qx\5\16\b\2rx\7\n\2\2sx\5\36\20\2tx\5\34\17\2ux\5\32\16\2vx\7\20\2"+
		"\2wq\3\2\2\2wr\3\2\2\2ws\3\2\2\2wt\3\2\2\2wu\3\2\2\2wv\3\2\2\2x\31\3\2"+
		"\2\2yz\7\13\2\2z\33\3\2\2\2{|\7\f\2\2|}\7\22\2\2}~\7\13\2\2~\35\3\2\2"+
		"\2\177\u0080\7\16\2\2\u0080\u0081\7\22\2\2\u0081\u0082\7\16\2\2\u0082"+
		"\37\3\2\2\2\16!$\',\628UZ`hmw";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}