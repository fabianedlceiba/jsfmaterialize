/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.beans;

import com.fernando.jsfproject.domain.User;
import com.fernando.jsfproject.service.UserService;
import com.fernando.jsfproject.utils.SessionHelper;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 *
 */
@ManagedBean(name = "login")
@ViewScoped
public class LoginBean implements Serializable {

	private static final String INDEX = "/faces/pages/index.xhtml?faces-redirect=true";

	private String name;
	private String password;

	@ManagedProperty("#{UserServiceImpl}")
	private UserService service;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public UserService getService() {
		return service;
	}

	public String login() {

		User user = getService().findByUsernameAndPassword(getName(), getPassword());

		if (user != null) {
			SessionHelper.setAttribute("userid", user.getId());

			return INDEX;
		}

		
		return null;
	}

}
