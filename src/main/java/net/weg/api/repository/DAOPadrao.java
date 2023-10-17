package net.weg.api.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class DAOPadrao<T, ID> implements ICRUD<T, ID> {

    private Connection connection;
    private String comandoSql;
    private String tabela;

    public DAOPadrao(String tabela) {
        this.connection = Banco.conectar();
        this.tabela = tabela;
    }

    public Connection getConnection() {
        return connection;
    }

    public String getComandoSql() {
        return comandoSql;
    }

    public void setComandoSql(String comandoSql) {
        this.comandoSql = comandoSql;
    }

    @Override
    public Set<T> buscarTodos() {
        this.comandoSql = "Select * from " + tabela;
        Set<T> set = new HashSet<>();
        try (PreparedStatement s = connection.prepareStatement(this.comandoSql)) {
            ResultSet results = s.executeQuery();
            while (results.next()) {
                set.add(converter(results));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return set;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    public void deletar(Integer id) {
        this.comandoSql = "Delete from " + tabela + " where id = ?";
        try (PreparedStatement s = this.connection.prepareStatement(this.comandoSql)) {
            s.setInt(1, id);
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T buscarUm(Integer id) {
        comandoSql = "Select * from " + tabela + " where id = ?;";
        try (PreparedStatement s = this.connection.prepareStatement(this.comandoSql)) {
            s.setInt(1, id);
            ResultSet results = s.executeQuery();
            if (results.next()) {
                return converter(results);
            }
            throw new NoSuchElementException();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public abstract T converter(ResultSet resultSet) throws SQLException;
}
