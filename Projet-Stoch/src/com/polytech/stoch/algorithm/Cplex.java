package com.polytech.stoch.algorithm;

import ilog.concert.IloException;
import ilog.cplex.IloCplex;

import com.polytech.stoch.data.Solution;
import com.polytech.stoch.data.problemData;

public class Cplex extends Algorithm{

	private IloCplex cplex;
	private problemData problem;
	private int nbProduits;
	
	
	protected Solution solve(problemData problem) {
		this.problem = problem;
		this.nbProduits = problem.getProductTypes();
		if(this.createProblem())
			return solveCplex();
		return null;
	}
	

	private boolean createProblem(){
		try {
			cplex = new IloCplex();
			this.createVariable();
			boolean constraintesCreate = this.createConstraintes();
			boolean objectiveFunction = this.createObjectiveFunction();
			return constraintesCreate && objectiveFunction;
		} catch (IloException e) {
			return false;
		}
		
	}
	private void createVariable() {
		// TODO Auto-generated method stub
		
	}

	

	private boolean createConstraintes() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean createObjectiveFunction() {
		// TODO Auto-generated method stub
		return false;
	}

	
	private Solution solveCplex() {
		
		return null;
	}

	
	public String getName() {
		
		return "Cplex";
	}

}
