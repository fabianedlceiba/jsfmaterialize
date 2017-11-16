/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.repositories.impl;

import com.fernando.jsfproject.entities.DbUser;
import com.fernando.jsfproject.repositories.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la persistencia de los usuarios en la bd.
 *
 */
@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<DbUser> implements UserRepository {

	@Override
	public List<DbUser> findByName(String name) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DbUser> query = cb.createQuery(getEntityClass());
		Root<DbUser> root = query.from(getEntityClass());
		query.select(root);
		query.where(cb.like(root.get("name"), "%" + name + "%"));
		return em.createQuery(query).getResultList();
	}

	@Override
	public DbUser findByNameAndPassword(String name, String password) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DbUser> query = cb.createQuery(getEntityClass());
		Root<DbUser> root = query.from(getEntityClass());
		query.select(root);
		
		Predicate namePredicate = cb.like(root.get("name"), name);
		Predicate passPredicate = cb.like(root.get("password"), password);
		
		query.where(namePredicate, passPredicate);
		return em.createQuery(query).getSingleResult();
	}

}
