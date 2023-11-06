package net.weg.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Seguradora {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Long cnpj;
    private String nome;
    @OneToOne
    private Endereco endereco;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Cliente> clientes;

    @Override
    public String toString() {
        return this.nome;
    }


}
