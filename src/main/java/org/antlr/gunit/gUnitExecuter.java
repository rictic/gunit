/*
 [The "BSD licence"]
 Copyright (c) 2007 Leon, Jen-Yuan Su
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.gunit;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.CommonGroupLoader;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.antlr.stringtemplate.StringTemplateGroupLoader;
import org.antlr.stringtemplate.language.DefaultTemplateLexer;

public class gUnitExecuter {
	public GrammarInfo grammarInfo;
	
	private int numOfTest;

	private int numOfSuccess;

	private int numOfFailure;

	private String title;

	private int numOfInvalidInput;

	private String parserName;

	private String lexerName;
	
	private List<AbstractTest> failures;
	private List<AbstractTest> invalids;
	
	public gUnitExecuter(GrammarInfo grammarInfo) {
		this.grammarInfo = grammarInfo;
		numOfTest = 0;
		numOfSuccess = 0;
		numOfFailure = 0;
		numOfInvalidInput = 0;
		failures = new ArrayList<AbstractTest>();
		invalids = new ArrayList<AbstractTest>();
	}
	
	public String execTest() throws IOException{
		// Set up string template for testing result
		StringTemplate testResultST = getTemplateGroup().getInstanceOf("testResult");
		try {
			/** Set up appropriate path for parser/lexer if using package */
			if (grammarInfo.getHeader()!=null ) {
				parserName = grammarInfo.getHeader()+"."+grammarInfo.getGrammarName()+"Parser";
				lexerName = grammarInfo.getHeader()+"."+grammarInfo.getGrammarName()+"Lexer";
			}
			else {
				parserName = grammarInfo.getGrammarName()+"Parser";
				lexerName = grammarInfo.getGrammarName()+"Lexer";
			}
			
			/*** Start Unit/Functional Testing ***/
			if ( grammarInfo.getTreeGrammarName()!=null ) {	// Execute unit test of for tree grammar
				title = "executing testsuite for tree grammar:"+grammarInfo.getTreeGrammarName()+" walks "+parserName;
				executeTests(true);
			}
			else {	// Execute unit test of for grammar
				title = "executing testsuite for grammar:"+grammarInfo.getGrammarName();
				executeTests(false);
			}	// End of exection of unit testing
			
			// Fill in the template holes with the test results
			testResultST.setAttribute("title", title);
			testResultST.setAttribute("num_of_test", numOfTest);
			testResultST.setAttribute("num_of_failure", numOfFailure);
			if ( numOfFailure>0 ) {
				testResultST.setAttribute("failure", failures);
			}
			if ( numOfInvalidInput>0 ) {
				testResultST.setAttribute("has_invalid", true);
				testResultST.setAttribute("num_of_invalid", numOfInvalidInput);
				testResultST.setAttribute("invalid", invalids);
			}
		}
		catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
		return testResultST.toString();
	}
	
	private StringTemplateGroup getTemplateGroup() {
		StringTemplateGroupLoader loader = new CommonGroupLoader("org/antlr/gunit", null);
		StringTemplateGroup.registerGroupLoader(loader);
		StringTemplateGroup.registerDefaultLexer(DefaultTemplateLexer.class);
		StringTemplateGroup group = StringTemplateGroup.loadGroup("gUnitTestResult");
		return group;
	}
	
	// TODO: throw more specific exceptions
	private gUnitTestResult runCorrectParser(String parserName, String lexerName, String rule, String treeRule, gUnitTestInput input) throws Exception
	{
		if (treeRule == null)
			return runParser(parserName, lexerName, rule, input);
		else
			return runTreeParser(parserName, lexerName, rule, treeRule, input);
	}

	private void executeTests(boolean isTreeTests) throws Exception {
		for ( gUnitTestSuite ts: grammarInfo.getRuleTestSuites() ) {
			String rule = ts.rule;
			String treeRule = null;
			if (isTreeTests) {
				treeRule = ts.treeRule;
			}
			for ( gUnitTestInput input: ts.testSuites.keySet() ) {	// each rule may contain multiple tests
				numOfTest++;
				// Run parser, and get the return value or stdout or stderr if there is
				gUnitTestResult result = null;
				AbstractTest test = ts.testSuites.get(input);
				try {
					result = runCorrectParser(parserName, lexerName, rule, treeRule, input);
				} catch ( InvalidInputException e) {
					numOfInvalidInput++;
					test.setHeader(rule, treeRule, numOfTest, input.getLine());
					test.setActual(input.testInput);
					invalids.add(test);
					continue;
				}
				
				String expected = test.getExpected();
				String actual = test.getResult(result);
				test.setActual(actual);
				
				if (actual == null) {
					numOfFailure++;
					test.setHeader(rule, treeRule, numOfTest, input.getLine());
					test.setActual("null");
					failures.add(test);
				}
				else if (expected.equals(actual)) {
					numOfSuccess++;
				}
				// TODO: something with ACTIONS - at least create action test type and throw exception.
				else if ( ts.testSuites.get(input).getType()==6 ) {	// expected Token: ACTION
					numOfFailure++;
					test.setHeader(rule, treeRule, numOfTest, input.getLine());
					test.setActual("\t"+"{ACTION} is not supported in the grammarInfo yet...");
					failures.add(test);
				}
				else {
					numOfFailure++;
					test.setHeader(rule, treeRule, numOfTest, input.getLine());
					failures.add(test);
				}
			}	// end of 2nd for-loop: tests for individual rule
		}	// end of 1st for-loop: testsuites for grammar
	}

	// TODO: throw proper exceptions
	protected gUnitTestResult runParser(String parserName, String lexerName, String testRuleName, gUnitTestInput testInput) throws Exception {
		CharStream input;
		/** Set up ANTLR input stream based on input source, file or String */
		if ( testInput.inputIsFile==true ) {
			input = new ANTLRFileStream(testInput.testInput);
		}
		else {
			input = new ANTLRStringStream(testInput.testInput);
		}
		Class lexer = null;
		Class parser = null;
        try {
            /** Use Reflection to create instances of lexer and parser */
        	lexer = Class.forName(lexerName);
            Class[] lexArgTypes = new Class[]{CharStream.class};				// assign type to lexer's args
            Constructor lexConstructor = lexer.getConstructor(lexArgTypes);        
            Object[] lexArgs = new Object[]{input};								// assign value to lexer's args   
            Object lexObj = lexConstructor.newInstance(lexArgs);				// makes new instance of lexer    
            
            CommonTokenStream tokens = new CommonTokenStream((Lexer) lexObj);
            
            parser = Class.forName(parserName);
            Class[] parArgTypes = new Class[]{TokenStream.class};				// assign type to parser's args
            Constructor parConstructor = parser.getConstructor(parArgTypes);
            Object[] parArgs = new Object[]{tokens};							// assign value to parser's args  
            Object parObj = parConstructor.newInstance(parArgs);				// makes new instance of parser      
            
            Method ruleName = parser.getMethod(testRuleName);
            
            /** Start of I/O Redirecting */
            PipedInputStream pipedIn = new PipedInputStream();
            PipedOutputStream pipedOut = new PipedOutputStream();
            PipedInputStream pipedErrIn = new PipedInputStream();
            PipedOutputStream pipedErrOut = new PipedOutputStream();
            try {
            	pipedOut.connect(pipedIn);
            	pipedErrOut.connect(pipedErrIn);
            }
            catch(IOException e) {
            	System.err.println("connection failed...");
            	System.exit(1);
            }
            PrintStream console = System.out;
            PrintStream consoleErr = System.err;
            PrintStream ps = new PrintStream(pipedOut);
            PrintStream ps2 = new PrintStream(pipedErrOut);
            System.setOut(ps);
            System.setErr(ps2);
            /** End of redirecting */

            /** Invoke grammar rule, and store if there is a return value */
            Object ruleReturn = ruleName.invoke(parObj);
            String astString = null;
            /** If rule has return value, determine if it's an AST */
            if ( ruleReturn!=null ) {
            	/** If return object is instanceof AST, get the toStringTree */
                if ( ruleReturn.toString().indexOf(testRuleName+"_return")>0 ) {
                	try {	// NullPointerException may happen here...
                		Class _return = Class.forName(parserName+"$"+testRuleName+"_return");
                		Method[] methods = _return.getDeclaredMethods();
                		for(Method method : methods) {
			                if ( method.getName().equals("getTree") ) {
			                	Method returnName = _return.getMethod("getTree");
		                    	CommonTree tree = (CommonTree) returnName.invoke(ruleReturn);
		                    	astString = tree.toStringTree();
			                }
			            }
                	}
                	catch(Exception e) {
                		System.err.println(e);
                	}
                }
            }
            
            /** Invalid input */
            if ( tokens.index()!=tokens.size() ) {
            	throw new InvalidInputException();
            }
            
            StreamVacuum stdoutVacuum = new StreamVacuum(pipedIn);
			StreamVacuum stderrVacuum = new StreamVacuum(pipedErrIn);
			ps.close();
			ps2.close();
			System.setOut(console);			// Reset standard output
			System.setErr(consoleErr);		// Reset standard err out
			stdoutVacuum.start();
			stderrVacuum.start();			
			stdoutVacuum.join();
			stderrVacuum.join();
			if ( stderrVacuum.toString().length()>0 ) {
				return new gUnitTestResult(false, stderrVacuum.toString());
			}
			String stdout = null;
			if ( stdoutVacuum.toString().length()>0 ) {
				stdout = stdoutVacuum.toString();
			}
			if ( astString!=null ) {	// Return toStringTree of AST
				return new gUnitTestResult(true, stdout, astString);
			}
			
			if ( ruleReturn!=null ) {
				// TODO: this is probably a work around to a bug in converting to an AST tree.
				return new gUnitTestResult(true, stdout, String.valueOf(ruleReturn));
			}
			return new gUnitTestResult(true, stdout, stdout);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); System.exit(1);
        } catch (SecurityException e) {
            e.printStackTrace(); System.exit(1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace(); System.exit(1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); System.exit(1);
        } catch (InstantiationException e) {
            e.printStackTrace(); System.exit(1);
        } catch (IllegalAccessException e) {
            e.printStackTrace(); System.exit(1);
        } catch (InvocationTargetException e) {
            e.printStackTrace(); System.exit(1);
        } catch (InterruptedException e) {
			e.printStackTrace(); System.exit(1);
		}
        // TODO: verify this:
        throw new Exception("This should be unreachable?");
	}
	
	protected gUnitTestResult runTreeParser(String parserName, String lexerName, String testRuleName, String testTreeRuleName, gUnitTestInput testInput) throws Exception {
		CharStream input;
		String treeParserPath;
		/** Set up ANTLR input stream based on input source, file or String */
		if ( testInput.inputIsFile==true ) {
			input = new ANTLRFileStream(testInput.testInput);
		}
		else {
			input = new ANTLRStringStream(testInput.testInput);
		}
		/** Set up appropriate path for tree parser if using package */
		if ( grammarInfo.getHeader()!=null ) {
			treeParserPath = grammarInfo.getHeader()+"."+grammarInfo.getTreeGrammarName();
		}
		else {
			treeParserPath = grammarInfo.getTreeGrammarName();
		}
		Class lexer = null;
		Class parser = null;
		Class treeParser = null;
        try {
            /** Use Reflection to create instances of lexer and parser */
        	lexer = Class.forName(lexerName);
            Class[] lexArgTypes = new Class[]{CharStream.class};				// assign type to lexer's args
            Constructor lexConstructor = lexer.getConstructor(lexArgTypes);        
            Object[] lexArgs = new Object[]{input};								// assign value to lexer's args   
            Object lexObj = lexConstructor.newInstance(lexArgs);				// makes new instance of lexer    
            
            CommonTokenStream tokens = new CommonTokenStream((Lexer) lexObj);
            
            parser = Class.forName(parserName);
            Class[] parArgTypes = new Class[]{TokenStream.class};				// assign type to parser's args
            Constructor parConstructor = parser.getConstructor(parArgTypes);
            Object[] parArgs = new Object[]{tokens};							// assign value to parser's args  
            Object parObj = parConstructor.newInstance(parArgs);				// makes new instance of parser      
            
            Method ruleName = parser.getMethod(testRuleName);

            /** Start of I/O Redirecting */
            PipedInputStream pipedIn = new PipedInputStream();
            PipedOutputStream pipedOut = new PipedOutputStream();
            PipedInputStream pipedErrIn = new PipedInputStream();
            PipedOutputStream pipedErrOut = new PipedOutputStream();
            try {
            	pipedOut.connect(pipedIn);
            	pipedErrOut.connect(pipedErrIn);
            }
            catch(IOException e) {
            	System.err.println("connection failed...");
            	System.exit(1);
            }
            PrintStream console = System.out;
            PrintStream consoleErr = System.err;
            PrintStream ps = new PrintStream(pipedOut);
            PrintStream ps2 = new PrintStream(pipedErrOut);
            System.setOut(ps);
            System.setErr(ps2);
            /** End of redirecting */

            /** Invoke grammar rule, and get the return value */
            Object ruleReturn = ruleName.invoke(parObj);
            
            Class _return = Class.forName(parserName+"$"+testRuleName+"_return");            	
        	Method returnName = _return.getMethod("getTree");
        	CommonTree tree = (CommonTree) returnName.invoke(ruleReturn);

        	// Walk resulting tree; create tree nodes stream first
        	CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        	// AST nodes have payload that point into token stream
        	nodes.setTokenStream(tokens);
        	// Create a tree walker attached to the nodes stream
        	treeParser = Class.forName(treeParserPath);
            Class[] treeParArgTypes = new Class[]{TreeNodeStream.class};		// assign type to tree parser's args
            Constructor treeParConstructor = treeParser.getConstructor(treeParArgTypes);
            Object[] treeParArgs = new Object[]{nodes};							// assign value to tree parser's args  
            Object treeParObj = treeParConstructor.newInstance(treeParArgs);	// makes new instance of tree parser      
        	// Invoke the tree rule, and store the return value if there is
            Method treeRuleName = treeParser.getMethod(testTreeRuleName);
            Object treeRuleReturn = treeRuleName.invoke(treeParObj);

            String astString = null;
            /** If tree rule has return value, determine if it's an AST */
            if ( treeRuleReturn!=null ) {
            	/** If return object is instanceof AST, get the toStringTree */
                if ( treeRuleReturn.toString().indexOf(testTreeRuleName+"_return")>0 ) {
                	try {	// NullPointerException may happen here...
                		Class _treeReturn = Class.forName(treeParserPath+"$"+testTreeRuleName+"_return");
                		Method[] methods = _treeReturn.getDeclaredMethods();
			            for(Method method : methods) {
			                if ( method.getName().equals("getTree") ) {
			                	Method treeReturnName = _treeReturn.getMethod("getTree");
		                    	CommonTree returnTree = (CommonTree) treeReturnName.invoke(treeRuleReturn);
		                        astString = returnTree.toStringTree();
			                }
			            }
                	}
                	catch(Exception e) {
                		System.err.println(e);
                	}
                }
            }
          
            /** Invalid input */
            if ( tokens.index()!=tokens.size() ) {
            	throw new InvalidInputException();
            }

            StreamVacuum stdoutVacuum = new StreamVacuum(pipedIn);
			StreamVacuum stderrVacuum = new StreamVacuum(pipedErrIn);
			ps.close();
			ps2.close();
			System.setOut(console);			// Reset standard output
			System.setErr(consoleErr);		// Reset standard err out
			stdoutVacuum.start();
			stderrVacuum.start();			
			stdoutVacuum.join();
			stderrVacuum.join();
			if ( stderrVacuum.toString().length()>0 ) {
				return new gUnitTestResult(false, stderrVacuum.toString());
			}
			
			String stdout = null;
			if ( stdoutVacuum.toString().length()>0 ) {
				stdout = stdoutVacuum.toString();
			}
			if ( astString!=null ) {	// Return toStringTree of AST
				return new gUnitTestResult(true, stdout, astString);
			}
			if ( treeRuleReturn!=null ) {
				// TODO: again, probably a work around to a bug in converting to astString
				return new gUnitTestResult(true, stdout, String.valueOf(treeRuleReturn));
			}
			return new gUnitTestResult(true, stdout, stdout);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); System.exit(1);
        } catch (SecurityException e) {
            e.printStackTrace(); System.exit(1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace(); System.exit(1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace(); System.exit(1);
        } catch (InstantiationException e) {
            e.printStackTrace(); System.exit(1);
        } catch (IllegalAccessException e) {
            e.printStackTrace(); System.exit(1);
        } catch (InvocationTargetException e) {
            e.printStackTrace(); System.exit(1);
        } catch (InterruptedException e) {
			e.printStackTrace(); System.exit(1);
		}
        // TODO: verify this:
        throw new Exception("Should not be reachable?");
	}

	public static class StreamVacuum implements Runnable {
		StringBuffer buf = new StringBuffer();
		BufferedReader in;
		Thread sucker;
		public StreamVacuum(InputStream in) {
			this.in = new BufferedReader( new InputStreamReader(in) );
		}
		public void start() {
			sucker = new Thread(this);
			sucker.start();
		}
		public void run() {
			try {
				String line = in.readLine();
				while (line!=null) {
					buf.append(line);
					buf.append('\n');
					line = in.readLine();
				}
			}
			catch (IOException ioe) {
				System.err.println("can't read output from standard (error) output");
			}
		}
		/** wait for the thread to finish */
		public void join() throws InterruptedException {
			sucker.join();
		}
		public String toString() {
			return buf.toString();
		}
	}
}
