package net.weg.api.model.dto;

import jakarta.persistence.OneToOne;
import net.weg.api.model.entity.Endereco;

public class SeguradoraCadastroDTO implements IDTO{

    private Long cnpj;
    private String nome;
    private Endereco endereco;
}
