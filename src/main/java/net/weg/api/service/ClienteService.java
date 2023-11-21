package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.UsuarioCadastroDTO;
import net.weg.api.model.entity.Cliente;
import net.weg.api.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public void salvar(UsuarioCadastroDTO ucdto){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(ucdto,cliente);
        clienteRepository.save(cliente);
    }

    public Cliente buscarUm(@PathVariable(value = "id") Integer id) {
        return clienteRepository.findById(id).get();
    }

    public Collection<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void deletar(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
    }
}
