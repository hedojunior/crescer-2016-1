﻿using CdZ.Dominio;
using CdZ.MVC.Services;
using System.Net;
using System.Web;
using System.Web.Mvc;

namespace CdZ.MVC.Controllers
{
    public class CavaleiroController : Controller
    {
        private ICavaleiroRepositorio _cavaleiros = ServicoInjecaoDeDependecia.CriarCavaleiroRepositorio();

        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public JsonResult Get()
        {
            /* Para simular erro, descomente
                var status = (int)HttpStatusCode.InternalServerError;
                throw new HttpException(status, "Ops");
            */
            return Json(new { data = _cavaleiros.Todos() }, JsonRequestBehavior.AllowGet);
        }
    }
}