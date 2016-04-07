public class Dwarf {
    
    private int vida;
    private String nome;

    public Dwarf(String nome){
         this.vida = 110;
         this.nome = nome;
    }
    
    public int getVida() {
        return vida;
    }
    
    public void danoRecebido() {
         this.vida -= 10;
    }
     
    public void setNome(String novoNome) {
        nome = novoNome;
    }
    public String getNome () {
        return nome;
    }
}


    

// Diferenças

// Declarar um objeto:
// Dwarf gimli = null;

// Criação (instanciação):
// new Dwarf();
// Dwarf d1 = new Dwarf();