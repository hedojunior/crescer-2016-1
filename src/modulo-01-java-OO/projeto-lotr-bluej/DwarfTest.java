

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
}
