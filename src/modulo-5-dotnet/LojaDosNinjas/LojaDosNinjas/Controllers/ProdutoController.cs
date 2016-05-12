using LojaNinja.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class ProdutoController : Controller
    {
        // GET: Produto
        public ActionResult CadastrarProduto()
        {
            return View();
        }

        public ActionResult SalvarProduto(ProdutoModel model)
        {
            return View("Sucesso",model);
        }
    }
}