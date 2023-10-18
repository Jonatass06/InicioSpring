package net.weg.api.controller;

import net.weg.api.exception.InvalidIndex;
import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.InputMismatchException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable Integer id) {
        return usuarioService.buscarUm(id);
    }

    @GetMapping
    public Collection<Usuario> buscarTodos() {
        return usuarioService.buscarTodos();
    }

    @DeleteMapping
    public void deletarUsuario(@RequestParam Integer id) {

        usuarioService.deletar(id);
    }

    @PostMapping
    public void inserirUsuario(@RequestBody Usuario usuario) throws InvalidIndex {
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Usuario usuario) throws InvalidIndex{
        usuarioService.atualizar(usuario);
    }

}
