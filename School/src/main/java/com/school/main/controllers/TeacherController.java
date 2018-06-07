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

import com.school.main.domain.Teacher;
import com.school.main.service.TeacherService;
import com.school.main.service.dto.PromotionTeacherDto;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value = "/teacher", method = RequestMethod.POST)
	public @ResponseBody Teacher addTeacher(@RequestBody Teacher teacher) {
		return teacherService.addTeacher(teacher);
	}
	
//	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public @ResponseBody List<Teacher> getAllTeacher(){
		return teacherService.getAllTeacher();
	}
	
	@RequestMapping(value="/teacher/{id}", method=RequestMethod.GET)
	public @ResponseBody Teacher getTeacher(@PathVariable Long id) {
		return teacherService.getTeacher(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/teacher/{id}", method=RequestMethod.DELETE)
	public @ResponseBody boolean deleteTeacher(@PathVariable Long id) {
		return teacherService.deleteTeacher(id);
	}
	
	@RequestMapping(value = "/teacher/{id}/promotion")
	public @ResponseBody PromotionTeacherDto promotionTeacher(@PathVariable Long id) {
		return teacherService.PromotionTeacher(id);
	}

}
