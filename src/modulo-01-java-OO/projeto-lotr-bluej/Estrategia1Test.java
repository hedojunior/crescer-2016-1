

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class Estrategia1Test {
   
    @Test
    public void testaSeContemOsElfosQueAtacaramNoArrayList() {
        Estrategia estrategia = new Estrategia1();
        ExercitoDeElfos exercito1 = new ExercitoDeElfos();
        Elfo elfonoturno1 = new ElfoNoturno("NightElf1");
        Elfo elfonoturno2 = new ElfoNoturno("NightElf2");
        Elfo elfonoturno3 = new ElfoNoturno("NightElf3");
        Elfo elfoverde1 = new ElfoVerde("GreenElf1");
        exercito1.alistarElfo(elfonoturno1);
        exercito1.alistarElfo(elfonoturno2);
        exercito1.alistarElfo(elfonoturno3);
        exercito1.alistarElfo(elfoverde1);
        exercito1.agruparElfos();
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(new Dwarf("Gimli"));
        anoes.add(new Dwarf("Bomfur"));
        estrategia.estrategiaDeAtaque(exercito1.buscar(Status.VIVO),anoes);
        ArrayList<Elfo> atacantes = estrategia.getOrdemDoUltimoAtaque();
        assertTrue(atacantes.contains(elfonoturno1));
        assertFalse(atacantes.contains(elfonoturno2));
        assertFalse(atacantes.contains(elfonoturno3));
        assertTrue(atacantes.contains(elfoverde1));
    }
    
    @Test
    public void testaSeOsElfosQueAtacaramEstaoEmOrdemNoArrayList() {
        Estrategia estrategia = new Estrategia1();
        ExercitoDeElfos exercito1 = new ExercitoDeElfos();
        Elfo elfonoturno1 = new ElfoNoturno("NightElf1");
        Elfo elfonoturno2 = new ElfoNoturno("NightElf2");
        Elfo elfonoturno3 = new ElfoNoturno("NightElf3");
        Elfo elfoverde1 = new ElfoVerde("GreenElf1");
        exercito1.alistarElfo(elfonoturno1);
        exercito1.alistarElfo(elfonoturno2);
        exercito1.alistarElfo(elfonoturno3);
        exercito1.alistarElfo(elfoverde1);
        exercito1.agruparElfos();
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(new Dwarf("Gimli"));
        anoes.add(new Dwarf("Bomfur"));
        estrategia.estrategiaDeAtaque(exercito1.buscar(Status.VIVO),anoes);
        ArrayList<Elfo> atacantes = estrategia.getOrdemDoUltimoAtaque();
        assertEquals(elfonoturno1, atacantes.get(0));
        assertEquals(elfoverde1,atacantes.get(1));
    }
    
    @Test
    public void testaSeOsElfosVerdesQueAtacaramEstaoEmOrdemNoArrayList() {
        Estrategia estrategia = new Estrategia1();
        ExercitoDeElfos exercito1 = new ExercitoDeElfos();
        Elfo elfoverde1 = new ElfoVerde("GreenElf1");
        Elfo elfoverde2 = new ElfoVerde("GreenElf2");
        Elfo elfoverde3 = new ElfoVerde("GreenElf3");
        Elfo elfoverde4 = new ElfoVerde("GreenElf4");
        exercito1.alistarElfo(elfoverde1);
        exercito1.alistarElfo(elfoverde2);
        exercito1.alistarElfo(elfoverde3);
        exercito1.alistarElfo(elfoverde4);
        exercito1.agruparElfos();
        ArrayList<Elfo> esperado = exercito1.buscar(Status.VIVO);
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(new Dwarf("Gimli"));
        anoes.add(new Dwarf("Bomfur"));
        estrategia.estrategiaDeAtaque(exercito1.buscar(Status.VIVO),anoes);
        ArrayList<Elfo> atacantes = estrategia.getOrdemDoUltimoAtaque();
        assertEquals(esperado, atacantes);
    }
    
    @Test
    public void calculaIntencoesCorretamente() {
        Estrategia1 estrategia = new Estrategia1();
        ArrayList<Elfo> elfos = new ArrayList<>();
        elfos.add(new ElfoNoturno("N1"));
        elfos.add(new ElfoNoturno("N2"));
        elfos.add(new ElfoNoturno("N3"));
        elfos.add(new ElfoVerde("V1"));
        assertEquals(8,estrategia.calcularIntencoes(elfos, 2),0);
        
    }
}   
 
