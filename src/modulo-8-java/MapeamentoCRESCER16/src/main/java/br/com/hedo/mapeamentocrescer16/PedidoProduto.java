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
@Table(name = "PEDIDOITEM")
public class PedidoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQPEDIDOITEM")
    @SequenceGenerator(name = "SQPEDIDOITEM", sequenceName = "SQPEDIDOITEM")
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private Long id;

    @OneToOne(targetEntity = Pedido.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPEDIDO")
    private Pedido pedido;

    @OneToOne(targetEntity = Produto.class, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    @Basic(optional = false)
    @Column(name = "QUANTIDADE", scale = 3, precision = 12)
    private Double quantidade;

    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO", scale = 2, precision = 12)
    private Double precoUnitario;

    @Basic(optional = false)
    @Column(name = "SITUACAO", columnDefinition = "VARCHAR2(1) DEFAULT 'A'")
    private String situacao;

    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public String getSituacao() {
        return situacao;
    }

    public PedidoProduto(Pedido pedido, Produto produto, Double quantidade, Double precoUnitario, String situacao) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.situacao = situacao;
    }

    public PedidoProduto() {
    }
}
