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

@AllArgsConstructor
@RestController
@RequestMapping("/carro")
public class CarroController {

    private CarroService carroService;

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarUm(@PathVariable Integer id){
        try {
            carroService.buscarUm(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/seguradora/{id}")
    public ResponseEntity<Collection<Carro>> buscarCarroSeguradora(@PathVariable Integer id){
        try{
        return new ResponseEntity<>(carroService.buscarCarrosSeguradora(id),HttpStatus.OK);
        }catch (NoSuchElementException e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @GetMapping("/marca")
    public ResponseEntity<Collection<Carro>> buscarCarrosMarca(@RequestParam String marca){
        try{
        return new ResponseEntity<>(carroService.buscarCarrosMarca(marca),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Carro>> buscarTodos(){
        try{
        return new ResponseEntity<>(carroService.buscarTodos(), HttpStatus.OK);
            }catch (NoSuchElementException e){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public void deletar(@RequestParam Integer id){
        carroService.deletar(id);
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrar(@RequestBody CarroCadastroDTO carroDTO){
        try{
            carroService.cadastrar(carroDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Carro> editar(@RequestBody CarroEdicaoDTO carroDTO){
        try {
            carroService.editar(carroDTO);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
