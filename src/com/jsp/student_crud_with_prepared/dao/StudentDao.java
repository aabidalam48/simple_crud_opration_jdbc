package com.jsp.student_crud_with_prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.student_crud_with_prepared.connection.StudentConnection;
import com.jsp.student_crud_with_prepared.dto.Student;

public class StudentDao {

	Connection connection = StudentConnection.getStudentConnection();

	/*
	 * insert method for student
	 */
	public Student insertStudent(Student student) {

		String insertQuery = "insert into student values(?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setString(3, student.getStudentEmail());
			preparedStatement.setLong(4, student.getStudentPhone());

			preparedStatement.execute();

			return student;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}/* Method insert ended */

	/*
	 * update studentName methods started
	 */
	public int updateStudentName(int studentId, String studentName) {

		String updateStudentNameQuery = "update student set studentName=? where studentId=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateStudentNameQuery);

			preparedStatement.setInt(2, studentId);
			preparedStatement.setString(1, studentName);

			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/*Update studentName method ended
	 * 
	 * Update studentEmail method started
	 */
	public int updateStudentEmail(int studentId, String studentEmail) {
		
		String updateStudentEmailQuery = "update student set studentEmail = ? where studentId = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateStudentEmailQuery);
			
			preparedStatement.setInt(2, studentId);
			preparedStatement.setString(1, studentEmail);
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;	
	}
	/*
	 * Update studentEmail method ended
	 * 
	 * Update studentPhone method started
	 */
	public int updateStudentPhone(int studentId, long studentPhone) {
		
		String updateStudentPhoneQuery = "update student set studentPhone = ? where studentId = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateStudentPhoneQuery);
			
			preparedStatement.setInt(2, studentId);
			preparedStatement.setLong(1, studentPhone);
			
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public void displayStudentDetails() {
		
		String displayStudentQuery = "SELECT * FROM student";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayStudentQuery);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			
			int id = resultSet.getInt("studentId");
			String name = resultSet.getString("studentName");
			String email = resultSet.getString("studentEmail");
			long phone =resultSet.getLong("StudentPhone");
			
			
			System.out.println("studentId-- = "+id);
			System.out.println("studentName-- = "+name);
			System.out.println("studentEmail-- = "+email);
			System.out.println("studentPhone-- = "+phone);
			System.out.println("===================");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
