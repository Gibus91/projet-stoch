package com.polytech.stoch.ui;

import java.awt.Dimension;

import javax.swing.JTextArea;


public class ResultView extends JTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1013998293556245481L;


	public ResultView() {
		super();
		this.setText("No result.");
		this.setPreferredSize(new Dimension(300, 300));
	}


	public void afficherTexte(String message) {
		this.setText(message);
	}
}
