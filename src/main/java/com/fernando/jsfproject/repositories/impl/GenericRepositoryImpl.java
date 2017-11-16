/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.repositories.impl;

import com.fernando.jsfproject.entities.BaseEntity;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.fernando.jsfproject.repositories.GenericRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author fabiand
 * @param <T> Type.
 */
public abstract class GenericRepositoryImpl<T extends BaseEntity> implements GenericRepository<T> {

    @PersistenceContext
    protected EntityManager em;
    private Class<T> entityClass;

    protected Class<T> getEntityClass() {
        if (entityClass == null) {
            ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                    .getGenericSuperclass();
            entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        }
        return entityClass;
    }

    @Override
    public T findById(Long id) {
        return em.find(getEntityClass(), id);
    }

    @Override
    public void save(T entity) {
        this.em.persist(entity);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getEntityClass());
        query.select(query.from(getEntityClass()));
        return em.createQuery(query).getResultList();
    }

    @Override
    public void edit(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(Long id) {
        T entity = findById(id);
        if (entity != null) {
            em.remove(entity);
        }
    }

}
