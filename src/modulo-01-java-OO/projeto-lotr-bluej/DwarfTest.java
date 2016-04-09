

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
   @Test
   public void criarDwarf110vida(){
       //Arrange
       int vida_esperada = 110;
       //Act
       Dwarf dwarf = new Dwarf("Dwarf");
       //Assert 
       assertEquals(vida_esperada, dwarf.getVida());  
   }
   
   @Test
   public void criarDwarf120vida(){
       //Arrange
       int vida_esperada = 120;
        //Act
       Dwarf dwarf = new Dwarf("Dori");
       //Assert 
       assertFalse(vida_esperada == dwarf.getVida());  
   }
   
   @Test
   public void dwarfToma10Dano(){
       //Arrange
       Dwarf dwarf = new Dwarf("Thráin");
       int vida_esperada = dwarf.getVida() - 10;
       //Act
       dwarf.danoRecebido();
       //Assert
       assertEquals(vida_esperada,dwarf.getVida());
   }
   
   @Test
   public void dwarfToma110Dano(){
       //Arrange
       Dwarf dwarf = new Dwarf("Kíli");
       int vida_esperada = dwarf.getVida() - 110;
       // Act
       for(int i = 0; i < 11; i++) {
           dwarf.danoRecebido();
       }
       // Assert
       assertEquals(vida_esperada,dwarf.getVida());
   }
      
   @Test
   public void estaMortoCom110Dano(){
       //Arrange
       Dwarf dwarf = new Dwarf("Farin");
       //Act
       for (int i = 0; i < 11; i++) {
           dwarf.danoRecebido();
       }
       //Assert
       assertEquals(0, dwarf.getVida());
       assertEquals(Status.MORTO, dwarf.getStatus());
   }
   
   @Test
   public void estaMortoCom120Dano(){
       //Arrange
       Dwarf dwarf = new Dwarf("Dwalin");
       //Act
       for (int i = 0; i < 120; i++) {
           dwarf.danoRecebido();
       }
       //Assert
       assertEquals(0, dwarf.getVida());
       assertEquals(Status.MORTO, dwarf.getStatus());
   }
   
   @Test
   public void adicionaItemInventario() {
       //Arrange
       Dwarf dwarf = new Dwarf("Glóin");
       Item i = new Item(13,"Hidromel");
       //Act
       dwarf.adicionarItem(i);
       //Assert
       assertTrue(dwarf.getInventario().getItens().contains(i));
   }
   
   @Test
   public void adiciona4ItensNoInventario() {
       //Arrange
       boolean obtido;
       Dwarf dwarf = new Dwarf("Frerin");
       Item i1 = new Item(1,"Pernil");
       Item i2 = new Item(1,"Caneco");
       Item i3 = new Item(1,"Malha de Mithril");
       Item i4 = new Item(1,"Casco de Hidromel");
       //Act
       dwarf.adicionarItem(i1);
       dwarf.adicionarItem(i2);
       dwarf.adicionarItem(i3);
       dwarf.adicionarItem(i4);
       obtido = dwarf.getInventario().getItens().contains(i1) == 
       dwarf.getInventario().getItens().contains(i2) ==
       dwarf.getInventario().getItens().contains(i3) ==
       dwarf.getInventario().getItens().contains(i4);
       //Assert
       assertTrue(obtido);
   }
      
   @Test
   public void perde4ItensInventario() {
       //Arrange
       boolean obtido;
       Dwarf dwarf = new Dwarf("Fundin");
       Item i1 = new Item(1,"Cesto de Lembas");
       Item i2 = new Item(1,"Tostão furado");
       Item i3 = new Item(1,"Pele de Javali");
       Item i4 = new Item(1,"Casco de Hidromel");
       //Act
       dwarf.adicionarItem(i1);
       dwarf.adicionarItem(i2);
       dwarf.adicionarItem(i3);
       dwarf.adicionarItem(i4);
       dwarf.perderItem(i1);
       dwarf.perderItem(i2);
       dwarf.perderItem(i3);
       dwarf.perderItem(i4);
       obtido = dwarf.getInventario().getItens().contains(i1) == 
       dwarf.getInventario().getItens().contains(i2) ==
       dwarf.getInventario().getItens().contains(i3) ==
       dwarf.getInventario().getItens().contains(i4);
       //Assert
       assertTrue(obtido);
   }
   
   @Test
   public void perdeItemInventario() {
       //Arrange
       boolean obtido;
       Dwarf dwarf = new Dwarf("Telchar");
       Item i = new Item(1,"Silmarillion");
       //Act
       dwarf.adicionarItem(i);
       dwarf.perderItem(i);
       //Assert
       assertFalse(dwarf.getInventario().getItens().contains(i));
   }
   
   @Test
   public void compararDataNascimento() {
       //Arrange
       DataTerceiraEra dataNascimento = new DataTerceiraEra(07,04,2016);
       Dwarf dwarf = new Dwarf("Balin", dataNascimento);
       //Act
       //Assert
       assertTrue(dataNascimento.getDia() == dwarf.getDataNascimento().getDia());
       assertTrue(dataNascimento.getMes() == dwarf.getDataNascimento().getMes());
       assertTrue(dataNascimento.getAno() == dwarf.getDataNascimento().getAno());
    }
   
   @Test
   public void numeroSorteSeixasAnoNãoBissexto(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(07,04,2015);
       Dwarf dwarf = new Dwarf("Seixas",data);
       //Act
       //Assert
       assertEquals((101.0 * 33) % 100,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteMeirelesAnoBissexto(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(07,04,2016);
       Dwarf dwarf = new Dwarf("Meireles",data);
       //Act
       //Assert
       assertEquals(101.0,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteSeixasAnoBissexto(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(07,04,2016);
       Dwarf dwarf = new Dwarf("Seixas",data);
       //Act
       //Assert
       assertEquals(101.0,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteMeirelesAnoNaoBissexto(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(07,04,2015);
       Dwarf dwarf = new Dwarf("Meireles",data);
       //Act
       //Assert
       assertEquals((101.0 * 33) % 100,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void numeroSorteDwarfQualquerNomeDataBissextoVida90(){
       //Arrange
       DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
       Dwarf dwarf = new Dwarf("Ibûn",data);
       //Act
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       //Assert
       assertEquals(101.0 * -33,dwarf.getNumeroSorte(),0);
   }
   
   @Test
   public void vidaEExperienciaIguaisAposDanoMeireles() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2015);
       Dwarf d1 = new Dwarf("Meireles",data);
       int vida_esperada = d1.getVida();
       int xp_esperada = d1.getExperiencia();
       //Act
       d1.danoRecebido();
       //Assert
       assertEquals(vida_esperada, d1.getVida());
       assertEquals(xp_esperada, d1.getExperiencia());
   }
   
   @Test
   public void vidaEExperienciaIguaisAposDanoMeirelesNewString() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2015);
       Dwarf d1 = new Dwarf(new String("Meireles"),data);
       int vida_esperada = d1.getVida() - 10;
       int xp_esperada = d1.getExperiencia();
       String nome_esperado = "Meireles";
       boolean teste_nome = d1.getNome().equals(nome_esperado);
       //Act
       d1.danoRecebido();
       //Assert
       assertEquals(vida_esperada, d1.getVida());
       assertEquals(xp_esperada, d1.getExperiencia());
       assertTrue(teste_nome);
   }
      
   @Test
   public void vidaEExperienciaAposDanoDataBissextoDwarf90Vida() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
       Dwarf d1 = new Dwarf("Azaghâl",data);
       int vida_esperada = d1.getVida() - 20;
       int xp_esperada = d1.getExperiencia() + 2;
       //Act
       d1.danoRecebido();
       d1.danoRecebido();
       d1.danoRecebido();
       //Assert
       assertEquals(vida_esperada, d1.getVida());
       assertEquals(xp_esperada, d1.getExperiencia());
   }
   
   @Test
   public void Experiencia8AposDanoDataBissextoDwarf90Vida() {
       DataTerceiraEra data = new DataTerceiraEra(01,01,2016);
       Dwarf d1 = new Dwarf("Fundin",data);
       int vida_esperada = d1.getVida() - 20;
       int xp_esperada = d1.getExperiencia() + 8;
       //Act
       for (int i = 0; i <6; i++) {
           d1.danoRecebido();
       }
       //Assert
       assertEquals(vida_esperada, d1.getVida());
       assertEquals(xp_esperada, d1.getExperiencia());
   }
   
   @Test
   public void dwarfTentaSorteComUmItemEDataSendoBissextoEVidaSendo90() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       Dwarf dwarf = new Dwarf("Thrór", data);
       Item item = new Item(1,"Silmarillion");
       dwarf.adicionarItem(item);
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.tentarSorte();
       assertEquals(1001, dwarf.getInventario().getItens().get(0).getQuantidade());
   }
   
   @Test
   public void dwarfTentaSorteComDoisItensEDataSendoBissextoEVidaSendo90() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       Dwarf dwarf = new Dwarf("Ori", data);
       Item item = new Item(2,"Lembas");
       Item item2 = new Item(1,"Casco de Hidromel");
       dwarf.adicionarItem(item);
       dwarf.adicionarItem(item2);
       dwarf.danoRecebido();
       dwarf.danoRecebido();
       dwarf.tentarSorte();
       assertEquals(1002, dwarf.getInventario().getItens().get(0).getQuantidade());
       assertEquals(1001, dwarf.getInventario().getItens().get(1).getQuantidade());
   }
   
   @Test
   public void dwarfTentaSorteComDoisItensEDataNaoSendoBissextoENomeSendoSeixas() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2015);
       Dwarf dwarf = new Dwarf("Seixas", data);
       Item item = new Item(1,"Casco meio-cheio de Hidromel");
       Item item2 = new Item(1,"Caneco sujo");
       dwarf.adicionarItem(item);
       dwarf.adicionarItem(item2);
       dwarf.tentarSorte();
       assertEquals(1, dwarf.getInventario().getItens().get(0).getQuantidade());
       assertEquals(1, dwarf.getInventario().getItens().get(1).getQuantidade());
   }
   
   @Test
   public void dwarfTentaSorteComDoisItensEDataSendoBissextoEVidaSendo110() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       Dwarf dwarf = new Dwarf("Flói", data);
       Item item = new Item(1,"Caneco lustroso");
       Item item2 = new Item(1,"Cera de polimento");
       dwarf.adicionarItem(item);
       dwarf.adicionarItem(item2);
       dwarf.tentarSorte();
       assertEquals(1, dwarf.getInventario().getItens().get(0).getQuantidade());
       assertEquals(1, dwarf.getInventario().getItens().get(1).getQuantidade());
   }
}
