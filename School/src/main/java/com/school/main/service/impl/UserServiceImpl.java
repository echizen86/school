package com.school.main.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.main.domain.Role;
import com.school.main.domain.User;
import com.school.main.repositories.RoleRepository;
import com.school.main.repositories.UserRepository;
import com.school.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles((Set<Role>) roleRepository.findAll());
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
