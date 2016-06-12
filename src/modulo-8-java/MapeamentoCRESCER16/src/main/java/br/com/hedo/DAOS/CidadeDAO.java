/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import br.com.hedo.mapeamentocrescer16.Cidade;
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
public class CidadeDAO extends GenericDAO<Long,Cidade> {
    
    public CidadeDAO(EntityManager em){
        super(em);
    }
    
    @Override
    public void exportToCSVFile(){
        List<Cidade> cidades = super.buscarTodos();
        List<String> linhas = new ArrayList<>();
        for(Cidade c : cidades){
            String formatado = String.format("%s;%s;%s;", c.getId(),c.getNome(),c.getUf());
            linhas.add(formatado);
        }
        File cityExport = new File("cidades.csv");
        try(Writer writer = new FileWriter(cityExport)){
            try(BufferedWriter bufferedWriter = new BufferedWriter(writer)){
               for(int i = 0; i < linhas.size(); i++){
                   bufferedWriter.write(linhas.get(i));
                   bufferedWriter.newLine();
                   bufferedWriter.flush();
               }
               System.out.println("Arquivo CSV exportado com sucesso.");
            }catch(IOException e){
                System.err.println(String.format("Erro: %s", e.getMessage()));
            }
        }catch(Exception e){
            System.err.println(String.format("Erro: %s", e.getMessage()));
        }
    }
    
}
