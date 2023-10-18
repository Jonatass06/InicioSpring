package net.weg.api.service;

import lombok.AllArgsConstructor;
import net.weg.api.model.Usuario;
import net.weg.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UsuarioService {


    private UsuarioRepository usuarioRepository;
    private CarroService carroService;

    public void salvar(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario buscarUm(Integer id){
        return usuarioRepository.findById(id).get();
    }

    public Collection<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
