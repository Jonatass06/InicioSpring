package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.IDTO;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.model.entity.Cliente;
import net.weg.api.model.entity.Usuario;
import net.weg.api.repository.ClienteRepository;
import net.weg.api.repository.HabilitacaoRepository;
import net.weg.api.view.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService implements IService<Cliente,Integer> {

    private ClienteRepository clienteRepository;
    private HabilitacaoRepository habilitacaoRepository;

    public void buscarUm(Integer id){
        clienteRepository.findById(id).get();
    }

    public List<Cliente> buscarTodos(){
       return clienteRepository.findAll();
    }

    public void deletar(Integer id){
        clienteRepository.deleteById(id);
    }

    public void cadastrar(IDTO dto){
        UsuarioCadastroDTO usuarioCadastroDTO = (UsuarioCadastroDTO) dto;
        Cliente cliente= new Cliente();
        BeanUtils.copyProperties(usuarioCadastroDTO,cliente);
        clienteRepository.save(cliente);
    }

    public void editar(IDTO dto) {
        UsuarioCadastroDTO ucdto = (UsuarioCadastroDTO) dto;
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(ucdto,cliente);
        clienteRepository.save(cliente);
    }
}
