package com.edu.less17.institute.repository;

public class CourseRepositoryProvider {
	    private static final CourseRepository repo = new FileCourseRepository();

	    private CourseRepositoryProvider() {}

	    public static CourseRepository getCourseRepository() {
	    	return repo;
	    }
}
