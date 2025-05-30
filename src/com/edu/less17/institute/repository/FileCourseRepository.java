package com.edu.less17.institute.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.util.ReaderFromFile;
import com.edu.less17.institute.util.WriterToFile;

public class FileCourseRepository implements CourseRepository{
	
	private final String DATA_PATH = "resources/courseData.txt";
	private WriterToFile writer = new WriterToFile();
	private ReaderFromFile reader = new ReaderFromFile();

	public FileCourseRepository() {
	}

	public void addCourse(TrainingCourse course) throws IOException {
		try {
			if (!isPresent(course)) {
				writeCourseToFile(course, true);
			}
		} catch (IOException e) {
			throw e;
		}
	}
	
	public boolean isPresent(TrainingCourse course) throws IOException {
		for (TrainingCourse someCourse:getCourses()) {
			if (someCourse.equals(course)) {
				return true;
			}
		}
		return false;
	}

	public void writeCourseToFile(TrainingCourse course, boolean rewrite) throws IOException {
		writer.writeCourseToFile(course, DATA_PATH, rewrite);
	}

	public void removeCourseById(int id) throws IOException {
		Iterator<TrainingCourse> iterator = getCourses().iterator();
		int i = 0;
		while(iterator.hasNext()) {
			TrainingCourse course = (TrainingCourse) iterator.next();
			if (course.getId()==id) {
				iterator.remove();
			} else {
				if (i==0) {
					writeCourseToFile(course, false);
				} else {
					writeCourseToFile(course, true);
				}
			}
			
		}
	}

	public List<TrainingCourse> getCourses() throws IOException {
		List<TrainingCourse> courses = new ArrayList<TrainingCourse>();
		String data = reader.getData(DATA_PATH);
		String[] dataArray = data.split("\n");
		StringBuilder sb = new StringBuilder();
			for (String tempString:dataArray) {
				if (tempString.trim().isEmpty() && sb.length()>0) {
					courses.add(new TrainingCourse().getCourseFromString(sb.toString()));
					sb.setLength(0);
				} else {
					sb.append(tempString).append("\n");
				}
			}
			if (sb.length()>0) {
				courses.add(new TrainingCourse().getCourseFromString(sb.toString()));
				sb.setLength(0);
			}
		return courses;
	}
	
	public TrainingCourse getCourseById(int id) throws IOException {
		for(TrainingCourse course:getCourses()) {
			if(id==course.getId()) {
				return course;
			}
		}
		return null;
	}

}
