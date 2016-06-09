package br.com.hedo.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hedo.junior
 */
public class SelectRun {

    public static void main(String[] args) {
        final String query = " SELECT * FROM PESSOA";

        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet rs = statement.executeQuery(query)) {
                    while (rs.next()) {
                        System.out.println(rs.getString("NM_PESSOA"));
                    }
                } catch (SQLException e) {
                    System.err.format("SQLException %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

}
