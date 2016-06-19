/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.services;

import br.com.crescer.pojos.Pessoa;
import br.com.crescer.repositories.IPessoaRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hedo.junior
 */
@Service
public class PessoaService {

    @Autowired
    IPessoaRepository repository;

    public Iterable<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa save(Pessoa p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

}
