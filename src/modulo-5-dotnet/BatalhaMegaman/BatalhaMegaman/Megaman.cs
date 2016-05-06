using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{
    class Megaman : Robo
    {

        public Megaman() : base()
        {
            PoderDeAtaque = 6;
        }

        protected override string Nome
        {
            get
            {
                return "Megaman";
            }
        }

        public override void Atacar(Robo robo)
        {
            throw new NotImplementedException();
        }
    }
}
