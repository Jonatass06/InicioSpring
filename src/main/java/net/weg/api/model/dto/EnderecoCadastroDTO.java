package net.weg.api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EnderecoCadastroDTO {

    private String rua,bairro;
    private Integer numero;

}
