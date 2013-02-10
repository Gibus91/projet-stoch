package com.polytech.stoch.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.polytech.stoch.algorithm.Algorithm;
import com.polytech.stoch.data.Solution;
import com.polytech.stoch.data.problemData;
import com.polytech.stoch.data.problemFile;

public class MainWindow extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ResultView resultView;
	private SettingPanel settingPanel;
	private JButton saveButton;
	private String nomFichier;

	public MainWindow() {
		super("Stochastic project");

		initComponents();
		layoutComponents();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	private void initComponents() {
		settingPanel = new SettingPanel(this);
		resultView = new ResultView();
		saveButton = new JButton("Save");
		saveButton.setEnabled(false);
		saveButton.addActionListener(this);
	}


	private void layoutComponents() {
		this.setLayout(new BorderLayout());
		this.add(settingPanel, BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(resultView);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(resultView.getPreferredSize());
		this.add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel(new BorderLayout());
		panel.add(saveButton, BorderLayout.EAST);
		this.add(panel, BorderLayout.SOUTH);
	}

	public void runSolve(Algorithm algorithm, String fichier) {
		problemData problem = problemFile.parseFile(fichier);
		System.out.println(problem.toString());
		// Rajouter la r�solution avec les algo
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Rajouter l'�criture dans le fichier

	}
}
