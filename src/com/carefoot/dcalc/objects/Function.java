/*
 * Enum for keeping track of different possible functions
 * Derivatives of functions are shown with 'x', which is then replaced by appropriate argument
 */

package com.carefoot.dcalc.objects;

import java.util.HashMap;

public enum Function {
	
	SIN("cos(x)", "sin"), 
	COS("-sin(x)", "cos"), 
	TAN("sec(x)^2", "tan"), 
	ARCSIN("1/sqrt(1-x^2)","arcsin"), 
	ARCCOS("1/sqrt(1+x^2)", "arccos"), 
	ARCTAN("1/(1+x^2)", "arctan"), 
	LN("1/x", "ln"), 
	LOG("1/(x*ln(10))", "log"), 
	SQRT("(1/2)*x^(-1/2)","sqrt"),
	EXP("exp(x)","exp");
	
	private String derivative;
	private String representation; // string representation of functions must be unique
	private static final HashMap<String, Function> reprMap; // hashmap of representations
	
	private Function(String derivative, String representation) {
		this.derivative = derivative;
		this.representation = representation;
	}
	
	static {
		HashMap<String, Function> map = new HashMap<>();
		for (Function f : Function.values()) {
			map.put(f.getRepresentation(), f);
		}
		reprMap = map;
	}
	
	// Returns a map of all string representions and their corresponding function
	public static HashMap<String, Function> getRepMap() {
		return reprMap;
	}
	
	// Checks given string for presence of a function
	// Must provide the string and the index of an opening bracket to test behind
	// Returns null if no function is found
	public static Function testFunction(String exp, int bracketIndex) {
		for (String rep : reprMap.keySet()) {
			try {
				String test = exp.substring(bracketIndex-rep.length(), bracketIndex);
				if (test.equals(rep)) {
					return reprMap.get(rep);
				}
			} catch (IndexOutOfBoundsException e) {
				continue;
			}
		}
		return null;
	}
	
	public String getDerivative() {
		return this.derivative;
	}
	
	public String getRepresentation() {
		return this.representation;
	}

}
