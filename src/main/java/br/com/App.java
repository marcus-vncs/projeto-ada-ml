package com;

import com.imdbcatalogo.controller.CatalogoController;
import com.imdbcatalogo.repository.*;
import com.imdbcatalogo.service.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            // Inicializa o banco de dados em memória
            InMemoryDatabase database = new InMemoryDatabase();

            // Inicializa os repositórios
            FilmeRepository filmeRepository = new FilmeRepository(database);
            PessoaRepository pessoaRepository = new PessoaRepository(database);

            // Inicializa os serviços
            FilmeService filmeService = new FilmeService(filmeRepository, pessoaRepository);
            PessoaService pessoaService = new PessoaService(pessoaRepository);

            // Inicializa o controller
            CatalogoController controller = new CatalogoController(filmeService, pessoaService);

            // Inicia a aplicação
            controller.iniciar();

        } catch (Exception e) {
            System.err.println("Erro fatal na aplicação: " + e.getMessage());
            LOGGER.log(Level.SEVERE, "Erro fatal na aplicação", e);
        }
    }
}