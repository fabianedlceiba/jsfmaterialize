/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.beans;

import com.fernando.jsfproject.enums.EGender;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author fabian.diaz
 */
@ManagedBean(name = "dropdownlist")
@ApplicationScoped
public class DropDownListBean {
	
	public EGender[] getGenders() {
		return EGender.values();
	}
	
}
