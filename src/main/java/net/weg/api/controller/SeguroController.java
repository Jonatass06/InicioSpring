package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.SeguroCadastroDTO;
import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import net.weg.api.service.SeguroService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/seguro")
public class SeguroController {
    private SeguroService seguroService;

    @GetMapping("/{idSeguro}/{idSeguradora}")
    public void buscarId(@PathVariable Integer idSeguro, @PathVariable Integer idSeguradora){
        seguroService.buscarId(idSeguro,idSeguradora);
    }

    @GetMapping()
    public void buscarTodos(){
        seguroService.buscarTodos();
    }

    @DeleteMapping("/{idSeguro}/{idSeguradora}")
    public void remover( @PathVariable Integer idSeguro, @PathVariable Integer idSeguradora){
        seguroService.deletar(idSeguro,idSeguradora);
    }

    @PostMapping
    public void inserir(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.salvar(seguroCadastroDTO);
    }

    @PutMapping
    public void atualizar(@RequestBody SeguroCadastroDTO seguroCadastroDTO){
        seguroService.salvar(seguroCadastroDTO);
    }
}
