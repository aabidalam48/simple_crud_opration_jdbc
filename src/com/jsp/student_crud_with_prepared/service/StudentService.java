package com.jsp.student_crud_with_prepared.service;

import com.jsp.student_crud_with_prepared.dao.StudentDao;
import com.jsp.student_crud_with_prepared.dto.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();

	public Student insertStudentService(Student student) {

		if (student.getStudentId() <= 9999) {
			Student student2 = studentDao.insertStudent(student);
			return student2;
		} else {
			System.err.println("plese pass your id with 4 digits or less than it");
		}
		return null;
	}
	/*insert student data method ended
	 * 
	 * update studentName method started
	 */

	public int updateStudentNameService(int studentId, String studentName) {

		return studentDao.updateStudentName(studentId, studentName);
	}
	/*update studentName method ended
	 * 
	 * Update studentEmail method started
	 */
	
	public int updateStudentEmailService(int studentId, String studentEmail) {
		
		return studentDao.updateStudentEmail(studentId, studentEmail);
	}
	/*
	 * update studentEmail method ended
	 * 
	 * update studentPhone method started
	 */
	public int updateStudentPhoneService(int studentId, long studentPhone) {
		
		return studentDao.updateStudentPhone(studentId, studentPhone);
	}
	/*
	 * this is display method will display all data of students
	 */
	public void displayStudentDetails() {
		 studentDao.displayStudentDetails();
	}
}
	
