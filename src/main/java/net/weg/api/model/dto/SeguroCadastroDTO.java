package net.weg.api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;

@AllArgsConstructor
@Data
public class SeguroCadastroDTO implements  IDTO{
    private Double valor;
    private String descricao;
    private Double valorFranquia;
    private Seguradora seguradora;
    private Carro veiculo;
    private Cliente cliente;
}
