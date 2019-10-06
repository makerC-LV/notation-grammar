lexer grammar Song4Lexer;

@header {
    package shiva.song4;
    import java.util.HashMap;

}

@members {
  public static final LexerLookup LOOKUP = LexerLookup.INSTANCE;
}



TEMPO : 'tempo' ;

KEY : 'key' ;

TIME : 'time' ;

VOICE : 'voice' ;

DRUM : 'drum' ;

NOTES : 'notes' ;

RHYTHM : 'rhythm' ;

MARKTIME: 'marktime' ;

RECALLTIME: 'recalltime' ;

VAR : '$' IDCHAR+ ;



KEYSIG: {LOOKUP.contains(KEYSIG, _input)}? . ;

CHORD : {LOOKUP.contains(CHORD, _input)}? . ;

NOTE : {LOOKUP.contains(NOTE, _input)}? . ;

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

TIMES : 'X' ;

PLUS: '+' ;

MINUS: '-' ;

INSTRUMENTNAME : ALPHABET IDCHAR* ;


NUM: DIGIT+ ;

DIGIT : [0-9] ;

fragment ALPHABET : [A-Za-z] ;

fragment IDCHAR : [A-Za-z0-9_] ;



WS : [ \n\r\t]+ -> skip;

COMMENT
    : '/*' .*? '*/' -> skip
;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
;