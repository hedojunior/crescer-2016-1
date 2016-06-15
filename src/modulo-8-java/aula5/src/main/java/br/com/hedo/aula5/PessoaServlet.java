package br.com.hedo.aula5;

import br.com.hedo.aula4.PessoaDAO;
import br.com.hedo.aula4.Pessoa;
import br.com.hedo.aula4.Sexo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hedo.junior
 */
@WebServlet(name = "pessoa", urlPatterns = {"/pessoa"})
public class PessoaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Pessoa> pessoas =  new PessoaDAO().listAll();
            req.setAttribute("pessoas", pessoas);
            
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nome = req.getParameter("pessoa.nome");
        int idade = Integer.parseInt(req.getParameter("pessoa.idade"));
        Sexo sexo = Sexo.valueOf(req.getParameter("pessoa.sexo"));
        
        if(nome != null && sexo != null && idade != 0){
            Pessoa pessoa = new Pessoa(nome,idade,sexo);
            PessoaDAO pdao = new PessoaDAO();
            pdao.beginTransaction();
            pdao.create(pessoa);
            pdao.commit();
        }
    }
}
