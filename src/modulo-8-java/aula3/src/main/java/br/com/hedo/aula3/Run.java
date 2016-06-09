/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author hedo.junior
 */
public class Run {
    
    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());
    
    public static void main(String[] args) {
        String INSERT = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) "
                + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
        
        try (Connection connection = ConnectionUtils.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            
            preparedStatement.setString(1, "HELDON");
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }
    
}
