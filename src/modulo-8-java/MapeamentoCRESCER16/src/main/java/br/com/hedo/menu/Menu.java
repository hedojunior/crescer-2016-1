package br.com.hedo.menu;

import br.com.hedo.DAOS.CidadeDAO;
import br.com.hedo.DAOS.ClienteDAO;
import br.com.hedo.DAOS.ICRUD;
import br.com.hedo.DAOS.SimpleEntityManager;
import br.com.hedo.mapeamentocrescer16.Cidade;
import br.com.hedo.mapeamentocrescer16.Cliente;

/**
 *
 * @author Hedo
 */
public class Menu {

    public static void main(String[] args) {
        SimpleEntityManager sem = SimpleEntityManager.getInstance();
        ICRUD<Long, Cliente> clienteDAO = new ClienteDAO(sem.getEntityManager());
        ICRUD<Long, Cidade> cidadeDAO = new CidadeDAO(sem.getEntityManager());

        Cidade cid1 = new Cidade("Parobé", "RS");
        Cidade cid2 = new Cidade("Porto Alegre", "RS");
        Cidade cid3 = new Cidade("Sapucaia do Sul", "RS");
        
        sem.beginTransaction();
        
        cidadeDAO.create(cid1);
        cidadeDAO.create(cid2);
        cidadeDAO.create(cid3);
        
        sem.commit();
        
        Cliente c1 = new Cliente("André Nunes", "andre.nunes", "Buenas", "saneuB", cid1 ,93040460,"A");
        Cliente c2 = new Cliente("Bernardo Bosak de Rezende", "bernardobrezende", "Bosak", "Bosak",cid2,93025250,"A");
        Cliente c3 = new Cliente("Ben-Hur Ott", "benhurott", "Eai", "Eai",cid3,65054350,"A");
        
        sem.beginTransaction();

        clienteDAO.create(c1);
        clienteDAO.create(c2);
        clienteDAO.create(c3);

        sem.commit();
        
        sem.close();
        System.out.println(sem.getEntityManager().isOpen());
    }
}
