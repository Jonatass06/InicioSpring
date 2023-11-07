package net.weg.api.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class SeguroID {
    protected Integer seguroId;
    protected Integer seguradoraId;
    private static Integer nextId = 1;

    protected SeguroID() {
        this.seguroId = nextId;
        nextId++;
    }

}
