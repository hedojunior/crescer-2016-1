using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using LojaNinja.MVC.Models.Login;

namespace LojaNinja.MVC.Controllers
{
    public class LoginController : Controller
    {
        // GET: Usuario
        public ActionResult Index()
        {
            return View();
        }

        //public ActionResult Entrar(LoginViewModel model)
        //{
        //     throw NotImplementedException;
        //}
    }
}