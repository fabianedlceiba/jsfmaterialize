/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.enums;

/**
 *
 *
 */
public enum EGender {
	FEMALE("enum.gender.female"), MALE("enum.gender.male");

	private final String messageKey;

	EGender(String messageKey) {
		this.messageKey = messageKey;
	}
	
	public String getMessageKey() {
		return messageKey;
	}
}
