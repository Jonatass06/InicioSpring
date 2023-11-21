package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Endereco;
import net.weg.api.repository.EnderecoRepository;
import net.weg.api.view.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public void salvar(Endereco endereco){
        enderecoRepository.save(endereco);
    }

    public void deletar(Integer id){
        enderecoRepository.deleteById(id);
    }

    public Endereco buscarUm(Integer id){
        return enderecoRepository.findById(id).get();
    }

    public List<Endereco> buscarTodos(){
        return enderecoRepository.findAll();
    }

}
