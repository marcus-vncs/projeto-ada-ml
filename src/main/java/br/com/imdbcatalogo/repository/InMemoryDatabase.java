package com.imdbcatalogo.repository;

import com.imdbcatalogo.domain.Ator;
import com.imdbcatalogo.domain.Diretor;
import com.imdbcatalogo.domain.Filme;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase {
    private List<Filme> filmes = new ArrayList<>();
    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    // Métodos para Filme
    public void salvarFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes);
    }

    public List<Filme> buscarFilmesPorNome(String nome) {
        List<Filme> resultados = new ArrayList<>();
        for (Filme filme : filmes) {
            if (filme.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultados.add(filme);
            }
        }
        return resultados;
    }

    // Métodos para Ator
    public void salvarAtor(Ator ator) {
        atores.add(ator);
    }

    public List<Ator> listarAtores() {
        return new ArrayList<>(atores);
    }

    // Métodos para Diretor
    public void salvarDiretor(Diretor diretor) {
        diretores.add(diretor);
    }

    public List<Diretor> listarDiretores() {
        return new ArrayList<>(diretores);
    }
}