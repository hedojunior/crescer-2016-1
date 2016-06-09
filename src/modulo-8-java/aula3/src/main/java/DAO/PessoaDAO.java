/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import br.com.hedo.aula3.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.IPessoa;
import pojo.Pessoa;

/**
 *
 * @author hedo.junior
 */
public class PessoaDAO implements IPessoa {

    private Connection connection;
    private static final String NOME_TABELA = "PESSOA";
    private static final String COLUNA_ID = "ID_PESSOA";
    private static final String COLUNA_NOME = "NM_PESSOA";

    public PessoaDAO() throws SQLException {
        this.connection = ConnectionUtils.getConnection();
    }
    
    public void closeConnection() throws SQLException{
        this.connection.close();
    }

    public void insert(Pessoa pessoa) {
        String insert = "INSERT INTO "
                + NOME_TABELA
                + " (" + COLUNA_ID + "," + COLUNA_NOME + ") "
                + "VALUES ((SELECT MAX(" + COLUNA_ID + ") + 1 FROM "
                + NOME_TABELA + "),?)";

        try (PreparedStatement preparedStatement
                = this.connection.prepareStatement(insert)) {

            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Pessoa pessoa) {
        String update = "UPDATE TABLE "
                + NOME_TABELA + " SET "
                + COLUNA_NOME + " = ? WHERE "
                + COLUNA_ID + " = ?";

        try (PreparedStatement ps = this.connection.prepareStatement(update)) {
            ps.setString(1, pessoa.getNome());
            ps.setLong(2, pessoa.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Pessoa pessoa) {
        String delete = "DELETE * FROM "
                + NOME_TABELA + " WHERE "
                + COLUNA_ID + " = ?";
        try (PreparedStatement ps = this.connection.prepareStatement(delete)) {
            ps.setLong(1, pessoa.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pessoa> listAll() {
        String select = "SELECT * FROM " + NOME_TABELA;
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        try (Statement s = this.connection.createStatement()) {
            try (ResultSet rs = s.executeQuery(select)) {
                while (rs.next()) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(rs.getLong(COLUNA_ID));
                    pessoa.setNome(rs.getString(COLUNA_NOME));
                    pessoas.add(pessoa);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    public List<Pessoa> findByName(String name) {
        String select = "SELECT * FROM "
                + NOME_TABELA + " WHERE "
                + COLUNA_NOME + " LIKE ?";

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        try (PreparedStatement ps = this.connection.prepareStatement(select)) {
            ps.setString(1, "%"+name+"%");
            try (ResultSet rs = ps.executeQuery(select)) {
                while (rs.next()) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(rs.getLong(COLUNA_ID));
                    pessoa.setNome(rs.getString(COLUNA_NOME));
                    pessoas.add(pessoa);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

}
