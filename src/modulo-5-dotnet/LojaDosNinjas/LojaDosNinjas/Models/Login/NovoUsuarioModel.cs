using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models.Login
{
    public class NovoUsuarioModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public List<string> Permissoes { get; set; }


        public NovoUsuarioModel (int id, string nome, string email, string senha)
        {
            Id = id;
            Nome = nome;
            Email = email;
            Senha = senha;
            Permissoes.Add("COMUM");
        }

        public NovoUsuarioModel() { }
    }
}