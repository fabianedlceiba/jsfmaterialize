/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.service.impl;

import com.fernando.jsfproject.domain.User;
import com.fernando.jsfproject.entities.DbUser;
import com.fernando.jsfproject.repositories.UserRepository;
import com.fernando.jsfproject.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author
 */
@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository repository;

	@Override
	public void save(User user) {

		DbUser dbUser = user.toEntity();
		repository.save(dbUser);

		user.setId(dbUser.getId());
	}

	@Override
	public User findById(Long id) {
		User user = null;
		DbUser dbUser = repository.findById(id);

		if (dbUser != null) {
			user = new User();
			user.fromEntity(dbUser);
		}

		return user;
	}

	@Override
	public List<User> getAll() {
		List<DbUser> users = repository.getAll();

		return users.stream().map((dbUser) -> {
			User user = new User();
			user.fromEntity(dbUser);
			return user;
		}).collect(Collectors.toList());
	}

	@Override
	public List<User> findByName(String name) {
		List<DbUser> users = repository.findByName(name);

		return users.stream().map((dbUser) -> {
			User user = new User();
			user.fromEntity(dbUser);
			return user;
		}).collect(Collectors.toList());
	}

	@Override
	public void edit(User user) {
		LOG.info(user.toString());

		DbUser dbUser = user.toEntity();
		repository.edit(dbUser);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		DbUser dbUser = repository.findByNameAndPassword(username, password);
		User user = new User();
		user.fromEntity(dbUser);
		return user;
	}

}
