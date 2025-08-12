package com.imdbcatalogo.domain;

import java.util.Date;
import java.util.Objects;

public abstract class Pessoa {
    private String nome;
    private Date dataNascimento;
    private String nacionalidade;

    public Pessoa(String nome, Date dataNascimento, String nacionalidade) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula");
        }
        if (nacionalidade == null || nacionalidade.trim().isEmpty()) {
            throw new IllegalArgumentException("Nacionalidade não pode ser nula ou vazia");
        }

        this.nome = nome.trim();
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade.trim();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome.trim();
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula");
        }
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        if (nacionalidade == null || nacionalidade.trim().isEmpty()) {
            throw new IllegalArgumentException("Nacionalidade não pode ser nula ou vazia");
        }
        this.nacionalidade = nacionalidade.trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pessoa pessoa = (Pessoa) obj;
        return Objects.equals(nome, pessoa.nome) &&
               Objects.equals(dataNascimento, pessoa.dataNascimento) &&
               Objects.equals(nacionalidade, pessoa.nacionalidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataNascimento, nacionalidade);
    }

    @Override
    public abstract String toString();
}