package net.weg.api.service;

import net.weg.api.model.entity.Seguradora;
import net.weg.api.repository.SeguradoraRepository;

import java.util.Collection;

public class SeguradoraService {
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
