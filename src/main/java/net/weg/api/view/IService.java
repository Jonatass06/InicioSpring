package net.weg.api.view;

import net.weg.api.model.dto.IDTO;

import java.util.List;

public interface IService<T,ID> {

    void cadastrar(IDTO dto) throws Exception;

    void deletar(ID id);

    void editar(IDTO dto) throws Exception;

    void buscarUm(ID id);

    List<T> buscarTodos();
}
