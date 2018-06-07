package com.school.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.main.domain.Note;
import com.school.main.service.NoteService;

@RestController
public class NoteController {
	
	@Autowired
	private NoteService noteService;
	
	@RequestMapping(value = "/note", method = RequestMethod.POST)
	public @ResponseBody Note addNote(@RequestBody Note note) {
		return noteService.addNote(note);
	}
	
	@RequestMapping(value = "/note", method = RequestMethod.GET)
	public @ResponseBody List<Note> getAllNote() {
		return noteService.getAllNote();
	}
	
	@RequestMapping(value = "/note/{id}", method = RequestMethod.GET)
	public @ResponseBody Note getNote(@PathVariable Long id) {
		return noteService.getNote(id);
	}
	
	@RequestMapping(value = "/note/{id}", method = RequestMethod.DELETE)
	public @ResponseBody boolean deleteNote(@PathVariable Long id) {
		return noteService.deleteNote(id);
	}
	
}
