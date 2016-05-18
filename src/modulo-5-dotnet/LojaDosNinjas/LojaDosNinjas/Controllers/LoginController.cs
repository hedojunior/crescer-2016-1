using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using LojaNinja.MVC.Models.Login;
using LojaNinja.Dominio;
using Repositorio;
using LojaNinja.MVC.Services;
using LojaNinja.MVC.Filters.BaseAulaSeguranca.Filters;

namespace LojaNinja.MVC.Controllers
{
    public class LoginController : Controller
    {
        private UsuarioServico _usuarioServico;

        public LoginController()
        {
            _usuarioServico = new UsuarioServico(
                    new UsuarioRepositorioADO()
                );
        }

        // GET: Usuario
        [HttpGet]
        public ActionResult Index()
        {
            if (!ServicoSessao.EstaLogado)
            {
                return View();
            }
            return View("Home");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(LoginViewModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha);

                if (usuarioEncontrado.Email != null)
                {
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);

                    ServicoSessao.CriarSessao(usuarioLogadoModel);
                    UsuarioLogadoModel usuarioLogado = ServicoSessao.UsuarioLogado;
                    ViewBag.NomeUsuarioLogado = usuarioLogado.Nome;

                    return View("Home");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index", loginViewModel);
        }

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Salvar(NovoUsuarioModel model)
        {
            if(ModelState.IsValid)
            {
                var user = new Usuario(model.Nome, model.Senha, model.Email);
                _usuarioServico.InserirUsuarioAoBanco(user);
                return View("Mensagem");
            }

            return View("Index", model);

        }
    }
}