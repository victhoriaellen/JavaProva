# 📚 API REST com Spring Boot – Avaliação 1

## 📌 Descrição do Projeto
Este projeto consiste no desenvolvimento de uma API REST utilizando o framework **Spring Boot**, com o objetivo de gerenciar dados de **Alunos** e **Professores**.

A aplicação implementa operações do tipo **CRUD (Create, Read, Update e Delete)**, permitindo:
- Cadastro de registros  
- Consulta de dados  
- Atualização de informações  
- Remoção de dados  

O sistema foi estruturado seguindo o padrão de arquitetura em camadas, promovendo organização, reutilização de código e facilidade de manutenção.

---

## 🛠️ Tecnologias Utilizadas

- Java  
- Spring Boot  
- Spring Data JPA  
- Maven  
- Lombok  
- Banco de Dados Relacional  
- Insomnia (testes de API)  
- DBeaver (visualização do banco)  

---

## 🧱 Arquitetura do Projeto

A aplicação segue o padrão de separação em camadas:

### 📂 Model
Responsável por representar as entidades do sistema, correspondentes às tabelas do banco de dados.

### 📂 Repository
Responsável pelo acesso aos dados, utilizando o Spring Data JPA para abstração das operações no banco.

### 📂 Service
Contém as regras de negócio da aplicação, intermediando a comunicação entre Controller e Repository.

### 📂 Controller
Responsável por expor os endpoints da API e gerenciar as requisições HTTP.

## 🔍 Estrutura da Implementação

### 📁 Entidade Aluno

```java
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String email;
    private String cpf;
}
