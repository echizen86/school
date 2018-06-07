package com.school.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.main.domain.Course;
import com.school.main.domain.Note;
import com.school.main.domain.Student;
import com.school.main.domain.Teacher;
import com.school.main.repositories.TeacherRepository;
import com.school.main.service.NoteService;
import com.school.main.service.StudentService;
import com.school.main.service.TeacherService;
import com.school.main.service.assembler.TeacherMapper;
import com.school.main.service.dto.PromotionTeacherDto;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private NoteService noteService;
	
	@Override
	public Teacher addTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		return (List<Teacher>) teacherRepository.findAll();
	}

	@Override
	public Teacher getTeacher(Long id) {
		return teacherRepository.findById(id).get();
	}

	@Override
	public boolean deleteTeacher(Long id) {
		if(teacherRepository.findById(id).isPresent()) {
			teacherRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public PromotionTeacherDto PromotionTeacher(Long id) {
		Teacher teacher = teacherRepository.findById(id).get();
		
		List<Student> students = studentService.getAllStudentTeacher(id);
		
		List<Course> courses = teacher.getCourse();
		
		List<Student> result = new ArrayList<>();
		
		for(int i = 0; i < teacher.getCourse().size(); i++) {
			Course c = teacher.getCourse().get(i);
			for(int j = 0; j < students.size(); j++) {
				if(students.get(j).getCourse().contains(c)) {
					result.add(students.get(j));
				}
			}
		}
		
		List<Float> aveNote = new ArrayList<>();
		
		for(int i = 0; i < result.size(); i++) {
			int k = 1;
			List<Note> notes = noteService.getAllStudentNote(result.get(i).getId());
			int ave = 0;
			for(int j = 0; j < notes.size(); j++) {
				ave += notes.get(j).getNote();
				k++;
			}
			aveNote.add((float) (ave/k));
		}
		
		PromotionTeacherDto t = TeacherMapper.INSTANCE.teacherToPromotionTeacherDto(teacher);
		
		return t;
	}

}
