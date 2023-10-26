package net.weg.api.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Usuario{

    private Double salario;
    private Integer matricula;
    private String cargo;

}
