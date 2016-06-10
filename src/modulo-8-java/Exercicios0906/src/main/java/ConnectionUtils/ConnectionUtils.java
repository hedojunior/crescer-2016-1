/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hedo.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hedo.junior
 */
public class ConnectionUtils {

    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "CRESCER16";
    private static final String pass = "CRESCER16";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
