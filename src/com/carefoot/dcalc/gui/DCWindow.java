package com.carefoot.dcalc.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.carefoot.dcalc.ComputationHandler;

public class DCWindow {
	
	private final JFrame window;
	private final ComputationHandler handler;
	
	private final int WINDOW_HEIGHT = 200;
	private final int WINDOW_WIDTH = 500;
	
	// Constructor
	public DCWindow(ComputationHandler handler) {
		this.window = new JFrame("Derivative Calculator");
		this.handler = handler;
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		constructWindow();
	}
	
	// Builds window using Java Swing
	private void constructWindow() {
		
		window.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		BorderLayout layout = new BorderLayout();
		layout.setVgap(50);
		window.getContentPane().setLayout(layout);
		
		JLabel text = new JLabel("Please input the equation below. Result will be displayed at the bottom.");
		text.setFont(new Font("Serif", Font.PLAIN, Math.round(14*(WINDOW_WIDTH/500))));
		window.getContentPane().add(text, BorderLayout.NORTH); // Adds text add top of gui
		
		JTextField field = new JTextField("E.g: 3x^2");
		window.getContentPane().add(field, BorderLayout.CENTER); // Adds text field (to center)
		
		JButton button = new JButton("Calculate");
		button.addActionListener(new ActionListener() {
			
			// Run when "calculate" button is pressed
			public void actionPerformed(ActionEvent e) {
				handler.derivative(field.getText());
			}
			
		});
		window.getContentPane().add(button, BorderLayout.EAST); // Adds button
		
		JLabel result = new JLabel("Calculated Derivative:");
		window.getContentPane().add(result, BorderLayout.SOUTH); // Adds result text field

	}
	
	// Opens the window
	public void open() {
		window.setVisible(true);
	}
	
	// Closes the window
	public void close() {
		window.setVisible(false);
	}

}
