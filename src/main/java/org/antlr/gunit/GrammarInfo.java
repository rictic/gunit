package org.antlr.gunit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GrammarInfo {

	private String grammarName;					// targeted grammar for unit test
	private String treeGrammarName = null;	// optional, required for testing tree grammar
	private String header = null;				// optional, required if using java package
	private List<gUnitTestSuite> ruleTestSuites = new ArrayList<gUnitTestSuite>();	// testsuites for each testing rule
	private StringBuffer unitTestResult = new StringBuffer();
	
	public String getGrammarName() {
		return grammarName;
	}
	
	public void setGrammarName(String grammarName) {
		this.grammarName = grammarName;
	}

	public String getTreeGrammarName() {
		return treeGrammarName;
	}

	public void setTreeGrammarName(String treeGrammarName) {
		this.treeGrammarName = treeGrammarName;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<gUnitTestSuite> getRuleTestSuites() {
		// Make this list unmodifiable so that we can refactor knowing it's not changed.
		return Collections.unmodifiableList(ruleTestSuites);
	}
	
	public void addRuleTestSuite(gUnitTestSuite testSuite) {
		this.ruleTestSuites.add(testSuite);
	}
	
	public void appendUnitTestResult(String result) {
		this.unitTestResult.append(result);
	}

	// We don't want people messing with the string buffer here, so don't return it.
	public String getUnitTestResult() {
		return unitTestResult.toString();
	}

	public void setUnitTestResult(StringBuffer unitTestResult) {
		this.unitTestResult = unitTestResult;
	}
}
