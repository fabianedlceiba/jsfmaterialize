/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.service;

import com.fernando.jsfproject.domain.User;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fabiand
 */
@Transactional
public interface UserService {

	/**
	 *
	 * @param user
	 */
	void save(User user);

	/**
	 *
	 * @param id
	 * @return
	 */
	User findById(Long id);

	/**
	 *
	 * @param name
	 * @return
	 */
	List<User> findByName(String name);

	/**
	 *
	 * @return
	 */
	List<User> getAll();

	/**
	 * Edita un usuario.
	 *
	 * @param user Usuario.
	 */
	void edit(User user);

	/**
	 * Elimina un usuario.
	 *
	 * @param id Id del usuario.
	 */
	void delete(Long id);

	/**
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	User findByUsernameAndPassword(String username, String password);

}
