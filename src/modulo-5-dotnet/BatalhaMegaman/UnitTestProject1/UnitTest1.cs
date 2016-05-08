﻿using System;
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
    }
}
