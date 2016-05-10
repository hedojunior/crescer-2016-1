using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using Microsoft.VisualBasic;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where
                (empregado => empregado.Cargo.Titulo == cargo.Titulo).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy
               (empregado => empregado.Cargo.Titulo)
               .ThenBy(empregado => empregado.Nome).ToList();   
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.Where(funcionario =>
                InternacionalizarStrings(funcionario,nome)).ToList();
        }        

        private bool InternacionalizarStrings
                (Funcionario funcionario, string param)
        {
            var nomeTransformado = funcionario.Nome.ToLower
                (System.Globalization.CultureInfo.InvariantCulture);
            var paramTransformado = param.ToLower
                (System.Globalization.CultureInfo.InvariantCulture);

            return (nomeTransformado.Contains(paramTransformado));
            
        }

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            if (turnos.Count() == 0)
                return Funcionarios.Select(funcionario => funcionario).ToList();
            else
            {
                return Funcionarios.Where(funcionario =>
                    retornaFuncionariosPorTurno(funcionario, turnos)).ToList();
            }

        }       
        private bool retornaFuncionariosPorTurno
            (Funcionario funcionario, TurnoTrabalho[] turnos)
        {
            return (turnos.Contains(funcionario.TurnoTrabalho));
            
        } 

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            return Funcionarios.Where(funcionario =>
                    IdadeEhQualificada(funcionario, idade)).ToList();
        }        

        private bool IdadeEhQualificada(Funcionario funcionario, int idade)
        {
            var diaDeHoje = DateTime.Now;
            diaDeHoje = diaDeHoje.AddYears(-(idade));

            var seMenor = funcionario.DataNascimento.Year < diaDeHoje.Year
                    && funcionario.DataNascimento.Year >= diaDeHoje.AddYears(-(5)).Year;

            var seMaior = funcionario.DataNascimento.Year > diaDeHoje.Year
                    && funcionario.DataNascimento.Year <= diaDeHoje.AddYears(5).Year;


            return seMenor || seMaior;
               
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            if (turno == null)
            {
                var listaSalarios = Funcionarios
                    .Select(funcionario => funcionario.Cargo.Salario).ToList();
                return listaSalarios.Sum() / listaSalarios.Count() ;
            }
            else
            {
                var listaSalarios = Funcionarios
                    .Where(funcionario => funcionario.TurnoTrabalho == turno)
                    .Select(funcionario => funcionario.Cargo.Salario).ToList();
                return listaSalarios.Sum() / listaSalarios.Count();       
            }
       
       }

        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.Where(funcionario =>
                ehAniversarianteDoMes(funcionario)).ToList();
        }

        private bool ehAniversarianteDoMes(Funcionario funcionario)
        {
            return funcionario.DataNascimento.Month == DateTime.Now.Month;
        }

        public IList<dynamic> BuscaRapida()
        {
            var listaRapida = ((IEnumerable<dynamic>)Funcionarios.Select(funcionario => new
            {
                NomeFuncionario = funcionario.Nome,
                TituloCargo = funcionario.Cargo.Titulo
            })).ToList();

            return listaRapida;

        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            var listaRapida = ((IEnumerable<dynamic>)Funcionarios
                .GroupBy(funcionario => funcionario.TurnoTrabalho)
                .Select(f => new
                {
                    Turno = f.Key,
                    Quantidade = f.Count()

                })).ToList();
            return listaRapida;
        }

        public dynamic FuncionarioMaisComplexo()
        {
            var listaFuncionarios = QuantidadeConsoantesPorNome();
             var maiorQtdConsoantes =
                listaFuncionarios.OrderByDescending(x => x.Consoantes).First();
            return Funcionarios
                .Where(funcionario => funcionario(maiorQtdConsoantes))
                .Where(funcionario => funcionario.Turno != TurnoTrabalho.Tarde)
                .Where(funcionario => funcionario.Cargo != "Desenvolvedor Júnior")
                .Select(funcionario => new
                {
                    Nome = funcionario.Nome,
                    DataNascimento = converterData(funcionario.DataNascimento),
                    SalarioRS = ConverterEmReal(funcionario.Salario),
                    SalarioUS = ConverterEmDolar(funcionario.Salario),
                    QuantidadeMesmoCargo = QuantidadeMesmosCargos(funcionario.Cargo)
                }).ToList();  
        }

        private int QuantidadeMesmosCargos(String cargo)
        {
            return Funcionarios.Where(funcionario => funcionario.Cargo.Titulo == cargo)
                .Count();
        }

        private string ConverterEmReal(double salario)
        {
            NumberFormatInfo nfi = new CultureInfo("pt-BR", false).NumberFormat;
            nfi.NumberDecimalSeparator = ",";
            return "R$" + salario.ToString("N", nfi);

        }

        private string ConverterEmDolar(double salario)
        {
            NumberFormatInfo nfi = new CultureInfo("en-US", false).NumberFormat;
            nfi.NumberDecimalSeparator = ".";
            return "$" + salario.ToString("N", nfi);

        }

        private string converterData(DateTime date)
        {
            return date.ToString("dd/MM/yyyy");
        }

        private int contarConsoantes(string nome)
        {
            var consoantes = 0;
            for (var i = 0; i < nome.Length; i++)
            {
                if (nome[i] != 'a' || nome[i] != 'e' || nome[i] != 'i'
                    || nome[i] != 'o' || nome[i] != 'u' || nome[i] != ' ')
                    consoantes++;
            }
            return consoantes;
        }

        private IList<dynamic> QuantidadeConsoantesPorNome()
        {
            return ((IEnumerable<dynamic>)Funcionarios
                .Select(f => new
                {
                    Nome = f.Nome,
                    Consoantes = contarConsoantes(f.Nome),
                    Cargo = f.Cargo.Titulo,
                    Turno = f.TurnoTrabalho,
                    DataNascimento = f.DataNascimento,
                    Salario = f.Cargo.Salario
                })).ToList();
        }

     }
}
