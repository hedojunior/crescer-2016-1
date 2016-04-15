import java.util.ArrayList;
public class Estrategia2 implements Estrategia {
    private static ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    public void estrategiaDeAtaque(ArrayList<Elfo> horda, ArrayList<Dwarf> alvos) {
        ordemDoUltimoAtaque.clear();
       int j = 0;
       while(j < 2) {
            for(int i = 0; i < horda.size(); i ++){
                if(j == 0 && horda.get(i) instanceof ElfoVerde) {
                    for(Dwarf dwarf: alvos) {
                        horda.get(i).atirarFlecha(dwarf);
                        ordemDoUltimoAtaque.add(horda.get(i));
                    }
                } else {
                    for(Dwarf dwarf: alvos) {
                       horda.get(i).atirarFlecha(dwarf);
                        ordemDoUltimoAtaque.add(horda.get(i));
                    }
                }
            }
            j++;
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }
    
    private void validaElfo(Elfo elfo) {
      
    }
}