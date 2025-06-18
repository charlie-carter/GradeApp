/**
 * @author Sarvenaz Eftekhari
 * @version 2025-06-16
 */
package com.gradeapp.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.gradeapp.model.FinalRecord;

/**
 * 
 */
public class CSVFileWriter {
    public static void write(String path, List<FinalRecord> records) throws IOException {
	try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
	    for (FinalRecord r : records) {
		pw.printf("%s,%s,%s,%.1f%n", r.getStudentId(), r.getName(), r.getCourseCode(), r.getFinalGrade());
	    }
	}
    }
}