package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.DTO.CarroCadastroDTO;
import net.weg.api.model.DTO.CarroEdicaoDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/clube")
public class CarroController {

    CarroService clubeService;

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarUm(@PathVariable(value = "id") Integer id) {
        try{
//            return ResponseEntity.ok(clubeService.buscarUm(id));
            return new ResponseEntity<>(clubeService.buscarUm(id),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Carro>> buscarTodos() {
        return new ResponseEntity<>(clubeService.buscarTodos(),HttpStatus.OK);
    }

    @GetMapping("/seguradora/{id}")
    public ResponseEntity<Collection<Carro>> buscarCarrosSeguradora(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(clubeService.buscarPorSeguradora(id),HttpStatus.OK);
    }

    @GetMapping("/marca")
    public ResponseEntity<Collection<Carro>> buscarCarrosMarca(@RequestParam String marca) {
        return new ResponseEntity<>(clubeService.buscarPorMarca(marca),HttpStatus.OK);
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id) {
        clubeService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Carro> criar(@RequestBody CarroCadastroDTO clubeFutebolDTO) {
        try {
            return new ResponseEntity<>(clubeService.criar(clubeFutebolDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping()
    public ResponseEntity<Carro> editar(@RequestBody CarroEdicaoDTO edicaoDTO) {

        try {
            return new ResponseEntity<>(clubeService.editar(edicaoDTO),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
