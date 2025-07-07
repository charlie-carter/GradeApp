package com.gradeapp.model;

/**
 * Represents a record of a single course taken by a student,
 * including the course code and grades on tests and final exam.
 * <p>
 * The grading strategy currently weights tests at 20% total and the final exam at 40%.
 * This class is designed for potential inheritance to support different grading schemes.
 * </p>
 *
 * @author Sarvenaz Eftekhari, Charlie Carter
 * @version 1.1
 * @since 2025-06-16
 */
public class CourseRecord {

    /**
     * The course code (e.g. "CP317").
     * Protected to allow subclasses to modify or access.
     */
    protected String code;

    /** Scores for three tests. */
    protected double test1, test2, test3;

    /** Score for the final exam. */
    protected double finalExam;

    /**
     * Constructs a CourseRecord with specified course code and grades.
     *
     * @param code the course code
     * @param t1 score for test 1
     * @param t2 score for test 2
     * @param t3 score for test 3
     * @param fe score for final exam
     */
    public CourseRecord(String code, double t1, double t2, double t3, double fe) {
        this.code = code;
        this.test1 = t1;
        this.test2 = t2;
        this.test3 = t3;
        this.finalExam = fe;
    }

    /**
     * Calculates the final grade based on weighted tests and final exam.
     *
     * @return the final numeric grade as a double
     */
    public double calculateFinalGrade() {
        return (test1 + test2 + test3) * 0.2 + finalExam * 0.4;
    }

    /**
     * Returns the course code.
     *
     * @return the course code string
     */
    public String getCode() {
        return code;
    }
}
