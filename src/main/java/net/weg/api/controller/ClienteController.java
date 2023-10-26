package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Cliente;
import net.weg.api.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;


    @GetMapping("/{id}")
    public Cliente buscarUsuario(@PathVariable Integer id) {
        return clienteService.buscarUm(id);
    }

    @GetMapping
    public Collection<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @DeleteMapping
    public void deletarUsuario(@RequestParam Integer id) {

        clienteService.deletar(id);
    }

    @PostMapping
    public void inserirUsuario(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Cliente cliente){
        clienteService.salvar(cliente);
    }

}
