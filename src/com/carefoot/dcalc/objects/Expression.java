/*
 * Object class that stores mathematical expressions
 * also stores the variable we are taking the derivative w.r.t
 */

package com.carefoot.dcalc.objects;

import java.util.ArrayList;
import java.util.List;

public class Expression {
	
	private final String expression;
	private String nodeExpression;
	private final String var;
	private List<String> nodes;
	
	public Expression(String exp, String var) {
		this.expression = exp;
		this.var = var;
		this.nodes = new ArrayList<>();
		this.nodeExpression = "";
		parseTree();
	}
	
	public String getStringExpression() {
		return this.expression;
	}
	
	public String getDerivationVariable() {
		return this.var;
	}

	
	public void parseTree() {
		this.nodeExpression = splitBrackets(this.expression);
	}
	
	// Powerful recursive function that will use brackets to replace all outside functions with nodes
	// Returns the final simplified expression, substituting nodes with node notation (E.g &3&)
	// If object list "nodes" has ANY value of null present, there is an error with the expression
	private String splitBrackets(String exp) {
		
		for (int i = 0; i < exp.length(); i++) {
			
			char c = exp.charAt(i);
			if (c == '(') { // Upon the first opening bracket, finds end bracket
				int stack = 1;
				
				for (int j = i+1; j < exp.length(); j++) { // Loops until end bracket is found
					if (exp.charAt(j) == '(') {
						stack++;
					} else if (exp.charAt(j) == ')') {
						if (stack == 1) {
							Function f = Function.testFunction(exp, i);
							String node = f == null ? exp.substring(i, j+1) 
									: exp.substring(i - f.getRepresentation().length(), j+1); // uses ternary operator to include function if present
							nodes.add(node);
							return splitBrackets(exp.replace(node, "&" + Integer.toString(nodes.size()-1) + "&")); // recursive call
						} else if (stack > 1) {
							stack--;
						}
					}
					if (j == exp.length()-1) nodes.add(null); // An error occured (no closing bracket)
				}
				
			}
		}
		return exp;
	}

}

