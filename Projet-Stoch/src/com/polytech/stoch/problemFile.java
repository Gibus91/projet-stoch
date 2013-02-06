package com.polytech.stoch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Classe permettant de charger un probleme provenant d'un fichier texte
 * 
 * @author jean-baptisteborel
 * 
 */
public class problemFile {

	public static problemData parseFile(String chemin) {
		problemData problem = null;
		try {
			FileReader fr = new FileReader(new File(chemin));
			BufferedReader reader = new BufferedReader(fr);
			StringTokenizer token, tree;
			String delim = " ,;=[]\t\n\r";

			int productTypes = 0;
			float holdingCosts = 0;
			float setupCosts = 0;
			int nbNodes = 0;
			int nbScenarios = 0;

			String ligne;
			while ((ligne = reader.readLine()) != null) {

				// On teste si la ligne contient des lignes de commentaire, au
				// quel cas on les supprimes avant de faire la tokenisation
				if (!ligne.contains("*") && !ligne.contains("/")) {
					token = new StringTokenizer(ligne, delim);
					while (token.hasMoreElements()) {
						String line = token.nextElement().toString();
						// System.out.println(line);
						if (line.contentEquals("P")) {
							productTypes = Integer.parseInt(token.nextToken());
						}

						if (line.contentEquals("h")) {
							holdingCosts = Float.parseFloat(token.nextToken());
						}

						if (line.contentEquals("pi")) {
							setupCosts = Float.parseFloat(token.nextToken());
						}

						if (line.contentEquals("nodes")) {
							nbNodes = Integer.parseInt(token.nextToken());
						}
						if (line.contentEquals("scenarios")) {
							nbScenarios = Integer.parseInt(token.nextToken());
						}
					}
				}
			}

			problem = new problemData(productTypes, holdingCosts, setupCosts,
					nbNodes, nbScenarios);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return problem;
	}
}
