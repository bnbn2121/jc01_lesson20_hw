package com.edu.less17.institute.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TrainingCourse {
	private String specialization;
	private int id;
	private List<Student> students;
	private List<Staff> staff;

	public TrainingCourse() {
		this.specialization = "Нет специализации";
		this.id = 0;
		this.students = new ArrayList<Student>();
		this.staff = new ArrayList<Staff>();
	}

	public TrainingCourse(String specialization, int id, List<Student> students, List<Staff> staff) {
		this.specialization = specialization;
		this.id = id;
		this.students = students;
		this.staff = staff;
	}

	
	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public void addStudent(Student student) {
		if (!students.contains(student)) {
			students.add(student);
		} else {
			throw new RuntimeException("Не удалось добавить студента");
		}
	}
	
	public void addStaff(Staff newStaff) {
		boolean isPresent = false;
		for(Staff s:staff) {
			if(s.getClass().isInstance(newStaff)||newStaff.getClass().isInstance(s)) {
				isPresent = true;
				break;
			}
		}
		if (!isPresent) {
			staff.add(newStaff);
		} else {
			throw new RuntimeException("Не удалось добавить сотрудника");
		}
	}

	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("Course data:\n");
		sb.append(String.format("id: %d\n", id));
		sb.append(String.format("specialization: %s\n", specialization));
		sb.append("staff:\n");
		for (Person p : staff) {
			sb.append(p.getName()).append(" (").append(p.getClass().getSimpleName()).append(")")
					.append("\n");
		}
		sb.append("students:\n");
		for (Person p : students) {
			sb.append(p.getName()).append(" (").append(p.getClass().getSimpleName()).append(")").append("\n");
		}
		return sb.toString();
	}

	public void conductLesson() {
		for (Person person : staff) {
			person.doSomething();
		}
		for (Person person : students) {
			person.doSomething();
		}
	}

	public double getAverageCourseGrade() {
		double sum = 0;
		for (Student s : students) {
			sum += s.getAverageGrade();
		}
		double result = ((int) (sum / students.size() * 10)) / 10.0;
		return result;
	}
	
	public String getStringData() {
		StringBuilder sb = new StringBuilder();
		sb.append("Course data:\n");
		sb.append(String.format("id: %d\n", id));
		sb.append(String.format("specialization: %s\n", specialization));
		sb.append("staff:\n");
		for (Staff s: staff) {
			sb.append(s.getStringData()).append("\n");
		}
		sb.append("students:\n");
		for (Student s: students) {
			sb.append(s.getStringData()).append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}
	
	public TrainingCourse getCourseFromString(String str) {
		if (str==null) {
			return null;
		}
		String[] dataArray = str.split("\n");
		for (String oneLine: dataArray) {
			oneLine = oneLine.trim();
			if(oneLine.startsWith("id")) {
				id = Integer.valueOf(oneLine.substring(4));
				continue;
			}
			if(oneLine.startsWith("specialization")) {
				specialization = oneLine.substring(16);
				continue;
			}
			if(oneLine.startsWith("Student")) {
				students.add(new Student().readDataFromString(oneLine));
				continue;
			}
			if(oneLine.startsWith("Administrator")) {
				staff.add(new Administrator().readDataFromString(oneLine));
				continue;
			}
			if(oneLine.startsWith("Teacher")) {
				staff.add(new Teacher().readDataFromString(oneLine));
				continue;
			}
		}
		return this;
	}
	
	public String getStudentsByAlphabet() {
		List<Student> sortedStudents = new ArrayList<Student>(students);
		Collections.sort(sortedStudents, new ComparatorByAlphabet());
		StringBuilder sb = new StringBuilder();
		sb.append("students by alphabet:\n");
		for (Student s: sortedStudents) {
			sb.append(String.format("%s - %.1f", s.getName(), s.getAverageGrade())).append("\n");
		}
		return sb.toString();
	}
	
	public String getStudentsByAverageGrade() {
		List<Student> sortedStudents = new ArrayList<Student>(students);
		Collections.sort(sortedStudents, new ComparatorByAvearageGrade());
		StringBuilder sb = new StringBuilder();
		sb.append("students by average grade:\n");
		for (Student s: sortedStudents) {
			sb.append(String.format("%s - %.1f", s.getName(), s.getAverageGrade())).append("\n");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, specialization, staff, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainingCourse other = (TrainingCourse) obj;
		return id == other.id && Objects.equals(specialization, other.specialization)
				&& Objects.equals(staff, other.staff) && Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "TrainingCourse [" + (specialization != null ? "specialization=" + specialization + ", " : "") + "id="
				+ id + ", " + (students != null ? "students=" + students + ", " : "")
				+ (staff != null ? "staff=" + staff : "") + "]";
	}

	
}
