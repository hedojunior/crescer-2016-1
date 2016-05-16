using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Services
{
    public static class ServicoSessao
    {
        private const string COOKIE_AUTENTICACAO = "COOKIE_AUTENTICACAO";
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";

        private static Dictionary<string, string> _usuariosLogados = new Dictionary<string, string>();

        public static UsuarioLogadoModel UsuarioLogado
        {
            get
            {
                return (UsuarioLogadoModel)HttpContext.Current.Session[USUARIO_LOGADO];
            }
        }
    }
}