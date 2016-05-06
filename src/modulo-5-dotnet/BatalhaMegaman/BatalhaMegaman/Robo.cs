using System;
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



        protected abstract string Nome { get;}
        
        public int Vida { get; set; }
  
        protected int PoderDeAtaque { get; set; }
        
        protected int PoderDeDefesa { get; set; }
    
        public virtual void Atacar(Robo robo);
    }
    
}
