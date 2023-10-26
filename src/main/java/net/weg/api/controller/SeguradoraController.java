package net.weg.api.controller;

import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public class SeguradoraController {

    private SeguradoraService seguradoraService;
    @GetMapping("/{id}")
    public Seguradora buscarUsuario(@PathVariable Integer id) {
        return seguradoraService.buscarUm(id);
    }

    @GetMapping
    public Collection<Seguradora> buscarTodos() {
        return seguradoraService.buscarTodos();
    }

    @DeleteMapping
    public void deletarUsuario(@RequestParam Integer id) {

        seguradoraService.deletar(id);
    }

    @PostMapping
    public void inserirUsuario(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }
}
