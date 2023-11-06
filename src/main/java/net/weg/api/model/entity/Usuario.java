package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private String usuario;
    private String nome;
    private String sobrenome;
    private String senha;
    private Integer idade;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Collection<Endereco> enderecos;

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome;
    }
}
