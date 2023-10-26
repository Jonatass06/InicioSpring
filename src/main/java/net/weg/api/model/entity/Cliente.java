package net.weg.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario{
    @OneToMany
    private Set<Carro> carro;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @OneToMany(mappedBy="cliente")
    private Set<Seguro> seguros;
}
