import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoDeElfosTest
{
   @Test
   public void alistaEBuscaElfoVerde() {
        //Arrange
        Elfo elfo = new ElfoVerde("Green Elf");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarElfo(elfo);
        //Assert
        assertEquals(elfo, exercito.buscarElfo("Green Elf"));
   }
    
   @Test
   public void alistaEBuscaElfoNoturno() {
        //Arrange
        Elfo elfo = new ElfoNoturno("Night Elf");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        //Act
        exercito.alistarElfo(elfo);
        //Assert
        assertEquals(elfo, exercito.buscarElfo("Night Elf"));
   }
    
   @Test
    public void naoAlistaElfoNormalERetornaNullAoBuscar() {
    //Arrange
    Elfo elfo = new Elfo("Elfo Generico");
    ExercitoDeElfos exercito = new ExercitoDeElfos();
    //Act
    exercito.alistarElfo(elfo);
    //Assert
    assertFalse(exercito.getExercito().containsValue(elfo));
    assertEquals(null, exercito.buscarElfo("Elfo Generico"));
   }
   
   @Test
   public void agrupaElfosVivosEmSegundaHashEmUmArrayList() {
       //Arrange
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       Elfo elfo1 = new ElfoVerde("ElfoVerde Generico");
       Elfo elfo2 = new ElfoNoturno("ElfoNoturno Generico");
       Elfo elfo3 = new ElfoNoturno("ElfoNoturno Generico #2");
       Elfo elfo4 = new ElfoVerde("ElfoVerde Generico #2");
       //Act
       exercito.alistarElfo(elfo1);
       exercito.alistarElfo(elfo2);
       exercito.alistarElfo(elfo3);
       exercito.alistarElfo(elfo4);
       exercito.agruparElfos();
       //Assert
       assertTrue(exercito.getElfosAgrupados().get(Status.VIVO).contains(elfo1));
       assertTrue(exercito.getElfosAgrupados().get(Status.VIVO).contains(elfo2));
       assertTrue(exercito.getElfosAgrupados().get(Status.VIVO).contains(elfo3));
       assertTrue(exercito.getElfosAgrupados().get(Status.VIVO).contains(elfo4));
   }
    
   @Test
   public void agrupaElfosVivosEmSegundaHashEmUmArrayListEElfoMortoEmUmaNovaArrayList() {
       //Arrange
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       Elfo elfo1 = new ElfoVerde("ElfoVerde Generico");
       Elfo elfo2 = new ElfoNoturno("ElfoNoturno Generico",100);
       Elfo elfo3 = new ElfoNoturno("ElfoNoturno Generico #2");
       Elfo elfo4 = new ElfoVerde("ElfoVerde Generico #2");
       //Act
       for (int i = 0; i< 90; i ++) {
           elfo2.atirarFlecha(new Dwarf("Gimli"));
       }
       exercito.alistarElfo(elfo1);
       exercito.alistarElfo(elfo2);
       exercito.alistarElfo(elfo3);
       exercito.alistarElfo(elfo4);
       exercito.agruparElfos();
       //Assert
       assertTrue(exercito.getElfosAgrupados().get(Status.VIVO).contains(elfo1));
       assertTrue(exercito.getElfosAgrupados().get(Status.MORTO).contains(elfo2));
       assertTrue(exercito.getElfosAgrupados().get(Status.VIVO).contains(elfo3));
       assertTrue(exercito.getElfosAgrupados().get(Status.VIVO).contains(elfo4));
   }
   
   @Test
   public void buscarElfosVivosCorretamente() {
       ArrayList<Elfo> vivosOrganizados, mortosOrganizados;
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       Elfo elfo1 = new ElfoVerde("ElfoVerde Generico");
       Elfo elfo2 = new ElfoNoturno("ElfoNoturno Generico",100);
       Elfo elfo3 = new ElfoNoturno("ElfoNoturno Generico #2");
       Elfo elfo4 = new ElfoVerde("ElfoVerde Generico #2");
       //Act
       for (int i = 0; i< 90; i ++) {
           elfo2.atirarFlecha(new Dwarf("Gimli"));
       }
       exercito.alistarElfo(elfo1);
       exercito.alistarElfo(elfo2);
       exercito.alistarElfo(elfo3);
       exercito.alistarElfo(elfo4);
       exercito.agruparElfos();
       vivosOrganizados = exercito.buscar(Status.VIVO);
       mortosOrganizados = exercito.buscar(Status.MORTO);
       assertTrue(vivosOrganizados.contains(elfo1));
       assertTrue(vivosOrganizados.contains(elfo3));
       assertTrue(vivosOrganizados.contains(elfo4));
       assertTrue(mortosOrganizados.contains(elfo2));
   }
   
   @Test
   public void retornarNullQuandoNãoHouveremElfosVivosAgrupados() {
       ExercitoDeElfos exercito = new ExercitoDeElfos();
       exercito.agruparElfos();
       assertEquals(null, exercito.buscar(Status.VIVO));
   }
}   
 