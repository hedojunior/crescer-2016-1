using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{
    public class Protoman : Robo
    {
        
        private int NumeroMortes { get; set; }

        public Protoman() : base()
        {
            PoderDeDefesa = 2;
        }

        public override string Nome
        {
            get
            {
               return "Protoman";
            }
        }

        public override void ReceberDano(int poderDeAtaque)
        {
            var aux = PoderDeDefesa;
            EquiparUpgradesParaBatalha();
            var dano = poderDeAtaque - PoderDeDefesa;

            if (dano > 0) Vida -= dano;

            if (Vida <= 0 && NumeroMortes == 0)
            {
                Vida = 20;
                NumeroMortes = 1;
                PoderDeAtaque = 7;
            }
            else if (Vida <= 0) { Vida = 0; }
            PoderDeDefesa = aux;
        }

        public override void Atacar(Robo robo)
        {
            var aux = PoderDeAtaque;
            EquiparUpgradesParaBatalha();
            robo.ReceberDano(PoderDeAtaque);
            PoderDeAtaque = aux;
        }

    }
}
