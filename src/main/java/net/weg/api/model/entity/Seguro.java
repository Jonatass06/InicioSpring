package net.weg.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"seguradora", "carro", "cliente"})
@AllArgsConstructor
//@IdClass(SeguroIdClass.class)
public class Seguro {
    @EmbeddedId
    private SeguroID id = new SeguroID();
//    @Id
//    private Long seguroId;
//    @Id
//    private Integer seguradoraId;

    private Double valor;
    private String descricao;
    private Double valorFranquia;
    @ManyToOne
    @MapsId("seguradoraId")
//    @JoinColumn(name = "seguradoraId")
    private Seguradora seguradora;
    @OneToOne(fetch = FetchType.EAGER)
    private Carro carro;
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

}
