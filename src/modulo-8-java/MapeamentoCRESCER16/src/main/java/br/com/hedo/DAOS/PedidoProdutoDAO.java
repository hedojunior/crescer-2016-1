/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import br.com.hedo.mapeamentocrescer16.Material;
import br.com.hedo.mapeamentocrescer16.PedidoProduto;
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
public class PedidoProdutoDAO extends GenericDAO<Long,PedidoProduto> {
    
    public PedidoProdutoDAO(EntityManager em){
        super(em);
    }
    
    @Override
    public void exportToCSVFile() {
        List<PedidoProduto> pedidosprodutos = super.buscarTodos();
        List<String> linhas = new ArrayList<>();
        for (PedidoProduto pp : pedidosprodutos) {
            String formatado = String.format("%s;%s;%s;%s;%s;%s;", 
                    pp.getId(),pp.getPrecoUnitario(),
                        pp.getQuantidade(),pp.getSituacao(),
                            pp.getPedido().getId(),pp.getProduto().getId());
            linhas.add(formatado);
        }
        File orderItemExport = new File("pedidoitem.csv");
        try (Writer writer = new FileWriter(orderItemExport)) {
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
