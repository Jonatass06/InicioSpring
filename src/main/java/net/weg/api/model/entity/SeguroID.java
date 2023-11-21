package net.weg.api.model.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.api.repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Embeddable
@Component
public class SeguroId {

    @Autowired
    SeguroRepository seguroRepository;
    private Integer seguroId;
    private Integer seguradoraId;


    public SeguroId() {
        seguroId = Math.toIntExact(seguroRepository.count() + 1);
    }

    public SeguroId(Integer seguroId, Integer seguradoraId){
        this.seguroId = seguroId;
        this.seguradoraId = seguradoraId;
    }

}
