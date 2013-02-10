package com.polytech.stoch.ui;

import java.awt.Dimension;

import javax.swing.JTextArea;

import com.polytech.stoch.algorithm.Algorithm;
import com.polytech.stoch.data.Solution;
import com.polytech.stoch.data.problemData;


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


	public void afficherTexte(Algorithm algorithm, problemData problem, Solution solution) {
		StringBuilder sb = new StringBuilder();
		if (solution == null) {
			sb.append("There is no solution available for this problem.");
		} else {
			sb.append("The best solution : " + algorithm.getName()+".\n");
		}
		this.setText(sb.toString());
	}
}
