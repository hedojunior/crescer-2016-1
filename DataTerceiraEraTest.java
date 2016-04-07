import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void EhBissexto() {
        DataTerceiraEra data = new DataTerceiraEra(06,04,2016);
        boolean esperado = true;
        boolean obtido = data.ehBissexto();
        assertEquals(esperado, obtido);   
    }
    
    @Test
    public void NaoEhBissexto() {
        DataTerceiraEra data = new DataTerceiraEra(06,04,2015);
        boolean esperado = false;
        boolean obtido = data.ehBissexto();
        assertEquals(esperado, obtido);   
    }
    
    @Test
    public void NaoEhBissextoAntigo() {
        DataTerceiraEra data = new DataTerceiraEra(06,04,1015);
        boolean esperado = false;
        boolean obtido = data.ehBissexto();
        assertEquals(esperado, obtido);   
    }
    
    
    @Test
    public void SeraBissexto() {
        DataTerceiraEra data = new DataTerceiraEra(06,04,2400);
        boolean esperado = true;
        boolean obtido = data.ehBissexto();
        assertEquals(esperado, obtido);
    }
}
