package com.polytech.stoch.main;

import com.polytech.stoch.data.problemData;
import com.polytech.stoch.data.problemFile;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		problemData problem = problemFile.parseFile("./data/data_2012_3stage.dat");
		
	}

}
