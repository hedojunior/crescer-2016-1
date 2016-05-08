using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{
    public class Rush : Robo, IUpgrade
    {

        public Rush() : base()
        {
        PoderDeAtaque = 4;
        PoderDeDefesa = 3;
        }

        public override string Nome
        {
            get
            {
                return "Rush";
            }
        }

        public int BonusDeAtaque
        {
            get
            {
                EquiparUpgradesParaBatalha();
                return PoderDeAtaque;
            }
        }

        public int BonusDeDefesa
        {
            get
            {
                EquiparUpgradesParaBatalha();
                return PoderDeDefesa;
            }
        }

        public override void EquiparUpgrade(IUpgrade upgrade)
        {
            if (upgrades.Count < 2) upgrades.Add(upgrade); 
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
