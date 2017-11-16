/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.repositories;

import com.fernando.jsfproject.entities.DbUser;
import java.util.List;

/**
 * Define el contrato de persistencia de la entidad user.
 *
 * @author
 */
public interface UserRepository extends GenericRepository<DbUser> {

	/**
	 * Busca un usuario por el nombre.
	 *
	 * @param name Nombre del usuario.
	 * @return Usuario.
	 */
	List<DbUser> findByName(String name);

	DbUser findByNameAndPassword(String name, String password);

}
