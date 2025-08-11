Projeto: IMDB Catalogo
Descrição: Um catálogo de filmes inspirado no IMDB, com funcionalidades de CRUD para filmes, atores, diretores e pessoas.
# Estrutura do Projeto
```
src/
├── main/
│   ├── java/
        ├── br/
        │   └── com/
        │       └── imdbcatalogo/
        │           ├── domain/        # Entidades e classes de modelo (Filme, Ator, Diretor, Pessoa)
        │           ├── repository/    # Persistência e DAOs (FilmeDAO, PessoaDAO, etc.)
        │           ├── service/       # Regras de negócio (FilmeService, PessoaService, etc.)
        │           ├── controller/    # Camada de controle (pode ser CLI, REST, ou GUI)
        │           └── utils/          # Utilitários (conexão com banco, helpers, etc.)
        └── App.java                  # Classe principal para execução do projeto

```