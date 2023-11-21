package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Habilitacao;
import net.weg.api.repository.HabilitacaoRepository;
import net.weg.api.view.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HabilitacaoService {

    private HabilitacaoRepository habilitacaoRepository;

    public void salvar(Habilitacao habilitacao){
        habilitacaoRepository.save(habilitacao);
    }

    public void deletar(Integer id){
        habilitacaoRepository.deleteById(id);
    }

    public void buscarUm(Integer id){
         habilitacaoRepository.findById(id).get();
    }

    public List<Habilitacao> buscarTodos(){
        return habilitacaoRepository.findAll();
    }

}
