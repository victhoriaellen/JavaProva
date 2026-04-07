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
Responsável pelo acesso aos dados, utilizando o Spring Data JPA.

### 📂 Service
Contém as regras de negócio da aplicação.

### 📂 Controller
Responsável por expor os endpoints da API.

---

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
````

**Anotações utilizadas:**

* `@Entity` → define a classe como entidade JPA
* `@Table` → define o nome da tabela
* `@Id` → chave primária
* `@GeneratedValue` → geração automática do ID

---

### 📁 Repository

```java
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
```

Principais métodos disponíveis:

* `save()`
* `findAll()`
* `findById()`
* `deleteById()`

---

### 📁 Service

```java
@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public Aluno atualizarAluno(Long id, Aluno alunoAtualizado) {
        Aluno aluno = buscarPorId(id);
        aluno.setNomeCompleto(alunoAtualizado.getNomeCompleto());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setCpf(alunoAtualizado.getCpf());
        return alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}
```

---

### 📁 Controller

```java
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @GetMapping("/{id}")
    public Aluno buscarAluno(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        return alunoService.atualizarAluno(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }
}
```

---

## 👨‍🏫 Entidade Professor

A entidade **Professor** segue a mesma estrutura da entidade Aluno, incluindo:

* Model
* Repository
* Service
* Controller

Alterando apenas nomes de classes e endpoints para `/professores`.

---

## 🔗 Endpoints da API

### 📌 Alunos

* GET /alunos
* POST /alunos
* GET /alunos/{id}
* PUT /alunos/{id}
* DELETE /alunos/{id}

### 📌 Professores

* GET /professores
* POST /professores
* GET /professores/{id}
* PUT /professores/{id}

### Testes no Insomnia
---

### Criar Aluno (POST)
<img width="857" height="664" alt="Captura de tela 2026-04-06 174029" src="https://github.com/user-attachments/assets/c316e0bb-f27f-48d3-8cec-71e13f6d13d9" />

### Listar Alunos (GET)
<img width="727" height="581" alt="image" src="https://github.com/user-attachments/assets/33c13fa9-5588-433b-9175-cb6e36db63bd" />

### Editar Alunos (PUT)
<img width="856" height="745" alt="image" src="https://github.com/user-attachments/assets/3e61eeed-e702-498d-8634-35e76b35dd3c" />

### Buscar Aluno Por ID (GET)
<img width="726" height="269" alt="image" src="https://github.com/user-attachments/assets/53f7b6ff-072d-4fee-a06f-296aa9c83557" />


### Deletar Aluno Por ID (DEL)
<img width="614" height="274" alt="image" src="https://github.com/user-attachments/assets/05991775-1d03-429d-8181-88a840be6854" />


### Criar Professor (POST)
<img width="617" height="280" alt="image" src="https://github.com/user-attachments/assets/b67b6103-f017-41b0-88bc-f61b1b53e5a6" />


###  Listar Professores (GET)
<img width="666" height="314" alt="image" src="https://github.com/user-attachments/assets/0dd63eee-f2ea-4301-86e4-86b528cc87b3" />


### Editar Professores (PUT)
<img width="618" height="250" alt="image" src="https://github.com/user-attachments/assets/54d8b384-5498-4267-940c-12786c4c2a37" />


###  Buscar Professor Por ID (GET)
<img width="687" height="261" alt="image" src="https://github.com/user-attachments/assets/4078a7b6-683e-4518-a2dc-3d8417455720" />


### Deletar Professor Por ID (DEL)
<img width="620" height="231" alt="image" src="https://github.com/user-attachments/assets/cd7565c1-db95-4713-a917-34c8b7dff49c" />


---

### Banco de Dados

### Tabela Aluno
<img width="549" height="292" alt="image" src="https://github.com/user-attachments/assets/0624bf7a-7dfe-430a-9476-75298041363a" />

### Tabela Professor

<img width="550" height="295" alt="image" src="https://github.com/user-attachments/assets/eeba3e4f-28cc-42e8-88ad-b4d7f77ad6f0" />











