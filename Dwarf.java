public class Dwarf {
    
    private int vida;
    private String nome;

     public Dwarf(String nome){
         this.vida = 110;
         this.nome = nome;
     }
    
     public void danoRecebido() {
        this.vida -= 10;
     }
}
