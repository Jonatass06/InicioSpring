package net.weg.api.repository;

import jakarta.persistence.IdClass;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroID;
import net.weg.api.model.entity.SeguroIdClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, SeguroID> {
}
