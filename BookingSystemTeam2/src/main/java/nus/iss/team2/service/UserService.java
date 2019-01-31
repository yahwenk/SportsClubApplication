package nus.iss.team2.service;

import java.util.ArrayList;
import java.util.List;

import nus.iss.team2.exception.UserBlockedException;
import nus.iss.team2.model.User;

public interface UserService {
	public static final String LOGIN_STATUS_ACTIVE = "Active";
	public static final String LOGIN_STATUS_BLOCKED = "Blocked";

	public static final String ROLE_ADMIN = "Admin";
	public static final String ROLE_USER = "User";

	User register(User user);

	User login(String userID, String password) throws UserBlockedException;

	List<User> getUserList();

	ArrayList<User> findAllUsers();

	User findUser(String userId);

	User createUser(User user);

	User changeUser(User user);

	//
	void removeUser(User user);
	//
	// User authenticate(String uname, String pwd);
	//
	// ArrayList<String> findAllUserIDs();

}