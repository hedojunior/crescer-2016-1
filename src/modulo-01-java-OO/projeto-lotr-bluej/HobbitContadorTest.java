import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class HobbitContadorTest
{
    @Test
    public void SeORetornoDoValorVaiSerCorretoCom3ArraysInternos() {
        //Arrange
        HobbitContador contador = new HobbitContador();
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        //Act
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        arrayDePares.add(new ArrayList(Arrays.asList(28,7)));
        arrayDePares.add(new ArrayList(Arrays.asList(33,27)));
        //Assert
        assertEquals(822,contador.calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void SeORetornoDoValorVaiSerCorretoCom1ArrayInterno() {
        //Arrange
        HobbitContador contador = new HobbitContador();
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        //Act
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        //Assert
        assertEquals(60,contador.calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void SeORetornoDoValorVaiSerCorretoCom5ArraysInternos() {
        //Arrange
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();
        //Act
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        arrayDePares.add(new ArrayList(Arrays.asList(28,7)));
        arrayDePares.add(new ArrayList(Arrays.asList(33,27)));
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        arrayDePares.add(new ArrayList(Arrays.asList(12,6)));
        //Assert
        assertEquals(942,contador.calcularDiferenca(arrayDePares));
    }
    
   @Test
   public void seRetornaOValorCorretoComParametroSendo100() {
        //Arrange
        HobbitContador contador = new HobbitContador();
        //Act
        //Assert
        assertEquals(99,contador.obterMaiorMultiploDeTresAte(100));    
   }
   
   @Test
   public void seRetornaOValorCorretoComParametroSendo3() {
        //Arrange
        HobbitContador contador = new HobbitContador();
        //Act
        //Assert
        assertEquals(3,contador.obterMaiorMultiploDeTresAte(3));    
   }
   
   @Test
   public void seRetornaOValorCorretoComParametroSendo0() {
        //Arrange
        HobbitContador contador = new HobbitContador();
        //Act
        //Assert
        assertEquals(0,contador.obterMaiorMultiploDeTresAte(0));    
   }
}

