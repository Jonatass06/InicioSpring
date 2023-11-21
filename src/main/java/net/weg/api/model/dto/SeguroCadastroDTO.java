package net.weg.api.model.DTO;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Seguradora;

@Data
@AllArgsConstructor
public class SeguroCadastroDTO {

    private Double valor;
    private String descricao;
    private Double valorFranquia;
    private Seguradora seguradora;
    private Carro veiculo;
    private Cliente cliente;

}
