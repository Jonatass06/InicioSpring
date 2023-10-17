package net.weg.api.controller;

import net.weg.api.exception.InvalidIndex;
import net.weg.api.model.Carro;
import net.weg.api.repository.CarroDAO;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController
@RequestMapping("/carro")
public class CarroController {


    private CarroDAO carroDAO = new CarroDAO();
    @GetMapping("/{id}")
    public Carro buscarCarro(@PathVariable Integer id) {
        return carroDAO.buscarUm(id);
    }

    @GetMapping
    public Collection<Carro> buscarTodos() {
        return carroDAO.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void deletarCarro(@PathVariable Integer id) {
        carroDAO.deletar(id);
    }

    @PostMapping
    public void inserirCarro(@RequestBody Carro carro) throws InvalidIndex {
        carroDAO.inserir(carro);
    }

    @PutMapping
    public void atualizarCarro(@RequestBody Carro carro){
        carroDAO.atualizar(carro);
    }

}
