package net.weg.api.controller;

import lombok.AllArgsConstructor;
import net.weg.api.model.dto.CarroCadastroDTO;
import net.weg.api.model.dto.CarroEdicaoDTO;
import net.weg.api.model.entity.Carro;
import net.weg.api.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {


    private CarroService carroService;

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarCarro(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(carroService.buscarUm(id), HttpStatus.FOUND);
        }catch(NoSuchElementException e ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/seguradora/{id}")
    public ResponseEntity<Collection<Carro>> buscarCarroPorSeguradora(@PathVariable Integer id) {
        return new ResponseEntity<>(carroService.buscarPorSeguradora(id), HttpStatus.FOUND);
    }

    @GetMapping("/marca")
    public ResponseEntity<Collection<Carro>> buscarCarroPorMarca(@RequestParam String marca) {
        return new ResponseEntity<>(carroService.buscarPorMarca(marca), HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Collection<Carro>> buscarTodos() {
            return new ResponseEntity<>(carroService.buscarTodos(), HttpStatus.FOUND);
    }

    @DeleteMapping
    public void deletarCarro(@RequestParam Integer id) {
        carroService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Carro> inserirCarro(@RequestBody CarroCadastroDTO carroDTO){
        try{
            return new ResponseEntity<>(carroService.salvar(carroDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Carro> atualizarCarro(@RequestBody CarroEdicaoDTO carroDTO){
        try{
            return new ResponseEntity<>(carroService.editar(carroDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
