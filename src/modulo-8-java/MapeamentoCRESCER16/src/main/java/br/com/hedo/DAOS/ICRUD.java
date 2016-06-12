/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import java.util.List;

/**
 *
 * @author Hedo
 */
public interface ICRUD<PK, T> {

    void delete(T entity);

    void create(T entity);

    void save(T entity);

    T buscarPorId(PK pk);

    List<T> buscarTodos();

}
