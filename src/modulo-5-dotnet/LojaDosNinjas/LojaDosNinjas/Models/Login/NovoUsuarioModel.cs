using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models.Login
{
    public class NovoUsuarioModel
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "Você tem certeza que digitou seu nome?")]
        [StringLength(160)]
        public string Nome { get; set; }

        [Required(ErrorMessage = "Você tem certeza que digitou seu email corretamente?")]
        [EmailAddress]
        [StringLength(160)]
        public string Email { get; set; }

        [Required(ErrorMessage = "Você tem certeza que digitou sua senha?")]
        [StringLength(30)]
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