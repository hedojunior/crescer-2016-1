package br.com.hedo.crescer.web;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "hello")
@RequestScoped
public class Hello implements Serializable {

    private String helloWorld = "Hello World!";

    public String getHelloWorld() {
        return helloWorld;
    }
    
    @PostConstruct
    public void init(){
        helloWorld = "Wello World!";
        System.out.println("..............................");
    }
    
    @PreDestroy
    public void out(){
        System.out.println("Terminou");
    }

    public void setHelloWorld(String helloWorld) {
        this.helloWorld = helloWorld;
    }

}