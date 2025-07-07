package com.gradeapp.model;

/**
 * @author Sarvenaz Eftekhari
 * @version 2025-06-16
 */
public class FinalRecord {
    private String studentId;
    private String name;
    private String courseCode;
    private double finalGrade;

    public FinalRecord(String studentId, String name, String courseCode, double finalGrade) {
	this.studentId = studentId;
	this.name = name;
	this.courseCode = courseCode;
	this.finalGrade = finalGrade;
    }

    public String getStudentId() {
	return studentId;
    }

    public String getName() {
	return name;
    }

    public String getCourseCode() {
	return courseCode;
    }

    public double getFinalGrade() {
	return finalGrade;
    }
}