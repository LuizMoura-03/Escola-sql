# **Projeto: Sistema de Gerenciamento de Alunos** 
Este projeto é uma aplicação simples desenvolvida com Spring Boot e PostgreSQL para gerenciar alunos. Ele foi criado com o objetivo de aprender os conceitos básicos de integração entre Java e bancos de dados relacionais, utilizando o Java 17 e o PostgreSQL como banco de dados.

## Pré-requisitos
Antes de começar, certifique-se de ter os seguintes itens instalados em sua máquina:

* Java 17 ou superior
* Maven (para gerenciar dependências)
* PostgreSQL (banco de dados utilizado no projeto)
* Insomnia ou qualquer ferramenta para testar APIs REST

## Configuração do Banco de Dados
1. **Acesse o terminal do PostgreSQL:
psql -U postgres**

2. **Crie o banco de dados Escola:
CREATE DATABASE Escola;**

3. **Conecte-se ao banco de dados Escola:**

   \c Escola

4. **Crie a tabela alunos:**

CREATE TABLE alunos (
id SERIAL PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
idade INT NOT NULL
);

5. **Insira alguns dados na tabela:**

INSERT INTO alunos (nome, idade) VALUES ('Luiz', 36), ('Pedro', 40);

# Configuração do Projeto
1. **Clone o repositório:**
* git clone <git@github.com:LuizMoura-03/Escola-sql.git>

* cd Escola

2. **Configure o arquivo application.properties (localizado em src/main/resources) com as credenciais do banco de dados:**
* spring.application.name=Escola

 **Configuração do banco de dados**
* spring.datasource.url=jdbc:postgresql://localhost:5432/Escola
* spring.datasource.username=postgres
* spring.datasource.password=

 **Configuração do JPA**
* spring.jpa.hibernate.ddl-auto=update
* spring.jpa.show-sql=true
* spring.jpa.properties.hibernate.format_sql=true
* spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

 **Configuração do servidor**
* server.port=8082

3. **Compile e execute o projeto:**

* mvn spring-boot:run

4. **O servidor será iniciado em http://localhost:8082.**


## Estrutura do Projeto
1. **Classe AlunoModel (Model)**
* Localização: src/main/java/com/sql/Escola/models/AlunoModel.java
   Descrição: Representa a entidade Aluno no sistema. Esta classe é mapeada para a tabela alunos no banco de dados.


* Define os atributos id, nome e idade que correspondem às colunas da tabela alunos.
   Utiliza as anotações @Entity e @Table para mapear a classe para o banco de dados.
   Valida os campos com anotações como @NotBlank, @Min e @Max.

2. **Interface AlunoRepository (Repository)**
* Localização: src/main/java/com/sql/Escola/repositors/AlunoRepository.java
  Descrição: Interface responsável por realizar operações no banco de dados relacionadas à entidade Aluno.
* O que faz:
  Extende a interface JpaRepository, fornecendo métodos prontos para salvar, buscar, atualizar e deletar registros no banco de dados.

3. **Classe AlunoService (Service)**
* Localização: src/main/java/com/sql/Escola/services/AlunoService.java
  Descrição: Contém a lógica de negócios para gerenciar os alunos.
* O que faz:
  Implementa métodos para listar, buscar, salvar, atualizar e deletar alunos.
  Contém a lógica de validação e manipulação dos dados antes de interagir com o repositório.

4. **Classe AlunoController (Controller)**
* Localização: src/main/java/com/sql/Escola/controllers/AlunoController.java
  Descrição: Controlador responsável por expor os endpoints da API REST.
* O que faz:
  Define os endpoints para listar, buscar, salvar, atualizar e deletar alunos.
  Utiliza o serviço AlunoService para realizar as operações.

## Dependências
 **As dependências utilizadas no projeto estão definidas no arquivo pom.xml:**

* Spring Boot Starter Data JPA: Para integração com o banco de dados.
* Spring Boot Starter Validation: Para validação de dados.
* Spring Boot Starter Web: Para criar APIs REST.
* PostgreSQL Driver: Para conectar ao banco de dados PostgreSQL.

## Testando a Aplicação

1. **Após iniciar o servidor, abra o Postman ou qualquer ferramenta de teste de API.**
2. **Teste os seguintes endpoints:**
* Listar todos os alunos: GET http://localhost:8082/alunos
* Buscar aluno por ID: GET http://localhost:8082/alunos/{id}
* Salvar aluno: POST http://localhost:8082/alunos
* Atualizar aluno: PUT http://localhost:8082/alunos/{id}
* Deletar aluno: DELETE http://localhost:8082/alunos/{id}

3. **Faça uma requisição GET para o endpoint: GET http://localhost:8080/alunos**
* Você deverá receber uma resposta semelhante a esta:
[
  {
  "id": 1,
  "nome": "Luiz",
  "idade": 36
  },
  {
  "id": 2,
  "nome": "Jessica",
  "idade": 32
  }
  ]

## Diagrama de classe
![Diagrama da Escola](images/diagrama-escola.png)

