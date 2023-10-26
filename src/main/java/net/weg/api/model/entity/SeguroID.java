package net.weg.api.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SeguroID {
    private Integer seguroId;
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer seguradoraId;

}
