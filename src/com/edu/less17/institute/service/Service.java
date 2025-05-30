package com.edu.less17.institute.service;

import java.io.IOException;
import java.util.List;

import com.edu.less17.institute.model.Staff;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.repository.CourseRepository;

public interface Service {
	public CourseRepository getCourseRepository();

	public void setCourseRepository(CourseRepository courses);

	public static TrainingCourse createTrainingCourse(String specialization, int id, List<Student> students, List<Staff> staff) {
		TrainingCourse trainingCourse = new TrainingCourse(specialization, id, students, staff);
		return trainingCourse;
	}
	
	public static TrainingCourse createTrainingCourse() {
		TrainingCourse trainingCourse = new TrainingCourse();
		return trainingCourse;
	}
	
	public void addCourse(TrainingCourse course) throws IOException;
	
	public void removeCourseById(int id) throws IOException;
	
	public List<TrainingCourse> getCourses() throws IOException;
	
	public void conductLesson(TrainingCourse course);
	
	public String getCourseInfo(TrainingCourse course);
	
	public String getStudentsByAlphabet(TrainingCourse course);
	
	public String getStudentsByAverageGrade(TrainingCourse course);
	
	public TrainingCourse getCourseById(int idCourse) throws IOException;
	
	public void addStudent(Student student, int idCourse) throws IOException;
}
