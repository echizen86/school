package com.school.main.service.dto;

import java.util.List;

import com.school.main.domain.Course;
import com.school.main.domain.Note;
import com.school.main.domain.Student;
import com.school.main.domain.Teacher;

public class PromotionTeacherDto {
	
//	private Teacher teacher;
//
//	public Teacher getTeacher() {
//		return teacher;
//	}
//
//	public void setTeacher(Teacher teacher) {
//		this.teacher = teacher;
//	}
	
//	private List<Student> students;
//	
//	private List<Course> courses;
//	
//	private List<Note> notes;
	
	private String firstName;
	
	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
