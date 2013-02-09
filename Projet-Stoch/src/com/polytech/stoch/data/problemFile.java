package com.polytech.stoch.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
	public static problemData parseFile(String chemin) {
		problemData problem = null;
		try {
			FileReader fr = new FileReader(new File(chemin));
			BufferedReader reader = new BufferedReader(fr);
			StringTokenizer token, tree;
			String delim = " ,;=[]\t\n\r";

			int productTypes = 0;
			float[] holdingCosts = null;
			float[] setupCosts = null;
			int nbNodes = 0;
			int nbScenarios = 0;
			int i = 0, j = 1, cpt, k;
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

				
			
			productTypes = Integer.parseInt(line.get(line.indexOf("P")+1));
			holdingCosts = new float[productTypes];
			setupCosts = new float[productTypes];
			for (cpt = 1; cpt <= productTypes; cpt++, i++) {
				holdingCosts[i] = Float.parseFloat(line.get(line.indexOf("h")+cpt));
				setupCosts[i] = Float.parseFloat(line.get(line.indexOf("pi")+ cpt));
			}
			/*
			cpt += productTypes;
			nbNodes = Integer.parseInt(line.get(cpt));
			nbScenarios = Integer.parseInt(line.get(cpt++));
			int[] parents = new int[nbNodes + 1];
			for (k = cpt + 1; k <= 3 * (nbNodes + 1); k += 3) {
				parents[Integer.parseInt(line.get(k))] = Integer.parseInt(line
						.get(k + 1));
				// System.out.println(line.get(k) +" "+ line.get(k +1 )
				// +" "+line.get(k + 2) + "\n");
			}
			//System.out.println(k);
			int[][] demand = new int[nbNodes + 1][productTypes];
			float[] probability = new float[nbNodes + 1];
			for (int temp = 1; temp <= productTypes; temp++) {
				for (i = 1; k < line.size(); k += 2, i++) {
					
					System.out.println(line.get(k) + " " + line.get(k + temp)+" " +i);
				//	demand[i][temp] = Integer.parseInt(line.get(k+ temp));
					//probability[i] = Float.parseFloat(line.get(k ));
				}

				
			}*/
			System.out.println(line);
			problem = new problemData(productTypes, nbNodes, nbScenarios);
			problem.setHoldingCosts(holdingCosts);
			problem.setSetupCosts(setupCosts);
			//problem.setParents(parents);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return problem;
	}
}
