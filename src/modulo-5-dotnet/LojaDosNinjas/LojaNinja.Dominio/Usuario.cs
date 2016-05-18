using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Senha { get; set; }
        public string Email { get; set; }
        public List<string> Permissoes { get; set; }

        public IList<Permissao> permissoes { get; set; }

        public Usuario(string nome, string senha, string email)
        {
            this.Id = 0;
            this.Nome = nome;
            this.Email = email;
            this.Senha = senha;
            this.Permissoes = new List<string>();
            this.Permissoes.Add("COMUM");
        }

        public Usuario() { }

    }
}
