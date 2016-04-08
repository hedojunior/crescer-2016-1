import java.util.ArrayList;

public class Inventario {
    
    private ArrayList<Item> inventario = new ArrayList<>();
    
   public void adicionarItem(Item item){
        inventario.add(item);
   }
   
   public void removerItem(Item item) {
       inventario.remove(item);
   }
   
   public ArrayList getInventario() {
       return inventario;
    }

}