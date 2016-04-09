import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void EhBissexto() {
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra(06,04,2016);
        //Act
        //Assert
        assertTrue(data.ehBissexto());   
    }
    
    @Test
    public void NaoEhBissexto() {
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra(06,04,915);
        //Act
        //Assert
        assertFalse(data.ehBissexto());   
    }
    
    @Test
    public void NaoEhBissextoAntigo() {
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra(06,04,1015);
        //Act
        //Assert
        assertFalse(data.ehBissexto());   
    }
    
    @Test
    public void SeraBissexto() {
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra(06,04,2400);
        //Act
        //Assert
        assertTrue(data.ehBissexto());
    }
    
    @Test
    public void SeraBissextoComMilhar() {
        //Arrange
        DataTerceiraEra data = new DataTerceiraEra(29,11,3400);
        //Act
        //Assert
        assertFalse(data.ehBissexto());
    }
}
