import java.util.ArrayList;
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
}
