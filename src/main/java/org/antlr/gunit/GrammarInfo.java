package org.antlr.gunit;

import java.util.ArrayList;
import java.util.List;

public class GrammarInfo {

	protected String grammarName;				// targeted grammar for unit test
	protected String treeGrammarName = null;	// optional, required for testing tree grammar
	protected String header = null;				// optional, required if using java package
	protected List<gUnitTestSuite> ruleTestSuites = new ArrayList<gUnitTestSuite>();	// testsuites for each testing rule
	protected StringBuffer unitTestResult = new StringBuffer();
}
