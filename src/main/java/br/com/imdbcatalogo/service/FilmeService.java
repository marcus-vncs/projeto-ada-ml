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
        if (filme == null) {
            throw new IllegalArgumentException("Filme não pode ser nulo");
        }
        filmeRepository.salvar(filme);

        // Salva o diretor se ainda não estiver salvo
        pessoaRepository.salvarDiretor(filme.getDiretor());

        // Salva os atores se ainda não estiverem salvos
        filme.getAtores().forEach(ator -> pessoaRepository.salvarAtor(ator));
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.listarTodos();
    }

    public List<Filme> pesquisarFilmes(String nome) {
        return filmeRepository.buscarPorNome(nome);
    }
}