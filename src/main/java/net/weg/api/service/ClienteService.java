package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Cliente;
import net.weg.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class ClienteService {


    private ClienteRepository usuarioRepository;
    private CarroService carroService;

    public void salvar(Cliente usuario){
        usuarioRepository.save(usuario);
    }

    public Cliente buscarUm(Integer id){
        return usuarioRepository.findById(id).get();
    }

    public Collection<Cliente> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
