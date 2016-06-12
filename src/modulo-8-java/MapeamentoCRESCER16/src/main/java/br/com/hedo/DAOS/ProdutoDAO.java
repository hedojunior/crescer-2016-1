/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import br.com.hedo.mapeamentocrescer16.Material;
import br.com.hedo.mapeamentocrescer16.Produto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Hedo
 */
public class ProdutoDAO extends GenericDAO<Long, Produto> {

    public ProdutoDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void exportToCSVFile() {
        List<Produto> produtos = super.buscarTodos();
        List<String> linhas = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Produto p : produtos) {
            String formatado = String.format("%s;%s;%s;%s;%s;%s;",
                    p.getId(), sdf.format(p.getDataCadastro()),
                        p.getNome(), p.getPrecoCusto(),
                            p.getPrecoVenda(), p.getSituacao());
            linhas.add(formatado);
        }
        File productExport = new File("produtos.csv");
        try (Writer writer = new FileWriter(productExport)) {
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
