package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroCadastroDTO implements  IDTO{

    private String placa;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;

}
