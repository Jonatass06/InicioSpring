package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.repository.SeguradoraRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class SeguradoraService{
    private SeguradoraRepository seguradoraRepository;

    public void salvar(Seguradora seguradora){
        seguradoraRepository.save(seguradora);
    }

    public Seguradora buscarUm(Integer id){
        return seguradoraRepository.findById(id).get();
    }

    public Collection<Seguradora> buscarTodos() {
        return seguradoraRepository.findAll();
    }

    public void deletar(Integer id) {
        seguradoraRepository.deleteById(id);
    }
}
