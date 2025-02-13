---

# Web Shopping Service

## Descrição

Este projeto tem como objetivo a criação de um serviço de compras online com uma arquitetura de software robusta, utilizando boas práticas de desenvolvimento para garantir escalabilidade, manutenibilidade e desempenho. O sistema será modular, com ênfase em uma arquitetura limpa e desacoplada.

## Tecnologias Utilizadas

- **Spring Boot** - Framework principal para desenvolvimento back-end.
- **Spring Security** - Para implementação de autenticação e autorização.
- **JPA (Hibernate)** - Para acesso e manipulação de dados no banco de dados.
- **MySQL** - Banco de dados relacional.
- **Docker** - Para containerização e deploy simplificado.
- **JUnit** - Para testes unitários e de integração.
- **Swagger** - Para documentação da API.

## Funcionalidades

- **Cadastro de Usuários**: Permite que os usuários se cadastrem no sistema.
- **Gerenciamento de Produtos**: Adicionar, editar, listar e remover produtos.
- **Carrinho de Compras**: Funcionalidade para adicionar e remover itens do carrinho.
- **Pagamento**: Processamento de pagamento simulado para finalizar compras.
- **Autenticação e Autorização**: Proteção de rotas e dados sensíveis utilizando JWT (JSON Web Tokens).
- **Administração de Pedidos**: Visualização e gerenciamento de pedidos realizados.

## Estrutura do Projeto

- **src/main/java**: Contém o código fonte do sistema.
    - **com.shopping.service**: Pacote principal do serviço.
    - **controller**: Controladores que gerenciam as requisições HTTP.
    - **service**: Lógica de negócios.
    - **model**: Entidades e objetos de domínio.
    - **repository**: Interface de repositório JPA.
    - **config**: Configurações diversas do projeto, como segurança e Swagger.
  
- **src/main/resources**: Contém arquivos de configuração e recursos.
    - **application.properties**: Arquivo de configuração do Spring Boot.
