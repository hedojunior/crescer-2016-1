using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{
    public class EscudoDeEnergia : IUpgrade
    {
        public int BonusDeAtaque
        {
            get
            {
                return 0;
            }
        }

        public int BonusDeDefesa
        {
            get
            {
                return 2;
            }
        }
    }
}
