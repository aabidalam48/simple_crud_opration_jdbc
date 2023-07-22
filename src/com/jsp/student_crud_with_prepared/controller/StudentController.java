package com.jsp.student_crud_with_prepared.controller;

import java.util.Scanner;

import com.jsp.student_crud_with_prepared.dto.Student;
import com.jsp.student_crud_with_prepared.service.StudentService;

//ctrl+shift+o==import all necessary package
public class StudentController {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("main method started");

		Student student = null;

		StudentService studentService = new StudentService();

		
		System.out.println("Enter Below given Option");
		System.out.println(" 1 for Insert the Data\n 2 for Update the Data\n 3 for Display the All Data");
		int ch = scanner.nextInt();

		switch (ch) {
		/*
		 * case 1 for insert data started
		 */
		case 1: {
			System.out.println("Enter student id");
			int id = scanner.nextInt();
			System.out.println("Enter student name");
			String name = scanner.next();
			System.out.println("Enter student Email");
			String email = scanner.next();
			System.out.println("Enter student phone");
			long phone = scanner.nextLong();

			student = new Student(id, name, email, phone);

			studentService.insertStudentService(student);
		}
			break;
		/*
		 * case 1 for insert data ended
		 * 
		 * case 2 for update data started
		 */
		case 2: {
			System.out.println("Please choose Below given Option to Update you Data ");
			System.out.println(" 1 for Name\n 2 for Email\n 3 for Phone");
			int ch1 = scanner.nextInt();
			switch(ch1) {
			case 1:{
				System.out.println("Enter student id");
				int id = scanner.nextInt();
				System.out.println("Enter student name");
				String name = scanner.next();

				int id1 = studentService.updateStudentNameService(id, name);
				if (id1 == 1) {
					System.out.println("Name---Updated-----Successfully--------");

				} else {
					System.out.println("id mismatch please check once");
				}
			}
				break;
			case 2:{
				System.out.println("Enter student id");
				int id = scanner.nextInt();
				System.out.println("Enter student Email");
				String email = scanner.next();

				int id1 = studentService.updateStudentEmailService(id, email);
				if (id1 == 1) {
					System.out.println("Email-ID---Updated-----Successfully--------");

				} else {
					System.out.println("id mismatch please check once");
				}
			}
				break;
			case 3:{
				System.out.println("Enter student id");
				int id = scanner.nextInt();
				System.out.println("Enter student Phone");
				long phone = scanner.nextLong();

				int id1 = studentService.updateStudentPhoneService(id, phone);
				if (id1 == 1) {
					System.out.println("Phone Number---Updated-----Successfully--------");

				} else {
					System.out.println("id mismatch please check once");
				}
			}
				break;
				
		}
			
			}
			break;
			case 3:{
				studentService.displayStudentDetails();
			}
			}
		System.out.println("main method ended!!!!");
		}
	

}
