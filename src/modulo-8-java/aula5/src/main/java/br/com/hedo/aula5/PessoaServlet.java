package br.com.hedo.aula5;

import java.io.IOException;
import java.io.PrintWriter;
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
        try (final PrintWriter out = resp.getWriter()) {
          resp.setContentType("text/html");
          out.append("Olá " + req.getParameter("pessoa.nome"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
