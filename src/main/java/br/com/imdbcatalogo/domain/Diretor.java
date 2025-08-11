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
        return filmesDirigidos;
    }

    @Override
    public String toString() {
        return "Diretor: " + getNome() + ", Nacionalidade: " + getNacionalidade();
    }
}