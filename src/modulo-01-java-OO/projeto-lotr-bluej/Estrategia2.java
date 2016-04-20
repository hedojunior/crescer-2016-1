import java.util.*;
public class Estrategia2 implements Estrategia {
   private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
   public void estrategiaDeAtaque(ArrayList<Elfo> horda, ArrayList<Dwarf> alvos) {
       ordemDoUltimoAtaque.clear();
       ordenarElfos(horda);
       for(int i = 0; i < horda.size(); i ++){
            horda.get(i).atirarFlechasDwarf(ordemDoUltimoAtaque,alvos);
       }
   }
    
    
   public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
       return this.ordemDoUltimoAtaque;
   }
    
   public void ordenarElfos(ArrayList<Elfo> horda) {
       Collections.sort(horda, new Comparator<Elfo>() {
       public int compare(Elfo e1, Elfo e2) {
       Elfo el1 = (Elfo)e1;
       Elfo el2 = (Elfo)e2;
  
       if(el1.getClass() == el2.getClass())
            return 0;
   
       return el1 instanceof ElfoVerde && el2 instanceof ElfoNoturno ? -1 : 1;

       }});
   }
   
}