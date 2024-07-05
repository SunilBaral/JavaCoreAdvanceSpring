package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean go = true;
		while (go) {
			try {
				System.out.println("Choose an option:");
				System.out.println("1. Insert Student");
				System.out.println("2. Get Student");
				System.out.println("3. Get All Students");
				System.out.println("4. Delete Student");
				System.out.println("5. Update Student");
				System.out.println("6. Exit");
				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					Student student = new Student(2327, "sunilll", "bbsr");
					studentDao.insert(student);
					break;
				case 2:
					Student student2 = studentDao.getStudent(2324);
					System.out.println(student2);
					break;
				case 3:
					List<Student> allStudents = studentDao.getAllStudents();
					System.out.println(allStudents);
					break;
				case 4:
					studentDao.deleteStudent(2324);
					break;
				case 5:
					Student student1 = new Student(23281, "sunilll", "bbsr");
					studentDao.updateStudent(student1);
					break;
				case 6:
					go = false;
					break;
				default:
					System.out.println("Invalid input. Please try again.");
				}
			} catch (IOException | NumberFormatException e) {
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
}
