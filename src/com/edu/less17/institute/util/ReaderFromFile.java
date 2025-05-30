package com.edu.less17.institute.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderFromFile {
	public String getData(String path) throws IOException {
		StringBuilder sb = new StringBuilder();
		String tempString;
		try (BufferedReader bReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
			while ((tempString = bReader.readLine()) != null) {
					sb.append(tempString).append("\n");
				}
			
		} catch (IOException e) {
			throw e;
		}
		return sb.toString();

	}
}
