import java.util.*;
public class Estrategia1 implements Estrategia {
        private static ArrayList<Elfo> OrdemDoUltimoAtaque = new ArrayList<>();
        
        public void estrategiaDeAtaque(ArrayList<Elfo> horda, ArrayList<Dwarf> alvos) {
            OrdemDoUltimoAtaque.clear();
            double intencoes = 0;
            int contadorVerde = 0, contadorNoturno = 0, numeroDwarves = alvos.size();
            intencoes = this.calcularIntencoes(contadorVerde,contadorNoturno,horda, numeroDwarves);
            this.batalha(horda,alvos,intencoes);
        }
        
        public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
            return this.OrdemDoUltimoAtaque;
        }
        
        private double calcularIntencoes (int contadorVerde, int contadorNoturno, ArrayList<Elfo> horda, int numeroDwarves){
            for (Elfo elfo : horda) {
                if(elfo instanceof ElfoVerde) {
                    contadorVerde++;
                } else {
                    contadorNoturno++;
                }
            }
            return ((contadorVerde + contadorNoturno) * numeroDwarves);
        }
        
        private void batalha (ArrayList<Elfo> horda, ArrayList<Dwarf> alvos, double intencoes) {
            double intencoesElfoNoturno = Math.floor(intencoes * 0.3);
            for (Elfo elfo : horda) {
                if(elfo instanceof ElfoNoturno && intencoesElfoNoturno > 0 || elfo instanceof ElfoVerde) {
                    OrdemDoUltimoAtaque.add(elfo);
                    for(Dwarf dwarf : alvos){
                        elfo.atirarFlecha(dwarf);
                        if (elfo instanceof ElfoNoturno) intencoesElfoNoturno--;
                    }
                } else {
                    continue;
                }
            }
        }
        
        
}