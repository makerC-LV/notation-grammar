lexer grammar Song4Lexer;

@header {
    package shiva.song4;
    import java.util.HashMap;

}

@members {
  //public static final LexerLookup LOOKUP = LexerLookup.INSTANCE;
}

tokens {
  CHORD, NOTE, KEYSIG, INSTRUMENTNAME, DRUMNAME
}
// Keywords

TEMPO : 'tempo' ;

KEY : 'key' ;

TIME : 'time' ;

VOICE : 'voice' ;

DRUM : 'drum' ;

PLAY : 'play' ;

//NOTES : 'notes' ;
//
//RHYTHM : 'rhythm' ;

MARKTIME: 'marktime' ;

RECALLTIME: 'recalltime' ;

VAR : '$' IDCHAR+ ;




// 
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

WORD : [a-zA-Z0-9#%_]+
{ 
	Song4SpecialTokenParser.SpecialToken token = Song4SpecialTokenParser.getSpecialToken(getText());
	if ( token != null) {
		setType(token.tokenId);
	}
}
;



	
	
