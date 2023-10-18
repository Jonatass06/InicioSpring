package net.weg.api.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@NoArgsConstructor
public class Carro {
    private Integer id;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;

    public Carro(Integer id){
        this.id = id;
    }

    public Carro(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.marca = resultSet.getString("marca");
        this.modelo = resultSet.getString("modelo");
        this.cor = resultSet.getString("cor");
        this.ano = resultSet.getInt("ano");
        this.preco = resultSet.getDouble("preco");
    }
}
