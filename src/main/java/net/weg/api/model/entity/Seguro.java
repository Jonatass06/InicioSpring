package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tb_seguro")
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(SeguroIdClass.class)
public class Seguro {
    @EmbeddedId
    private SeguroId idComposto = new SeguroId();
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Integer seguroId;
// @Id
// private Integer seguradoraId;
    private Double valor;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
    @MapsId("seguradoraId")
//    @JoinColumn(name = "seguradoraId")
    private Seguradora seguradora;
    @OneToOne
    @EqualsAndHashCode.Exclude
//    @MapsId("veiculoId")
    private Carro veiculo;
    @ManyToOne
    private Cliente cliente;

}
