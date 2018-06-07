package com.school.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.main.domain.Course;
import com.school.main.service.CourseService;
import com.school.main.service.dto.CourseDto;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@CrossOrigin
	@RequestMapping(value = "/course", method = RequestMethod.POST)
	public @ResponseBody Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	
	@RequestMapping(value = "/course", method = RequestMethod.GET)
	public @ResponseBody List<Course> getAllCourse() {
		return courseService.getAllCourse();
	}
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
	public @ResponseBody CourseDto getCourse(@PathVariable Long id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteCourse(@PathVariable Long id) {
		return courseService.deleteCourse(id);
	}

}
