import java.util.*;
public class Estrategia1 implements Estrategia {
        private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();
        
        public void estrategiaDeAtaque(ArrayList<Elfo> horda, ArrayList<Dwarf> alvos) {
            ordemDoUltimoAtaque.clear();
            double intencoes = 0;
            int numeroDwarves = alvos.size();
            intencoes = this.calcularIntencoes(horda, numeroDwarves);
            this.batalha(horda,alvos,intencoes);
        }
        
        public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
            return this.ordemDoUltimoAtaque;
        }
        
        private double calcularIntencoes (ArrayList<Elfo> horda, int numeroDwarves){
            return (horda.size() * numeroDwarves);
        }
        
        private void batalha (ArrayList<Elfo> horda, ArrayList<Dwarf> alvos, double intencoes) {
            int intencoesElfoNoturno = (int)(intencoes * 0.3);
            boolean classeElfo;
            for (Elfo elfo : horda) {
                classeElfo = elfo instanceof ElfoNoturno;
                if(classeElfo && intencoesElfoNoturno > 0 || !classeElfo) {
                    ordemDoUltimoAtaque.add(elfo);
                    for(Dwarf dwarf : alvos){
                        elfo.atirarFlecha(dwarf);
                        if(classeElfo)intencoesElfoNoturno--;
                    }  
                }
            }
        }
}