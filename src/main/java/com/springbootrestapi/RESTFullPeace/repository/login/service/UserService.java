package com.springbootrestapi.RESTFullPeace.repository.login.service;

import com.springbootrestapi.RESTFullPeace.login.model.User;

public interface UserService {
	   public User findUserByEmail(String email);
	   public void saveUser(User user);
	}


