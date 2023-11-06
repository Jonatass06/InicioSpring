package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.entity.Endereco;

import java.util.Collection;

@Data
@AllArgsConstructor
public class UsuarioCadastroDTO {
        private String usuario;
        private String nome;
        private String sobrenome;
        private String senha;
        private Integer idade;
        private Collection<Endereco> enderecos;

}
