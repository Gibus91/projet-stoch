package com.polytech.stoch;

public class problemData {

	private int productTypes;
	private float holdingCosts;
	private float setupCosts;
	private int nbNodes;
	private int nbScenarios;


	// private tree ->[node n - a(n) - t(n)]
	// private tree ->[p(n) - x_1(n) - x_2(n) - ... ]

	
	public problemData(int productTypes, float holdingCosts, float setupCosts,
			int nbNodes, int nbScenarios) {

		this.productTypes = productTypes;
		this.holdingCosts = holdingCosts;
		this.setupCosts = setupCosts;
		this.nbNodes = nbNodes;
		this.nbScenarios = nbScenarios;
	}

	@Override
	public String toString() {
		return "problemData [productTypes=" + productTypes + ", holdingCosts="
				+ holdingCosts + ", setupCosts=" + setupCosts + ", nbNodes="
				+ nbNodes + ", nbScenarios=" + nbScenarios + "]";
	}

	public  int getProductTypes() {
		return productTypes;
	}

	public  void setProductTypes(int productTypes) {
		this.productTypes = productTypes;
	}

	public  float getHoldingCosts() {
		return holdingCosts;
	}

	public  void setHoldingCosts(float holdingCosts) {
		this.holdingCosts = holdingCosts;
	}

	public  float getSetupCosts() {
		return setupCosts;
	}

	public  void setSetupCosts(float setupCosts) {
		this.setupCosts = setupCosts;
	}

	public  int getNbNodes() {
		return nbNodes;
	}

	public  void setNbNodes(int nbNodes) {
		this.nbNodes = nbNodes;
	}

	public  int getNbScenarios() {
		return nbScenarios;
	}

	public  void setNbScenarios(int nbScenarios) {
		this.nbScenarios = nbScenarios;
	}

}
