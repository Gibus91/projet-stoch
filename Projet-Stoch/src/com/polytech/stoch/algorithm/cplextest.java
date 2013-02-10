package com.polytech.stoch.algorithm;

import ilog.concert.*;
import ilog.cplex.*;

public class cplextest{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("RUNNING ... YEEEESSSS!");
		double[][] xi = {{1.1, 1.3, 1.5},
						 {1.2, 1.1, 1.1},
						 {1.0, 0.3, 0.5},
						 {1.0, 1.0, 1.0},
						 {1.2, 1.8, 1.5},};
		double alpha = 0.4;
		double VaR = runCPLEX(xi, alpha);
		System.out.println("VaR solution = "+VaR);
	}
	
	/** example calculating the VaR for an investments into assets
	* the possible assets returns are uncertain and represented by scenarios 
	* given in matrix xi
	* @param xi matrix of scenario-asset returns
	* @param alpha risk level
	* @return VaR of return distribution
	*/
 	private static double runCPLEX(double[][] xi, double alpha){
		int scenarios = xi.length;
		int assets = xi[0].length;
		double kappa = 1000000;
		double objval=0;
		try {
            IloCplex cplex = new IloCplex();
            // stops cplex logging output 
            //cplex.setOut(null);
			
			IloNumVar gamma = cplex.numVar(Double.MIN_VALUE,Double.MAX_VALUE);
            IloNumVar[] x = cplex.numVarArray(assets,0.0,Double.MAX_VALUE);
			IloNumVar[] z = cplex.numVarArray(scenarios,0,1,IloNumVarType.Bool);

			IloLinearNumExpr expr1 = cplex.linearNumExpr();
	        IloNumExpr expr2 = cplex.numExpr();
			
			// define Expected Costs objective
	        expr1.clear();
			expr1.addTerm(gamma, 1.0);
			IloObjective obj = cplex.maximize(expr1);
			cplex.add(obj);
			
			// constraints:

			// constraint 1
			for(int s=0; s<scenarios;s++){
				expr1.clear();
				expr1.addTerm(gamma, 1.0);
				for(int a=0;a<assets;a++){
					expr1.addTerm(x[a], -1.0* xi[s][a]);
				}
				expr2 = cplex.diff(1.0, z[s]);
				expr2 = cplex.prod(expr2, kappa);
				cplex.addLe(expr1,expr2);
			}
			// constraint 2
			expr1.clear();
			for(int s=0; s<scenarios;s++){
				expr1.addTerm(z[s], 1.0);
			}
			cplex.addGe(expr1, (scenarios*(1.0-alpha)));
			// constraint 3
			expr1.clear();
			for(int a=0; a<assets;a++){
				expr1.addTerm(x[a], 1.0);
			}
			cplex.addEq(expr1, 1.0);
			
			
			long time_start = System.currentTimeMillis();
			
			cplex.exportModel("model.lp"); 
			if ( cplex.solve() ) {

            	double time = Double.parseDouble(""+(System.currentTimeMillis()-time_start))/1000.0;
            	objval = cplex.getObjValue();
            	
				System.out.println("\n----------------------------\n");
            	System.out.println("Opt Status: "+cplex.getStatus().toString());
            	System.out.println("time: "+time);
            	System.out.println("Objective Value: "+objval);
            	
                // get solutions from root node
                double[] x_sol = cplex.getValues(x);
                double[] z_sol = cplex.getValues(z);
                System.out.println("Investments per asset:");
                for(int a=0; a<assets;a++){
                	System.out.println("\tasset "+a+": "+x_sol[a]);
                }

			}
			
		}catch(Exception e){
			System.err.println("Problem solving CPLEX: "+e);
		}
			
		return objval;
	}
	
}