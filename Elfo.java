public class Elfo {
    private String nome;
    private int experiencia, flechas = 42;
    
    public Elfo(String nome) {
		this.nome = nome;
    }
    
    public int getFlechas(){
        return flechas;
    }
    
     public int getExperiencia(){
        return experiencia;
    }
    
    
    public void atirarFlechaDwarf(Dwarf dwarf) {
        experiencia++;
        flechas--;
        dwarf.danoRecebido();               
    }
    
   // public void toString () {
     //  String string_xp = Elfo.getExperiencia().toString();
       //System.out.println(string_xp);         
    //}
}
