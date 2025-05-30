package com.edu.less17.institute.service;

import java.io.IOException;
import java.util.List;

import com.edu.less17.institute.model.Staff;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.repository.CourseRepository;
import com.edu.less17.institute.repository.CourseRepositoryProvider;

public class ServiceImpl implements Service{
	private CourseRepository courses;
	
	{
		courses = CourseRepositoryProvider.getCourseRepository();
	}
	
	public ServiceImpl() {
	}

	public ServiceImpl(CourseRepository courses) {
		this.courses = courses;
	}

	public CourseRepository getCourseRepository() {
		return courses;
	}

	public void setCourseRepository(CourseRepository courses) {
		this.courses = courses;
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
		courses.addCourse(course);
	}
	
	public void removeCourseById(int id) throws IOException {
		courses.removeCourseById(id);
	}
	
	public List<TrainingCourse> getCourses() throws IOException {
		return courses.getCourses();
	}
	
	public void conductLesson(TrainingCourse course) {
		course.conductLesson();
	}
	
	public String getCourseInfo(TrainingCourse course) {
		return course.getInfo();
	}
	
	public String getStudentsByAlphabet(TrainingCourse course) {
		return course.getStudentsByAlphabet();
	}
	
	public String getStudentsByAverageGrade(TrainingCourse course) {
		return course.getStudentsByAverageGrade();
	}
	
	public TrainingCourse getCourseById(int idCourse) throws IOException {
		TrainingCourse currentCourse = courses.getCourseById(idCourse);
		return currentCourse;
	}
	
	public void addStudent(Student student, int idCourse) throws IOException {
		TrainingCourse currentCourse = courses.getCourseById(idCourse);
		if (currentCourse!=null) {
			currentCourse.addStudent(student);
		}
	}
	
	
	
}
