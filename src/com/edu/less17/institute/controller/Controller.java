package com.edu.less17.institute.controller;

import java.io.IOException;
import java.util.List;

import com.edu.less17.institute.model.Staff;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.Service;
import com.edu.less17.institute.service.ServiceProvider;

public class Controller {
private Service service;
	
	{
		service = ServiceProvider.getService();
	}
	
	public Controller() {
	}

	public static TrainingCourse createTrainingCourse(String specialization, int id, List<Student> students, List<Staff> staff) {
		TrainingCourse trainingCourse = new TrainingCourse(specialization, id, students, staff);
		return trainingCourse;
	}
	
	public static TrainingCourse createTrainingCourse() {
		TrainingCourse trainingCourse = new TrainingCourse();
		return trainingCourse;
	}
	
	public void addCourse(TrainingCourse course) throws IOException {
		service.addCourse(course);
	}
	
	public void removeCourseById(int id) throws IOException {
		service.removeCourseById(id);
	}
	
	public List<TrainingCourse> getCourses() throws IOException {
		return service.getCourses();
	}
	
	public void conductLesson(TrainingCourse course) {
		service.conductLesson(course);
	}
	
	public String getCourseInfo(TrainingCourse course) {
		return service.getCourseInfo(course);
	}
	
	public String getStudentsByAlphabet(TrainingCourse course) {
		return service.getStudentsByAlphabet(course);
	}
	
	public String getStudentsByAverageGrade(TrainingCourse course) {
		return service.getStudentsByAverageGrade(course);
	}
	
	public TrainingCourse getCourseById(int idCourse) throws IOException {
		TrainingCourse currentCourse = service.getCourseById(idCourse);
		return currentCourse;
	}
	
	public void addStudent(Student student, int idCourse) throws IOException {
		TrainingCourse currentCourse = service.getCourseById(idCourse);
		if (currentCourse!=null) {
			currentCourse.addStudent(student);
		}
	}
}
