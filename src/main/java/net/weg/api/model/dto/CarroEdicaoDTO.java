package net.weg.api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarroEdicaoDTO {

    private Integer id;
    private String placa;
    private String marca,cor,modelo;
    private Double preco;
    private Integer ano;
    private Double motor;

}
