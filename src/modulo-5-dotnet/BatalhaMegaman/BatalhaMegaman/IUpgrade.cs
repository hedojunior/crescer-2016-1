using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BatalhaMegaman
{
    public interface IUpgrade
    {
        int BonusDeAtaque { get; }
        int BonusDeDefesa { get; }
    }

}
