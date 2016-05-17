using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Filters
{
    using Dominio;
    using Services;
    using Models.Login;
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Web;
    using System.Web.Mvc;
    using System.Web.Routing;

    namespace BaseAulaSeguranca.Filters
    {
        public class NinjaToken : AuthorizeAttribute
        {
            private string[] _permissoesRequeridas = null;

            public NinjaToken()
            {
            _permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ?
                                            null :
                                            this.Roles.Split(',');
            }

            private bool TemAutorizacao
            {
                get
                {
                    UsuarioLogadoModel usuarioLogado = ServicoSessao.UsuarioLogado;

                    if (this._permissoesRequeridas != null)
                    {
                        foreach (string permissao in _permissoesRequeridas)
                        {
                            if (usuarioLogado.TemPermissao(permissao))
                            {
                                return true;
                            }
                        }
                    }
                    else
                    {
                        return true;
                    }

                    return false;
                }
            }

            protected override bool AuthorizeCore(HttpContextBase httpContext)
            {
                return ServicoSessao.EstaLogado && TemAutorizacao;
            }

            public override void OnAuthorization(AuthorizationContext filterContext)
            {
                _permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ?
                                           null :
                                           this.Roles.Split(',');

                bool estaAutenticadoEAutorizado = this.AuthorizeCore(filterContext.HttpContext);

                if (!estaAutenticadoEAutorizado)
                {
                    filterContext.Result = new RedirectToRouteResult(
                                       new RouteValueDictionary
                                       {
                                       { "action", "Index" },
                                       { "controller", "Login" }
                                       });
                }

            }

        }
    }
}