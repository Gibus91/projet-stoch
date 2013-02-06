package com.polytech.stoch.algorithm;

import com.polytech.stoch.data.Solution;
import com.polytech.stoch.data.problemData;

public abstract class Algorithm {
	protected long startTime;
	protected long endTime;


	public Solution resoudre(problemData probleme) {
		endTime = -1;
		startTime = System.currentTimeMillis();

		Solution solution = solve(probleme);

		endTime = System.currentTimeMillis();

		return solution;
	}

	protected abstract Solution solve(problemData probleme);


	public long getTimeSolve() {
		if (endTime == -1)
			return -1;
		else
			return endTime - startTime;
	}


	public abstract String getName();
}
