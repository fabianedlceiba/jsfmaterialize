/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.beans;

import com.fernando.jsfproject.domain.User;
import com.fernando.jsfproject.service.UserService;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author
 */
@ManagedBean(name = "user")
@ViewScoped
public class UserBean implements Serializable {

	private static final Logger LOG = LoggerFactory.getLogger(UserBean.class);

	@ManagedProperty("#{UserServiceImpl}")
	private UserService service;

	private boolean showAll;
	private List<User> users;
	private User item;
	private String userName;

	public UserBean() {
		this.showAll = true;
	}

	@PostConstruct
	public void init() {
		LOG.info("Iniciando ..... ");
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserService getService() {
		return this.service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public void setShowAll(boolean showAll) {
		this.showAll = showAll;
	}

	public boolean isShowAll() {
		return showAll;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setItem(User item) {
		this.item = item;
	}

	public User getItem() {
		return this.item;
	}

	/**
	 * Realiza la busqueda dependiendo de los filtros.
	 */
	public void search() {
		this.users = service.findByName(getUserName());

		LOG.info("Size " + this.users.size());

	}

	/**
	 * Guarda en base de datos el objeto actual.
	 */
	public void save() {

		if (getItem() == null) {
			return;
		}

		LOG.info(getItem().toString());

		if (getItem().getId() == null) {
			service.save(getItem());
		} else {
			service.edit(getItem());
		}

		this.showAll = true;
		setItem(null);
		reset();
	}

	/**
	 * Crea un nuevo usuario.
	 */
	public void create() {
		this.showAll = false;
		setItem(new User());

		reset();
	}

	/**
	 * Edita un usuario.
	 *
	 * @param id Id del usuario.
	 */
	public void edit(Long id) {
		this.showAll = false;
		setItem(service.findById(id));
	}

	/**
	 * Elimina el usuario.
	 *
	 * @param id Id del usuario que se desea eliminar.
	 */
	public void delete(Long id) {
		service.delete(id);
		users.removeIf(user -> Objects.equals(user.getId(), id));
	}

	/**
	 * Devuelve a la vista de consulta.
	 */
	public void back() {
		this.showAll = true;
		reset();
	}

	private void reset() {
		this.users = Collections.emptyList();
		this.userName = null;
	}

}
