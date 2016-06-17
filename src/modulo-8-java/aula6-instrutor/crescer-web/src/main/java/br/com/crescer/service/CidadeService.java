/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service;

import br.com.crescer.entity.Cidade;
import br.com.crescer.service.abstracts.AbstractService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hedo.junior
 */
@Stateless
public class CidadeService extends AbstractService<Cidade> {
    
    @PersistenceContext(name = "crescerPU")
    private EntityManager entityManager;
    
    public CidadeService(){
        super(Cidade.class);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
}
