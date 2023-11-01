package net.weg.api.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguroCadastroDTO {
    private Double valor;
    private String descricao;
    private Double valorFranquia;
    private Seguradora seguradora;
    private Carro carro;
    private Cliente cliente;
}
