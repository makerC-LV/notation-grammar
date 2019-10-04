parser grammar Song4Parser;

options {   tokenVocab = Song4Lexer; }

@header {
    package shiva.song4;
    import java.util.HashMap;
}

song : tempo? keysig? timesig? voiceDef* phraseDef* voicedPhrase+ ;

tempo : TEMPOMARKER NUM SEMICOLON ;

keysig : KEYMARKER KEYSIG SEMICOLON ;

timesig : TIMEMARKER NUM SLASH NUM SEMICOLON ;

voiceDef : VOICEVAR ASSIGN INSTRUMENTNAME SEMICOLON ;

phraseDef : PHRASETEMPLATEVAR ASSIGN templatePhrase SEMICOLON ;

templatePhrase : templatePhraseElement+ ;

templatePhraseElement : CHORD | NOTE | parallelNotes ;

parallelNotes: LBRACE parallelNotesElement+ RBRACE ;

parallelNotesElement : NOTE ;

voicedPhrase : LPAREN VOICEVAR?  voicedPhraseElement+ RPAREN ;

voicedPhraseElement : templatePhrase | PHRASETEMPLATEVAR | timeSet | timeRecall | timeBookmark | BARMARKER ;

timeBookmark : TIMEVAR  ;

timeRecall : TIMINGMARKER COLON TIMEVAR ;

timeSet : NUM COLON NUM ;

//timeSet : BARCOUNT PULSECOUNT ;
