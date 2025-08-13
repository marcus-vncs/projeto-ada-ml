# Documentação do Projeto projeto-ada-ml

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

## 1. Visão Geral

O **projeto-ada-ml** é um sistema de catálogo de filmes inspirado no IMDB, desenvolvido em Java. O sistema permite o gerenciamento de filmes, atores e diretores através de uma interface de linha de comando, com dados armazenados em memória.

## 2. Arquitetura do Sistema

O projeto segue uma arquitetura em camadas com os seguintes componentes:

### 2.1. Camada de Domínio (Domain Layer)
Contém as entidades principais do sistema:
- **Pessoa**: Classe abstrata com atributos básicos como nome, data de nascimento e nacionalidade
- **Ator**: Estende Pessoa, gerencia filmes em que participou
- **Diretor**: Estende Pessoa, gerencia filmes dirigidos
- **Filme**: Representa um filme com seus atributos e relacionamentos

### 2.2. Camada de Repositório (Repository Layer)
Responsável pelo acesso e persistência dos dados:
- **InMemoryDatabase**: Implementação de banco de dados em memória
- **FilmeRepository**: Gerencia operações CRUD para filmes
- **PessoaRepository**: Gerencia operações CRUD para pessoas (atores e diretores)

### 2.3. Camada de Serviço (Service Layer)
Implementa a lógica de negócio:
- **FilmeService**: Operações de negócio relacionadas a filmes
- **PessoaService**: Operações de negócio relacionadas a pessoas

### 2.4. Camada de Controle (Controller Layer)
Gerencia a interação com o usuário:
- **CatalogoController**: Controla o fluxo da aplicação, exibe menus e processa entradas

### 2.5. Utilitários
Classes auxiliares:
- **DateUtils**: Funções para manipulação de datas

## 3. Funcionalidades do Sistema

O sistema oferece as seguintes funcionalidades principais:

1. **Cadastro e Gestão de Filmes**
   - Cadastrar novos filmes
   - Listar todos os filmes
   - Pesquisar filmes por nome

2. **Cadastro e Gestão de Pessoas**
   - Cadastrar atores
   - Cadastrar diretores
   - Listar atores
   - Listar diretores

3. **Associações**
   - Associar atores a filmes
   - Filmes já são associados a diretores na criação

4. **Estatísticas**
   - Exibir informações estatísticas do sistema

## 4. Estrutura de Classes

### 4.1. Domínio

#### 4.1.1. Pessoa (Abstract)
- Atributos: nome, dataNascimento, nacionalidade
- Métodos: getters, setters, equals, hashCode
- Validações: Não permite valores nulos ou vazios para atributos obrigatórios

#### 4.1.2. Ator
- Estende Pessoa
- Atributos: filmesParticipados (List\<Filme>)
- Métodos: adicionarFilme(), getFilmesParticipados(), toString()

#### 4.1.3. Filme
- Atributos: nome, dataLancamento, orcamento, descricao, diretor, atores
- Métodos: adicionarAtor(), removerAtor(), getters, equals(), hashCode(), toString()
- Validações: Não permite valores nulos para nome, data e diretor; orçamento não pode ser negativo

### 4.2. Repositórios

#### 4.2.1. InMemoryDatabase
- Armazena listas de filmes, atores e diretores
- Métodos para:
  - Salvar, listar e buscar filmes
  - Salvar, listar e buscar atores
  - Salvar, listar e buscar diretores
  - Obter estatísticas e limpar dados

#### 4.2.2. FilmeRepository e PessoaRepository
- Encapsulam a lógica de acesso ao InMemoryDatabase
- Fornecem métodos específicos para operações com filmes e pessoas

### 4.3. Serviços

#### 4.3.1. FilmeService
- Implementa operações de negócio relacionadas a filmes

#### 4.3.2. PessoaService
- Implementa operações de negócio relacionadas a atores e diretores
- Métodos: cadastrarAtor(), cadastrarDiretor(), listarAtores(), listarDiretores()

### 4.4. Controller

#### 4.4.1. CatalogoController
- Gerencia a interface com usuário via linha de comando
- Exibe menus e processa entradas do usuário
- Integra os serviços para executar operações solicitadas

## 5. Fluxo Principal da Aplicação

1. A aplicação inicia na classe `App`
2. Cria uma instância de `InMemoryDatabase`
3. Inicializa repositórios, serviços e controller
4. O controller exibe o menu principal
5. O usuário seleciona opções do menu
6. O controller processa as entradas e executa as operações correspondentes
7. O ciclo continua até o usuário escolher sair

## 6. Interface do Usuário

A interface do usuário é implementada via linha de comando com um design visual aprimorado usando caracteres Unicode para criar bordas e símbolos. O menu principal apresenta opções numeradas para as diversas funcionalidades do sistema.

## 7. Tratamento de Erros

O sistema implementa validações em diversos níveis:
- Validação de entradas do usuário
- Validação de regras de negócio nas entidades
- Tratamento de exceções com mensagens informativas
- Logging para erros severos

---
