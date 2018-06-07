package com.school.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.main.domain.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>{

}
