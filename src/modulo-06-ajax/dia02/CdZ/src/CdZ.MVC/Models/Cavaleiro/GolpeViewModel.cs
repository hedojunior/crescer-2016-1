using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CdZ.MVC.Models.Cavaleiro
{
    public class GolpeViewModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }


        public Dominio.Golpe ToModel()
        {
            return new Dominio.Golpe(Id, Nome);
        }
    }

}