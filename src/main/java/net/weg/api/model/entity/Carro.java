package net.weg.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String placa;
    private String marca;
    private String cor;
    private String modelo;
    private Double preco;
    private Integer ano;
    @OneToOne(mappedBy = "veiculo")
    @JsonIgnore
    private Seguro seguro;

    public Carro(CarroCadastroDTO carroCadastroDTO) {
        this.ano = carroCadastroDTO.getAno();
        this.marca = carroCadastroDTO.getMarca();
        this.cor = carroCadastroDTO.getCor();
        this.modelo = carroCadastroDTO.getModelo();
        this.preco = carroCadastroDTO.getPreco();
    }

    @Override
    public String toString(){
        return marca + " - " + modelo + " ("+ placa +")";
    }
}
