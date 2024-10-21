# O que é?

DTO (Data Transfer Object) é um padrão de projeto usado para transferir dados entre camadas de uma aplicação sem expor diretamente as entidades do modelo de dados. Seu objetivo principal é reduzir o acoplamento entre essas camadas, permitindo que apenas os dados necessários sejam enviados. Ele também melhora a segurança, já que você pode controlar o que está sendo exposto, e melhora a performance, pois evita carregar dados desnecessários.

## Como Funciona

Em vez de passar diretamente entidades do banco de dados (como uma entidade User), você cria um objeto específico (como UserDTO) que contém apenas os dados que serão expostos ou usados. Dessa forma, você separa a lógica de persistência da lógica de apresentação, o que torna a aplicação mais modular.

``` java

public class Produto {    
    private Long id;    
    private String nome;    
    private double preco;    
    private String descricao;    
    private Date dataCadastro;  
      
    // Construtores, Getters e Setters omitidos no código
}
 
public class ProdutoDTO {   
    private String nome;    
    private double preco;    
    private String descricao;   
     
    // Construtires Getters e Setters omitidos no código
}

```

Nesse exemplo, o **ProdutoDTO** não precisa expor todos os campos da entidade **Produto**. Ele apenas transfere as informações necessárias, como nome, preco e descricao. Isso evita, exemplo, que campos sejam exposto desnecessariamente.

O DTO é utilizado também para não precisar retornar parametros desnecessários entre o front e o back, por exemplo para enviar a criação de um usuario sem o DTO.

``` JSON

{    
    "id": 1,    
    "username": "[email protected]",    
    "password": "101010",    
    "role": "ROLE_ADMIN",  
    //Campos desnecessário  
    "dataCriacao": null,     
    "dataModificacao": null,    
    "criadoPor": null,    
    "modificadoPor": null
}

```

Nesse exemplo, temos campos pertencentes a entidade usuario, mas com atributos que serão gerados apenas no banco de dados, então não faz sentido deixar essas variaveis expostas ao front-end.

# Boas Práticas

1. **Usar DTO para a comunicação entre diferentes camadas**: Geralmente, o DTO é utilizado entre a camada de serviços e a camada de apresentação (controller). Isso ajuda a manter as entidades do banco de dados isoladas.

2. **Manter DTOs simples**: Um DTO deve ter apenas os dados que são relevantes para o caso de uso específico. Isso melhora a performance, já que menos dados são transferidos.

3. **Converter entre entidade e DTO**: O mapeamento entre entidade e DTO pode ser feito manualmente ou com bibliotecas como o MapStruct ou ModelMapper.

- Mapeamento Manual

``` java 

public class BookService {

    public BookDTO convertToDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setGenre(book.getGenre());
        return dto;
    }

    public Book convertToEntity(BookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        return book;
    }
}

```

- Mapeamento utilizando a biblioteca ModelMapper.

``` java

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private ModelMapper modelMapper;

    // Converter de entidade para DTO
    public BookDTO convertToDto(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    // Converter de DTO para entidade
    public Book convertToEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }
}

```

# Como incorporar na sua Aplicação

1. **Criar os DTOs para cada caso de uso**: Se você tem diferentes endpoints que exigem diferentes campos de um objeto, crie DTOs específicos para esses endpoints.

2. **Adicionar conversão nas camadas de serviço ou controller**: Centralize a lógica de conversão no service, ou no controller, para que a aplicação fique modular.

3. **Bibliotecas de mapeamento**: Para automatizar a conversão entre entidade e DTO, você pode usar:

- **MapStruct**: Usa anotações para gerar automaticamente o código de conversão.

- **ModelMapper**: Faz a conversão automática com base nas propriedades que coincidem.
