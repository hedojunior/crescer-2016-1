package br.com.hedo.mapeamentocrescer16;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hedo
 */
@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQPRODUTO")
    @SequenceGenerator(name = "SQPRODUTO", sequenceName = "SQPRODUTO")
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private Long id;

    @Basic(optional = false)
    @Column(name = "NOME", length = 50)
    private String nome;

    @Basic(optional = false)
    @Column(name = "DATACADASTRO", columnDefinition = "DATE DEFAULT SYSDATE")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Basic(optional = false)
    @Column(name = "PRECOCUSTO", scale = 2, precision = 12)
    private Double precoCusto;

    @Basic(optional = true)
    @Column(name = "PRECOVENDA", scale = 2, precision = 12)
    private Double precoVenda;

    @Column(name = "SITUACAO", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'A'")
    private String situacao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public String getSituacao() {
        return situacao;
    }

    public Produto(String nome, Date dataCadastro, Double precoCusto, Double precoVenda, String situacao) {
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.situacao = situacao;
    }

    public Produto() {
    }
}
