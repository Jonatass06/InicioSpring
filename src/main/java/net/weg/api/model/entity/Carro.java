package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.weg.api.model.DTO.CarroCadastroDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "tb_Clube")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    @Column(name = "nome",length = 350)
    private Integer id;
    private String placa;
    private String marca,cor,modelo;
    private Double preco;
    private Integer ano;
    @OneToOne(mappedBy = "veiculo")
    @EqualsAndHashCode.Exclude
    private Seguro seguro;

    @Override
    public String toString(){
        return marca + " - " + modelo + " ("+placa+") ";
    }

//    public Carro(CarroCadastroDTO carroDTO) {
//        this.ano = carroDTO.getAno();
//        this.marca = carroDTO.getMarca();
//        this.cor = carroDTO.getCor();
//        this.preco = carroDTO.getPreco();
//        this.modelo = carroDTO.getModelo();
//
//    }
}
