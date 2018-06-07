package com.school.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.main.domain.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{

}
