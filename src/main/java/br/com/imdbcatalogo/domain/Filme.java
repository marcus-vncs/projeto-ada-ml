package com.imdbcatalogo.domain;

import com.imdbcatalogo.utils.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filme {
    private String nome;
    private Date dataLancamento;
    private double orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> atores;

    public Filme(String nome, Date dataLancamento, double orcamento, String descricao, Diretor diretor) {
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.diretor = diretor;
        this.atores = new ArrayList<>();
        diretor.adicionarFilme(this);
    }

    public void adicionarAtor(Ator ator) {
        if (!atores.contains(ator)) {
            atores.add(ator);
            ator.adicionarFilme(this);
        }
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Filme: ").append(nome).append("\n");
        sb.append("Data de Lançamento: ").append(new DateUtils().formatDate(dataLancamento)).append("\n");
        sb.append("Orçamento: $").append(String.format("%.2f", orcamento)).append("\n");
        sb.append("Descrição: ").append(descricao).append("\n");
        sb.append("Diretor: ").append(diretor.getNome()).append("\n");
        sb.append("Atores: ");
        if (!atores.isEmpty()) {
            for (int i = 0; i < atores.size(); i++) {
                sb.append(atores.get(i).getNome());
                if (i < atores.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("Nenhum ator associado.");
        }
        return sb.toString();
    }
}

