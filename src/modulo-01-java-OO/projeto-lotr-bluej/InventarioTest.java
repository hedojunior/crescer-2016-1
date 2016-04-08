

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
       esperado_add = lista.getItens().contains(item);
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
       esperado_rmv = lista.getItens().contains(item);
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
       esperado_add = lista.getItens().contains(item);
       lista.removerItem(item);
       esperado_rmv = lista.getItens().contains(item);
       //Assert
       assertTrue(esperado_add);
       assertFalse(esperado_rmv);
   }
   
   @Test
   public void imprimeItensCorretamente() {
       //Arrange
       Inventario inventario = new Inventario();
       for (int t = 0; t < 5; t++) {
           inventario.adicionarItem(new Item(1,"item"));
       }
       String obtida, esperada = "item,item,item,item,item";
       //Act
       obtida = inventario.getDescricoesItens();
       //Assert
       assertEquals(esperada, obtida);
   }
   
   @Test
    public void getDescricoesComUmItem() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(1, "Espada"));
        String obtido = inventario.getDescricoesItens();
        assertEquals("Espada", obtido);
    }

    @Test
    public void getDescricoesComDoisItens() {
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(1, "Espada"));
        inventario.adicionarItem(new Item(1, "Escudo"));
        String obtido = inventario.getDescricoesItens();
        assertEquals("Espada,Escudo", obtido);
    }
    
    @Test
    public void descobreOItemMaisPopularQueEstaNoInicioDaLista() {
        Inventario inventario = new Inventario();
        Item item1 = new Item(5,"Item");
        Item item2 = new Item(4,"Item");
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        Item obtido = inventario.maiorQtd();
        assertEquals(5, obtido.getQuantidade());
    }
    
    @Test
    public void descobreOItemMaisPopularQueEstaNoFimDaLista() {
        Inventario inventario = new Inventario();
        Item item1 = new Item(5,"Item");
        Item item2 = new Item(4,"Item");
        Item item3 = new Item(4,"Item");
        Item item4 = new Item(8,"Item");
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        inventario.adicionarItem(item4);
        Item obtido = inventario.maiorQtd();
        assertEquals(8, obtido.getQuantidade());
    }
}
