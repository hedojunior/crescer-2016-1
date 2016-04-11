

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
   @Test
   public void ganhaDobroDeExperienciaAoAtirarFlecha()
   {
       //Arrange
       ElfoVerde elfo = new ElfoVerde("GreenElf",5);
       //Act
       elfo.atirarFlechaDwarf(new Dwarf("Gimli"));
       //Assert
       assertEquals(2, elfo.getExperiencia());
   }
   
   @Test
   public void adicionaItemComDescricaoEspadaValiriana()
   {
       ElfoVerde elfo = new ElfoVerde("GreenElf");
       Item item = new Item(1,"Espada de aço valiriano");
       elfo.adicionarItem(item);
       assertTrue(elfo.getInventario().getItens().contains(item));
   }
}
