package com.school.main.service;

import java.util.List;

import com.school.main.domain.Course;
import com.school.main.service.dto.CourseDto;

public interface CourseService {

	Course addCourse(Course course);

	List<Course> getAllCourse();

	CourseDto getCourse(Long id);

	boolean deleteCourse(Long id);

}
