using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using BatalhaMegaman;

namespace UnitTestProject1
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void NomeDoMegamanQuandoCriadoRealmenteÉMegaman()
        {
            var mgmn = new Megaman();
            Assert.AreEqual("Megaman", mgmn.Nome);
        }

        [TestMethod]
        public void NomeDoProtomanQuandoCriadoRealmenteÉProtoman()
        {
            var ptmn = new Protoman();
            Assert.AreEqual("Protoman", ptmn.Nome);
        }

        [TestMethod]
        public void NomeDoBotQuandoCriadoRealmenteÉBot()
        {
            var bot = new Bot();
            Assert.AreEqual("Bot", bot.Nome);
        }

        [TestMethod]
        public void toStringDoBotRetornaStringCorreta()
        {
            var bot = new Bot();
            Assert.AreEqual("Nome: Bot, Vida: 100, Ataque: 5, Defesa: 0", bot.ToString());
        }

        [TestMethod]
        public void ProtomanFicaCom20DeVidaE7DeAtaqueQuandoMorrePelaPrimeiraVez()
        {
            var proto = new Protoman();
            proto.ReceberDano(102);
            Assert.AreEqual
                ("Nome: Protoman, Vida: 20, Ataque: 7, Defesa: 2", proto.ToString());
        }

        [TestMethod]
        public void ProtomanFicaCom0DeVidaQuandoMorrePelaSegundaVez()
        {
            var proto = new Protoman();
            proto.ReceberDano(102);
            proto.ReceberDano(22);
            proto.ReceberDano(42);
            Assert.AreEqual
                ("Nome: Protoman, Vida: 0, Ataque: 7, Defesa: 2", proto.ToString());
        }

        [TestMethod]
        public void ProtomanEquipaUmUpgrade()
        {
            var proto = new Protoman();
            CanhaoDePlasma upgrade = new CanhaoDePlasma();
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgradesParaBatalha();
            Assert.AreEqual
                ("Nome: Protoman, Vida: 100, Ataque: 7, Defesa: 2", proto.ToString());
        }

        [TestMethod]
        public void ProtomanEquipaDoisUpgrades()
        {
            var proto = new Protoman();
            CanhaoDePlasma upgrade = new CanhaoDePlasma();
            var upgrade1 = new EscudoDeEnergia();
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgrade(upgrade1);
            proto.EquiparUpgradesParaBatalha();
            Assert.AreEqual
                ("Nome: Protoman, Vida: 100, Ataque: 7, Defesa: 4", proto.ToString());
        }

        [TestMethod]
        public void ProtomanEquipaTresUpgradesIguais()
        {
            var proto = new Protoman();
            CanhaoDePlasma upgrade = new CanhaoDePlasma();
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgradesParaBatalha();
            Assert.AreEqual
                ("Nome: Protoman, Vida: 100, Ataque: 11, Defesa: 2", proto.ToString());
        }

        [TestMethod]
        public void ProtomanEquipaTresUpgradesQuandoSaoInseridosQuatro()
        {
            var proto = new Protoman();
            CanhaoDePlasma upgrade = new CanhaoDePlasma();
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgradesParaBatalha();
            Assert.AreEqual
                ("Nome: Protoman, Vida: 100, Ataque: 11, Defesa: 2", proto.ToString());
        }

        [TestMethod]
        public void ProtomanAtaca()
        {
            var bot = new Bot();
            var proto = new Protoman();
            CanhaoDePlasma upgrade = new CanhaoDePlasma();
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgrade(upgrade);
            proto.EquiparUpgrade(upgrade);
            proto.Atacar(bot);
            Assert.AreEqual
                ("Nome: Bot, Vida: 89, Ataque: 5, Defesa: 0", bot.ToString());
        }

        [TestMethod]
        public void ProtomanRecebeMenosDanoQuandoEquipadoCom3Escudos()
        {
            var bot = new Bot();
            var proto = new Protoman();
            CanhaoDePlasma upgrade = new CanhaoDePlasma();
            var upgrade1 = new EscudoDeEnergia();
            bot.EquiparUpgrade(upgrade);
            bot.EquiparUpgrade(upgrade);
            bot.EquiparUpgrade(upgrade);
            proto.EquiparUpgrade(upgrade1);
            proto.EquiparUpgrade(upgrade1);
            proto.EquiparUpgrade(upgrade1);
            bot.Atacar(proto);
            Assert.AreEqual
                ("Nome: Protoman, Vida: 97, Ataque: 5, Defesa: 2", proto.ToString());
        }

        [TestMethod]
        public void MegamanComecaCom6DeAtaque()
        {
            var mega = new Megaman();
            Assert.AreEqual
                ("Nome: Megaman, Vida: 100, Ataque: 6, Defesa: 0", mega.ToString());
        }

        [TestMethod]
        public void RushÉCriadoCorretamente()
        {
            var doggie = new Rush();
            Assert.AreEqual
                ("Nome: Rush, Vida: 100, Ataque: 4, Defesa: 3", doggie.ToString());
        }

        [TestMethod]
        public void RushAceitaDoisUpgrades()
        {
            var doggie = new Rush();
            var upg = new EscudoDeEnergia();
            doggie.EquiparUpgrade(upg);
            doggie.EquiparUpgrade(upg);
            doggie.ReceberDano(9);
            Assert.AreEqual
                ("Nome: Rush, Vida: 98, Ataque: 4, Defesa: 3", doggie.ToString());
        }

        [TestMethod]
        public void RushPodeSerUmUpgrade()
        {
            var bot = new Bot();
            var doggie = new Rush();
            doggie.EquiparUpgrade(new Rush());
            doggie.EquiparUpgrade(new CanhaoDePlasma());
            doggie.Atacar(bot);
            Assert.AreEqual
                ("Nome: Bot, Vida: 90, Ataque: 5, Defesa: 0", bot.ToString());
        }

        [TestMethod]
        public void RushAceitaComoUpgradeUmOutroRushComUpgrade()
        {
            var bot = new Bot();
            var doggie = new Rush();
            var doggie1 = new Rush();
            doggie1.EquiparUpgrade(new CanhaoDePlasma());
            doggie.EquiparUpgrade(doggie1);
            doggie.Atacar(bot);
            Assert.AreEqual
                ("Nome: Bot, Vida: 90, Ataque: 5, Defesa: 0", bot.ToString());
        }

        [TestMethod]
        public void RushAceitaComoUpgradesDoisOutrosRushsComUpgrade()
        {
            var bot = new Bot();
            var doggie = new Rush();
            var doggie1 = new Rush();
            var doggie2 = new Rush();
            doggie1.EquiparUpgrade(new CanhaoDePlasma());
            doggie2.EquiparUpgrade(new CanhaoDePlasma());
            doggie.EquiparUpgrade(doggie1);
            doggie.EquiparUpgrade(doggie2);
            doggie.Atacar(bot);
            Assert.AreEqual
                ("Nome: Bot, Vida: 84, Ataque: 5, Defesa: 0", bot.ToString());
        }

        [TestMethod]
        public void BotCriadoComChip1Perde1DeAtaque()
        {
            var bot = new Bot(Chip.Nivel1);
            Assert.AreEqual
                ("Nome: Bot, Vida: 100, Ataque: 4, Defesa: 0", bot.ToString());
        }

        [TestMethod]
        public void MegamanCriadoComChip1Perde1DeAtaque()
        {
            var bot = new Megaman(Chip.Nivel1);
            Assert.AreEqual
                ("Nome: Megaman, Vida: 100, Ataque: 5, Defesa: 0", bot.ToString());
        }

        [TestMethod]
        public void BotCriadoComChip2FicaInalterado()
        {
            var bot = new Bot(Chip.Nivel2);
            Assert.AreEqual
                ("Nome: Bot, Vida: 100, Ataque: 5, Defesa: 0", bot.ToString());
        }

        [TestMethod]
        public void BotCriadoComChip3GanhaBuffs()
        {
            var bot = new Bot(Chip.Nivel3);
            Assert.AreEqual
                ("Nome: Bot, Vida: 100, Ataque: 7, Defesa: 1", bot.ToString());
        }

        [TestMethod]
        public void RushCriadoComChip3GanhaBuffs()
        {
            var bot = new Rush(Chip.Nivel3);
            Assert.AreEqual
                ("Nome: Rush, Vida: 100, Ataque: 6, Defesa: 4", bot.ToString());
        }

        [TestMethod]
        public void RushNaoCausaDanoAoAtacarMegaman()
        {
            var bot = new Rush(Chip.Nivel3);
            var mgmn = new Megaman();
            bot.Atacar(mgmn);
            Assert.AreEqual
                ("Nome: Megaman, Vida: 100, Ataque: 6, Defesa: 0", mgmn.ToString());
        }
    }
}
