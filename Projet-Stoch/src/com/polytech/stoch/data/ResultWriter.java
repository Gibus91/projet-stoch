package com.polytech.stoch.data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class ResultWriter {
	public static void save(String path, String result) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(path));
			out.write(result);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
