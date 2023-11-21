package net.weg.api.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeguroIdClass implements Serializable {

    private Integer seguradoraId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seguroId;

}
