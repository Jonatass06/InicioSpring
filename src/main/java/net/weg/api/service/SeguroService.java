package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.repository.SeguroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguroService {

    private SeguroRepository seguroRepository;

    public void salvar(SeguroCadastroDTO seguroCadastroDTO) {
        Seguro seguro = new Seguro();
        BeanUtils.copyProperties(seguroCadastroDTO,seguro);
        seguroRepository.save(seguro);
    }

    public void deletar(Integer idSeguro,Integer idSeguradora){
        seguroRepository.deleteById(new SeguroId(idSeguro,idSeguradora));
    }

    public Seguro buscarId(Integer idSeguro,Integer idSeguradora){
        return seguroRepository.findById(new SeguroId(idSeguro,idSeguradora)).get();
    }

    public List<Seguro> buscarTodos(){
        return seguroRepository.findAll();
    }
}
