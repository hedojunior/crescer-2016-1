using CdZ.Dominio;
using CdZ.MVC.Models.Cavaleiro;
using CdZ.MVC.Services;
using System.Collections.Generic;
using System.Net;
using System.Threading;
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

        [HttpGet]
        public ActionResult Listagem()
        {
            IEnumerable<Cavaleiro> cavaleiros = _cavaleiros.Todos();

            return View(cavaleiros);
        }

        [HttpGet]
        [ActionName("GetById")]
        public JsonResult Get(int? id)
        {
            return Json(new {  data = _cavaleiros.Buscar(id.Value)}, JsonRequestBehavior.AllowGet);
        }

        //[HttpDelete]
        [AcceptVerbs(HttpVerbs.Get | HttpVerbs.Delete)]
        public JsonResult Delete(int id)
        {
            _cavaleiros.Excluir(id);
            return NoContentJsonVazio();
        }

        [HttpPost]
        public JsonResult Post(CavaleiroViewModel cavaleiro)
        {
           // Thread.Sleep(3000);
            var novoId = _cavaleiros.Adicionar(cavaleiro.ToModel());
            Response.StatusCode = (int)HttpStatusCode.Created;
            return Json(new { id = novoId });
        }

        public ActionResult CadastroCavaleiro()
        {
            return View();
        }

        [HttpPut]
        public JsonResult Put(CavaleiroViewModel cavaleiro)
        {
            _cavaleiros.Atualizar(cavaleiro.ToModel());
            return NoContentJsonVazio();
        }

        private JsonResult NoContentJsonVazio()
        {
            Response.StatusCode = (int)HttpStatusCode.NoContent;
            return Json(new { });
        }
    }
}
