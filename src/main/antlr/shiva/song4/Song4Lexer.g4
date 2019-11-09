lexer grammar Song4Lexer;

@header {
    package shiva.song4;
    import java.util.HashMap;

}

@members {
  //public static final LexerLookup LOOKUP = LexerLookup.INSTANCE;
  
}

channels { ERROR }

tokens {
  CHORD, NOTE, KEYSIG, INSTRUMENTNAME, DRUMNAME
  
  
  
}
// Keywords

TEMPO : T E M P O ;

KEY : K E Y ;

TIME : T I M E ;

VOICE : V O I C E ;

DRUM : D R U M ;

MARKTIME: M A R K ;

RECALLTIME: R E C A L L ;



VAR : '$' IDCHAR+ ;

ACCENT : CARET ;

ANTIACCENT : TILDE ;

DYNAMICS : COLON ('fff'|'ff'|'f'|'mf'| 'pf'| 'ppp' | 'pp' | 'p') ;

BEAT : PLUS ;

ACCENTED_BEAT : EXCLAMATION ;

FLAM : ASTERISK ;

MULTILINE_COMMENT
    : STARTCOMMENT .*? ENDCOMMENT -> channel(HIDDEN)
;


STARTCOMMENT: '/*' -> channel(HIDDEN);

ENDCOMMENT: '*/' -> channel(HIDDEN);

SCRIPT: STARTSCRIPT .*? ENDSCRIPT ;

STARTSCRIPT: SLASH LBRACKET ;

ENDSCRIPT : RBRACKET SLASH ;


// 
BARMARKER : '|' ;

TILDE : '~' ;

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

CARET: '^' ;

EXCLAMATION: '!' ;

ASTERISK: '*';


NUM: DIGIT+ ;

DIGIT : [0-9] ;

fragment A : [aA]; // match either an 'a' or 'A'
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

fragment ALPHABET : [A-Za-z] ;

fragment IDCHAR : [A-Za-z0-9_] ;




WS : [ \n\r\t]+ -> channel(HIDDEN);






LINE_COMMENT
    : '//' ~[\r\n]* -> channel(HIDDEN)
;

WORD : [a-zA-Z0-9#%_]+
{ 
	Song4SpecialTokenParser.SpecialToken token = Song4SpecialTokenParser.getSpecialToken(getText());
	if ( token != null) {
		setType(token.tokenId);
	} else {
		setType(Song4Lexer.UNMATCHED);
	}
}
;




UNMATCHED          : .  /* -> channel(ERROR) */
;

	
	
