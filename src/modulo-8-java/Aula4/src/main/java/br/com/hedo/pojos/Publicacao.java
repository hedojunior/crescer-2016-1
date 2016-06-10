/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.pojos;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author hedo.junior
 */
@Entity
@Table(name = "PUBLICACAO")
public class Publicacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PUBLICACAO")
    @SequenceGenerator(name = "SEQ_PUBLICACAO", sequenceName = "SEQ_PUBLICACAO")
    @Basic(optional = false)
    @Column(name="ID_PUBLICACAO")
    private long id;
    
    @Basic(optional = false)
    @Column(name="DATAEHORA")
    @Temporal(TemporalType.DATE)
    private Date dataEHora;
    
    @Basic(optional = false)
    @Column(name = "CONTEUDO")
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    public long getId() {
        return id;
    }

    public Date getDataEHora() {
        return dataEHora;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
