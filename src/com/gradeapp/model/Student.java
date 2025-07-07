package com.gradeapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a student with identifying information and their enrolled courses.
 *
 * <p>This class holds the student's basic info including student ID, name, and
 * a list of their course records with grades.</p>
 *
 * @author Sarvenaz Eftekhari, Charlie Carter
 * @version 1.1
 * @since 2025-06-01
 */

public class Student {
    private final String id;
    private final String name;
    private ArrayList<CourseRecord> courses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    /**
     * Adds a CourseRecord object to this student's list of courses.
     *
     * @param course the course record to add
     */
    public void addCourse(CourseRecord course) {
        this.courses.add(course);
    }

    /**
     * Returns the student's unique ID.
     *
     * @return the student ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the list of course records for this student.
     *
     * @return the list of courses
     */
    public List<CourseRecord> getCourses() {
        return courses;
    }

    /**
     * Returns the student's full name.
     *
     * @return the student's name
     */
    public String getName() {
        return name;
    }


}
