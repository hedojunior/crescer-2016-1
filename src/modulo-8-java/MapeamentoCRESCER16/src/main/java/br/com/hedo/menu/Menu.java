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
        clienteDAO.exportToCSVFile();

        sem.close();
        System.out.println(sem.getEntityManager().isOpen());
    }
}
