package br.com.crescer.controllers;
import br.com.crescer.controllers.Pessoa;
import br.com.crescer.services.PessoaService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaRest {

    @Autowired
    PessoaService service;
    
    @RequestMapping(value = "/current_date_time")
    public Date date() {
        return new Date();
    }
    @ResponseBody
    @RequestMapping("/pessoa")
    public List<Pessoa> list() {
        return service.list();
    }
}