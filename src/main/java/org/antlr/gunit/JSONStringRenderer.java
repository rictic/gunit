package org.antlr.gunit;

import org.antlr.stringtemplate.AttributeRenderer;

public class JSONStringRenderer implements AttributeRenderer {

	public String toString(Object obj) {
		if (obj == null) return "null";
		if (obj instanceof String){
			String s = (String)obj;
			s.replaceAll("\n", "\\n");
			s.replaceAll("\"", "\\\"");
			return "\"" + s + "\"";
		}
		else
			return obj.toString();
		
	}

	public String toString(Object arg0, String arg1) {
		// TODO figure out the meaning of this method
		System.err.println("???: <" + arg0 + "> : <" + arg1 + ">");
		return null;
	}
	
}
