package com.school.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.main.domain.Course;
import com.school.main.domain.Student;
import com.school.main.repositories.CourseRepository;
import com.school.main.repositories.StudentRepository;
import com.school.main.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student getStudent(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public boolean deleteStudent(Long id) {
		if(studentRepository.findById(id).isPresent()) {
			studentRepository.deleteById(id);
			return true;
		}
		return false;		
	}

	@Override
	public List<Student> getAllStudentNotTeacher() {
		List<Student> nl = new ArrayList<>();
		List<Student> list = this.getAllStudent();
		
		for (Student student : list) {
			if(student.getTeacher() == null) {
				nl.add(student);
			}
		}
		
		return nl;
	}

	@Override
	public List<Student> getAllStudentTeacher(Long id) {
		List<Student> nl = new ArrayList<>();
		List<Student> list = this.getAllStudent();
		
		for (Student student : list) {
			if(student.getTeacher() != null && student.getTeacher().getId() == id) {
				nl.add(student);
			}
		}
		
		return nl;
	}

	@Override
	public List<Student> setAllStudentTeacher(List<Student> list) {
		for (Student student : list) {
			Student s = studentRepository.findById(student.getId()).get();
			s.setTeacher(student.getTeacher());
			studentRepository.save(s);
		}
		return (List<Student>) studentRepository.findAll();
	}
	
	@Override
	public List<Student> getAllStudentNotCourse() {
		List<Student> nl = new ArrayList<>();
		List<Student> list = this.getAllStudent();
		
		for (Student student : list) {
			if(student.getCourse().isEmpty()) {
				nl.add(student);
			}
		}
		
		return nl;
	}
	
	@Override
	public List<Student> getAllStudentCourse(Long id) {
		List<Student> nl = new ArrayList<>();
		List<Student> list = this.getAllStudent();
		
		Course c = courseRepository.findById(id).get();
		
		for (Student student : list) {
			if(!student.getCourse().isEmpty() && student.getCourse().contains(c)) {
				nl.add(student);
			}
		}
		
		return nl;
	}
	
	@Override
	public List<Student> setAllStudentCourse(List<Student> list) {
		for (Student student : list) {
			Student s = studentRepository.findById(student.getId()).get();
			s.setCourse(s.getCourse());
			studentRepository.save(s);
		}
		return (List<Student>) studentRepository.findAll();
	}

}
