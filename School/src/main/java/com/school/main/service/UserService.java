package com.school.main.service;

import com.school.main.domain.User;

public interface UserService {

	User save(User user);

	User findByUserName(String username);

}
