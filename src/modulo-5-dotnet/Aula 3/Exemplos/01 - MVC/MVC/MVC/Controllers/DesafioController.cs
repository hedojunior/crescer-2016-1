using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MVC.Models;


namespace MVC.Controllers
{
    public class DesafioController : Controller
    {
        // GET: Desafio
        public ActionResult ZenGarden(string aluno)
        {
            ViewBag.aluno = aluno;
            return View();
        }
    }
}