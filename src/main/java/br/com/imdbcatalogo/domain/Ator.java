package com.imdbcatalogo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ator extends Pessoa {
    private List<Filme> filmesParticipados;

    public Ator(String nome, Date dataNascimento, String nacionalidade) {
        super(nome, dataNascimento, nacionalidade);
        this.filmesParticipados = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        if (!filmesParticipados.contains(filme)) {
            filmesParticipados.add(filme);
        }
    }

    public List<Filme> getFilmesParticipados() {
        return filmesParticipados;
    }

    @Override
    public String toString() {
        return "Ator: " + getNome() + ", Nacionalidade: " + getNacionalidade();
    }
}