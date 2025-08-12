package com.imdbcatalogo.controller;

import com.imdbcatalogo.domain.*;
import com.imdbcatalogo.service.FilmeService;
import com.imdbcatalogo.service.PessoaService;
import com.imdbcatalogo.utils.DateUtils;
import java.util.*;

public class CatalogoController {
    private Scanner scanner;
    private FilmeService filmeService;
    private PessoaService pessoaService;
    private DateUtils dateUtils;

    public CatalogoController(FilmeService filmeService, PessoaService pessoaService) {
        this.scanner = new Scanner(System.in);
        this.filmeService = filmeService;
        this.pessoaService = pessoaService;
        this.dateUtils = new DateUtils();
    }

    public void iniciar() {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║          BEM-VINDO AO IMDB             ║");
        System.out.println("║        Sistema de Catálogo             ║");
        System.out.println("╚════════════════════════════════════════╝");

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1: cadastrarFilme(); break;
                case 2: cadastrarAtor(); break;
                case 3: cadastrarDiretor(); break;
                case 4: associarAtoresFilme(); break;
                case 5: pesquisarFilme(); break;
                case 6: listarFilmes(); break;
                case 7: listarAtores(); break;
                case 8: listarDiretores(); break;
                case 9: exibirEstatisticas(); break;
                case 0:
                    System.out.println("╔════════════════════════════════════════╗");
                    System.out.println("║          Obrigado por usar!            ║");
                    System.out.println("╚════════════════════════════════════════╝");
                    scanner.close(); // Fechar o scanner antes de sair
                    break;
                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private int lerOpcao() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // consume newline
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println("❌ Erro: Por favor, digite um número válido!");
            scanner.nextLine();
            return -1;
        }
    }

    private void exibirMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║            MENU PRINCIPAL              ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 1. 🎬 Cadastrar Filme                  ║");
        System.out.println("║ 2. 🎭 Cadastrar Ator                   ║");
        System.out.println("║ 3. 🎯 Cadastrar Diretor                ║");
        System.out.println("║ 4. 🔗 Associar Atores a Filme          ║");
        System.out.println("║ 5. 🔍 Pesquisar Filme                  ║");
        System.out.println("║ 6. 📋 Listar Todos os Filmes           ║");
        System.out.println("║ 7. 📋 Listar Todos os Atores           ║");
        System.out.println("║ 8. 📋 Listar Todos os Diretores        ║");
        System.out.println("║ 9. 📊 Estatísticas                     ║");
        System.out.println("║ 0. 🚪 Sair                             ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

    private void cadastrarFilme() {
        try {
            System.out.println("\n🎬 --- Cadastro de Filme ---");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Data de Lançamento (dd/MM/yyyy): ");
            Date dataLancamento = dateUtils.parseDate(scanner.nextLine());

            System.out.print("Orçamento: ");
            double orcamento = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();

            List<Diretor> diretores = pessoaService.listarDiretores();
            if (diretores.isEmpty()) {
                System.out.println("❌ Nenhum diretor cadastrado. Cadastre um diretor primeiro.");
                return;
            }

            System.out.println("\n📋 Diretores disponíveis:");
            for (int i = 0; i < diretores.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + diretores.get(i).getNome());
            }

            System.out.print("Escolha o número do diretor: ");
            int indice = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indice < 0 || indice >= diretores.size()) {
                System.out.println("❌ Índice inválido!");
                return;
            }

            Diretor diretor = diretores.get(indice);
            Filme filme = new Filme(nome, dataLancamento, orcamento, descricao, diretor);
            filmeService.cadastrarFilme(filme);
            System.out.println("✅ Filme cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }
    }

    private void cadastrarAtor() {
        try {
            System.out.println("\n🎭 --- Cadastro de Ator ---");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            Date dataNascimento = dateUtils.parseDate(scanner.nextLine());

            System.out.print("Nacionalidade: ");
            String nacionalidade = scanner.nextLine();

            Ator ator = new Ator(nome, dataNascimento, nacionalidade);
            pessoaService.cadastrarAtor(ator);
            System.out.println("✅ Ator cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }
    }

    private void cadastrarDiretor() {
        try {
            System.out.println("\n🎯 --- Cadastro de Diretor ---");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            Date dataNascimento = dateUtils.parseDate(scanner.nextLine());

            System.out.print("Nacionalidade: ");
            String nacionalidade = scanner.nextLine();

            Diretor diretor = new Diretor(nome, dataNascimento, nacionalidade);
            pessoaService.cadastrarDiretor(diretor);
            System.out.println("✅ Diretor cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }
    }

    private void associarAtoresFilme() {
        List<Filme> filmes = filmeService.listarFilmes();
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        System.out.println("\n--- Associar Atores a Filme ---");
        System.out.println("Filmes disponíveis:");
        for (int i = 0; i < filmes.size(); i++) {
            System.out.println((i + 1) + ". " + filmes.get(i).getNome());
        }

        System.out.print("Escolha o número do filme: ");
        int indiceFilme = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indiceFilme < 0 || indiceFilme >= filmes.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        Filme filme = filmes.get(indiceFilme);
        List<Ator> atores = pessoaService.listarAtores();

        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
            return;
        }

        System.out.println("\nAtores disponíveis:");
        for (int i = 0; i < atores.size(); i++) {
            System.out.println((i + 1) + ". " + atores.get(i).getNome());
        }

        System.out.println("Digite os números dos atores (separados por vírgula): ");
        String input = scanner.nextLine();
        String[] indices = input.split(",");

        for (String indiceStr : indices) {
            try {
                int indiceAtor = Integer.parseInt(indiceStr.trim()) - 1;
                if (indiceAtor >= 0 && indiceAtor < atores.size()) {
                    filme.adicionarAtor(atores.get(indiceAtor));
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: " + indiceStr);
            }
        }

        System.out.println("Atores associados com sucesso!");
    }

    private void pesquisarFilme() {
        System.out.println("\n--- Pesquisar Filme ---");
        System.out.print("Digite o nome do filme: ");
        String termo = scanner.nextLine();

        List<Filme> resultados = filmeService.pesquisarFilmes(termo);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
        } else {
            System.out.println("\nResultados:");
            resultados.forEach(System.out::println);
        }
    }

    private void listarFilmes() {
        List<Filme> filmes = filmeService.listarFilmes();
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
        } else {
            System.out.println("\n--- Todos os Filmes ---");
            filmes.forEach(System.out::println);
        }
    }

    private void listarAtores() {
        List<Ator> atores = pessoaService.listarAtores();
        if (atores.isEmpty()) {
            System.out.println("❌ Nenhum ator cadastrado.");
        } else {
            System.out.println("\n🎭 --- Todos os Atores ---");
            atores.forEach(System.out::println);
        }
    }

    private void listarDiretores() {
        List<Diretor> diretores = pessoaService.listarDiretores();
        if (diretores.isEmpty()) {
            System.out.println("❌ Nenhum diretor cadastrado.");
        } else {
            System.out.println("\n🎯 --- Todos os Diretores ---");
            diretores.forEach(System.out::println);
        }
    }

    private void exibirEstatisticas() {
        int totalFilmes = filmeService.listarFilmes().size();
        int totalAtores = pessoaService.listarAtores().size();
        int totalDiretores = pessoaService.listarDiretores().size();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║              ESTATÍSTICAS              ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 🎬 Total de Filmes: " + String.format("%-18d", totalFilmes) + "║");
        System.out.println("║ 🎭 Total de Atores: " + String.format("%-18d", totalAtores) + "║");
        System.out.println("║ 🎯 Total de Diretores: " + String.format("%-15d", totalDiretores) + "║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}