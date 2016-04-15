import java.util.ArrayList;
public class Elfo extends Personagem {
    protected int flechas = 42;
    private static int contadorElfo;
    
    public Elfo(String nome) {
        super(nome);
        this.vida = 100;
        contadorElfo++;
    }
    
    public Elfo(String nome, int flechas) {
        this(nome);
        this.flechas = flechas;
    }  
    
    public static int getContador() {
        return contadorElfo;
    }
    
    public int getFlechas(){
        return flechas;
    }
       
    public void atirarFlecha(Dwarf dwarf) {
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
    
    public void tentarSorte() {
        System.out.println("Elfo tentou a sorte!");
    }
        
    public boolean equals(Object obj) {
        Elfo outro = (Elfo)obj;
        return this.getNome() == outro.getNome() && this.getExperiencia() == outro.getExperiencia() && this.getVida() == outro.getVida() && this.getFlechas() ==
            outro.getFlechas();
    }
}
