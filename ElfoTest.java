

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
   @Test
   public void criarElfo(){
       Elfo elfo = new Elfo("Elfo");
       int flechas_esperadas = 42;
       assertEquals(flechas_esperadas, elfo.getFlechas());  
   }
   
   @Test
   public void testeAtirarFlechaDwarf(){
      Elfo elfo = new Elfo("Elfo");
      Dwarf dwarf = new Dwarf("Dwarf");
      
      int xp_esperado = elfo.getExperiencia() + 1;
      int flechas_esperadas = elfo.getFlechas() - 1;
      
      elfo.atirarFlechaDwarf(dwarf);
      
      int flechas_obtidas = elfo.getFlechas();
      int xp_obtido = elfo.getExperiencia();
      
      assertEquals(xp_esperado , xp_obtido);
      assertEquals(flechas_esperadas , flechas_obtidas);
   }    
}
