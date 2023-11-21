package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.CarroEdicaoDTO;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.repository.CarroRepository;
import net.weg.api.view.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Service
public class CarroService implements IService<Carro,Integer> {
    private CarroRepository carroRepository;

    public List<Carro> buscarTodos(){
        return carroRepository.findAll();
    }

    public List<Carro> buscarCarrosSeguradora(Integer id){
        return carroRepository.findBySeguro_SeguradoraId(id);
    }

    public List<Carro> buscarCarrosMarca(String marca){
        return carroRepository.findByMarca(marca);
    }

    public void deletar( Integer id){
        carroRepository.deleteById(id);
    }


    public void cadastrar(IDTO dto) throws Exception {
        CarroCadastroDTO carroDTO = (CarroCadastroDTO) dto;
        if(carroRepository.existsByPlaca(carroDTO.getPlaca())){
            throw new Exception("Há um carro com a placa " + carroDTO.getPlaca() + "cadastrado.");
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO,carro);
          carroRepository.save(carro);
    }

    public void buscarUm(Integer id) {
      carroRepository.findById(id).get();

    }

    public void editar(IDTO dto) throws Exception {
        CarroEdicaoDTO carroDTO = (CarroEdicaoDTO) dto;
        if (!carroRepository.existsById(carroDTO.getId())){
            throw new Exception("Não foi encontrado nenhum carro com o id"+carroDTO.getId());
        }
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroDTO, carro);
        carroRepository.save(carro);
    }


}
