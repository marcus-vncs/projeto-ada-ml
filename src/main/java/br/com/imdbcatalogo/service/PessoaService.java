package com.imdbcatalogo.service;

import com.imdbcatalogo.domain.Ator;
import com.imdbcatalogo.domain.Diretor;
import com.imdbcatalogo.repository.PessoaRepository;
import java.util.List;

public class PessoaService {
    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void cadastrarAtor(Ator ator) {
        pessoaRepository.salvarAtor(ator);
    }

    public void cadastrarDiretor(Diretor diretor) {
        pessoaRepository.salvarDiretor(diretor);
    }

    public List<Ator> listarAtores() {
        return pessoaRepository.listarAtores();
    }

    public List<Diretor> listarDiretores() {
        return pessoaRepository.listarDiretores();
    }
}