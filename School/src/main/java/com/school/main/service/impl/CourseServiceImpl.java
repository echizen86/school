package com.school.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.main.domain.Course;
import com.school.main.repositories.CourseRepository;
import com.school.main.service.CourseService;
import com.school.main.service.assembler.CourseMapper;
import com.school.main.service.dto.CourseDto;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	//@Autowired
	//private CourseMapper courseMapper;

	@Override
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourse() {
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public CourseDto getCourse(Long id) {
		Course course = courseRepository.findById(id).get();
		CourseDto c = CourseMapper.INSTANCE.courseToCourseDTO(course);
		// CourseDto c = courseMapper.courseToCourseDTO(course);
		return c;
	}

	@Override
	public boolean deleteCourse(Long id) {
		if (courseRepository.findById(id).isPresent()) {
			courseRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
