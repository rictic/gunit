lexer grammar gUnit;
options {
  language=Java;

}
@header {package gunit;}

T22 : 'gunit' ;
T23 : 'walks' ;
T24 : ';' ;
T25 : 'header' ;
T26 : ':' ;
T27 : 'OK' ;
T28 : 'FAIL' ;
T29 : 'returns' ;
T30 : '->' ;

// $ANTLR src "gUnit.g" 84
SL_COMMENT
 	:	'//' ~('\r'|'\n')* '\r'? '\n' {$channel=HIDDEN;}
	;

// $ANTLR src "gUnit.g" 88
ML_COMMENT
	:	'/*' {if (input.LA(1)=='*') $type=DOC_COMMENT; else $channel=HIDDEN;} .* '*/'
	;

// $ANTLR src "gUnit.g" 92
STRING	:	'"' (STRING_ESC|~('\\'|'"'))* '"' {setText(getText().substring(1, getText().length()-1));}
	;

// $ANTLR src "gUnit.g" 95
ML_STRING
	:	'<<' .* '>>' {setText(getText().substring(2, getText().length()-2));}
	;

// $ANTLR src "gUnit.g" 99
fragment
STRING_ESC
	:	'\\"'
	|	'\\' ~'"'
	;

// $ANTLR src "gUnit.g" 105
ID	:	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "gUnit.g" 107
EXT	:	'.'('a'..'z'|'A'..'Z'|'0'..'9')+;

// $ANTLR src "gUnit.g" 109
RETVAL	:	NESTED_RETVAL {setText(getText().substring(1, getText().length()-1));}
	;

// $ANTLR src "gUnit.g" 112
fragment
NESTED_RETVAL :
	'['
	(	options {greedy=false;}
	:	NESTED_RETVAL
	|	.
	)*
	']'
	;

// $ANTLR src "gUnit.g" 122
AST	:	NESTED_AST ;

// $ANTLR src "gUnit.g" 124
fragment
NESTED_AST :
	'('
	(	options {greedy=false;}
	:	NESTED_AST
	|	.
	)*
	')'
	;

// $ANTLR src "gUnit.g" 134
ACTION
	:	NESTED_ACTION {setText(getText().substring(1, getText().length()-1));}
	;

// $ANTLR src "gUnit.g" 138
fragment
NESTED_ACTION :
	'{'
	(	options {greedy=false; k=3;}
	:	NESTED_ACTION
	|	STRING_LITERAL
	|	CHAR_LITERAL
	|	.
	)*
	'}'
	;

// $ANTLR src "gUnit.g" 150
fragment
CHAR_LITERAL
	:	'\'' (ESC|~('\\'|'\'')) '\''
	;

// $ANTLR src "gUnit.g" 155
fragment
STRING_LITERAL
	:	'"' (ESC|~('\\'|'"'))+ '"'
	;

// $ANTLR src "gUnit.g" 160
fragment
ESC
	:	'\\\''
	|	'\\"'
	|	'\\' ~('\''|'"')
	;

// $ANTLR src "gUnit.g" 167
WS	:	(	' '
		|	'\t'
		|	'\r'? '\n'
		)+
		{$channel=HIDDEN;}
	;
