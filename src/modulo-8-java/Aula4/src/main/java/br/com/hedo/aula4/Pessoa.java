package br.com.hedo.aula4;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    @Id // Identifica a PK
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA")
    @Basic(optional = false)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NM_PESSOA", length = 60)
    private String nome;

    @Basic(optional = false)
    @Column(name = "IDADE")
    private Integer idade;
    
    @Basic(optional = false)
    @Column(name = "SEXO")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Pessoa() {
    }

    public Pessoa(String nome, Sexo sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public Pessoa(String nome, Integer idade, Sexo sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    

}
