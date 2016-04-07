

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
   @Test
   public void criarElfo(){
       Elfo elfo = new Elfo("Elfo");
       int flechas_esperadas = 42;
       assertEquals(flechas_esperadas, elfo.getFlechas());  
   }
   
   @Test
   public void criarDoisElfos(){
       Elfo elfo = new Elfo("Elfo");
       Elfo elfo2 = new Elfo("Elfo2");
       int flechas_esperadas = 42;
       assertEquals(flechas_esperadas, elfo.getFlechas());  
       assertEquals(flechas_esperadas, elfo2.getFlechas());
   }
    
   @Test
   public void criarElfoSemNome(){
       Elfo elfo = new Elfo("");
       int flechas_esperadas = 42;
       assertEquals(flechas_esperadas, elfo.getFlechas());  
       
   }
   
   @Test
   public void criarElfoCom100000Flechas(){
       Elfo elfo = new Elfo("Elfo",100000);
       int flechas_esperadas = 100000;
       assertEquals(flechas_esperadas, elfo.getFlechas());  
   }    
       
   @Test
   public void AtirarFlechaDwarf(){
      Elfo elfo = new Elfo("Elfo");
      Dwarf dwarf = new Dwarf("Dwarf");
      
      int xp_esperado = elfo.getExperiencia() + 1;
      int flechas_esperadas = elfo.getFlechas() - 1;
      
      elfo.atirarFlechaDwarf(dwarf);
      
      int flechas_obtidas = elfo.getFlechas();
      int xp_obtido = elfo.getExperiencia();
      
      assertEquals(xp_esperado , xp_obtido);
      assertEquals(flechas_esperadas , flechas_obtidas);
   }
   
   @Test
   public void atirarFlechaEmTresDwarfs(){
      Elfo elfo = new Elfo("Elfo");
      Dwarf dwarf = new Dwarf("Dwarf");
      Dwarf dwarf2 = new Dwarf("Dwarf2");
      Dwarf dwarf3 = new Dwarf("Dwarf3");
      
      int xp_esperado = elfo.getExperiencia() + 3;
      int flechas_esperadas = elfo.getFlechas() - 3;
      
      elfo.atirarFlechaDwarf(dwarf);
      elfo.atirarFlechaDwarf(dwarf2);
      elfo.atirarFlechaDwarf(dwarf3);
      
      int flechas_obtidas = elfo.getFlechas();
      int xp_obtido = elfo.getExperiencia();
      
      assertEquals(xp_esperado , xp_obtido);
      assertEquals(flechas_esperadas , flechas_obtidas);
   }
   
   @Test
   public void atirarFlechaEmDwarfSemNome(){
      Elfo elfo = new Elfo("Elfo");
      Dwarf dwarf = new Dwarf("");
     
      int xp_esperado = elfo.getExperiencia() + 1;
      int flechas_esperadas = elfo.getFlechas() - 1;
      
      elfo.atirarFlechaDwarf(dwarf);
      
      int flechas_obtidas = elfo.getFlechas();
      int xp_obtido = elfo.getExperiencia();
      
      assertEquals(xp_esperado , xp_obtido);
      assertEquals(flechas_esperadas , flechas_obtidas);
   }
   
   @Test
   public void milFlechasToString(){
       Elfo elfo = new Elfo("Legolas",1000);
       String esperada = "Legolas possui 1000 flechas e 0 níveis de experiência."; 
       assertEquals(esperada, elfo.toString());  
   }
   
   @Test
   public void retornarDoisElfosToString(){
       Elfo elfo = new Elfo("Legolas",1000);
       Elfo elfo2 = new Elfo("Baby Legolas",5);
       String esperada = "Legolas possui 1000 flechas e 0 níveis de experiência.";
       String esperada2 = "Baby Legolas possui 5 flechas e 0 níveis de experiência."; 
       assertEquals(esperada, elfo.toString());
       assertEquals(esperada2, elfo2.toString());
   }
   
   
}
