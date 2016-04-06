

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
   @Test
   public void testaSeAVidaDoDwarfÉPadrãoAoCriarDwarf(){
       Dwarf dwarf = new Dwarf("Dwarf");
       int vida_esperada = 110;
       assertEquals(vida_esperada, dwarf.getVida());  
   }
   
   @Test
   public void TesteSeOAnãoTomaDano(){
       Dwarf dwarf = new Dwarf("Dwarf");
       int vida_esperada = dwarf.getVida() - 10;
       dwarf.danoRecebido();
       int vida_obtida = dwarf.getVida();
       assertEquals(vida_esperada,vida_obtida);
   }
}
