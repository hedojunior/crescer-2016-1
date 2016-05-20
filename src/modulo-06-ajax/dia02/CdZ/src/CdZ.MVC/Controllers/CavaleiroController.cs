using CdZ.Dominio;
using CdZ.MVC.Models.Cavaleiro;
using CdZ.MVC.Services;
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
            Thread.Sleep(3000);
            return Json(new { data = _cavaleiros.Todos() }, JsonRequestBehavior.AllowGet);
        }
        [HttpDelete]
        public JsonResult Delete(int id)
        {
            //deletar no repo
            _cavaleiros.Excluir(id);
            //Preencher status no content
            Response.StatusCode = (int)HttpStatusCode.NoContent;
            //retornar empty json
            return Json(new { });
        }

        [HttpPost]
        public JsonResult Post(CavaleiroViewModel cavaleiro)
        {
            Thread.Sleep(3000);
            var novoId = _cavaleiros.Adicionar(cavaleiro.ToModel());
            Response.StatusCode = (int)HttpStatusCode.Created;
            return Json(new { id = novoId });
        }
    }
}
