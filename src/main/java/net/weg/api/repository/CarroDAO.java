package net.weg.api.repository;

import net.weg.api.exception.InvalidIndex;
import net.weg.api.model.Carro;

import java.sql.*;

public class CarroDAO extends DAOPadrao<Carro, Integer> {

    public CarroDAO(){
        super("carro");
    }
    @Override
    public void inserir(Carro carro) throws InvalidIndex {
        super.setComandoSql("INSERT INTO carro VALUES (?,?,?,?,?,?);");
        try (PreparedStatement s = super.getConnection().prepareStatement(super.getComandoSql())) {
            if (carro.getId() == 0) {
                throw new InvalidIndex();
            }
            s.setInt(1, carro.getId());
            s.setString(2, carro.getMarca());
            s.setString(3, carro.getModelo());
            s.setString(4, carro.getCor());
            s.setDouble(5, carro.getPreco());
            s.setInt(6, carro.getAno());
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void atualizar(Carro carro) {
        super.setComandoSql("Update carro set marca = ?, modelo = ?, cor = ?, preco = ?, ano = ? where id = ?");
        try (PreparedStatement s = super.getConnection().prepareStatement(super.getComandoSql())){
            s.setString(1, carro.getMarca());
            s.setString(2, carro.getModelo());
            s.setString(3, carro.getCor());
            s.setDouble(4, carro.getPreco());
            s.setInt(5, carro.getAno());
            s.setInt(6, carro.getId());
            s.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Carro converter(ResultSet resultSet) throws SQLException{
        return new Carro(resultSet);
    }

}
