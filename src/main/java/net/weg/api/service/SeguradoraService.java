package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.dto.SeguradoraCadastroDTO;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.repository.SeguradoraRepository;
import net.weg.api.view.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeguradoraService implements IService<Seguradora,Integer> {
    private SeguradoraRepository seguradoraRepository;

    public void cadastrar(IDTO idto){
        SeguradoraCadastroDTO seguradoraCadastroDTO = (SeguradoraCadastroDTO) idto;
        Seguradora seguradora = new Seguradora();
        BeanUtils.copyProperties(seguradoraCadastroDTO, seguradora);
        seguradoraRepository.save(seguradora);
    }

    public void editar(IDTO idto){
        SeguradoraCadastroDTO seguradoraCadastroDTO = (SeguradoraCadastroDTO) idto;
        Seguradora seguradora = new Seguradora();
        BeanUtils.copyProperties(seguradoraCadastroDTO, seguradora);
        seguradoraRepository.save(seguradora);
    }

    public void deletar(Integer id){
        seguradoraRepository.deleteById(id);
    }

    public void buscarUm(Integer id){
         seguradoraRepository.findById(id).get();
    }

    public List<Seguradora> buscarTodos(){
        return seguradoraRepository.findAll();
    }

}
