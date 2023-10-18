package net.weg.api.controller;

import net.weg.api.exception.InvalidIndex;
import net.weg.api.model.Carro;
import net.weg.api.repository.CarroDAO;
import net.weg.api.service.CarroService;
import net.weg.api.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
@RequestMapping("/carro")
public class CarroController {


    private CarroService carroService;
    public CarroController(CarroService carroService){
        this.carroService = carroService;
    }

    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable Integer id) {
        return carroService.buscarUm(id);
    }

    @GetMapping
    public Collection<Carro> buscarTodos() {
        return carroService.buscarTodos();
    }

    @DeleteMapping
    public void deletarCarro(@RequestParam Integer id) {
        carroService.deletar(id);
    }

    @PostMapping
    public void inserirCarro(@RequestBody Carro carro) throws InvalidIndex {
        carroService.inserir(carro);
    }

    @PutMapping
    public void atualizarCarro(@RequestBody Carro carro){
        carroService.atualizar(carro);
    }

}
