

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void estaMorto() {
        //Arrange
        ElfoNoturno elfo = new ElfoNoturno("DarkElf");
        //Act
        for(int i = 0; i < 90; i++){
            elfo.atirarFlechaDwarf(new Dwarf("Gimli"));
        }
        //Assert
        assertEquals(Status.MORTO,elfo.getStatus());
    }
    
    @Test
    public void ganha9Experiencia() {
        //Arrange
        ElfoNoturno elfo = new ElfoNoturno("DarkElf");
        //Act
        for(int i = 0; i <= 2; i++){
            elfo.atirarFlechaDwarf(new Dwarf("Gimli"));
        }
        //Assert
        assertEquals(9,elfo.getExperiencia());
    }
    
    @Test
    public void perde5PorcentodeVidaDuasVezes() {
        //Arrange
        ElfoNoturno elfo = new ElfoNoturno("DarkElf");
        Dwarf d = new Dwarf("Gimli");
        //Act
        elfo.atirarFlechaDwarf(d);
        elfo.atirarFlechaDwarf(d);
        //Assert
        assertEquals(90.25, elfo.getVida(),0);
    }
    
    @Test
    public void perde5deVidaQuandoAtira() {
        //Arrange  
        ElfoNoturno elfo = new ElfoNoturno("DarkElf");
        //Act
        elfo.atirarFlechaDwarf(new Dwarf("Gimli"));
        //Assert
        assertEquals(95, elfo.getVida(),0);
    }
    
}
