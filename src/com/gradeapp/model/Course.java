package com.gradeapp.model;

/**
 * Represents an abstract course taken by a student.
 * <p>
 * This class defines the structure and contract that all course types must follow.
 * Each course has a course code and must implement a method to calculate the final grade.
 * </p>
 *
 * This abstract class enables polymorphism by allowing multiple grading schemes
 * to be implemented by subclasses.
 *
 * @author Charlie Carter, Sarvenaz Eftekhari
 * @version 1.0
 * @since 2025-07-21
 */
public abstract class Course {

    /**
     * The course code (e.g., "CP317").
     * Protected to allow subclasses to access and use.
     */
    protected String code;

    /**
     * Constructs a Course with the given course code.
     *
     * @param code the unique identifier for the course
     */
    public Course(String code) {
        this.code = code;
    }

    /**
     * Returns the course code.
     *
     * @return the course code string
     */
    public String getCode() {
        return code;
    }

    /**
     * Calculates the final grade for this course.
     * Implemented differently depending on grading strategy.
     *
     * @return the final numeric grade as a double
     */
    public abstract double calculateFinalGrade();
}
