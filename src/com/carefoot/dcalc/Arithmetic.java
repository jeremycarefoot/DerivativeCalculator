// This is a class with static methods. Has some useful methods to visualize math operations on strings

package com.carefoot.dcalc;

public class Arithmetic {
	
	// Visualizes multiplication by surrounding all given expressions in brackets
	public static String multiply(String...exps) {
		String result = "";
		for (String s : exps) {
			result += "(" + s + ")";
		}
		return result;
	}
	
	// Visualizes division
	public static String divide(String ex1, String ex2) {
		return "(" + ex1+ ")/(" + ex2 + ")";
	}
	
	// Visualizes division or subtraction, depending on boolean value
	public static String add(boolean subtract, String... exps) {
		String result = "";
		for (String s : exps) {
			result += s + (subtract ? " - " : " + ");
		}
		return result.substring(0,result.length() - 3); // substring off the final sign
	}

}
