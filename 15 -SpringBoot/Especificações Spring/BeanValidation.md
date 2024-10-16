# O que é o Bean Validation

Bean Validation é uma especificação em Java que permite validar dados de objetos (ou "beans"). A ideia é garantir que os dados atendam a certas regras antes de serem usados em uma aplicação. Por exemplo, você pode querer garantir que um campo de e-mail seja realmente um e-mail válido ou que um campo de idade não seja negativo.

## Por que usar?

- Validação Simples: Facilita a validação de dados de forma declarativa, sem a necessidade de escrever lógica de validação manual.

- Separação de Preocupações: Mantém a lógica de validação separada do código de negócio, tornando o código mais limpo e organizado.

- Integração com Frameworks: Funciona bem com frameworks como Spring e Jakarta EE, permitindo validações automáticas em controladores e serviços.

# Principais Anotações

- @NotNull: Verfica se o valor não é nulo.

- @NotBlanck: Verifica se a string não é nula e não está vazia (aplica-se a strings).

- @Size: Verifica o tamanho de uma coleção, array ou string.

- @Min e @Max:  Valida se um número está dentro de um intervalo específico.

- @Email: Verifica se a string é um endereço de e-mail válido.

``` java

public class User {

    @NotBlank(message = "Nome não pode ser vazio")
    private String name;

    @Email(message = "Email inválido")
    private String email;

    @Min(value = 18, message = "Idade deve ser pelo menos 18 anos")
    private int age;

    // Getters e Setters
}

```

- @Valid:  indica que o objeto user deve ser validado antes de ser processado. Se a validação falhar, o Spring lançará uma exceção automaticamente, e você pode tratar essa exceção para retornar mensagens de erro adequadas.

``` java

@RestController
@Validated
public class UserController {

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        // Se a validação falhar, uma exceção será lançada automaticamente
        return new ResponseEntity<>("Usuário criado com sucesso!", HttpStatus.CREATED);
    }
}

```