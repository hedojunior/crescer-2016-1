import java.util.*;
public class ExercitoDeElfos {
    HashMap<String, Elfo> exercito = new HashMap<>();
    HashMap<Status, ArrayList<Elfo>> elfosAgrupados = new HashMap<>();
    public void alistarElfo(Elfo elfo) {
        if( elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde ) {
            exercito.put(elfo.getNome(),elfo);
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
        for(String chave : exercito.keySet()) {
            if(!(elfosAgrupados.containsKey(exercito.get(chave).getStatus()))){
                elfosAgrupados.put(exercito.get(chave).getStatus(), new ArrayList<Elfo>());
                elfosAgrupados.get(exercito.get(chave).getStatus()).add(exercito.get(chave));
            } else {
                elfosAgrupados.get(exercito.get(chave).getStatus()).add(exercito.get(chave));
            }
        }
    }
    
    public ArrayList<Elfo> buscar (Status status) {
       return elfosAgrupados.get(status);
    }
}

