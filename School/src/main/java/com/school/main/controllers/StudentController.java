package com.school.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.school.main.domain.Student;
import com.school.main.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public @ResponseBody Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@RequestMapping(value = "/student/prueba", method = RequestMethod.GET)
	public @ResponseBody Object getTest() {

		RestTemplate rest = new RestTemplate();	
		
		try {
			Student s = rest.exchange("http://localhost:8080/student/73", HttpMethod.GET, null, Student.class).getBody();
			return s;
		} catch (Exception e) {
			System.out.println("ERROR: School2Service getTest is down");
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public @ResponseBody List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public @ResponseBody Student getStudent(@PathVariable Long id) {
		return studentService.getStudent(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}

	@RequestMapping(value = "/teacher/assignstudent", method = RequestMethod.GET)
	public @ResponseBody List<Student> getAllStudentNotTeacher() {
		return studentService.getAllStudentNotTeacher();
	}

	@RequestMapping(value = "/teacher/assignstudent/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Student> getAllStudentTeacher(@PathVariable Long id) {
		return studentService.getAllStudentTeacher(id);
	}

	@CrossOrigin
	@RequestMapping(value = "/teacher/assignstudent/save", method = RequestMethod.POST)
	public @ResponseBody List<Student> setAllStudentTeacher(@RequestBody List<Student> list) {
		return studentService.setAllStudentTeacher(list);
	}
	
	@RequestMapping(value = "/course/assignstudent", method = RequestMethod.GET)
	public @ResponseBody List<Student> getAllStudentNotCourse() {
		return studentService.getAllStudentNotCourse();
	}
	
	@RequestMapping(value = "/course/assignstudent/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Student> getAllStudentCourse(@PathVariable Long id) {
		return studentService.getAllStudentCourse(id);
	}
	
	@RequestMapping(value = "/course/assignstudent/save", method = RequestMethod.POST)
	public @ResponseBody List<Student> setAllStudentCourse(@RequestBody List<Student> list) {
		return studentService.setAllStudentCourse(list);
	}

}
