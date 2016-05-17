using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UsuarioRepositorioEF
{
    class UsuarioRepositorioEF : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            using (var db = new ContextoDeDados())
            {
                    
            }
        }
    }
}
