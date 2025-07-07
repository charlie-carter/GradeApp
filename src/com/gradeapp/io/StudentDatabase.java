package com.gradeapp.io;

import com.gradeapp.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages the collection of students for the grade application.
 * Provides methods to add, retrieve, and check existence of students by ID.
 *
 * Thread safety: Not synchronized; consider external synchronization if used concurrently.
 *
 * @author Sarvenaz Eftekhari, Charlie Carter
 * @version 1.1
 * @since 2025-06-16
 */
public class StudentDatabase {

	/** Maps student ID to Student objects */
	private final Map<String, Student> students = new HashMap<>();

	/**
	 * Adds a student to the database.
	 * If a student with the same ID exists, it will be overwritten.
	 *
	 * @param student the Student to add
	 */
	public void addStudent(Student student) {
		students.put(student.getId(), student);
	}

	/**
	 * Retrieves a student by their unique ID.
	 *
	 * @param id the student ID
	 * @return the Student if found, otherwise null
	 */
	public Student getStudentById(String id) {
		return students.get(id);
	}

	/**
	 * Returns all students currently in the database.
	 *
	 * @return a collection of all Student objects
	 */
	public Collection<Student> getAllStudents() {
		return students.values();
	}
}
