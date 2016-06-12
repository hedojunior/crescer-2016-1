/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author Hedo
 */
public class GenericDAO<PK,T> implements ICRUD<PK,T> {
    
    EntityManager em;
    
    public GenericDAO(EntityManager entityManager){
        this.em = entityManager;
    }
    
    @SuppressWarnings("unchecked")
    public T buscarPorId(PK pk){
        return (T) em.find(getTypeClass(), pk);
    }
    
    public void create(T entity){
        em.persist(entity);
    }
    
    public void save(T entity){
        em.merge(entity);
    }
    
    public void delete(T entity){
        em.remove(entity);
    }
    
    public List<T> buscarTodos(){
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(getTypeClass());
        return criteria.list();
    }
    
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
