/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hedo.junior
 */
public interface IPessoa {
    void insert(Pessoa pessoa);
    void update(Pessoa pessoa);
    void delete(Pessoa pessoa);
    List<Pessoa> listAll();
    List<Pessoa> findByName(String nome);
    
}
