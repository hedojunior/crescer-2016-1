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
@Table(name="AMIGO")
public class Amigo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AMIGO")
    @SequenceGenerator(name = "SEQ_AMIGO", sequenceName = "SEQ_AMIGO")
    @Basic(optional = false)
    @Column(name="ID_AMIGO")
    private long id;
    
    @Basic(optional = false)
    @Column(name="DATAADICAO")
    @Temporal(TemporalType.DATE)
    private Date dataAdicao;
        
    @ManyToOne
    @JoinColumn(name="ID_USUARIO")
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public Date getDataAdicao() {
        return dataAdicao;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    
}
