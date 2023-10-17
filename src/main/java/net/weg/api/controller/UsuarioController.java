package net.weg.api.controller;

import net.weg.api.exception.InvalidIndex;
import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.InputMismatchException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id) {
        return usuarioDAO.buscarUm(id);
    }

    @GetMapping
    public Collection<Usuario> buscarTodos() {
        return usuarioDAO.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Integer id) {
        usuarioDAO.deletar(id);
    }

    @PostMapping
    public void inserirUsuario(@RequestBody Usuario usuario) throws InvalidIndex {
        usuarioDAO.inserir(usuario);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Usuario usuario){
        usuarioDAO.atualizar(usuario);
    }

}
