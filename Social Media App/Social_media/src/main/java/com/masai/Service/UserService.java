package com.masai.Service;

import java.util.List;

import com.masai.model.User;

public interface UserService {

	public User createUser(User user);
	
	public User updateUser(User user, String key);
	
	
	public List<User> findbyname(String name, String key);
}
