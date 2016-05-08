using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{
    public class BotasSuperVelocidade : IUpgrade
    {
        public int BonusDeAtaque
        {
            get
            {
                return 1;
            }
        }

        public int BonusDeDefesa
        {
            get
            {
                return 1;
            }
        }
    }
}
