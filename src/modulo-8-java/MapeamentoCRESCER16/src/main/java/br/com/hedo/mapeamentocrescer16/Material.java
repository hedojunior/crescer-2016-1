package br.com.hedo.mapeamentocrescer16;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Hedo
 */
@Entity
@Table(name = "MATERIAL")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQMATERIAL")
    @SequenceGenerator(name = "SQMATERIAL", sequenceName = "SQMATERIAL")
    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private Long id;

    @Basic(optional = false)
    @Column(name = "DESCRICAO", length = 50)
    private String descricao;

    @Basic(optional = false)
    @Column(name = "PESOLIQUIDO", scale = 5, precision = 15)
    private Double pesoLiquido;

    @Basic(optional = false)
    @Column(name = "PRECOCUSTO", scale = 2, precision = 12)
    private Double precoCusto;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public Double getPrecoCusto() {
        return precoCusto;
    }

    public Material(String descricao, Double pesoLiquido, Double precoCusto) {
        this.descricao = descricao;
        this.pesoLiquido = pesoLiquido;
        this.precoCusto = precoCusto;
    }

    public Material() {
    }
}