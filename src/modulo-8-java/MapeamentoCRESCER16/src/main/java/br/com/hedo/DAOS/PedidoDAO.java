/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import br.com.hedo.mapeamentocrescer16.Material;
import br.com.hedo.mapeamentocrescer16.Pedido;
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
public class PedidoDAO extends GenericDAO<Long,Pedido> {
    
    public PedidoDAO(EntityManager em){
        super(em);
    }
    
    @Override
    public void exportToCSVFile() {
        List<Pedido> pedidos = super.buscarTodos();
        List<String> linhas = new ArrayList<>();
        SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
        for (Pedido p : pedidos) {
            
            String formatado = String.format("%s;%s;%s;%s;%s;%s;", 
                    p.getId(),sdf.format(p.getDataEntrega()),
                        sdf.format(p.getDataPedido()),p.getSituacao(),
                            p.getValorPedido(),p.getCliente().getId());
            linhas.add(formatado);
        }
        File orderExport = new File("pedidos.csv");
        try (Writer writer = new FileWriter(orderExport)) {
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
