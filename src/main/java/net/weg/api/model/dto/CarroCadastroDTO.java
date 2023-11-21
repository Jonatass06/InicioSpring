package net.weg.api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarroCadastroDTO {

    private String placa;
    private String marca,cor,modelo;
    private Double preco;
    private Integer ano;

}
