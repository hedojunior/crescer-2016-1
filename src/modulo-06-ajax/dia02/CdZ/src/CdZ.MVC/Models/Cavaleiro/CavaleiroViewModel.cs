﻿using CdZ.Dominio;
using System;
using System.Linq;
using System.Collections.Generic;
using Dominio = CdZ.Dominio;
using System.Web.Script.Serialization;
using CdZ.MVC.Extensions;

namespace CdZ.MVC.Models.Cavaleiro
{
    public class CavaleiroViewModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public double AlturaCm { get; set; }
        public double PesoLb { get; set; }
        public string DataNascimento { get; set; }
        [ScriptIgnore]
        public DateTime DataNascimentoObj
        {
            get { return DataNascimento.FromISOToDateTime(); }
            set { DataNascimento = value.FromDateTimeToISOString(); }
        }
        public Signo Signo { get; set; }
        public TipoSanguineo TipoSanguineo { get; set; }
        public LocalViewModel LocalNascimento { get; set; }
        public LocalViewModel LocalTreinamento { get; set; }
        public IList<GolpeViewModel> Golpes { get; set; }
        public IList<ImagemViewModel> Imagens { get; set; }

        public CavaleiroViewModel() { }

        public Dominio.Cavaleiro ToModel()
        {
            var golpesObj = Golpes.Select(_ =>_.ToModel()).ToList();
            var imagensObj = Imagens.Select(_ => _.ToModel()).ToList();

            return new Dominio.Cavaleiro
                (Nome, AlturaCm, PesoLb, DataNascimentoObj, Signo, TipoSanguineo, 
                LocalNascimento.ToModel(), LocalTreinamento.ToModel(), golpesObj, imagensObj);
        }
    }
}