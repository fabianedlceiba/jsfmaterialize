/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author
 */
@FacesConverter(forClass = LocalDate.class)
public class LocalDateConverter implements Converter {

	private static final String LOCAL_DATE_FORMAT = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(LOCAL_DATE_FORMAT);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if (value == null || value.isEmpty()) {
			return null;
		}
		
		return LocalDate.parse(value, FORMATTER);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof LocalDate) {
			LocalDate dateValue = (LocalDate) value;
			return dateValue.format(FORMATTER);
		}
		return null;
	}

}
