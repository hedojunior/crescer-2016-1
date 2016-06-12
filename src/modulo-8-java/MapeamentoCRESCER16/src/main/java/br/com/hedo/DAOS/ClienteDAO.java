/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import br.com.hedo.mapeamentocrescer16.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author Hedo
 */
public class ClienteDAO extends GenericDAO<Long, Cliente> {

    public ClienteDAO(EntityManager em) {
        super(em);
    }

}
