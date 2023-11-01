package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.entity.Endereco;

import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
public class UsuarioCadastroDTO {
        private String nome;
        private String senha;
        private Integer idade;
        private Collection<Endereco> enderecos;

}
