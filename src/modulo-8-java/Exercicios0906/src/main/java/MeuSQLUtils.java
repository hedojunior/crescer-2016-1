
import br.com.hedo.aula3.ConnectionUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Hedo
 */
public class MeuSQLUtils {

    private static final String SELECTCSV = "SELECT * FROM CIDADE";

    public static void main(String[] args) {
        MeuSQLUtils sql = new MeuSQLUtils();
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Digite o nome do arquivo:");
            String filename = teclado.nextLine();
            sql.importCSV(filename);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void readSQLFile(String fileName) {
        if (!fileName.matches("^.*\\.(sql|SQL)$")) {
            System.out.println("O arquivo não é .sql");
        } else {
            try (final Reader reader = new FileReader(fileName)) {
                try (final BufferedReader bfReader = new BufferedReader(reader)) {
                    try (final Connection connection = ConnectionUtils.getConnection()) {
                        try (final Statement st = connection.createStatement()) {
                            while (bfReader.ready()) {
                                st.executeQuery(bfReader.readLine().toUpperCase());
                                System.out.println("Query executada com sucesso.");
                            }
                        } catch (SQLException e) {
                            System.err.println(e.getMessage());
                        }
                    } catch (SQLException e) {
                        System.err.println(e.getMessage());
                    }
                    System.out.println("Importação completada.");
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void importCSV(String csvFileName) {
        if (!csvFileName.matches("^.*\\.(csv|CSV)$")) {
            System.out.println("O arquivo não é .csv");
        } else {
            try (final Reader reader = new FileReader(csvFileName)) {
                try (final BufferedReader bfReader = new BufferedReader(reader)) {
                    String INSERT = "INSERT INTO CIDADE(IDCIDADE,NOME,UF) VALUES(?,?,?)";
                    while (bfReader.ready()) {
                        String[] pedacos = bfReader.readLine().split(";");
                        try (final Connection connection = ConnectionUtils.getConnection()) {
                            try (final PreparedStatement ps = connection.prepareStatement(INSERT)) {
                                ps.setInt(1, Integer.valueOf(pedacos[0]));
                                ps.setString(2, pedacos[1]);
                                ps.setString(3, pedacos[2]);
                                ps.executeUpdate();
                            } catch (Exception e) {
                                System.err.println(e.getMessage());
                            }
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void exportCSV() {
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (Statement st = connection.createStatement()) {
                try (ResultSet rs = st.executeQuery(SELECTCSV)) {
                    String id = String.valueOf(rs.getInt("IDCidade"));
                    String nome = rs.getString("Nome");
                    String uf = rs.getString("UF");
                    String concatenado = id + ";" + nome + ";" + uf + ";";
                    
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
