/*
 * Derivative Calculator
 * Version 1.0 - January 2024
 * Developed by Jeremy Carefoot
 * 
 * Takes a mathematical function and attempts to find the derivative using basic differentiation rules
 * 
 */

package com.carefoot.dcalc;

import com.carefoot.dcalc.gui.DCWindow;

public class DerivativeCalculator {
	
	private static DCWindow window;
	private static ComputationHandler handler;
	
	// Main method
	public static void main(String[] args) {
		setup();
	}
	
	// Runs all necessary startup procedures
	private static void setup() {
		handler = new ComputationHandler();
		window = new DCWindow(handler);
		window.open();
	}

}
