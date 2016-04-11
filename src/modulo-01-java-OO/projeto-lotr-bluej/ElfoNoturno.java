public class ElfoNoturno extends Elfo
{
    public ElfoNoturno (String nome) {
        super(nome);
    }
    
    public ElfoNoturno (String nome, int flechas) {
        super(nome, flechas);
    }
    
    public void atirarFlechaDwarf(Dwarf dwarf) {
        if(this.status == Status.VIVO){
        super.atirarFlechaDwarf(dwarf);
        this.experiencia += 2;
        this.vida -=  5;
        this.estaVivo();
       }
    }
    /* Resposta da Questão 7.2:
     * No modo que estava, os Elfos Noturnos não poderiam morrer nunca, pois se os 5% de sua vida fossem
     * calculados à cada iteração, ele nunca morreria, pois o calculo diminuiria exponencialmente com o
     * valor. A solução que encontrei foi a de calcular 5% do VALOR INICIAL da vida de todos os Elfos
     * Noturnos, que acabou sendo 5 (100/100 * 5), fazendo assim com que seja possível a morte do Elfo.
     */
    
    
    
    
    public void estaVivo() {
        if(this.vida <= 0) {
            this.status = Status.MORTO;
        }
    }
    
    
    
    
}