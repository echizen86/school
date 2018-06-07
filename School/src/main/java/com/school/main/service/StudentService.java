package com.school.main.service;

import java.util.List;

import com.school.main.domain.Student;

public interface StudentService {
	
	Student addStudent(Student student);
	
	List<Student> getAllStudent();
	
	Student getStudent(Long id);
	
	boolean deleteStudent(Long id);
	
	List<Student> getAllStudentNotTeacher();
	
	List<Student> getAllStudentTeacher(Long id);
	
	List<Student> setAllStudentTeacher(List<Student> list);

	List<Student> getAllStudentNotCourse();

	List<Student> getAllStudentCourse(Long id);

	List<Student> setAllStudentCourse(List<Student> list);
}
