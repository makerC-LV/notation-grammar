lexer grammar Song2Lexer;

@header {
    package shiva.song2;
    import java.util.HashMap;
}

DIGIT : [0-9]+ ;

WS : [ \n\r\t]+ -> skip;

VARNAME : '_' [A-Za-z0-9_-]+ ;

SEMICOLON : ';' ;

LPAREN : '(' ;

RPAREN : ')' ;

SLASH : '/' ;

LBRACKET : '[' ;

RBRACKET : ']' ;

ASSIGN : '=' ;

fragment BASENOTE : [ABCDEFGabcdefg] ;

fragment NOTEMODIFIER : [#b] ;

fragment SCALE : 'maj' | 'min' ;

KEYMARKER : 'key' ;

TIMEMARKER: 'time' ;

KEYCHORD: LBRACKET BASENOTE NOTEMODIFIER? SCALE? RBRACKET;
    
TIMENUMERATOR: DIGIT ;

TIMEDENOMINATOR : DIGIT ;      
          
RHYTHM : 'o' | '_' ;

NOTE : BASENOTE OCTAVE? NOTEMODIFIER? DURATION? ;
     
OCTAVE : '11' | '10' | [0-9] ;

DURATION :  [whqst] ;

VARNOTE : VARNAME '+' NUM 
                 |  VARNAME '-' NUM
                 | VARNAME ;

fragment NUM : DIGIT+ ;


INSTRUMENT : 'Piano' 
           | 'Flute'
           ;
           
RINSTRUMENT : 'Bass'
            | 'Snare'
            ;