package net.weg.api.service;

import net.weg.api.model.entity.Seguro;
import net.weg.api.repository.SeguroRepository;

import java.util.Collection;

public class SeguroService {
    private SeguroRepository seguroRepository;

    public void salvar(Seguro Seguro){
        seguroRepository.save(Seguro);
    }

    public Seguro buscarUm(Integer id){
        return seguroRepository.findById(id).get();
    }

    public Collection<Seguro> buscarTodos() {
        return seguroRepository.findAll();
    }

    public void deletar(Integer id) {
        seguroRepository.deleteById(id);
    }
}
