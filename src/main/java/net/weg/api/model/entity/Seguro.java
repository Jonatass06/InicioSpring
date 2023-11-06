package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SeguroIdClass.class)
public class Seguro {
//    @EmbeddedId
//    private SeguroID id;
    @Id
    private Long seguroId;
    @Id
    private Integer seguradoraId;

    private Double valor;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
//    @MapsId("seguradoraId")
    @JoinColumn(name = "seguradoraId")
    private Seguradora seguradora;
    @OneToOne
//    @MapsId("veiculoId")
    private Carro carro;
    @ManyToOne
    private Cliente cliente;

}
