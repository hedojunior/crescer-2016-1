package br.com.hedo.mapeamentocrescer16;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Hedo
 */
@Entity
@Table(name = "PRODUTOMATERIAL")
public class ProdutoMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQPRODUTOMATERIAL")
    @SequenceGenerator(name = "SQPRODUTOMATERIAL", sequenceName = "SQPRODUTOMATERIAL")
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private Long id;

    @OneToOne(targetEntity = Produto.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    @OneToOne(targetEntity = Material.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDMATERIAL")
    private Material material;

    @Basic(optional = true)
    @Column(name = "QUANTIDADE", scale = 3, precision = 12)
    private Double quantidade;

    public Long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public Material getMaterial() {
        return material;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public ProdutoMaterial(Produto produto, Material material, Double quantidade) {
        this.produto = produto;
        this.material = material;
        this.quantidade = quantidade;
    }

    public ProdutoMaterial() {
    }
}
