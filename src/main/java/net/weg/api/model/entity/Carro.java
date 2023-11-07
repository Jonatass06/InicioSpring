package net.weg.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToOne(mappedBy = "carro", fetch = FetchType.EAGER)
    private Seguro seguro;

    @Override
    public String toString() {
        return this.marca + " - " + this.modelo + " (" + this.placa+")";
    }

}
