using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public string Nome { get; set; }
        public string Senha { get; set; }
        public string Email { get; set; }
        public PermissoesUser Permissoes { get; set; }

        public Usuario(string nome, string senha, string email)
        {
            this.Nome = nome;
            this.Email = email;
            this.Senha = senha;
            Permissoes = PermissoesUser.COMUM;
        }

        public Usuario() { }

    }
}
