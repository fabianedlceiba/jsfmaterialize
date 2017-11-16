/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jsfproject.repositories;

import com.fernando.jsfproject.entities.BaseEntity;
import java.util.List;

/**
 * Repositorio génerico para el acceso a la bd de las diferentes entidades.
 *
 * @author
 * @param <T> Tipo de la entidad.
 */
public interface GenericRepository<T extends BaseEntity> {

    /**
     * Buscar una entidad por su llave primaria.
     *
     * @param id Id de la entidad.
     * @return La entidad que se encontro.
     */
    T findById(Long id);

    /**
     * Guarda una entidad en la bd.
     *
     * @param entity Entidad que se desea guardar.
     */
    void save(T entity);

    /**
     * Obtiene todos los elementos de la tabla.
     *
     * @return Todos los elementos de la tabla.
     */
    List<T> getAll();

    /**
     * Edita una entidad
     *
     * @param Entity Entidad que se desea editar.
     */
    void edit(T Entity);

    /**
     * Elimina la entidad.
     *
     * @param id Id de la entidad.
     */
    void delete(Long id);

}
