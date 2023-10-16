package net.weg.api.repository;

import net.weg.api.exception.InvalidIndex;

import java.util.Set;

public interface ICRUD <T, ID> extends AutoCloseable{

    void inserir(T obj) throws InvalidIndex;
    T buscarUm(ID id);
    Set<T> buscarTodos();
    void atualizar(T obj);
    void deletar (ID id);
}
