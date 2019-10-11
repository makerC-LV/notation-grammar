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
		CHORD=1, NOTE=2, KEYSIG=3, INSTRUMENTNAME=4, DRUMNAME=5, TEMPO=6, KEY=7, 
		TIME=8, VOICE=9, DRUM=10, PLAY=11, MARKTIME=12, RECALLTIME=13, VAR=14, 
		BARMARKER=15, SEMICOLON=16, COLON=17, LPAREN=18, RPAREN=19, SLASH=20, 
		LBRACKET=21, RBRACKET=22, LBRACE=23, RBRACE=24, ASSIGN=25, TIMES=26, PLUS=27, 
		MINUS=28, NUM=29, DIGIT=30, WS=31, COMMENT=32, LINE_COMMENT=33, WORD=34;
	public static final int
		RULE_song = 0, RULE_songElement = 1, RULE_playCommand = 2, RULE_playable = 3, 
		RULE_varDef = 4, RULE_assignable = 5, RULE_voice = 6, RULE_notes = 7, 
		RULE_notesElement = 8, RULE_groupedNotes = 9, RULE_rhythm = 10, RULE_rhythmElement = 11, 
		RULE_groupedRhythm = 12, RULE_tempo = 13, RULE_keysig = 14, RULE_timesig = 15, 
		RULE_parallelNotes = 16, RULE_parallelNotesElement = 17, RULE_timeBookmark = 18, 
		RULE_timeRecall = 19, RULE_timeSet = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"song", "songElement", "playCommand", "playable", "varDef", "assignable", 
			"voice", "notes", "notesElement", "groupedNotes", "rhythm", "rhythmElement", 
			"groupedRhythm", "tempo", "keysig", "timesig", "parallelNotes", "parallelNotesElement", 
			"timeBookmark", "timeRecall", "timeSet"
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
		public List<SongElementContext> songElement() {
			return getRuleContexts(SongElementContext.class);
		}
		public SongElementContext songElement(int i) {
			return getRuleContext(SongElementContext.class,i);
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMPO) {
				{
				setState(42);
				tempo();
				}
			}

			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEY) {
				{
				setState(45);
				keysig();
				}
			}

			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIME) {
				{
				setState(48);
				timesig();
				}
			}

			setState(52); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(51);
				songElement();
				}
				}
				setState(54); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==PLAY || _la==VAR );
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

	public static class SongElementContext extends ParserRuleContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public PlayCommandContext playCommand() {
			return getRuleContext(PlayCommandContext.class,0);
		}
		public SongElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_songElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterSongElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitSongElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitSongElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SongElementContext songElement() throws RecognitionException {
		SongElementContext _localctx = new SongElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_songElement);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				varDef();
				}
				break;
			case PLAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				playCommand();
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

	public static class PlayCommandContext extends ParserRuleContext {
		public TerminalNode PLAY() { return getToken(Song4Parser.PLAY, 0); }
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public List<PlayableContext> playable() {
			return getRuleContexts(PlayableContext.class);
		}
		public PlayableContext playable(int i) {
			return getRuleContext(PlayableContext.class,i);
		}
		public PlayCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterPlayCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitPlayCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitPlayCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayCommandContext playCommand() throws RecognitionException {
		PlayCommandContext _localctx = new PlayCommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_playCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(PLAY);
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				playable();
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHORD) | (1L << NOTE) | (1L << VOICE) | (1L << DRUM) | (1L << MARKTIME) | (1L << RECALLTIME) | (1L << VAR) | (1L << BARMARKER) | (1L << LPAREN) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << NUM))) != 0) );
			setState(66);
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

	public static class PlayableContext extends ParserRuleContext {
		public NotesContext notes() {
			return getRuleContext(NotesContext.class,0);
		}
		public RhythmContext rhythm() {
			return getRuleContext(RhythmContext.class,0);
		}
		public TimeBookmarkContext timeBookmark() {
			return getRuleContext(TimeBookmarkContext.class,0);
		}
		public TimeRecallContext timeRecall() {
			return getRuleContext(TimeRecallContext.class,0);
		}
		public TimeSetContext timeSet() {
			return getRuleContext(TimeSetContext.class,0);
		}
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public PlayableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterPlayable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitPlayable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitPlayable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayableContext playable() throws RecognitionException {
		PlayableContext _localctx = new PlayableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_playable);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				notes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				rhythm();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				timeBookmark();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				timeRecall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				timeSet();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(73);
				match(VAR);
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

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode ASSIGN() { return getToken(Song4Parser.ASSIGN, 0); }
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(VAR);
			setState(77);
			match(ASSIGN);
			setState(78);
			assignable();
			setState(79);
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

	public static class AssignableContext extends ParserRuleContext {
		public VoiceContext voice() {
			return getRuleContext(VoiceContext.class,0);
		}
		public NotesContext notes() {
			return getRuleContext(NotesContext.class,0);
		}
		public RhythmContext rhythm() {
			return getRuleContext(RhythmContext.class,0);
		}
		public AssignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterAssignable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitAssignable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitAssignable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignable);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				voice();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				notes();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				rhythm();
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

	public static class VoiceContext extends ParserRuleContext {
		public TerminalNode INSTRUMENTNAME() { return getToken(Song4Parser.INSTRUMENTNAME, 0); }
		public TerminalNode DRUMNAME() { return getToken(Song4Parser.DRUMNAME, 0); }
		public VoiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVoice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVoice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVoice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoiceContext voice() throws RecognitionException {
		VoiceContext _localctx = new VoiceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_voice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if ( !(_la==INSTRUMENTNAME || _la==DRUMNAME) ) {
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

	public static class NotesContext extends ParserRuleContext {
		public List<NotesElementContext> notesElement() {
			return getRuleContexts(NotesElementContext.class);
		}
		public NotesElementContext notesElement(int i) {
			return getRuleContext(NotesElementContext.class,i);
		}
		public NotesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterNotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitNotes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitNotes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotesContext notes() throws RecognitionException {
		NotesContext _localctx = new NotesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_notes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(89); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(88);
					notesElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(91); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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

	public static class NotesElementContext extends ParserRuleContext {
		public TerminalNode NOTE() { return getToken(Song4Parser.NOTE, 0); }
		public TerminalNode CHORD() { return getToken(Song4Parser.CHORD, 0); }
		public TerminalNode BARMARKER() { return getToken(Song4Parser.BARMARKER, 0); }
		public ParallelNotesContext parallelNotes() {
			return getRuleContext(ParallelNotesContext.class,0);
		}
		public TerminalNode VOICE() { return getToken(Song4Parser.VOICE, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public GroupedNotesContext groupedNotes() {
			return getRuleContext(GroupedNotesContext.class,0);
		}
		public NotesElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notesElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterNotesElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitNotesElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitNotesElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotesElementContext notesElement() throws RecognitionException {
		NotesElementContext _localctx = new NotesElementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_notesElement);
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(NOTE);
				}
				break;
			case CHORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(CHORD);
				}
				break;
			case BARMARKER:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				match(BARMARKER);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				parallelNotes();
				}
				break;
			case VOICE:
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				match(VOICE);
				setState(98);
				match(VAR);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(99);
				groupedNotes();
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

	public static class GroupedNotesContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Song4Parser.LPAREN, 0); }
		public NotesContext notes() {
			return getRuleContext(NotesContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Song4Parser.RPAREN, 0); }
		public TerminalNode TIMES() { return getToken(Song4Parser.TIMES, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public GroupedNotesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupedNotes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterGroupedNotes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitGroupedNotes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitGroupedNotes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupedNotesContext groupedNotes() throws RecognitionException {
		GroupedNotesContext _localctx = new GroupedNotesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_groupedNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(LPAREN);
			setState(103);
			notes();
			setState(104);
			match(RPAREN);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES) {
				{
				setState(105);
				match(TIMES);
				setState(106);
				match(NUM);
				}
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

	public static class RhythmContext extends ParserRuleContext {
		public List<RhythmElementContext> rhythmElement() {
			return getRuleContexts(RhythmElementContext.class);
		}
		public RhythmElementContext rhythmElement(int i) {
			return getRuleContext(RhythmElementContext.class,i);
		}
		public RhythmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhythm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterRhythm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitRhythm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitRhythm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhythmContext rhythm() throws RecognitionException {
		RhythmContext _localctx = new RhythmContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rhythm);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(110); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(109);
					rhythmElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(112); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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

	public static class RhythmElementContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(Song4Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Song4Parser.MINUS, 0); }
		public TerminalNode BARMARKER() { return getToken(Song4Parser.BARMARKER, 0); }
		public TerminalNode DRUM() { return getToken(Song4Parser.DRUM, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public GroupedRhythmContext groupedRhythm() {
			return getRuleContext(GroupedRhythmContext.class,0);
		}
		public RhythmElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhythmElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterRhythmElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitRhythmElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitRhythmElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RhythmElementContext rhythmElement() throws RecognitionException {
		RhythmElementContext _localctx = new RhythmElementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rhythmElement);
		try {
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				match(PLUS);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(MINUS);
				}
				break;
			case BARMARKER:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(BARMARKER);
				}
				break;
			case DRUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				match(DRUM);
				setState(118);
				match(VAR);
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 5);
				{
				setState(119);
				match(NUM);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(120);
				groupedRhythm();
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

	public static class GroupedRhythmContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Song4Parser.LPAREN, 0); }
		public RhythmContext rhythm() {
			return getRuleContext(RhythmContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Song4Parser.RPAREN, 0); }
		public TerminalNode TIMES() { return getToken(Song4Parser.TIMES, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public GroupedRhythmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupedRhythm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterGroupedRhythm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitGroupedRhythm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitGroupedRhythm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupedRhythmContext groupedRhythm() throws RecognitionException {
		GroupedRhythmContext _localctx = new GroupedRhythmContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_groupedRhythm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(LPAREN);
			setState(124);
			rhythm();
			setState(125);
			match(RPAREN);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES) {
				{
				setState(126);
				match(TIMES);
				setState(127);
				match(NUM);
				}
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
		enterRule(_localctx, 26, RULE_tempo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(TEMPO);
			setState(131);
			match(NUM);
			setState(132);
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
		enterRule(_localctx, 28, RULE_keysig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(KEY);
			setState(135);
			match(KEYSIG);
			setState(136);
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
		enterRule(_localctx, 30, RULE_timesig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(TIME);
			setState(139);
			match(NUM);
			setState(140);
			match(SLASH);
			setState(141);
			match(NUM);
			setState(142);
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
		enterRule(_localctx, 32, RULE_parallelNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(LBRACE);
			setState(146); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(145);
				parallelNotesElement();
				}
				}
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NOTE );
			setState(150);
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
		enterRule(_localctx, 34, RULE_parallelNotesElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
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
		enterRule(_localctx, 36, RULE_timeBookmark);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(MARKTIME);
			setState(155);
			match(COLON);
			setState(156);
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
		enterRule(_localctx, 38, RULE_timeRecall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(RECALLTIME);
			setState(159);
			match(COLON);
			setState(160);
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
		enterRule(_localctx, 40, RULE_timeSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(NUM);
			setState(163);
			match(COLON);
			setState(164);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00a9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\5\2.\n\2\3\2\5\2\61\n\2\3"+
		"\2\5\2\64\n\2\3\2\6\2\67\n\2\r\2\16\28\3\3\3\3\5\3=\n\3\3\4\3\4\6\4A\n"+
		"\4\r\4\16\4B\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5M\n\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\5\7W\n\7\3\b\3\b\3\t\6\t\\\n\t\r\t\16\t]\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\ng\n\n\3\13\3\13\3\13\3\13\3\13\5\13n\n\13\3\f\6\f"+
		"q\n\f\r\f\16\fr\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r|\n\r\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u0083\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\6\22\u0095\n\22\r\22\16\22\u0096\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\3"+
		"\3\2\6\7\2\u00af\2-\3\2\2\2\4<\3\2\2\2\6>\3\2\2\2\bL\3\2\2\2\nN\3\2\2"+
		"\2\fV\3\2\2\2\16X\3\2\2\2\20[\3\2\2\2\22f\3\2\2\2\24h\3\2\2\2\26p\3\2"+
		"\2\2\30{\3\2\2\2\32}\3\2\2\2\34\u0084\3\2\2\2\36\u0088\3\2\2\2 \u008c"+
		"\3\2\2\2\"\u0092\3\2\2\2$\u009a\3\2\2\2&\u009c\3\2\2\2(\u00a0\3\2\2\2"+
		"*\u00a4\3\2\2\2,.\5\34\17\2-,\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/\61\5\36\20"+
		"\2\60/\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\64\5 \21\2\63\62\3\2\2\2"+
		"\63\64\3\2\2\2\64\66\3\2\2\2\65\67\5\4\3\2\66\65\3\2\2\2\678\3\2\2\28"+
		"\66\3\2\2\289\3\2\2\29\3\3\2\2\2:=\5\n\6\2;=\5\6\4\2<:\3\2\2\2<;\3\2\2"+
		"\2=\5\3\2\2\2>@\7\r\2\2?A\5\b\5\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2"+
		"\2\2CD\3\2\2\2DE\7\22\2\2E\7\3\2\2\2FM\5\20\t\2GM\5\26\f\2HM\5&\24\2I"+
		"M\5(\25\2JM\5*\26\2KM\7\20\2\2LF\3\2\2\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2"+
		"LJ\3\2\2\2LK\3\2\2\2M\t\3\2\2\2NO\7\20\2\2OP\7\33\2\2PQ\5\f\7\2QR\7\22"+
		"\2\2R\13\3\2\2\2SW\5\16\b\2TW\5\20\t\2UW\5\26\f\2VS\3\2\2\2VT\3\2\2\2"+
		"VU\3\2\2\2W\r\3\2\2\2XY\t\2\2\2Y\17\3\2\2\2Z\\\5\22\n\2[Z\3\2\2\2\\]\3"+
		"\2\2\2][\3\2\2\2]^\3\2\2\2^\21\3\2\2\2_g\7\4\2\2`g\7\3\2\2ag\7\21\2\2"+
		"bg\5\"\22\2cd\7\13\2\2dg\7\20\2\2eg\5\24\13\2f_\3\2\2\2f`\3\2\2\2fa\3"+
		"\2\2\2fb\3\2\2\2fc\3\2\2\2fe\3\2\2\2g\23\3\2\2\2hi\7\24\2\2ij\5\20\t\2"+
		"jm\7\25\2\2kl\7\34\2\2ln\7\37\2\2mk\3\2\2\2mn\3\2\2\2n\25\3\2\2\2oq\5"+
		"\30\r\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\27\3\2\2\2t|\7\35\2\2"+
		"u|\7\36\2\2v|\7\21\2\2wx\7\f\2\2x|\7\20\2\2y|\7\37\2\2z|\5\32\16\2{t\3"+
		"\2\2\2{u\3\2\2\2{v\3\2\2\2{w\3\2\2\2{y\3\2\2\2{z\3\2\2\2|\31\3\2\2\2}"+
		"~\7\24\2\2~\177\5\26\f\2\177\u0082\7\25\2\2\u0080\u0081\7\34\2\2\u0081"+
		"\u0083\7\37\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\33\3\2\2"+
		"\2\u0084\u0085\7\b\2\2\u0085\u0086\7\37\2\2\u0086\u0087\7\22\2\2\u0087"+
		"\35\3\2\2\2\u0088\u0089\7\t\2\2\u0089\u008a\7\5\2\2\u008a\u008b\7\22\2"+
		"\2\u008b\37\3\2\2\2\u008c\u008d\7\n\2\2\u008d\u008e\7\37\2\2\u008e\u008f"+
		"\7\26\2\2\u008f\u0090\7\37\2\2\u0090\u0091\7\22\2\2\u0091!\3\2\2\2\u0092"+
		"\u0094\7\31\2\2\u0093\u0095\5$\23\2\u0094\u0093\3\2\2\2\u0095\u0096\3"+
		"\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u0099\7\32\2\2\u0099#\3\2\2\2\u009a\u009b\7\4\2\2\u009b%\3\2\2\2\u009c"+
		"\u009d\7\16\2\2\u009d\u009e\7\23\2\2\u009e\u009f\7\20\2\2\u009f\'\3\2"+
		"\2\2\u00a0\u00a1\7\17\2\2\u00a1\u00a2\7\23\2\2\u00a2\u00a3\7\20\2\2\u00a3"+
		")\3\2\2\2\u00a4\u00a5\7\37\2\2\u00a5\u00a6\7\23\2\2\u00a6\u00a7\7\37\2"+
		"\2\u00a7+\3\2\2\2\21-\60\638<BLV]fmr{\u0082\u0096";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}