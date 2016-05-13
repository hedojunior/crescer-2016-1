using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class ProdutoController : Controller
    {
        public RepositorioVendas repo = new RepositorioVendas();

        // GET: Produto
        public ActionResult CadastrarProduto()
        {
            return View();
        }

        public ActionResult SalvarProduto(ProdutoModel model)
        {
            return View("Sucesso",model);
        }

        public ActionResult ListaPedidos(string cliente, string produto)
        {
            var pedidos = repo.ObterPedidos();
            return View(pedidos);

        }
    }
}