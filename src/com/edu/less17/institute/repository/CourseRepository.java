package com.edu.less17.institute.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.edu.less17.institute.model.TrainingCourse;

public class CourseRepository {
	
	//пока так и не разобрался как задать относительный путь без использования папки src в адресе
	private final String DATA_PATH = "src/resources/courseData.txt";

	public CourseRepository() {
	}

	public void addCourse(TrainingCourse course) throws IOException {
		try (FileOutputStream fileOutputStream = new FileOutputStream(DATA_PATH, true);
				OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
				BufferedWriter bWriter = new BufferedWriter(writer)) {
			if (!isPresent(course)) {
				writeCourseInFile(course, true);
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

	public void writeCourseInFile(TrainingCourse course, boolean rewrite) throws IOException {
		try (FileOutputStream fileOutputStream = new FileOutputStream(DATA_PATH, rewrite);
				OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream);
				BufferedWriter bWriter = new BufferedWriter(writer)) {
			bWriter.write(course.getStringData());
		} catch (IOException e) {
			throw e;
		}
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
					writeCourseInFile(course, false);
				} else {
					writeCourseInFile(course, true);
				}
			}
			
		}
	}

	public List<TrainingCourse> getCourses() throws IOException {
		List<TrainingCourse> courses = new ArrayList<TrainingCourse>();
		StringBuilder sb = new StringBuilder();
		String tempString;
		try (FileInputStream fileInputStream = new FileInputStream(DATA_PATH);
				InputStreamReader reader = new InputStreamReader(fileInputStream);
				BufferedReader bReader = new BufferedReader(reader)) {
			while ((tempString = bReader.readLine()) != null) {
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
			
		} catch (IOException e) {
			throw e;
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
