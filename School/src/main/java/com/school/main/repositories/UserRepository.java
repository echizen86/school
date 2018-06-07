package com.school.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.main.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByUserName(String userName);

}
