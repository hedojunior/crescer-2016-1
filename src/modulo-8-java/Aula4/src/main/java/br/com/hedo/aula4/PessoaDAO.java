/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.aula4;

import br.com.hedo.aula4.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Hedo
 */
public class PessoaDAO {

    private final EntityManager em;

    public PessoaDAO() {
        this.em = Persistence.createEntityManagerFactory("CRESCER16").createEntityManager();
    }

    public void beginTransaction() {
        this.em.getTransaction().begin();
    }

    public void commit() {
        this.em.getTransaction().commit();
    }

    public void close() {
        this.em.close();
    }

    public EntityManager getEntityManager() {
        return this.em;
    }

    public void create(Pessoa pessoa) {
        this.em.persist(pessoa);
    }

    public void update(Pessoa pessoa) {
        this.em.merge(pessoa);
    }

    public void delete(Pessoa pessoa) {
        this.em.remove(pessoa);
    }

    public List<Pessoa> getByName(String name) {
        Session session = this.em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Restrictions.ilike("NOME", name, MatchMode.ANYWHERE));

        return criteria.list();
    }

    public Pessoa getById(Long id) {
        return this.em.find(Pessoa.class, id);
    }

    public List<Pessoa> listAll() {
        Session session = this.em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Pessoa.class);

        return criteria.list();
    }

}
