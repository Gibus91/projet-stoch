package com.polytech.stoch.data;

import java.util.ArrayList;
/**
 * 
 * @author jean-baptisteborel
 *
 */
public class Tree {

	private ArrayList<Nodes> tree;
	/**
	 * 
	 * @param nbNodes
	 */
	public Tree(int nbNodes){
		tree = new ArrayList<Nodes>();
	}
	/**
	 * Add a node to the tree
	 * @param n
	 * @return
	 */
	public boolean addNodes(Nodes n){
		return this.tree.add(n);
	}
}
