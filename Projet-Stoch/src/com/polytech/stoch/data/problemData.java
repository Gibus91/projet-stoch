package com.polytech.stoch.data;

import java.util.Arrays;

public class problemData {

	private int productTypes;
	private float[] holdingCosts;
	private float[] setupCosts;
	private int nbNodes;
	private int nbScenarios;
	private int[] parents;
	private int[][] demand;
	private float[] probability;

	// private tree ->[node n - a(n) - t(n)]
	// private tree ->[p(n) - x_1(n) - x_2(n) - ... ]

	public problemData(int productTypes, int nbNodes, int nbScenarios) {

		this.productTypes = productTypes;
		this.holdingCosts = new float[this.getProductTypes()];
		this.setupCosts = new float[this.getProductTypes()];
		this.nbNodes = nbNodes;
		this.nbScenarios = nbScenarios;
		this.parents = new int[this.getNbNodes() + 1];
		this.setDemand(new int[this.getNbNodes() + 1][this.getProductTypes()]);
		this.setProbability(new float[this.getNbNodes() + 1]);
	}

	

	


	@Override
	public String toString() {
		return "problemData [productTypes=" + productTypes + ", holdingCosts="
				+ Arrays.toString(holdingCosts) + ", setupCosts="
				+ Arrays.toString(setupCosts) + ", nbNodes=" + nbNodes
				+ ", nbScenarios=" + nbScenarios + ", parents="
				+ Arrays.toString(parents) + ", demand="
				+ Arrays.toString(demand) + ", probability="
				+ Arrays.toString(probability) + "]";
	}






	public int getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(int productTypes) {
		this.productTypes = productTypes;
	}

	public float[] getHoldingCosts() {
		return holdingCosts;
	}

	public void setHoldingCosts(float[] holdingCosts) {
		this.holdingCosts = holdingCosts;
	}

	public float[] getSetupCosts() {
		return setupCosts;
	}

	public void setSetupCosts(float[] setupCosts) {
		this.setupCosts = setupCosts;
	}

	public int getNbNodes() {
		return nbNodes;
	}

	public void setNbNodes(int nbNodes) {
		this.nbNodes = nbNodes;
	}

	public int getNbScenarios() {
		return nbScenarios;
	}

	public void setNbScenarios(int nbScenarios) {
		this.nbScenarios = nbScenarios;
	}

	public int[] getParents() {
		return parents;
	}

	public void setParents(int[] parents) {
		this.parents = parents;
	}

	public int[][] getDemand() {
		return demand;
	}

	public void setDemand(int[][] demand) {
		this.demand = demand;
	}

	public float[] getProbability() {
		return probability;
	}

	public void setProbability(float[] probability) {
		this.probability = probability;
	}

}
