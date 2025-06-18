/**
 * @author Sarvenaz Eftekhari
 * @version 2025-06-16
 */
package com.gradeapp.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gradeapp.io.CSVFileReader;
import com.gradeapp.io.CSVFileWriter;
import com.gradeapp.model.CourseRecord;
import com.gradeapp.model.FinalRecord;
import com.gradeapp.model.Student;
import com.gradeapp.service.GradeService;

/**
 * 
 */
public class MainApp {
    public static void main(String[] args) {
	if (args.length != 3) {
	    System.err.println("Usage: java -jar GradeApp.jar <names> <courses> <output>");
	    System.exit(2);
	}
	try {
	    List<String[]> nameRows = CSVFileReader.readAll(args[0]);
	    List<String[]> courseRows = CSVFileReader.readAll(args[1]);

	    List<Student> students = new ArrayList<>();
	    for (String[] r : nameRows) {
		students.add(new Student(r[0], r[1]));
	    }
	    List<CourseRecord> courses = new ArrayList<>();
	    for (String[] r : courseRows) {
		double[] tests = new double[] { Double.parseDouble(r[2]), Double.parseDouble(r[3]),
			Double.parseDouble(r[4]) };
		double exam = Double.parseDouble(r[5]);
		courses.add(new CourseRecord(r[0], r[1], tests, exam));
	    }

	    List<FinalRecord> results = new GradeService().computeFinals(students, courses);
	    CSVFileWriter.write(args[2], results);
	    System.exit(0);
	} catch (FileNotFoundException e) {
	    System.err.println("File not found: " + e.getMessage());
	    System.exit(1);
	} catch (IOException e) {
	    System.err.println("I/O error: " + e.getMessage());
	    System.exit(3);
	} catch (NumberFormatException e) {
	    System.err.println("Parse error: invalid number format");
	    System.exit(2);
	}
    }
}