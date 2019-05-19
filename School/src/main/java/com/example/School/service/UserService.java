package com.example.School.service;

import com.example.School.model.User;



public interface UserService {
	User save(User user);

	User findByEmail(String email);

}
