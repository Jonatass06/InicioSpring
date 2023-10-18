package net.weg.api.service;

import net.weg.api.exception.InvalidIndex;
import net.weg.api.model.Usuario;
import net.weg.api.repository.CarroDAO;
import net.weg.api.repository.UsuarioDAO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class UsuarioService {


    private UsuarioDAO usuarioDAO;
    private CarroService carroService;
    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
        this.carroService = new CarroService();
    }

    public void inserir(Usuario usuario) throws InvalidIndex {
        try {
            carroService.buscarUm(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroService.inserir(usuario.getCarro());
        }catch (NullPointerException ignore){}
        usuarioDAO.inserir(usuario);
    }

    public Usuario buscarUm(Integer id) {
        Usuario usuario = usuarioDAO.buscarUm(id);
        try {
            usuario.setCarro(carroService.buscarUm(usuario.getCarro().getId()));
        } catch (NullPointerException ignore) {}
        return usuario;
    }

    public Collection<Usuario> buscarTodos() {
        Collection<Usuario> usuarios = usuarioDAO.buscarTodos();
        for(Usuario usuario : usuarios){
            try {
                usuario.setCarro(carroService.buscarUm(usuario.getCarro().getId()));
            } catch (NullPointerException ignore) {}
        }
        return usuarios;
    }

    public void deletar(Integer id) {

        usuarioDAO.deletar(id);
    }

    public void atualizar(Usuario usuario) throws InvalidIndex{
        try {
            carroService.buscarUm(usuario.getCarro().getId());
        } catch (NoSuchElementException e) {
            carroService.inserir(usuario.getCarro());
        }catch (NullPointerException ignore){}
        usuarioDAO.atualizar(usuario);
    }


}
