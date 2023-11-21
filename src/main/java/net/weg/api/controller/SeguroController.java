package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {
    private SeguroService seguroService;
    @DeleteMapping("/{seguroId}/{seguradoraId}")
    public void deletar(@PathVariable Integer segurooId, @PathVariable Integer seguradoraId){
        seguroService.deletar(new SeguroId(segurooId,seguradoraId));
    }

    @PostMapping
    public void cadastrar(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.cadastrar(seguroCadastroDTO);
    }

    @PutMapping
    public void editar(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.editar(seguroCadastroDTO);
    }

    @GetMapping("/{id}")
    public void buscarUm(@PathVariable Integer id, @PathVariable Integer seguradoraId){
        seguroService.buscarUm(new SeguroId(id,seguradoraId));
    }

}
