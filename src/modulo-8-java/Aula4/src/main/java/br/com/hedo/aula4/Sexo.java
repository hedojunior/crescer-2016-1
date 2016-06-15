/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.aula4;

/**
 *
 * @author Hedo
 */
    public enum Sexo {
    
    
    
    MASCULINO("MASCULINO"),
    FEMININO("FEMININO"),
    OUTRO("OUTRO");
    
    
    public String valor;
    
    
    Sexo(String opcao){
        valor = opcao;
    }

    String getValor(){
    return valor;
    }
}
