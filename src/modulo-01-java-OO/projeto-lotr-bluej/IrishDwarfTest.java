

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
   @Test
   public void criarIrishDwarfCom110deVida () {
   //Arrange
   int vida_esperada = 110;
   //Act
   IrishDwarf leprechaun = new IrishDwarf ("Frank McDonnell");
   //Assert
   assertEquals(vida_esperada, leprechaun.getVida());
   }
   
   @Test
   public void criarIrishDwarfCom7777vida(){
       //Arrange
       int vida_esperada = 7777;
       boolean obtido;
       //Act
       IrishDwarf leprechaun = new IrishDwarf("Ossian O'Casey");
       obtido = vida_esperada == leprechaun.getVida();
       //Assert 
       assertFalse(obtido);  
   }
   
   @Test
   public void IrishDwarfToma70Dano(){
       //Arrange
       IrishDwarf leprechaun = new IrishDwarf("Kieran Mac Ateer");
       int vida_esperada = leprechaun.getVida() - 70;
       //Act
       for(int i = 0; i < 7; i++) {
       leprechaun.danoRecebido();
       }
       //Assert
       assertEquals(vida_esperada,leprechaun.getVida());
   }
   
   @Test
   public void LeprechaunEstaMortoCom110Dano(){
      //Arrange
      IrishDwarf leprechaun = new IrishDwarf("Donagh Brennan");
      Status esperado = Status.MORTO;
       //Act
      for (int i = 0; i < 11; i++){
          leprechaun.danoRecebido();
        }
      //Assert
      assertEquals(0, leprechaun.getVida());
      assertEquals(esperado, leprechaun.getStatus());
   }
   
   @Test
   public void LeprechaunEstaMortoCom140Dano(){
      //Arrange
      IrishDwarf leprechaun = new IrishDwarf("Lorcan Cullen");
      Status esperado = Status.MORTO;
       //Act
      for (int i = 0; i < 14; i++){
          leprechaun.danoRecebido();
        }
      //Assert
      assertEquals(0, leprechaun.getVida());
      assertEquals(esperado, leprechaun.getStatus());
   }
   
   @Test
   public void adicionaItemInventario() {
       //Arrange
       boolean obtido;
       IrishDwarf leprechaun = new IrishDwarf("Brendan Shannon");
       Item i = new Item(1,"Guiness Draught");
       //Act
       leprechaun.adicionarItem(i);
       obtido = leprechaun.getInventario().getItens().contains(i);
       //Assert
       assertTrue(obtido);
   }
   
   @Test
   public void adiciona4ItensNoInventario() {
       //Arrange
       boolean obtido;
       IrishDwarf leprechaun = new IrishDwarf("Frank McDermott");
       Item i1 = new Item(1,"Guinness Draught");
       Item i2 = new Item(1,"Guinness Original/Extra Stout");
       Item i3 = new Item(1,"Guinness Foreign Extra Stout");
       Item i4 = new Item(1,"Guinness Special Export Stout");
       //Act
       leprechaun.adicionarItem(i1);
       leprechaun.adicionarItem(i2);
       leprechaun.adicionarItem(i3);
       leprechaun.adicionarItem(i4);
       obtido = leprechaun.getInventario().getItens().contains(i1) == 
       leprechaun.getInventario().getItens().contains(i2) ==
       leprechaun.getInventario().getItens().contains(i3) ==
       leprechaun.getInventario().getItens().contains(i4);
       //Assert
       assertTrue(obtido);
   }
   
   @Test
   public void perde4ItensInventario() {
       //Arrange
       boolean obtido;
       IrishDwarf leprechaun = new IrishDwarf("Donagh McCarthy");
       Item i1 = new Item(1,"Guinness Bitter");
       Item i2 = new Item(1,"Guinness Extra Smooth");
       Item i3 = new Item(1,"Malta Guinness");
       Item i4 = new Item(1,"Guinness Mid-Strength");
       //Act
       leprechaun.adicionarItem(i1);
       leprechaun.adicionarItem(i2);
       leprechaun.adicionarItem(i3);
       leprechaun.adicionarItem(i4);
       leprechaun.perderItem(i1);
       leprechaun.perderItem(i2);
       leprechaun.perderItem(i3);
       leprechaun.perderItem(i4);
       obtido = leprechaun.getInventario().getItens().contains(i1) == 
       leprechaun.getInventario().getItens().contains(i2) ==
       leprechaun.getInventario().getItens().contains(i3) ==
       leprechaun.getInventario().getItens().contains(i4);
       //Assert
       assertTrue(obtido);
   }
   
   @Test
   public void perdeItemInventario() {
       //Arrange
       IrishDwarf leprechaun = new IrishDwarf("Finbar Brannigan");
       Item i = new Item(1,"Guinness Red");
       //Act
       leprechaun.adicionarItem(i);
       leprechaun.perderItem(i);
       //Assert
       assertFalse(leprechaun.getInventario().getItens().contains(i));
   }
   
   @Test
   public void compararDataNascimento() {
       //Arrange
       DataTerceiraEra dataNascimento = new DataTerceiraEra(07,04,2016);
       //Act
       IrishDwarf leprechaun = new IrishDwarf("Eamon McEvoy", dataNascimento);
       //Assert
       assertEquals(07, leprechaun.getDataNascimento().getDia());
       assertEquals(04, leprechaun.getDataNascimento().getMes());
       assertEquals(2016, leprechaun.getDataNascimento().getAno());
   
   }
   
   @Test
   public void numeroSorteSeixas(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(07,04,2015);
       //Act
       IrishDwarf leprechaun = new IrishDwarf("Seixas",data);
       //Assert
       assertEquals(((101.0 * 33) % 100),leprechaun.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteMeireles(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(07,04,2015);
       //Act
       IrishDwarf leprechaun = new IrishDwarf("Meireles",data);
       //Assert
       assertEquals(((101.0 * 33) % 100),leprechaun.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteMeirelesAnoBissexto(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(07,04,2016);
       //Act
       IrishDwarf leprechaun = new IrishDwarf("Meireles",data);
       //Assert
       assertEquals(101.0,leprechaun.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteSeixasAnoBissexto(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(07,04,2016);
       IrishDwarf leprechaun = new IrishDwarf("Seixas",data);
       //Act
       //Assert
       assertEquals(101.0,leprechaun.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteIrishDwarfQualquerNomeDataBissextoVida90(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
       IrishDwarf leprechaun = new IrishDwarf("Aengus Maguire",data);
       //Act
       leprechaun.danoRecebido();
       leprechaun.danoRecebido();
       //Assert
       assertEquals((101.0 * -33),leprechaun.getNumeroSorte(),0);
   }
   
   @Test
   public void vidaEExperienciaIguaisAposDanoMeireles() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2015);
       IrishDwarf leprechaun = new IrishDwarf("Meireles",data);
       int vida_esperada = leprechaun.getVida();
       int xp_esperada = leprechaun.getExperiencia();
       //Act
       leprechaun.danoRecebido();
       //Assert
       assertEquals(vida_esperada, leprechaun.getVida());
       assertEquals(xp_esperada, leprechaun.getExperiencia());
   }
   
   @Test
   public void vidaEExperienciaAposDanoDataBissextoDwarf90Vida() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
       IrishDwarf leprechaun = new IrishDwarf("Brendan Cullen",data);
       int vida_esperada = leprechaun.getVida() - 20;
       int xp_esperada = leprechaun.getExperiencia() + 2;
       //Act
       leprechaun.danoRecebido();
       leprechaun.danoRecebido();
       leprechaun.danoRecebido();
       //Assert
       assertEquals(vida_esperada, leprechaun.getVida());
       assertEquals(xp_esperada, leprechaun.getExperiencia());
   }
   
   @Test
   public void Experiencia8AposDanoDataBissextoIrishDwarf90Vida() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
       IrishDwarf leprechaun = new IrishDwarf("Frank Cullen",data);
       int vida_esperada = leprechaun.getVida() - 20;
       int xp_esperada = leprechaun.getExperiencia() + 8;
       //Act
       for (int i = 0;i < 6; i++) {
           leprechaun.danoRecebido();
       }
       //Assert
       assertEquals(vida_esperada, leprechaun.getVida());
       assertEquals(xp_esperada, leprechaun.getExperiencia());
   }
   
   @Test
   public void IrishDwarfTentaSorteComUmItemEDataSendoBissextoEVidaSendo90() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       IrishDwarf leprechaun = new IrishDwarf("Kieran McDermott", data);
       Item item = new Item(4,"250 Anniversary Stout");
       leprechaun.adicionarItem(item);
       leprechaun.danoRecebido();
       leprechaun.danoRecebido();
       leprechaun.tentarSorte();
       assertEquals(10004, leprechaun.getInventario().getItens().get(0).getQuantidade());
   }
   
   @Test
   public void IrishDwarfTentaSorteComDoisItensEDataSendoBissextoEVidaSendo90() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       IrishDwarf leprechaun = new IrishDwarf("Dinny Moloney", data);
       Item item = new Item(3,"Brew 39");
       Item item2 = new Item(2,"Toucan Brew");
       leprechaun.adicionarItem(item);
       leprechaun.adicionarItem(item2);
       leprechaun.danoRecebido();
       leprechaun.danoRecebido();
       leprechaun.tentarSorte();
       assertEquals(6003, leprechaun.getInventario().getItens().get(0).getQuantidade());
       assertEquals(3002, leprechaun.getInventario().getItens().get(1).getQuantidade());
   }
   
   @Test
   public void IrishDwarfTentaSorteComDoisItensEDataNaoSendoBissextoENomeSendoSeixas() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2015);
       IrishDwarf leprechaun = new IrishDwarf("Seixas", data);
       Item item = new Item(1,"North Star");
       Item item2 = new Item(2,"Guinness's Brite Lager");
       leprechaun.adicionarItem(item);
       leprechaun.adicionarItem(item2);
       leprechaun.tentarSorte();
       assertEquals(1, leprechaun.getInventario().getItens().get(0).getQuantidade());
       assertEquals(2, leprechaun.getInventario().getItens().get(1).getQuantidade());
   }
   
   @Test
   public void IrishDwarfTentaSorteComDoisItensEDataSendoBissextoEVidaSendo110() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       IrishDwarf leprechaun = new IrishDwarf("Teague Malone", data);
       Item item = new Item(1,"Guinness's Brite Ale");
       Item item2 = new Item(1,"Guinness Light");
       leprechaun.adicionarItem(item);
       leprechaun.adicionarItem(item2);
       leprechaun.tentarSorte();
       assertEquals(1, leprechaun.getInventario().getItens().get(0).getQuantidade());
       assertEquals(1, leprechaun.getInventario().getItens().get(1).getQuantidade());
   }
}
