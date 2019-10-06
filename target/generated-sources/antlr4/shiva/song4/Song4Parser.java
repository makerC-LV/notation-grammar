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
		TEMPO=1, KEY=2, TIME=3, VOICE=4, DRUM=5, NOTES=6, RHYTHM=7, MARKTIME=8, 
		RECALLTIME=9, VAR=10, KEYSIG=11, CHORD=12, NOTE=13, BARMARKER=14, SEMICOLON=15, 
		COLON=16, LPAREN=17, RPAREN=18, SLASH=19, LBRACKET=20, RBRACKET=21, LBRACE=22, 
		RBRACE=23, ASSIGN=24, TIMES=25, PLUS=26, MINUS=27, INSTRUMENTNAME=28, 
		NUM=29, DIGIT=30, WS=31, COMMENT=32, LINE_COMMENT=33;
	public static final int
		RULE_song = 0, RULE_phrase = 1, RULE_tempo = 2, RULE_keysig = 3, RULE_timesig = 4, 
		RULE_voiceDef = 5, RULE_rhythmVoiceDef = 6, RULE_phraseDef = 7, RULE_rhythmPhraseDef = 8, 
		RULE_rhythmPhrase = 9, RULE_rhythmPhraseElement = 10, RULE_parallelNotes = 11, 
		RULE_parallelNotesElement = 12, RULE_notePhrase = 13, RULE_notePhraseElement = 14, 
		RULE_voicedNotePhrase = 15, RULE_voicedNotePhraseElement = 16, RULE_repeatedVar = 17, 
		RULE_voicedRhythmPhrase = 18, RULE_voicedRhythmPhraseElement = 19, RULE_timeBookmark = 20, 
		RULE_timeRecall = 21, RULE_timeSet = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"song", "phrase", "tempo", "keysig", "timesig", "voiceDef", "rhythmVoiceDef", 
			"phraseDef", "rhythmPhraseDef", "rhythmPhrase", "rhythmPhraseElement", 
			"parallelNotes", "parallelNotesElement", "notePhrase", "notePhraseElement", 
			"voicedNotePhrase", "voicedNotePhraseElement", "repeatedVar", "voicedRhythmPhrase", 
			"voicedRhythmPhraseElement", "timeBookmark", "timeRecall", "timeSet"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'tempo'", "'key'", "'time'", "'voice'", "'drum'", "'notes'", "'rhythm'", 
			"'marktime'", "'recalltime'", null, null, null, null, "'|'", "';'", "':'", 
			"'('", "')'", "'/'", "'['", "']'", "'{'", "'}'", "'='", "'X'", "'+'", 
			"'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TEMPO", "KEY", "TIME", "VOICE", "DRUM", "NOTES", "RHYTHM", "MARKTIME", 
			"RECALLTIME", "VAR", "KEYSIG", "CHORD", "NOTE", "BARMARKER", "SEMICOLON", 
			"COLON", "LPAREN", "RPAREN", "SLASH", "LBRACKET", "RBRACKET", "LBRACE", 
			"RBRACE", "ASSIGN", "TIMES", "PLUS", "MINUS", "INSTRUMENTNAME", "NUM", 
			"DIGIT", "WS", "COMMENT", "LINE_COMMENT"
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
		public List<RhythmVoiceDefContext> rhythmVoiceDef() {
			return getRuleContexts(RhythmVoiceDefContext.class);
		}
		public RhythmVoiceDefContext rhythmVoiceDef(int i) {
			return getRuleContext(RhythmVoiceDefContext.class,i);
		}
		public List<PhraseDefContext> phraseDef() {
			return getRuleContexts(PhraseDefContext.class);
		}
		public PhraseDefContext phraseDef(int i) {
			return getRuleContext(PhraseDefContext.class,i);
		}
		public List<RhythmPhraseDefContext> rhythmPhraseDef() {
			return getRuleContexts(RhythmPhraseDefContext.class);
		}
		public RhythmPhraseDefContext rhythmPhraseDef(int i) {
			return getRuleContext(RhythmPhraseDefContext.class,i);
		}
		public List<PhraseContext> phrase() {
			return getRuleContexts(PhraseContext.class);
		}
		public PhraseContext phrase(int i) {
			return getRuleContext(PhraseContext.class,i);
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
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMPO) {
				{
				setState(46);
				tempo();
				}
			}

			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEY) {
				{
				setState(49);
				keysig();
				}
			}

			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIME) {
				{
				setState(52);
				timesig();
				}
			}

			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VOICE) {
				{
				{
				setState(55);
				voiceDef();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DRUM) {
				{
				{
				setState(61);
				rhythmVoiceDef();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOTES) {
				{
				{
				setState(67);
				phraseDef();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RHYTHM) {
				{
				{
				setState(73);
				rhythmPhraseDef();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				phrase();
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHORD) | (1L << NOTE) | (1L << LPAREN) | (1L << LBRACE) | (1L << NUM))) != 0) );
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
		public VoicedNotePhraseContext voicedNotePhrase() {
			return getRuleContext(VoicedNotePhraseContext.class,0);
		}
		public VoicedRhythmPhraseContext voicedRhythmPhrase() {
			return getRuleContext(VoicedRhythmPhraseContext.class,0);
		}
		public PhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhraseContext phrase() throws RecognitionException {
		PhraseContext _localctx = new PhraseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_phrase);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				voicedNotePhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				voicedRhythmPhrase();
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

	public static class TempoContext extends ParserRuleContext {
		public TerminalNode TEMPO() { return getToken(Song4Parser.TEMPO, 0); }
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
		enterRule(_localctx, 4, RULE_tempo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(TEMPO);
			setState(89);
			match(NUM);
			setState(90);
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
		public TerminalNode KEY() { return getToken(Song4Parser.KEY, 0); }
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
		enterRule(_localctx, 6, RULE_keysig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(KEY);
			setState(93);
			match(KEYSIG);
			setState(94);
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
		public TerminalNode TIME() { return getToken(Song4Parser.TIME, 0); }
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
		enterRule(_localctx, 8, RULE_timesig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(TIME);
			setState(97);
			match(NUM);
			setState(98);
			match(SLASH);
			setState(99);
			match(NUM);
			setState(100);
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
		public TerminalNode VOICE() { return getToken(Song4Parser.VOICE, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
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
		enterRule(_localctx, 10, RULE_voiceDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(VOICE);
			setState(103);
			match(VAR);
			setState(104);
			match(ASSIGN);
			setState(105);
			match(INSTRUMENTNAME);
			setState(106);
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

	public static class RhythmVoiceDefContext extends ParserRuleContext {
		public TerminalNode DRUM() { return getToken(Song4Parser.DRUM, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(Song4Parser.ASSIGN, 0); }
		public TerminalNode INSTRUMENTNAME() { return getToken(Song4Parser.INSTRUMENTNAME, 0); }
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public RhythmVoiceDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhythmVoiceDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterRhythmVoiceDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitRhythmVoiceDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitRhythmVoiceDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhythmVoiceDefContext rhythmVoiceDef() throws RecognitionException {
		RhythmVoiceDefContext _localctx = new RhythmVoiceDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rhythmVoiceDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(DRUM);
			setState(109);
			match(VAR);
			setState(110);
			match(ASSIGN);
			setState(111);
			match(INSTRUMENTNAME);
			setState(112);
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
		public TerminalNode NOTES() { return getToken(Song4Parser.NOTES, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(Song4Parser.ASSIGN, 0); }
		public NotePhraseContext notePhrase() {
			return getRuleContext(NotePhraseContext.class,0);
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
		enterRule(_localctx, 14, RULE_phraseDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(NOTES);
			setState(115);
			match(VAR);
			setState(116);
			match(ASSIGN);
			setState(117);
			notePhrase();
			setState(118);
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

	public static class RhythmPhraseDefContext extends ParserRuleContext {
		public TerminalNode RHYTHM() { return getToken(Song4Parser.RHYTHM, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(Song4Parser.ASSIGN, 0); }
		public RhythmPhraseContext rhythmPhrase() {
			return getRuleContext(RhythmPhraseContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public RhythmPhraseDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhythmPhraseDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterRhythmPhraseDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitRhythmPhraseDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitRhythmPhraseDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhythmPhraseDefContext rhythmPhraseDef() throws RecognitionException {
		RhythmPhraseDefContext _localctx = new RhythmPhraseDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rhythmPhraseDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(RHYTHM);
			setState(121);
			match(VAR);
			setState(122);
			match(ASSIGN);
			setState(123);
			rhythmPhrase();
			setState(124);
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

	public static class RhythmPhraseContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Song4Parser.LPAREN, 0); }
		public List<TerminalNode> NUM() { return getTokens(Song4Parser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(Song4Parser.NUM, i);
		}
		public TerminalNode RPAREN() { return getToken(Song4Parser.RPAREN, 0); }
		public TerminalNode TIMES() { return getToken(Song4Parser.TIMES, 0); }
		public List<RhythmPhraseElementContext> rhythmPhraseElement() {
			return getRuleContexts(RhythmPhraseElementContext.class);
		}
		public RhythmPhraseElementContext rhythmPhraseElement(int i) {
			return getRuleContext(RhythmPhraseElementContext.class,i);
		}
		public RhythmPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhythmPhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterRhythmPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitRhythmPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitRhythmPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhythmPhraseContext rhythmPhrase() throws RecognitionException {
		RhythmPhraseContext _localctx = new RhythmPhraseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rhythmPhrase);
		int _la;
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(LPAREN);
				setState(127);
				match(NUM);
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(128);
					rhythmPhraseElement();
					}
					}
					setState(131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PLUS || _la==MINUS );
				setState(133);
				match(RPAREN);
				setState(134);
				match(TIMES);
				setState(135);
				match(NUM);
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(NUM);
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(138);
					rhythmPhraseElement();
					}
					}
					setState(141); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PLUS || _la==MINUS );
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

	public static class RhythmPhraseElementContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(Song4Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Song4Parser.MINUS, 0); }
		public RhythmPhraseElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhythmPhraseElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterRhythmPhraseElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitRhythmPhraseElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitRhythmPhraseElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhythmPhraseElementContext rhythmPhraseElement() throws RecognitionException {
		RhythmPhraseElementContext _localctx = new RhythmPhraseElementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rhythmPhraseElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
		enterRule(_localctx, 22, RULE_parallelNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(LBRACE);
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(148);
				parallelNotesElement();
				}
				}
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NOTE );
			setState(153);
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
		enterRule(_localctx, 24, RULE_parallelNotesElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
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

	public static class NotePhraseContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Song4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Song4Parser.RPAREN, 0); }
		public TerminalNode TIMES() { return getToken(Song4Parser.TIMES, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public List<NotePhraseElementContext> notePhraseElement() {
			return getRuleContexts(NotePhraseElementContext.class);
		}
		public NotePhraseElementContext notePhraseElement(int i) {
			return getRuleContext(NotePhraseElementContext.class,i);
		}
		public NotePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notePhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterNotePhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitNotePhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitNotePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotePhraseContext notePhrase() throws RecognitionException {
		NotePhraseContext _localctx = new NotePhraseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_notePhrase);
		int _la;
		try {
			int _alt;
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(LPAREN);
				setState(159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(158);
					notePhraseElement();
					}
					}
					setState(161); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHORD) | (1L << NOTE) | (1L << LBRACE))) != 0) );
				setState(163);
				match(RPAREN);
				setState(164);
				match(TIMES);
				setState(165);
				match(NUM);
				}
				break;
			case CHORD:
			case NOTE:
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(168); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(167);
						notePhraseElement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(170); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class NotePhraseElementContext extends ParserRuleContext {
		public TerminalNode CHORD() { return getToken(Song4Parser.CHORD, 0); }
		public TerminalNode NOTE() { return getToken(Song4Parser.NOTE, 0); }
		public ParallelNotesContext parallelNotes() {
			return getRuleContext(ParallelNotesContext.class,0);
		}
		public NotePhraseElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notePhraseElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterNotePhraseElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitNotePhraseElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitNotePhraseElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotePhraseElementContext notePhraseElement() throws RecognitionException {
		NotePhraseElementContext _localctx = new NotePhraseElementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_notePhraseElement);
		try {
			setState(177);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(CHORD);
				}
				break;
			case NOTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(NOTE);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
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

	public static class VoicedNotePhraseContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Song4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Song4Parser.RPAREN, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public List<VoicedNotePhraseElementContext> voicedNotePhraseElement() {
			return getRuleContexts(VoicedNotePhraseElementContext.class);
		}
		public VoicedNotePhraseElementContext voicedNotePhraseElement(int i) {
			return getRuleContext(VoicedNotePhraseElementContext.class,i);
		}
		public NotePhraseContext notePhrase() {
			return getRuleContext(NotePhraseContext.class,0);
		}
		public VoicedNotePhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voicedNotePhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVoicedNotePhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVoicedNotePhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVoicedNotePhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoicedNotePhraseContext voicedNotePhrase() throws RecognitionException {
		VoicedNotePhraseContext _localctx = new VoicedNotePhraseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_voicedNotePhrase);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(179);
				match(LPAREN);
				setState(181);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(180);
					match(VAR);
					}
					break;
				}
				setState(184); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(183);
					voicedNotePhraseElement();
					}
					}
					setState(186); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MARKTIME) | (1L << RECALLTIME) | (1L << VAR) | (1L << CHORD) | (1L << NOTE) | (1L << BARMARKER) | (1L << LPAREN) | (1L << LBRACE) | (1L << NUM))) != 0) );
				setState(188);
				match(RPAREN);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				notePhrase();
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

	public static class VoicedNotePhraseElementContext extends ParserRuleContext {
		public NotePhraseContext notePhrase() {
			return getRuleContext(NotePhraseContext.class,0);
		}
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public RepeatedVarContext repeatedVar() {
			return getRuleContext(RepeatedVarContext.class,0);
		}
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
		public VoicedNotePhraseElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voicedNotePhraseElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVoicedNotePhraseElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVoicedNotePhraseElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVoicedNotePhraseElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoicedNotePhraseElementContext voicedNotePhraseElement() throws RecognitionException {
		VoicedNotePhraseElementContext _localctx = new VoicedNotePhraseElementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_voicedNotePhraseElement);
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				notePhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				repeatedVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(196);
				timeSet();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				timeRecall();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(198);
				timeBookmark();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(199);
				match(BARMARKER);
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

	public static class RepeatedVarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode TIMES() { return getToken(Song4Parser.TIMES, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public RepeatedVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatedVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterRepeatedVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitRepeatedVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitRepeatedVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeatedVarContext repeatedVar() throws RecognitionException {
		RepeatedVarContext _localctx = new RepeatedVarContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_repeatedVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(VAR);
			setState(203);
			match(TIMES);
			setState(204);
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

	public static class VoicedRhythmPhraseContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Song4Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Song4Parser.RPAREN, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public List<VoicedRhythmPhraseElementContext> voicedRhythmPhraseElement() {
			return getRuleContexts(VoicedRhythmPhraseElementContext.class);
		}
		public VoicedRhythmPhraseElementContext voicedRhythmPhraseElement(int i) {
			return getRuleContext(VoicedRhythmPhraseElementContext.class,i);
		}
		public RhythmPhraseContext rhythmPhrase() {
			return getRuleContext(RhythmPhraseContext.class,0);
		}
		public VoicedRhythmPhraseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voicedRhythmPhrase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVoicedRhythmPhrase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVoicedRhythmPhrase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVoicedRhythmPhrase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoicedRhythmPhraseContext voicedRhythmPhrase() throws RecognitionException {
		VoicedRhythmPhraseContext _localctx = new VoicedRhythmPhraseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_voicedRhythmPhrase);
		int _la;
		try {
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(206);
				match(LPAREN);
				setState(208);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(207);
					match(VAR);
					}
					break;
				}
				setState(211); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(210);
					voicedRhythmPhraseElement();
					}
					}
					setState(213); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MARKTIME) | (1L << RECALLTIME) | (1L << VAR) | (1L << BARMARKER) | (1L << LPAREN) | (1L << NUM))) != 0) );
				setState(215);
				match(RPAREN);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				rhythmPhrase();
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

	public static class VoicedRhythmPhraseElementContext extends ParserRuleContext {
		public RhythmPhraseContext rhythmPhrase() {
			return getRuleContext(RhythmPhraseContext.class,0);
		}
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
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
		public VoicedRhythmPhraseElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voicedRhythmPhraseElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVoicedRhythmPhraseElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVoicedRhythmPhraseElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVoicedRhythmPhraseElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoicedRhythmPhraseElementContext voicedRhythmPhraseElement() throws RecognitionException {
		VoicedRhythmPhraseElementContext _localctx = new VoicedRhythmPhraseElementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_voicedRhythmPhraseElement);
		try {
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				rhythmPhrase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				match(VAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				timeSet();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(223);
				timeRecall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(224);
				timeBookmark();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(225);
				match(BARMARKER);
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

	public static class TimeBookmarkContext extends ParserRuleContext {
		public TerminalNode MARKTIME() { return getToken(Song4Parser.MARKTIME, 0); }
		public TerminalNode COLON() { return getToken(Song4Parser.COLON, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
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
		enterRule(_localctx, 40, RULE_timeBookmark);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(MARKTIME);
			setState(229);
			match(COLON);
			setState(230);
			match(VAR);
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
		public TerminalNode RECALLTIME() { return getToken(Song4Parser.RECALLTIME, 0); }
		public TerminalNode COLON() { return getToken(Song4Parser.COLON, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
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
		enterRule(_localctx, 42, RULE_timeRecall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(RECALLTIME);
			setState(233);
			match(COLON);
			setState(234);
			match(VAR);
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
		enterRule(_localctx, 44, RULE_timeSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(NUM);
			setState(237);
			match(COLON);
			setState(238);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u00f3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\5\2\62"+
		"\n\2\3\2\5\2\65\n\2\3\2\5\28\n\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\7\2A"+
		"\n\2\f\2\16\2D\13\2\3\2\7\2G\n\2\f\2\16\2J\13\2\3\2\7\2M\n\2\f\2\16\2"+
		"P\13\2\3\2\6\2S\n\2\r\2\16\2T\3\3\3\3\5\3Y\n\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\6\13\u0084\n\13\r\13\16\13\u0085\3\13\3\13\3\13\3\13\3\13\3\13\6\13"+
		"\u008e\n\13\r\13\16\13\u008f\5\13\u0092\n\13\3\f\3\f\3\r\3\r\6\r\u0098"+
		"\n\r\r\r\16\r\u0099\3\r\3\r\3\16\3\16\3\17\3\17\6\17\u00a2\n\17\r\17\16"+
		"\17\u00a3\3\17\3\17\3\17\3\17\3\17\6\17\u00ab\n\17\r\17\16\17\u00ac\5"+
		"\17\u00af\n\17\3\20\3\20\3\20\5\20\u00b4\n\20\3\21\3\21\5\21\u00b8\n\21"+
		"\3\21\6\21\u00bb\n\21\r\21\16\21\u00bc\3\21\3\21\3\21\5\21\u00c2\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00cb\n\22\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\5\24\u00d3\n\24\3\24\6\24\u00d6\n\24\r\24\16\24\u00d7\3\24"+
		"\3\24\3\24\5\24\u00dd\n\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00e5\n"+
		"\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\2"+
		"\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\3\3\2\34\35\2"+
		"\u00fe\2\61\3\2\2\2\4X\3\2\2\2\6Z\3\2\2\2\b^\3\2\2\2\nb\3\2\2\2\fh\3\2"+
		"\2\2\16n\3\2\2\2\20t\3\2\2\2\22z\3\2\2\2\24\u0091\3\2\2\2\26\u0093\3\2"+
		"\2\2\30\u0095\3\2\2\2\32\u009d\3\2\2\2\34\u00ae\3\2\2\2\36\u00b3\3\2\2"+
		"\2 \u00c1\3\2\2\2\"\u00ca\3\2\2\2$\u00cc\3\2\2\2&\u00dc\3\2\2\2(\u00e4"+
		"\3\2\2\2*\u00e6\3\2\2\2,\u00ea\3\2\2\2.\u00ee\3\2\2\2\60\62\5\6\4\2\61"+
		"\60\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\65\5\b\5\2\64\63\3\2\2\2\64"+
		"\65\3\2\2\2\65\67\3\2\2\2\668\5\n\6\2\67\66\3\2\2\2\678\3\2\2\28<\3\2"+
		"\2\29;\5\f\7\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=B\3\2\2\2><\3\2"+
		"\2\2?A\5\16\b\2@?\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CH\3\2\2\2DB\3"+
		"\2\2\2EG\5\20\t\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IN\3\2\2\2JH"+
		"\3\2\2\2KM\5\22\n\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2"+
		"PN\3\2\2\2QS\5\4\3\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2U\3\3\2\2"+
		"\2VY\5 \21\2WY\5&\24\2XV\3\2\2\2XW\3\2\2\2Y\5\3\2\2\2Z[\7\3\2\2[\\\7\37"+
		"\2\2\\]\7\21\2\2]\7\3\2\2\2^_\7\4\2\2_`\7\r\2\2`a\7\21\2\2a\t\3\2\2\2"+
		"bc\7\5\2\2cd\7\37\2\2de\7\25\2\2ef\7\37\2\2fg\7\21\2\2g\13\3\2\2\2hi\7"+
		"\6\2\2ij\7\f\2\2jk\7\32\2\2kl\7\36\2\2lm\7\21\2\2m\r\3\2\2\2no\7\7\2\2"+
		"op\7\f\2\2pq\7\32\2\2qr\7\36\2\2rs\7\21\2\2s\17\3\2\2\2tu\7\b\2\2uv\7"+
		"\f\2\2vw\7\32\2\2wx\5\34\17\2xy\7\21\2\2y\21\3\2\2\2z{\7\t\2\2{|\7\f\2"+
		"\2|}\7\32\2\2}~\5\24\13\2~\177\7\21\2\2\177\23\3\2\2\2\u0080\u0081\7\23"+
		"\2\2\u0081\u0083\7\37\2\2\u0082\u0084\5\26\f\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0088\7\24\2\2\u0088\u0089\7\33\2\2\u0089\u008a\7\37\2\2\u008a"+
		"\u0092\3\2\2\2\u008b\u008d\7\37\2\2\u008c\u008e\5\26\f\2\u008d\u008c\3"+
		"\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0092\3\2\2\2\u0091\u0080\3\2\2\2\u0091\u008b\3\2\2\2\u0092\25\3\2\2"+
		"\2\u0093\u0094\t\2\2\2\u0094\27\3\2\2\2\u0095\u0097\7\30\2\2\u0096\u0098"+
		"\5\32\16\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2"+
		"\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\31\2\2\u009c\31"+
		"\3\2\2\2\u009d\u009e\7\17\2\2\u009e\33\3\2\2\2\u009f\u00a1\7\23\2\2\u00a0"+
		"\u00a2\5\36\20\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3"+
		"\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7\24\2\2\u00a6"+
		"\u00a7\7\33\2\2\u00a7\u00a8\7\37\2\2\u00a8\u00af\3\2\2\2\u00a9\u00ab\5"+
		"\36\20\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u009f\3\2\2\2\u00ae\u00aa\3\2"+
		"\2\2\u00af\35\3\2\2\2\u00b0\u00b4\7\16\2\2\u00b1\u00b4\7\17\2\2\u00b2"+
		"\u00b4\5\30\r\2\u00b3\u00b0\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b2\3"+
		"\2\2\2\u00b4\37\3\2\2\2\u00b5\u00b7\7\23\2\2\u00b6\u00b8\7\f\2\2\u00b7"+
		"\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00bb\5\""+
		"\22\2\u00ba\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7\24\2\2\u00bf\u00c2\3"+
		"\2\2\2\u00c0\u00c2\5\34\17\2\u00c1\u00b5\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"!\3\2\2\2\u00c3\u00cb\5\34\17\2\u00c4\u00cb\7\f\2\2\u00c5\u00cb\5$\23"+
		"\2\u00c6\u00cb\5.\30\2\u00c7\u00cb\5,\27\2\u00c8\u00cb\5*\26\2\u00c9\u00cb"+
		"\7\20\2\2\u00ca\u00c3\3\2\2\2\u00ca\u00c4\3\2\2\2\u00ca\u00c5\3\2\2\2"+
		"\u00ca\u00c6\3\2\2\2\u00ca\u00c7\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00c9"+
		"\3\2\2\2\u00cb#\3\2\2\2\u00cc\u00cd\7\f\2\2\u00cd\u00ce\7\33\2\2\u00ce"+
		"\u00cf\7\37\2\2\u00cf%\3\2\2\2\u00d0\u00d2\7\23\2\2\u00d1\u00d3\7\f\2"+
		"\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d6"+
		"\5(\25\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\7\24\2\2\u00da\u00dd\3"+
		"\2\2\2\u00db\u00dd\5\24\13\2\u00dc\u00d0\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd"+
		"\'\3\2\2\2\u00de\u00e5\5\24\13\2\u00df\u00e5\7\f\2\2\u00e0\u00e5\5.\30"+
		"\2\u00e1\u00e5\5,\27\2\u00e2\u00e5\5*\26\2\u00e3\u00e5\7\20\2\2\u00e4"+
		"\u00de\3\2\2\2\u00e4\u00df\3\2\2\2\u00e4\u00e0\3\2\2\2\u00e4\u00e1\3\2"+
		"\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5)\3\2\2\2\u00e6\u00e7"+
		"\7\n\2\2\u00e7\u00e8\7\22\2\2\u00e8\u00e9\7\f\2\2\u00e9+\3\2\2\2\u00ea"+
		"\u00eb\7\13\2\2\u00eb\u00ec\7\22\2\2\u00ec\u00ed\7\f\2\2\u00ed-\3\2\2"+
		"\2\u00ee\u00ef\7\37\2\2\u00ef\u00f0\7\22\2\2\u00f0\u00f1\7\37\2\2\u00f1"+
		"/\3\2\2\2\33\61\64\67<BHNTX\u0085\u008f\u0091\u0099\u00a3\u00ac\u00ae"+
		"\u00b3\u00b7\u00bc\u00c1\u00ca\u00d2\u00d7\u00dc\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}