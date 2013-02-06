package com.polytech.stoch;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		problemData problem = problemFile.parseFile("./data/data_2012_3stage.dat");
		System.out.println(problem.toString());
	}

}
