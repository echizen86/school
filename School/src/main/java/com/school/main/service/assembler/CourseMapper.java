package com.school.main.service.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.school.main.domain.Course;
import com.school.main.service.dto.CourseDto;

@Mapper
public interface CourseMapper {
	
	CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
	
//	@Mappings({
//		@Mapping(source = "course.id", target = "courseId"),
//		@Mapping(source = "course.name", target = "courseName")
//	})
	
	CourseDto courseToCourseDTO(Course entity);

}
