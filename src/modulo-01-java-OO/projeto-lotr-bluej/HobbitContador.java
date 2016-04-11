import java.util.*;
public class HobbitContador {
    public int calcularDiferenca(ArrayList<ArrayList<Integer>> arrayDePares) {
        int val1, val2, maior, menor, aux, j, i, somaProduto = 0, valoresMMC = 0;
        for (i = 0; i < arrayDePares.size(); i++) {
            val1 = arrayDePares.get(i).get(0);
            val2 = arrayDePares.get(i).get(1);
            somaProduto += val1 * val2;
            if(val1 > val2){
                maior = val1;
                menor = val2;
            }else{
                maior = val2;
                menor = val1;
             }
            for (j = 1; j <= menor; j++) {
                aux = maior * j;
                if ( aux % menor == 0){
                    valoresMMC += aux;
                    break;
                }
            }
        }
        return somaProduto - valoresMMC;
    }
    
    public int obterMaiorMultiploDeTresAte(int numero) {
    // ArrayList<Integer> multiplos = new ArrayList<>(Arrays.asList(0)); - O ArrayList é desnecessário, pois o método deve retornar um número inteiro tendo como parâmetro
    // Um número inteiro
    int multiplos = 0; // Cria-se uma variável para armazenar o resultado
    for (int i = 1; i <= /*limite */ numero; i++) { // Limite, além de estar errado - deveria ser multiplos.size() - é desnecessário, pois o ArrayList não existe mais.
        if (i % 3 == 0) {
            multiplos = i;
    //        continue;  É desnecessário pois, mesmo sem ele, a estrutura de repetição vai continuar repetindo até chegar no seu limite.
        }
    }
    return multiplos;
   }
}
