/**
 * @author Sarvenaz Eftekhari, Charlie Carter
 * @version 2025-06-16
 */
package com.gradeapp.main;

import com.gradeapp.io.ReportWriter;
import com.gradeapp.io.StudentDataLoader;
import com.gradeapp.io.StudentDatabase;

public class MainApp {
	public static void main(String[] args) {
		String studentFile = "data/NameFile.txt";
		String courseFile = "data/CourseFile.txt";
		String outputFile = "data/Output.txt";

		StudentDatabase database = new StudentDatabase();
		StudentDataLoader loader = new StudentDataLoader(database);

		try {
			loader.loadStudents(studentFile);
			loader.loadCourses(courseFile);
			ReportWriter.writeReport(database.getAllStudents(), outputFile);
			System.out.println("Report successfully generated to " + outputFile);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
