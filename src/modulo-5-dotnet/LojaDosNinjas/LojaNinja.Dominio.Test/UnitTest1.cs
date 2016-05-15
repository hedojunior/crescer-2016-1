using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LojaNinja.Dominio;

namespace LojaNinja.Dominio.Test
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void CriaPedidoSemIDCorretamente()
        {

            var pedido = new Pedido(new DateTime(2018,10,20,20,54,20),"Kunai",1200,TipoPagamento.Diners,"Hedo","SL","RS");
            Assert.AreEqual("Hedo",pedido.NomeCliente);
            Assert.AreEqual("RS", pedido.Estado);
            Assert.AreEqual("SL", pedido.Cidade);
            Assert.AreEqual(TipoPagamento.Diners, pedido.TipoPagamento);
            Assert.AreEqual(1200, pedido.Valor);
            Assert.AreEqual("Kunai", pedido.NomeProduto);
            Assert.AreEqual(new DateTime(2018,10,20,20,54,20), pedido.DataEntregaDesejada);
        }

        [TestMethod]
        public void CriaPedidoComIDCorretamente()
        {

            var pedido = new Pedido(1, new DateTime(2018, 10, 20, 20, 54, 19),new DateTime(2018, 10, 20, 20, 54, 20), "Kunai", 1200, TipoPagamento.Diners, "Hedo", "SL", "RS",true);
            Assert.AreEqual("Hedo", pedido.NomeCliente);
            Assert.AreEqual(true, pedido.PedidoUrgente);
            Assert.AreEqual(1, pedido.Id);
            Assert.AreEqual("RS", pedido.Estado);
            Assert.AreEqual("SL", pedido.Cidade);
            Assert.AreEqual(TipoPagamento.Diners, pedido.TipoPagamento);
            Assert.AreEqual(1200, pedido.Valor);
            Assert.AreEqual("Kunai", pedido.NomeProduto);
            Assert.AreEqual(new DateTime(2018, 10, 20, 20, 54, 19), pedido.DataPedido);
            Assert.AreEqual(new DateTime(2018, 10, 20, 20, 54, 20), pedido.DataEntregaDesejada);
        }

    }
}
