package com.school.main.service.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.school.main.domain.Student;
import com.school.main.domain.Teacher;
import com.school.main.service.dto.PromotionTeacherDto;
import com.school.main.service.dto.StudentDto;

@Mapper
public interface TeacherMapper {
	
	TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);
	
	PromotionTeacherDto teacherToPromotionTeacherDto(Teacher entity);

}
