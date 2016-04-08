

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
   @Test
   public void criarDwarf110vida(){
       //Arrange
       int vida_esperada = 110;
       //Act
       Dwarf dwarf = new Dwarf("Dwarf");
       //Assert 
       assertEquals(vida_esperada, dwarf.getVida());  
   }
   
   @Test
   public void criarDwarf120vida(){
       //Arrange
       int vida_esperada = 120;
       boolean obtido;
       //Act
       Dwarf dwarf = new Dwarf("Dwarf");
       obtido = vida_esperada == dwarf.getVida();
       //Assert 
       assertFalse(obtido);  
   }
   
   @Test
   public void dwarfToma10Dano(){
       //Arrange
       Dwarf dwarf = new Dwarf("Dwarf");
       int vida_esperada = dwarf.getVida() - 10;
       //Act
       dwarf.danoRecebido();
       //Assert
       assertEquals(vida_esperada,dwarf.getVida());
   }
   
   @Test
   public void dwarfToma110Dano(){
       //Arrange
       Dwarf dwarf = new Dwarf("Dwarf");
       int vida_esperada = dwarf.getVida() - 110;
       // Act
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       // Assert
       assertEquals(vida_esperada,dwarf.getVida());
   }
      
   @Test
   public void estaMortoCom110Dano(){
       //Arrange
       Dwarf dwarf = new Dwarf("Dwarf");
       Status esperado = Status.MORTO;
       //Act
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       //Assert
       assertEquals(0, dwarf.getVida());
       assertEquals(esperado, dwarf.getStatus());
   }
   
   @Test
   public void estaMortoCom120Dano(){
       //Arrange
       Dwarf dwarf = new Dwarf("Dwarf");
       Status esperado = Status.MORTO;
       //Act
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       //Assert
       assertEquals(0, dwarf.getVida());
       assertEquals(esperado, dwarf.getStatus());
   }
   
   @Test
   public void adicionaItem() {
       //Arrange
       boolean obtido;
       Dwarf dwarf = new Dwarf("Dwarf");
       Item i = new Item(1,"Item");
       //Act
       dwarf.adicionarItem(i);
       obtido = dwarf.getInventario().getInventario().contains(i);
       //Assert
       assertTrue(obtido);
   }
   
   @Test
   public void adiciona4Itens() {
       //Arrange
       boolean obtido;
       Dwarf dwarf = new Dwarf("Dwarf");
       Item i1 = new Item(1,"Item");
       Item i2 = new Item(1,"Item");
       Item i3 = new Item(1,"Item");
       Item i4 = new Item(1,"Item");
       //Act
       dwarf.adicionarItem(i1);
       dwarf.adicionarItem(i2);
       dwarf.adicionarItem(i3);
       dwarf.adicionarItem(i4);
       obtido = dwarf.getInventario().getInventario().contains(i1) == 
       dwarf.getInventario().getInventario().contains(i2) ==
       dwarf.getInventario().getInventario().contains(i3) ==
       dwarf.getInventario().getInventario().contains(i4);
       //Assert
       assertTrue(obtido);
   }
      
   @Test
   public void perde4Itens() {
       //Arrange
       boolean obtido;
       Dwarf dwarf = new Dwarf("Dwarf");
       Item i1 = new Item(1,"Item");
       Item i2 = new Item(1,"Item");
       Item i3 = new Item(1,"Item");
       Item i4 = new Item(1,"Item");
       //Act
       dwarf.adicionarItem(i1);
       dwarf.adicionarItem(i2);
       dwarf.adicionarItem(i3);
       dwarf.adicionarItem(i4);
       dwarf.perderItem(i1);
       dwarf.perderItem(i2);
       dwarf.perderItem(i3);
       dwarf.perderItem(i4);
       obtido = dwarf.getInventario().getInventario().contains(i1) == 
       dwarf.getInventario().getInventario().contains(i2) ==
       dwarf.getInventario().getInventario().contains(i3) ==
       dwarf.getInventario().getInventario().contains(i4);
       //Assert
       assertTrue(obtido);
   }
   
   @Test
   public void perdeItem() {
       //Arrange
       boolean obtido;
       Dwarf dwarf = new Dwarf("Dwarf");
       Item i = new Item(1,"Item");
       //Act
       dwarf.adicionarItem(i);
       dwarf.perderItem(i);
       obtido = dwarf.getInventario().getInventario().contains(i);
       //Assert
       assertFalse(obtido);
   }
   
   @Test
   public void compararDataNascimento() {
       //Arrange
       DataTerceiraEra dataNascimento = new DataTerceiraEra(07,04,2016);
       Dwarf dwarf = new Dwarf("Dwarf", dataNascimento);
       boolean dia, mes, ano;
       //Act
       dia = dataNascimento.getDia() == dwarf.getDataNascimento().getDia(); 
       mes = dataNascimento.getMes() == dwarf.getDataNascimento().getMes();
       ano = dataNascimento.getAno() == dwarf.getDataNascimento().getAno();
       //Assert
       assertTrue(dia);
       assertTrue(mes);
       assertTrue(ano);
    }
   
   @Test
   public void numeroSorteSeixas(){
       //Arrange
       double esperado = 101.0 * 33 % 100;
       DataTerceiraEra data = new DataTerceiraEra(07,04,2015);
       Dwarf dwarf = new Dwarf("Seixas",data);
       //Act
       //Assert
       assertEquals(esperado,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteMeirelesAnoBissexto(){
       //Arrange
       double esperado = 101.0;
       DataTerceiraEra data = new DataTerceiraEra(07,04,2016);
       Dwarf dwarf = new Dwarf("Meireles",data);
       //Act
       //Assert
       assertEquals(esperado,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteSeixasAnoBissexto(){
       //Arrange
       double esperado = 101.0;
       DataTerceiraEra data = new DataTerceiraEra(07,04,2016);
       Dwarf dwarf = new Dwarf("Seixas",data);
       //Act
       //Assert
       assertEquals(esperado,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteMeirelesAnoNaoBissexto(){
       //Arrange
       double esperado = 101.0 * 33 % 100;
       DataTerceiraEra data = new DataTerceiraEra(07,04,2015);
       Dwarf dwarf = new Dwarf("Meireles",data);
       //Act
       //Assert
       assertEquals(esperado,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteDwarfQualquerNomeDataBissextoVida90(){
       //Arrange
       double esperado = 101.0 * -33;
       DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
       Dwarf dwarf = new Dwarf(null,data);
       //Act
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       //Assert
       assertEquals(esperado,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void vidaEExperienciaIguaisAposDanoMeireles() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2015);
       Dwarf d1 = new Dwarf("Meireles",data);
       int vida_esperada = d1.getVida();
       int xp_esperada = d1.getExperiencia();
       //Act
       d1.danoRecebido();
       //Assert
       assertEquals(vida_esperada, d1.getVida());
       assertEquals(xp_esperada, d1.getExperiencia());
   }
   
   /* @Test
   public void vidaEExperienciaIguaisAposDanoMeirelesNewString() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2015);
       Dwarf d1 = new Dwarf("Meireles",data);
       int vida_esperada = d1.getVida();
       int xp_esperada = d1.getExperiencia();
       //Act
       d1.danoRecebido();
       //Assert
       assertEquals(vida_esperada, d1.getVida());
       assertEquals(xp_esperada, d1.getExperiencia());
   }
   */
   
   @Test
   public void vidaEExperienciaAposDanoDataBissextoDwarf90Vida() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
       Dwarf d1 = new Dwarf(null,data);
       int vida_esperada = d1.getVida() - 20;
       int xp_esperada = d1.getExperiencia() + 2;
       //Act
       d1.danoRecebido();
       d1.danoRecebido();
       d1.danoRecebido();
       //Assert
       assertEquals(vida_esperada, d1.getVida());
       assertEquals(xp_esperada, d1.getExperiencia());
   }
   
   @Test
   public void Experiencia8AposDanoDataBissextoDwarf90Vida() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
       Dwarf d1 = new Dwarf(null,data);
       int vida_esperada = d1.getVida() - 20;
       int xp_esperada = d1.getExperiencia() + 8;
       //Act
       d1.danoRecebido();
       d1.danoRecebido();
       d1.danoRecebido();
       d1.danoRecebido();
       d1.danoRecebido();
       d1.danoRecebido();
       //Assert
       assertEquals(vida_esperada, d1.getVida());
       assertEquals(xp_esperada, d1.getExperiencia());
   }
   
   @Test
   public void dwarfTomaDanoNormalmente(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       Dwarf dwarf = new Dwarf(null,data);
       int esperado = dwarf.getVida() - 10;
       //Act
       dwarf.danoRecebido();
       //Assert
       assertEquals(esperado,dwarf.getVida());
   }
}
