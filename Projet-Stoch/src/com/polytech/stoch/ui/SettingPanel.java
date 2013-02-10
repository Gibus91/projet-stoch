package com.polytech.stoch.ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import com.polytech.stoch.algorithm.Algorithm;
import com.polytech.stoch.algorithm.Cplex;
import com.polytech.stoch.algorithm.VNS;

public class SettingPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 9189108000159260811L;

	private MainWindow window;

	private JFileChooser fileChooser;
	private JRadioButton[] radioButtons;
	private JTextArea nbIteration, nbNeighbourhood;
	private File file;
	private Algorithm algorithms[];

	public SettingPanel(MainWindow window) {
		this.window = window;
		algorithms = new Algorithm[] { new VNS(), new Cplex() };
		initComponents();
		layoutComponents();
	}

	private void initComponents() {

		fileChooser = new JFileChooser();

		ButtonGroup group = new ButtonGroup();
		radioButtons = new JRadioButton[algorithms.length];
		for (int i = 0; i < algorithms.length; i++) {
			radioButtons[i] = new JRadioButton(algorithms[i].getName());
			group.add(radioButtons[i]);
		}
		radioButtons[0].setSelected(true);

	}

	/**
	 * Ajoute les éléments dans le panneau.
	 */
	private void layoutComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 10, 10);

		addToPanel(new JLabel("File"), gbc, 0, 0);
		// addToPanel(fileChooser, gbc, 1, 0);
		JButton btnFile = new JButton("Select file");
		btnFile.addActionListener(new ActionListener() {
			// Handle open button action.
			public void actionPerformed(ActionEvent e) {

				int returnVal = fileChooser.showOpenDialog(window);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					file = fileChooser.getSelectedFile();
				} else {
					System.out.println("Open command cancelled by user.");
				}
				System.out.println(returnVal);
			}
		});

		this.add(btnFile);
		addToPanel(new JLabel("Algorithm"), gbc, 0, 1);
		for (int i = 0; i < radioButtons.length; i++)
			addToPanel(radioButtons[i], gbc, i + 1, 1);
		addToPanel(new JLabel("Settings"), gbc, 0, 2);
		addToPanel(new JLabel("Iteration Max"), gbc, 1, 2);
		nbIteration = new JTextArea(1, 5);
		addToPanel(nbIteration, gbc, 2,2);
		addToPanel(new JLabel("Neighbourhood"), gbc, 1, 3);
		nbNeighbourhood = new JTextArea(1,5);
		addToPanel(nbNeighbourhood,gbc,2,3);
		
		
		JButton launchButton = new JButton("Solve");
		launchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Algorithm algo = null;
				System.out.println(nbNeighbourhood.getText());
				for (int i = 0; i < radioButtons.length && algo == null; i++) {
					if (radioButtons[i].isSelected())
						algo = algorithms[i];
				}
				/*if (file != null)
					window.runSolve(algo, file.getAbsolutePath());*/
			}
		});
		addToPanel(launchButton, gbc, 0, 10);
		
	}

	private void addToPanel(Component comp, GridBagConstraints gbc, int x, int y) {
		addToPanel(comp, gbc, x, y, 1, 1);
	}

	private void addToPanel(Component comp, GridBagConstraints gbc, int x,
			int y, int width, int height) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		this.add(comp, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
