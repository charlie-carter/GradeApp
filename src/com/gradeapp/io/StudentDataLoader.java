package com.gradeapp.io;

import com.gradeapp.model.StandardCourse;
import com.gradeapp.model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Loads student and course data from txt files into the StudentDatabase.
 * Expects specific txt formats:
 * <ul>
 *     <li>Students: id,name</li>
 *     <li>Courses: id,courseCode,test1,test2,test3,finalExam</li>
 * </ul>
 *
 * Handles missing students gracefully by logging warnings.
 *
 * @author Sarvenaz Eftekhari, Charlie Carter
 * @version 1.1
 * @since 2025-06-16
 */
public class StudentDataLoader {

    private final StudentDatabase database;

    /**
     * Creates a data loader for the specified StudentDatabase.
     *
     * @param database the student database to populate
     */
    public StudentDataLoader(StudentDatabase database) {
        this.database = database;
    }

    /**
     * Loads students from a txt file.
     * Lines with fewer than 2 comma-separated parts are ignored.
     *
     * @param filename path to the students txt file
     * @throws IOException if file reading fails
     */
    public void loadStudents(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) continue;

                String id = parts[0].trim();
                String name = parts[1].trim();

                Student student = new Student(id, name);
                database.addStudent(student);
            }
        }
    }

    /**
     * Loads courses from a txt file and associates them with students.
     * Lines with fewer than 6 comma-separated parts are ignored.
     * Logs a warning if a course references a student not in the database.
     *
     * @param filename path to the courses txt file
     * @throws IOException if file reading fails
     */
    public void loadCourses(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 6) continue;

                String id = parts[0].trim();
                String code = parts[1].trim();
                double t1 = Double.parseDouble(parts[2]);
                double t2 = Double.parseDouble(parts[3]);
                double t3 = Double.parseDouble(parts[4]);
                double fe = Double.parseDouble(parts[5]);

                StandardCourse course = new StandardCourse(code, t1, t2, t3, fe);

                Student student = database.getStudentById(id);
                if (student != null) {
                    student.addCourse(course);
                } else {
                    System.err.println("Warning: no student found with ID " + id);
                }
            }
        }
    }
}
