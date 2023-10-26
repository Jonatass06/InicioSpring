package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarroEdicaoDTO {

    private Integer id;
    private String marca;
    private String placa;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;
    private Integer clienteId;
}
