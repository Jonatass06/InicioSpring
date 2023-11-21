package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.CarroEdicaoDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.repository.CarroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor

@Service
public class CarroService {

    private CarroRepository carroRepository;


    public Carro buscarUm(@PathVariable(value = "id") Integer id) {
        return carroRepository.findById(id).get();
    }


    public List<Carro> buscarPorMarca(@PathVariable String marca){
        return carroRepository.findByMarca(marca);
    }

    public Collection<Carro> buscarPorSeguradora(@PathVariable Integer id){
        return carroRepository.findBySeguro_SeguradoraId(id);
    }

    public Collection<Carro> buscarTodos() {
        return carroRepository.findAll();
    }

    public void deletar(@PathVariable Integer id) {
        carroRepository.deleteById(id);
    }

    public Carro criar(@RequestBody CarroCadastroDTO carroDTO) throws Exception {
        if (carroRepository.existsByPlaca(carroDTO.getPlaca())){
            throw new Exception("Já existe um carro com a placa "+ carroDTO.getPlaca());
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO,carro);
        return carroRepository.save(carro);
    }

    public Carro editar(@RequestBody CarroEdicaoDTO edicaoDTO) throws Exception {

        if (!carroRepository.existsById(edicaoDTO.getId())){
            throw new Exception("Não foi encontrado nenhum carro com o id "+ edicaoDTO.getId());
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(edicaoDTO,carro);
        return carroRepository.save(carro);
    }
}
