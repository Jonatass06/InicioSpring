package net.weg.api.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.entity.Endereco;

import java.util.Set;

@AllArgsConstructor
@Data
public class UsuarioCadastroDTO {
    private String usuario;
    private String nome;
    private String sobrenome;
    private String senha;
    private Integer idade;
    private Set<Endereco> enderecos;

}

