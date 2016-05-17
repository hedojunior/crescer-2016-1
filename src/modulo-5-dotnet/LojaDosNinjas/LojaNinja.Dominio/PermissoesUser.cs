using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
   public class Permissao
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        
        public IList<Usuario> usuarios { get; set; }

        public Permissao(int id, string nome)
        {
            this.Id = id;
            this.Nome = nome;
        }

        public Permissao() { }
    }
}
