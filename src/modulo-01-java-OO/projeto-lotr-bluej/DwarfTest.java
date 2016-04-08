

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
   public void numeroSorteSeixasAnoNaoBissexto(){
       //Arrange
       double esperado = 101.0 * 33 % 100;
       DataTerceiraEra data = new DataTerceiraEra(07,04,2015);
       Dwarf dwarf = new Dwarf("Seixas",data);
       //Act
       //Assert
       assertEquals(esperado,dwarf.getNumeroSorte(),0);
   }
    
   
   
   
   
}
