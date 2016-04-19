import java.util.*;
public class ExercitoDeElfos {
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> elfosAgrupados = new HashMap<>();
    private Estrategia estrategia = new Estrategia1();

    public void alistarElfo(Elfo elfo) {
        if( elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde) {
        exercito.put(elfo.getNome(), elfo);
       }
    }
    
    public Elfo buscarElfo(String nome) {
        return exercito.get(nome);
    }
    
    public HashMap<String, Elfo> getExercito() {
        return this.exercito;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getElfosAgrupados() {
        return this.elfosAgrupados;
    }
    
    public void agruparElfos() {
        elfosAgrupados.clear();
        Status statusElfoAtual;
        for(String chave : exercito.keySet()) {
            statusElfoAtual = exercito.get(chave).getStatus();
            if(!(elfosAgrupados.containsKey(statusElfoAtual))){
                elfosAgrupados.put(statusElfoAtual, new ArrayList<Elfo>());
            }
            elfosAgrupados.get(statusElfoAtual).add(exercito.get(chave));
            }
        }
     
    public ArrayList<Elfo> buscar (Status status) {
       return elfosAgrupados.get(status);
    }
    
    public void mudarEstrategia (Estrategia estrategia) {
        this.estrategia = estrategia;
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.estrategia.getOrdemDoUltimoAtaque();
    }
    
     public void atacar(ArrayList<Dwarf> alvos) {
         this.estrategia.estrategiaDeAtaque(this.getElfosAgrupados().get(Status.VIVO),alvos);
     }
    
   // public void estrategiaDeAtaque(ExercitoDeElfos exercito, ArrayList<Dwarf> dwarfs){
     //   Estrategia estrategia1 = new Estrategia1();
       // estrategia1.estrategiaDeAtaque(exercito,dwarfs);
    //}
    
}

