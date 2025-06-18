/**
 * @author Sarvenaz Eftekhari
 * @version 2025-06-16
 */
package com.gradeapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gradeapp.model.CourseRecord;
import com.gradeapp.model.FinalRecord;
import com.gradeapp.model.Student;

/**
 * 
 */
public class GradeService {
    public List<FinalRecord> computeFinals(List<Student> students, List<CourseRecord> courses) {

	Map<String, String> nameMap = new HashMap<>();
	for (Student s : students) {
	    nameMap.put(s.getId(), s.getName());
	}

	List<FinalRecord> finals = new ArrayList<>();
	for (CourseRecord c : courses) {
	    double sumTests = Arrays.stream(c.getTests()).sum();
	    double finalGrade = sumTests * 0.2 + c.getExam() * 0.4;
	    finalGrade = Math.round(finalGrade * 10) / 10.0;
	    String name = nameMap.getOrDefault(c.getStudentId(), "Unknown");
	    finals.add(new FinalRecord(c.getStudentId(), name, c.getCourseCode(), finalGrade));
	}

	finals.sort(Comparator.comparing(FinalRecord::getStudentId));
	return finals;
    }
}