grammar gUnit;
options {language=Java;}
tokens {
	DOC_COMMENT;
}
@header {package org.antlr.gunit;}
@lexer::header {package org.antlr.gunit;}
@members {
public GrammarInfo grammarInfo;
public gUnitParser(TokenStream input, GrammarInfo grammarInfo) {
	super(input);
	this.grammarInfo = grammarInfo;
}
}

gUnitDef:	'gunit' g1=ID 
		('walks' g2=ID 
		{
		grammarInfo.setGrammarName($g2.text);
		grammarInfo.setTreeGrammarName($g1.text);
		}
		)? 
		';' 
		{grammarInfo.setGrammarName($g1.text);}
		header? suite* ;

header	:	'@header' ACTION
		{
		int pos1, pos2;
		if ( (pos1=$ACTION.text.indexOf("package"))!=-1 && (pos2=$ACTION.text.indexOf(';'))!=-1 ) {
			grammarInfo.setHeader($ACTION.text.substring(pos1+8, pos2).trim());	// substring the package path
		}
		else {
			System.err.println("error(line "+$ACTION.getLine()+"): invalid header");
		}
		}
	;
		
suite	// gUnit test suite based on individual rule
@init {
    gUnitTestSuite ts = null;
}
	:	r1=ID ('walks' r2=ID {ts = new gUnitTestSuite($r1.text, $r2.text);})? ':' 
		{ts = new gUnitTestSuite($r1.text);} 
		test[ts]+ {grammarInfo.addRuleTestSuite(ts);} 
	;

test[gUnitTestSuite ts]	// individual test within a (rule)testsuite
	:	input ok='OK' {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile, $input.line), new BooleanTest(true));}
	|	input fail='FAIL' {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile, $input.line), new BooleanTest(false));}
	|	input 'returns' RETVAL {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile, $input.line), new ReturnTest($RETVAL));}
	|	input '->' output {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile, $input.line), new OutputTest($output.token));}
	;

input returns [String testInput, boolean inputIsFile, int line]
	:	STRING 
		{
		$testInput = $STRING.text.replace("\\n", "\n").replace("\\r", "\r").replace("\\t", "\t")
		.replace("\\b", "\b").replace("\\f", "\f").replace("\\\"", "\"").replace("\\'", "\'").replace("\\\\", "\\");
		$inputIsFile = false;
		$line = $STRING.line;
		}
	|	ML_STRING
		{
		$testInput = $ML_STRING.text;
		$inputIsFile = false;
		$line = $ML_STRING.line;
		}
	|	file
		{
		$testInput = $file.text;
		$inputIsFile = true;
		$line = $file.line;
		}
	;

output returns [Token token]
	:	STRING 
		{
		$STRING.setText($STRING.text.replace("\\n", "\n").replace("\\r", "\r").replace("\\t", "\t")
		.replace("\\b", "\b").replace("\\f", "\f").replace("\\\"", "\"").replace("\\'", "\'").replace("\\\\", "\\"));
		$token = $STRING;
		}
	|	ML_STRING {$token = $ML_STRING;}
	|	AST {$token = $AST;}
	|	ACTION {$token = $ACTION;}
	;

file returns [int line]	
	:	ID EXT? {$line = $ID.line;}
	;


// L E X I C A L   R U L E S

SL_COMMENT
 	:	'//' ~('\r'|'\n')* '\r'? '\n' {$channel=HIDDEN;}
	;

ML_COMMENT
	:	'/*' {$channel=HIDDEN;} .* '*/'
	;

STRING	:	'"' ( ESC | ~('\\'|'"') )* '"' {setText(getText().substring(1, getText().length()-1));}
	;

ML_STRING
	:	'<<' .* '>>' 
		{
		if ( getText().charAt(2)=='\n' && getText().charAt(getText().length()-3)=='\n' ) {
			setText(getText().substring(3, getText().length()-3));
		}
		else if ( getText().charAt(2)=='\n' ) {
			setText(getText().substring(3, getText().length()-2));
		}
		else if ( getText().charAt(getText().length()-3)=='\n' ) {
			setText(getText().substring(2, getText().length()-3));
		}
		else {
			setText(getText().substring(2, getText().length()-2));
		}
		}
	;

ID	:	('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

EXT	:	'.'('a'..'z'|'A'..'Z'|'0'..'9')+;

RETVAL	:	NESTED_RETVAL {setText(getText().substring(1, getText().length()-1));}
	;

fragment
NESTED_RETVAL :
	'['
	(	options {greedy=false;}
	:	NESTED_RETVAL
	|	.
	)*
	']'
	;

AST	:	NESTED_AST (' '? NESTED_AST)*;

fragment
NESTED_AST :
	'('
	(	options {greedy=false;}
	:	NESTED_AST
	|	.
	)*
	')'
	;

ACTION
	:	NESTED_ACTION {setText(getText().substring(1, getText().length()-1));}
	;

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

fragment
CHAR_LITERAL
	:	'\'' ( ESC | ~('\''|'\\') ) '\''
	;

fragment
STRING_LITERAL
	:	'"' ( ESC | ~('\\'|'"') )* '"'
	;

fragment
ESC	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		|	'>'
		|	'u' XDIGIT XDIGIT XDIGIT XDIGIT
		|	. // unknown, leave as it is
		)
	;
	
fragment
XDIGIT :
		'0' .. '9'
	|	'a' .. 'f'
	|	'A' .. 'F'
	;

WS	:	(	' '
		|	'\t'
		|	'\r'? '\n'
		)+
		{$channel=HIDDEN;}
	;
