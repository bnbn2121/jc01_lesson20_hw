package com.edu.less17.institute.main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.edu.less17.institute.controller.Controller;
import com.edu.less17.institute.model.Administrator;
import com.edu.less17.institute.model.Staff;
import com.edu.less17.institute.model.Student;
import com.edu.less17.institute.model.Teacher;
import com.edu.less17.institute.model.TrainingCourse;
import com.edu.less17.institute.service.ServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException, URISyntaxException {

		//создаем персонал
		List<Staff> staff = new ArrayList<>();
		staff.add(new Teacher("Виктор Олегович", "История"));
		staff.add(new Administrator("Олег Олегович"));
		
		//создаем студентов
		List<Student> students = new ArrayList<>();
		students.add(new Student("Игорь", "РН-09-3"));
		students.add(new Student("Роман", "НД-09-1"));
		students.add(new Student("Алина", "РН-09-3"));
		students.add(new Student("Степан", "РН-09-4"));
		students.add(new Student("Владислав", "НД-09-1"));

		//создаем курс
		TrainingCourse course1 = ServiceImpl.createTrainingCourse();
		course1.setId(1);
		course1.setSpecialization("История");
		course1.setStaff(staff);
		course1.setStudents(students);

		//создаем репозиторий, сервис и контроллер
		Controller controller = new Controller();
		
		//записываем данные о курсе в файл
		controller.addCourse(course1);
		controller.addCourse(course1);
		
		//читаем данные курса из файла
		TrainingCourse course2 = controller.getCourseById(1);
		
		//проводим изменение данных в курсе
		course2.setId(3);
		course2.addStudent(new Student("Анна", "НД-09-1"));
		
		//обфусцируем данные студента
		course2.getStudents().get(1).obfuscateName();
		
		//добавляем второй курс в файл
		controller.addCourse(course2);
		controller.addCourse(course2);
		controller.addCourse(course2);
		
		//удаляем первый курс из файла
		controller.removeCourseById(1);

		//проводим урок
		System.out.println("Проводим урок:");
		controller.conductLesson(course1);
		System.out.println();
		
		//Выводим информацию в консоль
		System.out.println("Информация о курсе1:");
		System.out.println(controller.getCourseInfo(course1));
		
		System.out.println("Информация о курсе2:");
		System.out.println(controller.getCourseInfo(controller.getCourseById(3)));
		
		System.out.println("Сортировка студентов по алфавиту:");
		System.out.println(controller.getStudentsByAlphabet(course2));
				
		System.out.println("Сортировка студентов по среднему баллу:");
		System.out.println(controller.getStudentsByAverageGrade(course2));
		
		

	}

}
