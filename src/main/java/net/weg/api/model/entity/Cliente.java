package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente extends Usuario {
//    @Id @GeneratedValue(strategy = GenerationType.TABLE) private int id;
//    @Column(name = "nome",length = 350)

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<Carro> carro;
//    @OneToOne(cascade = CascadeType.PERSIST)
//    private Habilitacao habilitacao;
    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Seguro> seguros;

    @Override
    public String toString() {
        return super.toString();
    }

    //    public Jogador() {
//    }

//    @Override
//    public String toString() {
//        return "Jogador{" +
//                "id=" + id +
//                ", nome='" + nome + '\'' +
//                ", golsMarcados=" + golsMarcados +
//                ", clubeFutebol=" + clubeFutebol +
//                '}';
//    }
}












