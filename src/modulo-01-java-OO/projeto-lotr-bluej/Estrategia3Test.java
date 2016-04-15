import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class Estrategia3Test {

    @Test
    public void intercala4Elfos(){
        Estrategia3 estrategia = new Estrategia3();
        ArrayList<Elfo> elfos = new ArrayList<>();
        Elfo elfo1 = new ElfoNoturno("EN1");
        Elfo elfo2 = new ElfoNoturno("EN2");
        Elfo elfo3 = new ElfoVerde("EV1");
        Elfo elfo4 = new ElfoVerde("EV2");
        elfos.add(elfo1);
        elfos.add(elfo2);
        elfos.add(elfo3);
        elfos.add(elfo4);
        ArrayList<Elfo> obtida = estrategia.intercalaElfos(elfos);
        assertEquals(elfo1, obtida.get(0));
        assertEquals(elfo3, obtida.get(1));
        assertEquals(elfo2, obtida.get(2));
        assertEquals(elfo4, obtida.get(3));
    }
    
    @Test
    public void intercala2Elfos(){
        Estrategia3 estrategia = new Estrategia3();
        ArrayList<Elfo> elfos = new ArrayList<>();
        Elfo elfo1 = new ElfoNoturno("EN1");
        Elfo elfo2 = new ElfoVerde("EV1");
        elfos.add(elfo1);
        elfos.add(elfo2);
        ArrayList<Elfo> obtida = estrategia.intercalaElfos(elfos);
        assertEquals(elfo1, obtida.get(0));
        assertEquals(elfo2, obtida.get(1));
    }
    
    @Test
    public void intercala6Elfos(){
        Estrategia3 estrategia = new Estrategia3();
        ArrayList<Elfo> elfos = new ArrayList<>();
        Elfo elfo1 = new ElfoNoturno("EN1");
        Elfo elfo2 = new ElfoNoturno("EN2");
        Elfo elfo3 = new ElfoNoturno("EN3");
        Elfo elfo4 = new ElfoVerde("EV1");
        Elfo elfo5 = new ElfoVerde("EV2");
        Elfo elfo6 = new ElfoVerde("EV3");
        elfos.add(elfo1);
        elfos.add(elfo2);
        elfos.add(elfo3);
        elfos.add(elfo4);
        elfos.add(elfo5);
        elfos.add(elfo6);
        ArrayList<Elfo> obtida = estrategia.intercalaElfos(elfos);
        assertEquals(elfo1.getClass(), obtida.get(0).getClass());
        assertEquals(elfo4.getClass(), obtida.get(1).getClass());
        assertEquals(elfo2.getClass(), obtida.get(2).getClass());
        assertEquals(elfo5.getClass(), obtida.get(3).getClass());
        assertEquals(elfo3.getClass(), obtida.get(4).getClass());
        assertEquals(elfo6.getClass(), obtida.get(5).getClass());
    }
    
    @Test
    public void verificaSeArrayListTemOMesmoNumeroDeElfosVerdesENoturnos() {
        Estrategia3 estrategia = new Estrategia3();
        ArrayList<Elfo> elfos = new ArrayList<>();
        Elfo elfo1 = new ElfoNoturno("EN1");
        Elfo elfo2 = new ElfoVerde("EV1");
        Elfo elfo3 = new ElfoNoturno("EN2");
        Elfo elfo4 = new ElfoVerde("EV2");
        elfos.add(elfo1);
        elfos.add(elfo2);
        elfos.add(elfo3);
        elfos.add(elfo4);
        assertTrue(estrategia.checa5050(elfos));
    }
    
    @Test
    public void verificaSeArrayListNaoTemOMesmoNumeroDeElfosVerdesENoturnos() {
        Estrategia3 estrategia = new Estrategia3();
        ArrayList<Elfo> elfos = new ArrayList<>();
        Elfo elfo1 = new ElfoNoturno("EN1");
        Elfo elfo2 = new ElfoNoturno("EN2");
        Elfo elfo3 = new ElfoNoturno("EN3");
        Elfo elfo4 = new ElfoVerde("EV1");
        elfos.add(elfo1);
        elfos.add(elfo2);
        elfos.add(elfo3);
        elfos.add(elfo4);
        assertFalse(estrategia.checa5050(elfos));
    }
    
    @Test
    public void estrategiaDeAtaqueIntercaladoRetornaArrayListQueContemElfosQueLutaram() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new Estrategia3());
        Elfo elfo1 = new ElfoVerde("verdinho");
        Elfo elfo2 = new ElfoVerde("verdinhozinho");
        Elfo elfo3 = new ElfoNoturno("noturninho");
        Elfo elfo4 = new ElfoNoturno("noturninhozinho");
        exercito.alistarElfo(elfo1);
        exercito.alistarElfo(elfo2);
        exercito.alistarElfo(elfo3);
        exercito.alistarElfo(elfo4);
        exercito.agruparElfos();
        ArrayList<Dwarf> alvos = new ArrayList<>();
        alvos.add(new Dwarf("Gimli"));
        alvos.add(new Dwarf("Bimbur"));
        exercito.atacar(alvos);
        ArrayList<Elfo> obtido = exercito.getOrdemDoUltimoAtaque();
        assertTrue(obtido.contains(elfo1));
        assertTrue(obtido.contains(elfo2));
        assertTrue(obtido.contains(elfo3));
        assertTrue(obtido.contains(elfo4));
    }
}
