package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_funcionario")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Funcionario extends Usuario{
    private Double salario;
    private Integer matricula;
    private String cargo;

}
