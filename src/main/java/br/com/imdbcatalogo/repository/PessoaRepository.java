package com.imdbcatalogo.repository;

import com.imdbcatalogo.domain.Ator;
import com.imdbcatalogo.domain.Diretor;
import java.util.List;

public class PessoaRepository {
    private InMemoryDatabase database;

    public PessoaRepository(InMemoryDatabase database) {
        this.database = database;
    }

    public void salvarAtor(Ator ator) {
        database.salvarAtor(ator);
    }

    public List<Ator> listarAtores() {
        return database.listarAtores();
    }

    public void salvarDiretor(Diretor diretor) {
        database.salvarDiretor(diretor);
    }

    public List<Diretor> listarDiretores() {
        return database.listarDiretores();
    }
}