lexer grammar Song4Lexer;

@header {
    package shiva.song4;
    import java.util.HashMap;

}

@members {
  public static final LexerLookup LOOKUP = LexerLookup.INSTANCE;
}

KEYSIG: {LOOKUP.contains(KEYSIG, _input)}? . ;

CHORD : {LOOKUP.contains(CHORD, _input)}? . ;

NOTE : {LOOKUP.contains(NOTE, _input)}? . ;

TEMPOMARKER : 'tempo' ;

KEYMARKER : 'key' ;

TIMEMARKER: 'time' ;

VOICEVAR : 'V' IDCHAR+ ;

PHRASETEMPLATEVAR : 'P' IDCHAR+ ;

TIMEVAR : 'T' IDCHAR+ ;

TIMINGMARKER : 'S' ;

//INSTRUMENT : 'I' INSTRUMENTNAME ;

INSTRUMENTNAME : ALPHABET IDCHAR* ;


NUM: DIGIT+ ;

DIGIT : [0-9] ;

fragment ALPHABET : [A-Za-z] ;

fragment IDCHAR : [A-Za-z0-9_] ;

BARMARKER : '|' ;

SEMICOLON : ';' ;

COLON: ':' ;

LPAREN : '(' ;

RPAREN : ')' ;

SLASH : '/' ;

LBRACKET : '[' ;

RBRACKET : ']' ;

LBRACE : '{' ;

RBRACE : '}' ;

ASSIGN : '=' ;

WS : [ \n\r\t]+ -> skip;

COMMENT
    : '/*' .*? '*/' -> skip
;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
;