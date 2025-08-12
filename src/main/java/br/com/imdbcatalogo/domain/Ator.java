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
        return new ArrayList<>(filmesParticipados);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════╗\n");
        sb.append("║               ATOR                   ║\n");
        sb.append("╠══════════════════════════════════════╣\n");
        sb.append("║ Nome: ").append(String.format("%-29s", getNome())).append("║\n");
        sb.append("║ Nacionalidade: ").append(String.format("%-19s", getNacionalidade())).append("║\n");
        sb.append("║ Filmes: ").append(String.format("%-27d", filmesParticipados.size())).append("║\n");
        sb.append("╚══════════════════════════════════════╝");
        return sb.toString();
    }
}