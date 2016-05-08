using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{   
    public abstract class Robo
    {
        public Robo()
        {
            Vida = 100;
            PoderDeAtaque = 5;
            PoderDeDefesa = 0;
        }

        public abstract string Nome { get;}
        
        public List<IUpgrade> upgrades = new List<IUpgrade>();
            
        protected int Vida { get; set; }
  
        protected int PoderDeAtaque { get; set; }
        
        protected int PoderDeDefesa { get; set; }

        public virtual void Atacar(Robo robo) { }
        
        public virtual void ReceberDano(int PoderDeAtaque) { }    

        public override string ToString()
        {
            return "Nome: " + Nome + ", Vida: " + Vida + ", Ataque: "
                + PoderDeAtaque + ", Defesa: " + PoderDeDefesa;
        }
        
                
        public virtual void EquiparUpgrade(IUpgrade upgrade)
        {
            if (upgrades.Count < 3) upgrades.Add(upgrade);
        }

        public void EquiparUpgradesParaBatalha()
        {
            foreach (IUpgrade upgrade in upgrades)
            {
                PoderDeAtaque += upgrade.BonusDeAtaque;
                PoderDeDefesa += upgrade.BonusDeDefesa;
            }
         
        }
    }
}
