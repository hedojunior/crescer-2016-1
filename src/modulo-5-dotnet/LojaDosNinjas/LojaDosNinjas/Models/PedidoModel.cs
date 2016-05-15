using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;


namespace LojaNinja.MVC.Models
{
    public class PedidoModel
    {
        public int Id { get; set; }
            
        [Display(Name = "Data de entrega: ")]
        [Required(ErrorMessage ="Digite a data de entrega")]
        public DateTime DataEntrega { get; set; }

        [Display(Name = "Nome do produto: ")]
        [Required(ErrorMessage = "Digite o nome do produto")]
        [StringLength(160)]
        public string Nome { get; set; }


        [Display(Name = "Valor de venda: ")]
        [Required(ErrorMessage = "Digite o valor de venda")]
        public decimal ValorVenda { get; set; }

        [Display(Name = "Pagamento: ")]
        [Required(ErrorMessage = "Escolha o modo de pagamento")]
        public TipoPagamento Pagamento { get; set; }


        [Display(Name = "Nome do cliente: ")]
        [Required(ErrorMessage = "Digite o nome do cliente")]
        [StringLength(160)]
        public string NomeCliente { get; set; }


        [Display(Name = "Cidade: ")]
        [Required(ErrorMessage = "Digite a cidade")]
        [StringLength(160)]
        public string Cidade { get; set; }


        [Display(Name = "Estado: ")]
        [Required(ErrorMessage = "Digite o estado")]
        [StringLength(160)]
        public string Estado { get; set; }

        public PedidoModel(DateTime dataEntrega, string nome, decimal valorVenda, TipoPagamento pagamento, string cliente, string cidade, string estado)
        {
            DataEntrega = dataEntrega;
            Nome = nome;
            ValorVenda = valorVenda;
            Pagamento = pagamento;
            NomeCliente = cliente;
            Cidade = cidade;
            Estado = estado;     
        }

        public PedidoModel() { }

        public PedidoModel(Pedido pedido) {
            Id = pedido.Id;
            DataEntrega = pedido.DataEntregaDesejada;
            Nome = pedido.NomeProduto;
            ValorVenda = pedido.Valor;
            Pagamento = pedido.TipoPagamento;
            NomeCliente = pedido.NomeCliente;
            Cidade = pedido.Cidade;
            Estado = pedido.Estado;
       }

    }

   

}