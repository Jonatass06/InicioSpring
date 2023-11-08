package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroID;
import net.weg.api.model.entity.SeguroIdClass;
import net.weg.api.repository.SeguroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor

public class SeguroService {
    private SeguroRepository seguroRepository;

    public void salvar(SeguroCadastroDTO seguroCadastroDTO) throws Exception{
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO, seguro);
        Integer seguroId = Math.toIntExact(seguroRepository.count());
        seguro.getId().setSeguroId(seguroId);
        this.seguroRepository.save(seguro);
    }
    public void editar(Seguro seguro){
        seguroRepository.save(seguro);
    }

    public Seguro buscarUm(Integer id, Integer seguradoraId){
        return seguroRepository.findById(new SeguroID(id, seguradoraId)).get();
    }

    public Collection<Seguro> buscarTodos() {
        return seguroRepository.findAll();
    }

    public void deletar(Integer id, Integer seguradoraId) {
        seguroRepository.deleteById(new SeguroID(id, seguradoraId));
    }
}
