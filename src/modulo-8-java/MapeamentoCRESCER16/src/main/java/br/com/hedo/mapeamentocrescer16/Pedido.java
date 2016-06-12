package br.com.hedo.mapeamentocrescer16;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hedo
 */
@Entity
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQPEDIDO")
    @SequenceGenerator(name = "SQPEDIDO", sequenceName = "SQPEDIDO")
    @Basic(optional = false)
    @Column(name = "IDPEDIDO")
    private Long id;

    @ManyToOne(targetEntity = Cliente.class, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;

    @Basic(optional = false)
    @Column(name = "DATAPEDIDO")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @Basic(optional = true)
    @Column(name = "DATAENTREGA")
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Basic(optional = false)
    @Column(name = "VALORPEDIDO", scale = 2, precision = 12)
    private Double valorPedido;

    @Basic(optional = false)
    @Column(name = "SITUACAO", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'A'")
    private String situacao;

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public Double getValorPedido() {
        return valorPedido;
    }

    public String getSituacao() {
        return situacao;
    }

    public Pedido(Cliente cliente, Date dataPedido, Date dataEntrega, Double valorPedido, String situacao) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.valorPedido = valorPedido;
        this.situacao = situacao;
    }

    public Pedido() {
    }
}
