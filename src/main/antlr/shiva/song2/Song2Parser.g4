parser grammar Song2Parser;

options {   tokenVocab = Song2Lexer; }

@header {
    package shiva.song2;
    import java.util.HashMap;
}

song : keysig timesig partlist 
     | keysig partlist
     | timesig partlist 
     | timesig keysig partlist
     | partlist ;

keysig : KEYMARKER KEYCHORD SEMICOLON ;

timesig : TIMEMARKER DIGIT SLASH DIGIT SEMICOLON ;

partlist : part+ ;

part : vardecl 
     | notepart
     | rhythmpart ;
     
vardecl :  VARNAME ASSIGN varvalue SEMICOLON ;

varvalue : (notepart | rhythmpart)+ 
         | NOTE ;

notepart : LPAREN phrase RPAREN 
         | VARNAME  ;
                 
phrase :  INSTRUMENT? NOTE+ 
         |  VARNOTE+ 
         |  INSTRUMENT VARNAME 
         ;

rhythmpart : LPAREN rphrase RPAREN
           | VARNAME ;

rphrase : RINSTRUMENT? RHYTHM+ 
         |  RINSTRUMENT VARNAME 
         ;
