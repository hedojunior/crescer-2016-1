/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.DAOS;

import br.com.hedo.mapeamentocrescer16.Material;
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
public class MaterialDAO extends GenericDAO<Long, Material> {

    public MaterialDAO(EntityManager em) {
        super(em);
    }

    @Override
    public void exportToCSVFile() {
        List<Material> materiais = super.buscarTodos();
        List<String> linhas = new ArrayList<>();
        for (Material m : materiais) {
            String formatado = String.format("%s;%s;%s;%s;", m.getId(), m.getDescricao(), m.getPesoLiquido(), m.getPrecoCusto());
            linhas.add(formatado);
        }
        File materialExport = new File("materiais.csv");
        try (Writer writer = new FileWriter(materialExport)) {
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
