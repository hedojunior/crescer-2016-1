using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{
    public class CanhaoDePlasma : IUpgrade
    {
       public int BonusDeAtaque
        {
            get
            {
                return 2;
            }
        }

        public int BonusDeDefesa
        {
            get
            {
                return 0;
            }
        }
    }
}
