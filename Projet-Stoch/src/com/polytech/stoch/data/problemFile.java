package com.polytech.stoch.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Classe permettant de charger un probleme provenant d'un fichier texte
 * 
 * @author jean-baptisteborel
 * 
 */
public class problemFile {
	/**
	 * 
	 * @param chemin
	 * @return
	 */
	public static problemData parseFile(String chemin)throws FileErrorException {
		problemData problem = null;
		try {
			FileReader fr = new FileReader(new File(chemin));
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(fr);
			StringTokenizer token;
			String delim = " ,;=[]\t\n\r";

			int productTypes = 0;
			float[] holdingCosts = null;
			float[] setupCosts = null;
			int nbNodes = 0;
			int nbScenarios = 0;
			
			int i = 0, j = 1, cpt, k = 0;
			String ligne;
			ArrayList<String> line = new ArrayList<String>();
			while ((ligne = reader.readLine()) != null) {
				// On teste si la ligne contient des lignes de commentaire, au
				// quel cas on les supprimes avant de faire la tokenisation
				if (!ligne.contains("*") && !ligne.contains("/")) {
					token = new StringTokenizer(ligne, delim);
					while (token.hasMoreElements()) {
						line.add(token.nextToken().toString());
					}
				}
			}

			productTypes = Integer.parseInt(line.get(line.indexOf("P") + 1));
			holdingCosts = new float[productTypes];
			setupCosts = new float[productTypes];
			for (cpt = 1; cpt <= productTypes; cpt++, i++) {
				holdingCosts[i] = Float.parseFloat(line.get(line.indexOf("h")
						+ cpt));
				setupCosts[i] = Float.parseFloat(line.get(line.indexOf("pi")
						+ cpt));
			}

			nbNodes = Integer.parseInt(line.get(line.indexOf("nodes") + 1));
			nbScenarios = Integer
					.parseInt(line.get(line.indexOf("scenarios") + 1));

			int str;
			int[] parents = new int[nbNodes + 1];
			int[][] demand = new int[nbNodes + 1][productTypes];
			float[] probability = new float[nbNodes + 1];
			for (str = line.indexOf("tree_str") + 1; str < line
					.indexOf("tree_val"); str += 3) {
				parents[Integer.parseInt(line.get(str))] = Integer
						.parseInt(line.get(str + 1));
			}

			for (str = line.indexOf("tree_val") + 1; str < line.size(); str += 2, j++) {
				probability[j] = Float.parseFloat(line.get(str));
				demand[j][k] = Integer.parseInt(line.get(str + 1));
			}

			problem = new problemData(productTypes, nbNodes, nbScenarios);
			problem.setDemand(demand);
			problem.setHoldingCosts(holdingCosts);
			problem.setSetupCosts(setupCosts);
			problem.setParents(parents);

			problem.setProbability(probability);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return problem;
	}
}
