/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import br.com.hedo.mapeamentocrescer16.Cliente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Hedo
 */
public class ClienteDAO extends GenericDAO<Long, Cliente> {

    public ClienteDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void exportToCSVFile() {
        List<Cliente> clientes = super.buscarTodos();
        List<String> linhas = new ArrayList<>();
        for (Cliente c : clientes) {
            String formatado = String.format("%s;%s;%s;%s;%s;%s;%s;%s;",
                    c.getId(), c.getBairro(), c.getCep(),
                    c.getEndereco(), c.getNome(), c.getRazaoSocial(),
                    c.getSituacao(), c.getCidade().getId());
            linhas.add(formatado);
        }
        File clientExport = new File("clientes.csv");
        try (Writer writer = new FileWriter(clientExport)) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                for (int i = 0; i < linhas.size(); i++) {
                    bufferedWriter.write(linhas.get(i));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
                System.out.println("Arquivo CSV exportado com sucesso.");
            } catch (IOException e) {
                System.err.println(String.format("Erro: %s", e.getMessage()));
            }
        } catch (Exception e) {
            System.err.println(String.format("Erro: %s", e.getMessage()));
        }
    }

}
