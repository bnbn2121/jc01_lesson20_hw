package com.edu.less17.institute.model;

import java.util.Comparator;

public class ComparatorByAvearageGrade implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
	}
	
}
