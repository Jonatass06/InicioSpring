package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {

    private SeguroService seguroService;
    @GetMapping("/{id}/{seguradoraId}")
    public Seguro buscarUsuario(@PathVariable Integer id, @PathVariable Long seguradoraId) {
        return seguroService.buscarUm(id, seguradoraId);
    }

    @GetMapping
    public Collection<Seguro> buscarTodos() {
        return seguroService.buscarTodos();
    }

    @DeleteMapping("/{id}/{seguradoraId}")
    public void deletarUsuario(@PathVariable Integer id, @PathVariable Long seguradoraId) {

        seguroService.deletar(id, seguradoraId);
    }

    @PostMapping
    public void inserirUsuario(@RequestBody SeguroCadastroDTO seguroCadastroDTO) throws Exception{
        seguroService.salvar(seguroCadastroDTO);
    }

    @PutMapping
    public void atualizarUsuario(@RequestBody Seguro seguro){
        seguroService.editar(seguro);
    }
}
