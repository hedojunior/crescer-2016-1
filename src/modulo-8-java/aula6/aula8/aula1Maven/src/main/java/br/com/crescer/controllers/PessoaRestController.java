package br.com.crescer.controllers;
import br.com.crescer.pojos.Pessoa;
import br.com.crescer.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/pessoa")
public class PessoaRestController {

    @Autowired
    PessoaService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Pessoa> list(Pageable pageable) {
        Page<Pessoa> listaPessoas = service.findAll(pageable);
        return listaPessoas;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
     public void delete(@RequestParam int id) {
        Long idPessoa = Long.valueOf(id);
        service.delete(idPessoa);
    }
     
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "text/html")
    public String save(@ModelAttribute Pessoa p){
        service.save(p);
        return ""
                + "<h1>"
                + "Salvo com sucesso!"
                + "</h1>"
                + "<a href=\"/pessoa/index\">"
                + "Voltar para listagem"
                + "</a>";
    }
}