package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "tb_seguradora")
@AllArgsConstructor
@NoArgsConstructor
public class Seguradora {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long cnpj;
    private String nome;
    @OneToOne
    private Endereco endereco;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Cliente> clientes;


}
