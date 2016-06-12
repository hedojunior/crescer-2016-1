/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import br.com.hedo.mapeamentocrescer16.Produto;
import javax.persistence.EntityManager;

/**
 *
 * @author Hedo
 */
public class ProdutoDAO extends GenericDAO<Long,Produto> {
    
    public ProdutoDAO(EntityManager em){
        super(em);
    }
}
