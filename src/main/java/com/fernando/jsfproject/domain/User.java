/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.domain;

import com.fernando.jsfproject.entities.DbUser;
import com.fernando.jsfproject.enums.EGender;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author
 */
public class User implements Serializable {

    private Long id;
    private String name;
    private String lastName;
		private String password;
		private EGender gender;
		private LocalDate birthday;

    public User() {
    }

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }
		
		public void setGender(EGender gender) {
			this.gender = gender;
		}
		
		public EGender getGender() {
			return gender;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setBirthday(LocalDate birthday) {
			this.birthday = birthday;
		}
		
		public LocalDate getBirthday() {
			return birthday;
		}

    public DbUser toEntity() {
        DbUser dbUser = new DbUser();
        dbUser.setId(getId());
        dbUser.setName(getName());
        dbUser.setLastName(getLastName());
				dbUser.setGender(getGender());
				dbUser.setPassword(getPassword());
        return dbUser;
    }

    public void fromEntity(DbUser user) {
        setId(user.getId());
        setName(user.getName());
        setLastName(user.getLastName());
				setGender(user.getGender());
				setPassword(user.getPassword());
    }

    @Override
    public String toString() {
        return String.format("Id: %s, Name: %s, Apellido: %s, Genero: %s", getId(), getName(), getLastName(), getGender());
    }
    
    
}
