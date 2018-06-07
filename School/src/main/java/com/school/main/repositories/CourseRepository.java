package com.school.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.main.domain.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{

}
