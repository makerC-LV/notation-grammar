parser grammar Song4Parser;

options {   tokenVocab = Song4Lexer; }

@header {
    package shiva.song4;
    import java.util.HashMap;
}

song : tempo? keysig? timesig? voiceDef* rhythmVoiceDef* phraseDef* rhythmPhraseDef* phrase+ ;

phrase: voicedNotePhrase | voicedRhythmPhrase ;

tempo : TEMPO NUM SEMICOLON ;

keysig : KEY KEYSIG SEMICOLON ;

timesig : TIME NUM SLASH NUM SEMICOLON ;

voiceDef : VOICE VAR ASSIGN INSTRUMENTNAME SEMICOLON ;

rhythmVoiceDef : DRUM VAR ASSIGN INSTRUMENTNAME SEMICOLON ;

phraseDef : NOTES VAR ASSIGN notePhrase SEMICOLON ;

rhythmPhraseDef : RHYTHM VAR ASSIGN rhythmPhrase SEMICOLON ;



rhythmPhrase : LPAREN NUM rhythmPhraseElement+ RPAREN TIMES NUM
	| NUM rhythmPhraseElement+ ;

rhythmPhraseElement: PLUS | MINUS ;

parallelNotes: LBRACE parallelNotesElement+ RBRACE ;

parallelNotesElement : NOTE ;

//-------
/* 
notePhrase : notePhraseElement+ ;


notePhraseElement : CHORD | NOTE | parallelNotes | repeatedNotePhrase ;

repeatedNotePhrase : LPAREN notePhraseElement+ RPAREN (TIMES NUM)? ;
*/
// -------
 
notePhrase : LPAREN notePhraseElement+ RPAREN TIMES NUM
	| notePhraseElement+ ;

notePhraseElement : CHORD | NOTE | parallelNotes ;


voicedNotePhrase : (LPAREN VAR?  voicedNotePhraseElement+ RPAREN) | notePhrase ;

voicedNotePhraseElement : notePhrase | VAR | repeatedVar | timeSet | timeRecall | timeBookmark | BARMARKER ;

repeatedVar : VAR TIMES NUM ;

voicedRhythmPhrase : (LPAREN VAR?  voicedRhythmPhraseElement+ RPAREN) | rhythmPhrase ;

voicedRhythmPhraseElement : rhythmPhrase | VAR | timeSet | timeRecall | timeBookmark | BARMARKER ;

timeBookmark : MARKTIME COLON VAR  ;

timeRecall : RECALLTIME COLON VAR ;

timeSet : NUM COLON NUM ;

//timeSet : BARCOUNT PULSECOUNT ;
