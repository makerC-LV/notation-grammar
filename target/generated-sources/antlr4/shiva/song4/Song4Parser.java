// Generated from Song4Parser.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

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
	public static final String[] tokenNames = {
		"<INVALID>", "CHORD", "NOTE", "KEYSIG", "INSTRUMENTNAME", "DRUMNAME", 
		"TEMPO", "KEY", "TIME", "VOICE", "DRUM", "MARKTIME", "RECALLTIME", "VAR", 
		"ACCENT", "ANTIACCENT", "DYNAMICS", "BEAT", "ACCENTED_BEAT", "FLAM", "MULTILINE_COMMENT", 
		"'/*'", "'*/'", "SCRIPT", "STARTSCRIPT", "ENDSCRIPT", "'|'", "'~'", "';'", 
		"':'", "'('", "')'", "'/'", "'['", "']'", "'{'", "'}'", "'='", "'X'", 
		"'+'", "'-'", "'^'", "'!'", "'*'", "NUM", "DIGIT", "WS", "LINE_COMMENT", 
		"WORD", "UNMATCHED"
	};
	public static final int
		RULE_song = 0, RULE_globalElement = 1, RULE_songElement = 2, RULE_playCommand = 3, 
		RULE_playable = 4, RULE_varDef = 5, RULE_assignable = 6, RULE_voice = 7, 
		RULE_notes = 8, RULE_notesElement = 9, RULE_voiceChange = 10, RULE_groupedNotes = 11, 
		RULE_note = 12, RULE_chord = 13, RULE_rhythm = 14, RULE_rhythmElement = 15, 
		RULE_drumChange = 16, RULE_beat = 17, RULE_groupedRhythm = 18, RULE_tempo = 19, 
		RULE_keysig = 20, RULE_timesig = 21, RULE_parallelNotes = 22, RULE_parallelNotesElement = 23, 
		RULE_timeBookmark = 24, RULE_timeRecall = 25, RULE_timeSet = 26;
	public static final String[] ruleNames = {
		"song", "globalElement", "songElement", "playCommand", "playable", "varDef", 
		"assignable", "voice", "notes", "notesElement", "voiceChange", "groupedNotes", 
		"note", "chord", "rhythm", "rhythmElement", "drumChange", "beat", "groupedRhythm", 
		"tempo", "keysig", "timesig", "parallelNotes", "parallelNotesElement", 
		"timeBookmark", "timeRecall", "timeSet"
	};

	@Override
	public String getGrammarFileName() { return "Song4Parser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public List<GlobalElementContext> globalElement() {
			return getRuleContexts(GlobalElementContext.class);
		}
		public List<SongElementContext> songElement() {
			return getRuleContexts(SongElementContext.class);
		}
		public TerminalNode EOF() { return getToken(Song4Parser.EOF, 0); }
		public GlobalElementContext globalElement(int i) {
			return getRuleContext(GlobalElementContext.class,i);
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
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEMPO) | (1L << KEY) | (1L << TIME))) != 0)) {
				{
				{
				setState(54); globalElement();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHORD) | (1L << NOTE) | (1L << VOICE) | (1L << DRUM) | (1L << MARKTIME) | (1L << RECALLTIME) | (1L << VAR) | (1L << ACCENT) | (1L << ANTIACCENT) | (1L << DYNAMICS) | (1L << BEAT) | (1L << ACCENTED_BEAT) | (1L << FLAM) | (1L << SCRIPT) | (1L << BARMARKER) | (1L << LPAREN) | (1L << LBRACE) | (1L << MINUS) | (1L << NUM))) != 0)) {
				{
				{
				setState(60); songElement();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66); match(EOF);
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
		public TempoContext tempo() {
			return getRuleContext(TempoContext.class,0);
		}
		public TimesigContext timesig() {
			return getRuleContext(TimesigContext.class,0);
		}
		public KeysigContext keysig() {
			return getRuleContext(KeysigContext.class,0);
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
			setState(71);
			switch (_input.LA(1)) {
			case KEY:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); keysig();
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 2);
				{
				setState(69); timesig();
				}
				break;
			case TEMPO:
				enterOuterAlt(_localctx, 3);
				{
				setState(70); tempo();
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
		public PlayCommandContext playCommand() {
			return getRuleContext(PlayCommandContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
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
			setState(75);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73); varDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74); playCommand();
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
			setState(78); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(77); playable();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(80); 
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
		public TimeRecallContext timeRecall() {
			return getRuleContext(TimeRecallContext.class,0);
		}
		public TimeSetContext timeSet() {
			return getRuleContext(TimeSetContext.class,0);
		}
		public TimeBookmarkContext timeBookmark() {
			return getRuleContext(TimeBookmarkContext.class,0);
		}
		public NotesContext notes() {
			return getRuleContext(NotesContext.class,0);
		}
		public RhythmContext rhythm() {
			return getRuleContext(RhythmContext.class,0);
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
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82); notes();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); rhythm();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84); timeBookmark();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(85); timeRecall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(86); timeSet();
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
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Song4Parser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
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
			setState(89); match(VAR);
			setState(90); match(ASSIGN);
			setState(91); assignable();
			setState(92); match(SEMICOLON);
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
		public NotesContext notes() {
			return getRuleContext(NotesContext.class,0);
		}
		public RhythmContext rhythm() {
			return getRuleContext(RhythmContext.class,0);
		}
		public VoiceContext voice() {
			return getRuleContext(VoiceContext.class,0);
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
			setState(97);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94); voice();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95); notes();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96); rhythm();
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
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==INSTRUMENTNAME || _la==DRUMNAME) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
			setState(102); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(101); notesElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(104); 
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
		public GroupedNotesContext groupedNotes() {
			return getRuleContext(GroupedNotesContext.class,0);
		}
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public VoiceChangeContext voiceChange() {
			return getRuleContext(VoiceChangeContext.class,0);
		}
		public TerminalNode DYNAMICS() { return getToken(Song4Parser.DYNAMICS, 0); }
		public ChordContext chord() {
			return getRuleContext(ChordContext.class,0);
		}
		public TerminalNode SCRIPT() { return getToken(Song4Parser.SCRIPT, 0); }
		public TerminalNode BARMARKER() { return getToken(Song4Parser.BARMARKER, 0); }
		public ParallelNotesContext parallelNotes() {
			return getRuleContext(ParallelNotesContext.class,0);
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
		enterRule(_localctx, 18, RULE_notesElement);
		try {
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106); note();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); chord();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108); match(BARMARKER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(109); parallelNotes();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(110); voiceChange();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(111); groupedNotes();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(112); match(VAR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(113); match(DYNAMICS);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(114); match(SCRIPT);
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

	public static class VoiceChangeContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode VOICE() { return getToken(Song4Parser.VOICE, 0); }
		public VoiceChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voiceChange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterVoiceChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitVoiceChange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitVoiceChange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoiceChangeContext voiceChange() throws RecognitionException {
		VoiceChangeContext _localctx = new VoiceChangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_voiceChange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(VOICE);
			setState(118); match(VAR);
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
		public TerminalNode TIMES() { return getToken(Song4Parser.TIMES, 0); }
		public TerminalNode LPAREN() { return getToken(Song4Parser.LPAREN, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public TerminalNode RPAREN() { return getToken(Song4Parser.RPAREN, 0); }
		public NotesContext notes() {
			return getRuleContext(NotesContext.class,0);
		}
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
		enterRule(_localctx, 22, RULE_groupedNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(LPAREN);
			setState(121); notes();
			setState(122); match(RPAREN);
			setState(125);
			_la = _input.LA(1);
			if (_la==TIMES) {
				{
				setState(123); match(TIMES);
				setState(124); match(NUM);
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
		public TerminalNode ACCENT(int i) {
			return getToken(Song4Parser.ACCENT, i);
		}
		public List<TerminalNode> ACCENT() { return getTokens(Song4Parser.ACCENT); }
		public TerminalNode ANTIACCENT(int i) {
			return getToken(Song4Parser.ANTIACCENT, i);
		}
		public TerminalNode NOTE() { return getToken(Song4Parser.NOTE, 0); }
		public List<TerminalNode> ANTIACCENT() { return getTokens(Song4Parser.ANTIACCENT); }
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
		enterRule(_localctx, 24, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ACCENT) {
					{
					{
					setState(127); match(ACCENT);
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANTIACCENT) {
					{
					{
					setState(133); match(ANTIACCENT);
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(141); match(NOTE);
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
		public TerminalNode ACCENT(int i) {
			return getToken(Song4Parser.ACCENT, i);
		}
		public List<TerminalNode> ACCENT() { return getTokens(Song4Parser.ACCENT); }
		public TerminalNode CHORD() { return getToken(Song4Parser.CHORD, 0); }
		public TerminalNode ANTIACCENT(int i) {
			return getToken(Song4Parser.ANTIACCENT, i);
		}
		public List<TerminalNode> ANTIACCENT() { return getTokens(Song4Parser.ANTIACCENT); }
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
		enterRule(_localctx, 26, RULE_chord);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ACCENT) {
					{
					{
					setState(143); match(ACCENT);
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				{
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ANTIACCENT) {
					{
					{
					setState(149); match(ANTIACCENT);
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(157); match(CHORD);
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
		public RhythmElementContext rhythmElement(int i) {
			return getRuleContext(RhythmElementContext.class,i);
		}
		public List<RhythmElementContext> rhythmElement() {
			return getRuleContexts(RhythmElementContext.class);
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
		enterRule(_localctx, 28, RULE_rhythm);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(159); rhythmElement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(162); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		public GroupedRhythmContext groupedRhythm() {
			return getRuleContext(GroupedRhythmContext.class,0);
		}
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode DYNAMICS() { return getToken(Song4Parser.DYNAMICS, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public BeatContext beat() {
			return getRuleContext(BeatContext.class,0);
		}
		public TerminalNode SCRIPT() { return getToken(Song4Parser.SCRIPT, 0); }
		public TerminalNode BARMARKER() { return getToken(Song4Parser.BARMARKER, 0); }
		public DrumChangeContext drumChange() {
			return getRuleContext(DrumChangeContext.class,0);
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
		enterRule(_localctx, 30, RULE_rhythmElement);
		try {
			setState(172);
			switch (_input.LA(1)) {
			case ACCENT:
			case ANTIACCENT:
			case BEAT:
			case ACCENTED_BEAT:
			case FLAM:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(164); beat();
				}
				break;
			case BARMARKER:
				enterOuterAlt(_localctx, 2);
				{
				setState(165); match(BARMARKER);
				}
				break;
			case DRUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(166); drumChange();
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 4);
				{
				setState(167); match(NUM);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(168); groupedRhythm();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 6);
				{
				setState(169); match(VAR);
				}
				break;
			case DYNAMICS:
				enterOuterAlt(_localctx, 7);
				{
				setState(170); match(DYNAMICS);
				}
				break;
			case SCRIPT:
				enterOuterAlt(_localctx, 8);
				{
				setState(171); match(SCRIPT);
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

	public static class DrumChangeContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode DRUM() { return getToken(Song4Parser.DRUM, 0); }
		public DrumChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drumChange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).enterDrumChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Song4ParserListener ) ((Song4ParserListener)listener).exitDrumChange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Song4ParserVisitor ) return ((Song4ParserVisitor<? extends T>)visitor).visitDrumChange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DrumChangeContext drumChange() throws RecognitionException {
		DrumChangeContext _localctx = new DrumChangeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_drumChange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); match(DRUM);
			setState(175); match(VAR);
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
		public TerminalNode FLAM() { return getToken(Song4Parser.FLAM, 0); }
		public TerminalNode BEAT() { return getToken(Song4Parser.BEAT, 0); }
		public TerminalNode ACCENT(int i) {
			return getToken(Song4Parser.ACCENT, i);
		}
		public List<TerminalNode> ACCENT() { return getTokens(Song4Parser.ACCENT); }
		public TerminalNode ANTIACCENT(int i) {
			return getToken(Song4Parser.ANTIACCENT, i);
		}
		public TerminalNode MINUS() { return getToken(Song4Parser.MINUS, 0); }
		public List<TerminalNode> ANTIACCENT() { return getTokens(Song4Parser.ANTIACCENT); }
		public TerminalNode ACCENTED_BEAT() { return getToken(Song4Parser.ACCENTED_BEAT, 0); }
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
		enterRule(_localctx, 34, RULE_beat);
		int _la;
		try {
			setState(195);
			switch (_input.LA(1)) {
			case ACCENT:
			case ANTIACCENT:
			case BEAT:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(189);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==ACCENT) {
						{
						{
						setState(177); match(ACCENT);
						}
						}
						setState(182);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(186);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==ANTIACCENT) {
						{
						{
						setState(183); match(ANTIACCENT);
						}
						}
						setState(188);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				}
				setState(191); match(BEAT);
				}
				}
				break;
			case ACCENTED_BEAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(192); match(ACCENTED_BEAT);
				}
				break;
			case FLAM:
				enterOuterAlt(_localctx, 3);
				{
				setState(193); match(FLAM);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 4);
				{
				setState(194); match(MINUS);
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
		public TerminalNode TIMES() { return getToken(Song4Parser.TIMES, 0); }
		public TerminalNode LPAREN() { return getToken(Song4Parser.LPAREN, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public TerminalNode RPAREN() { return getToken(Song4Parser.RPAREN, 0); }
		public RhythmContext rhythm() {
			return getRuleContext(RhythmContext.class,0);
		}
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
		enterRule(_localctx, 36, RULE_groupedRhythm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(LPAREN);
			setState(198); rhythm();
			setState(199); match(RPAREN);
			setState(202);
			_la = _input.LA(1);
			if (_la==TIMES) {
				{
				setState(200); match(TIMES);
				setState(201); match(NUM);
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
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public TerminalNode NUM() { return getToken(Song4Parser.NUM, 0); }
		public TerminalNode TEMPO() { return getToken(Song4Parser.TEMPO, 0); }
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
		enterRule(_localctx, 38, RULE_tempo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204); match(TEMPO);
			setState(205); match(NUM);
			setState(206); match(SEMICOLON);
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
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public TerminalNode KEYSIG() { return getToken(Song4Parser.KEYSIG, 0); }
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
		enterRule(_localctx, 40, RULE_keysig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208); match(KEY);
			setState(209); match(KEYSIG);
			setState(210); match(SEMICOLON);
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
		public TerminalNode SEMICOLON() { return getToken(Song4Parser.SEMICOLON, 0); }
		public List<TerminalNode> NUM() { return getTokens(Song4Parser.NUM); }
		public TerminalNode TIME() { return getToken(Song4Parser.TIME, 0); }
		public TerminalNode SLASH() { return getToken(Song4Parser.SLASH, 0); }
		public TerminalNode NUM(int i) {
			return getToken(Song4Parser.NUM, i);
		}
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
		enterRule(_localctx, 42, RULE_timesig);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); match(TIME);
			setState(213); match(NUM);
			setState(214); match(SLASH);
			setState(215); match(NUM);
			setState(216); match(SEMICOLON);
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
		public List<ParallelNotesElementContext> parallelNotesElement() {
			return getRuleContexts(ParallelNotesElementContext.class);
		}
		public TerminalNode RBRACE() { return getToken(Song4Parser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(Song4Parser.LBRACE, 0); }
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
		enterRule(_localctx, 44, RULE_parallelNotes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218); match(LBRACE);
			setState(220); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(219); parallelNotesElement();
				}
				}
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NOTE );
			setState(224); match(RBRACE);
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
		enterRule(_localctx, 46, RULE_parallelNotesElement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); match(NOTE);
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
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode MARKTIME() { return getToken(Song4Parser.MARKTIME, 0); }
		public TerminalNode COLON() { return getToken(Song4Parser.COLON, 0); }
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
		enterRule(_localctx, 48, RULE_timeBookmark);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228); match(MARKTIME);
			setState(229); match(COLON);
			setState(230); match(VAR);
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
		public TerminalNode VAR() { return getToken(Song4Parser.VAR, 0); }
		public TerminalNode COLON() { return getToken(Song4Parser.COLON, 0); }
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
		enterRule(_localctx, 50, RULE_timeRecall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(RECALLTIME);
			setState(233); match(COLON);
			setState(234); match(VAR);
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
		enterRule(_localctx, 52, RULE_timeSet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236); match(NUM);
			setState(237); match(COLON);
			setState(238); match(NUM);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\63\u00f3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\7\2@\n"+
		"\2\f\2\16\2C\13\2\3\2\3\2\3\3\3\3\3\3\5\3J\n\3\3\4\3\4\5\4N\n\4\3\5\6"+
		"\5Q\n\5\r\5\16\5R\3\6\3\6\3\6\3\6\3\6\5\6Z\n\6\3\7\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\5\bd\n\b\3\t\3\t\3\n\6\ni\n\n\r\n\16\nj\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13v\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r"+
		"\u0080\n\r\3\16\7\16\u0083\n\16\f\16\16\16\u0086\13\16\3\16\7\16\u0089"+
		"\n\16\f\16\16\16\u008c\13\16\5\16\u008e\n\16\3\16\3\16\3\17\7\17\u0093"+
		"\n\17\f\17\16\17\u0096\13\17\3\17\7\17\u0099\n\17\f\17\16\17\u009c\13"+
		"\17\5\17\u009e\n\17\3\17\3\17\3\20\6\20\u00a3\n\20\r\20\16\20\u00a4\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00af\n\21\3\22\3\22\3\22"+
		"\3\23\7\23\u00b5\n\23\f\23\16\23\u00b8\13\23\3\23\7\23\u00bb\n\23\f\23"+
		"\16\23\u00be\13\23\5\23\u00c0\n\23\3\23\3\23\3\23\3\23\5\23\u00c6\n\23"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00cd\n\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\6\30\u00df\n\30\r\30"+
		"\16\30\u00e0\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\34\2\2\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\66\2\3\3\2\6\7\u0103\2;\3\2\2\2\4I\3\2\2\2\6M\3"+
		"\2\2\2\bP\3\2\2\2\nY\3\2\2\2\f[\3\2\2\2\16c\3\2\2\2\20e\3\2\2\2\22h\3"+
		"\2\2\2\24u\3\2\2\2\26w\3\2\2\2\30z\3\2\2\2\32\u008d\3\2\2\2\34\u009d\3"+
		"\2\2\2\36\u00a2\3\2\2\2 \u00ae\3\2\2\2\"\u00b0\3\2\2\2$\u00c5\3\2\2\2"+
		"&\u00c7\3\2\2\2(\u00ce\3\2\2\2*\u00d2\3\2\2\2,\u00d6\3\2\2\2.\u00dc\3"+
		"\2\2\2\60\u00e4\3\2\2\2\62\u00e6\3\2\2\2\64\u00ea\3\2\2\2\66\u00ee\3\2"+
		"\2\28:\5\4\3\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<A\3\2\2\2=;\3\2"+
		"\2\2>@\5\6\4\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2"+
		"\2\2DE\7\2\2\3E\3\3\2\2\2FJ\5*\26\2GJ\5,\27\2HJ\5(\25\2IF\3\2\2\2IG\3"+
		"\2\2\2IH\3\2\2\2J\5\3\2\2\2KN\5\f\7\2LN\5\b\5\2MK\3\2\2\2ML\3\2\2\2N\7"+
		"\3\2\2\2OQ\5\n\6\2PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\t\3\2\2\2"+
		"TZ\5\22\n\2UZ\5\36\20\2VZ\5\62\32\2WZ\5\64\33\2XZ\5\66\34\2YT\3\2\2\2"+
		"YU\3\2\2\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2\2Z\13\3\2\2\2[\\\7\17\2\2\\]\7"+
		"\'\2\2]^\5\16\b\2^_\7\36\2\2_\r\3\2\2\2`d\5\20\t\2ad\5\22\n\2bd\5\36\20"+
		"\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2d\17\3\2\2\2ef\t\2\2\2f\21\3\2\2\2gi\5"+
		"\24\13\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\23\3\2\2\2lv\5\32\16"+
		"\2mv\5\34\17\2nv\7\34\2\2ov\5.\30\2pv\5\26\f\2qv\5\30\r\2rv\7\17\2\2s"+
		"v\7\22\2\2tv\7\31\2\2ul\3\2\2\2um\3\2\2\2un\3\2\2\2uo\3\2\2\2up\3\2\2"+
		"\2uq\3\2\2\2ur\3\2\2\2us\3\2\2\2ut\3\2\2\2v\25\3\2\2\2wx\7\13\2\2xy\7"+
		"\17\2\2y\27\3\2\2\2z{\7 \2\2{|\5\22\n\2|\177\7!\2\2}~\7(\2\2~\u0080\7"+
		".\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\31\3\2\2\2\u0081\u0083\7\20"+
		"\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u008e\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0089\7\21"+
		"\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u0084\3\2"+
		"\2\2\u008d\u008a\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7\4\2\2\u0090"+
		"\33\3\2\2\2\u0091\u0093\7\20\2\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2"+
		"\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u009e\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0097\u0099\7\21\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2"+
		"\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009d\u0094\3\2\2\2\u009d\u009a\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a0\7\3\2\2\u00a0\35\3\2\2\2\u00a1\u00a3\5 \21\2\u00a2\u00a1\3\2\2"+
		"\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\37"+
		"\3\2\2\2\u00a6\u00af\5$\23\2\u00a7\u00af\7\34\2\2\u00a8\u00af\5\"\22\2"+
		"\u00a9\u00af\7.\2\2\u00aa\u00af\5&\24\2\u00ab\u00af\7\17\2\2\u00ac\u00af"+
		"\7\22\2\2\u00ad\u00af\7\31\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00a7\3\2\2\2"+
		"\u00ae\u00a8\3\2\2\2\u00ae\u00a9\3\2\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ab"+
		"\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af!\3\2\2\2\u00b0"+
		"\u00b1\7\f\2\2\u00b1\u00b2\7\17\2\2\u00b2#\3\2\2\2\u00b3\u00b5\7\20\2"+
		"\2\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00c0\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bb\7\21\2\2"+
		"\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd"+
		"\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00b6\3\2\2\2\u00bf"+
		"\u00bc\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c6\7\23\2\2\u00c2\u00c6\7"+
		"\24\2\2\u00c3\u00c6\7\25\2\2\u00c4\u00c6\7*\2\2\u00c5\u00bf\3\2\2\2\u00c5"+
		"\u00c2\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6%\3\2\2\2"+
		"\u00c7\u00c8\7 \2\2\u00c8\u00c9\5\36\20\2\u00c9\u00cc\7!\2\2\u00ca\u00cb"+
		"\7(\2\2\u00cb\u00cd\7.\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\'\3\2\2\2\u00ce\u00cf\7\b\2\2\u00cf\u00d0\7.\2\2\u00d0\u00d1\7\36\2\2"+
		"\u00d1)\3\2\2\2\u00d2\u00d3\7\t\2\2\u00d3\u00d4\7\5\2\2\u00d4\u00d5\7"+
		"\36\2\2\u00d5+\3\2\2\2\u00d6\u00d7\7\n\2\2\u00d7\u00d8\7.\2\2\u00d8\u00d9"+
		"\7\"\2\2\u00d9\u00da\7.\2\2\u00da\u00db\7\36\2\2\u00db-\3\2\2\2\u00dc"+
		"\u00de\7%\2\2\u00dd\u00df\5\60\31\2\u00de\u00dd\3\2\2\2\u00df\u00e0\3"+
		"\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e3\7&\2\2\u00e3/\3\2\2\2\u00e4\u00e5\7\4\2\2\u00e5\61\3\2\2\2\u00e6"+
		"\u00e7\7\r\2\2\u00e7\u00e8\7\37\2\2\u00e8\u00e9\7\17\2\2\u00e9\63\3\2"+
		"\2\2\u00ea\u00eb\7\16\2\2\u00eb\u00ec\7\37\2\2\u00ec\u00ed\7\17\2\2\u00ed"+
		"\65\3\2\2\2\u00ee\u00ef\7.\2\2\u00ef\u00f0\7\37\2\2\u00f0\u00f1\7.\2\2"+
		"\u00f1\67\3\2\2\2\32;AIMRYcju\177\u0084\u008a\u008d\u0094\u009a\u009d"+
		"\u00a4\u00ae\u00b6\u00bc\u00bf\u00c5\u00cc\u00e0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}