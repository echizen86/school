package com.school.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.main.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
