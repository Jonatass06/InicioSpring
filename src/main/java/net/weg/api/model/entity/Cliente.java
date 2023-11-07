package net.weg.api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario{
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Carro> carro;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Habilitacao habilitacao;
    @OneToMany(mappedBy="cliente", fetch = FetchType.EAGER)
    private Set<Seguro> seguros;

    @Override
    public String toString() {
        return super.toString();
    }
}
