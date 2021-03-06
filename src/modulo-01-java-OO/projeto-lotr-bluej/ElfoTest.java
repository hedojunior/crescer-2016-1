import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
   @Test
   public void criarElfo(){
       //Arrange
       Elfo elfo = new Elfo("Elfo");
       //Act
       //Assert
       assertEquals(42, elfo.getFlechas());  
   }
   
   @Test
   public void criarDoisElfos(){
       //Arrange
       Elfo elfo = new Elfo("Elfo");
       Elfo elfo2 = new Elfo("Elfo2");
       //Act
       //Assert
       assertEquals(42, elfo.getFlechas());  
       assertEquals(42, elfo2.getFlechas());
   }
    
   @Test
   public void criarElfoSemNome(){
       //Arrange
       Elfo elfo = new Elfo(null);
       //Act
       //Assert
       assertEquals(42, elfo.getFlechas());  
       assertNull(elfo.getNome());
   }
   
   @Test
   public void criarElfoCom100000Flechas(){
       //Arrange
       Elfo elfo = new Elfo("Elfo",100000);
       //Act
       //Assert
       assertEquals(100000, elfo.getFlechas());  
   }    
       
   @Test
   public void atirarFlecha(){
      //Arrange
      Elfo elfo = new Elfo("Elfo");
      Dwarf dwarf = new Dwarf("Dwarf");
      int xp_obtido, xp_esperado = elfo.getExperiencia() + 1;
      int flechas_obtidas, flechas_esperadas = elfo.getFlechas() - 1;
      //Act
          elfo.atirarFlecha(dwarf);
      flechas_obtidas  = elfo.getFlechas();
      xp_obtido = elfo.getExperiencia();
      //Assert
      assertEquals(xp_esperado , xp_obtido);
      assertEquals(flechas_esperadas , flechas_obtidas);
   }
   
   @Test
   public void atirarFlechaEmTresDwarfs(){
      //Arrange
      Elfo elfo = new Elfo("Elfo");
      Dwarf dwarf = new Dwarf("Dwarf");
      Dwarf dwarf2 = new Dwarf("Dwarf2");
      Dwarf dwarf3 = new Dwarf("Dwarf3");
      int xp_obtido, xp_esperado = elfo.getExperiencia() + 3;
      int flechas_obtidas, flechas_esperadas = elfo.getFlechas() - 3;
      //Act
      elfo.atirarFlecha(dwarf);
      elfo.atirarFlecha(dwarf2);
      elfo.atirarFlecha(dwarf3);
      xp_obtido = elfo.getExperiencia();
      flechas_obtidas = elfo.getFlechas();
      //Assert     
      assertEquals(xp_esperado , xp_obtido);
      assertEquals(flechas_esperadas , flechas_obtidas);
   }
   
   @Test
   public void atirarFlechaEmDwarfSemNome(){
      //Arrange
      Elfo elfo = new Elfo("Elfo");
      Dwarf dwarf = new Dwarf(null);
      int xp_obtido, xp_esperado = elfo.getExperiencia() + 1;
      int flechas_obtidas, flechas_esperadas = elfo.getFlechas() - 1;
      //Act
      elfo.atirarFlecha(dwarf);
      flechas_obtidas = elfo.getFlechas();
      xp_obtido = elfo.getExperiencia();
      //Assert
      assertEquals(xp_esperado , xp_obtido);
      assertEquals(flechas_esperadas , flechas_obtidas);
   }
   
   @Test
   public void milFlechasToString(){
       //Arrange
       Elfo elfo = new Elfo("Legolas",1000);
       //Act
       //Assert
       assertEquals("Legolas possui 1000 flechas e 0 níveis de experiência.", elfo.toString());  
   }
   
   @Test
   public void retornarDoisElfosToString(){
       //Arrange
       Elfo elfo = new Elfo("Legolas",1000);
       Elfo elfo2 = new Elfo("Baby Legolas",5);
       //Act
       //Assert
       assertEquals("Legolas possui 1000 flechas e 0 níveis de experiência.", elfo.toString());
       assertEquals("Baby Legolas possui 5 flechas e 0 níveis de experiência.", elfo2.toString());
   }
   
   @Test
   public void ElfoNasceCom100DeVida() {
       //Arrange
       Elfo elfo = new Elfo("elfo");
       //Act
       //Assert
       assertEquals(100, elfo.getVida(),0);
   }
   
   @Test
   public void ElfoNasceComStatusVivo() {
       //Arrange
       Elfo elfo = new Elfo("elfo");
       //Act
       //Assert
       assertEquals(Status.VIVO, elfo.getStatus());
   }
   
   @Test
   public void contadorAumentaQuandoElfoNasce() {
       int esperado = Elfo.getContador() + 1;
       Elfo elfo = new Elfo("Elfo");
       assertEquals(esperado, Elfo.getContador());
   }
   
   @Test
   public void contadorAumentaQuandoTresElfosNascem() {
       int esperado = Elfo.getContador() + 3;
       Elfo elfo = new Elfo("Elfo");
       Elfo elfo1 = new ElfoVerde("Elfo");
       Elfo elfo2 = new ElfoNoturno("Elfo");
       assertEquals(esperado, Elfo.getContador());
   }
}
