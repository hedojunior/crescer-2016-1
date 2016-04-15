import java.util.*;
public class Estrategia1 implements Estrategia {
        private static ArrayList<Elfo> OrdemDoUltimoAtaque = new ArrayList<>();
        
        public void estrategiaDeAtaque(ArrayList<Elfo> horda, ArrayList<Dwarf> alvos) {
            OrdemDoUltimoAtaque.clear();
            double intencoes = 0;
            int numeroDwarves = alvos.size();
            intencoes = this.calcularIntencoes(horda, numeroDwarves);
            this.batalha(horda,alvos,intencoes);
        }
        
        public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
            return this.OrdemDoUltimoAtaque;
        }
        
        public double calcularIntencoes (ArrayList<Elfo> horda, int numeroDwarves){
            int contadorVerde = 0, contadorNoturno = 0;
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
                        if (elfo instanceof ElfoNoturno && intencoesElfoNoturno > 0){
                            elfo.atirarFlecha(dwarf);
                            intencoesElfoNoturno--;
                        }   else if (elfo instanceof ElfoVerde){
                                elfo.atirarFlecha(dwarf);
                            }
                    }
                    } else {
                        continue;
                }
            }
        }
        
        
}