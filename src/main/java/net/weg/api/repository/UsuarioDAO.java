package net.weg.api.repository;

import net.weg.api.exception.InvalidIndex;
import net.weg.api.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends DAOPadrao<Usuario, Integer>{

    public UsuarioDAO() throws SQLException {
        super("usuarios");
    }
    @Override
    public void inserir(Usuario usuario) throws InvalidIndex {
        super.setComandoSql("INSERT INTO usuarios VALUES (?,?,?,?,?);");
        try (PreparedStatement s = super.getConnection().prepareStatement(super.getComandoSql())){
            s.setInt(1, usuario.getId());
            s.setString(2, usuario.getNome());
            s.setString(3, usuario.getSenha());
            s.setInt(4, usuario.getIdade());
            try {
                s.setInt(5, usuario.getCarro().getId());
            } catch (NullPointerException e) {
                s.setNull(5, 0);
            }
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario converter(ResultSet resultSet) throws SQLException{
        return new Usuario(resultSet);
    }

    @Override
    public void atualizar(Usuario usuario) {
        super.setComandoSql("Update usuarios set nome = ?, senha = ?, idade = ?, carro = ? where idusuarios = ?");
        try (PreparedStatement s = super.getConnection().prepareStatement(super.getComandoSql())){
            s.setString(1, usuario.getNome());
            s.setString(2, usuario.getSenha());
            s.setInt(3, usuario.getIdade());
            s.setInt(5, usuario.getId());
            try {
                s.setInt(4, usuario.getCarro().getId());
            } catch (NullPointerException e) {
                s.setNull(4, 0);
            }
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
