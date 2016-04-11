public class Elfo extends Personagem {
    protected int flechas = 42;
    
    public Elfo(String nome) {
        super(nome);
    }
    
    public Elfo(String nome, int flechas) {
        this(nome);
        this.flechas = flechas;
    }   
    
    public int getFlechas(){
        return flechas;
    }
       
    public void atirarFlechaDwarf(Dwarf dwarf) {
        experiencia++;
        flechas--;
        dwarf.danoRecebido();               
    }
   
    public String toString () {
        boolean FlechasNoSingular = Math.abs(this.flechas) == 1;
        boolean ExperienciaNoSingular = Math.abs(this.flechas) == 1;
        
        return String.format ("%s possui %d %s e %d %s de experiência.",
            this.nome,this.flechas, FlechasNoSingular ? "flecha" : "flechas", this.experiencia, ExperienciaNoSingular ? "nível" : "níveis");       
    }
}
