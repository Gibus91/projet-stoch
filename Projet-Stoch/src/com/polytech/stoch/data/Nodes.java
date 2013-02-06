package com.polytech.stoch.data;
/**
 * 
 * @author jean-baptisteborel
 *
 */
public class Nodes {

	private int position;
	private Nodes nodesAncestor;
	private int timeStage;
	private float probability;
	private float demand;

	public Nodes(int position, Nodes ancestor, int timeStage,
			float probability, float demand) {
		this.position = position;
		this.nodesAncestor = ancestor;
		this.timeStage = timeStage;
		this.probability = probability;
		this.demand = demand;
	}

}
