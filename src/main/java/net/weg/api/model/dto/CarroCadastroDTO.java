package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroCadastroDTO {
    private String marca;
    private String cor;
    private String placa;
    private String modelo;
    private Double preco;
    private Integer ano;
}
