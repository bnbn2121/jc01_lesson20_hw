package com.edu.less17.institute.repository;

import java.io.IOException;
import java.util.List;

import com.edu.less17.institute.model.TrainingCourse;

public interface CourseRepository {
	void addCourse(TrainingCourse course) throws IOException;
	void removeCourseById(int id) throws IOException;
	List<TrainingCourse> getCourses() throws IOException;
	TrainingCourse getCourseById(int id) throws IOException;

}
