package com.imdbcatalogo.repository;

import com.imdbcatalogo.domain.Filme;
import java.util.List;

public class FilmeRepository {
    private InMemoryDatabase database;

    public FilmeRepository(InMemoryDatabase database) {
        this.database = database;
    }

    public void salvar(Filme filme) {
        database.salvarFilme(filme);
    }

    public List<Filme> listarTodos() {
        return database.listarFilmes();
    }

    public List<Filme> buscarPorNome(String nome) {
        return database.buscarFilmesPorNome(nome);
    }
}