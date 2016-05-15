using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        public RepositorioVendas repo = new RepositorioVendas();

        // GET: Produto
        public ActionResult CadastrarPedido()
        {
            return View();
        }

        public ActionResult Home()
        {
            return View();
        }

        public ActionResult SalvarPedido(PedidoModel model)
        {
            if (ModelState.IsValid)
            {

                var pedido = new Pedido(model.DataEntrega, model.Nome, model.ValorVenda, model.Pagamento, model.NomeCliente, model.Cidade, model.Estado);
                //if (model.Id.HasValue)
                //    repositorio.AtualizarPedido(pedido);
                //else
                repo.IncluirPedido(pedido);
                return View("Sucesso", model);
            }
            else return View("CadastrarPedido", model);

        }

        public ActionResult ExcluirPedido(int id)
        {
            repo.ExcluirPedido(id);

            return View("Mensagem");
        }

        public ActionResult EditarPedido(int id)
        {
            var pedido = repo.ObterPedidoPorId(id);
            var model = new PedidoModel(pedido);
            repo.ExcluirPedido(pedido.Id);
            return View("CadastrarPedido", model);

        }

        public ActionResult ListaPedidos(string cliente, string produto)
        {
            List<Pedido> pedidos;
            if (cliente == null && produto == null)
            {
                pedidos = repo.ObterPedidos();
            }
            else
            {
                pedidos = repo.ObterPedidosPorNomeEProduto(cliente, produto);
            }
            return View(pedidos);

        }

        public ActionResult Detalhes(int id)
        {
            var pedido = repo.ObterPedidoPorId(id);
            return View(pedido);
        }
    }
}
