/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controllers;

import br.com.crescer.pojos.Pessoa;
import br.com.crescer.services.PessoaService;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String list(Model model) {
        Iterable<Pessoa> pessoas = service.findAll();
         model.addAttribute("pessoa", new Pessoa());
        model.addAttribute("pessoas", pessoas);
        return "index_pessoa";
    }

}
