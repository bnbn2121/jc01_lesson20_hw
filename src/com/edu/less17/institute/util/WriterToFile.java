package com.edu.less17.institute.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.edu.less17.institute.model.TrainingCourse;

public class WriterToFile {
	
	public void writeCourseToFile(TrainingCourse course, String path, boolean rewrite) throws IOException{
	    try (BufferedWriter bWriter = new BufferedWriter(
	            new OutputStreamWriter(new FileOutputStream(path, rewrite)))) {
	        bWriter.write(course.getStringData());
	    } catch (FileNotFoundException e) {
	        throw e;
	    } catch (IOException e) {
	        throw new IOException("Failed to write data to file: " + e.getMessage(), e);
	    }
	}
	
	
	
}
