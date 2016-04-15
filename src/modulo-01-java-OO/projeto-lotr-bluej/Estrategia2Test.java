

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class Estrategia2Test {
    @Test
    public void atacaEmOrdem() {
        Estrategia estrategia = new Estrategia2();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(estrategia);
        Elfo v1 = new ElfoVerde("EV1");
        Elfo n1 = new ElfoNoturno("EN1");
        Elfo v2 = new ElfoVerde("EV2");
        Elfo n2 = new ElfoNoturno("EN2");
        exercito.alistarElfo(v1);
        exercito.alistarElfo(n1);
        exercito.alistarElfo(v2);
        exercito.alistarElfo(n2);
        exercito.agruparElfos();
        ArrayList<Elfo> horda = exercito.buscar(Status.VIVO);
        ArrayList<Dwarf> alvos = new ArrayList<>();
        alvos.add(new Dwarf("Gimli"));
        alvos.add(new Dwarf("Bomfur"));
        estrategia.estrategiaDeAtaque(horda,alvos);
        assertEquals(v2, estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(v1, estrategia.getOrdemDoUltimoAtaque().get(2));
        assertEquals(n2, estrategia.getOrdemDoUltimoAtaque().get(4));
        assertEquals(n1, estrategia.getOrdemDoUltimoAtaque().get(6));
    }
    
    @Test
    public void atacaEmOrdemSóNoturnos() {
        Estrategia estrategia = new Estrategia2();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(estrategia);
        Elfo n1 = new ElfoNoturno("EN1");
        Elfo n2 = new ElfoNoturno("EN2");
        exercito.alistarElfo(n1);
        exercito.alistarElfo(n2);
        exercito.agruparElfos();
        ArrayList<Elfo> horda = exercito.buscar(Status.VIVO);
        ArrayList<Dwarf> alvos = new ArrayList<>();
        alvos.add(new Dwarf("Gimli"));
        alvos.add(new Dwarf("Bomfur"));
        estrategia.estrategiaDeAtaque(horda,alvos);
        assertEquals(n2, estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(n1, estrategia.getOrdemDoUltimoAtaque().get(2));
    }
    
    @Test
    public void atacaEmOrdemSóVerde() {
        Estrategia estrategia = new Estrategia2();
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(estrategia);
        Elfo v1 = new ElfoVerde("EV1");
        Elfo v2 = new ElfoVerde("EV2");
        exercito.alistarElfo(v1);
        exercito.alistarElfo(v2);
        exercito.agruparElfos();
        ArrayList<Elfo> horda = exercito.buscar(Status.VIVO);
        ArrayList<Dwarf> alvos = new ArrayList<>();
        alvos.add(new Dwarf("Gimli"));
        alvos.add(new Dwarf("Bomfur"));
        estrategia.estrategiaDeAtaque(horda,alvos);
        assertEquals(v2, estrategia.getOrdemDoUltimoAtaque().get(0));
        assertEquals(v1, estrategia.getOrdemDoUltimoAtaque().get(2));
    }

}
