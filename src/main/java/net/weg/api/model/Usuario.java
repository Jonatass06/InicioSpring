package net.weg.api.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private Integer id;
    private String nome;
    private String senha;
    private Integer idade;
    private Carro carro;

    public Usuario(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.idade = resultSet.getInt("idade");
        this.nome = resultSet.getString("nome");
        this.senha = resultSet.getString("senha");
        int idCarro = resultSet.getInt("carro");
        if (idCarro != 0) {
            this.carro = new Carro(idCarro);
        }
    }
}
