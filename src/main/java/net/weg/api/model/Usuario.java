package net.weg.api.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="nome") // Mais Configs
    private String nome;
    private String senha;
    private Integer idade;
    //A primeira é da classe modeladora(Usuario) e a segunda a classe relacionada (Carro)
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Carro> carro;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Endereco> endereco;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @ManyToOne
    private Consorcio consorcio;
}
