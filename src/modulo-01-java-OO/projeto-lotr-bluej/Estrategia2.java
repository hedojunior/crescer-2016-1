import java.util.ArrayList;
public class Estrategia2 implements Estrategia {
    private static ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
    public void estrategiaDeAtaque(ArrayList<Elfo> horda, ArrayList<Dwarf> alvos) {
       ordemDoUltimoAtaque.clear();
       int j = 0;
       while(j < 1) {
            for(int i = 0; i < horda.size(); i ++){
                if(j == 0 && horda.get(i) instanceof ElfoVerde) {
                    horda.get(i).atirarFlechasDwarf(ordemDoUltimoAtaque,alvos);
                } else if( horda.get(i) instanceof ElfoNoturno) {
                    horda.get(i).atirarFlechasDwarf(ordemDoUltimoAtaque,alvos);
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