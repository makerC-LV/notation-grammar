parser grammar Song4Parser;

options {   tokenVocab = Song4Lexer; }

@header {
    package shiva.song4;
    import java.util.HashMap;
}

song : globalElement* songElement* EOF ;

globalElement : keysig | timesig | tempo ;

songElement : varDef | playCommand ;

playCommand : playable+  ;

playable: notes | rhythm | timeBookmark | timeRecall | timeSet ;

varDef : VAR ASSIGN assignable SEMICOLON;

assignable : voice | notes | rhythm ;

voice : INSTRUMENTNAME | DRUMNAME ;

notes:  notesElement+ ;

notesElement : note | chord | BARMARKER | parallelNotes | voiceChange
	| groupedNotes | VAR | DYNAMICS | SCRIPT ;

voiceChange : VOICE VAR ;

groupedNotes: LPAREN notes RPAREN (TIMES NUM)? ;

note: (ACCENT* | ANTIACCENT*) NOTE;

chord: (ACCENT* | ANTIACCENT*) CHORD;

rhythm : rhythmElement+ ;

rhythmElement :  beat | BARMARKER | drumChange | NUM
	| groupedRhythm  | VAR | DYNAMICS | SCRIPT ;

drumChange: DRUM VAR ;

beat: ((ACCENT* | ANTIACCENT*) BEAT) | ACCENTED_BEAT | FLAM | MINUS ;

groupedRhythm : LPAREN rhythm RPAREN (TIMES NUM)? ;





tempo : TEMPO NUM SEMICOLON ;

keysig : KEY KEYSIG SEMICOLON ;

timesig : TIME NUM SLASH NUM SEMICOLON ;



parallelNotes: LBRACE parallelNotesElement+ RBRACE ;

parallelNotesElement : NOTE ;
 

timeBookmark : MARKTIME COLON VAR  ;

timeRecall : RECALLTIME COLON VAR ;

timeSet : NUM COLON NUM ;


