package net.weg.api.model.entity;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.*;
import net.weg.api.model.dto.CarroCadastroDTO;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String marca;
    private String placa;

    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;
    @OneToOne(mappedBy = "carro")
    private Seguro seguro;

}
