package com.carefoot.dcalc;

import com.carefoot.dcalc.objects.Expression;

public class ComputationHandler {
	
	private final String INVALID_CHARS = "&%$#@~`={}[]|\\;:<>,/\"";
	
	
	// Pilot method for computing derivative
	public String computeDerivative(Expression e) {
		
		if (invalidCharacterCheck(e.getStringExpression())) { // returns true if no invalid chars
			return derivative(e.getStringExpression(), e.getDerivationVariable());
		} else {
			return "Error: Invalid character detected!";
		}
		
	}
	
	// Takes derivative of given equation (can be used recursively)
	public String derivative(String eq, String variable) {
		if (eq.contains(variable)) {
			
		} else {
			return "0";
		}
		
		return "";
	}
	
	// Detects if there is an invalid character present in the equation; pulls from INVALID_CHARS
	private boolean invalidCharacterCheck(String s) {
		boolean pass = true;
		char[] stringChars = s.toCharArray();
		for (char c : stringChars) {
			if (INVALID_CHARS.contains(Character.toString(c))) {
				pass = false;
				break;
			}
		}
		return pass;
	}
	
	private String powerRule(String ex, String var) {
		// TODO implement power rule
		return null;
	}

}
