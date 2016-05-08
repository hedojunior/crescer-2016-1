using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{
    public class Megaman : Robo
    {

        public Megaman() : base()
        {
            PoderDeAtaque = 6;
        }

        public override string Nome
        {
            get
            {
                return "Megaman";
            }
        }

        public override void Atacar(Robo robo)
        {
            var aux = PoderDeAtaque;
            EquiparUpgradesParaBatalha();
            if (Vida < 30)PoderDeAtaque += 3;
            robo.ReceberDano(PoderDeAtaque);
            PoderDeAtaque = aux;
        }

        public override void ReceberDano(int poderDeAtaque)
        {
            var aux = PoderDeDefesa;
            EquiparUpgradesParaBatalha();
            var dano = poderDeAtaque - PoderDeDefesa;
            if (dano > 0)Vida -= dano;
            PoderDeDefesa = aux;
        }
    }
}
