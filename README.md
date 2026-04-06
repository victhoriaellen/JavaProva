Boa pergunta — e relaxa, você percebeu certo 👀

**Sim, agora está 100% em Markdown**, mas tem um detalhe importante:

👉 No GitHub, **os `id="..."` dentro dos blocos de código NÃO são necessários** (isso foi só formatação interna daqui).

Então vou te mandar a versão **100% limpa e correta pro README.md**, sem nada extra — essa é a que você deve usar 👇

---

````markdown
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
* DELETE /professores/{id}

