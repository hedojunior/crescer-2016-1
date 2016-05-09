using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{
    public class Bot : Robo
    {

        public Bot() : base()
        {

        }

        public Bot(Chip chip) : base()
        {
            ChecaChip(chip);
        }

        public override string Nome
        {
            get
            {
                return "Bot";
            }
        }

        public override void Atacar(Robo robo)
        {
            var aux = PoderDeAtaque;
            EquiparUpgradesParaBatalha();
            robo.ReceberDano(PoderDeAtaque);
            PoderDeAtaque = aux;
        }

        public override void ReceberDano(int poderDeAtaque)
        {
            var aux = PoderDeDefesa;
            EquiparUpgradesParaBatalha();
            var dano = poderDeAtaque - PoderDeDefesa;
            if (dano > 0) Vida -= dano;
            PoderDeDefesa = aux;
        }
    }
}
