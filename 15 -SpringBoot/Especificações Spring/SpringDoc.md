# O que é o SpringDoc

O Springdoc é uma biblioteca usada no Spring Boot para gerar automaticamente a documentação da API usando a especificação OpenAPI 3. Ela substitui o antigo Swagger 2 e facilita a geração de documentação interativa para APIs REST, que pode ser acessada em uma interface web.

# Configuração 

Para utilizar o Springdoc, você deve adicionar a dependência no seu arquivo pom.xml (para projetos Maven):

``` XML

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.1.0</version> <!-- Use a versão mais recente -->
</dependency>


```

Você pode personalizar ainda mais a documentação definindo informações globais, como título, descrição, e versionamento, no seu arquivo de propriedades ou via classe de configuração.

``` properties

springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger

```

Após configurar, você pode acessar a documentação da API gerada em:

http://localhost:8080/swagger-ui.html para uma interface interativa.
http://localhost:8080/v3/api-docs para o documento JSON da OpenAPI.

# Anotações Comuns

Para customizar a documentação, você pode usar algumas anotações com seus parametros:

- **@Operation**: Define uma operação específica em um endpoint.

    - summary: Um resumo curto da operação
    - description: uma descrição mais detalhada
    - tags: Grupos ou categorias que ajudam a organizar as operações
    - responses: Define as respostas possiveis com seus códigos e descrições.

``` java

@Operation(
    summary = "Retrieve a book by its ID",
    description = "Returns a single book based on the provided ID",
    tags = {"Books"}
)
@GetMapping("/{id}")
public Book getBookById(@PathVariable String id) {
    // Lógica do método
}

```

- **@Parameter**: Descreve os parâmetros da API, como os de um @PathVariable, @RequestParam, ou @RequestBody. Você pode usar essa anotação para fornecer mais detalhes ou restringir valores permitidos.

    - name: O nome do parâmetro
    - description: Uma explicação do que o parâmetro faz.
    - required: Define se o parâmetro é obrigatório ou não. 
    - example: Um exemplo de valor para o parâmetro

``` java

@GetMapping("/books/{id}")
public Book getBook(
    @Parameter(description = "ID of the book to be retrieved", example = "123", required = true)
    @PathVariable String id) {
    // Lógica do método
}

```

- **@ApiResponse**: Define as respostas que o endpoint pode retornar. É possível associar um código de status HTTP e uma descrição, além de exemplos.

    - responseCode: O código HTTP da resposta.
    - description: Uma descrição da resposta.
    - content: Define o tipo de conteúdo retornado (JSON, XML, etc.) e suas especificações.

``` java

@Operation(summary = "Get a book by ID")
@ApiResponse(responseCode = "200", description = "Book found", content = @Content(mediaType = "application/json"))
@ApiResponse(responseCode = "404", description = "Book not found")
@GetMapping("/books/{id}")
public Book getBookById(@PathVariable String id) {
    // Lógica do método
}

```

- **@RequestBody**: Documenta os dados enviados no corpo da requisição, como em um POST ou PUT. É usado para definir a descrição de objetos passados no corpo da solicitação.

    - description: Uma explicação sobre o conteúdo do corpo da requisição.
    - required: Define se o corpo da requisição é obrigatório.
    - content: Define o tipo de dado esperado (JSON, XML, etc.).

``` java

@Operation(summary = "Create a new book")
@PostMapping("/books")
public Book createBook(
    @RequestBody(description = "Book details", required = true, content = @Content(mediaType = "application/json"))
    Book book) {
    // Lógica para criar o livro
}

```

- **@Schema**: Essa anotação é usada para documentar modelos (ou seja, classes e seus atributos). Ela permite adicionar descrições, exemplos, definir o formato esperado e muito mais.

    - description: Explica o que o campo ou classe representa.
    - example: Define um exemplo de valor.
    - required: Define se o campo é obrigatório.
    - format: Define o formato esperado (como date, uuid, etc.).

``` java

@Schema(description = "Book entity representing a book in the library")
public class Book {
    
    @Schema(description = "The unique ID of the book", example = "123")
    private String id;

    @Schema(description = "The title of the book", example = "Effective Java")
    private String title;

    // getters e setters
}

```

- @Content: Define o tipo de conteúdo de uma resposta ou parâmetro.

    - mediaType: O tipo de mídia da resposta (por exemplo, application/json).
    - schema: Especifica o modelo de dados (geralmente com @Schema).

``` java

@Operation(summary = "Get a book")
@ApiResponse(responseCode = "200", description = "Book found", content = @Content(
    mediaType = "application/json", schema = @Schema(implementation = Book.class)
))
@GetMapping("/books/{id}")
public Book getBookById(@PathVariable String id) {
    // Lógica do método
}

```

- @ArraySchema: Específico para arrays, define como documentar listas de objetos.

    - minItems e maxItems: Define o número mínimo e máximo de itens no array.
    - uniqueItems: Se true, garante que os itens do array sejam únicos.

``` java

@ArraySchema(minItems = 1, uniqueItems = true, arraySchema = @Schema(implementation = Book.class))
public List<Book> getBooks() {
    // Retorna a lista de livros
}


```
## Exemplo

``` java

@RestController
@RequestMapping("/books")
public class BookController {

    @Operation(summary = "Get a book by ID", description = "Returns a book by its unique ID")
    @ApiResponse(responseCode = "200", description = "Book found")
    @ApiResponse(responseCode = "404", description = "Book not found")
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(
        @Parameter(description = "ID of the book") @PathVariable String id) {
        // lógica para retornar o livro
    }
}

```