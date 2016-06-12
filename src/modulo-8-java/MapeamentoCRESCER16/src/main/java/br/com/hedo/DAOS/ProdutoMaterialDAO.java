/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import br.com.hedo.mapeamentocrescer16.ProdutoMaterial;
import javax.persistence.EntityManager;

/**
 *
 * @author Hedo
 */
public class ProdutoMaterialDAO extends GenericDAO<Long,ProdutoMaterial> {
    
    public ProdutoMaterialDAO(EntityManager em){
        super(em);
    }
}
