package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")

public class Cliente extends Usuario {
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Carro> carro;
    //    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    private Habilitacao habilitacao;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER)
    private Set<Seguro> seguros;

    @Override
    public String toString() {
      return super.toString();
    }
}
