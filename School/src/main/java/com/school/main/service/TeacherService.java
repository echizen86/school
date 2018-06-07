package com.school.main.service;

import java.util.List;

import com.school.main.domain.Teacher;
import com.school.main.service.dto.PromotionTeacherDto;

public interface TeacherService {
	
	Teacher addTeacher(Teacher teacher);
	
	List<Teacher> getAllTeacher();
	
	Teacher getTeacher(Long id);
	
	boolean deleteTeacher(Long id);

	PromotionTeacherDto PromotionTeacher(Long id);

}
