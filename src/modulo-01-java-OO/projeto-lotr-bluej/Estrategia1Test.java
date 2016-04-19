

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
public class Estrategia1Test {
   
    @Test
    public void ContemOsElfosQueAtacaramNoArrayList() {
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
    public void ElfosQueAtacaramEstaoEmOrdemNoArrayList() {
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
    public void ElfosVerdesQueAtacaramEstaoEmOrdemNoArrayList() {
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
    public void NenhumElfoAtacarNaoInsereNadaNoSegundoArrayList() {
        Estrategia estrategia = new Estrategia1();
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(new Dwarf("Gimli"));
        anoes.add(new Dwarf("Bomfur"));
        ArrayList<Elfo> vazio = new ArrayList<>();
        estrategia.estrategiaDeAtaque(vazio,anoes);
        ArrayList<Elfo> atacantes = estrategia.getOrdemDoUltimoAtaque();
        assertTrue(atacantes.isEmpty());
    }
    
    @Test
    public void UmElfoVerdeAtacaInsereNoSegundoArrayList() {
        Estrategia estrategia = new Estrategia1();
        Elfo elfo = new ElfoVerde("G1");
        ArrayList<Elfo> horda = new ArrayList<>();
        horda.add(elfo);
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(new Dwarf("Gimli"));
        anoes.add(new Dwarf("Bomfur"));
        estrategia.estrategiaDeAtaque(horda,anoes);
        ArrayList<Elfo> atacantes = estrategia.getOrdemDoUltimoAtaque();
        assertTrue(atacantes.contains(elfo));
    }
    
    @Test
    public void UmElfoAtacaInsereNoSegundoArrayList() {
        Estrategia estrategia = new Estrategia1();
        Elfo elfo = new Elfo("G1");
        ArrayList<Elfo> horda = new ArrayList<>();
        horda.add(elfo);
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(new Dwarf("Gimli"));
        anoes.add(new Dwarf("Bomfur"));
        estrategia.estrategiaDeAtaque(horda,anoes);
        ArrayList<Elfo> atacantes = estrategia.getOrdemDoUltimoAtaque();
        assertTrue(atacantes.contains(elfo));
    }
    
    @Test
    public void UmElfoNoturnoAtacaDoisDwarvesENaoInsereNoSegundoArrayList() {
        Estrategia estrategia = new Estrategia1();
        Elfo elfo = new ElfoNoturno("G1");
        ArrayList<Elfo> horda = new ArrayList<>();
        horda.add(elfo);
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(new Dwarf("Gimli"));
        anoes.add(new Dwarf("Bomfur"));
        estrategia.estrategiaDeAtaque(horda,anoes);
        ArrayList<Elfo> atacantes = estrategia.getOrdemDoUltimoAtaque();
        assertFalse(atacantes.contains(elfo));
    }
    
    @Test
    public void UmElfoNoturnoAtacaQuatroDwarvesEInsereInsereNoSegundoArrayList() {
        Estrategia estrategia = new Estrategia1();
        Elfo elfo = new ElfoNoturno("G1");
        ArrayList<Elfo> horda = new ArrayList<>();
        horda.add(elfo);
        ArrayList<Dwarf> anoes = new ArrayList<>();
        anoes.add(new Dwarf("Gimli"));
        anoes.add(new Dwarf("Bomfur"));
        anoes.add(new Dwarf("Kili"));
        anoes.add(new Dwarf("Fili"));
        estrategia.estrategiaDeAtaque(horda,anoes);
        ArrayList<Elfo> atacantes = estrategia.getOrdemDoUltimoAtaque();
        assertTrue(atacantes.contains(elfo));
    }
}   
 
