package com.imdbcatalogo.domain;

import com.imdbcatalogo.utils.DateUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Filme {
    private String nome;
    private Date dataLancamento;
    private double orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> atores;

    public Filme(String nome, Date dataLancamento, double orcamento, String descricao, Diretor diretor) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do filme não pode ser nulo ou vazio");
        }
        if (dataLancamento == null) {
            throw new IllegalArgumentException("Data de lançamento não pode ser nula");
        }
        if (orcamento < 0) {
            throw new IllegalArgumentException("Orçamento não pode ser negativo");
        }
        if (diretor == null) {
            throw new IllegalArgumentException("Diretor não pode ser nulo");
        }

        this.nome = nome.trim();
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao != null ? descricao.trim() : "";
        this.diretor = diretor;
        this.atores = new ArrayList<>();
        diretor.adicionarFilme(this);
    }

    public void adicionarAtor(Ator ator) {
        if (ator == null) {
            throw new IllegalArgumentException("Ator não pode ser nulo");
        }
        if (!atores.contains(ator)) {
            atores.add(ator);
            ator.adicionarFilme(this);
        }
    }

    public void removerAtor(Ator ator) {
        atores.remove(ator);
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
        return new ArrayList<>(atores);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Filme filme = (Filme) obj;
        return Objects.equals(nome, filme.nome) &&
               Objects.equals(dataLancamento, filme.dataLancamento) &&
               Objects.equals(diretor, filme.diretor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataLancamento, diretor);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════╗\n");
        sb.append("║              FILME                   ║\n");
        sb.append("╠══════════════════════════════════════╣\n");
        sb.append("║ Nome: ").append(String.format("%-29s", nome)).append("║\n");
        sb.append("║ Lançamento: ").append(String.format("%-22s", new DateUtils().formatDate(dataLancamento))).append("║\n");
        sb.append("║ Orçamento: $").append(String.format("%-21.2f", orcamento)).append("║\n");
        sb.append("║ Diretor: ").append(String.format("%-25s", diretor.getNome())).append("║\n");
        sb.append("║ Descrição: ").append(String.format("%-23s",
            descricao.length() > 23 ? descricao.substring(0, 20) + "..." : descricao)).append("║\n");
        sb.append("║ Atores: ");
        if (!atores.isEmpty()) {
            StringBuilder atoresStr = new StringBuilder();
            for (int i = 0; i < atores.size(); i++) {
                atoresStr.append(atores.get(i).getNome());
                if (i < atores.size() - 1) {
                    atoresStr.append(", ");
                }
            }
            String atoresFormatted = atoresStr.length() > 26 ? atoresStr.substring(0, 23) + "..." : atoresStr.toString();
            sb.append(String.format("%-26s", atoresFormatted));
        } else {
            sb.append(String.format("%-26s", "Nenhum ator"));
        }
        sb.append("║\n");
        sb.append("╚══════════════════════════════════════╝");
        return sb.toString();
    }
}
