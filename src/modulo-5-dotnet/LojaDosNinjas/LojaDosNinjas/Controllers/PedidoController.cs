using LojaNinja.Dominio;
using LojaNinja.MVC.Filters.BaseAulaSeguranca.Filters;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Models.Login;
using LojaNinja.MVC.Services;
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
        [HttpGet]
        [NinjaToken(Roles ="COMUM")]
        public ActionResult CadastrarPedido()
        {
            UsuarioLogadoModel usuarioLogado = ServicoSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
            return View();
        }


        [HttpGet]
        [NinjaToken(Roles="COMUM")]
        public ActionResult Home()
        {
            UsuarioLogadoModel usuarioLogado = ServicoSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
            return View();
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult SalvarPedido(PedidoModel model)
        {
            if (ModelState.IsValid)
            {
                var pedido = new Pedido
                        (model.DataEntrega, model.Nome, model.ValorVenda, 
                            model.Pagamento, model.NomeCliente, model.Cidade, model.Estado);

                repo.IncluirPedido(pedido);

                UsuarioLogadoModel usuarioLogado = ServicoSessao.UsuarioLogado;
                ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
                return View("Sucesso", model);
            }
            else
                return RedirectToAction("CadastrarPedido","Pedido", model);
        }


        [HttpGet]
        [NinjaToken(Roles = "ADMIN")]
        public ActionResult ExcluirPedido(int id)
        {
            repo.ExcluirPedido(id);

            UsuarioLogadoModel usuarioLogado = ServicoSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
            return View("Mensagem");
        }


        [HttpGet]
        [NinjaToken(Roles = "ADMIN")]
        public ActionResult EditarPedido(int id)
        {
            var pedido = repo.ObterPedidoPorId(id);
            var model = new PedidoModel(pedido);

            repo.ExcluirPedido(pedido.Id);

            return RedirectToAction("CadastrarPedido","Pedido", model);
        }


        [HttpGet]
        [NinjaToken(Roles ="COMUM")]
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

            UsuarioLogadoModel usuarioLogado = ServicoSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;
            return View(pedidos);
        }


        [HttpGet]
        [NinjaToken(Roles ="COMUM")]
        public ActionResult Detalhes(int id)
        {
            var pedido = repo.ObterPedidoPorId(id);

            UsuarioLogadoModel usuarioLogado = ServicoSessao.UsuarioLogado;
            ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;

            return View(pedido);
        }
    }
}
