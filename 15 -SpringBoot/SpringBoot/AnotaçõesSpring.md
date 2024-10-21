# Anotações de Configuração

O Spring Boot oferece um conjunto extenso de anotações para facilitar o desenvolvimento de aplicações, divididas em diferentes categorias com base nas funcionalidades que elas ativam ou configuram.

(Core Configurations)[Core-Configuration]

(Stereotype Annotations)[Stereotype-Annotations]

(Web Annotations)[Spring-Web-Annotations]

(Transaction Management)[Transaction-Management]

## Core Configurations

- **@SpringBootApplication**: Marca a classe principal da aplicação Spring Boot. É uma combinação de três anotações:

    - **@Component**: Informa que a classe é uma fonte de definições de beans para o Spring IoC container.

    - **@EnableAutoConfiguration**: Habilita a configuração automática do Spring com base nas dependências presentes.

    - **@ComponentScan**: Habilita a varredura de componentes (Como **@Controller, @Service, etc...**) no pacote base.

- **@Configuration**: Indica que a classe define beans e outras configurações. É uma substituição moderna do xml de configuração do Spring.

- **@EnableAutoConfiguration**: Diz ao Spring Boot para configurar automaticamente a aplicação com base nas dependências do classpath. Usualmente está incluída na **@SpringBootApplication**.

## Stereotype Annotations

- **@Component**:  Define uma classe como um bean gerenciado pelo Spring, tornando-a elegível para ser injetada em outras partes da aplicação

- **@Service**: Uma especialização de **@Component**. Indica que a classe fornece algum serviço, geralmente usado em classes de lógica de negócios.

- **@Repository**: Também uma especialização de **@Component**, usada para marcar classes que acessam diretamente o banco de dados. Facilita o tratamento de exceções relacionadas ao banco.

- **@Autowired**: Permite a injeção automática de dependências. O Spring tenta resolver e injetar o bean correspondente quando você usa essa anotação.

- **@Controller**: Indica que uma classe vai lidar com solicitações HTTP. É uma especialização de @Component, usada em controladores MVC no Spring.

- **@RestController**: Combina @Controller e @ResponseBody. Indica que os métodos da classe retornarão dados diretamente no corpo da resposta (geralmente em formato JSON ou XML), em vez de redirecionar para uma view.

## Spring Web Annotations

- **@RequestMapping**: Define a URL que um método ou classe irá responder. Pode ser aplicada tanto a classes quanto a métodos.

- **@GetMapping, @PostMapping, @PutMapping @DeleteMapping**: São atalhos para @RequestMapping, mas específicos para os métodos HTTP GET, POST, PUT e DELETE, respectivamente.

``` java 

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);
    }
}

```

- **@PathVariable**: Usada para capturar valores de variáveis na URL. É útil para obter parâmetros dinâmicos na rota.

``` java

@GetMapping("/{id}")
public Book getBookById(@PathVariable Long id) {
    return bookService.findById(id);
} 

```

- **@RequestParam**: Usada para capturar parâmetros da query string na URL. É útil para passar dados adicionais nas requisições GET.

``` java

@GetMapping("/search")
public List<Book> searchBooks(@RequestParam String title) {
    return bookService.findByTitle(title);
}

```

- **@RequestBody**:  Indica que o parâmetro do método deve ser vinculado ao corpo da requisição HTTP. É utilizado para deserializar objetos JSON enviados em requisições POST ou PUT.

``` java

@PostMapping
public Book createBook(@RequestBody Book book) {
    return bookService.save(book);
}

```

- **@ResponseBody**:  Indica que o objeto retornado pelo método deve ser serializado diretamente para o corpo da resposta HTTP. Pode ser usado em métodos de controladores para APIs.

- **@ExceptionHandler**: Usada para definir métodos que devem tratar exceções específicas lançadas por métodos do controlador. Permite a manipulação de erros de forma centralizada.

``` java

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFound(BookNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

```

## Transaction Management

- @Transactional: Define que um método ou classe deve ser executado dentro de uma transação.
