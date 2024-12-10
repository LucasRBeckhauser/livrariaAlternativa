# Sistema de Gerenciamento de Livros

Este projeto é um sistema simples de gerenciamento de livros, desenvolvido com Java Spring Boot e Progress OpenEdge, utilizando o PASOE (Progress Application Server for OpenEdge) para a exposição de serviços.

## Descrição

O sistema permite que os usuários realizem operações CRUD (Criar, Ler, Atualizar, Remover) em um catálogo de livros. Os usuários podem adicionar novos livros, visualizar a lista de livros existentes, atualizar informações de livros e remover livros do catálogo.

## Tecnologias Utilizadas

- **Java Spring Boot**: Framework para construção da aplicação web.
- **Progress OpenEdge**: Banco de dados utilizado para armazenar as informações dos livros.
- **PASOE**: Gerenciamento e exposição dos serviços como APIs REST.

## Componentes

### Backend (Java Spring)

- **Controladores**: Controladores REST para gerenciar as operações CRUD dos livros.
- **Serviços**: Lógica de negócios para interagir com o banco de dados.
- **Repositórios**: Utilização do Spring Data para facilitar a comunicação com o banco de dados Progress.

### Banco de Dados (Progress OpenEdge)

- **Tabela de Livros**: Tabela com colunas como `id`, `titulo`, `autor`, `ano_publicacao`, `genero` e `descricao`.
- **Stored Procedures**: Implementação de stored procedures para operações complexas, se necessário.

### Integração com PASOE

- Configuração do PASOE para expor os serviços de backend como APIs REST.
- Utilização do PASOE para gerenciar a segurança e a autenticação dos usuários.

## Fluxo de Trabalho

1. **Adicionar Livro**: O usuário envia uma requisição POST para o endpoint `/livros` com os detalhes do livro.
   - O controlador recebe a requisição e processa a lógica de negócios necessária, como validações.
   - O serviço chama o endpoint REST do PASOE para armazenar os dados do livro.

2. **Listar Livros**: O usuário faz uma requisição GET para o endpoint `/livros` para obter a lista de todos os livros.
   - O controlador recebe a requisição e chama o serviço para buscar os livros.
   - O serviço chama o PASOE para recuperar os dados do banco de dados Progress.

3. **Atualizar Livro**: O usuário envia uma requisição PUT para o endpoint `/livros/{id}` com os novos dados do livro.
   - O controlador processa a requisição e valida os dados.
   - O serviço chama o PASOE para atualizar os dados do livro.

4. **Remover Livro**: O usuário faz uma requisição DELETE para o endpoint `/livros/{id}` para remover um livro específico.
   - O controlador recebe a requisição e chama o serviço para remover o livro.
   - O serviço chama o PASOE para deletar o livro do banco de dados.

5. **Resposta**: O controlador recebe a resposta do PASOE e a envia de volta para o frontend.

