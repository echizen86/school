package com.school.main.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.main.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

}
