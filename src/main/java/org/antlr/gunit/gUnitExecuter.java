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
	
	public int numOfTest;

	public int numOfSuccess;

	public int numOfFailure;

	private String title;

	public int numOfInvalidInput;

	private String parserName;

	private String lexerName;
	
	public List<AbstractTest> failures;
	public List<AbstractTest> invalids;
	
	public gUnitExecuter(GrammarInfo grammarInfo) {
		this.grammarInfo = grammarInfo;
		numOfTest = 0;
		numOfSuccess = 0;
		numOfFailure = 0;
		numOfInvalidInput = 0;
		failures = new ArrayList<AbstractTest>();
		invalids = new ArrayList<AbstractTest>();
	}
	
	public String execTest() throws IOException {
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
	private gUnitTestResult runCorrectParser(String parserName, String lexerName, String rule, String treeRule, gUnitTestInput input) throws IOException, InvalidInputException {
		if (treeRule == null)
			return runParser(parserName, lexerName, rule, input);
		else
			return runTreeParser(parserName, lexerName, rule, treeRule, input);
	}

	private void executeTests(boolean isTreeTests) throws IOException  {
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
	protected gUnitTestResult runParser(String parserName, String lexerName, String testRuleName, gUnitTestInput testInput) throws IOException, InvalidInputException {
		CharStream input = testInput.getInputStream();
        try {
            /** Use Reflection to create instances of lexer and parser */
        	Class<Lexer> lexer = (Class<Lexer>)Class.forName(lexerName);
        	Lexer lexObj = makeLexer(lexer, input);
            CommonTokenStream tokens = new CommonTokenStream(lexObj);            
            Class parser = Class.forName(parserName);
            Object parObj = makeParser(parser, tokens);

            Method ruleName = parser.getMethod(testRuleName);
            
            RedirectedIO subIO = new RedirectedIO();
            subIO.beginRedirecting();

            /** Invoke grammar rule, and store if there is a return value */
            Object ruleReturn = ruleName.invoke(parObj);
            String astString = null;
            /** If rule has return value, determine if it's an AST */
            if ( ruleReturn!=null ) {
            	/** If return object is instanceof AST, get the toStringTree */
                if ( ruleReturn.toString().indexOf(testRuleName+"_return")>0 ) {
                	try {	// NullPointerException may happen here...
                		Class _return = Class.forName(parserName+"$"+testRuleName+"_return");
                		CommonTree tree = (CommonTree)_return.getMethod("getTree").invoke(ruleReturn);
                		astString = tree.toString();
                	}
                	catch(Exception e) {
                		System.err.println(e);
                	}
                }
            }
            astString = getAstString(ruleReturn, testRuleName);
            
            /** Invalid input */
            if ( tokens.index()!=tokens.size() ) {
            	throw new InvalidInputException();
            }
            
            subIO.restore();
            
            String errorOutput = subIO.getErr();
            String output = subIO.getOutput();
            
            
            
			if ( errorOutput.length()>0 ) {
				return new gUnitTestResult(false, errorOutput);
			}
			String stdout = null;
			if ( output.length()>0 ) {
				stdout = output;
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
        }
        
        // TODO: verify this:
        throw new RuntimeException("This should be unreachable?");
	}
	
	

	protected gUnitTestResult runTreeParser(String parserName, String lexerName, String testRuleName, String testTreeRuleName, gUnitTestInput testInput) throws IOException, InvalidInputException  {
		CharStream input = testInput.getInputStream();
		String treeParserPath;
		/** Set up appropriate path for tree parser if using package */
		if ( grammarInfo.getHeader()!=null ) {
			treeParserPath = grammarInfo.getHeader()+"."+grammarInfo.getTreeGrammarName();
		}
		else {
			treeParserPath = grammarInfo.getTreeGrammarName();
		}
		
		try {
            /** Use Reflection to create instances of lexer and parser */
        	Class<Lexer> lexer = (Class<Lexer>)Class.forName(lexerName);
			Lexer lexObj = makeLexer(lexer, input);
            CommonTokenStream tokens = new CommonTokenStream(lexObj);            
            Class parser = Class.forName(parserName);
            Object parObj = makeParser(parser, tokens);      
            
            Method ruleName = parser.getMethod(testRuleName);

            RedirectedIO subIO = new RedirectedIO();
            subIO.beginRedirecting();
            

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
        	Class treeParser = Class.forName(treeParserPath);
            Object treeParObj = makeTreeParser(treeParser,nodes);	// makes new instance of tree parser      
        	// Invoke the tree rule, and store the return value if there is
            Method treeRuleName = treeParser.getMethod(testTreeRuleName);
            Object treeRuleReturn = treeRuleName.invoke(treeParObj);

            String astString = null;
            /** If tree rule has return value, determine if it's an AST */
            astString = getAstString(ruleReturn, testRuleName);
            
            
            /** Invalid input */
            if ( tokens.index()!=tokens.size() ) {
            	throw new InvalidInputException();
            }

            subIO.restore();
            String errorOutput = subIO.getErr();
            String output = subIO.getOutput();
            
            if ( errorOutput.length()>0 ) {
				return new gUnitTestResult(false, errorOutput);
			}
			
			String stdout = null;
			if ( output.length()>0 ) {
				stdout = output;
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
        }
        // TODO: verify this:
        throw new RuntimeException("Should not be reachable?");
	}

	//constraints elsewhere force the Lexer tested to subclass Antlr's Lexer class, is there
	//any time in which we would want to allow testing Parsers and TreeParsers which don't
	//subclass antlr's Parser and TreeParser classes?

	private Lexer makeLexer(Class<Lexer> lexer, CharStream input) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		return instantiateClass(lexer, input, CharStream.class);
	}
	
	private Object makeParser(Class parser, CommonTokenStream tokens) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return instantiateClass(parser, new Object[]{tokens}, new Class[]{TokenStream.class});
	}
	
	private Object makeTreeParser(Class treeparser, CommonTreeNodeStream nodes) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException{
        return instantiateClass(treeparser, nodes, TreeNodeStream.class);
	}
	
	private <T> T instantiateClass(Class<T> klass, Object[] constructorArgs, Class[] argClasses) throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		Constructor<T> klassConstructor = klass.getConstructor(argClasses);
		return klassConstructor.newInstance(constructorArgs);
	}
	
	private <T> T instantiateClass(Class<T> klass, Object constructorArg, Class argClass) throws SecurityException, IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException{
		return instantiateClass(klass, new Object[]{constructorArg}, new Class[]{argClass});
	}
	
	/** If tree rule has return value, determine if it's an AST */
	private String getAstString(Object ruleReturn, String testRuleName) {
		if ( ruleReturn!=null ) {
        	/** If return object is instanceof AST, get the toStringTree */
            if ( ruleReturn.toString().indexOf(testRuleName+"_return")>0 ) {
            	try {	// NullPointerException may happen here...
            		Class _return = Class.forName(parserName+"$"+testRuleName+"_return");
            		CommonTree tree = (CommonTree)_return.getMethod("getTree").invoke(ruleReturn);
            		return tree.toString();
            	}
            	catch(Exception e) {
            		System.err.println(e);
            	}
            }
        }
		return null;
	}
}
