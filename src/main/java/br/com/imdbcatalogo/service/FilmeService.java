package com.imdbcatalogo.service;

import com.imdbcatalogo.domain.Filme;
import com.imdbcatalogo.repository.FilmeRepository;
import com.imdbcatalogo.repository.PessoaRepository;
import java.util.List;

public class FilmeService {
    private FilmeRepository filmeRepository;
    private PessoaRepository pessoaRepository;

    public FilmeService(FilmeRepository filmeRepository, PessoaRepository pessoaRepository) {
        this.filmeRepository = filmeRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public void cadastrarFilme(Filme filme) {
        filmeRepository.salvar(filme);
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.listarTodos();
    }

    public List<Filme> pesquisarFilmes(String nome) {
        return filmeRepository.buscarPorNome(nome);
    }
}