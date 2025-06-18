/**
 * @author Sarvenaz Eftekhari
 * @version 2025-06-16
 */
package com.gradeapp.model;

/**
 * 
 */
public class CourseRecord {
    private String studentId;
    private String courseCode;
    private double[] tests;
    private double exam;

    public CourseRecord(String studentId, String courseCode, double[] tests, double exam) {
	this.studentId = studentId;
	this.courseCode = courseCode;
	this.tests = tests;
	this.exam = exam;
    }

    public String getStudentId() {
	return studentId;
    }

    public String getCourseCode() {
	return courseCode;
    }

    public double[] getTests() {
	return tests;
    }

    public double getExam() {
	return exam;
    }
}