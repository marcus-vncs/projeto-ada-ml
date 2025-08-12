package com.imdbcatalogo.repository;

import com.imdbcatalogo.domain.Ator;
import com.imdbcatalogo.domain.Diretor;
import com.imdbcatalogo.domain.Filme;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryDatabase {
    private List<Filme> filmes = new ArrayList<>();
    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    // Métodos para Filme
    public void salvarFilme(Filme filme) {
        if (filme == null) {
            throw new IllegalArgumentException("Filme não pode ser nulo");
        }
        filmes.add(filme);
    }

    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes);
    }

    public List<Filme> buscarFilmesPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return new ArrayList<>();
        }

        return filmes.stream()
                .filter(filme -> filme.getNome().toLowerCase().contains(nome.toLowerCase().trim()))
                .collect(Collectors.toList());
    }

    // Métodos para Ator
    public void salvarAtor(Ator ator) {
        if (ator == null) {
            throw new IllegalArgumentException("Ator não pode ser nulo");
        }
        if (!atores.contains(ator)) {
            atores.add(ator);
        }
    }

    public List<Ator> listarAtores() {
        return new ArrayList<>(atores);
    }

    public List<Ator> buscarAtoresPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return new ArrayList<>();
        }

        return atores.stream()
                .filter(ator -> ator.getNome().toLowerCase().contains(nome.toLowerCase().trim()))
                .collect(Collectors.toList());
    }

    // Métodos para Diretor
    public void salvarDiretor(Diretor diretor) {
        if (diretor == null) {
            throw new IllegalArgumentException("Diretor não pode ser nulo");
        }
        if (!diretores.contains(diretor)) {
            diretores.add(diretor);
        }
    }

    public List<Diretor> listarDiretores() {
        return new ArrayList<>(diretores);
    }

    public List<Diretor> buscarDiretoresPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return new ArrayList<>();
        }

        return diretores.stream()
                .filter(diretor -> diretor.getNome().toLowerCase().contains(nome.toLowerCase().trim()))
                .collect(Collectors.toList());
    }

    // Métodos utilitários
    public int getTotalFilmes() {
        return filmes.size();
    }

    public int getTotalAtores() {
        return atores.size();
    }

    public int getTotalDiretores() {
        return diretores.size();
    }

    public void limparDatabase() {
        filmes.clear();
        atores.clear();
        diretores.clear();
    }
}