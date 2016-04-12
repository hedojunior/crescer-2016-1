

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest {
   @Test
   public void IrishDwarfTentaSorteComUmItemEDataSendoBissextoEVidaSendo90() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       IrishDwarf leprechaun = new IrishDwarf("Kieran McDermott", data);
       Item item = new Item(4,"250 Anniversary Stout");
       leprechaun.adicionarItem(item);
       leprechaun.danoRecebido();
       leprechaun.danoRecebido();
       leprechaun.tentarSorte();
       assertEquals(10004, leprechaun.getInventario().getItens().get(0).getQuantidade());
   }
   
   @Test
   public void IrishDwarfTentaSorteComDoisItensEDataSendoBissextoEVidaSendo90() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       IrishDwarf leprechaun = new IrishDwarf("Dinny Moloney", data);
       Item item = new Item(3,"Brew 39");
       Item item2 = new Item(2,"Toucan Brew");
       leprechaun.adicionarItem(item);
       leprechaun.adicionarItem(item2);
       leprechaun.danoRecebido();
       leprechaun.danoRecebido();
       leprechaun.tentarSorte();
       assertEquals(6003, leprechaun.getInventario().getItens().get(0).getQuantidade());
       assertEquals(3002, leprechaun.getInventario().getItens().get(1).getQuantidade());
   }
   
   @Test
   public void IrishDwarfTentaSorteComDoisItensEDataNaoSendoBissextoENomeSendoSeixas() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2015);
       IrishDwarf leprechaun = new IrishDwarf("Seixas", data);
       Item item = new Item(1,"North Star");
       Item item2 = new Item(2,"Guinness's Brite Lager");
       leprechaun.adicionarItem(item);
       leprechaun.adicionarItem(item2);
       leprechaun.tentarSorte();
       assertEquals(1, leprechaun.getInventario().getItens().get(0).getQuantidade());
       assertEquals(2, leprechaun.getInventario().getItens().get(1).getQuantidade());
   }
   
   @Test
   public void IrishDwarfTentaSorteComDoisItensEDataSendoBissextoEVidaSendo110() {
       DataTerceiraEra data = new DataTerceiraEra(1,1,2016);
       IrishDwarf leprechaun = new IrishDwarf("Teague Malone", data);
       Item item = new Item(1,"Guinness's Brite Ale");
       Item item2 = new Item(1,"Guinness Light");
       leprechaun.adicionarItem(item);
       leprechaun.adicionarItem(item2);
       leprechaun.tentarSorte();
       assertEquals(1, leprechaun.getInventario().getItens().get(0).getQuantidade());
       assertEquals(1, leprechaun.getInventario().getItens().get(1).getQuantidade());
   }
}
