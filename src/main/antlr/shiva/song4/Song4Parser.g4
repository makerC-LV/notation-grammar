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

playable: notes | rhythm | timeBookmark | timeRecall | timeSet  ;

varDef : VAR ASSIGN assignable SEMICOLON;

assignable : voice | notes | rhythm ;

voice : INSTRUMENTNAME | DRUMNAME ;

notes:  notesElement+ ;

notesElement : NOTE | CHORD | BARMARKER | parallelNotes | VOICE VAR
	| groupedNotes | VAR ;

groupedNotes: LPAREN notes RPAREN (TIMES NUM)? ;

rhythm : rhythmElement+ ;

rhythmElement :  PLUS | MINUS | BARMARKER | DRUM VAR | NUM
	| groupedRhythm  | VAR ;

groupedRhythm : LPAREN rhythm RPAREN (TIMES NUM)? ;





tempo : TEMPO NUM SEMICOLON ;

keysig : KEY KEYSIG SEMICOLON ;

timesig : TIME NUM SLASH NUM SEMICOLON ;



parallelNotes: LBRACE parallelNotesElement+ RBRACE ;

parallelNotesElement : NOTE ;
 

timeBookmark : MARKTIME COLON VAR  ;

timeRecall : RECALLTIME COLON VAR ;

timeSet : NUM COLON NUM ;


