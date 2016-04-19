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
       int maior_quantidade = 0;
       int indice_maior = 0;
       
       for(int i = 0; i <this.inventario.size(); i++) {
           if(this.inventario.get(i).getQuantidade() > maior_quantidade){
               maior_quantidade = this.inventario.get(i).getQuantidade();
               indice_maior = i;
            }
       }
       try {
           return this.inventario.get(indice_maior);
       }
       catch(IndexOutOfBoundsException e) {
          System.out.println("O Inventário está vazio!");
          return null;
       }
   }
   
    public void ordenaItens() {
       Item aux = null;
       for (int i = 0; i < this.inventario.size(); i++) {
           for(int j = 0; j < this.inventario.size() - 1; j++) {
               if(this.inventario.get(j).getQuantidade() > this.inventario.get(j + 1).getQuantidade()){
                   aux = this.inventario.get(j);
                   this.inventario.set(j,this.inventario.get(j + 1));
                   this.inventario.set(j + 1, aux);
               }
           }
       }
   }
   
   public boolean equals(Object obj) {
       boolean resultado = false;
       Inventario outro = (Inventario)obj;
       if  (this.getItens().size() != outro.getItens().size()) {
           resultado = false;
           return resultado;
       }else {
           for( int i = 0; i < this.getItens().size(); i++) {
               if (this.getItens().get(i).equals(outro.getItens().get(i)) ) {
                   resultado = true;
               }else {
                   resultado = false;
                   break;
               }
           }
       } return resultado;
   }
   
}