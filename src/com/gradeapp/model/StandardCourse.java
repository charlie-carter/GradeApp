package com.gradeapp.model;

/**
 * Represents a standard course with a default grading scheme.
 * <p>
 * This course includes three tests and a final exam. The final grade is calculated
 * as follows: the average of the three tests is weighted at 60% total (20% each),
 * and the final exam is weighted at 40%.
 * </p>
 *
 * This class is a concrete implementation of the abstract {@code Course} class.
 * It demonstrates polymorphism by overriding {@code calculateFinalGrade()}.
 *
 * @author Charlie Carter, Sarvenaz Eftekhari
 * @version 1.0
 * @since 2025-07-21
 */
public class StandardCourse extends Course {

    /** Scores for three tests. */
    private double test1, test2, test3;

    /** Score for the final exam. */
    private double finalExam;

    /**
     * Constructs a StandardCourse with a course code and associated grades.
     *
     * @param code the course code (e.g., "CP317")
     * @param t1 score for test 1
     * @param t2 score for test 2
     * @param t3 score for test 3
     * @param fe score for the final exam
     */
    public StandardCourse(String code, double t1, double t2, double t3, double fe) {
        super(code);
        this.test1 = t1;
        this.test2 = t2;
        this.test3 = t3;
        this.finalExam = fe;
    }

    /**
     * Calculates the final grade using the standard grading formula.
     * <p>
     * Formula: (test1 + test2 + test3) * 0.2 + finalExam * 0.4
     * </p>
     *
     * @return the final numeric grade as a double
     */
    @Override
    public double calculateFinalGrade() {
        return (test1 + test2 + test3) * 0.2 + finalExam * 0.4;
    }
}
