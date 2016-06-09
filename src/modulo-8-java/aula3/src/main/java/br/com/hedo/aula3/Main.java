/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.aula3;

import DAO.PessoaDAO;
import java.sql.SQLException;
import java.util.Scanner;
import pojo.Pessoa;

/**
 *
 * @author hedo.junior
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("ajuhadfj");
        String nome = teclado.nextLine();
        try{
            PessoaDAO sb = new PessoaDAO();
            sb.insert(new Pessoa(nome));
            System.out.println("----------");
            System.out.println("Inserido com sucesso.");
            System.out.println(sb.findByName(nome));
            sb.closeConnection();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
