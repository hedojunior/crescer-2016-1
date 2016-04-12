

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ItemTest
{
 @Test
 public void umItemEhIgualAoOutro() {
     Item item = new Item(1,"Espada");
     Item item1 = new Item(1,"Espada");
     assertEquals(item,item1);
    }
 
 @Test
 public void umItemNaoEhIgualAoOutro() {
     Item item = new Item(1,"Espada");
     Item item1 = new Item(2,"Espada");
     assertFalse(item.equals(item1));
    }
}
