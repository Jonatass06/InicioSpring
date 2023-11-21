package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.entity.Seguradora;
import net.weg.api.service.SeguradoraService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/seguradora")
public class SeguradoraController {
    private SeguradoraService seguradoraService;

    @GetMapping("/{id}")
    public void buscarId(Integer id){
        seguradoraService.buscarId(id);
    }

    @GetMapping()
    public void buscarTodos(){
        seguradoraService.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        seguradoraService.deletar(id);
    }

    @PostMapping
    public void inserir(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }

    @PutMapping
    public void atualizar(@RequestBody Seguradora seguradora){
        seguradoraService.salvar(seguradora);
    }
}
