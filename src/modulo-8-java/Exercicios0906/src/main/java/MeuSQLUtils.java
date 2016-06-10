
import br.com.hedo.aula3.ConnectionUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hedo
 */
public class MeuSQLUtils {

    private static final String SELECTCSV = "SELECT * FROM CIDADE";

    public static void main(String[] args) {
//        MeuSQLUtils sql = new MeuSQLUtils();
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("Digite qualquer tecla para iniciar a exportação:");
            String tecla = teclado.nextLine();
            if(!tecla.toLowerCase().matches("^select\\s.*$"))
                System.out.println("Não é select");
            else
                System.out.println("É select");
//            System.out.println("Aguarde, exportando o arquivo para CSV...");
//            sql.exportCSV();
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

    public void readSQLCommand(String SQLCommand){
        boolean ehSelect = false;
        if(SQLCommand.toLowerCase().matches("^select\\s.*$"))
            ehSelect = true;
        else {
            
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
                    ArrayList<String> linhas = new ArrayList<String>();
                    while (rs.next()) {
                        String id = String.valueOf(rs.getInt("IDCidade"));
                        String nome = rs.getString("Nome");
                        String uf = rs.getString("UF");
                        String concatenado = id + ";" + nome + ";" + uf + ";";
                        linhas.add(concatenado);
                    }
                    File csv = new File("export.csv");
                    try (final Writer writer = new FileWriter(csv)) {
                        try (final BufferedWriter bfWriter = new BufferedWriter(writer)) {
                            for(int i = 0; i < linhas.size(); i++){
                                bfWriter.write(linhas.get(i));
                                bfWriter.flush();
                                bfWriter.newLine();
                            }
                            System.out.println("Arquivo exportado com sucesso.");
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
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
