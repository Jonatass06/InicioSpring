package net.weg.api.controller;

import net.weg.api.model.entity.Seguro;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public class SeguroController {

    private SeguroService seguroService;
    @GetMapping("/{id}")
    public Seguro buscarUsuario(@PathVariable Integer id) {
        return seguroService.buscarUm(id);
    }

    @GetMapping
    public Collection<Seguro> buscarTodos() {
        return seguroService.buscarTodos();
    }

    @DeleteMapping
    public void deletarUsuario(@RequestParam Integer id) {

        seguroService.deletar(id);
    }

    @PostMapping
    public void inserirUsuario(@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Seguro seguro){
        seguroService.salvar(seguro);
    }
}
