/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hedo
 */
public class SimpleEntityManager {

    private static SimpleEntityManager instance;
    private EntityManagerFactory emf;
    private EntityManager em;

    private SimpleEntityManager() {
        if (instance == null) {
            emf = Persistence.createEntityManagerFactory("CRESCER16");
            this.em = emf.createEntityManager();
        }
    }

    public static synchronized SimpleEntityManager getInstance() {
        if (instance == null) {
            instance = new SimpleEntityManager();
        }
        return instance;
    }

    public void beginTransaction() {
        em.getTransaction().begin();
    }

    public void commit() {
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }

    public void rollback() {
        em.getTransaction().rollback();
    }

    public EntityManager getEntityManager() {
        return this.em;
    }
}
