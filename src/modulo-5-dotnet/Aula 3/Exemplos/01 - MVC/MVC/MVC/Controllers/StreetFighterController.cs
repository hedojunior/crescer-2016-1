using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {        
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View();
        }

        public ActionResult SobreMim()
        {
            var eu = new SobreMimModel
            {
                Nome = "Hedo Eccker da Silva Júnior",
                Cidade = "São Leopoldo/RS",
                LingPref = "Portugol",
                ComidaPref = "Mac'n'Cheese",
                LivroPref = "Eu sou a Lenda",
                JogoPref = "FIFA 16",
                SeriadoPref = "Breaking Bad",
                FilmePref = "Um estranho no ninho",
                MateriaPref = "Geografia"
            };

            return View(eu);
        }
    }
}