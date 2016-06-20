/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controllers;

import br.com.crescer.pojos.Pessoa;
import br.com.crescer.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hedo
 */
@Controller
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable) {
        Page<Pessoa> pessoas = service.findAll(pageable);
        
        model.addAttribute("pessoa", new Pessoa());
        model.addAttribute("pessoas", pessoas);
        model.addAttribute("size", 3);
        model.addAttribute("totalPages", pessoas.getTotalPages());
        return "index_pessoa";
    }
    
    public Page<Pessoa> findAll(Pageable pageable) {
    return service.findAll(pageable);
}

}
