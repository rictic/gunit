// $ANTLR 3.0 /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g 2007-08-18 23:04:40
package org.antlr.gunit;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class gUnitParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DOC_COMMENT", "ID", "ACTION", "RETVAL", "STRING", "ML_STRING", "AST", "EXT", "SL_COMMENT", "ML_COMMENT", "STRING_ESC", "NESTED_RETVAL", "NESTED_AST", "NESTED_ACTION", "STRING_LITERAL", "CHAR_LITERAL", "ESC", "WS", "'gunit'", "'walks'", "';'", "'@header'", "':'", "'OK'", "'FAIL'", "'returns'", "'->'"
    };
    public static final int RETVAL=7;
    public static final int AST=10;
    public static final int NESTED_ACTION=17;
    public static final int EXT=11;
    public static final int STRING_ESC=14;
    public static final int WS=21;
    public static final int STRING=8;
    public static final int ACTION=6;
    public static final int ESC=20;
    public static final int NESTED_AST=16;
    public static final int CHAR_LITERAL=19;
    public static final int EOF=-1;
    public static final int STRING_LITERAL=18;
    public static final int ML_STRING=9;
    public static final int ML_COMMENT=13;
    public static final int SL_COMMENT=12;
    public static final int DOC_COMMENT=4;
    public static final int ID=5;
    public static final int NESTED_RETVAL=15;

        public gUnitParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g"; }


    public Interp interpreter;
    public gUnitParser(TokenStream input, Interp interpreter) {
    	super(input);
    	this.interpreter = interpreter;
    }



    // $ANTLR start gUnitDef
    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:16:1: gUnitDef : 'gunit' g1= ID ( 'walks' g2= ID )? ';' ( header )? ( suite )+ ;
    public final void gUnitDef() throws RecognitionException {
        Token g1=null;
        Token g2=null;

        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:16:9: ( 'gunit' g1= ID ( 'walks' g2= ID )? ';' ( header )? ( suite )+ )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:16:11: 'gunit' g1= ID ( 'walks' g2= ID )? ';' ( header )? ( suite )+
            {
            match(input,22,FOLLOW_22_in_gUnitDef42); 
            g1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_gUnitDef46); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:16:25: ( 'walks' g2= ID )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==23) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:16:26: 'walks' g2= ID
                    {
                    match(input,23,FOLLOW_23_in_gUnitDef49); 
                    g2=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_gUnitDef53); 

                    }
                    break;

            }

            match(input,24,FOLLOW_24_in_gUnitDef57); 

            		if ( g2!=null ) {
            			interpreter.grammarName = g2.getText();
            			interpreter.treeGrammarName = g1.getText();
            		}
            		else {
            			interpreter.grammarName = g1.getText();
            		}
            		
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:26:3: ( header )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:26:3: header
                    {
                    pushFollow(FOLLOW_header_in_gUnitDef66);
                    header();
                    _fsp--;


                    }
                    break;

            }

            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:26:11: ( suite )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:26:11: suite
            	    {
            	    pushFollow(FOLLOW_suite_in_gUnitDef69);
            	    suite();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end gUnitDef


    // $ANTLR start header
    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:28:1: header : '@header' ACTION ;
    public final void header() throws RecognitionException {
        Token ACTION1=null;

        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:28:8: ( '@header' ACTION )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:28:10: '@header' ACTION
            {
            match(input,25,FOLLOW_25_in_header79); 
            ACTION1=(Token)input.LT(1);
            match(input,ACTION,FOLLOW_ACTION_in_header81); 

            		int pos1; int pos2;
            		if ( (pos1=ACTION1.getText().indexOf("package"))!=-1 && (pos2=ACTION1.getText().indexOf(';'))!=-1 ) {
            			interpreter.header = ACTION1.getText().substring(pos1+8, pos2);
            		}
            		

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end header


    // $ANTLR start suite
    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:37:1: suite : r1= ID ( 'walks' r2= ID )? ':' ( test[ts] )+ ;
    public final void suite() throws RecognitionException {
        Token r1=null;
        Token r2=null;

        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:37:7: (r1= ID ( 'walks' r2= ID )? ':' ( test[ts] )+ )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:37:9: r1= ID ( 'walks' r2= ID )? ':' ( test[ts] )+
            {
            r1=(Token)input.LT(1);
            match(input,ID,FOLLOW_ID_in_suite99); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:37:15: ( 'walks' r2= ID )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:37:16: 'walks' r2= ID
                    {
                    match(input,23,FOLLOW_23_in_suite102); 
                    r2=(Token)input.LT(1);
                    match(input,ID,FOLLOW_ID_in_suite106); 

                    }
                    break;

            }

            match(input,26,FOLLOW_26_in_suite110); 

            		gUnitTestSuite ts = null;
            		if ( r2!=null ) {
            			ts = new gUnitTestSuite(r1.getText(), r2.getText());
            		}
            		else {
            			ts = new gUnitTestSuite(r1.getText());
            		}
            		
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:47:3: ( test[ts] )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID) ) {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2==EXT||(LA5_2>=27 && LA5_2<=30)) ) {
                        alt5=1;
                    }


                }
                else if ( ((LA5_0>=STRING && LA5_0<=ML_STRING)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:47:3: test[ts]
            	    {
            	    pushFollow(FOLLOW_test_in_suite120);
            	    test(ts);
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            interpreter.ruleTestSuites.add(ts);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end suite


    // $ANTLR start test
    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:49:1: test[gUnitTestSuite ts] : ( input ok= 'OK' | input fail= 'FAIL' | input 'returns' RETVAL | input '->' output );
    public final void test(gUnitTestSuite ts) throws RecognitionException {
        Token ok=null;
        Token fail=null;
        Token RETVAL5=null;
        input_return input2 = null;

        input_return input3 = null;

        input_return input4 = null;

        input_return input6 = null;

        Token output7 = null;


        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:50:2: ( input ok= 'OK' | input fail= 'FAIL' | input 'returns' RETVAL | input '->' output )
            int alt6=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                switch ( input.LA(2) ) {
                case 29:
                    {
                    alt6=3;
                    }
                    break;
                case 30:
                    {
                    alt6=4;
                    }
                    break;
                case 27:
                    {
                    alt6=1;
                    }
                    break;
                case 28:
                    {
                    alt6=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("49:1: test[gUnitTestSuite ts] : ( input ok= 'OK' | input fail= 'FAIL' | input 'returns' RETVAL | input '->' output );", 6, 1, input);

                    throw nvae;
                }

                }
                break;
            case ML_STRING:
                {
                switch ( input.LA(2) ) {
                case 29:
                    {
                    alt6=3;
                    }
                    break;
                case 30:
                    {
                    alt6=4;
                    }
                    break;
                case 27:
                    {
                    alt6=1;
                    }
                    break;
                case 28:
                    {
                    alt6=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("49:1: test[gUnitTestSuite ts] : ( input ok= 'OK' | input fail= 'FAIL' | input 'returns' RETVAL | input '->' output );", 6, 2, input);

                    throw nvae;
                }

                }
                break;
            case ID:
                {
                switch ( input.LA(2) ) {
                case EXT:
                    {
                    switch ( input.LA(3) ) {
                    case 28:
                        {
                        alt6=2;
                        }
                        break;
                    case 29:
                        {
                        alt6=3;
                        }
                        break;
                    case 27:
                        {
                        alt6=1;
                        }
                        break;
                    case 30:
                        {
                        alt6=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("49:1: test[gUnitTestSuite ts] : ( input ok= 'OK' | input fail= 'FAIL' | input 'returns' RETVAL | input '->' output );", 6, 8, input);

                        throw nvae;
                    }

                    }
                    break;
                case 28:
                    {
                    alt6=2;
                    }
                    break;
                case 27:
                    {
                    alt6=1;
                    }
                    break;
                case 30:
                    {
                    alt6=4;
                    }
                    break;
                case 29:
                    {
                    alt6=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("49:1: test[gUnitTestSuite ts] : ( input ok= 'OK' | input fail= 'FAIL' | input 'returns' RETVAL | input '->' output );", 6, 3, input);

                    throw nvae;
                }

                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("49:1: test[gUnitTestSuite ts] : ( input ok= 'OK' | input fail= 'FAIL' | input 'returns' RETVAL | input '->' output );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:50:4: input ok= 'OK'
                    {
                    pushFollow(FOLLOW_input_in_test135);
                    input2=input();
                    _fsp--;

                    ok=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_test139); 
                    ts.testSuites.put(new gUnitTestInput(input2.testInput, input2.inputIsFile), ok);

                    }
                    break;
                case 2 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:51:4: input fail= 'FAIL'
                    {
                    pushFollow(FOLLOW_input_in_test146);
                    input3=input();
                    _fsp--;

                    fail=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_test150); 
                    ts.testSuites.put(new gUnitTestInput(input3.testInput, input3.inputIsFile), fail);

                    }
                    break;
                case 3 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:52:4: input 'returns' RETVAL
                    {
                    pushFollow(FOLLOW_input_in_test157);
                    input4=input();
                    _fsp--;

                    match(input,29,FOLLOW_29_in_test159); 
                    RETVAL5=(Token)input.LT(1);
                    match(input,RETVAL,FOLLOW_RETVAL_in_test161); 
                    ts.testSuites.put(new gUnitTestInput(input4.testInput, input4.inputIsFile), RETVAL5);

                    }
                    break;
                case 4 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:53:4: input '->' output
                    {
                    pushFollow(FOLLOW_input_in_test168);
                    input6=input();
                    _fsp--;

                    match(input,30,FOLLOW_30_in_test170); 
                    pushFollow(FOLLOW_output_in_test172);
                    output7=output();
                    _fsp--;

                    ts.testSuites.put(new gUnitTestInput(input6.testInput, input6.inputIsFile), output7);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end test

    public static class input_return extends ParserRuleReturnScope {
        public String testInput;
        public boolean inputIsFile;
    };

    // $ANTLR start input
    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:56:1: input returns [String testInput, boolean inputIsFile] : ( STRING | ML_STRING | file );
    public final input_return input() throws RecognitionException {
        input_return retval = new input_return();
        retval.start = input.LT(1);

        Token STRING8=null;
        Token ML_STRING9=null;
        file_return file10 = null;


        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:57:2: ( STRING | ML_STRING | file )
            int alt7=3;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt7=1;
                }
                break;
            case ML_STRING:
                {
                alt7=2;
                }
                break;
            case ID:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("56:1: input returns [String testInput, boolean inputIsFile] : ( STRING | ML_STRING | file );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:57:4: STRING
                    {
                    STRING8=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_input189); 

                    		retval.testInput =STRING8.getText().replace("\\n", "\n").replace("\\t", "\t").replace("\\r", "\r");
                    		retval.inputIsFile =false;
                    		

                    }
                    break;
                case 2 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:62:4: ML_STRING
                    {
                    ML_STRING9=(Token)input.LT(1);
                    match(input,ML_STRING,FOLLOW_ML_STRING_in_input199); 

                    		retval.testInput =ML_STRING9.getText();
                    		retval.inputIsFile =false;
                    		

                    }
                    break;
                case 3 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:67:4: file
                    {
                    pushFollow(FOLLOW_file_in_input208);
                    file10=file();
                    _fsp--;


                    		retval.testInput =input.toString(file10.start,file10.stop);
                    		retval.inputIsFile =true;
                    		

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end input


    // $ANTLR start output
    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:74:1: output returns [Token token] : ( STRING | ML_STRING | AST | ACTION );
    public final Token output() throws RecognitionException {
        Token token = null;

        Token STRING11=null;
        Token ML_STRING12=null;
        Token AST13=null;
        Token ACTION14=null;

        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:75:2: ( STRING | ML_STRING | AST | ACTION )
            int alt8=4;
            switch ( input.LA(1) ) {
            case STRING:
                {
                alt8=1;
                }
                break;
            case ML_STRING:
                {
                alt8=2;
                }
                break;
            case AST:
                {
                alt8=3;
                }
                break;
            case ACTION:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("74:1: output returns [Token token] : ( STRING | ML_STRING | AST | ACTION );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:75:4: STRING
                    {
                    STRING11=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_output227); 

                    		STRING11.setText(STRING11.getText().replace("\\n", "\n").replace("\\t", "\t").replace("\\r", "\r"));
                    		token =STRING11;
                    		

                    }
                    break;
                case 2 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:80:4: ML_STRING
                    {
                    ML_STRING12=(Token)input.LT(1);
                    match(input,ML_STRING,FOLLOW_ML_STRING_in_output237); 
                    token =ML_STRING12;

                    }
                    break;
                case 3 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:81:4: AST
                    {
                    AST13=(Token)input.LT(1);
                    match(input,AST,FOLLOW_AST_in_output244); 
                    token =AST13;

                    }
                    break;
                case 4 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:82:4: ACTION
                    {
                    ACTION14=(Token)input.LT(1);
                    match(input,ACTION,FOLLOW_ACTION_in_output251); 
                    token =ACTION14;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return token;
    }
    // $ANTLR end output

    public static class file_return extends ParserRuleReturnScope {
    };

    // $ANTLR start file
    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:85:1: file : ID ( EXT )? ;
    public final file_return file() throws RecognitionException {
        file_return retval = new file_return();
        retval.start = input.LT(1);

        try {
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:85:6: ( ID ( EXT )? )
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:85:8: ID ( EXT )?
            {
            match(input,ID,FOLLOW_ID_in_file263); 
            // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:85:11: ( EXT )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==EXT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /Users/leonsu/Documents/Java Codes/Summer Project/org/antlr/gunit/gUnit.g:85:11: EXT
                    {
                    match(input,EXT,FOLLOW_EXT_in_file265); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end file


 

    public static final BitSet FOLLOW_22_in_gUnitDef42 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_gUnitDef46 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_gUnitDef49 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_gUnitDef53 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_gUnitDef57 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_header_in_gUnitDef66 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_suite_in_gUnitDef69 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_25_in_header79 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ACTION_in_header81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_suite99 = new BitSet(new long[]{0x0000000004800000L});
    public static final BitSet FOLLOW_23_in_suite102 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_suite106 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_suite110 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_test_in_suite120 = new BitSet(new long[]{0x0000000000000322L});
    public static final BitSet FOLLOW_input_in_test135 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_test139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_input_in_test146 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_test150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_input_in_test157 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_test159 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RETVAL_in_test161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_input_in_test168 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_test170 = new BitSet(new long[]{0x0000000000000740L});
    public static final BitSet FOLLOW_output_in_test172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_input189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ML_STRING_in_input199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_file_in_input208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_output227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ML_STRING_in_output237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AST_in_output244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_output251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_file263 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_EXT_in_file265 = new BitSet(new long[]{0x0000000000000002L});

}