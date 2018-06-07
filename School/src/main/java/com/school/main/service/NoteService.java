package com.school.main.service;

import java.util.List;

import com.school.main.domain.Note;

public interface NoteService {

	Note addNote(Note note);

	List<Note> getAllNote();

	Note getNote(Long id);

	boolean deleteNote(Long id);

	List<Note> getAllStudentNote(Long id);

}
