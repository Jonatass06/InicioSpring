package net.weg.api.repository;

import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer> {

    List<Carro> findByMarca(String marca);
    List<Carro> findBySeguro_SeguradoraId(Integer seguroId);
    boolean existsByPlaca(String placa);

}
