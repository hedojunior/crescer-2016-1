package br.com.hedo.mapeamentocrescer16;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Hedo
 */
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQCLIENTE")
    @SequenceGenerator(name = "SQCLIENTE", sequenceName = "SQCLIENTE")
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NOME", length = 50)
    private String nome;

    @Basic(optional = false)
    @Column(name = "RAZAOSOCIAL", length = 50)
    private String razaoSocial;

    @Basic(optional = true)
    @Column(name = "ENDERECO", length = 35)
    private String endereco;

    @Basic(optional = true)
    @Column(name = "BAIRRO", length = 30)
    private String bairro;

    @ManyToOne(targetEntity = Cidade.class, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "IDCIDADE")
    private Cidade cidade;

    @Basic(optional = true)
    @Column(name = "CEP", precision = 8, scale = 0)
    private Integer cep;

    @Basic(optional = false)
    @Column(name = "SITUACAO", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'A'")
    private String situacao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public Integer getCep() {
        return cep;
    }

    public String getSituacao() {
        return situacao;
    }

    public Cliente(String nome, String razaoSocial, String endereco, String bairro, Cidade cidade, Integer cep, String situacao) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.situacao = situacao;
    }

    public Cliente() {
    }
}