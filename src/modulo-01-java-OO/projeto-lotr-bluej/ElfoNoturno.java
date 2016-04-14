public class ElfoNoturno extends Elfo
{
    public ElfoNoturno (String nome) {
        super(nome);
    }
    
    public ElfoNoturno (String nome, int flechas) {
        super(nome, flechas);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        super.atirarFlecha(dwarf);
        this.experiencia += 2;
        this.vida -= ((this.vida / 100) * 5);
        this.estaVivo();
       
    }
    /* Resposta da Questão 7.2:
     * No modo que estava, os Elfos Noturnos não poderiam morrer nunca, pois se os 5% de sua vida fossem
     * calculados à cada iteração, ele nunca morreria, pois o calculo diminuiria exponencialmente com o
     * valor. A solução que encontrei foi a de calcular 5% do VALOR ATUAL da vida, trocando o tipo da va-
     * riável vida de todos os personagens para double, e quando a vida do elfo estiver entre 0 e 1 ele morre.
     */
        
    public void estaVivo() {
        if(this.vida < 1) {
            this.status = Status.MORTO;
        }
    }
    
    
    
    
}