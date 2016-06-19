/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.repositories;

import br.com.crescer.pojos.Pessoa;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Hedo
 */
public interface IPessoaRepository extends CrudRepository<Pessoa, Long> {
    
}
