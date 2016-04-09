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
        //Arrange
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(1, "Espada"));
        //Act
        String obtido = inventario.getDescricoesItens();
        //Assert
        assertEquals("Espada", obtido);
   }

   @Test
   public void getDescricoesComDoisItens() {
        //Arrange
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(1, "Espada"));
        inventario.adicionarItem(new Item(1, "Escudo"));
        //Act
        String obtido = inventario.getDescricoesItens();
        //Assert
        assertEquals("Espada,Escudo", obtido);
   }
    
   @Test
   public void descobreOItemMaisPopularQueEstaNoInicioDaLista() {
        //Arrange
        Inventario inventario = new Inventario();
        Item item1 = new Item(5,"Item");
        Item item2 = new Item(4,"Item");
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        //Act
        Item obtido = inventario.maiorQtd();
        //Assert
        assertEquals(5, obtido.getQuantidade());
   }
    
   @Test
   public void descobreOItemMaisPopularQueEstaNoFimDaLista() {
        //Arrange
        Inventario inventario = new Inventario();
        Item item1 = new Item(5,"Item");
        Item item2 = new Item(4,"Item");
        Item item3 = new Item(4,"Item");
        Item item4 = new Item(8,"Item");
        inventario.adicionarItem(item1);
        inventario.adicionarItem(item2);
        inventario.adicionarItem(item3);
        inventario.adicionarItem(item4);
        //Act
        Item obtido = inventario.maiorQtd();
        //Assert
        assertEquals(8, obtido.getQuantidade());
   }
   
   @Test
   public void ordenaListaCom6Itens() {
        //Arrange
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(8, "Lembas"));
        inventario.adicionarItem(new Item(13, "Anões"));
        inventario.adicionarItem(new Item(1, "Anel"));
        inventario.adicionarItem(new Item(5, "Exércitos"));
        inventario.adicionarItem(new Item(4, "Hobbits"));
        inventario.adicionarItem(new Item(1, "Sauron"));
        //Act
        inventario.ordenaItens();
        //Assert
        assertEquals(1,inventario.getItens().get(0).getQuantidade());
        assertEquals(4,inventario.getItens().get(2).getQuantidade());
        assertEquals(13,inventario.getItens().get(5).getQuantidade());
   }
    
   @Test
   public void ordenaListaCom2Itens() {
        //Arrange
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(8, "Lembas"));
        inventario.adicionarItem(new Item(13, "Anões"));
        //Act
        inventario.ordenaItens();
        //Assert
        assertEquals(8,inventario.getItens().get(0).getQuantidade());
        assertEquals(13,inventario.getItens().get(1).getQuantidade());
   }
    
   @Test
   public void ordenaListaCom1Item() {
        //Arrange
        Inventario inventario = new Inventario();
        inventario.adicionarItem(new Item(8, "Lembas"));
        //Act
        inventario.ordenaItens();
        //Assert
        assertEquals(8,inventario.getItens().get(0).getQuantidade());
   }
}
