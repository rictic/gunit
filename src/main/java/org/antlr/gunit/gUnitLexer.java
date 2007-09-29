// $ANTLR 3.0 /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g 2007-08-18 23:04:40
package org.antlr.gunit;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class gUnitLexer extends Lexer {
    public static final int RETVAL=7;
    public static final int T29=29;
    public static final int NESTED_ACTION=17;
    public static final int AST=10;
    public static final int EXT=11;
    public static final int T22=22;
    public static final int STRING_ESC=14;
    public static final int WS=21;
    public static final int STRING=8;
    public static final int T28=28;
    public static final int T23=23;
    public static final int ACTION=6;
    public static final int ESC=20;
    public static final int NESTED_AST=16;
    public static final int T25=25;
    public static final int CHAR_LITERAL=19;
    public static final int T26=26;
    public static final int EOF=-1;
    public static final int STRING_LITERAL=18;
    public static final int Tokens=31;
    public static final int ML_STRING=9;
    public static final int ML_COMMENT=13;
    public static final int T27=27;
    public static final int SL_COMMENT=12;
    public static final int T30=30;
    public static final int T24=24;
    public static final int DOC_COMMENT=4;
    public static final int NESTED_RETVAL=15;
    public static final int ID=5;
    public gUnitLexer() {;} 
    public gUnitLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g"; }

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:8:5: ( 'gunit' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:8:7: 'gunit'
            {
            match("gunit"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:9:5: ( 'walks' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:9:7: 'walks'
            {
            match("walks"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:10:5: ( ';' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:10:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:11:5: ( '@header' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:11:7: '@header'
            {
            match("@header"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:12:5: ( ':' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:12:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:13:5: ( 'OK' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:13:7: 'OK'
            {
            match("OK"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:14:5: ( 'FAIL' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:14:7: 'FAIL'
            {
            match("FAIL"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:15:5: ( 'returns' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:15:7: 'returns'
            {
            match("returns"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:16:5: ( '->' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:16:7: '->'
            {
            match("->"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start SL_COMMENT
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:91:3: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:91:5: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' )? '\\n'
            {
            match("//"); 

            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:91:10: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:91:10: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:91:24: ( '\\r' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\r') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:91:24: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }

            match('\n'); 
            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SL_COMMENT

    // $ANTLR start ML_COMMENT
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:95:2: ( '/*' ( . )* '*/' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:95:4: '/*' ( . )* '*/'
            {
            match("/*"); 

            channel=HIDDEN;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:95:28: ( . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1>='\u0000' && LA3_1<='.')||(LA3_1>='0' && LA3_1<='\uFFFE')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0>='\u0000' && LA3_0<=')')||(LA3_0>='+' && LA3_0<='\uFFFE')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:95:28: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ML_COMMENT

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:98:8: ( '\"' ( STRING_ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:98:10: '\"' ( STRING_ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:98:14: ( STRING_ESC | ~ ( '\\\\' | '\"' ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFE')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:98:15: STRING_ESC
            	    {
            	    mSTRING_ESC(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:98:26: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\"'); 
            setText(getText().substring(1, getText().length()-1));

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start ML_STRING
    public final void mML_STRING() throws RecognitionException {
        try {
            int _type = ML_STRING;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:102:2: ( '<<' ( . )* '>>' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:102:4: '<<' ( . )* '>>'
            {
            match("<<"); 

            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:102:9: ( . )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='>') ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1=='>') ) {
                        alt5=2;
                    }
                    else if ( ((LA5_1>='\u0000' && LA5_1<='=')||(LA5_1>='?' && LA5_1<='\uFFFE')) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='=')||(LA5_0>='?' && LA5_0<='\uFFFE')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:102:9: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(">>"); 


            		if ( getText().charAt(3)=='\n' && getText().charAt(getText().length()-3)=='\n' ) {
            			setText(getText().substring(3, getText().length()-3));
            		}
            		else {
            			setText(getText().substring(2, getText().length()-2));
            		}
            		

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ML_STRING

    // $ANTLR start STRING_ESC
    public final void mSTRING_ESC() throws RecognitionException {
        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:115:2: ( '\\\\\"' | '\\\\' ~ '\"' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\\') ) {
                int LA6_1 = input.LA(2);

                if ( ((LA6_1>='\u0000' && LA6_1<='!')||(LA6_1>='#' && LA6_1<='\uFFFE')) ) {
                    alt6=2;
                }
                else if ( (LA6_1=='\"') ) {
                    alt6=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("113:1: fragment STRING_ESC : ( '\\\\\"' | '\\\\' ~ '\"' );", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("113:1: fragment STRING_ESC : ( '\\\\\"' | '\\\\' ~ '\"' );", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:115:4: '\\\\\"'
                    {
                    match("\\\""); 


                    }
                    break;
                case 2 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:116:4: '\\\\' ~ '\"'
                    {
                    match('\\'); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end STRING_ESC

    // $ANTLR start ID
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:119:4: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:119:6: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:119:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ID

    // $ANTLR start EXT
    public final void mEXT() throws RecognitionException {
        try {
            int _type = EXT;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:121:5: ( '.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+ )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:121:7: '.' ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            {
            match('.'); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:121:10: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EXT

    // $ANTLR start RETVAL
    public final void mRETVAL() throws RecognitionException {
        try {
            int _type = RETVAL;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:123:8: ( NESTED_RETVAL )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:123:10: NESTED_RETVAL
            {
            mNESTED_RETVAL(); 
            setText(getText().substring(1, getText().length()-1));

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RETVAL

    // $ANTLR start NESTED_RETVAL
    public final void mNESTED_RETVAL() throws RecognitionException {
        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:127:15: ( '[' ( options {greedy=false; } : NESTED_RETVAL | . )* ']' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:128:2: '[' ( options {greedy=false; } : NESTED_RETVAL | . )* ']'
            {
            match('['); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:129:2: ( options {greedy=false; } : NESTED_RETVAL | . )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==']') ) {
                    alt9=3;
                }
                else if ( (LA9_0=='[') ) {
                    alt9=1;
                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='Z')||LA9_0=='\\'||(LA9_0>='^' && LA9_0<='\uFFFE')) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:130:4: NESTED_RETVAL
            	    {
            	    mNESTED_RETVAL(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:131:4: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match(']'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end NESTED_RETVAL

    // $ANTLR start AST
    public final void mAST() throws RecognitionException {
        try {
            int _type = AST;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:136:5: ( NESTED_AST )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:136:7: NESTED_AST
            {
            mNESTED_AST(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AST

    // $ANTLR start NESTED_AST
    public final void mNESTED_AST() throws RecognitionException {
        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:139:12: ( '(' ( options {greedy=false; } : NESTED_AST | . )* ')' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:140:2: '(' ( options {greedy=false; } : NESTED_AST | . )* ')'
            {
            match('('); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:141:2: ( options {greedy=false; } : NESTED_AST | . )*
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==')') ) {
                    alt10=3;
                }
                else if ( (LA10_0=='(') ) {
                    alt10=1;
                }
                else if ( ((LA10_0>='\u0000' && LA10_0<='\'')||(LA10_0>='*' && LA10_0<='\uFFFE')) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:142:4: NESTED_AST
            	    {
            	    mNESTED_AST(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:143:4: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            match(')'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end NESTED_AST

    // $ANTLR start ACTION
    public final void mACTION() throws RecognitionException {
        try {
            int _type = ACTION;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:149:2: ( NESTED_ACTION )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:149:4: NESTED_ACTION
            {
            mNESTED_ACTION(); 
            setText(getText().substring(1, getText().length()-1));

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ACTION

    // $ANTLR start NESTED_ACTION
    public final void mNESTED_ACTION() throws RecognitionException {
        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:153:15: ( '{' ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )* '}' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:154:2: '{' ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )* '}'
            {
            match('{'); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:155:2: ( options {greedy=false; k=3; } : NESTED_ACTION | STRING_LITERAL | CHAR_LITERAL | . )*
            loop11:
            do {
                int alt11=5;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='}') ) {
                    alt11=5;
                }
                else if ( (LA11_0=='{') ) {
                    alt11=1;
                }
                else if ( (LA11_0=='\"') ) {
                    int LA11_3 = input.LA(2);

                    if ( (LA11_3=='\\') ) {
                        int LA11_6 = input.LA(3);

                        if ( (LA11_6=='\"') ) {
                            alt11=2;
                        }
                        else if ( (LA11_6=='}') ) {
                            alt11=2;
                        }
                        else if ( (LA11_6=='\'') ) {
                            alt11=2;
                        }
                        else if ( (LA11_6=='{') ) {
                            alt11=2;
                        }
                        else if ( ((LA11_6>='\u0000' && LA11_6<='!')||(LA11_6>='#' && LA11_6<='&')||(LA11_6>='(' && LA11_6<='z')||LA11_6=='|'||(LA11_6>='~' && LA11_6<='\uFFFE')) ) {
                            alt11=2;
                        }


                    }
                    else if ( (LA11_3=='}') ) {
                        alt11=4;
                    }
                    else if ( (LA11_3=='{') ) {
                        int LA11_8 = input.LA(3);

                        if ( (LA11_8=='{') ) {
                            alt11=2;
                        }
                        else if ( (LA11_8=='\"') ) {
                            alt11=2;
                        }
                        else if ( (LA11_8=='\'') ) {
                            alt11=2;
                        }
                        else if ( (LA11_8=='}') ) {
                            alt11=2;
                        }
                        else if ( (LA11_8=='\\') ) {
                            alt11=2;
                        }
                        else if ( ((LA11_8>='\u0000' && LA11_8<='!')||(LA11_8>='#' && LA11_8<='&')||(LA11_8>='(' && LA11_8<='[')||(LA11_8>=']' && LA11_8<='z')||LA11_8=='|'||(LA11_8>='~' && LA11_8<='\uFFFE')) ) {
                            alt11=2;
                        }


                    }
                    else if ( (LA11_3=='\'') ) {
                        int LA11_9 = input.LA(3);

                        if ( (LA11_9=='\"') ) {
                            alt11=2;
                        }
                        else if ( (LA11_9=='\\') ) {
                            alt11=2;
                        }
                        else if ( (LA11_9=='}') ) {
                            alt11=2;
                        }
                        else if ( (LA11_9=='\'') ) {
                            alt11=2;
                        }
                        else if ( (LA11_9=='{') ) {
                            alt11=2;
                        }
                        else if ( ((LA11_9>='\u0000' && LA11_9<='!')||(LA11_9>='#' && LA11_9<='&')||(LA11_9>='(' && LA11_9<='[')||(LA11_9>=']' && LA11_9<='z')||LA11_9=='|'||(LA11_9>='~' && LA11_9<='\uFFFE')) ) {
                            alt11=2;
                        }


                    }
                    else if ( (LA11_3=='\"') ) {
                        alt11=4;
                    }
                    else if ( ((LA11_3>='\u0000' && LA11_3<='!')||(LA11_3>='#' && LA11_3<='&')||(LA11_3>='(' && LA11_3<='[')||(LA11_3>=']' && LA11_3<='z')||LA11_3=='|'||(LA11_3>='~' && LA11_3<='\uFFFE')) ) {
                        int LA11_11 = input.LA(3);

                        if ( (LA11_11=='\"') ) {
                            alt11=2;
                        }
                        else if ( (LA11_11=='\\') ) {
                            alt11=2;
                        }
                        else if ( (LA11_11=='}') ) {
                            alt11=2;
                        }
                        else if ( (LA11_11=='{') ) {
                            alt11=2;
                        }
                        else if ( (LA11_11=='\'') ) {
                            alt11=2;
                        }
                        else if ( ((LA11_11>='\u0000' && LA11_11<='!')||(LA11_11>='#' && LA11_11<='&')||(LA11_11>='(' && LA11_11<='[')||(LA11_11>=']' && LA11_11<='z')||LA11_11=='|'||(LA11_11>='~' && LA11_11<='\uFFFE')) ) {
                            alt11=2;
                        }


                    }


                }
                else if ( (LA11_0=='\'') ) {
                    int LA11_4 = input.LA(2);

                    if ( (LA11_4=='\\') ) {
                        int LA11_12 = input.LA(3);

                        if ( (LA11_12=='}') ) {
                            alt11=3;
                        }
                        else if ( (LA11_12=='\"') ) {
                            alt11=3;
                        }
                        else if ( (LA11_12=='\'') ) {
                            alt11=3;
                        }
                        else if ( (LA11_12=='{') ) {
                            alt11=3;
                        }
                        else if ( ((LA11_12>='\u0000' && LA11_12<='!')||(LA11_12>='#' && LA11_12<='&')||(LA11_12>='(' && LA11_12<='z')||LA11_12=='|'||(LA11_12>='~' && LA11_12<='\uFFFE')) ) {
                            alt11=3;
                        }


                    }
                    else if ( (LA11_4=='}') ) {
                        alt11=4;
                    }
                    else if ( (LA11_4=='{') ) {
                        int LA11_14 = input.LA(3);

                        if ( ((LA11_14>='\u0000' && LA11_14<='&')||(LA11_14>='(' && LA11_14<='\uFFFE')) ) {
                            alt11=4;
                        }
                        else if ( (LA11_14=='\'') ) {
                            alt11=3;
                        }


                    }
                    else if ( (LA11_4=='\"') ) {
                        int LA11_15 = input.LA(3);

                        if ( ((LA11_15>='\u0000' && LA11_15<='&')||(LA11_15>='(' && LA11_15<='\uFFFE')) ) {
                            alt11=4;
                        }
                        else if ( (LA11_15=='\'') ) {
                            alt11=3;
                        }


                    }
                    else if ( ((LA11_4>='\u0000' && LA11_4<='!')||(LA11_4>='#' && LA11_4<='&')||(LA11_4>='(' && LA11_4<='[')||(LA11_4>=']' && LA11_4<='z')||LA11_4=='|'||(LA11_4>='~' && LA11_4<='\uFFFE')) ) {
                        int LA11_16 = input.LA(3);

                        if ( (LA11_16=='\'') ) {
                            alt11=3;
                        }
                        else if ( ((LA11_16>='\u0000' && LA11_16<='&')||(LA11_16>='(' && LA11_16<='\uFFFE')) ) {
                            alt11=4;
                        }


                    }
                    else if ( (LA11_4=='\'') ) {
                        alt11=4;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='&')||(LA11_0>='(' && LA11_0<='z')||LA11_0=='|'||(LA11_0>='~' && LA11_0<='\uFFFE')) ) {
                    alt11=4;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:156:4: NESTED_ACTION
            	    {
            	    mNESTED_ACTION(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:157:4: STRING_LITERAL
            	    {
            	    mSTRING_LITERAL(); 

            	    }
            	    break;
            	case 3 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:158:4: CHAR_LITERAL
            	    {
            	    mCHAR_LITERAL(); 

            	    }
            	    break;
            	case 4 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:159:4: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match('}'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end NESTED_ACTION

    // $ANTLR start CHAR_LITERAL
    public final void mCHAR_LITERAL() throws RecognitionException {
        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:166:2: ( '\\'' ( ESC | ~ ( '\\\\' | '\\'' ) ) '\\'' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:166:4: '\\'' ( ESC | ~ ( '\\\\' | '\\'' ) ) '\\''
            {
            match('\''); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:166:9: ( ESC | ~ ( '\\\\' | '\\'' ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\\') ) {
                alt12=1;
            }
            else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFE')) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("166:9: ( ESC | ~ ( '\\\\' | '\\'' ) )", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:166:10: ESC
                    {
                    mESC(); 

                    }
                    break;
                case 2 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:166:14: ~ ( '\\\\' | '\\'' )
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            match('\''); 

            }

        }
        finally {
        }
    }
    // $ANTLR end CHAR_LITERAL

    // $ANTLR start STRING_LITERAL
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:171:2: ( '\"' ( ESC | ~ ( '\\\\' | '\"' ) )+ '\"' )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:171:4: '\"' ( ESC | ~ ( '\\\\' | '\"' ) )+ '\"'
            {
            match('\"'); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:171:8: ( ESC | ~ ( '\\\\' | '\"' ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\\') ) {
                    alt13=1;
                }
                else if ( ((LA13_0>='\u0000' && LA13_0<='!')||(LA13_0>='#' && LA13_0<='[')||(LA13_0>=']' && LA13_0<='\uFFFE')) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:171:9: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:171:13: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end STRING_LITERAL

    // $ANTLR start ESC
    public final void mESC() throws RecognitionException {
        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:176:2: ( '\\\\\\'' | '\\\\\"' | '\\\\' ~ ( '\\'' | '\"' ) )
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='\\') ) {
                int LA14_1 = input.LA(2);

                if ( ((LA14_1>='\u0000' && LA14_1<='!')||(LA14_1>='#' && LA14_1<='&')||(LA14_1>='(' && LA14_1<='\uFFFE')) ) {
                    alt14=3;
                }
                else if ( (LA14_1=='\"') ) {
                    alt14=2;
                }
                else if ( (LA14_1=='\'') ) {
                    alt14=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("174:1: fragment ESC : ( '\\\\\\'' | '\\\\\"' | '\\\\' ~ ( '\\'' | '\"' ) );", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("174:1: fragment ESC : ( '\\\\\\'' | '\\\\\"' | '\\\\' ~ ( '\\'' | '\"' ) );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:176:4: '\\\\\\''
                    {
                    match("\\\'"); 


                    }
                    break;
                case 2 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:177:4: '\\\\\"'
                    {
                    match("\\\""); 


                    }
                    break;
                case 3 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:178:4: '\\\\' ~ ( '\\'' | '\"' )
                    {
                    match('\\'); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFE') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end ESC

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:181:4: ( ( ' ' | '\\t' | ( '\\r' )? '\\n' )+ )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:181:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
            {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:181:6: ( ' ' | '\\t' | ( '\\r' )? '\\n' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=4;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt16=1;
                    }
                    break;
                case '\t':
                    {
                    alt16=2;
                    }
                    break;
                case '\n':
                case '\r':
                    {
                    alt16=3;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:181:8: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:182:5: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:183:5: ( '\\r' )? '\\n'
            	    {
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:183:5: ( '\\r' )?
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0=='\r') ) {
            	        alt15=1;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:183:5: '\\r'
            	            {
            	            match('\r'); 

            	            }
            	            break;

            	    }

            	    match('\n'); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    public void mTokens() throws RecognitionException {
        // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:8: ( T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | SL_COMMENT | ML_COMMENT | STRING | ML_STRING | ID | EXT | RETVAL | AST | ACTION | WS )
        int alt17=19;
        switch ( input.LA(1) ) {
        case 'g':
            {
            int LA17_1 = input.LA(2);

            if ( (LA17_1=='u') ) {
                int LA17_19 = input.LA(3);

                if ( (LA17_19=='n') ) {
                    int LA17_26 = input.LA(4);

                    if ( (LA17_26=='i') ) {
                        int LA17_31 = input.LA(5);

                        if ( (LA17_31=='t') ) {
                            int LA17_35 = input.LA(6);

                            if ( ((LA17_35>='0' && LA17_35<='9')||(LA17_35>='A' && LA17_35<='Z')||LA17_35=='_'||(LA17_35>='a' && LA17_35<='z')) ) {
                                alt17=14;
                            }
                            else {
                                alt17=1;}
                        }
                        else {
                            alt17=14;}
                    }
                    else {
                        alt17=14;}
                }
                else {
                    alt17=14;}
            }
            else {
                alt17=14;}
            }
            break;
        case 'w':
            {
            int LA17_2 = input.LA(2);

            if ( (LA17_2=='a') ) {
                int LA17_20 = input.LA(3);

                if ( (LA17_20=='l') ) {
                    int LA17_27 = input.LA(4);

                    if ( (LA17_27=='k') ) {
                        int LA17_32 = input.LA(5);

                        if ( (LA17_32=='s') ) {
                            int LA17_36 = input.LA(6);

                            if ( ((LA17_36>='0' && LA17_36<='9')||(LA17_36>='A' && LA17_36<='Z')||LA17_36=='_'||(LA17_36>='a' && LA17_36<='z')) ) {
                                alt17=14;
                            }
                            else {
                                alt17=2;}
                        }
                        else {
                            alt17=14;}
                    }
                    else {
                        alt17=14;}
                }
                else {
                    alt17=14;}
            }
            else {
                alt17=14;}
            }
            break;
        case ';':
            {
            alt17=3;
            }
            break;
        case '@':
            {
            alt17=4;
            }
            break;
        case ':':
            {
            alt17=5;
            }
            break;
        case 'O':
            {
            int LA17_6 = input.LA(2);

            if ( (LA17_6=='K') ) {
                int LA17_21 = input.LA(3);

                if ( ((LA17_21>='0' && LA17_21<='9')||(LA17_21>='A' && LA17_21<='Z')||LA17_21=='_'||(LA17_21>='a' && LA17_21<='z')) ) {
                    alt17=14;
                }
                else {
                    alt17=6;}
            }
            else {
                alt17=14;}
            }
            break;
        case 'F':
            {
            int LA17_7 = input.LA(2);

            if ( (LA17_7=='A') ) {
                int LA17_22 = input.LA(3);

                if ( (LA17_22=='I') ) {
                    int LA17_29 = input.LA(4);

                    if ( (LA17_29=='L') ) {
                        int LA17_33 = input.LA(5);

                        if ( ((LA17_33>='0' && LA17_33<='9')||(LA17_33>='A' && LA17_33<='Z')||LA17_33=='_'||(LA17_33>='a' && LA17_33<='z')) ) {
                            alt17=14;
                        }
                        else {
                            alt17=7;}
                    }
                    else {
                        alt17=14;}
                }
                else {
                    alt17=14;}
            }
            else {
                alt17=14;}
            }
            break;
        case 'r':
            {
            int LA17_8 = input.LA(2);

            if ( (LA17_8=='e') ) {
                int LA17_23 = input.LA(3);

                if ( (LA17_23=='t') ) {
                    int LA17_30 = input.LA(4);

                    if ( (LA17_30=='u') ) {
                        int LA17_34 = input.LA(5);

                        if ( (LA17_34=='r') ) {
                            int LA17_38 = input.LA(6);

                            if ( (LA17_38=='n') ) {
                                int LA17_41 = input.LA(7);

                                if ( (LA17_41=='s') ) {
                                    int LA17_42 = input.LA(8);

                                    if ( ((LA17_42>='0' && LA17_42<='9')||(LA17_42>='A' && LA17_42<='Z')||LA17_42=='_'||(LA17_42>='a' && LA17_42<='z')) ) {
                                        alt17=14;
                                    }
                                    else {
                                        alt17=8;}
                                }
                                else {
                                    alt17=14;}
                            }
                            else {
                                alt17=14;}
                        }
                        else {
                            alt17=14;}
                    }
                    else {
                        alt17=14;}
                }
                else {
                    alt17=14;}
            }
            else {
                alt17=14;}
            }
            break;
        case '-':
            {
            alt17=9;
            }
            break;
        case '/':
            {
            int LA17_10 = input.LA(2);

            if ( (LA17_10=='*') ) {
                alt17=11;
            }
            else if ( (LA17_10=='/') ) {
                alt17=10;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1:1: Tokens : ( T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | SL_COMMENT | ML_COMMENT | STRING | ML_STRING | ID | EXT | RETVAL | AST | ACTION | WS );", 17, 10, input);

                throw nvae;
            }
            }
            break;
        case '\"':
            {
            alt17=12;
            }
            break;
        case '<':
            {
            alt17=13;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'x':
        case 'y':
        case 'z':
            {
            alt17=14;
            }
            break;
        case '.':
            {
            alt17=15;
            }
            break;
        case '[':
            {
            alt17=16;
            }
            break;
        case '(':
            {
            alt17=17;
            }
            break;
        case '{':
            {
            alt17=18;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt17=19;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | SL_COMMENT | ML_COMMENT | STRING | ML_STRING | ID | EXT | RETVAL | AST | ACTION | WS );", 17, 0, input);

            throw nvae;
        }

        switch (alt17) {
            case 1 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:10: T22
                {
                mT22(); 

                }
                break;
            case 2 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:14: T23
                {
                mT23(); 

                }
                break;
            case 3 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:18: T24
                {
                mT24(); 

                }
                break;
            case 4 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:22: T25
                {
                mT25(); 

                }
                break;
            case 5 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:26: T26
                {
                mT26(); 

                }
                break;
            case 6 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:30: T27
                {
                mT27(); 

                }
                break;
            case 7 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:34: T28
                {
                mT28(); 

                }
                break;
            case 8 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:38: T29
                {
                mT29(); 

                }
                break;
            case 9 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:42: T30
                {
                mT30(); 

                }
                break;
            case 10 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:46: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 11 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:57: ML_COMMENT
                {
                mML_COMMENT(); 

                }
                break;
            case 12 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:68: STRING
                {
                mSTRING(); 

                }
                break;
            case 13 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:75: ML_STRING
                {
                mML_STRING(); 

                }
                break;
            case 14 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:85: ID
                {
                mID(); 

                }
                break;
            case 15 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:88: EXT
                {
                mEXT(); 

                }
                break;
            case 16 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:92: RETVAL
                {
                mRETVAL(); 

                }
                break;
            case 17 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:99: AST
                {
                mAST(); 

                }
                break;
            case 18 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:103: ACTION
                {
                mACTION(); 

                }
                break;
            case 19 :
                // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:1:110: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}