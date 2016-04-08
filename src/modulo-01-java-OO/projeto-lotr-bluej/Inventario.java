import java.util.ArrayList;

public class Inventario {
    
    private ArrayList<Item> inventario = new ArrayList<>();
    
   public void adicionarItem(Item item){
        inventario.add(item);
   }
   
   public void removerItem(Item item) {
       inventario.remove(item);
   }
   
   public ArrayList<Item> getItens() {
       return this.inventario;
    }
    
   public String getDescricoesItens() {
       String imprimir = "";
       
       for (int i = 0; i < this.inventario.size(); i++) {
           if(i == inventario.size() - 1){
               imprimir += inventario.get(i).getDescricao();
            }   else{
                    imprimir += inventario.get(i).getDescricao() + ",";
            
                }
       }
       return imprimir;
   }
   
   public void temSorte() {
       for(int i = 0; i < this.inventario.size(); i++) {
           this.inventario.get(i).setQuantidade(this.inventario.get(i).getQuantidade()+1000) ;
       }
   }
   
   public Item maiorQtd() {
       int maior_quantidade = this.inventario.get(0).getQuantidade();
       Item maior = this.inventario.get(0);
       for(int i = 0; i <this.inventario.size(); i++) {
           if(this.inventario.get(i).getQuantidade() > maior_quantidade){
               maior = this.inventario.get(i);
            }
       }
       return maior;
   }
}