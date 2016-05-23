using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CdZ.MVC.Models
{
    public class LocalViewModel
    {
        public int Id { get; set; }
        public string Texto { get; set; }

        public Dominio.Local ToModel()
        {
            return new Dominio.Local(Id, Texto);
        }
    }
}