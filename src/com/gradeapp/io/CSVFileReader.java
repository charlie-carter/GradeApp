/**
 * @author Sarvenaz Eftekhari
 * @version 2025-06-16
 */
package com.gradeapp.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class CSVFileReader {
    public static List<String[]> readAll(String path) throws IOException {
	List<String[]> rows = new ArrayList<>();
	try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	    String line;
	    while ((line = br.readLine()) != null) {
		if (!line.trim().isEmpty()) {
		    rows.add(line.split(","));
		}
	    }
	}
	return rows;
    }
}