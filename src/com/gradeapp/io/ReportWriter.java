package com.gradeapp.io;

import com.gradeapp.model.StandardCourse;
import com.gradeapp.model.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * Writes a report of students and their course grades to a text file.
 * The report format per line is: studentId studentName courseCode finalGrade
 *
 * <p> Students are sorted by their ID in ascending order. </p>
 *
 * @author Sarvenaz Eftekhari, Charlie Carter
 * @version 1.1
 * @since 2025-06-16
 */
public class ReportWriter {

	/**
	 * Writes the report for a collection of students to the specified file.
	 *
	 * @param students the collection of students to report on
	 * @param filename the output file path
	 * @throws IOException if writing to file fails
	 */
	public static void writeReport(Collection<Student> students, String filename) throws IOException {
		List<Student> sortedStudents = new ArrayList<>(students);
		sortedStudents.sort(Comparator.comparing(Student::getId));

		try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
			for (Student student : sortedStudents) {
				for (StandardCourse course : student.getCourses()) {
					double grade = course.calculateFinalGrade();
					writer.printf("%s %s %s %.1f%n",
							student.getId(),
							student.getName(),
							course.getCode(),
							grade);
				}
			}
		}
	}
}
