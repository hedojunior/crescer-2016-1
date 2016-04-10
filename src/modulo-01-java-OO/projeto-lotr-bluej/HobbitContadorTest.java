import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class HobbitContadorTest
{
    @Test
    public void SeORetornoDoValorVaiSerCorretoCom3ArraysInternos() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        arrayDePares.add(new ArrayList(Arrays.asList(28,7)));
        arrayDePares.add(new ArrayList(Arrays.asList(33,27)));
        HobbitContador contador = new HobbitContador();
        assertEquals(822,contador.calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void SeORetornoDoValorVaiSerCorretoCom1ArrayInterno() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        HobbitContador contador = new HobbitContador();
        assertEquals(60,contador.calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void SeORetornoDoValorVaiSerCorretoCom5ArraysInternos() {
        int esperado;
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        arrayDePares.add(new ArrayList(Arrays.asList(28,7)));
        arrayDePares.add(new ArrayList(Arrays.asList(33,27)));
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        HobbitContador contador = new HobbitContador();
        assertEquals(942,contador.calcularDiferenca(arrayDePares));
    }
    
}
