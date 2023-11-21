package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguradoraCadastroDTO;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/seguradora")
public class SeguradoraController {
    private SeguradoraService seguradoraService;

    @PostMapping
    public void cadastrar(@RequestBody SeguradoraCadastroDTO seguradora){
        seguradoraService.cadastrar(seguradora);
    }

    @PutMapping
    public void editar(@RequestBody SeguradoraCadastroDTO seguradora){
        seguradoraService.editar(seguradora);
    }

    @DeleteMapping("/{id}")
    public void deletar(Integer id){
        seguradoraService.deletar(id);
    }

    @GetMapping()
    public Collection<Seguradora> buscarTodos(){
        return seguradoraService.buscarTodos();
    }
    @GetMapping()
    public void buscarUm(Integer id){
        seguradoraService.buscarUm(id);
    }
}
