package nus.iss.team2.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.team2.exception.UserBlockedException;
import nus.iss.team2.model.User;
import nus.iss.team2.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	// For Register and Login
	@Override
	@Transactional
	public User register(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	@Transactional
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User login(String userID, String password) throws UserBlockedException {
		// throw new UnsupportedOperationException("Not supported yet.");
		try {
			User u = userRepository.findUserByIdPwd(userID, password);
			if (u != null) {
				if (u.getStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
					throw new UserBlockedException("Your account has been blocked. Contact to Admin.");
				} else {
					return u;
				}
			} else {
				return null;
			}
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ul = (ArrayList<User>) userRepository.findAll();
		return ul;
	}

	@Override
	@Transactional
	public User findUser(String userId) {
		return userRepository.findOne(userId);

	}

	//
	//
	@Override
	@Transactional
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	//
	//
	//
	@Override
	@Transactional
	public User changeUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	//
	@Override
	@Transactional
	public void removeUser(User user) {
		userRepository.delete(user);
	}
	//
	//
	// @Transactional
	// public User authenticate(String uname, String pwd) {
	// User u = userRepository.findUserByNamePwd(uname, pwd);
	// return u;
	// }
	/*
	 * @Override
	 * 
	 * @Transactional public ArrayList<String> findAllUserIDs() { return
	 * userRepository.findAllUserIDs(); }
	 */

}
