

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class InventarioTest
{
   @Test
   public void adicionaItem() {
       //Arrange
       boolean esperado_add;
       Item item = new Item (5,"Item");
       Inventario lista = new Inventario();
       //Act
       lista.adicionarItem(item);
       esperado_add = lista.getInventario().contains(item);
       //Assert
       assertTrue(esperado_add);
   }
   
   @Test
   public void removeItem() {
       //Arrange
       boolean esperado_rmv;
       Item item = new Item (5,"Item");
       Inventario lista = new Inventario();
       //Act
       lista.adicionarItem(item);
       lista.removerItem(item);
       esperado_rmv = lista.getInventario().contains(item);
       //Assert
       assertFalse(esperado_rmv);
   }
    
   @Test
   public void adiciona_E_Exclui_Item() {
       //Arrange
       boolean esperado_add, esperado_rmv;
       Item item = new Item (5,"Item");
       Inventario lista = new Inventario();
       //Act
       lista.adicionarItem(item);
       esperado_add = lista.getInventario().contains(item);
       lista.removerItem(item);
       esperado_rmv = lista.getInventario().contains(item);
       //Assert
       assertTrue(esperado_add);
       assertFalse(esperado_rmv);
   }
}
