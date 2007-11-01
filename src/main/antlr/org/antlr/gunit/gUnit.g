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

gUnitDef:	'gunit' g1=ID ('walks' g2=ID)? ';' 
		{
		if ( $g2!=null ) {
			grammarInfo.setGrammarName($g2.text);
			grammarInfo.setTreeGrammarName($g1.text);
		}
		else {
			grammarInfo.setGrammarName($g1.text);
		}
		}
		header? suite+ ;

header	:	'@header' ACTION
		{
		int pos1; int pos2;
		if ( (pos1=$ACTION.text.indexOf("package"))!=-1 && (pos2=$ACTION.text.indexOf(';'))!=-1 ) {
			grammarInfo.setHeader($ACTION.text.substring(pos1+8, pos2).trim());
		}
		}
	;
		
suite	:	r1=ID ('walks' r2=ID)? ':' 
		{
		gUnitTestSuite ts = null;
		if ( $r2!=null ) {
			ts = new gUnitTestSuite($r1.text, $r2.text);
		}
		else {
			ts = new gUnitTestSuite($r1.text);
		}
		} 
		test[ts]+ {grammarInfo.addRuleTestSuite(ts);} ;

test[gUnitTestSuite ts]
	:	input ok='OK' {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile), new BooleanTest(true));}
	|	input fail='FAIL' {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile), new BooleanTest(false));}
	|	input 'returns' RETVAL {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile), new ReturnTest($RETVAL));}
	|	input '->' output {$ts.testSuites.put(new gUnitTestInput($input.testInput, $input.inputIsFile), new OutputTest($output.token));}
	;

input returns [String testInput, boolean inputIsFile]
	:	STRING 
		{
		$testInput=$STRING.text.replace("\\n", "\n").replace("\\t", "\t").replace("\\r", "\r");
		$inputIsFile=false;
		}
	|	ML_STRING
		{
		$testInput=$ML_STRING.text;
		$inputIsFile=false;
		}
	|	file
		{
		$testInput=$file.text;
		$inputIsFile=true;
		}
	;

output returns [Token token]
	:	STRING 
		{
		$STRING.setText($STRING.text.replace("\\n", "\n").replace("\\t", "\t").replace("\\r", "\r"));
		$token=$STRING;
		}
	|	ML_STRING {$token=$ML_STRING;}
	|	AST {$token=$AST;}
	|	ACTION {$token=$ACTION;}
	;

file	:	ID EXT?;


// L E X I C A L   R U L E S

SL_COMMENT
 	:	'//' ~('\r'|'\n')* '\r'? '\n' {$channel=HIDDEN;}
	;

ML_COMMENT
	:	'/*' {$channel=HIDDEN;} .* '*/'
	;

STRING	:	'"' (STRING_ESC|~('\\'|'"'))* '"' {setText(getText().substring(1, getText().length()-1));}
	;

ML_STRING
	:	'<<' .* '>>' 
		{
		if ( getText().charAt(3)=='\n' && getText().charAt(getText().length()-3)=='\n' ) {
			setText(getText().substring(3, getText().length()-3));
		}
		else {
			setText(getText().substring(2, getText().length()-2));
		}
		}
	;

fragment
STRING_ESC
	:	'\\"'
	|	'\\' ~'"'
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

AST	:	NESTED_AST ;

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
	:	'\'' (ESC|~('\\'|'\'')) '\''
	;

fragment
STRING_LITERAL
	:	'"' (ESC|~('\\'|'"'))+ '"'
	;

fragment
ESC
	:	'\\\''
	|	'\\"'
	|	'\\' ~('\''|'"')
	;

WS	:	(	' '
		|	'\t'
		|	'\r'? '\n'
		)+
		{$channel=HIDDEN;}
	;
