package net.weg.api.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguroIdClass implements Serializable {

    private Integer seguradoraId;
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long seguroId;

}
