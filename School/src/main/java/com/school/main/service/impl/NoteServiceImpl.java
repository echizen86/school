package com.school.main.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.main.domain.Note;
import com.school.main.repositories.NoteRepository;
import com.school.main.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private NoteRepository noteRepository;
	
	@Override
	public Note addNote(Note note) {
		return noteRepository.save(note);
	}

	@Override
	public List<Note> getAllNote() {
		return (List<Note>) noteRepository.findAll();
	}

	@Override
	public Note getNote(Long id) {
		return noteRepository.findById(id).get();
	}

	@Override
	public boolean deleteNote(Long id) {
		if(noteRepository.findById(id).isPresent()) {
			noteRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	@Override
	public List<Note> getAllStudentNote(Long id) {
		List<Note> nl = new ArrayList<>();
		List<Note> list = this.getAllNote();
		
		for (Note note : list) {
			if(note.getStudent() != null && note.getStudent().getId() == id) {
				nl.add(note);
			}
		}
		
		return nl;
	}
}
