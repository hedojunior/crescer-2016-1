/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.aula1;

public class Exercicio2 { 
 
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        
        for(Estados e : Estados.values()){
            String nome = e.getNome().replaceAll("([A-Z])", " $1");
            sb.append(nome + ",");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.insert(sb.length()-1,".");
        System.out.print(sb);
    }
   
}   





