public class Dwarf {
    
    public int vida = 110;
    private String nome;

     public Dwarf(String nome){
         this.nome = nome;
  };
    
     public void danoRecebido() {
        this.vida = vida;
        vida = vida - 10;
  };
}