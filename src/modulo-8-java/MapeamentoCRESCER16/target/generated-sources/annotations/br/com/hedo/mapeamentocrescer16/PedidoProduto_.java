package br.com.hedo.mapeamentocrescer16;

import br.com.hedo.mapeamentocrescer16.Pedido;
import br.com.hedo.mapeamentocrescer16.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-11T19:51:57")
@StaticMetamodel(PedidoProduto.class)
public class PedidoProduto_ { 

    public static volatile SingularAttribute<PedidoProduto, Double> precoUnitario;
    public static volatile SingularAttribute<PedidoProduto, String> situacao;
    public static volatile SingularAttribute<PedidoProduto, Produto> produto;
    public static volatile SingularAttribute<PedidoProduto, Pedido> pedido;
    public static volatile SingularAttribute<PedidoProduto, Long> id;
    public static volatile SingularAttribute<PedidoProduto, Double> quantidade;

}