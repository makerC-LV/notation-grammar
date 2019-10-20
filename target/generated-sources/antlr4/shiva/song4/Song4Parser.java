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
		TIME=8, VOICE=9, DRUM=10, MARKTIME=11, RECALLTIME=12, VAR=13, ACCENT=14, 
		DYNAMICS=15, MULTILINE_COMMENT=16, STARTCOMMENT=17, ENDCOMMENT=18, BARMARKER=19, 
		SEMICOLON=20, COLON=21, LPAREN=22, RPAREN=23, SLASH=24, LBRACKET=25, RBRACKET=26, 
		LBRACE=27, RBRACE=28, ASSIGN=29, TIMES=30, PLUS=31, MINUS=32, CARET=33, 
		NUM=34, DIGIT=35, WS=36, LINE_COMMENT=37, WORD=38, UNMATCHED=39;
	public static final int
		RULE_song = 0, RULE_globalElement = 1, RULE_songElement = 2, RULE_playCommand = 3, 
		RULE_playable = 4, RULE_varDef = 5, RULE_assignable = 6, RULE_voice = 7, 
		RULE_notes = 8, RULE_notesElement = 9, RULE_groupedNotes = 10, RULE_note = 11, 
		RULE_chord = 12, RULE_rhythm = 13, RULE_rhythmElement = 14, RULE_beat = 15, 
		RULE_groupedRhythm = 16, RULE_tempo = 17, RULE_keysig = 18, RULE_timesig = 19, 
		RULE_parallelNotes = 20, RULE_parallelNotesElement = 21, RULE_timeBookmark = 22, 
		RULE_timeRecall = 23, RULE_timeSet = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"song", "globalElement", "songElement", "playCommand", "playable", "varDef", 
			"assignable", "voice", "notes", "notesElement", "groupedNotes", "note", 
			"chord", "rhythm", "rhythmElement", "beat", "groupedRhythm", "tempo", 
			"keysig", "timesig", "parallelNotes", "parallelNotesElement", "timeBookmark", 
			"timeRecall", "timeSet"
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
		public TerminalNode EOF() { return getToken(Song4Parser.EOF, 0); }
		public List<GlobalElementContext> globalElement() {
			return getRuleContexts(GlobalElementContext.class);
		}
		public GlobalElementContext globalElement(int i) {
			return getRuleContext(GlobalElementContext.class,i);
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
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEMPO) | (1L << KEY) | (1L << TIME))) != 0)) {
				{
				{
				setState(50);
				globalElement();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHORD) | (1L << NOTE) | (1L << VOICE) | (1L << DRUM) | (1L << MARKTIME) | (1L << RECALLTIME) | (1L << VAR) | (1L << ACCENT) | (1L << DYNAMICS) | (1L << BARMARKER) | (1L << LPAREN) | (1L << LBRACE) | (1L << PLUS) | (1L << MINUS) | (1L << NUM))) != 0)) {
				{
				{
				setState(56);
				songElement();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(EOF);
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

	public static class GlobalElementContext extends ParserRuleContext {
		public KeysigContext keysig() {
			return getRuleContext(KeysigContext.class,0);
		}
		public TimesigContext timesig() {
			return getRuleContext(TimesigContext.class,0);
		}
		public TempoContext tempo() {
			return getRuleContext(TempoContext.class,0);
		}
		public GlobalElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterGlobalElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitGlobalElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitGlobalElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalElementContext globalElement() throws RecognitionException {
		GlobalElementContext _localctx = new GlobalElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalElement);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				keysig();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				timesig();
				}
				break;
			case TEMPO:
				enterOuterAlt(_localctx, 3);
				{
				setState(66);
				tempo();
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
		enterRule(_localctx, 4, RULE_songElement);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				varDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				playCommand();
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

	public static class PlayCommandContext extends ParserRuleContext {
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
		enterRule(_localctx, 6, RULE_playCommand);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(73);
					playable();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(76); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		enterRule(_localctx, 8, RULE_playable);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				notes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				rhythm();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(80);
				timeBookmark();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(81);
				timeRecall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(82);
				timeSet();
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
		enterRule(_localctx, 10, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(VAR);
			setState(86);
			match(ASSIGN);
			setState(87);
			assignable();
			setState(88);
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
		enterRule(_localctx, 12, RULE_assignable);
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				voice();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				notes();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92);
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
		enterRule(_localctx, 14, RULE_voice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
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
		enterRule(_localctx, 16, RULE_notes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(97);
					notesElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(100); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public ChordContext chord() {
			return getRuleContext(ChordContext.class,0);
		}
		public TerminalNode BARMARKER() { return getToken(Song4Parser.BARMARKER, 0); }
		public ParallelNotesContext parallelNotes() {
			return getRuleContext(ParallelNotesContext.class,0);
		}
		public TerminalNode VOICE() { return getToken(Song4Parser.VOICE, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public GroupedNotesContext groupedNotes() {
			return getRuleContext(GroupedNotesContext.class,0);
		}
		public TerminalNode DYNAMICS() { return getToken(Song4Parser.DYNAMICS, 0); }
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
		enterRule(_localctx, 18, RULE_notesElement);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				note();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				chord();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				match(BARMARKER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(105);
				parallelNotes();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				match(VOICE);
				setState(107);
				match(VAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				groupedNotes();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				match(VAR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(110);
				match(DYNAMICS);
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
		enterRule(_localctx, 20, RULE_groupedNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(LPAREN);
			setState(114);
			notes();
			setState(115);
			match(RPAREN);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES) {
				{
				setState(116);
				match(TIMES);
				setState(117);
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

	public static class NoteContext extends ParserRuleContext {
		public TerminalNode NOTE() { return getToken(Song4Parser.NOTE, 0); }
		public TerminalNode ACCENT() { return getToken(Song4Parser.ACCENT, 0); }
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCENT) {
				{
				setState(120);
				match(ACCENT);
				}
			}

			setState(123);
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

	public static class ChordContext extends ParserRuleContext {
		public TerminalNode CHORD() { return getToken(Song4Parser.CHORD, 0); }
		public TerminalNode ACCENT() { return getToken(Song4Parser.ACCENT, 0); }
		public ChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitChord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitChord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChordContext chord() throws RecognitionException {
		ChordContext _localctx = new ChordContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCENT) {
				{
				setState(125);
				match(ACCENT);
				}
			}

			setState(128);
			match(CHORD);
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
		enterRule(_localctx, 26, RULE_rhythm);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(130);
					rhythmElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(133); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		public BeatContext beat() {
			return getRuleContext(BeatContext.class,0);
		}
		public TerminalNode BARMARKER() { return getToken(Song4Parser.BARMARKER, 0); }
		public TerminalNode DRUM() { return getToken(Song4Parser.DRUM, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public GroupedRhythmContext groupedRhythm() {
			return getRuleContext(GroupedRhythmContext.class,0);
		}
		public TerminalNode DYNAMICS() { return getToken(Song4Parser.DYNAMICS, 0); }
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
		enterRule(_localctx, 28, RULE_rhythmElement);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ACCENT:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				beat();
				}
				break;
			case BARMARKER:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(BARMARKER);
				}
				break;
			case DRUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(DRUM);
				setState(138);
				match(VAR);
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(139);
				match(NUM);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				groupedRhythm();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(141);
				match(VAR);
				}
				break;
			case DYNAMICS:
				enterOuterAlt(_localctx, 7);
				{
				setState(142);
				match(DYNAMICS);
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

	public static class BeatContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(Song4Parser.PLUS, 0); }
		public TerminalNode ACCENT() { return getToken(Song4Parser.ACCENT, 0); }
		public TerminalNode MINUS() { return getToken(Song4Parser.MINUS, 0); }
		public BeatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterBeat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitBeat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitBeat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeatContext beat() throws RecognitionException {
		BeatContext _localctx = new BeatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_beat);
		int _la;
		try {
			setState(150);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ACCENT:
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ACCENT) {
					{
					setState(145);
					match(ACCENT);
					}
				}

				setState(148);
				match(PLUS);
				}
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(MINUS);
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
		enterRule(_localctx, 32, RULE_groupedRhythm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(LPAREN);
			setState(153);
			rhythm();
			setState(154);
			match(RPAREN);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIMES) {
				{
				setState(155);
				match(TIMES);
				setState(156);
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
		enterRule(_localctx, 34, RULE_tempo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(TEMPO);
			setState(160);
			match(NUM);
			setState(161);
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
		enterRule(_localctx, 36, RULE_keysig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(KEY);
			setState(164);
			match(KEYSIG);
			setState(165);
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
		enterRule(_localctx, 38, RULE_timesig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(TIME);
			setState(168);
			match(NUM);
			setState(169);
			match(SLASH);
			setState(170);
			match(NUM);
			setState(171);
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
		enterRule(_localctx, 40, RULE_parallelNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(LBRACE);
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				parallelNotesElement();
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NOTE );
			setState(179);
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
		enterRule(_localctx, 42, RULE_parallelNotesElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
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
		enterRule(_localctx, 44, RULE_timeBookmark);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(MARKTIME);
			setState(184);
			match(COLON);
			setState(185);
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
		enterRule(_localctx, 46, RULE_timeRecall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(RECALLTIME);
			setState(188);
			match(COLON);
			setState(189);
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
		enterRule(_localctx, 48, RULE_timeSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(NUM);
			setState(192);
			match(COLON);
			setState(193);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00c6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\5\3F\n\3\3\4\3\4\5\4J\n\4\3\5\6\5M\n\5\r\5\16\5N\3"+
		"\6\3\6\3\6\3\6\3\6\5\6V\n\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\5\b`\n\b\3"+
		"\t\3\t\3\n\6\ne\n\n\r\n\16\nf\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13r\n\13\3\f\3\f\3\f\3\f\3\f\5\fy\n\f\3\r\5\r|\n\r\3\r\3\r\3\16"+
		"\5\16\u0081\n\16\3\16\3\16\3\17\6\17\u0086\n\17\r\17\16\17\u0087\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0092\n\20\3\21\5\21\u0095\n"+
		"\21\3\21\3\21\5\21\u0099\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u00a0\n\22"+
		"\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\6\26\u00b2\n\26\r\26\16\26\u00b3\3\26\3\26\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\2\2\33\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\3\3\2\6\7\2\u00ce"+
		"\2\67\3\2\2\2\4E\3\2\2\2\6I\3\2\2\2\bL\3\2\2\2\nU\3\2\2\2\fW\3\2\2\2\16"+
		"_\3\2\2\2\20a\3\2\2\2\22d\3\2\2\2\24q\3\2\2\2\26s\3\2\2\2\30{\3\2\2\2"+
		"\32\u0080\3\2\2\2\34\u0085\3\2\2\2\36\u0091\3\2\2\2 \u0098\3\2\2\2\"\u009a"+
		"\3\2\2\2$\u00a1\3\2\2\2&\u00a5\3\2\2\2(\u00a9\3\2\2\2*\u00af\3\2\2\2,"+
		"\u00b7\3\2\2\2.\u00b9\3\2\2\2\60\u00bd\3\2\2\2\62\u00c1\3\2\2\2\64\66"+
		"\5\4\3\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28=\3\2\2\2"+
		"9\67\3\2\2\2:<\5\6\4\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2"+
		"\2?=\3\2\2\2@A\7\2\2\3A\3\3\2\2\2BF\5&\24\2CF\5(\25\2DF\5$\23\2EB\3\2"+
		"\2\2EC\3\2\2\2ED\3\2\2\2F\5\3\2\2\2GJ\5\f\7\2HJ\5\b\5\2IG\3\2\2\2IH\3"+
		"\2\2\2J\7\3\2\2\2KM\5\n\6\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\t"+
		"\3\2\2\2PV\5\22\n\2QV\5\34\17\2RV\5.\30\2SV\5\60\31\2TV\5\62\32\2UP\3"+
		"\2\2\2UQ\3\2\2\2UR\3\2\2\2US\3\2\2\2UT\3\2\2\2V\13\3\2\2\2WX\7\17\2\2"+
		"XY\7\37\2\2YZ\5\16\b\2Z[\7\26\2\2[\r\3\2\2\2\\`\5\20\t\2]`\5\22\n\2^`"+
		"\5\34\17\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2\2`\17\3\2\2\2ab\t\2\2\2b\21\3"+
		"\2\2\2ce\5\24\13\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\23\3\2\2\2"+
		"hr\5\30\r\2ir\5\32\16\2jr\7\25\2\2kr\5*\26\2lm\7\13\2\2mr\7\17\2\2nr\5"+
		"\26\f\2or\7\17\2\2pr\7\21\2\2qh\3\2\2\2qi\3\2\2\2qj\3\2\2\2qk\3\2\2\2"+
		"ql\3\2\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2r\25\3\2\2\2st\7\30\2\2tu\5\22"+
		"\n\2ux\7\31\2\2vw\7 \2\2wy\7$\2\2xv\3\2\2\2xy\3\2\2\2y\27\3\2\2\2z|\7"+
		"\20\2\2{z\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7\4\2\2~\31\3\2\2\2\177\u0081"+
		"\7\20\2\2\u0080\177\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\7\3\2\2\u0083\33\3\2\2\2\u0084\u0086\5\36\20\2\u0085\u0084\3\2"+
		"\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\35\3\2\2\2\u0089\u0092\5 \21\2\u008a\u0092\7\25\2\2\u008b\u008c\7\f\2"+
		"\2\u008c\u0092\7\17\2\2\u008d\u0092\7$\2\2\u008e\u0092\5\"\22\2\u008f"+
		"\u0092\7\17\2\2\u0090\u0092\7\21\2\2\u0091\u0089\3\2\2\2\u0091\u008a\3"+
		"\2\2\2\u0091\u008b\3\2\2\2\u0091\u008d\3\2\2\2\u0091\u008e\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0090\3\2\2\2\u0092\37\3\2\2\2\u0093\u0095\7\20\2"+
		"\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0099"+
		"\7!\2\2\u0097\u0099\7\"\2\2\u0098\u0094\3\2\2\2\u0098\u0097\3\2\2\2\u0099"+
		"!\3\2\2\2\u009a\u009b\7\30\2\2\u009b\u009c\5\34\17\2\u009c\u009f\7\31"+
		"\2\2\u009d\u009e\7 \2\2\u009e\u00a0\7$\2\2\u009f\u009d\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0#\3\2\2\2\u00a1\u00a2\7\b\2\2\u00a2\u00a3\7$\2\2\u00a3\u00a4"+
		"\7\26\2\2\u00a4%\3\2\2\2\u00a5\u00a6\7\t\2\2\u00a6\u00a7\7\5\2\2\u00a7"+
		"\u00a8\7\26\2\2\u00a8\'\3\2\2\2\u00a9\u00aa\7\n\2\2\u00aa\u00ab\7$\2\2"+
		"\u00ab\u00ac\7\32\2\2\u00ac\u00ad\7$\2\2\u00ad\u00ae\7\26\2\2\u00ae)\3"+
		"\2\2\2\u00af\u00b1\7\35\2\2\u00b0\u00b2\5,\27\2\u00b1\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b6\7\36\2\2\u00b6+\3\2\2\2\u00b7\u00b8\7\4\2\2\u00b8-\3"+
		"\2\2\2\u00b9\u00ba\7\r\2\2\u00ba\u00bb\7\27\2\2\u00bb\u00bc\7\17\2\2\u00bc"+
		"/\3\2\2\2\u00bd\u00be\7\16\2\2\u00be\u00bf\7\27\2\2\u00bf\u00c0\7\17\2"+
		"\2\u00c0\61\3\2\2\2\u00c1\u00c2\7$\2\2\u00c2\u00c3\7\27\2\2\u00c3\u00c4"+
		"\7$\2\2\u00c4\63\3\2\2\2\24\67=EINU_fqx{\u0080\u0087\u0091\u0094\u0098"+
		"\u009f\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}