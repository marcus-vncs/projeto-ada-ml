package com.imdbcatalogo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Diretor extends Pessoa {
    private List<Filme> filmesDirigidos;

    public Diretor(String nome, Date dataNascimento, String nacionalidade) {
        super(nome, dataNascimento, nacionalidade);
        this.filmesDirigidos = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        if (!filmesDirigidos.contains(filme)) {
            filmesDirigidos.add(filme);
        }
    }

    public List<Filme> getFilmesDirigidos() {
        return new ArrayList<>(filmesDirigidos);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════╗\n");
        sb.append("║              DIRETOR                 ║\n");
        sb.append("╠══════════════════════════════════════╣\n");
        sb.append("║ Nome: ").append(String.format("%-29s", getNome())).append("║\n");
        sb.append("║ Nacionalidade: ").append(String.format("%-19s", getNacionalidade())).append("║\n");
        sb.append("║ Filmes dirigidos: ").append(String.format("%-15d", filmesDirigidos.size())).append("║\n");
        sb.append("╚══════════════════════════════════════╝");
        return sb.toString();
    }
}