public class Dwarf {
    
    private int vida;
    private String nome;
    private Status status;
    
    public Dwarf(String nome){
         this.vida = 110;
         this.nome = nome;
         this.status = Status.VIVO;
        }
    
    public int getVida() {
        return vida;
    }
    
    public void danoRecebido() {
        if(this.status != Status.MORTO) { 
            this.vida -= 10;
                if (vida <= 0){
                    this.estaMorto();
                }
        }
    }
     
    public void setNome(String novoNome) {
        nome = novoNome;
    }
    
    public String getNome () {
        return nome;
    }
    
    public Status getStatus() {
        return status;
    }
    
    private void estaMorto(){
        this.status = Status.MORTO;
        this.vida = 0;
    }        
}


    

// Diferenças

// Declarar um objeto:
// Dwarf gimli = null;

// Criação (instanciação):
// new Dwarf();
// Dwarf d1 = new Dwarf();