/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.entities;

import com.fernando.jsfproject.enums.EGender;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author fabiand
 */
@Entity
@Table(name = "User")
public class DbUser extends DbBase {

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Column(name = "gender")
	@Enumerated(EnumType.ORDINAL)
	private EGender gender;
	
	@Column(name = "password", length = 30)
	private String password;

	public DbUser() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public EGender getGender() {
		return gender;
	}
	
	public void setGender(EGender gender) {
		this.gender = gender;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
