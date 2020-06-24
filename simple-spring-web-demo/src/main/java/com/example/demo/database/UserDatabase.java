package com.example.demo.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserDatabase {
	private static final Map<Long, User> usersMap = new HashMap<Long, User>();
	
	public User getSingleUser(Long id) {
		return usersMap.get(id);
	}
	
	public Collection<User> getAllUsers() {
		return usersMap.values();
	}
	
	public String addUser(User user) {
		usersMap.put(user.getUserId(), user);
		return "Added.";
	}

	public String deleteUser(Long userId) {
		usersMap.remove(userId);
		return "User Removed.";
	}

	public String updateUser(Long userId, User user) {
		usersMap.put(userId, user);
		return "User Updated..";
	}

}
