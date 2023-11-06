package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.UsuarioCadastroDTO;
import net.weg.api.model.entity.Cliente;
import net.weg.api.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class ClienteService {


    private ClienteRepository clienteRepository;
    private CarroService carroService;

    public void salvar(UsuarioCadastroDTO usuario){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(usuario, cliente);
        clienteRepository.save(cliente);
    }
    public void editar(Cliente cliente){
        clienteRepository.save(cliente);
    }


    public Cliente buscarUm(Integer id){
        return clienteRepository.findById(id).get();
    }

    public Collection<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
