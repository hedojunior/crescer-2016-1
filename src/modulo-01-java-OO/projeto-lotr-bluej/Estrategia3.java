import java.util.ArrayList;
public class Estrategia3 implements Estrategia {
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    
    public void estrategiaDeAtaque(ArrayList<Elfo> horda, ArrayList<Dwarf> alvos) {
        ordemDoUltimoAtaque.clear();
        ArrayList<Elfo> intercalados = new ArrayList<>();
        if(checa5050(horda)){
            intercalados = this.intercalaElfos(horda);
            for(int i = 0; i < intercalados.size(); i++){
                intercalados.get(i).atirarFlechasDwarf(ordemDoUltimoAtaque,alvos);
            }
        }
    }
    
    public boolean checa5050(ArrayList<Elfo> horda) {
        int elfoNoturno = 0, elfoVerde = 0;
        for (int i =0; i < horda.size(); i++){
            if(horda.get(i) instanceof ElfoNoturno) {
                elfoNoturno++;
            } else{
                elfoVerde++;
            }
        }
        return elfoNoturno == elfoVerde;
    }
    
    public ArrayList<Elfo> intercalaElfos(ArrayList<Elfo> horda) {
        ArrayList<Elfo> intercalados = new ArrayList<>();
        boolean verdeOuNoturno = true;
        boolean contem;
        while(intercalados.size() != horda.size()){
            for(int i = 0; i < horda.size(); i++){
                contem = !intercalados.contains(horda.get(i));
                if(i == 0 && contem) {
                    intercalados.add(horda.get(i));
                    continue;
                }else{
                    if(intercalados.get(intercalados.size() - 1) instanceof ElfoVerde)
                    verdeOuNoturno = true;
                    else if(intercalados.get(intercalados.size() - 1) instanceof ElfoNoturno)
                    verdeOuNoturno = false;
                    
                    if(verdeOuNoturno && horda.get(i) instanceof ElfoNoturno 
                    && contem) {
                        intercalados.add(horda.get(i));
                    }else if( !verdeOuNoturno && horda.get(i) instanceof ElfoVerde
                    && contem) {
                        intercalados.add(horda.get(i));
                    }
                }
            }
        }
        return intercalados;
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }
}